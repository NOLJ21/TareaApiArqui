package com.ddg.catrina.service;

import com.ddg.catrina.dto.Dictionary11;
import com.ddg.catrina.dto.WordDto;
import com.ddg.catrina.model.PartOfSpeech;
import com.ddg.catrina.model.Word;
import com.ddg.catrina.repository.PartOfSpeechRepository;
import com.ddg.catrina.repository.WordRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService
{
    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private PartOfSpeechRepository partOfSpeechRepository;

    @Autowired
    private ExternalWordService externalWordService;

    public List<WordDto> getWord(String word)
    {
        if (wordRepository.existsByName(word)){
            throw new RuntimeException("La palabra ya existe en la base de datos");
        }

        List<Dictionary11> data = externalWordService.getWord(word);
        return data.stream().map(this::mapToDto).collect(java.util.stream.Collectors.toList());
    }

    public List<Word> getAllWords()
    {
        List<Word> data = wordRepository.findAll();
        return data.stream().filter(Word::getStatus).collect(java.util.stream.Collectors.toList());
    }

    public WordDto mapToDto(Dictionary11 word)
    {
        WordDto wordDto = new WordDto();
        wordDto.setName(word.getWord());
        wordDto.setDescription(word.getMeanings().get(0).getDefinitions().get(0).getDefinition());
        wordDto.setPartOfSpeech(word.getMeanings().get(0).getPartOfSpeech());

        Word word1 = new Word();
        word1.setName(word.getWord());
        word1.setDescription(word.getMeanings().get(0).getDefinitions().get(0).getDefinition());
        word1.setPartOfSpeech(partOfSpeechRepository.findByName(word.getMeanings().get(0).getPartOfSpeech()));
        word1.setStatus(true);
        wordRepository.save(word1);
        return wordDto;
    }

    public ResponseEntity<?> deleteWord(Long id)
    {
        if (!wordRepository.existsById(id)){
            throw new RuntimeException("La palabra no existe en la base de datos");
        }

        Word word1 = wordRepository.findById1(id);
        word1.setStatus(false);
        wordRepository.save(word1);
        return ResponseEntity.ok().build();
    }

    public List<PartOfSpeech> findAllPartOfSpeech()
    {
        return partOfSpeechRepository.findAll();
    }
}

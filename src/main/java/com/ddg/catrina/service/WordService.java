package com.ddg.catrina.service;

import com.ddg.catrina.dto.Entry;
import com.ddg.catrina.dto.License;
import com.ddg.catrina.dto.Meaning;
import com.ddg.catrina.dto.Phonetic;
import com.ddg.catrina.model.Word;
import com.ddg.catrina.repository.OriginRepository;
import com.ddg.catrina.repository.WordRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.mapping.Any;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService
{
    private WordRepository wordRepository;

    private OriginRepository originRepository;

    private ExternalWordService externalWordService;

    public WordService(WordRepository wordRepository, OriginRepository originRepository, ExternalWordService externalWordService)
    {
        this.wordRepository = wordRepository;
        this.originRepository = originRepository;
        this.externalWordService = externalWordService;
    }

    // obtener el get de la api externa y guardarlo en la base de datos
    // si ya existe en la base de datos, retornar el que ya existe
    // si no existe, crearlo y retornarlo

    public List<Entry> getWord(String word)
    {
        List<Entry> list = externalWordService.getWord(word);

        ObjectMapper mapper = new ObjectMapper();

        Entry entry = mapper.convertValue(list.get(0), Entry.class);

        System.out.println(entry.getWord());

        saveWordDto(entry);
        return list;
    }

    public String saveWordDto(Entry entry)
    {
        Word word = new Word();
        word.setName(entry.getWord());
        word.setDescription(entry.getMeanings().get(0).getDefinitions().get(0).getDefinition());
        word.setExample(entry.getMeanings().get(0).getDefinitions().get(0).getExample());
        word.setOrigin(originRepository.findById(1L).get());
        wordRepository.save(word);
        return "Word saved";
    }




}

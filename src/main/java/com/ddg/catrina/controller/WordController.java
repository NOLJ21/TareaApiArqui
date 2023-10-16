package com.ddg.catrina.controller;

import com.ddg.catrina.dto.Dictionary11;
import com.ddg.catrina.dto.WordDto;
import com.ddg.catrina.model.PartOfSpeech;
import com.ddg.catrina.model.Word;
import com.ddg.catrina.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/word")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class WordController
{
    @Autowired
    private WordService wordService;
    @CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.POST ,allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
    @PostMapping(path = "/{word}")
    public ResponseEntity <List<WordDto>> getWord(@PathVariable String word)
    {
        try {
            List<WordDto> data = wordService.getWord(word);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            log.error("Error al obtener la palabra", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.GET ,allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
    @GetMapping(path = "/all")
    public ResponseEntity <List<Word>> getAllWords()
    {
        try {
            List<Word> data = wordService.getAllWords();
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            log.error("Error al obtener la palabra", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.DELETE ,allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
    @GetMapping(path = "/all/part")
    public ResponseEntity <List<PartOfSpeech>> getAllPartOfSpeech()
    {
        try {
            List<PartOfSpeech> data = wordService.findAllPartOfSpeech();
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            log.error("Error al obtener la palabra", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.DELETE ,allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteWord(@PathVariable Long id)
    {
        try {
            wordService.deleteWord(Long.valueOf(id));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error al eliminar la palabra", e);
            return ResponseEntity.badRequest().build();
        }
    }
}

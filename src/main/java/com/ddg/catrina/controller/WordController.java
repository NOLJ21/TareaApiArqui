package com.ddg.catrina.controller;

import com.ddg.catrina.dto.Entry;
import com.ddg.catrina.service.WordService;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/word")
public class WordController
{
    private WordService wordService;

    @Autowired
    public WordController(WordService wordService)
    {
        this.wordService = wordService;
    }

    @GetMapping(path = "/{word}")
    public ResponseEntity <List<Entry>> getWord(@PathVariable("word") String word)
    {
        return ResponseEntity.ok(wordService.getWord(word));
    }
}

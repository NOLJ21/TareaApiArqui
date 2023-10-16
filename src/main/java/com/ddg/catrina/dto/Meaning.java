package com.ddg.catrina.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.*;
import java.util.List;

@Data
public class Meaning
{
    @lombok.Getter(onMethod_ = {@JsonProperty("partOfSpeech")})
    @lombok.Setter(onMethod_ = {@JsonProperty("partOfSpeech")})
    private String partOfSpeech;
    @lombok.Getter(onMethod_ = {@JsonProperty("definitions")})
    @lombok.Setter(onMethod_ = {@JsonProperty("definitions")})
    private List<Definition> definitions;
    @lombok.Getter(onMethod_ = {@JsonProperty("synonyms")})
    @lombok.Setter(onMethod_ = {@JsonProperty("synonyms")})
    private List<String> synonyms;
    @lombok.Getter(onMethod_ = {@JsonProperty("antonyms")})
    @lombok.Setter(onMethod_ = {@JsonProperty("antonyms")})
    private List<Object> antonyms;
}

package com.ddg.catrina.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.*;
import java.util.List;

@Data
public class Definition
{
    @lombok.Getter(onMethod_ = {@JsonProperty("definition")})
    @lombok.Setter(onMethod_ = {@JsonProperty("definition")})
    private String definition;
    @lombok.Getter(onMethod_ = {@JsonProperty("synonyms")})
    @lombok.Setter(onMethod_ = {@JsonProperty("synonyms")})
    private List<Object> synonyms;
    @lombok.Getter(onMethod_ = {@JsonProperty("antonyms")})
    @lombok.Setter(onMethod_ = {@JsonProperty("antonyms")})
    private List<Object> antonyms;
    @lombok.Getter(onMethod_ = {@JsonProperty("example")})
    @lombok.Setter(onMethod_ = {@JsonProperty("example")})
    private String example;
}

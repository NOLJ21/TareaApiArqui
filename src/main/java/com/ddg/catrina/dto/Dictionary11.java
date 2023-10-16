package com.ddg.catrina.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.List;

@Data
public class Dictionary11
{
    @lombok.Getter(onMethod_ = {@JsonProperty("word")})
    @lombok.Setter(onMethod_ = {@JsonProperty("word")})
    private String word;
//    @lombok.Getter(onMethod_ = {@JsonProperty("phonetic")})
//    @lombok.Setter(onMethod_ = {@JsonProperty("phonetic")})
//    private PhoneticEnum phonetic;
//    @lombok.Getter(onMethod_ = {@JsonProperty("phonetics")})
//    @lombok.Setter(onMethod_ = {@JsonProperty("phonetics")})
//    private List<PhoneticElement> phonetics;
    @lombok.Getter(onMethod_ = {@JsonProperty("meanings")})
    @lombok.Setter(onMethod_ = {@JsonProperty("meanings")})
    private List<Meaning> meanings;
    @lombok.Getter(onMethod_ = {@JsonProperty("license")})
    @lombok.Setter(onMethod_ = {@JsonProperty("license")})
    private License license;
    @lombok.Getter(onMethod_ = {@JsonProperty("sourceUrls")})
    @lombok.Setter(onMethod_ = {@JsonProperty("sourceUrls")})
    private List<String> sourceUrls;
}

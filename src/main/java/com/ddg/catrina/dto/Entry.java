package com.ddg.catrina.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Entry
{
    private String word;
    private List<Phonetic> phonetics;
    private List<Meaning> meanings;
    private License license;
    @JsonProperty("sourceUrls")
    private List<String> sourceUrls;

    public Entry() {}

    public Entry(String word, List<Phonetic> phonetics, List<Meaning> meanings, License license, List<String> sourceUrls)
    {
        this.word = word;
        this.phonetics = phonetics;
        this.meanings = meanings;
        this.license = license;
        this.sourceUrls = sourceUrls;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetic> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetic> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public List<String> getSourceUrls() {
        return sourceUrls;
    }

    public void setSourceUrls(List<String> sourceUrls) {
        this.sourceUrls = sourceUrls;
    }
}

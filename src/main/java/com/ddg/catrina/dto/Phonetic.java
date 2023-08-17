package com.ddg.catrina.dto;

public class Phonetic
{
    private String audio;
    private String text;
    private String sourceUrl;
    private License license;

    public Phonetic() {}

    public Phonetic(String audio, String text, String sourceUrl, License license)
    {
        this.audio = audio;
        this.text = text;
        this.sourceUrl = sourceUrl;
        this.license = license;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}

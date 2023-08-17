package com.ddg.catrina.service;

import com.ddg.catrina.dto.Entry;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalWordService
{
    // llama a esta api https://api.dictionaryapi.dev/api/v2/entries/en/<word>
    // y retorna el json de la respuesta como string

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${miapp.ruta}")
    private String url;

    public ExternalWordService() {}

    public ExternalWordService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public List<Entry> getWord(String word)
    {
        url = url + word;
        return restTemplate.getForObject(url, List.class);
    }
}

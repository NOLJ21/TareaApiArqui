package com.ddg.catrina.service;

import com.ddg.catrina.dto.Dictionary11;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Dictionary;
import java.util.List;

@Service
public class ExternalWordService
{
    // llama a esta api https://api.dictionaryapi.dev/api/v2/entries/en/<word>
    // y retorna el json de la respuesta como string

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${miapp.ruta}")
    private final String url = new String();

    public ExternalWordService() {}

    public ExternalWordService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public List<Dictionary11> getWord(String word)
    {
        String aux = new String();
        aux = url + word;
        Dictionary11[] response = restTemplate.getForObject(aux, Dictionary11[].class);
        return List.of(response);
    }
}

package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users";       //api to be consumed
    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public ResponseEntity<User[]> readAllUsers(){       //returning DTO (accepting array)

        return restTemplate.getForEntity(URI, User[].class);    //getForEntity() gets url, and shows api objects
    }

    @GetMapping("/{id}")                                            //another way of retrieving from api by returning Object
    public Object readUser(@PathVariable("id") Integer id){

        String URL = URI + "/{id}";

        return restTemplate.getForObject(URL, Object.class, id);
    }


    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi(){

//in case, if api has security and is requesting app id: "error": "APP_ID_MISSING"

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id", "6298ebfecd0551211fce37a6");                  //app id

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

    }



}

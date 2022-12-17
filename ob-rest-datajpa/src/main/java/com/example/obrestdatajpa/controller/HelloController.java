package com.example.obrestdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String HolaMundo(){
        return "Hola mundo desde un controller con Java y Spring Boot, Hola postman";
    }

@GetMapping("/bootstrap")
    public  String bootstrap (){
        return "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title>Bootstrap demo</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h1>Hola mundo !</h1>\n" +
                " <a class=\"btn btn-primary\" href=\"https://www.google.com\">Google</a>\n"+
                "  </body>\n" +
                "</html>";
    }
}

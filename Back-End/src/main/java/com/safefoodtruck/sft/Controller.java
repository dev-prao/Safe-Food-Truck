package com.safefoodtruck.sft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String home() {
        return "어? 이게 되네? 당연히 되야지;
    }
}

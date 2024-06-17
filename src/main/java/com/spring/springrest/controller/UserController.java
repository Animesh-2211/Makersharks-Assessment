package com.spring.springrest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springrest.service.NumberService;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/{numberId}")
    public Map<String, Object> getNumbers(@PathVariable String numberId) {
        return numberService.getNumbers(numberId);
    }
}

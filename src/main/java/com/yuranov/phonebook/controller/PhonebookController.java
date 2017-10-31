/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuranov.phonebook.controller;

import com.yuranov.phonebook.models.PhoneRecord;
import com.yuranov.phonebook.service.IPhonebookService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mihail
 */
@RestController
public class PhonebookController {
    @Autowired
    private IPhonebookService service;
    
     @GetMapping("/find")
    public List find(@RequestBody PhoneRecord phoneRecord) {
        return service.findByParams(phoneRecord);
    }
    
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody PhoneRecord phoneRecord) {
        service.addRecord(phoneRecord);
    }
    
    @GetMapping("/new")
    public List req() {
        return Arrays.asList("1", "2", "3");
    }
}

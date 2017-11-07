/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuranov.phonebook.controller;

import com.yuranov.phonebook.models.PhoneRecord;
import com.yuranov.phonebook.service.IPhonebookService;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RestController()
public class PhonebookController {
    @Autowired
    private IPhonebookService service;
    
     @GetMapping("/find")
    public List find(@RequestBody PhoneRecord phoneRecord) {
        return service.findByParams(phoneRecord);
    }
    
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Map add(@RequestBody PhoneRecord phoneRecord) {
        phoneRecord = service.addRecord(phoneRecord);
        if(phoneRecord.getId() != null) {
            return Collections.singletonMap("id", phoneRecord.getId());
        }
        return Collections.singletonMap("error", new ResponseEntity<String>
            ("Error creating record", HttpStatus.BAD_REQUEST));
    }
    
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        service.deleteRecord(id);
    }
 }

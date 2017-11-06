/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuranov.phonebook.service;

import com.yuranov.phonebook.models.PhoneRecord;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author mihail
 */
@Component
@Service("iPhonebookService")
public class PhonebookService implements IPhonebookService {

    @Autowired
    IPhonebookDataSource dataSource;
 
    public void addRecord(PhoneRecord phoneRecord) {
        dataSource.persist(phoneRecord);
    }

    public void deleteRecord(Integer recordId) {
        dataSource.deleteById(recordId);
    }

    public List findByParams(PhoneRecord phoneRecord) {
        return dataSource.findByParams(phoneRecord);
    }
    
}

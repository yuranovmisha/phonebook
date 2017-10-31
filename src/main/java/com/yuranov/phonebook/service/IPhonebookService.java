/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuranov.phonebook.service;

import com.yuranov.phonebook.models.PhoneRecord;
import java.util.List;

/**
 *
 * @author mihail
 */
public interface IPhonebookService {
    List findByParams(PhoneRecord phoneRecord);
    void addRecord(PhoneRecord phoneRecord);
    void deleteRecord(Integer recordId);
}

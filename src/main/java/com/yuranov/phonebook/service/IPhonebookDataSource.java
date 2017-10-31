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
public interface IPhonebookDataSource {
    void persist(PhoneRecord phoneRecord);
    List<PhoneRecord> findByParams(PhoneRecord phoneRecord);
    void deleteById(Integer id);
}

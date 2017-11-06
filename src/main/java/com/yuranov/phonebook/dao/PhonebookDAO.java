/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuranov.phonebook.dao;

import com.yuranov.phonebook.models.PhoneRecord;
import com.yuranov.phonebook.service.IPhonebookDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author mihail
 */
@Component
public class PhonebookDAO implements IPhonebookDataSource {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public void persist(PhoneRecord phoneRecord) {
        entityManager.persist(phoneRecord);
    }
    
    @Override
    @Transactional
    public List<PhoneRecord> findByParams(PhoneRecord phoneRecord) {
        Query query = selectQuery(phoneRecord);
        return query.getResultList();
        
    }
    
    @Override
    @Transactional
    public void deleteById(Integer id) {
        Query query = entityManager.createQuery("delete from phonerecord p where id=?1");
        query.setParameter(1, id);
        query.executeUpdate();
    }
    
    private boolean checkWhere(boolean hasWhere, StringBuilder stringBuilder) {
        if(hasWhere) {
            stringBuilder.append(" and ");
        } else {
            stringBuilder.append(" where ");
        }
        return true;
    }
    
    private boolean checkField(Object field) {
        return field != null && !field.equals("");
    }
    
    private Query selectQuery(PhoneRecord phoneRecord) {
        List parameters = new ArrayList();
        StringBuilder stringBuilder = 
                new StringBuilder("select p from PhoneRecord p ");
        boolean hasWhere = false;
        int parameterIndex = 1;
        if(checkField(phoneRecord.getName())) {
            hasWhere = checkWhere(hasWhere, stringBuilder);
            stringBuilder.append("name=?" + String.valueOf(parameterIndex++));
            parameters.add(phoneRecord.getName());
            hasWhere = true;
        }
        if(checkField(phoneRecord.getSurname())) {
            hasWhere = checkWhere(hasWhere, stringBuilder);
            stringBuilder.append("surname=?" + String.valueOf(parameterIndex++));
            parameters.add(phoneRecord.getSurname());
        }
        if(checkField(phoneRecord.getFamily())) {
            hasWhere = checkWhere(hasWhere, stringBuilder);
            stringBuilder.append("family=?" + String.valueOf(parameterIndex++));
            parameters.add(phoneRecord.getFamily());
        }
        if(checkField(phoneRecord.getAddress())) {
            hasWhere = checkWhere(hasWhere, stringBuilder);
            stringBuilder.append("address=?" + String.valueOf(parameterIndex++));
            parameters.add(phoneRecord.getAddress());
        }
        if(checkField(phoneRecord.getPhoneNumber())) {
            hasWhere = checkWhere(hasWhere, stringBuilder);
            stringBuilder.append("phonenumber=?" + String.valueOf(parameterIndex++));
            parameters.add(phoneRecord.getPhoneNumber());
        }
        Query query = entityManager.createQuery(stringBuilder.toString());
        int index = 1;
        for(Object parameter: parameters) {
            query.setParameter(index, parameter);
            index++;
        }
        return query;
    }
}

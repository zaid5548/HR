package com.nagarro.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.entities.UserEntity;

@Component
public class UserDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    @Transactional
    public void saveUser(UserEntity user) {
        this.hibernateTemplate.saveOrUpdate(user);
    }
    
    public UserEntity getUser(String username) {
        
        UserEntity user=hibernateTemplate.get(UserEntity.class, username);
        return user;
        
    }

}

package com.xxx.jpa.user_defined;

import com.xxx.jpa.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User someCustomerMethodFindById(Integer oid) {
        return entityManager.find(User.class,oid);
    }
}

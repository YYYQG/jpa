package com.xxx.jpa;

import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;
import java.util.Date;

public final class SpecificationFactory {


    /*
    模糊查询
     */
    public static Specification containsLike(String attribute,String value){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get(attribute),"%"+value+"%"));
    }

    /*
    等于
     */
    public static Specification equal(String attribute,String value ){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(attribute),value));
    }
    /*
    获取对应属性的值所在区间
     */
    public static Specification isBetween(String attribute,double min,double max){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get(attribute),min,max));
    }
    public static Specification isBetween(String attribute,int min,int max){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get(attribute),min,max));
    }
    public static Specification isBetween(String attribute, Date min, Date max){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get(attribute),min,max));
    }

    /*
    通过属性名和集合实现in查询
     */
    public static Specification in(String attribute, Collection c){
        return ((root, criteriaQuery, criteriaBuilder) -> root.get(attribute).in(c));
    }

    /*
    通过属性名构建大于等于value的查询条件...
     */




}

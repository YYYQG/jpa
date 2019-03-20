package com.xxx.jpa;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Integer>,JpaSpecificationExecutor<Tag> {

    @EntityGraph(value = "blogs")
    List<Tag> findAll();

    @EntityGraph(value = "blogs")
    List<Tag> findAll(@Nullable Specification<Tag> var1);
}

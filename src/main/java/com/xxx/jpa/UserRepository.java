package com.xxx.jpa;

import com.xxx.jpa.user_defined.UserRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>, UserRepositoryCustom {

    List<Name> findAllByName(String name);

}

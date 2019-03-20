package com.xxx.jpa;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@Slf4j
public class JpaApplication {

    @Autowired
    UserRepository repository;

    @Autowired
    BlogRepository blogRespository;

    @Autowired
    TagRepository tagRepository;

    @RequestMapping("/index")
    public User to (){
        List list = repository.findAll();
        return  (User)list.get(0);
    }
    @RequestMapping("/findByName")
    public List<Name> findByName (){
        List<Name> list = repository.findAllByName("YQG");
        return  list;
    }

    @RequestMapping("/findBlog")
    public List<Blog> findBlog (){
        List<Blog> list = blogRespository.findAll();
        return  list;
    }

    @RequestMapping("/findTag")
    public List<Tag> findTag (){
        List<Tag> list = tagRepository.findAll();
        return  list;
    }
    @RequestMapping("/findTagByExample")
    public List<Tag> findTagByExample (){

        Tag tag = new Tag();
        tag.setId(1);
       /* ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.storeDefaultMatching());*/
        Example<Tag> example = Example.of(tag);
        List<Tag> list = tagRepository.findAll(example);
        log.info(tag.toString());
        return  list;
    }
    @RequestMapping("/findTagByExample1")
    public List<Tag> findTagByExample1 (){

        Tag tag = new Tag();
        tag.setName("ja");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Tag> example = Example.of(tag,matcher);
        List<Tag> list = tagRepository.findAll(example);
        log.info(tag.toString());
        return  list;
    }

    @RequestMapping("/findTagBySpecification")
    public List<Tag> findTagBySpecification(){
        Tag tag = new Tag();
        tag.setName("a");
        return tagRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.isNotBlank(tag.getName())){
                predicates.add(criteriaBuilder.like(root.get("name"),"%"+tag.getName()+"%"));
            }
            return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        });
    }

    @RequestMapping("/findUserBydefined")
    public User findUserBydefined (){
        User user = repository.someCustomerMethodFindById(14);
        return  user;
    }


    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("2018-02-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDate.toString());
        SpringApplication.run(JpaApplication.class, args);
        Optional<String> s = Stream.of(new String[]{"10", "20","30"}).parallel()
                .sorted(Comparator.comparing((x)->{
                    return Integer.parseInt((String)x);
                }).reversed())
                .findFirst();
        System.out.println(s.get());
    }

}

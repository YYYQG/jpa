package com.xxx.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "tag")
@NamedEntityGraph(name = "blogs",attributeNodes = {@NamedAttributeNode("blogs")})
public class Tag {


    @Id
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs;
}

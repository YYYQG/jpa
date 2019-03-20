package com.xxx.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @Column(name = "id")
    private Integer id;

    private String name;

    @JsonIgnore
    @JoinTable(name = "blog_tag_relation",joinColumns = @JoinColumn(name = "blog_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id"))
    @ManyToMany
    private List<Tag> tags;
}

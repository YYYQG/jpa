package com.xxx.jpa;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "blog_tag_relation")
public class BlogTagRelation implements Serializable {

    @Id
    @Column(name = "blog_id")
    private Integer blogId;
    @Id
    @Column(name = "tag_id")
    private Integer tagId;

}

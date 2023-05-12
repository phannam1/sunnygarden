package com.Sunnygarden.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "service")
public class ServiceEntity {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;
    @Column(name = "title")
    private String title;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "createdate")
    private String createDate;
    @Column(name = "subdecription")
    private String subDescription;



}

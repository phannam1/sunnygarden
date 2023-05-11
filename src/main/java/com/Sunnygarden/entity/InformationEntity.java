package com.Sunnygarden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "information")
public class InformationEntity {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "link")
    private String link;
    @Column(name = "icon")
    private String icon;
}

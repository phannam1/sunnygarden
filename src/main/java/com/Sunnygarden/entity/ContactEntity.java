package com.Sunnygarden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contact")
public class ContactEntity {

	@javax.persistence.Id
	@GeneratedValue
	private Long Id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "phone",length = 12)
	private String phone;
	@Column(name = "content",length = 1000)
	private String content;
	@Column(name = "createdate")
	private String createDate;

}

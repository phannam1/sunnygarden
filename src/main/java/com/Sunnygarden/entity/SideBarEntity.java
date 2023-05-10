package com.Sunnygarden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SideBarEntity {

	@javax.persistence.Id
	@GeneratedValue
	private Long Id;
	@Column(name = "name")
	private String sideBarName;
	@Column(name = "icon")
	private String icon;
	@Column(name = "route")
	private String route;
	@Column(name = "status")
	private boolean status;
	@Column(name = "role")
	private Long roleId;
}

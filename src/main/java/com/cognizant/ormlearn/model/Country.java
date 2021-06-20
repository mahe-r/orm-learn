package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Table(name = "country")
@Getter 
@Setter
@ToString
public class Country {

	@Id
	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;
	
	
}

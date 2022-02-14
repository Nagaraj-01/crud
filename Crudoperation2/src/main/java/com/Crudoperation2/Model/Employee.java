package com.Crudoperation2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name ="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name ="FirstName")
	private String FirstName;
	@Column(name ="LastName")
	private String LastName;
	@Column(name ="Email")
	private String Email;
	

}

package com.assignment1.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int SLno;
	@Column(name="Student_Name")
	private String Student_Name;
	@Column(name="Student_Class")
	private String Student_Class;
	@Column(name="Shool_Name")
	private String School_Name;

}

package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private static int  studentId;
	@Column(name="first_name")
	private static String  firstName;
	@Column(name="last_name")
	private static String  lastName;
	

}

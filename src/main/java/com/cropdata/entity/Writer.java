package com.cropdata.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Writer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer wId;

	private String name;

//	@OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
//	private List<Course> courses;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	private Integer cId;
}

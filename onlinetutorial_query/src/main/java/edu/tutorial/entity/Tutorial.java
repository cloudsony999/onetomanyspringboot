package edu.tutorial.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutorials")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	private int level;// 1=CHILDREN 2=ADULT 3=SENIOR
	private boolean published;
	@Temporal(TemporalType.DATE)
	private Date createdAt;

}

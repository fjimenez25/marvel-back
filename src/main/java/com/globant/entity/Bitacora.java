package com.globant.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Bitacora {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
		
	@Column
	private String serviceName;
	
	@Column
	private Date date;
	
	
}

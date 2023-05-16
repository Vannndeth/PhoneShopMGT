package com.vanndeth.phoneshopmgt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "tbbrands")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "brand_id")
	private Integer id;
	
	@Column(name = "brand_name")
	private String name;

	
}

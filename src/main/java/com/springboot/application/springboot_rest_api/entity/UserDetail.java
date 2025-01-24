package com.springboot.application.springboot_rest_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="USERDETAIL")
public class UserDetail {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public Long id;
	@Column(name="name",nullable = false,unique = true)
	public String name;
	@Column(name="country")
	public String country;
	@Column(name="postcode")
	public String postcode;

}

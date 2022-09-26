package com.example.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_ID")
	private int customerId;

	@Column(name = "FIRST_NAME", unique = true)
	@NotNull(message = "first name should not be null")
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotNull(message = "last name should not be null")
	private String lastName;

	@Column(name = "PHONE_NUMBER")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "phone number should be ten digits")
	@NotNull(message = "phoneNumber should not be null")
	private String phoneNumber;

	@Column(name = "ADDRESS")
	private String address;
}

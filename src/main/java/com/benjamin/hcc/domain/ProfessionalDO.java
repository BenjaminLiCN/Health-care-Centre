package com.benjamin.hcc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.benjamin.hcc.core.BaseDO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "professional_info")
public class ProfessionalDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Override
	public String toString() {
		return "ProfessionalDO [id=" + id + ", type=" + type + ", name=" + name + ", email=" + email + ", number="
				+ number + ", charge=" + charge + ", bookingDOs=" + bookingDOs + ", availableTimeDOs="
				+ availableTimeDOs + "]";
	}

	public ProfessionalDO() {
	}

	@Column(name = "type", length = 20)
	private String type;

	@Column(name = "name", length = 40)
	private String name;

	@Column(name = "email", length = 40)
	private String email;

	@Column(name = "number", length = 15)
	private String number;

	@Column(name = "charge", length = 20)
	private String charge;

	@JsonIgnore
	@OneToMany(mappedBy = "professionalDO", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<BookingDO> bookingDOs = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "professionalDO", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AvailableTimeDO> availableTimeDOs = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public Set<BookingDO> getBookingDOs() {
		return bookingDOs;
	}

	public void setBookingDOs(Set<BookingDO> bookingDOs) {
		this.bookingDOs = bookingDOs;
	}

	public Set<AvailableTimeDO> getAvailableTimeDOs() {
		return availableTimeDOs;
	}

	public void setAvailableTimeDOs(Set<AvailableTimeDO> availableTimeDOs) {
		this.availableTimeDOs = availableTimeDOs;
	}

}

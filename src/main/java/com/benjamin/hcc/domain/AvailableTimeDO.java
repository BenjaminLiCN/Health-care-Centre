package com.benjamin.hcc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Availabletime_info")
public class AvailableTimeDO{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professional_id")
    private ProfessionalDO professionalDO;
    
    
    public AvailableTimeDO() {
		super();
		this.isBooked = 0;
	}

	// e.g. 2019-4-10
    @Column(name = "schedule_date")
    private String scheduleDate;

    // 12:15  == 12.25
    @Column(name = "period_start")
    private int periodStart;

    @Column(name = "period_end")
	private int periodEnd;
	
	@Column(name = "is_booked")
	private int isBooked;

	public int getIsBooked(){
		return isBooked;
	}

	public void setIsBooked(int isBooked){
		this.isBooked = isBooked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProfessionalDO getProfessionalDO() {
		return professionalDO;
	}

	public void setProfessionalDO(ProfessionalDO professionalDO) {
		this.professionalDO = professionalDO;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public int getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(int periodStart) {
		this.periodStart = periodStart;
	}

	public int getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(int periodEnd) {
		this.periodEnd = periodEnd;
	}

	@Override
	public String toString() {
		return "AvailableTimeDO [id=" + id + ", professionalDO=" + professionalDO + ", scheduleDate=" + scheduleDate
				+ ", periodStart=" + periodStart + ", periodEnd=" + periodEnd + "]";
	}

    

    

}
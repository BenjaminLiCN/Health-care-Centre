package com.benjamin.hcc.domain;

import com.benjamin.hcc.core.BaseDO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.util.Date;

@Entity(name = "booking_info")
public class BookingDO{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professional_id")
    private ProfessionalDO professionalDO;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
	private UserDO userDO;
	
	public BookingDO(){
		this.isConfirmed = 0;
		this.isCancelled = 0;
	}

    public BookingDO(ProfessionalDO professionalDO, UserDO userDO) {
		this.professionalDO = professionalDO;
		this.userDO = userDO;
		this.isConfirmed = 0;
		this.isCancelled = 0;
	}

	// e.g. 2019-4-10
    @Column(name = "schedule_date")
    private String scheduleDate;

    // 12:15  == 12.25
    @Column(name = "schedule_start")
    private int start;

    @Column(name = "schedule_end")
    private int end;


    @Column(name = "description" , length =  200)
    private String description;

    @Column(name = "is_confirmed" , length =  2)
    private int isConfirmed;


    @Column(name = "is_cancelled" , length =  2)
    private int isCancelled;


   
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

	public UserDO getUserDO() {
		return userDO;
	}

	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(int isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public int getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(int isCancelled) {
		this.isCancelled = isCancelled;
	}

	@Override
	public String toString() {
		return "BookingDO [id=" + id + ", professionalDO=" + professionalDO + ", userDO=" + userDO + ", scheduleDate="
				+ scheduleDate + ", start=" + start + ", end=" + end + ", description=" + description + ", isConfirmed="
				+ isConfirmed + ", isCancelled=" + isCancelled + "]";
	}
    
    


}
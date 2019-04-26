package com.benjamin.hcc.dto;

import com.benjamin.hcc.core.BaseDTO;

import java.util.Date;

/**
 * @Auther Benjamin(Jingyi Li) Li
 * @Email jili@student.unimelb.edu.au
 * @ID 961543
 * @Date 2019-04-22 18:05
 */
public class BookingDTO extends BaseDTO {

    private String professional;
    private Date time;
    private String duration;
    private String message;
    private int confirm;

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "professional='" + professional + '\'' +
                ", time=" + time +
                ", duration='" + duration + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

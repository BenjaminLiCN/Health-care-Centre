package com.benjamin.hcc.domain;

import com.benjamin.hcc.core.BaseDO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther Benjamin Li li.benjamincn@gmail.com
 * @id 961543
 * @date 2018/9/28下午12:53
 */
@Entity(name = "booking_info")
public class BookingDO extends BaseDO {
    @Id
    @GeneratedValue
    private String id;

    @Column(name = "professional",length = 40)
    private String professional;

    @Column(name = "time" , length = 20)
    private Date time;

    @Column(name = "duration" , nullable = true , length = 5)
    private int duration;

    @Column(name = "available_id" , length =  5)
    private int available_id;

    @Column(name = "message" , length =  200)
    private String message;

    @Column(name = "confirm" , length =  200)
    private int confirm;

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "BookingDO{" +
                "id=" + id +
                ", professional='" + professional + '\'' +
                ", time=" + time +
                ", duration=" + duration +
                ", available_id=" + available_id +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAvailable_id() {
        return available_id;
    }

    public void setAvailable_id(int available_id) {
        this.available_id = available_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
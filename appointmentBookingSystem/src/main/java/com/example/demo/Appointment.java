package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity 
@Table(name = "appointment")
public class Appointment {
	
	private static final long serialVersionUID = -4439114469417994311L;
	private Long appointmentId;
    private String customerName;
    private long customerId;
    private String appointmentDateTime;
    
    public Appointment() {

    }

    public Appointment(String n, long i, String dt) {
        this.customerName = n;
        this.customerId = i;
        this.appointmentDateTime = dt;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return appointmentId;
    }
    public void setId(long id) {
        this.appointmentId = id;
    }

    @Column(name = "customer_name", nullable = false)
    public String getName() {
        return customerName;
    }
    public void setName(String name) {
        this.customerName = name;
    }

    @Column(name = "customer_id", nullable = false)
    public long getCid() {
        return customerId;
    }
    public void setCid(long cid) {
        this.customerId = cid;
    }

    @Column(name = "date_time", nullable = false)
    public String getDateTime() {
        return appointmentDateTime;
    }
    public void setDateTime(String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
}

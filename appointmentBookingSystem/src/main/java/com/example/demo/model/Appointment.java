package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.io.Serializable;


@Entity
@Data
@Table(name = "appointment")
public class Appointment implements Serializable {
	
	private static final long serialVersionUID = -4439114469417994311L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;
    
    @Column(name = "customer_name", nullable = false)
    private String customerName;
    
    @Column(name = "customer_id", nullable = false)
    private long customerId;
    
    @Column(name = "date_time", nullable = false)
    private String appointmentDateTime;
    
    public Appointment() {

    }

    public Appointment(String n, long i, String dt) {
        this.customerName = n;
        this.customerId = i;
        this.appointmentDateTime = dt;
    }
    
}

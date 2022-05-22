package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
}

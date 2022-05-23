package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl {//implements AppointmentService {

    @Autowired
    private AppointmentRepository ar;

//    @Override
    public Appointment create(@Valid @RequestBody Appointment ap) {
		return ar.save(ap);
	}

//    @Override
    @CachePut(value="Appointment", key="#appointmentId")
    public ResponseEntity <Appointment> update(@PathVariable(value = "appointmentId") Long id,
	        @Valid @RequestBody Appointment appointmentDetails) throws ResourceNotFoundException {
	        Appointment ap = ar.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + id));
	        ap.setAppointmentDateTime(appointmentDetails.getAppointmentDateTime());
	        ap.setCustomerName(appointmentDetails.getCustomerName());
	        ap.setCustomerId(appointmentDetails.getCustomerId());
	        final Appointment updatedAppointment = ar.save(ap);
	        return ResponseEntity.ok(updatedAppointment);
    }

//    @Override
    @CacheEvict(value="Appointment", key="#appointmentId")
    // @CacheEvict(value="Invoice", allEntries=true) //in case there are multiple entires to delete
    public Map < String, Boolean > delete(@PathVariable(value = "appointmentId") Long id,
	        @Valid @RequestBody Appointment appointmentDetails) throws ResourceNotFoundException {
	        Appointment ap = ar.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + id));
	        
	        ar.delete(ap);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	}

//    @Override
    @Cacheable(value="Appointment")
    public List < Appointment > read(@PathVariable(value = "appointmentId") Long id){
		return ar.findAll();
	}
}
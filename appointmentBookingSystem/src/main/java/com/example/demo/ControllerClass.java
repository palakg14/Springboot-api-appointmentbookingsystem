package com.example.demo;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book_appointment")
public class ControllerClass {
	@Autowired
	private AppointmentServiceImpl as;
	
	@PostMapping("/create")
	public Appointment create(@Valid @RequestBody Appointment ap) {
		return as.create(ap);
	}
	
	@GetMapping("/read")
	public List < Appointment > read(@PathVariable(value = "appointmentId") Long id){
		return as.read(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity <Appointment> update(@PathVariable(value = "appointmentId") Long id,
	        @Valid @RequestBody Appointment appointmentDetails) throws ResourceNotFoundException {
//	        Appointment ap = ar.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + id));
////			Appointment ap = ar.findById(id);
//	        ap.setDateTime(appointmentDetails.getDateTime());
//	        ap.setName(appointmentDetails.getName());
//	        ap.setCid(appointmentDetails.getCid());
//	        final Appointment updatedAppointment = ar.save(ap);
//	        return ResponseEntity.ok(updatedAppointment);
		return as.update(id, appointmentDetails);
	}
	
	@DeleteMapping("/delete")
	public Map < String, Boolean > delete(@PathVariable(value = "appointmentId") Long id,
	        @Valid @RequestBody Appointment appointmentDetails) throws ResourceNotFoundException {
//	        Appointment ap = ar.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + id));
//	        
//	        ar.delete(ap);
//	        Map < String, Boolean > response = new HashMap < > ();
//	        response.put("deleted", Boolean.TRUE);
//	        return response;
		return as.delete(id, appointmentDetails);
	}	

//    @PostMapping("/saveInv")
//    public Invoice saveInvoice(@RequestBody Invoice inv) {
//       return invoiceService.saveInvoice(inv);
//    }
//
//    @GetMapping("/allInv") 
//    public ResponseEntity<List<Invoice>> getAllInvoices(){
//       
//    }
//
//    @PutMapping("/modify/{id}")
//    public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer id) {
//       return invoiceService.updateInvoice(inv, id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteInvoice(@PathVariable Integer id) {
//       invoiceService.deleteInvoice(id);
//       return "Employee with id: "+id+ " Deleted !";
//    }
}

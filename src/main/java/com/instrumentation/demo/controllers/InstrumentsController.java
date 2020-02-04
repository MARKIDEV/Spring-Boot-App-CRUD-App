package com.instrumentation.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instrumentation.demo.models.Instrument;
import com.instrumentation.demo.repositories.InstrumentRepository;

@RestController
@RequestMapping("/api/v1/instruments")
public class InstrumentsController {
	@Autowired
	private InstrumentRepository instrumentRepository;
	@GetMapping
	public List<Instrument> list() {
		
		return instrumentRepository.findAll();
	}
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Instrument> findById(@PathVariable long id){
	  return instrumentRepository.findById(id)
	          .map(record -> ResponseEntity.ok().body(record))
	          .orElse(ResponseEntity.notFound().build());
	}
	@PostMapping (path = {"/add"})
	public Instrument create(@RequestBody Instrument instrument){
	    return instrumentRepository.save(instrument);
	    
	}
	@PutMapping(path="/{id}")
	  public ResponseEntity<Instrument> update(@PathVariable("id") long id,
	                                        @RequestBody Instrument instrument){
	    return instrumentRepository.findById(id)
	        .map(record -> {
	            record.setBuyerName(instrument.getBuyerName());
	            record.setEmail(instrument.getEmail());
	            record.setInstrumentModel(instrument.getInstrumentModel());
	            record.setSerialNumber(instrument.getSerialNumber());
	            record.setPurchaseDate(instrument.getPurchaseDate());
	           Instrument updated = instrumentRepository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
	@DeleteMapping(path ={"/{id}"})
	  public ResponseEntity<?> delete(@PathVariable("id") long id) {
	    return instrumentRepository.findById(id)
	        .map(record -> {
	        	instrumentRepository.deleteById(id);
	            return ResponseEntity.ok().build();
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
}

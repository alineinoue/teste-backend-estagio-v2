package aline.testebackend.resources;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aline.testebackend.domain.Equipment_model_state_hourly_earnings;
import aline.testebackend.service.Equipment_model_state_hourly_earningsService;

@RestController
public class Equipment_model_state_hourly_earningsController {

	@Autowired
	private Equipment_model_state_hourly_earningsService service;
	
	@GetMapping("/equipments/hourly_earnings")
	public List<Equipment_model_state_hourly_earnings> list(){
		return service.listAll();
	}
	
	@GetMapping("/equipments/hourly_earnings/{id}")
	public ResponseEntity<Equipment_model_state_hourly_earnings> get(@PathVariable Integer id) {
		try {
			Equipment_model_state_hourly_earnings equipment = service.get(id);
			return new ResponseEntity<Equipment_model_state_hourly_earnings>(equipment, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Equipment_model_state_hourly_earnings>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/equipments/hourly_earnings")
	public void add(@RequestBody Equipment_model_state_hourly_earnings equipment) {
		service.save(equipment);
	}
	
	@PutMapping("/equipments/hourly_earnings/{id}")
	public ResponseEntity<?> update(@RequestBody Equipment_model_state_hourly_earnings equipment, @PathVariable Integer id) {
		try {
			Equipment_model_state_hourly_earnings existEquipment = service.get(id);
			service.save(equipment);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/equipments/hourly_earnings/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}

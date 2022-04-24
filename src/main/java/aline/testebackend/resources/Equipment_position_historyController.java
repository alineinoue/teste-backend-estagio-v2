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

import aline.testebackend.domain.Equipment_position_history;
import aline.testebackend.domain.Equipment_state_history;
import aline.testebackend.service.Equipment_position_historyService;

@RestController
public class Equipment_position_historyController {

	@Autowired
	private Equipment_position_historyService service;
	
	@GetMapping("/equipments/position_history")
	public ResponseEntity<List<Equipment_position_history>> findByOrderByDateDesc(){
		List<Equipment_position_history> result = service.findByOrderByDateDesc();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/equipments/position_history/{id}")
	public ResponseEntity<Equipment_position_history> get(@PathVariable Integer id) {
		try {
			Equipment_position_history equipment = service.get(id);
			return new ResponseEntity<Equipment_position_history>(equipment, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Equipment_position_history>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/equipments/position_history")
	public void add(@RequestBody Equipment_position_history equipment) {
		service.save(equipment);
	}
	
	@PutMapping("/equipments/position_history/{id}")
	public ResponseEntity<?> update(@RequestBody Equipment_position_history equipment, @PathVariable Integer id) {
		try {
			Equipment_position_history existEquipment = service.get(id);
			service.save(equipment);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/equipments/position_history/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}

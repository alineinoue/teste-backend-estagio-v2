package aline.testebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aline.testebackend.domain.Equipment_state;
import aline.testebackend.repository.Equipment_stateRepository;

@Service
public class Equipment_stateService {
	
	@Autowired
	private Equipment_stateRepository repo;
	
	public List<Equipment_state> listAll(){
		return repo.findAll();
	}

	public void save(Equipment_state equipment) {
		repo.save(equipment);
	}
	
	public Equipment_state get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}

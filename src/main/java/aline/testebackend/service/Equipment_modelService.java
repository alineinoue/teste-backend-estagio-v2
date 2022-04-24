package aline.testebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aline.testebackend.domain.Equipment_model;
import aline.testebackend.repository.Equipment_modelRepository;

@Service
public class Equipment_modelService {
	
	@Autowired
	private Equipment_modelRepository repo;
	
	public List<Equipment_model> listAll(){
		return repo.findAll();
	}

	public void save(Equipment_model equipment) {
		repo.save(equipment);
	}
	
	public Equipment_model get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}

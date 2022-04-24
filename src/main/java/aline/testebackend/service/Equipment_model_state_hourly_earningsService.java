package aline.testebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aline.testebackend.domain.Equipment_model_state_hourly_earnings;
import aline.testebackend.repository.Equipment_model_state_hourly_earningRepository;

@Service
public class Equipment_model_state_hourly_earningsService {
	
	@Autowired
	private Equipment_model_state_hourly_earningRepository repo;
	
	public List<Equipment_model_state_hourly_earnings> listAll(){
		return repo.findAll();
	}

	public void save(Equipment_model_state_hourly_earnings equipment) {
		repo.save(equipment);
	}
	
	public Equipment_model_state_hourly_earnings get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}

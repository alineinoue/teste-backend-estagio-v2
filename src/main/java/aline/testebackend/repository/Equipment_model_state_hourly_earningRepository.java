package aline.testebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aline.testebackend.domain.Equipment_model_state_hourly_earnings;

@Repository
public interface Equipment_model_state_hourly_earningRepository extends JpaRepository<Equipment_model_state_hourly_earnings, Integer> {

}

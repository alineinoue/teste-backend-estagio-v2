package aline.testebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aline.testebackend.domain.Equipment_state;

@Repository
public interface Equipment_stateRepository extends JpaRepository<Equipment_state, Integer> {

}

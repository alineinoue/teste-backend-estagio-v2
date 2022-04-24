package aline.testebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aline.testebackend.domain.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

}

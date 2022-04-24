package aline.testebackend.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Equipment {

	private Integer id;
	private Integer equipment_model_id;
	private String name;
	
	public Equipment() {
	}

	public Equipment(Integer id, Integer equipment_model_id, String name) {
		this.id = id;
		this.equipment_model_id = equipment_model_id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEquipment_model_id() {
		return equipment_model_id;
	}

	public void setEquipment_model_id(Integer equipment_model_id) {
		this.equipment_model_id = equipment_model_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		return Objects.equals(id, other.id);
	}

}

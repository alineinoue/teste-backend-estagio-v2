package aline.testebackend.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipment_state_history {

	private Integer equipment_id;
	private Date date;
	private Integer equipment_state_id;

	public Equipment_state_history() {
	}
	
	public Equipment_state_history(Integer equipment_id, Date date, Integer equipment_state_id) {
		this.equipment_id = equipment_id;
		this.date = date;
		this.equipment_state_id = equipment_state_id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(Integer equipment_id) {
		this.equipment_id = equipment_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getEquipment_state_id() {
		return equipment_state_id;
	}

	public void setEquipment_state_id(Integer equipment_state_id) {
		this.equipment_state_id = equipment_state_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipment_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment_state_history other = (Equipment_state_history) obj;
		return Objects.equals(equipment_id, other.equipment_id);
	}

}

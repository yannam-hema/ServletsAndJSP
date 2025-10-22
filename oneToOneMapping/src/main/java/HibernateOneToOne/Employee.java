package HibernateOneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee", schema="gqt_hib")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column
private String name;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="add_id" , referencedColumnName = "aid")
Address aid;
public Address getAid() {
	return aid;
}
public void setAid(Address aid) {
	this.aid = aid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}

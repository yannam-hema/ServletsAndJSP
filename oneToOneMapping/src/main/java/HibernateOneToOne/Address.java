package HibernateOneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address" , schema="gqt_hib")
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int aid;
@Column
String addline;
@Column
String city;
@Column
String state;

@Column
int pincode;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAddline() {
	return addline;
}
public void setAddline(String addline) {
	this.addline = addline;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}

}

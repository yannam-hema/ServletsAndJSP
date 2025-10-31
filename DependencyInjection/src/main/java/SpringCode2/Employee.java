package SpringCode2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
int id;
String name;
Address address;
@Value("22")
public void setId(int id) {
	this.id=id;
}
@Value("Hema Yannam")
public void setName(String name) {
	this.name=name;
}
@Autowired
public void setAddress(Address address) {
	this.address=address;
}
void display() {
	System.out.println(id+" -> "+name);
	System.out.println("Address -> "+address);
}
}

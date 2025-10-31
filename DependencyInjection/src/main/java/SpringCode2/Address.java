package SpringCode2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Address {
String addline;
String city;
String state;
@Value("3rd cross Road")
public void setAddline(String addline) {
	this.addline = addline;
}
@Value("Bengaluru")
public void setCity(String city) {
	this.city = city;
}
@Value("Karnataka")
public void setState(String state) {
	this.state = state;
}
@Override
public String toString() {
	return addline+"->"+city+"->"+state;
}
}

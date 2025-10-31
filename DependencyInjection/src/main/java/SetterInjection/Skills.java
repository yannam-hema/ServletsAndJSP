package SetterInjection;

public class Skills {
String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Skills(String name) {
	super();
	this.name=name;
}
@Override
public String toString() {
	return "Skills {name '= "+name+" '}";
}
}

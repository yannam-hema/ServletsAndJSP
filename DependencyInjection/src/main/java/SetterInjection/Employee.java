package SetterInjection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
String name;
List<Skills> skills;
List<Project> project;

public Employee(String name) {
	super();
	this.name=name;
}
@Autowired
@Qualifier("Skills")
public void setSkills(List<Skills> skills) {
	this.skills = skills;
}
@Autowired
@Qualifier("project")
public void setProject(List<Project> project) {
	this.project=project;
}

void display() {
	System.out.println(name);
}
}

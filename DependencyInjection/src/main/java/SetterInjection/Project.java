package SetterInjection;

public class Project {
String projectName;
public Project(String projectName) {
	this.projectName=projectName;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String toString() {
	return "project { projectName '= "+projectName+" '}";
}
}

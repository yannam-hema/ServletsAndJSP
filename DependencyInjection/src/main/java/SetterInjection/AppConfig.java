package SetterInjection;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "SetterInjection")
public class AppConfig {
@Bean
public Skills javaSkills() {
	return new Skills("java");
}
@Bean
public Skills pythonSkills() {
	return new Skills("python");
}
@Bean
public Skills rubySkills() {
	return new Skills("ruby");
}
@Bean
public Skills reactSkills() {
	return new Skills("React.js");
}

@Bean
public Project newProject() {
	return new Project("new Project 1");
}
@Bean
public Project newProject2() {
	return new Project("new Project 2");
}
@Bean
public Employee employee() {
	return new Employee("Hema");
}
@Bean(name="Skills")
public List<Skills> skills(){
	return Arrays.asList(javaSkills(),reactSkills(),pythonSkills(),rubySkills());
}
@Bean(name="project")
public List<Project> project(){
	return Arrays.asList(newProject(),newProject2());
}
}

package SetterInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
public static void main(String[] args) {
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
Employee e =(Employee)context.getBean(Employee.class);
e.display();
context.close();
}
}

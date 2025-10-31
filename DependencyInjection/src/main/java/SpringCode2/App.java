package SpringCode2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
      
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class); 

        Employee e = context.getBean(Employee.class);
        e.display();

        context.close();
    }
}

package spring.DependencyInjection.Setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Spring.AppConfig;

public class App {
public static void main(String[] args) {
	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	Notification nf = ac.getBean(Notification.class);
	nf.notifyUser("Hello hema !! this is the message from setter injection");
}
}

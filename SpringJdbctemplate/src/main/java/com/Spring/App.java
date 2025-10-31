package com.Spring;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    	UserService us = ac.getBean(UserService.class);

         Scanner sc = new Scanner(System.in);
         
         Users u = new Users();
         System.out.println("enter name");
         u.setName(sc.next());
         System.out.println("enter email");
         u.setEmail(sc.next());
         us.createUser(u);
         
         List<Users> allUsers = us.getAllUsers();
         for(int i=0;i<allUsers.size();i++) {
        	 Users user = allUsers.get(i);
        	 System.out.println(user.getId()+"--"+user.getName());
         }
         
         System.out.println("----------------");
         
         System.out.println("enter id of the person");
         Users user = (Users) us.getUserById(sc.nextInt());
         System.out.println(user.getId()+"--"+user.getName());
         
         System.out.println("----------------");
         
         System.out.println("Enter the NEW name");
         String name=sc.next();
         System.out.println("Enter the id");
         int id = sc.nextInt();
         
         us.UpdateUserById(id, name);
         
         
       
    }
}

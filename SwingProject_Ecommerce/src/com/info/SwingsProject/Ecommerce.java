package com.info.SwingsProject;

import javax.swing.*;

//import java.awt.Color;
//import java.awt.Image;

public class Ecommerce {

	public static void main(String[] args) {
		
		//creating a Main Frame with a title 
		
		JFrame frame= new JFrame("Welcome to yannam's online Shopping Website");
		//the size of a frame
		frame.setSize(1500,1500);
		
		//To add background color
		//frame.getContentPane().setBackground(Color.blue);
		//frame.getContentPane().setBackground(new Color(250,200,150));
		
		
		ImageIcon ic = new ImageIcon("C:\\Users\\yanna\\Downloads\\EcommerceProjectImage1.png");
	    //Image refined_one= ic.getImage().getScaledInstance(1024,1024,Image.SCALE_SMOOTH);
		JLabel jl_mainImg = new JLabel(ic);
		frame.add(jl_mainImg);
		
		
		//Making Frame Visible
		frame.setVisible(true);
		
		//To close Frame when user Click on Cross Button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Set Menu Bar
		frame.setJMenuBar(new MenuBuilder().createMainMenu());
		
		


		
	}
}

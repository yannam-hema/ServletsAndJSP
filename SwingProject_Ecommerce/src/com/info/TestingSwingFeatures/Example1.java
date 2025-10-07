package com.info.TestingSwingFeatures;


import javax.swing.*;

public class Example1  {

	public static void main(String[] args) {
		
		JFrame frame= new JFrame();
		 frame.setSize(500,400);
		 frame.setVisible(true);
		 JButton button = new JButton("Hello ! I am Hema");
		 button.setBounds(50,100,220,50);
		 frame.add(button);
	}

}

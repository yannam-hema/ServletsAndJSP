package com.info.SwingsProject;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MenuBuilder {
	
	public JMenuBar createMainMenu() {
		
		JMenuBar mb = new JMenuBar();
		
		      //creating Main menus
				JMenu electronicsMenu = new JMenu("Electronics");
				JMenu FurnitureMenu = new JMenu("Furniture");
				JMenu ClothingMenu = new JMenu("Clothing");
				JMenu groceriesMenu = new JMenu("grocery");
				
				mb.add(electronicsMenu);
				mb.add(FurnitureMenu);
				mb.add(ClothingMenu);
				mb.add(groceriesMenu);
				
				//Electronic Menu Sub Menus
				JMenuItem mobiles = new JMenuItem("Mobiles");
				JMenuItem laptop = new JMenuItem("Laptop");
				JMenuItem camera = new JMenuItem("Camera");
				JMenuItem headPhones = new JMenuItem("Head Phones");
				JMenuItem Mouse = new JMenuItem("Mouse");
				
				//adding Electronics SubMenu Items into Electronics Menu
				electronicsMenu.add(mobiles);
				electronicsMenu.add(laptop);
				electronicsMenu.add(camera);
				electronicsMenu.add(headPhones);
				electronicsMenu.add(Mouse);
				
				//Furniture Menu Sub Menus
				JMenuItem sofa = new JMenuItem("Sofa");
				JMenuItem table = new JMenuItem("Table");
				JMenuItem chair = new JMenuItem("Chair");
				JMenuItem bed = new JMenuItem("Bed");
				JMenuItem couch = new JMenuItem("Couch");
						
				//adding Furniture SubMenu Items into Furniture Menu
				FurnitureMenu.add(sofa);
				FurnitureMenu.add(table);
				FurnitureMenu.add(chair);
				FurnitureMenu.add(bed);
				FurnitureMenu.add(couch);
				
				//Clothing Menu Menu Sub Menus
				JMenuItem Women = new JMenuItem("Women");
				JMenuItem Men = new JMenuItem("Men");
				JMenuItem Kids = new JMenuItem("Kids");
				JMenuItem Girls = new JMenuItem("Girls");
				JMenuItem Boys = new JMenuItem("Boys");
				
			   //adding Furniture SubMenu Items into Furniture Menu
				ClothingMenu.add(Women);
				ClothingMenu.add(Men);
				ClothingMenu.add(Kids);
				ClothingMenu.add(Girls);
				ClothingMenu.add(Boys);

				//Groceries Menu Sub Menus
				JMenuItem Fruits = new JMenuItem("Fruits");
				JMenuItem Vegtables = new JMenuItem("Vegtables");
				JMenuItem DairyProducts  = new JMenuItem("DairyProducts");
				JMenuItem Rice = new JMenuItem("Rice");
				JMenuItem Snacks= new JMenuItem("Snacks");
				
				//adding Groceries SubMenu Items into Groceries Menu
				groceriesMenu.add(Fruits);
				groceriesMenu.add(Vegtables);
				groceriesMenu.add(DairyProducts);
				groceriesMenu.add(Rice);
				groceriesMenu.add(Snacks);
				
		
		return mb;
	}

}

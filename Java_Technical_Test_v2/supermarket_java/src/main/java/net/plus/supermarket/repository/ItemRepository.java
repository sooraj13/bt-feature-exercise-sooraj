package net.plus.supermarket.repository;

import java.util.ArrayList;
import java.util.List;

import net.plus.supermarket.model.Item;

public class ItemRepository implements Repository{
	
	
	    // Getting hard coded price and Offer  details .
	    //While Adding Data to DB priorityIndex should be set in a way that lower values should be given to those which is having best offer. 
		public  List<Item>  getData() {

			List<Item> items = new ArrayList<Item>();

			items.add(new Item("A",3,130D,"",1));
			items.add(new Item("A",1,50D,"",2));

			items.add(new Item("B",2,45D,"",1));
			items.add(new Item("B",1,30D,"",2));

			items.add(new Item("C",3,50D,"",1));
			items.add(new Item("C",2,38D,"",2));
			items.add(new Item("C",1,20D,"",3));

			items.add(new Item("D",1,5D,"A",0));
			items.add(new Item("D",1,15D,"",1));


			items.add(new Item("E",1,5D,"",1));

			return items;
		}


}

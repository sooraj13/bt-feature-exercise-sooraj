package net.plus.supermarket.services;

import java.util.HashMap;

import net.plus.supermarket.model.Item;

public interface OfferLogic {
	
	
	public int doOfferLogic(Item inputItem,Item dbItem,HashMap<String,Integer> itemQtyMap,Integer reqItemQty ,Double itemTotalPrice,Integer dbQty);

}

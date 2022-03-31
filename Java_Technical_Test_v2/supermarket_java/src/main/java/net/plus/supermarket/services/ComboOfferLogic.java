package net.plus.supermarket.services;

import java.util.HashMap;

import net.plus.supermarket.model.Item;

public class ComboOfferLogic implements OfferLogic {
	
	
	
	/**
	 * Combo offer scenario(Ex:if D  is purchased with an 'A' )
	 * @param inputItem
	 * @param dbItem
	 * @param itemQtyMap
	 * @param reqItemQty
	 * @param itemTotalPrice
	 */
	public int doOfferLogic(Item inputItem,Item dbItem,HashMap<String,Integer> itemQtyMap,Integer reqItemQty ,Double itemTotalPrice,Integer dbQty) {
		
		//Checks if the combo offer item mentioned in DB is ordered in same order .If yes combo offer price for that many items will be applied.
		
		Integer offerCount = 0;
		if(itemQtyMap.containsKey(dbItem.getComboOfferItem())) {
			offerCount = itemQtyMap.get(dbItem.getComboOfferItem());
			if(offerCount>inputItem.getQty()) {
				offerCount = inputItem.getQty();
			}
		}
		return offerCount;


	}

}

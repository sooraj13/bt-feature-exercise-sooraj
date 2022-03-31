package net.plus.supermarket.services;

import java.util.HashMap;

import net.plus.supermarket.model.Item;

public class NormalOfferLogic implements OfferLogic {
	
	/**
	 * Normal Offer Scenario (Ex:3 for 130 and 1 for 50 scenarios)
	 * @param dbItem
	 * @param reqItemQty
	 * @param itemTotalPrice
	 */
	public int doOfferLogic(Item inputItem,Item dbItem,HashMap<String,Integer> itemQtyMap,Integer reqItemQty ,Double itemTotalPrice,Integer dbQty) {
		
		//Will identify how many times of the best offer available can be applied to the inputed quantity.
		//Since the list is sorted with priority Index  the best offer will get applied first.
		
		Integer mFactor = reqItemQty/dbQty;
		return mFactor;
	}

}

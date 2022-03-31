# bt-feature-exercise-sooraj


Sample Screen:
=================

Welcome To MORE SuperMarket
***************************
Please Provide Item and it's Quantity Details separated with a single space.Each Item should be mentioned in seperate line .Once done please type END 
Item : qty
----   ---
D 10
A 6
B 1
END


Bill Amount : 380.0


Have another bill to calculate? (Type Y for yes and N for No)
N
Thanks For Shopping With MORE SuperMarket...







Notes:
====

ItemRepository->getData() 
	method creates the list of data as mentioned in the question.
	In real case scenario this data will be fetched from Database.

CheckOutService->getSortedData()
	Doing a sorting on the list of hard coded data so that the first item coming in iterator will be the best offer for that particular product.
	Using a field "priorityIndex" to identify the order of best offers available for that product.The Best offer will have a Lower priority index.
	While Adding Data to DB priorityIndex should be set in a way that lower values should be given to those which is having best offer.  
	Ex: Item C: For the given question "3 for 50" will be set as 1,"2 for 38" will be set as 2 and buying a single one will be set as 3 .
		Item D: For Combo offer PriorityIndex will be set to 0 hence "5 if purchased with an 'A'" will be set as 0

CheckOutService->getItemQtyMap()
		Creating a map to identify the items purchased and it's quantity
		Using below map For SpecialOffer scenarios(Ex:If D is purchased with an 'A' we need to identify how many A's are present in Request)

ComboOfferLogic->doOfferLogic()
	Checks if the combo offer item mentioned in DB is ordered in same order .If yes combo offer price for that many items will be applied.

NormalOfferLogic->doOfferLogic()
	Will identify how many times of the best offer available can be applied to the inputed quantity.
	Since the list is sorted with priority Index  the best offer will get applied first.







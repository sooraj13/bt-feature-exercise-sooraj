package net.plus.supermarket;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.plus.supermarket.repository.ItemRepository;

public class TestItemRepository {
	
	ItemRepository  repo=new ItemRepository();
	
	@Test
	public void testgetData() {
		assertNotNull(repo.getData());
	}


}

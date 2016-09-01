package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testElementsAreUnique() {
		
		Collection<String> collection = new ArrayList<String>();
		collection.add("a");
		collection.add("b");
		
		assertTrue(Utils.elementsAreUnique(collection));
		
		collection.add("b");
		assertFalse(Utils.elementsAreUnique(collection));

	}
	
	@Test
	public void testIsAnyNull() {
		Object[] array = new Object[10];
		assertTrue(Utils.isAnyNull(array));

		for (Object a : array){
			a = new Object();
		}
		assertTrue(Utils.isAnyNull(array));
		
	}

}

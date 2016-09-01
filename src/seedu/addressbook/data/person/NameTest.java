package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	
	@Test
	public void testIsSimilar() {
			
		Name a;
		Name b;
		try {
			a = new Name("JOHN one");
			b = new Name("john two");
			assertTrue(a.isSimilar(b));
		} catch (IllegalValueException e) {
			e.printStackTrace();
		}
	}

}

package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }
    
    public boolean isSimilar(Name other){
    	String myName = this.fullName.toLowerCase();
    	String theirName = other.fullName.toLowerCase();
    	
    	if (myName == null || theirName == null)
    		return false;
    	
    	List<String> myWords = Arrays.asList(myName.split("\\s+"));
    	List<String> theirWords = Arrays.asList(theirName.split("\\s+"));

    	System.out.println(myWords);
    	
    	if (checkIfSameWordOccurs(theirWords, myWords))
    		return true;
    	
    	return false;
    }
    
    boolean checkIfSameWordOccurs(List<String> theirWords, List<String> myWords){
    	for (String one : theirWords){
    		for (String two : myWords){
    			
    			if (two.equals(one))
    				return true;
    			
    		}
    	}
    	
    	return false;
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}

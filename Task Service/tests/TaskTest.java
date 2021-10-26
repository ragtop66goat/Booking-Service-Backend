//Author Name: Jason Gionfriddo

//Description: This is the Task test file that validates the Task class is in accordance with the 
//defined requirements before a task is added to the TaskCreation classList

package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import tasks.main.Task;

import org.junit.jupiter.api.Test;

class TaskTest {

	// valid task creation
	@Test
	void testTask() {
		Task testTask = new Task("1234567890", "Grocery", "Pick up eggs and milk");
		assertTrue(testTask.getId().equals("1234567890"));
		assertTrue(testTask.getName().equals("Grocery"));
		assertTrue(testTask.getDescription().equals("Pick up eggs and milk"));
	}


@Test
void testNullID() {
	
	//Testing null input for ID.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Task(null, "Grocery", "Pick up eggs and milk");
		});
  }

@Test
void testLongID() {
	
	//Testing null input for ID.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Task("12345678901", "Grocery", "Pick up eggs and milk");
		});
  }

@Test
void testNullName() {
	
	//Testing null input for name.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Task("1234567890", null, "Pick up eggs and milk");
		});
  }

@Test
void testLongName() {
	
	//Testing too long input for name.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Task("1234567890", "GroceryGroceryGrocery", "Pick up eggs and milk");
		});
  }

@Test
void testNullDescription() {
	
	//Testing null input for description.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Task("1234567890", "Grocery", null);
		});
  }

@Test
void testLongDescription() {
	
	//Testing too long input for description.
	Assertions.assertThrows(IllegalArgumentException.class, () -> { 
		new Task("1234567890", "Grocery", "Pick up eggs and milk Pick up eggs and milk Pick up eggs and milk Pick up eggs and milk");
		});
  }

}
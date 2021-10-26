//Author Name: Jason Gionfriddo

//Description: This is the TaskService test file that validates the add, update, and delete functionality 
// of the TaskService class

package tests;

import tasks.main.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class TaskServiceTest {

	@Test
	void testAddContact() {
		TaskService tasks = new TaskService();
		
		// Successfully add new task
		tasks.addTask("1234567890", "Grocery", "Get eggs and milk");
		
		// Test for duplicate id 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			tasks.addTask("1234567890", "Grocery2", "Also get ground beef");
		});
		
		//delete the task to avoid duplication error in testing
		tasks.deleteTask("1234567890");
	}
	
	// test for the ability to delete a task
		@Test
		void testDeleteTask() {
			TaskService tasks = new TaskService();
			
			// test for empty task list
			Assertions.assertThrows(Error.class, () -> {
			tasks.deleteTask("1");
		});
			
			// Successfully add the task to be deleted
			tasks.addTask("1234567890", "Grocery", "Get eggs and milk");
			
			// delete the task
			tasks.deleteTask("1234567890");
			
			// ensure that a non-existent task can not be deleted
			Assertions.assertThrows(Error.class, () -> {
				tasks.deleteTask("1");
			});
			
		}
	
	// test for the ability to update a task
	@Test
	void testUpdateTask() {
		TaskService tasks = new TaskService();
		
		// test for empty task list
		Assertions.assertThrows(Error.class, () -> {
		tasks.updateTask("1234567890", "Grocery", "Get eggs and milk");
	});
		
		// Successfully add new task
		tasks.addTask("1234567890", "Grocery", "Get eggs and milk");
		
		// Update the task
		tasks.updateTask("1234567890", "Grocery2", "Get eggs and milk and ground beef");
		
		Assertions.assertThrows(Error.class, () -> {
			tasks.updateTask("1", "Grocery3", "Dont get any of it");
		});
		
		// delete the task to avoid duplication error in testing
		tasks.deleteTask("1234567890");

  }
}	
	

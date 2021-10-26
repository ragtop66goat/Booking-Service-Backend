//Author Name: Jason Gionfriddo

//Date: 09/26/2021

//Course ID: CS-320-T1021 Software Test Automation

//Description: This is the TaskService class that ensures all task functions meet the requirements 
//for id, name, and description

package tasks.main;
import java.util.ArrayList;

public class TaskService {
	
	// array for storing tasks
	public static ArrayList<Task> taskList = new ArrayList<>();
	
	// method to add a task
	public void addTask(String id, String name, String description) {
		
		// constructor for new task from Task.java
		Task newTask = new Task(id, name, description);
		
		// append to task list
		taskList.add(newTask);
	}
	
	// method to delete a task
	public void deleteTask(String id) {
		
		// make sure the taskList is not empty
		if(taskList.size() == 0) {
			throw new Error("There are no tasks in the lsit!");
		}
		
		// for loop to search for the id
		for (int i = 0; i < taskList.size(); i++) {
			if(taskList.get(i).getId().equals(id)) {
				taskList.remove(i);
				
				return;
			}
		}
		
		// error for non-existent id
		throw new Error("Id not found");
	}
	
	// method to update the task fields
	public void updateTask(String id, String name, String description) {
		
		// make sure the list is not empty
		if(taskList.size() == 0) {
			throw new Error("There are no tasks in the list");
		}
		
		// for loop to find the task by it's id
		for (int i = 0; i < taskList.size(); i++) {
			if(taskList.get(i).getId().equals(id)) {
				
				taskList.get(i).setName(name);
				taskList.get(i).setDescription(description);
				
				return;
			}
		}
		
		//error for non-existent task id
		throw new Error("Id not found");
	}

}

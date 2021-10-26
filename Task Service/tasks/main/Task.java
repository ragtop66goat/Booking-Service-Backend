//Author Name: Jason Gionfriddo

//Date: 09/26/2021

//Course ID: CS-320-T1021 Software Test Automation

//Description: This is the Task class that ensures all new contacts meet the requirements 
//for a valid id, name, and description

package tasks.main;

public class Task {
	
	// id is final and initialized in the constructor to prevent it form being changed
	private final String id;
	private String name;
	private String description;
	
	
	// task constructor
	public Task(String idNum, String name, String description) {
		// id validation per requirements
		if(idNum == null || idNum.length() > 10) {
			throw new IllegalArgumentException("Id is invalid!");
		}
		
		// ensures id is unique
		for(int i = 0; i < TaskService.taskList.size(); i++) {
			if(TaskService.taskList.get(i).getId().equals(idNum)) {
				throw new IllegalArgumentException("Id is already taken!");
			}
		}
		
		id = idNum;
		this.setName(name);
		this.setDescription(description);
		
	}


	// section for all setters
	public void setName(String name) {
		// validates name per requirements
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name is invalid");
		}
		this.name = name;
	}

	public void setDescription(String description) {
		// validates description per requirements
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description is invalid");
		}
		this.description = description;
	}
	
	

	// section for all getters
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
}

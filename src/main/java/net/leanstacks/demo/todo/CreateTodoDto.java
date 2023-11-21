package net.leanstacks.demo.todo;

public class CreateTodoDto {
	
	private String title;
	
	public CreateTodoDto() {
		
	}
	
	public CreateTodoDto(String title) {
		this();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

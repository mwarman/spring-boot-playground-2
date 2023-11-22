package net.leanstacks.demo.todo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreateTodoDto {

	@NotBlank(message = "title is required")
	@Size(min = 1, max = 100, message = "title must contain 1 to 100 characters")
	private String title;

	public CreateTodoDto() {

	}

	public CreateTodoDto(String title) {
		this();
		this.title = title;
	}

	@Schema(example = "Document the API")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

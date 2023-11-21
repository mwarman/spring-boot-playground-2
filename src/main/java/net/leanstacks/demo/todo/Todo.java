package net.leanstacks.demo.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "title is required")
	@Size(min = 1, max = 100, message = "title must contain 1 to 100 characters")
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private boolean isComplete;

	public Todo() {

	}

	public Todo(String title, boolean isComplete) {
		this();
		this.title = title;
		this.isComplete = isComplete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

}

package net.leanstacks.demo.todo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable("id") Long id) {
		logger.info("> getTodo");
		logger.debug("id: {}", id);

		final Optional<Todo> todo = todoService.find(id);

		logger.info("< getTodo");
		return todo.get();
	}

	@GetMapping
	public List<Todo> getTodos() {
		logger.info("> getTodos");

		final List<Todo> todos = todoService.findAll();

		logger.info("< getTodos");
		return todos;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Todo createTodo(@Valid @RequestBody CreateTodoDto todoDto) {
		logger.info("> createTodo");

		final Todo createdTodo = todoService.create(todoDto);

		logger.info("< createTodo");
		return createdTodo;
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
		logger.info("> updateTodo");

		final Optional<Todo> updatedTodo = todoService.update(todo);

		logger.info("< updateTodo");
		return updatedTodo.get();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTodo(@PathVariable("id") Long id) {
		logger.info("> deleteTodo");
		logger.debug("id: {id}", id);

		todoService.delete(id);

		logger.info("< deleteTodo");
	}

}

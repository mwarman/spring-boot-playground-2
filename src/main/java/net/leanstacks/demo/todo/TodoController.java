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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.leanstacks.demo.exception.ExceptionDetail;

@Tag(name = "Todos", description = "The API endpoints to access and mutate Todos.")
@ApiResponse(responseCode = "400", description = "Bad Request", content = {
		@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetail.class)) })
@ApiResponse(responseCode = "401", description = "Unauthorized", content = {
		@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetail.class)) })
@ApiResponse(responseCode = "403", description = "Forbidden", content = {
		@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetail.class)) })
@RestController
@RequestMapping("/api/todos")
public class TodoController {

	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@Operation(summary = "Get Todo", description = "Optionally provide detailed description of the API endpoint. Fugait qos voluptate irure adipiscing sed aenean. Duis neque eiusmod culpa laborum esse. E proident nisi aliqua exercitation nulla vel laboris. Consectetur aliqua non dolor laoreet consequat cupidatat morbi. Nul ero ero quis a aute do. Condimentum nostrud consequat laoreet vitae nam aliquip lorem. Convallis justo ad veniam elit dolor tempor dui amet.")
	@ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Todo.class)) })
	@ApiResponse(responseCode = "404", description = "Not Found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetail.class)) })
	@GetMapping("/{id}")
	public Todo getTodo(@Parameter(description = "A Todo identifier.") @PathVariable("id") Long id) {
		logger.info("> getTodo");
		logger.debug("id: {}", id);

		final Optional<Todo> todo = todoService.find(id);

		logger.info("< getTodo");
		return todo.get();
	}

	@Operation(summary = "List Todos", description = "Optionally provide detailed description of the API endpoint. Fugait qos voluptate irure adipiscing sed aenean. Duis neque eiusmod culpa laborum esse. E proident nisi aliqua exercitation nulla vel laboris. Consectetur aliqua non dolor laoreet consequat cupidatat morbi. Nul ero ero quis a aute do. Condimentum nostrud consequat laoreet vitae nam aliquip lorem. Convallis justo ad veniam elit dolor tempor dui amet.")
	@ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Todo.class))) })
	@GetMapping
	public List<Todo> getTodos() {
		logger.info("> getTodos");

		final List<Todo> todos = todoService.findAll();

		logger.info("< getTodos");
		return todos;
	}

	@Operation(summary = "Create Todo", description = "Optionally provide detailed description of the API endpoint. Fugait qos voluptate irure adipiscing sed aenean. Duis neque eiusmod culpa laborum esse. E proident nisi aliqua exercitation nulla vel laboris. Consectetur aliqua non dolor laoreet consequat cupidatat morbi. Nul ero ero quis a aute do. Condimentum nostrud consequat laoreet vitae nam aliquip lorem. Convallis justo ad veniam elit dolor tempor dui amet.")
	@ApiResponse(responseCode = "201", description = "Created", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Todo.class)) })
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Todo createTodo(@Valid @RequestBody CreateTodoDto todoDto) {
		logger.info("> createTodo");

		final Todo createdTodo = todoService.create(todoDto);

		logger.info("< createTodo");
		return createdTodo;
	}

	@Operation(summary = "Update Todo", description = "Optionally provide detailed description of the API endpoint. Fugait qos voluptate irure adipiscing sed aenean. Duis neque eiusmod culpa laborum esse. E proident nisi aliqua exercitation nulla vel laboris. Consectetur aliqua non dolor laoreet consequat cupidatat morbi. Nul ero ero quis a aute do. Condimentum nostrud consequat laoreet vitae nam aliquip lorem. Convallis justo ad veniam elit dolor tempor dui amet.")
	@ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Todo.class)) })
	@ApiResponse(responseCode = "404", description = "Not Found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetail.class)) })
	@PutMapping("/{id}")
	public Todo updateTodo(@Parameter(description = "A Todo identifier.") @PathVariable("id") Long id,
			@RequestBody Todo todo) {
		logger.info("> updateTodo");

		final Optional<Todo> updatedTodo = todoService.update(todo);

		logger.info("< updateTodo");
		return updatedTodo.get();
	}

	@Operation(summary = "Delete Todo", description = "Optionally provide detailed description of the API endpoint. Fugait qos voluptate irure adipiscing sed aenean. Duis neque eiusmod culpa laborum esse. E proident nisi aliqua exercitation nulla vel laboris. Consectetur aliqua non dolor laoreet consequat cupidatat morbi. Nul ero ero quis a aute do. Condimentum nostrud consequat laoreet vitae nam aliquip lorem. Convallis justo ad veniam elit dolor tempor dui amet.")
	@ApiResponse(responseCode = "204", description = "No Content")
	@ApiResponse(responseCode = "404", description = "Not Found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetail.class)) })
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTodo(@Parameter(description = "A Todo identifier.") @PathVariable("id") Long id) {
		logger.info("> deleteTodo");
		logger.debug("id: {id}", id);

		todoService.delete(id);

		logger.info("< deleteTodo");
	}

}

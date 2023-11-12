package com.neonci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neonci.dto.Todo;
import com.neonci.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		return todoRepository.save(todo);
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
		Todo todo = todoRepository.findById(id).orElse(null);

		if (todo != null) {
			todo.setTitle(updatedTodo.getTitle());
			todo.setCompleted(updatedTodo.isCompleted());
			return todoRepository.save(todo);
		} else {
			return null; // Handle not found scenario
		}
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Long id) {
		todoRepository.deleteById(id);
	}
}

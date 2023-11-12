package com.neonci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neonci.dto.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	// You can add custom queries if needed
}

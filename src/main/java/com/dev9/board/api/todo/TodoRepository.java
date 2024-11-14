package com.dev9.board.api.todo;

import org.springframework.data.jpa.repository.JpaRepository;



//JpaRepository
//CrudRepository
//PagingAndSortingRepository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}

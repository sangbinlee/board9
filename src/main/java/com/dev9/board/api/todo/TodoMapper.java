package com.dev9.board.api.todo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

	int insert(Todo todo);

//	List<Map<String, Object>> select(Todo todo);
	List<Todo> select(Todo todo);
	List<Todo> select2();

	Todo update(Todo todo);

	void delete(Todo todo);
//	int delete(Todo todo);

}

package com.dev9.board.api.todo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

	int insert(Todo todo);

//	List<Map<String, Object>> select(Todo todo);
	List<Todo> select(Todo todo);
	List<Map<String, Object>> select2();
	List<Map<String, Object>> select3();
	List<Map<String, Object>> select4();
	List<Map<String, Object>> select5();
	List<Map<String, Object>> select6(Map<String, Object> param);
	List<Map<String, Object>> select7(Map<String, Object> param);

	Todo update(Todo todo);

	void delete(Todo todo);
//	int delete(Todo todo);

	List<Map<String, Object>> select8(Map<String, Object> param);

	List<Map<String, Object>> select9(Map<String, Object> param);

	List<Map<String, Object>> select10(Map<String, Object> param);

}

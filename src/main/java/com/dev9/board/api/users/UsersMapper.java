package com.dev9.board.api.users;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

	int insert(Users todo);

//	List<Map<String, Object>> select(Todo todo);
	List<Users> select(Users todo);

	Users update(Users todo);

	void delete(Users todo);
//	int delete(Todo todo);

}

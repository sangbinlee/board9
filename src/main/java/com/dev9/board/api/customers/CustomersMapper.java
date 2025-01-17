package com.dev9.board.api.customers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomersMapper {

	int insert(Customers todo);

//	List<Map<String, Object>> select(Todo todo);
	List<Customers> select(Customers todo);

	Customers update(Customers todo);

	void delete(Customers todo);
//	int delete(Todo todo);

}

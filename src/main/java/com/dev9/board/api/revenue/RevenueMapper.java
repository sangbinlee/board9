package com.dev9.board.api.revenue;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RevenueMapper {

	int insert(Revenue todo);

//	List<Map<String, Object>> select(Todo todo);
	List<Revenue> select(Revenue todo);

	Revenue update(Revenue todo);

	void delete(Revenue todo);
//	int delete(Todo todo);

}

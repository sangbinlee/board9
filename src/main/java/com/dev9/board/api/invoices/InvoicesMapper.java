package com.dev9.board.api.invoices;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InvoicesMapper {

	int insert(Invoices todo);

//	List<Map<String, Object>> select(Todo todo);
	List<Invoices> select(Invoices todo);

	Invoices update(Invoices todo);

	void delete(Invoices todo);
//	int delete(Todo todo);

}

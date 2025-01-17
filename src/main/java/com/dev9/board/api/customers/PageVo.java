package com.dev9.board.api.customers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * <pre>
 * </pre>
 */
@Data
@JsonPropertyOrder({ "id", "name", "quantity", "price" }) // json 출력 순서지정
public class PageVo {

	private Integer page;
	private Integer size;
	private String sort;
	private String keyword;

}

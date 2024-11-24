package com.dev9.board.api.todo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * type : buy :  제품명, 가격, 개수
 * type : study : (영어, k8s), 공부시간,  몇분,
 * </pre>
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)// Json-응답시-Null-필드-제외
@JsonPropertyOrder({ "id", "name", "quantity", "price" }) // json 출력 순서지정
public class Todo extends AuditableEntity {

//	@JsonProperty("id")
	@Id
//    @GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@JsonProperty("name")
	private String name;

	private Integer quantity;

	private Double price;

}

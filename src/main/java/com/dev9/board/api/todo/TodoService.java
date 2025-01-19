package com.dev9.board.api.todo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	TodoMapper todoMapper;




	@Transactional
	int insert(Todo todo){
		String name = todo.getName();
		double price = todo.getPrice();
		int quantity = todo.getQuantity();

		int cnt = 0 ;
		for (int i = 0; i < 100; i++) {
			cnt++;
			Todo todo_ = new Todo();
			todo_.setName(name+ "-" + i);
			todo_.setPrice(price + i);
			todo_.setQuantity(quantity+i);
			todoRepository.save(todo_);
		}
		return cnt;
	}

	@Transactional
	int insertMybatis(Todo todo){
		return todoMapper.insert(todo);
	}

//	List<Map<String, Object>> select(Todo todo){
//		return todoMapper.select(todo);
//	}
	@Cacheable("getTodo")
	List<Todo> select(){
//		List<Todo> select(Todo todo){
		return todoRepository.findAll();
	}





	Page<Todo> page(Todo todo, Pageable pageable){



		// http://localhost:8080/todo/page?sort=id,desc&size=1000&keyword=sangbinlee
		// http://localhost:8080/todo/page?sort=id,desc&size=1000&keyword=sangbinlee
		// http://localhost:8080/todo/page?sort=id,desc&size=1000&keyword=sangbinlee
		// http://localhost:8080/todo/page?sort=id,desc&size=1000&keyword=sangbinlee
		// http://localhost:8080/todo/page?sort=id,desc&size=1000&keyword=sangbinlee
		// http://localhost:8080/todo/page?sort=id,desc&size=1000&keyword=sangbinlee

		// where 절 동적 추가????????
		ExampleMatcher matcher = ExampleMatcher
				.matching()
//		  .withIgnorePaths("quantity")
//		  .withIgnorePaths("price")
//		  .withIncludeNullValues()
//		  .withStringMatcher(StringMatcher.ENDING)
//				.withMatcher("name",GenericPropertyMatcher.of(StringMatcher.ENDING))// %sangbinlee
//				.withMatcher("name",GenericPropertyMatcher.of(StringMatcher.CONTAINING))// %sangbinlee%
//				.withMatcher("name",GenericPropertyMatcher.of(StringMatcher.STARTING))// sangbinlee%
				.withMatcher("name",GenericPropertyMatcher.of(StringMatcher.STARTING))// sangbinlee%
		  ;


		Todo todo_ = new Todo();
		todo_.setName(todo.getKeyword());// 검색어 이름이 검색어인 경우 where 조건절을 만든다.


		Example<Todo> example = Example.of(todo_, matcher);
//        Pageable pageable = PageRequest.of(
//        		todo.getPage()
//        		, todo.getSize()
//        		, Sort.by("id").descending()
////        		.and(Sort.by(todo.getSortBy())
//        );

        // where 절 동적 추가????????

        Page<Todo> pageData = todoRepository.findAll(example, pageable);
        return pageData;
	}

	@Transactional
	Todo update(Todo todo){
		return todoMapper.update(todo);
	}

	@Transactional
	void delete(Todo todo){
		todoMapper.delete(todo);
	}

	@Transactional
	void deleteJpa(Todo todo){
		todoRepository.deleteAll();
	}




	List<Map<String, Object>> select2(){
//		List<Todo> select(Todo todo){
		return todoMapper.select2();
	}


	List<Map<String, Object>> select3(){
//		List<Todo> select(Todo todo){
		return todoMapper.select3();
	}

	List<Map<String, Object>> select4(){
//		List<Todo> select(Todo todo){
		return todoMapper.select4();
	}

	List<Map<String, Object>> select5(){
		return todoMapper.select5();
	}

	List<Map<String, Object>> select6(Map<String, Object> param){
		return todoMapper.select6(param);
	}

	List<Map<String, Object>> select7(Map<String, Object> param){
		return todoMapper.select7(param);
	}



	public List<Map<String, Object>> select8(Map<String, Object> param) {
		return todoMapper.select8(param);
	}

	public List<Map<String, Object>> select9(Map<String, Object> param) {
		return todoMapper.select9(param);
	}




}

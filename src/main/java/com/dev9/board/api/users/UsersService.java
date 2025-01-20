package com.dev9.board.api.users;

import java.util.List;

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
public class UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	UsersMapper usersMapper;




	@Transactional
	int insert(Users todo){




			Users todo_ = new Users();
			todo_.setName("User");
			todo_.setEmail("user@nextmail.com");
			todo_.setPassword("123456");

			usersRepository.save(todo_);










//		String name = todo.getName();
//		double price = todo.getPrice();
//		int quantity = todo.getQuantity();

		int cnt = 0 ;
		cnt++;
//		for (int i = 0; i < 100; i++) {
//			Users todo_ = new Users();
//			todo_.setName(name+ "-" + i);
//			todo_.setPrice(price + i);
//			todo_.setQuantity(quantity+i);
//			usersRepository.save(todo_);
//		}
		return cnt;
	}

	@Transactional
	int insertMybatis(Users todo){
		return usersMapper.insert(todo);
	}

//	List<Map<String, Object>> select(Todo todo){
//		return todoMapper.select(todo);
//	}
	@Cacheable("getUsers")
	List<Users> selectAll(){
//		List<Todo> select(Todo todo){
		return usersRepository.findAll();
	}
	@Cacheable("getUser")
	List<Users> findByEmail(String email){
//		List<Todo> select(Todo todo){
		return usersRepository.findByEmail(email);
	}











	Page<Users> page(Users todo, Pageable pageable){



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


		Users todo_ = new Users();
		todo_.setName(todo.getKeyword());// 검색어 이름이 검색어인 경우 where 조건절을 만든다.


		Example<Users> example = Example.of(todo_, matcher);
//        Pageable pageable = PageRequest.of(
//        		todo.getPage()
//        		, todo.getSize()
//        		, Sort.by("id").descending()
////        		.and(Sort.by(todo.getSortBy())
//        );

        // where 절 동적 추가????????

        Page<Users> pageData = usersRepository.findAll(example, pageable);
        return pageData;
	}

	@Transactional
	Users update(Users todo){
		return usersMapper.update(todo);
	}

	@Transactional
	void delete(Users todo){
		usersMapper.delete(todo);
	}

	@Transactional
	void deleteJpa(Users todo){
		usersRepository.deleteAll();
	}




}

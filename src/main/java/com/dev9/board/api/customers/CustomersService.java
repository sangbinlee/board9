package com.dev9.board.api.customers;

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
public class CustomersService {

	@Autowired
	CustomersRepository customersRepository;

	@Autowired
	CustomersMapper customersMapper;




	@Transactional
	int insert(Customers todo){
		String name = todo.getName();
		String email = todo.getEmail();
		String imageUrl = todo.getImageUrl();




		String [] names = new String [] {
				"Evil Rabbit",
				"Delba de Oliveira",
				"Lee Robinson",
				"Michael Novotny",
				"Amy Burns",
				"Balazs Orban",

		};

		String [] emails = new String [] {
				"evil@rabbit.com",
				"delba@oliveira.com",
				"lee@robinson.com",
				"michael@novotny.com",
				"amy@burns.com",
				"balazs@orban.com",
		};

		String [] imageUrls = new String [] {
				 "/customers/evil-rabbit.png",
				 "/customers/delba-de-oliveira.png",
				 "/customers/lee-robinson.png",
				 "/customers/michael-novotny.png",
				 "/customers/amy-burns.png",
				 "/customers/balazs-orban.png",
		};
		String [] ids = new String [] {
				"d6e15727-9fe1-4961-8c5b-ea44a9bd81aa",
				"3958dc9e-712f-4377-85e9-fec4b6a6442a",
				"3958dc9e-742f-4377-85e9-fec4b6a6442a",
				"76d65c26-f784-44a2-ac19-586678f7c2f2",
				"CC27C14A-0ACF-4F4A-A6C9-D45682C144B9",
				"13D07535-C59E-4157-A011-F8D2EF4E0CBB",
		};




		int cnt = 0 ;
		for (int i = 0; i < names.length; i++) {
			cnt++;
			Customers todo_ = new Customers();
			todo_.setName(names[i]);
			todo_.setUId(ids[i]);
			todo_.setEmail(emails[i]);
			todo_.setImageUrl(imageUrls[i]);

			customersRepository.save(todo_);
		}
		return cnt;
	}

	@Transactional
	int insertMybatis(Customers todo){
		return customersMapper.insert(todo);
	}

//	List<Map<String, Object>> select(Todo todo){
//		return todoMapper.select(todo);
//	}
	@Cacheable("getCustomers")
	List<Customers> select(){
//		List<Todo> select(Todo todo){
		return customersRepository.findAll();
	}
	Page<Customers> page(Customers todo, Pageable pageable){



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


		Customers todo_ = new Customers();
		todo_.setName(todo.getKeyword());// 검색어 이름이 검색어인 경우 where 조건절을 만든다.


		Example<Customers> example = Example.of(todo_, matcher);
//        Pageable pageable = PageRequest.of(
//        		todo.getPage()
//        		, todo.getSize()
//        		, Sort.by("id").descending()
////        		.and(Sort.by(todo.getSortBy())
//        );

        // where 절 동적 추가????????

        Page<Customers> pageData = customersRepository.findAll(example, pageable);
        return pageData;
	}

	@Transactional
	Customers update(Customers todo){
		return customersMapper.update(todo);
	}

	@Transactional
	void delete(Customers todo){
		customersMapper.delete(todo);
	}

	@Transactional
	void deleteJpa(Customers todo){
		customersRepository.deleteAll();
	}




}

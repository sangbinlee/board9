package com.dev9.board.api.revenue;

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
public class RevenueService {

	@Autowired
	RevenueRepository revenueRepository;

	@Autowired
	RevenueMapper revenueMapper;




	@Transactional
	int insert(Revenue revenue){
		String month = revenue.getMonth();
		int price = revenue.getRevenue();




		String [] months = new String [] {
				"Jan",
				"Feb",
				"Mar",
				"Apr",
				"May",
				"Jun",
				"Jul",
				"Aug",
				"Sep",
				"Oct",
				"Nov",
				"Dec"
		};

		int[] revenues = new int[] {
				 2000,
				 1800,
				 2200,
				 2500,
				 2300,
				 3200,
				 3500,
				 3700,
				 2500,
				 2800,
				 3000,
				 4800

		};

		int cnt=0;
		for (int i = 0; i < months.length; i++) {
			revenue = new Revenue();
			revenue.setMonth(months[i]);
			revenue.setRevenue(revenues[i]);
			revenueRepository.save(revenue);
			cnt++;
		}
		return cnt;
	}

	@Transactional
	int insertMybatis(Revenue todo){
		return revenueMapper.insert(todo);
	}

//	List<Map<String, Object>> select(Todo todo){
//		return todoMapper.select(todo);
//	}
	@Cacheable("getRevenue")
	List<Revenue> select(){
//		List<Todo> select(Todo todo){
		return revenueRepository.findAll();
	}
	Page<Revenue> page(Revenue todo, Pageable pageable){



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


		Revenue todo_ = new Revenue();
//		todo_.setName(todo.getKeyword());// 검색어 이름이 검색어인 경우 where 조건절을 만든다.


		Example<Revenue> example = Example.of(todo_, matcher);
//        Pageable pageable = PageRequest.of(
//        		todo.getPage()
//        		, todo.getSize()
//        		, Sort.by("id").descending()
////        		.and(Sort.by(todo.getSortBy())
//        );

        // where 절 동적 추가????????

        Page<Revenue> pageData = revenueRepository.findAll(example, pageable);
        return pageData;
	}

	@Transactional
	Revenue update(Revenue todo){
		return revenueMapper.update(todo);
	}

	@Transactional
	void delete(Revenue todo){
		revenueMapper.delete(todo);
	}

	@Transactional
	void deleteJpa(Revenue todo){
		revenueRepository.deleteAll();
	}




}

package com.dev9.board.api.invoices;

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

import com.dev9.board.api.invoices.Invoices.StatusType;

@Service
public class InvoicesService {

	@Autowired
	InvoicesRepository invoicesRepository;

	@Autowired
	InvoicesMapper invoicesMapper;




	@Transactional
	int insert(Invoices todo){
//		String name = todo.getName();
//		double price = todo.getPrice();
//		int quantity = todo.getQuantity();

		String [] ids = new String [] {
				"d6e15727-9fe1-4961-8c5b-ea44a9bd81aa",
				"3958dc9e-712f-4377-85e9-fec4b6a6442a",
				"3958dc9e-742f-4377-85e9-fec4b6a6442a",
				"76d65c26-f784-44a2-ac19-586678f7c2f2",
				"CC27C14A-0ACF-4F4A-A6C9-D45682C144B9",
				"13D07535-C59E-4157-A011-F8D2EF4E0CBB",
		};



		String [] customerIds = new String [] {
				ids[0],
				ids[1],
				ids[4],
				ids[3],
				ids[5],
				ids[2],
				ids[0],
				ids[3],
				ids[4],
				ids[5],
				ids[1],
				ids[5],
				ids[2]
		};

		int[] amounts = new int[] {
				15795,
				20348,
				3040,
				44800,
				34577,
				54246,
				666,
				32545,
				1250,
				8546,
				500,
				8945,
				1000
		};

		StatusType [] statusTypes = new StatusType [] {
				StatusType.pending,
				StatusType.pending,
				StatusType.paid,
				StatusType.paid,
				StatusType.pending,
				StatusType.pending,
				StatusType.pending,
				StatusType.paid,
				StatusType.paid,
				StatusType.paid,
				StatusType.paid,
				StatusType.paid,
				StatusType.paid
		};

		String [] dates = new String [] {
				"2022-12-06",
				"2022-11-14",
				"2022-10-29",
				"2023-09-10",
				"2023-08-05",
				"2023-07-16",
				"2023-06-27",
				"2023-06-09",
				"2023-06-17",
				"2023-06-07",
				"2023-08-19",
				"2023-06-03",
				"2022-06-05"
		};


		int cnt = 0 ;
		for (int i = 0; i < customerIds.length; i++) {
			cnt++;
			Invoices todo_ = new Invoices();
			todo_.setCustomerId(customerIds[i]);
			todo_.setDate(dates[i]);
			todo_.setStatus(statusTypes[i]);
			todo_.setAmount((double) amounts[i]);
			invoicesRepository.save(todo_);
		}
		return cnt;
	}

	@Transactional
	int insertMybatis(Invoices todo){
		return invoicesMapper.insert(todo);
	}

//	List<Map<String, Object>> select(Todo todo){
//		return todoMapper.select(todo);
//	}
	@Cacheable("getInvoices")
	List<Invoices> select(){
//		List<Todo> select(Todo todo){
		return invoicesRepository.findAll();
	}
	Page<Invoices> page(Invoices todo, Pageable pageable){



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


		Invoices todo_ = new Invoices();
//		todo_.setName(todo.getKeyword());// 검색어 이름이 검색어인 경우 where 조건절을 만든다.


		Example<Invoices> example = Example.of(todo_, matcher);
//        Pageable pageable = PageRequest.of(
//        		todo.getPage()
//        		, todo.getSize()
//        		, Sort.by("id").descending()
////        		.and(Sort.by(todo.getSortBy())
//        );

        // where 절 동적 추가????????

        Page<Invoices> pageData = invoicesRepository.findAll(example, pageable);
        return pageData;
	}

	@Transactional
	Invoices update(Invoices todo){
		return invoicesMapper.update(todo);
	}

	@Transactional
	void delete(Invoices todo){
		invoicesMapper.delete(todo);
	}

	@Transactional
	void deleteJpa(){
		invoicesRepository.deleteAll();
	}

	public void deleteById(Long id) {
		invoicesRepository.deleteById(id);
	}

	public Invoices updateJpa(Invoices invoices) {
		return invoicesRepository.save(invoices);

	}

	public Invoices insertJpa(Invoices invoices) {
		return invoicesRepository.save(invoices);
	}





}

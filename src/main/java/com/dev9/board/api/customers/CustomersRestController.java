package com.dev9.board.api.customers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * 페이징 소팅 http://localhost:8080/todo?page=3&size=5&sort=id,desc
 */
@RestController
@Slf4j
@RequestMapping(value = "/customers")
public class CustomersRestController {

	@Autowired
	HttpSession httpSession;

	@Autowired
	private CustomersService todoService;




	@ModelAttribute("userInfoMap")
	public Map<String, String> userInfoMap(HttpServletRequest request){

		log.info("###################################### 2 start ###########################={}", httpSession.toString());


		request.setAttribute("foo", "bar");

		httpSession.setAttribute("createdBy", "admin");
		httpSession.setAttribute("lastModifiedBy", "admin");
		request.setAttribute("createdBy", "admin");
		request.setAttribute("lastModifiedBy", "adminz");


		log.info("httpSession={}", httpSession);
		String id = httpSession.getId();
		String createdBy = (String) httpSession.getAttribute("createdBy");
		String lastModifiedBy = (String) httpSession.getAttribute("lastModifiedBy");
		Map<String, String> userInfoMap = new HashMap<>();
		userInfoMap.put("sessionId", id);
		userInfoMap.put("createdBy", createdBy);
		userInfoMap.put("lastModifiedBy", lastModifiedBy);
		log.info("userInfoMap={}", userInfoMap);

		log.info("###################################### 2 end ###########################={}", httpSession.toString());
		return userInfoMap;
	}

	@PostMapping
	int insert(@RequestBody Customers todo, Model model) {
		log.info("[insert] todo={}", todo);
		log.info("[insert] model={}", model);
		log.info("[insert] model.getAttribute(\"userInfoMap\")={}", model.getAttribute("userInfoMap"));
		Map<String, String> userInfoMap = (Map<String, String>) model.getAttribute("userInfoMap");
		return todoService.insert(todo);
	}



	/**
	 * <pre>
	 * 다중 정렬 : sort=productSid,desc&sort=productName,asc
	 * </pre>
	 * @param todo
	 * @param pageVo
	 * @param page
	 * @param size
	 * @param sort
	 * @param keyword
	 * @param pageable
	 * @return
	 */
	@GetMapping("page")
	Page<Customers> page(
			@RequestBody Customers todo
			,@ModelAttribute Customers pageVo // get 파라미터 ?page=3&size=5&sort=id,desc&keyword=test
//			,@ModelAttribute PageVo pageVo // get 파라미터 ?page=3&size=5&sort=id,desc&keyword=test
//			, @RequestParam(required = false, defaultValue = "0", value = "page") int page
//			, @RequestParam(required = false, defaultValue = "10", value = "size") int size
//			, @RequestParam(required = false, defaultValue = "createdAt", value = "sort") String sort
    		, @RequestParam(name="keyword",required = false) String keyword
    		, @PageableDefault(size = 10) Pageable pageable
//    		, @RequestAttribute Object foo
    		, Model model
	) {
//		http://localhost:8080/todo/page?sort=id,desc&size=1000&keyword=sangbinlee
		log.info("todo={}", todo);
		log.info("pageVo={}", pageVo);
//		log.info("page={}", page);
//		log.info("size={}", size);
//		log.info("sort={}", sort);
		log.info("keyword={}", keyword);
		log.info("pageable={}", pageable);
//		log.info("foo", foo);
		log.info("model", model.toString());

		// get 파라미터를 쓰겠다면
//		if (pageVo.getPage() != null && pageVo.getPage() > 0) {
//			todo.setPage(pageVo.getPage());
//		}
//		if (pageVo.getSize() != null && pageVo.getSize() > 0) {
//			todo.setSize(pageVo.getSize());
//		}
		if (pageVo.getKeyword() !=null) {
			todo.setKeyword(pageVo.getKeyword());
		}
		return todoService.page(todo, pageable);
	}

//    @PostMapping
//	int insert(@RequestBody Todo todo){
//		return todoService.insert(todo);
//	}
//    @GetMapping
//	List<Map<String, Object>> select(@RequestBody Todo todo){
//		return todoService.select(todo);
//	}
	@GetMapping
	List<Customers> select(
//			@RequestBody Todo todo
			) {
		return todoService.select();
//		return todoService.select(todo);
	}
//    @GetMapping
//    Page<Todo> select(@RequestBody Todo todo){
//    	return todoService.select(todo);
//    }

	@PutMapping
	Customers update(@RequestBody Customers todo) {
		return todoService.update(todo);
	}

	@DeleteMapping
	void delete(@RequestBody Customers todo) {
//		todoService.delete(todo);
		todoService.deleteJpa(todo);
	}

}

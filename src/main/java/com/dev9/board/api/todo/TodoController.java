package com.dev9.board.api.todo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * 페이징 소팅 http://localhost:8080/todo?page=3&size=5&sort=id,desc
 */
@Controller
@Slf4j
public class TodoController {

	@Autowired
	HttpSession httpSession;


	@ModelAttribute("userInfoMap")
	public Map<String, String> userInfoMap(HttpServletRequest request) {



		log.info("###################################### start ###########################={}", httpSession.toString());

		request.setAttribute("foo", "bar");

		httpSession.setAttribute("createdBy", "admin");
		httpSession.setAttribute("lastModifiedBy", "admin");

		log.info("httpSession={}", httpSession);
		log.info("httpSession.toString()={}", httpSession.toString());
		String id = httpSession.getId();
		String createdBy = (String) httpSession.getAttribute("createdBy");
		String lastModifiedBy = (String) httpSession.getAttribute("lastModifiedBy");


		log.info("2222 httpSession.toString()={}", httpSession.toString());

		Map<String, String> userInfoMap = new HashMap<>();
		userInfoMap.put("sessionId", id);
		userInfoMap.put("createdBy", createdBy);
		userInfoMap.put("lastModifiedBy", lastModifiedBy);
		log.info("userInfoMap={}", userInfoMap);


		log.info("###################################### end ###########################={}", httpSession.getAttributeNames());
		return userInfoMap;
	}


	@GetMapping("/requestAttribute")
	@ResponseBody
	public String requestAttribute(@RequestAttribute String foo, Model model) {
		log.info("foo={}", foo);
		log.info("model={}", model);
	    return foo;
	}


	@GetMapping("/hi")
	public String redirectAttributes(RedirectAttributes redirectAttributes, Model model) {
		log.info("redirectAttributes={}", redirectAttributes);
		log.info("modelmodel={}", model);
		redirectAttributes.addAttribute("id", 1);
		redirectAttributes.addAttribute("foo", "bar");
		return "redirect:redirectAttributes/"+ redirectAttributes.getAttribute("id") ;
//		return "redirect:redirectAttributes/{id}";
	}

	@GetMapping("/redirectAttributes/{id}")
	public String redirectAttributesHi(@PathVariable Long id, String foo) {
		log.info("id={}", id);
		log.info("foo={}", foo);
		return "success redirect test";
	}

	@GetMapping("/matrix/{id}")
	public String matrix(@PathVariable String id, @MatrixVariable int q) {
		return "test";
	}

	@GetMapping("/page")
	public String page(@PageableDefault(size = 100, page = 1, sort = "id", direction = Direction.ASC) Pageable pageable) {
		return "test";
	}
}

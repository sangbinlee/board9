package com.dev9.board.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {

	@Autowired
	HttpSession httpSession;

	@Override
	public Optional<String> getCurrentAuditor() {
		log.info("###################################### 3 start ###########################={}", httpSession.toString());

		httpSession.setAttribute("createdBy", "admin");
		httpSession.setAttribute("lastModifiedBy", "admin");
		String createdBy = (String) httpSession.getAttribute("createdBy");
		String lastModifiedBy = (String) httpSession.getAttribute("lastModifiedBy");
		log.info("createdBy={}", createdBy);
		log.info("lastModifiedBy={}", lastModifiedBy);

//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = "";
		if (httpSession != null && httpSession.getAttribute("createdBy") != null) {
			userId = createdBy;
			log.info("[자동 세팅 ]userId={}", userId);
		}
		log.info("###################################### 3 end ###########################={}", httpSession.toString());
		return Optional.of(userId);
	}

}

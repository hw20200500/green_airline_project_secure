package com.green.airline.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.websocket.WsFrameClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.airline.dto.response.ResponseDto;
import com.green.airline.handler.exception.CustomRestfullException;
import com.green.airline.repository.interfaces.MemberRepository;
import com.green.airline.repository.interfaces.UserRepository;
import com.green.airline.repository.model.User;
import com.green.airline.service.EmailService;
import com.green.airline.service.UserService;

@RestController
public class UserApiController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private MemberRepository memberRepository;
	
	private User user;
	@GetMapping("/sendNewPw")
	public String sendNewPw(@RequestParam("email") String email, RedirectAttributes redirectAttributes) {
		String code = null;
		try {
			String realEmail = memberRepository.findEmailById(user.getId());
			// 입력한 메일 주소와 해당 계정 이용자의 저장된 메일 주소가 일치하지 않을 경우 오류 메시지 출력
			if (!realEmail.equals(email)) {
				System.out.println("실제 email::"+realEmail);
	            return "different"; 
			}
			
			// 랜덤값으로 만든 임시 비밀번호 이메일로 발송, 해당 비밀번호로 계정 이용자의 비밀번호 업데이트
			code = emailService.sendPwCodeMessage(email);
			userService.updateyPassword(code, user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	/*
	 * 머지할때 오류로 수정 해야함 -정다운
	 * 
	 * @GetMapping("/searchId") public int sendNewPw1( @RequestParam("id") String
	 * id) { int result = 1; System.out.println("id : " + id); User user =
	 * userService.readByid(id); if(user.getId() != id) { result = 0; } return
	 * result; }
	 */
	// 머지할때 오류로 수정 해야함 -정다운
	@GetMapping("/searchId")
	public int sendNewPw1(@RequestParam("id") String id) {
		int result = 1;
		System.out.println("id : " + id);
		user = userService.readByid(id);
		if (user.getId() != id) {
			result = 0;
		}
		return result;
	}

	@GetMapping("/existsById")
	public boolean existsById(@RequestParam String id) {
		User userId = userService.readUserById(id);

		if (userId == null) {
			return true;
		} else {
			return false;
		}
	}
	
}

package com.green.airline.handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.green.airline.handler.exception.UnAuthException;

/**
 * @author 치승
 * 에러페이지 
 */

@ControllerAdvice
@Controller
public class WebErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@GetMapping(ERROR_PATH)
	public String handleError(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null && Integer.parseInt(status.toString()) == HttpStatus.NOT_FOUND.value()) {
			// NOT_FOUND : 404에러
			
			return "layout/errorPage";
		} else if (status != null && Integer.parseInt(status.toString()) == HttpStatus.FORBIDDEN.value()) {
			// FORBIDDEN : 권한 거절
			
			return "layout/errorPage";
		} else if (status!=null && Integer.parseInt(status.toString())==HttpStatus.BAD_REQUEST.value()) {
			return "layout/errorPage";
		}
		return "layout/errorPage";
	}
	
	@ExceptionHandler(UnAuthException.class)
    public ModelAndView handleUnAuthException(HttpServletRequest request, UnAuthException ex) {
        // ModelAndView를 사용해 HTML 오류 페이지로 리다이렉트
        ModelAndView modelAndView = new ModelAndView("layout/errorPage"); // 로그인 필요 페이지
        modelAndView.addObject("error", "Unauthorized");
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setStatus(HttpStatus.UNAUTHORIZED); // 또는 ex.getStatus()로 설정 가능
        return modelAndView;
    }
	
}

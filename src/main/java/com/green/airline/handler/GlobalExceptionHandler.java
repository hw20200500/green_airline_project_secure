package com.green.airline.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.green.airline.handler.exception.CustomRestfullException;
import com.green.airline.handler.exception.UnAuthException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
    
    @ExceptionHandler(UnAuthException.class)
    public ModelAndView handleUnauthorizedError(UnAuthException ex) {
        ModelAndView modelAndView = new ModelAndView("layout/errorPage");
        modelAndView.setStatus(HttpStatus.UNAUTHORIZED); // Set status to 401
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
    
    @ExceptionHandler(CustomRestfullException.class)
    public RedirectView handleCustomException(
            CustomRestfullException ex,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("alertMessage", ex.getMessage());

        // Referer 헤더를 확인
        String referer = request.getHeader("Referer");
        
        // Referer가 없을 경우 현재 요청 URI를 사용
        if (referer == null || referer.isEmpty()) {
            referer = request.getRequestURI(); // 현재 페이지 URI
        }

        return new RedirectView(referer);
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleInternalServerError(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("layout/errorPage");
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}

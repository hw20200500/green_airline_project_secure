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

    // 400 Bad Request 에러 처리
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleBadRequest(HttpServletRequest request, IllegalArgumentException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Bad Request");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("path", request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnAuthException.class)
    public ModelAndView handleInternalServerError(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("layout/errorPage"); // 500 에러 페이지로 리다이렉트
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
    
    @ExceptionHandler(CustomRestfullException.class)
    public RedirectView handleCustomException(
            CustomRestfullException ex,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        // 예외 메시지를 속성으로 저장하여 리다이렉트된 페이지에서 alert로 표시 
        redirectAttributes.addFlashAttribute("alertMessage", ex.getMessage());

     // Referer 헤더를 확인
        String referer = request.getHeader("Referer");
        
        // Referer가 없을 경우 현재 요청 URI를 사용
        if (referer == null || referer.isEmpty()) {
            referer = request.getRequestURI(); // 현재 페이지 URI
        }

        return new RedirectView(referer);
    }
    
    // 기타 다른 예외 처리
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> handleInternalServerError(HttpServletRequest request, Exception ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("error", "Internal Server Error");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("path", request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    
}

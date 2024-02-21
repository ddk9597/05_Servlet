package practice.servlet.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet; // Tomcat이 제공하는 클래스
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PracticeExampleServlit01 extends HttpServlet{
	
//	Get 방식 요청 (method = "get" 인 form 태그 제출	) 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * 매개 변수 req, resp
		 * 	- 클라이언트 요청 시 자동 생성
		 * - req : 
		 * 
		 * HttpServletRequest
		 *  - 클라이언트 요청 시 자동 생성되는 객체
		 *  - 요청 시 전달 된 데이터, 
		 *  	요청한 클라이언트의 정보,
		 *  	요청을 유연하게 처리하기 위한 객체 등을 제공
		 * 
		 * 
		 * HttpServletResponse
		 *  - 클라이언트 요청 시 자동 생성되는 객체
		 *  
		 *  - 서버가 클라이언트에게 응답할 수 있는 방법을 제공하는 객체
		 *  	(서버 -> 클라이언트 출력 스트림(PrintWriter) )
		 * 
		 * */
		
		// 요청 시 함께 제출 된 이름, 나이 얻어오기
		
		// 제출된 이름, 나이 == 전달 인자(Parameter) == 전달된 값 
		
		// * 요청에 담긴 특정 Parameter 얻어오는 방법 *//
		// - String HttpServletRequest.getParameter("name속성 값")
		
		// HTML에서 <input name = "inputName">에 작성되어 제출된 값 얻어오기
		String inputName = req.getParameter("inputName");
		
		// HTML에서 <input name = "inputName">에 작성되어 제출된 값 얻어오기
		String inputAge = req.getParameter("inputAge");
		// -> 반환형 String이다!
		
		
	System.out.println("[서버] /ex1 요청을 받음"); 
	
	System.out.println(" 전달 받은 inputName : " + inputName );
	System.out.println(" 전달 받은 inputAge : " + inputAge );
	}
	
}

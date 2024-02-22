package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.mode.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el") 
// 이 어노테이션으로 인해 index.html에 작성된 "/el"인식하여
// 불려올 수 있음
public class ELServlet extends HttpServlet{

	// a태그 요청 == GET 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpServletRequest 객체에 여러 속성을 추가!
		// - req.setAttribute( "K", "V");
		// -> K : String, V : 자료형 제한 없음
		// 추가된 속성 값은 위임 받은 JSP에서 
		// ${K} 형태로 작성하면 출력시 해당 위치에 V가 출력이 됨
		
		// 기본 자료형
		req.setAttribute("score", 90);
		
		// String
		req.setAttribute("address", "서울시 강동구");
		
		// 컬렉션(List, set, Map)
		List<String> strList = new ArrayList<String>(); // 배열 모양의 List
		
		strList.add("Collection");
		strList.add("List");
		strList.add("Set");
		strList.add("Map");
		
		req.setAttribute("strList", strList);
		
		// DTO
		Book book1 = new Book("시시포스신화", "카뮈", 15000);
		req.setAttribute("book1", book1);
		
		// ---------------------------------------------------------------------
		
		/* null, 빈칸, 비어있음에 대한 EL 처리 확인* */
		 String test1 = null; //null
		 String test2 = ""; // 빈칸
		 List<String> test3 = null; // null
		 List<String> test4 = new ArrayList<String>(); // 비어있는 List
		 List<String> test5 = new ArrayList<String>(); // 비어 있지 않은 List
		 test5.add("aaa");
		 test5.add("bbb");
		 test5.add("ccc");
		  
		  req.setAttribute("test1", test1);
		  req.setAttribute("test2", test2);
		  req.setAttribute("test3", test3);
		  req.setAttribute("test4", test4);
		  req.setAttribute("test5", test5);
		 
		
		
		
		// ---------------------------------------------------------------------
		
		
		// forward : 요청을 위임 (Servlet -> JSP)
		// 원래 Servlet이 요청 받고 결과 화면(Html)만들어 응답해야하는데
		// Java 에서 Html 코드 쓰기 힘들다...
		// -> JSP에게 요청, 응답 객체를 넘겨줘서
		//	  대신 결과 화면 만들고 응답해라
		
		// 1) 요청 위임할 JSP 파일 경로 지정
		String path = "/WEB-INF/views/el/el.jsp";
		
		// 2) 요청 넘겨줄 별도의 객체(요청 발송자, RequestDispatcher 생성)
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// 3) 요청 위임
		dispatcher.forward(req, resp);
		
		
		
		
		
	}
	
	
}

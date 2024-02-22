package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/* Servlet JSP 내장 객체와 범위 */
		
		// 범위 별 내장 객체를 얻어와 여러 값을 세팅, 확인하는 테스트
		
		// 1. page scope -> Jsp에서 확인
		
		// --------------------------------------------- -------------------------------------------- //
		
		// 2. request scope(== HttpServletRequest)
		// - 요청 받은 Servlet/Jsp + 위임 받은 Servlet/Jsp 에서 유지
		
		// ( 위임이 계속되면 request도 계속 유지가 된다)
		
		req.setAttribute("requestMessage", "requestScope 입니다.");
		
		// --------------------------------------------- -------------------------------------------- //
		
		// 3. session Scope(session : 접속)
		// - 클라이언트가 서버에 첫 요청을 할때 생성됨
		//   (== 클라이언트가 사이트에 접속함)
		
		// - 지정된 세션 만료 시간 또는 브라우저 종료 시 까지 유지
		// - session이 유지되는 동안 어디서든 사용이 가능하다(네이버 로그인이 유지되는 블로그, 뉴스, 쇼핑 등...)
		
		// 1) session 객체 얻어오기
		HttpSession session = req.getSession();
		
		// 2) session 객체에 속성 추가하기
		session.setAttribute("sessionMessage", "sessionScope 입니다");
		
		// --------------------------------------------- -------------------------------------------- //
		
		// 4. application Scope
		// - 앱 어플리케이션(서버)당 1개만 존재
		// - 서버 시작 시 생성, 종료 시 소멸
		// -> 종료 전까지 어디서든 사용이 가능하다
		
		ServletContext application = req.getServletContext();
		application.setAttribute("applicationMessage", "applicationScope 입니다");
		
		// --------------------------------------------- -------------------------------------------- //
		
		// 5. 범위별 우선순위 확인
		// - 범위가 좁을수록 우선순위가 높다!!!
		// page > request > session > application
		
		// 모든 범위에 같은 key로 속성을 추가!!!
		req.setAttribute("str", "REQUEST");
		session.setAttribute("str", "SESSION");
		application.setAttribute("str", "APPLICATION");
		
		// --------------------------------------------- -------------------------------------------- //
		
		// forward(요청위임)
		
		String path = "/WEB-INF/views/scope/scope.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp); // 디스패쳐에 path설정 후 바로 forward 실행.
		
	}
	
	
}

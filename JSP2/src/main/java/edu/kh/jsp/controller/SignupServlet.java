package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/signup" )
public class SignupServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/redirect/signup.jsp";
		req.getRequestDispatcher(path).forward(req, resp);	
		
		
		
	
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어오기
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String pwCheck = req.getParameter("pwCheck");
		
		// pw, pwCheck 가 일치하면 "(id)" 회원 가입 성공
		// 일치하지 않으면 "비밀번호 불일치"
		// 메세지를 message 변수에 저장
		
		String message = null;
		if(pw.equals(pwCheck)) {
			
			message = id + "회원가입 성공";
		} else {
			message = "비밀번호 불일치";
		}
		
		// *********** 실행 안되는 경우 ********************** //
		
		// req.setAttribute("message", message);
		
		// 안된다
		// req : 요청이 위임되는 곳에서만 사용 가능함
		// -> redirect(재요청) 수행 시 이전 요청이 담긴 request 객체가 삭제되고 
		// 새로운 요청이 담긴 request 객체가 다시 생성된다!!!
		// -> 이전 request의 message가 세팅되었기 때문에 새로운 request에는 존재하지 않음
		// -> 화면에 출력이 안됨;;
		
		// *********** ************* ********************** //
		
		// 해결 방법   : session 객체를 이용하면 해결 가능하다
		// 왜? session : 창이 닫히거나 만료되기 전 까지 유지되는 객체. 
		// -->redirect를 해도 사라지거나 다시 생성되는 객체가 아니다.
		
		HttpSession session = req.getSession();   // session 객체 얻어오기
		session.setAttribute("message", message); // session에 message 추가

		
		// Servlet 코드 수행이 완료된 후
		// - 원래 존재하던 페이지로 이동하거나
		// - 응답할 화면이 별도로 존재하지 않은 경우
		// **** redirect **** 수행
		
		
		resp.sendRedirect("/signup");
		// -> redirect는 무조건 get방식 요청이다.
		
	}
}

package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> nameList = new ArrayList<String>(); 
		
		nameList.add("강찬혁");
		nameList.add("박세리");
		nameList.add("곽두팔");
		nameList.add("메서드");
		nameList.add("어레이");
		nameList.add("없는이름");
		nameList.add("있는이름");
		nameList.add("헷갈리지");
		
		// 리스트에 입력받은 parameter가 있는지 확인
		
		String inputName = req.getParameter("inputName"); // 입력 받은 이름
		
		
		
		if(nameList.contains(inputName)) { // 존재하는 경우
			
			String searchMessage = String.format("%s은/는 %d 번째 index에 존재합니다", inputName, nameList.indexOf(inputName));
			
			// forward 시 request가 유지된다
			req.setAttribute("searchMessage", searchMessage);
			
			String path = "/WEB-INF/views/practice/searchResult.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			 
		} else { // 존재하지 않는 경우
			
			String searchMessage = inputName + "은/는 존재하지 않습니다";
			
			HttpSession session = req.getSession(); // session 객체 얻어오기
			session.setAttribute("searchMessage", searchMessage); // session에 serachMessage 추가
			
			// "/error" redirect
			resp.sendRedirect("/error"); // redirect는 무조건 GET 방식
			
		}
		
	}
	
	
	
	
}

<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
	
<%-- Servlet Jsp 프로젝트 실행 시 
	/ 주소로요청이 오면
	webapp 폴더에 있는 index.html 또는 index.jsp를 이용해
	메인 페이지 화면을 응답 해준다!!
	(무조건 "/" 요청은 index 파일과 연결이 된다 -> Spring 에서는 해결됨)
	(다른 곳으로 요청 받은 것을 넘겨주는 forward 활용)
	 --> JSP -> Servlet
 --%>
 
 <%-- jsp 액션 태그 : JSP에서 할수 있는 기능을 담은 태그 --%>
 
 <jsp:forward page = "/main" />
 <%-- 
 	"/" 요청이 오면 index로 무조건 간다.
 	이것을 "/main" 요청을 처리하는 Servlet 에게 forward 하는 코드
 	
 	++ "/main" 으로 forward 하는게 아니다!!!
 	
  --%>>
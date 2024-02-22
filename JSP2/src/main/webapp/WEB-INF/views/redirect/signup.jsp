<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect 확인하기</title>
</head>
<body>

	<!-- session에  message가 존재하면 출력됨 -->
	<h1>${message }</h1>
	
	<%
	session.removeAttribute("message"); // session에 존재하는 속성 중 message를 제거한다.
	// -> redirect시 데이터를 유지하기 위해 session을 이용했는데 계속 남아있는 문제 해결
	// -> 1회성으로 사용 가능하게 한다. 1회 출력 후 session에서 데이터를 제거
	%>

	<hr>
	
	<h1>회원 가입</h1>
	
	<form action="signup" method = "post">
	 <div>
	 	ID : <input type="text" name = "id">
	 </div>
	 
	 <div>
	 	PW : <input type="password" name = "pw">
	 </div>
	 
	 <div>
	 	Pw check : <input type="password" name = "pwCheck">
	 </div>
	 
	 <button> 회원 가입</button> 
	 
	 
	 
	 
	
	 </form>)


</body>
</html>
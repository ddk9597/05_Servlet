package practice.servlet.pizza;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servletPractice_01")
public class ServletPractice_pizzaOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어오기
		String pizza = req.getParameter("pizza"); // 피자 주문하기
		String size = req.getParameter("size"); // 사이즈 정하기
		String ordererName = req.getParameter("ordererName");
		String ordererAddress = req.getParameter("ordererAddress");
		
		// 동시에 여러 파라미터 얻어오기
		String [] options = req.getParameterValues("opt");
		
		System.out.println("servletPractice_01 요청됨");
		
		// 옵션(종류, 사이즈, 사이드메뉴) 에 따라 달라지는 가격 계산
		
		int price = 0;
		
		// 종류별 금액 변동
		switch(pizza) {
		case "치즈" : price += 12000 ; break;
		case "페퍼로니" : 
		case "하와이안" : price += 14000 ; break;
		case "불고기" : price += 15000 ; break;
		}
		
		// 사이즈별 금액 변동
		if ("medium".equals(size)) {
		    price += 0;
		}
		if ("large".equals(size)) {
		    price += 5000;
		}
		if ("family".equals(size)) {
		    price += 8000;
		}
		
		// 옵션 또는 사이드메뉴별 금액 변동
		if(options != null) {
			
			for(String opt : options) {
				
				switch(opt) {
				case "콜라 사이즈 업" 	: price += 1500 ; break; 
				case "치즈추가" 			: price += 2000 ; break; 
				case "치즈크러스트" 	: price += 3000 ; break; 
				case "버팔로윙" 		: price += 8000 ; break; 
				
				}
			
			
			}
			
		}
		
		// 응답 형태 지정
		resp.setContentType("text/html; charset=utf-8");
		
		// 응답 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		StringBuilder sb = new StringBuilder(); 
		
		sb.append("<DOCTYPE html>");
		sb.append("<html>");
			sb.append("<head>");
				sb.append("<title>");
					sb.append(String.format("%s 님 주문 영수증", ordererName) );
					
				sb.append("</title>");
				
			sb.append("<body>");
			
				sb.append("<h3>");
					sb.append(String.format("주문자 명 : %s", ordererName) );
				sb.append("</h3>");
			
				sb.append(String.format("<h3>주소 : %s</h3>", ordererAddress));
				
				sb.append("<ul>");
					sb.append(String.format("<li> 피자 : %s </li>", pizza));
					
					String temp;
					if(size == "medium" ) {
						temp = "medium" ;
					} else if (size == "large") {
						temp = "large";
					} else temp = "family";
					
					if(options != null) {
						
						sb.append("<li>");
							sb.append(" 선택한 옵션 : ");
							for(String opt : options) sb.append(opt + " ");
						sb.append("</li>");
						
					}
							
				sb.append("</ul>");
				
				sb.append(String.format("<h3>금액 : %d 원</h3>", price) );
				
			sb.append("</body>");
				
			sb.append("</head>");
		sb.append("</html>");
		
		out.print(sb.toString());
		
		
	}
	
	
}

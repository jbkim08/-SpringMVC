package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Test2Service;


@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청한 주소를 가져오기
		String url = request.getRequestURI();
		//System.out.println(url);
		String viewName = "";
		
		if(url.contains("main.mvc")) {
			viewName = "main.jsp";
		} else if(url.contains("test1.mvc")) {
			// 파라미터 데이터 추출
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			// 파라미터 값을 숫자로 변환
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			int result = number1 + number2;
			
			request.setAttribute("result", result); //리퀘스트객체에 데이터 담기

			viewName = "test1.jsp";
		} else if(url.contains("test2.mvc")) {
			
			int result = Test2Service.minus(request);
			
			request.setAttribute("result", result); //리퀘스트객체에 데이터 담기
			
			viewName = "test2.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
		
	}
}

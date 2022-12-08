package model;

import javax.servlet.http.HttpServletRequest;

public class Test2Service {

	public static int minus(HttpServletRequest request) {
		// 파라미터 데이터 추출
		String str1 = request.getParameter("data1");
		String str2 = request.getParameter("data2");
		// 파라미터 값을 숫자로 변환
		int number1 = Integer.parseInt(str1);
		int number2 = Integer.parseInt(str2);
		int result = number1 - number2;
		
		return result;
	}
}

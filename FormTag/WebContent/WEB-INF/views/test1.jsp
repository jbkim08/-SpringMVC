<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<form action="result" method="post">
		이름 : <input type='text' name='user_name' value="${requestScope.userDataBean.user_name }"/><br/>
		아이디 : <input type='text' name='user_id' value='${requestScope.userDataBean.user_id }'/><br/>
		비밀번호 : <input type='password' name='user_pw' value='${requestScope.userDataBean.user_pw }'/><br/>
		우편번호 : <input type='text' name='user_postcode' value='${requestScope.userDataBean.user_postcode }'/><br/>
		주소1 : <input type='text' name='user_address1' value='${requestScope.userDataBean.user_address1 }'/><br/>
		주소2 : <input type='text' name='user_address2' value='${requestScope.userDataBean.user_address2 }'/><br/>
		<button type='submit'>확인</button>
	</form>
</body>
</html>
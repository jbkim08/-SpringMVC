<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품입력</h1>
	<form:form action='input_product_proc' modelAttribute="product" method='post'>
		상품명 : <form:input path="name"/><br/>
			<form:errors path='name'/><br/>
		이메일 : <form:input path="email"/><br/>
			<form:errors path='email'/><br/>
		가격 : <form:input path="price"/><br/>	
			<form:errors path='price'/><br/>
			
		<form:button type='submit'>확인</form:button>
	</form:form>

</body>
</html>
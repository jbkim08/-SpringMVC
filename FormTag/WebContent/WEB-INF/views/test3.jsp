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
	<h1>test3</h1>
	<form:form action='result' modelAttribute="dataBean">
		<form:select path="a1">
			<form:option value="select1">선택1</form:option>
			<form:option value="select2">선택2</form:option>
			<form:option value="select3">선택3</form:option>
		</form:select>

		<hr/>
		<form:checkbox path="a2" value="check1"/>체크1
		<form:checkbox path="a2" value="check2"/>체크2
		<form:checkbox path="a2" value="check3"/>체크3
		
		<hr/>
		<form:radiobutton path="a3" value="radio1"/>항목1
		<form:radiobutton path="a3" value="radio2"/>항목2
		<form:radiobutton path="a3" value="radio3"/>항목3
	
	</form:form>
</body>
</html>
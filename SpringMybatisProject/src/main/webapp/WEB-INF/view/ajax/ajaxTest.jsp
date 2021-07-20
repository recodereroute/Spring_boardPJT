<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxTest.jsp</title>
<script type="text/javascript">
	function testDiv(num){
		if(num == 1){
			op1.style.display="";
			op2.style.display="none";
			op3.style.display="none";
		}else if(num == 2){
			op1.style.display="none";
			op2.style.display="";
			op3.style.display="none";
		}else if(num == 3){
			op1.style.display="none";
			op2.style.display="none";
			op3.style.display="";
		}
	}
</script>
</head>
<body>
<ul>
	<li onclick = "testDiv(1)">경력3년이상</li>
	<li onclick = "testDiv(2)">경력5년이상</li>
	<li onclick = "testDiv(3)">경력10년이상</li>
</ul>
</body>
</html>
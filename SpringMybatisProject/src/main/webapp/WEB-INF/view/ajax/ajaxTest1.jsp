<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxTest1.jsp</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn2").click(function(){
		//$("#frm").submit();
		$("#frm").ajaxSubmit({
			type : "post",
			url : "ajaxTest1",
			dataType : "html",
			success : function(result){
				$("#notice_content").html(result);
			},
			error : function(){
				alert("에러가 발생했습니다.");
				return;
			}
		});
	});
	$("#btn3").click(function(){
		//$("#frm").submit();
		var option = {
			type : "post",
			url : "ajaxTest1",
			dataType : "html",
			success : function(result){
				$("#notice_content").html(result);
			},
			error : function(){
				alert("에러가 발생했습니다.");
				return;
			}
		}
		$("#frm").ajaxSubmit(option);
	});
	$("#btn4").click(function(){
		//$("#frm").submit();
		var option = {
			type : "post",
			url : "ajaxTest1",
			dataType : "html",
			beforeSubmit : beforeTest, //익명 함수가 아닌 함수를 부를때는 함수명만
			success : okTest,
			error : err
		}
		$("#frm").ajaxSubmit(option);
	});
});
	function err(){
		alert("에러가 발생하였습니다.");
		return false;
	}
	function okTest(responseText, statusText, xhr, $form){//ajax가 실행되면 이 4개의 값을 반환한다.
		if(statusText == "success"){
			$("#notice_content").html(responseText);
			$form.css('background', 'red');
		}
	}
	function beforeTest(){
		if($("#n").val() == ""){
			alert("값을 입력해주세요.");
			$("#n").focus();
			return false;
		}else{
			alert("ajax가 submit하기전에 실행되는 함수");
		}
	}
	function testDiv(num){
		//location.href="ajaxTest1?n="+num //동기식
		$.ajax({ //비동기식 - jquery.form.js가 있어야만 사용가능
			type : "post",
			url : "ajaxTest1",// 여기로부터 받아온 값
			dataType : "html",//보여주려는 결과 data-type
			data : "n="+num,
			//익명함수(이름이 없는 함수) : 직접 실행시킬수 없음 - 실행시키기 위한 객체가 필요
			success : function(result){//result : data 넘겨줘서 나온 동기식 결과 페이지
				$("#notice_content").html(result);
			},
			error : function(){
				alert("에러가 발생했습니다.");
				return;
			}
		});
	}
</script>
</head>
<body>
	<ul>
		<li onclick = "testDiv(1)">경력3년이상</li>
		<li onclick = "testDiv(2)">경력5년이상</li>
		<li onclick = "testDiv(3)">경력10년이상</li>
	</ul>
	<div id = "notice_content"></div>
<form name = "frm" id = "frm" >
	<input type = "text" id = "n" name="n"/>
</form>
	<button id = "btn2">버튼2</button>
	<button id = "btn3">버튼3</button>
	<button id = "btn4">버튼4</button>
</body>
</html>
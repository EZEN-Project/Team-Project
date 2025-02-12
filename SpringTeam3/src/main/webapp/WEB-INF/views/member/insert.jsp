<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript">

</script>
</head>
<body>

	<div class="container">
		<div class="row">	
			<div class="col-md-12">
	        <div class="py-7">
	            <div class="text-center">
	            <h2>회원가입</h2>
	            <p class="lead">회원가입하세요.</p>
	            </div>
	        </div>
	       
	        	<form action="/member/insert" id="form" name="form" method="post">
	        	 
	        	 <div class="form-group">
		        	  <div class=".col-xs-12 .col-md-8">
					    <div class="input-group">
					      <span id="span1" class="input-group-addon">ID</span>
					     	 <input name="id" id="id" class="form-control" placeholder="id는 영문 숫자 4~12글자 사이로 입력해 주세요">
					      <span class="input-group-btn">
					        <button id="btnID" class="btn btn-default" type="button">ID 중복체크</button>
					      </span>
					    </div><!-- /input-group -->
					  </div><!-- /.col-lg-6 -->
				  </div><!-- /.form-group -->
				  
				  <div class="form-group">
					<div class=".col-xs-12 .col-md-8">
						<div class="input-group">
						  <span class="input-group-addon" id="email">email</span>
						  <input name="email" type="email" class="form-control" required placeholder="email 입력하세요" aria-describedby="email">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class=".col-xs-12 .col-md-8">
						<div class="input-group">
						  <span class="input-group-addon" id="pw1">비빌번호</span>
						  <input name="pw" type="password" class="form-control" required placeholder="Password" aria-describedby="pw1">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class=".col-xs-12 .col-md-8">
						<div class="input-group">
						  <span class="input-group-addon" id="pw2">비빌번호확인</span>
						  <input name="pw2" type="password" class="form-control" required placeholder="Password" aria-describedby="pw2">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class=".col-xs-12 .col-md-8">
						<div class="input-group">
						  <span class="input-group-addon" id="nameSp">이름</span>
						  <input id="name" name="name" type="text" class="form-control" required placeholder="2~6글자의 한글로 입력하세요" aria-describedby="nameSp">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class=".col-xs-12 .col-md-8">
						<div class="input-group">
						  <span class="input-group-addon" id="phoneSp">전화번호</span>
						  <input id="phone" name="phone" type="tel" maxlength="11" class="form-control" required placeholder="전화번호를 -를 제외하고 입력하세요" aria-describedby="phoneSp">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class=".col-xs-12 .col-md-8">
						<div class="input-group">
						  <span class="input-group-addon" id="birthSp">생일</span>
						  <input id="birth" name="birth" type="date" class="form-control" required aria-describedby="birthSp">
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class=".col-xs-12 .col-md-8">
						<div class="input-group">
							<input type="button" id="addsearch" class="btn btn-default" onclick="sample4_execDaumPostcode()" value="주소 검색"><br>
							<input type="text" class="form-control" id="sample4_postcode" readonly placeholder="우편번호"> 
							<input type="text" class="form-control" name="address" id="sample4_roadAddress" required readonly placeholder="도로명주소"> 
							<input type="hidden" class="form-control" id="sample4_jibunAddress" readonly placeholder="지번주소">
							<span id="guide" style="color: #999; display: none"></span> 
							
							<input type="text" class="form-control" id="sample4_detailAddress" placeholder="상세주소">
							<input type="text" class="form-control" id="sample4_extraAddress" placeholder="참고항목">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class=".col-xs-12 .col-md-8">
						<div class="input-group">	
							<input class="btn btn-primary" type="submit" value="가입">
						</div>
					</div>
				</div>
				</form>
				</div>
	        </div><!-- /.row -->
		</div><!--/.container  -->

	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>

  	<script type="text/javascript">
  		var today = new Date();
  		var year = today.getFullYear();
  		  		
		var a = false;// id중복체크 확인용
		$(document).ready(function(){
			$("input[type=submit]").click(function(event) {
				
				var address = $("#sample4_roadAddress").val();
				var idn = $("input[name=id]").val();
				var pw1 = $("input[name=pw]").val();
				var pw2 = $("input[name=pw2]").val();
				var namen = $("input[name=name]").val();
				var idspan = $("#span1").text();
				var ids = $.trim(idspan); // 공백 제거
				var birth = $("#birth").val();
				var birthYear= birth.substring(0,birth.indexOf("-"));
				var phone = $("#phone").val();
				var phoneStart = phone.substring(0,2);
				var kor = /^[가-힣]{2,6}$/;
				var idEng = /^[a-z|A-z|0-9]{4,12}$/;
				
				console.log((!kor.test(namen) || namen.length != $.trim(namen).length));
				
				if(!idEng.test(idn) || idn.length != $.trim(idn).length){
					alert("id는 영문 숫자 4~12글자 사이로 입력해 주세요");
					$("input[name=id]").select();
					$("#id").attr("readonly",false);
					a= false;
					event.preventDefault();
					return;
				} else if(ids != "사용 가능합니다" || !a ){ // 아이디 중복체크 검사
					alert("id 중복체크를 해주세요");
					$("input[name=id]").select();
					event.preventDefault();
					return;
				} else if(pw1.length < 4 || pw1.length != $.trim(pw1).length){
					alert("비밀번호를 4자 이상으로 입력해주세요");
					event.preventDefault();
					return;
				} else if (pw1 != pw2) {//비밀번호 체크
					$("input[name=pw2]").select(); // 드래그 선택됨 
					alert("비밀번호가 같지 않습니다.");
					event.preventDefault();
					return;			
				} else if(!address){
					alert("주소를 입력해주세요");
					$("#addsearch").focus();
					event.preventDefault();
					return;
				} else if((year-Number(birthYear)) <=0 || (year-Number(birthYear)) > 150){
					alert("생년월일이 잘못되었습니다");
					$("#birth").select();
					event.preventDefault();
					return;
				} else if(isNaN(phone) || phone.length != 11 || phone.length != $.trim(phone).length ){// 문자 입력 체크
					alert("잘못된 전화번호: 전화번호를 옮바르게 입력해주세요");
					$("#phone").select();
					event.preventDefault();
					return;
				} else if(phoneStart !="01") {
					alert("잘못된 전화번호: 01로 시작하지 않음");
					$("#phone").select();
					event.preventDefault();
					return;
				}else if(!kor.test(namen) || namen.length != $.trim(namen).length){
					alert("잘못된 이름: 2~6글자의 한글로 입력하세요");
					$("#name").select();
					event.preventDefault();
					return;
				}
				
				
				
				
							
			});
			$("#btnID").click(function(event) {
				event.preventDefault(); 
				var id = $("#id").val();
				if(!id){
					alert("id를 입력해주세요")
					return;
				}
				$.getJSON("/member/idcheck/"+id, function(data) {
					var result = data.result;
					if(result == "o"){
						$("#span1").text("사용 가능합니다");
						$("#id").attr("readonly","readonly");
					}else{
						alert("중복된 아이디 입니다.");
					}
				});
				a = true;
				
			});
			
		});
	</script>
</body>
</html>
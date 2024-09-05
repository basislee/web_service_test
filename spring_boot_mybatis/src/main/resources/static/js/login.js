/**
 * login.js
 */
 
 $(document).ready(function() {
 	// 로그인 폼이 전송(submit) 되었을 때
 	$('#frmLogin').on('submit', function() {
 		event.preventDefault();
 		
 		let user_id = $('#user_id').val();
 		let user_pw = $('#user_pw').val();
 		
 		$.ajax({
 			type:"post",
 			url:"/mybatis/login", 
 			data : {"id": user_id, "pw":user_pw}, /* 컨트롤러에서 받는 이름 id, pw  */
 			dataType:'text', /* 요청하는 데이터 타입 (반환 타입) */
 			success:function(result) {
 				if(result == "success") {
 					alert("로그인 성공");
 				} else {
 					alert("로그인 실패");
 				}
 			},
 			error:function() {
 				alert("실패");
 			},
 			complete:function() {
 				alert("작업을 완료했습니다");
 			}
 		});
 	
 	}); // submit 끝
 
 });
/**
 * prdNoCheck.js
 */
 
 $(document).ready(function() {
 	// prdNoCheckBtn 버튼 클릭했을 때
 	$('#prdNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let prdNo = $('#prdNo').val();
 		
 		if(prdNo == "") {
 			alert("상품번호를 입력하세요");
 			return false;
 		} else { 		
	 		$.ajax({
	 			type:"post",
	 			url:"/mybatis/product/prdNoCheck", 
	 			data : {"prdNo": prdNo}, /* 컨트롤러에서 받는 이름 prdNo  */
	 			dataType:'text', /* 요청하는 데이터 타입 (반환 타입) */
	 			success:function(result) {
	 				if(result == "available") {
	 					alert("사용 가능한 번호입니다");
	 				} else {
	 					alert("사용할 수 없는 번호입니다.");
	 				}
	 			},
	 			error:function() {
	 				alert("실패");
	 			}
	 		});
 		
 		} // else 끝
 	
 	}); // click 끝
 
 });
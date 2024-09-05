/**
 * prdNoCheck.js
    상품번호 중복 확인 : fetch 사용 post 방식
 */
 
 $(document).ready(function() {
 	// prdNoCheckBtn 버튼 클릭했을 때
 	$('#prdNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let prdNo = $('#prdNo').val();
 		
 		if(prdNo == "") {
 			alert("상품번호를 입력하세요.3");
 			//return false;
 		} else { 		
	 		
	 		fetch("/mybatis/product/prdNoCheck3", {
	 			method:'post',
	 			headers: {
	 				'Content-Tyte':'application/json'
	 			},
	 			body: prdNo
	 		})
	 		.then(response => response.text()) // 응답 객체를 text로 파싱(변환)
	 		.then(result => {
	 			if(result == "available") {
	 					alert("사용 가능한 번호입니다.3");
	 			} else {
	 					alert("사용할 수 없는 번호입니다.3");
	 			}
	 		})
	 		.catch(err => console.log(err));
 		
 		} // else 끝
 	
 	}); // click 끝
 
 });
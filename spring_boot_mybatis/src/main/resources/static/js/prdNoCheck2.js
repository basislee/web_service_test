/**
 * prdNoCheck.js
    상품번호 중복 확인 : fetch 사용 get 방식
 */
 
 $(document).ready(function() {
 	// prdNoCheckBtn 버튼 클릭했을 때
 	$('#prdNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let prdNo = $('#prdNo').val();
 		
 		if(prdNo == "") {
 			alert("상품번호를 입력하세요.2");
 			//return false;
 		} else { 		
	 		
	 		fetch("/mybatis/product/prdNoCheck2/" + prdNo)
	 		.then(response => response.text()) // 응답 객체를 text로 파싱(변환)
	 		.then(result => {
	 			if(result == "available") {
	 					alert("사용 가능한 번호입니다.2");
	 			} else {
	 					alert("사용할 수 없는 번호입니다.2");
	 			}
	 		})
	 		.catch(err => console.log(err));
 		
 		} // else 끝
 	
 	}); // click 끝
 
 });
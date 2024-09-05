/**
 * prdNoCheck5.js
    상품번호 중복 확인 : axios 사용 post 방식
 */
 
 $(document).ready(function() {
 	// prdNoCheckBtn 버튼 클릭했을 때
 	$('#prdNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let prdNo = $('#prdNo').val();
 		
 		if(prdNo == "") {
 			alert("상품번호를 입력하세요.5");
 			//return false;
 		} else { 		
	 		
	 		const data = {"prdNo" : prdNo}
	 		axios.post("/mybatis/product/prdNoCheck5", data)
	 		.then(function(response){
	 			console.log(response);
	 			if(response.data == "available") {
	 					alert("사용 가능한 번호입니다.5");
	 			} else {
	 					alert("사용할 수 없는 번호입니다.5");
	 			}
	 		})
	 		.catch((error) => {
	 			console.log(error.response)
	 		})
 		} // else 끝
 	
 	}); // click 끝
 
 });
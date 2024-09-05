/**
 * audioFileUpload.js
 */

$(document).ready(function(){
 	$('#audioFileFrm').on('submit', function() {
 		event.preventDefault();
 		
 		//폼 데이터 읽어오기 
 		 let formData = new FormData($('#audioFileFrm')[0]); // 방법1
 		//let formData = new FormData(document.audioFileFrm); // 방법2 : name 속성 사용
 		
 		// 업로도된 파일명 알아보기 : imageBox에 출력하기 위해 
 		// C:\fakepath\a.mp3파일 경로 및 파일명
 		let fileName = $('#uploadFile').val().split("\\").pop(); // 파일명만 추출 
 		// alert($('#uploadFile').val()); //C:\fakepath\a.mp3
 		//alert(fileName); // apple.mp3
		// 서버로 전송하고 결과 받아서 처리
 		$.ajax({
 			type:"post",
 			url:"/mediaFileUpload", 
 			enctype:"multipart/form-data",
 			processData:false,
 			contentType:false,
 			data : formData, 
 			success:function(result) {
 				if(result == "success") {
 					// 파일 업로드 성공했으면 audioBox에 이미지 출력
 					$('#audioBox').html('<audio src="/audio/' + fileName + '" controls>');
 					// audio : 맵핑 이름 (WebConfig.java에 설정)
 					
 				} 
 			},
 			error:function() {
 				alert("실패");
 			}
 		});
 	});
 
 });
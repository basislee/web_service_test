/**
 * recordFileUpload.js
 */
 
  $(document).ready(function() {
  	
  	//(1) 음성 녹음
  	//////////////////////////////////////////////////////////////////////////
  	const recordBtn = document.getElementById("recordBtn");
  	const stopBtn = document.getElementById("stopBtn");
  	
  	if(navigator.mediaDevices) {
  		var constraints = {
  			audio:true
  		};
  		
  		let chunks = []; // 녹음 데이터 저장하기 위한 변수
  		
  		navigator.mediaDevices.getUserMedia(constraints)
  			.then(stream => {
  				const mediaRecorder = new MediaRecorder(stream);
  				
  				// [녹음] 버튼 눌렀을 때
  				recordBtn.onclick = () => {  
  					mediaRecorder.start(); // 녹음 시작
  					recordBtn.style.background = "red"; // [녹음] 버튼 배경색
  					recordBtn.style.color = "black";
  				}
  				
  				// [정지] 버튼 눌렀을 때
  				stopBtn.onclick = () => {
  					mediaRecorder.stop(); // 녹음 정지
  					recordBtn.style.background = ""; // [녹음] 버튼 배경색 설정한 것 삭제
  					recordBtn.style.color = "";
  				}
  				
  				// chunks에 저장된 녹음 데이터를 audio 양식으로 설정
  				// blob : 녹음 데이터
  				mediaRecorder.onstop = e => {
  					const blob = new Blob(chunks, {
  						'type':'audio/mp3 codecs=opus'
  					});
  				
  				chunks = []; // 초기화 : 초기화하지 않으면 녹음 내용이 누적됨
  				
				// 녹음 내용을 파일로 저장 시 파일명 랜덤 생성
				let rNum = new Date(); // 날짜를 getTime() 사용해서 숫자로 변환해서 사용
				const fileName = rNum.getTime() + "_voiceFile.mp3"; // 파일 이름
				
				// 파일 업로드 하는 함수 호출
				fileUploadFn(blob, fileName); // 음성 데이터, 파일명 전달
  				
  			  }// mediaRcorder.onstop 끝
  			  
  			  // 녹음 시작시킨 상태가 되면 chunks에 녹음 데이터 저장
  			  mediaRecorder.ondataavailable = e => {
  			  		chunks.push(e.data);
  			  };
  			  
  			  }).catch(err => {
  			  		console.log("오류 발생 : " + err);
  			  });
  		
  		}  	//if 끝
    	
  	///////////////////////////////////////////////////////////
  	// (2) 파일 업로드 
  	// 서버에 파일 업로드 하는 함수
	   function fileUploadFn(blob, fileName) {
	   	// 음성 파일을 폼에 추가
	   	let formData = new FormData();
	   	formData.append('uploadFile', blob, fileName);
	   	// name, 데이터, 파일명
	   	
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
	   
	   }
  
  });
  
  
  
  
  
  
  
  
  
  
  
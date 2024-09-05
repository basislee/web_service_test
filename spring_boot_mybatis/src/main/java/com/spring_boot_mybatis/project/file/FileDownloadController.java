package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FileDownloadController {
	// 다운로드 받을 파일 리스트 출력 : upload 폴더의 모든 파일 목록 출력
	@RequestMapping("fileDownloadList")
	public String fileDownloadList(Model model) {
		// "C:/springWorkspace/upload/" 폴더에 있는 전체 파일 목록 가져오기
		File path = new File("C:/springWorkspace/upload");
		String[] fileList = path.list();
		
		model.addAttribute("fileList", fileList);
		
		return "upload/fileDownloadListView";
	}
	
	// 선택한 파일을 다운로드 폴더에 다운로드 함
	@RequestMapping("/fileDownload/{file}")
	public void fileDownload(
			@PathVariable String file,
			HttpServletResponse response) throws IOException {
		
		// 1. 파일 객체 생성
		File f = new File("C:/springWorkspace/upload", file);
		
		// 한글 파일명 인코딩 필요
		// 잘 다운로드되지만 콘솔창 유니코드 예외 해결 위해
		String encodedFileName = new String(
				file.getBytes("UTF-8"), "ISO-8859-1");
		
		// 2. file 다운로드 설정 : response 객체 통해
		response.setContentType("application/download");
		response.setContentLength((int)f.length());
		response.setHeader("Content-Disposition",  
					"attatchment;filename=\"" + encodedFileName + "\"");
		
		// 3. 파일 다운로드 : FileCopyUtils 객체 이용
		// 스프링 프레임워크에 내장된 파일 다운로드 기능
		// InputStream의 내용을 지정한 OutputStream에 복사하고 스트림을 닫음
		FileInputStream fis = new FileInputStream(f); // 다운로드할 파일
		OutputStream os = response.getOutputStream(); // 서버에서 클라이언트로 다운로드
		FileCopyUtils.copy(fis, os); //스트림을 열고, 복사, flush, close 기능 수행
		// 다운로드 폴더로 다운받아짐
		
	}
}
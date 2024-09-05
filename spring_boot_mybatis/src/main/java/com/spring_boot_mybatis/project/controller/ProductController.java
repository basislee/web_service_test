package com.spring_boot_mybatis.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mybatis.project.model.ProductVO;
import com.spring_boot_mybatis.project.service.ProductService;



@Controller
public class ProductController {
	// DI 설정
	@Autowired
	ProductService prdService;
	
	// 시작 시 index 페이지 열기
	@RequestMapping("/") 
	public String viewIndex() {
		return "index"; // index.jsp 파일의 이름 반환
	}
	
	// 전체 상품 조회
	// ProductService 클래스의 listAllProduct() 메소드 호출하기 위해서는 객체 필요
	// @Autowired 어노테이션 사용해서 DI 설정 필요
	@RequestMapping("/product/listAllProduct")
	public String  listAllProduct(Model model) {
		// (1) ProductService 클래스의 listAllProduct() 호출해서 결과 받아옴
		ArrayList<ProductVO> prdList = prdService.listAllProduct();
		
		// (2) Model 설정
		model.addAttribute("prdList", prdList);
		
		// (3) 뷰 페이지 반환
		return "product/productListView";
	}
	
	// 상품 등록 폼 열기
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}

	// 상품 등록 
	// 폼에 입력된 데이터를 ProductVO에 저장
	// ProductService의 insertProduct() 메소드 호출하면서 VO 전달
	// DB 저장 후 '전체 도서 조회' 화면으로 포워딩 : redirect
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductVO vo) {
		prdService.insertProduct(vo);		
		return "redirect:/product/listAllProduct";
		//return "redirect:./listAllProduct";
	}
	
	// 상품 상세 정보 조회
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		// 서비스에게 상품번호 전달하고, 해당 상품 데이터 받아오기
		ProductVO prd = prdService.detailViewProduct(prdNo);
		
		// 뷰 페이지에 출력하기 위해 Model 설정
		model.addAttribute("prd", prd);
		
		return "product/productDetailView";
	}
	
	// 상품 정보 수정 화면 열기
	// 상품 정보를 수정하기 위해 먼저 상품 정보를 출력 : 상세 정보 출력 (입력 폼에)
	// detailViewProduct() 사용해서 정보 먼저 출력
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo, Model model) {
		// 서비스에게 상품번호 전달하고, 해당 상품 데이터 받아오기
		ProductVO prd = prdService.detailViewProduct(prdNo);
		
		// 뷰 페이지에 출력하기 위해 Model 설정
		model.addAttribute("prd", prd);
		
		return "product/updateProductForm"; // 폼에 데이터 출력
	}
	
	// 수정된 데이터 받아서 DB에 저장
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductVO vo) {
		prdService.updateProduct(vo);		
		return "redirect:/product/listAllProduct";
		//return "redirect:./listAllProduct";
	}
	
	// 상품 정보 삭제 
	// 상품번호 전달 받아서 서비스에게 전달 -> dao -> Mapper -> DB에서 삭제
	// 삭제 후 전체 상품 정보 조회 화면으로 이동 : 포워딩
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		prdService.deleteProduct(prdNo);	
		return "redirect:/product/listAllProduct";
		//return "redirect:./listAllProduct";
	}
	
	// 상품번호 중복 확인  방법1 : ajax 사용 post 방식
	@ResponseBody
	@RequestMapping("/product/prdNoCheck")
	public String prdNoCheck(@RequestParam("prdNo") String prdNo) {
		// 서비스 호출해서 DB에 해당 상품번호가 존재 여부 확인
		// 존재하면 상품번호를 받아올 것임
		String prdNo_result = prdService.prdNoCheck(prdNo);
		
		String result = "available";
		if(prdNo_result != null) // 상품번호가 존재한다면
			result = "not_available";
		
		return result;		
	}
	
	// 상품번호 중복 확인  방법2 : ajax 사용 get 방식
	
	
	
	// 상품번호 중복 확인  방법3 : fetch 사용 get 방식
	@ResponseBody
	@RequestMapping("/product/prdNoCheck2/{prdNo}")
	public String prdNoCheck2(@PathVariable String prdNo) {
		// 서비스 호출해서 DB에 해당 상품번호가 존재 여부 확인
		// 존재하면 상품번호를 받아올 것임
		String prdNo_result = prdService.prdNoCheck(prdNo);
		
		String result = "available";
		if(prdNo_result != null) // 상품번호가 존재한다면
			result = "not_available";
		
		return result;		
	}
	
	
	// 상품번호 중복 확인  방법4 : fetch 사용 post 방식
	@ResponseBody
	@RequestMapping("/product/prdNoCheck3")
	public String prdNoCheck3(@RequestBody String prdNo) {
		// @RequestParam("prdNo") 사용하면 오류
		// 서비스 호출해서 DB에 해당 상품번호가 존재 여부 확인
		// 존재하면 상품번호를 받아올 것임
		String prdNo_result = prdService.prdNoCheck(prdNo);
		
		String result = "available";
		if(prdNo_result != null) // 상품번호가 존재한다면
			result = "not_available";
		
		return result;		
	}
	
	// 상품번호 중복 확인  방법5 : axios 사용 get 방식
	@ResponseBody
	@RequestMapping("/product/prdNoCheck4/{prdNo}")
	public String prdNoCheck4(@PathVariable String prdNo) {
		// 서비스 호출해서 DB에 해당 상품번호가 존재 여부 확인
		// 존재하면 상품번호를 받아올 것임
		String prdNo_result = prdService.prdNoCheck(prdNo);
		
		String result = "available";
		if(prdNo_result != null) // 상품번호가 존재한다면
			result = "not_available";
		
		return result;		
	}
	
	// 상품번호 중복 확인  방법6 : axios 사용 post 방식
	@ResponseBody
	@RequestMapping("/product/prdNoCheck5")
	
	//public String prdNoCheck5(@RequestBody String prdNo) {
		// prdNo 값으로 {"prdNo":"1003"} 전달
		//System.out.println(prdNo);
		//String prdNo_result = prdService.prdNoCheck(prdNo);
		
	public String prdNoCheck5(@RequestBody HashMap<String, String> map) {	
		// HashMap으로 받아서 key에 해당되는 value 값(prdNo) 추출해서 서비스로 전달
		String prdNo_result = prdService.prdNoCheck(map.get("prdNo"));
		
		String result = "available";
		if(prdNo_result != null) // 상품번호가 존재한다면
			result = "not_available";
		
		return result;		
	}
	
	// 상품 검색 폼 열기 /product/productSearchForm1'
	@RequestMapping("/product/productSearchForm1")
	public String productSearchForm1() {
		return "product/productSearchForm1";
	}
	
	// 상품 검색 방법1
	// 검색 조건과 keyword 전달 받아서 서비스에게 전달하고 
	// DB에서 검색 결과를 ArrayList로 받아서 Ajax로 전달	
	@ResponseBody
	@RequestMapping("/product/productSearch1")
	public ArrayList<ProductVO> productSearch1(@RequestParam HashMap<String, Object> param) {
		ArrayList<ProductVO> prdList = prdService.productSearch(param);		
		return prdList;
	}

	
	// 상품 검색 폼 열기 /product/productSearchForm2'
	@RequestMapping("/product/productSearchForm2")
	public String productSearchForm2() {
		return "product/productSearchForm2";
	}

	// 상품 검색 방법2
	// 검색 조건과 keyword 전달 받아서 서비스에게 전달하고 
	// DB에서 검색 결과 ArrayList를 Model 설정해 놓고 뷰 페이지 반환
	@RequestMapping("/product/productSearch2")
	public String productSearch2(@RequestParam HashMap<String, Object> param,
														Model model) {
		ArrayList<ProductVO> prdList = prdService.productSearch(param);	
		model.addAttribute("prdList", prdList);
		
		return "product/productSearchResultView";
	}
	
	// 상품 검색 폼 열기 /product/productSearchForm3'
	@RequestMapping("/product/productSearchForm3")
	public String productSearchForm3() {
		return "product/productSearchForm3";
	}
}









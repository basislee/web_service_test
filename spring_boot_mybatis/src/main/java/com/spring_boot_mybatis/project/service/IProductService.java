package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis.project.model.ProductVO;

// 요청 : client(View) -> Controller -> Service -> DAO -> DB
// 응답 : client(View) <- Controller <- Service <- DAO <- DB
public interface IProductService {
	// 규격 지정 : 반드시 구현해야 할 기능들(메소드)을 지정해 놓음
	// 구현 클래스에서 오버라이딩할 추상 메소드 선언
	// public 반환타입 메소드명(매개변수);
	
	// 전체 상품 조회 : DAO에게 요청 -> DB에서 전체 상품(VO 여러 개(ArrayList)) 찾아서 반환
	public ArrayList<ProductVO> listAllProduct(); 
	
	// 상품 정보 등록 : insertProduct() : 1개의 상품 정보를 전달 받아서 DAO에게 전달 -> DB에 저장. 끝(반환 없음)
	public void insertProduct(ProductVO vo);
	
	// 상품 정보 수정 : updateProduct() : 1개의 수정된 상품 정보를 전달 받아서 DAO에게 전달
	//-> DB에 해당 상품의 수정된 값 저장. 끝(반환 없음)
	public void updateProduct(ProductVO vo);
	
	// 상품 정보 삭제 : deleteProduct() : 1개의 상품 정보(기본키만 필요)를 전달 받아서 DAO에게 전달
	// -> DB에서 해당 상품 삭제. 끝(반환 없음)
	public void deleteProduct(String prdNo); 
	
	// 상세 상품 정보 조회 : detailViewProduct() : 1개의 상품 정보(기본키만 필요)를 전달 받아서 DAO에게 전달 
	//-> DB에 해당 상품 1개 찾아서 반환.
	public ProductVO detailViewProduct(String prdNo);
	
	//상품번호 중복 체크 
	public String prdNoCheck(String prdNo); // 상품번호 전달해서 이 번호가 존재하는지 확인
	
	// 상품 검색
	public ArrayList<ProductVO> productSearch(HashMap<String, Object> map);
}









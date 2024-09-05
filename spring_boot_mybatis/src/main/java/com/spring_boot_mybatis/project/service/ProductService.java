package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis.project.dao.IProductDAO;
import com.spring_boot_mybatis.project.model.ProductVO;

@Service
public class ProductService implements IProductService {
	// DI 설정
	// MyBatis인 경우에는 @Autowired만 사용하지 않고 @Quarlifier와 같이 사용
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;

	@Override
	public ArrayList<ProductVO> listAllProduct() {
		return dao.listAllProduct(); // DAO에게서 받은 결과값을 Controller에게 반환
	}

	@Override
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		dao.updateProduct(vo);	
	}

	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo);
	}

	@Override
	public ProductVO detailViewProduct(String prdNo) {		
		return dao.detailViewProduct(prdNo);
	}
	
	@Override
	public String prdNoCheck(String prdNo) {		
		return dao.prdNoCheck(prdNo);
	}

	@Override
	public ArrayList<ProductVO> productSearch(HashMap<String, Object> map) {		
		return dao.productSearch(map);
	}
}

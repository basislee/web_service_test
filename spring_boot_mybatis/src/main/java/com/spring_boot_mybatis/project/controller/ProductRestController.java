package com.spring_boot_mybatis.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_mybatis.project.model.ProductVO;
import com.spring_boot_mybatis.project.service.ProductService;



@RestController
public class ProductRestController {
	@Autowired
	ProductService prdService;
	
	//@ResponseBody 없음
	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductVO> productSearch3(@RequestParam HashMap<String, Object> param) {
		ArrayList<ProductVO> prdList = prdService.productSearch(param);		
		return prdList;
	}
	
}

package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/products")
@Controller
public class ProductsController {
	
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public String list(Model model) {
		
		List<ProductVO> iolist = productDao.selectAll();
		
		model.addAttribute("PRODUCTS", iolist);
		model.addAttribute("BODY", "IO-LIST");
		return "home";
	}
}

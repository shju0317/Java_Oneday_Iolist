package com.biz.iolist.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@Transactional
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String input(Model model) {
		
		LocalDateTime lDateTime = LocalDateTime.now();
		String lDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
		String lTime = DateTimeFormatter.ofPattern("HH:mm:SS").format(lDateTime);
		
		ProductVO productVO = ProductVO.builder()
							.io_date(lDate)
							.io_time(lTime)
							.build();
		
		model.addAttribute("BODY", "IO-WRITE");
		model.addAttribute("productVO", productVO);
		
		return "home";
	}
	
	@Transactional
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String input(@ModelAttribute("productVO") ProductVO productVO) {
		
		log.debug(productVO.toString());
		
		int ret = productDao.insert(productVO);
		if(ret < 1) {
			// insert가 실패했으므로 그에 대한 메시지를 보여주는 페이지로 jump
		}
		
		return "redirect:/products";
	}
}

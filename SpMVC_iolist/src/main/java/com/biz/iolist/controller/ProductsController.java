package com.biz.iolist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/products")
@Controller
public class ProductsController {

	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	@Transactional
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String list(Model model) {

		List<ProductVO> iolist = productService.selectAll();

		model.addAttribute("PRODUCTS", iolist);
		model.addAttribute("BODY", "IO-LIST");
		return "home";
	}

	
	@Transactional
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String input(Model model) {

		LocalDateTime lDateTime = LocalDateTime.now();
		String lDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
		String lTime = DateTimeFormatter.ofPattern("HH:mm:SS").format(lDateTime);

		ProductVO productVO = ProductVO.builder().io_date(lDate).io_time(lTime).build();

		model.addAttribute("BODY", "IO-WRITE");
		model.addAttribute("productVO", productVO);

		return "home";
	}

	@Transactional
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String input(@ModelAttribute("productVO") ProductVO productVO) {

		log.debug(productVO.toString());

		int ret = productService.insert(productVO);
		if (ret < 1) {
			// insert가 실패했으므로 그에 대한 메시지를 보여주는 페이지로 jump
		}

		return "redirect:/products";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String seq) {
		long long_seq = 0;
		try {
			long_seq = Long.valueOf(seq);
		} catch (Exception e) {
			return "view_error";
		}

		productService.delete(long_seq);
		return "redirect:/products";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@ModelAttribute ProductVO productVO, @RequestParam("seq") String seq, Model model) {
		long long_seq = 0;
		try {
			long_seq = Long.valueOf(seq);
		} catch (Exception e) {
			return "view_error";
		}
		
		// update할 데이터를 SELECT해오기
		productVO = productService.findById(long_seq);
		
		// update할 데이터를 model에 심기
		model.addAttribute("ProductVO", productVO);
		
		model.addAttribute("BODY", "IO-WRITE");
		


		
		// 입력폼 화면 열기
		return "/products/io-write";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute ProductVO productVO, Model model) {
		log.debug("UPDATE POST Method");
		log.debug(productVO.toString());
		
		productService.update(productVO);
		
		// 아래 두줄과 같은 의미
		// return "redirect:/blog/view?seq=" + blogVO.getBl_seq();
		// 수정이 완료되면 다시 detail view로 화면을 전환하기
		model.addAttribute("seq", productVO.getIo_seq());
		return "redirect:/products";
	}
}

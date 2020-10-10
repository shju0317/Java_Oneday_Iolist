package com.biz.iolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.ProductVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("productServiceImpl")
public class ProductServiceImplV1 implements ProductService {

	@Autowired
	private ProductDao productDao;

	private List<ProductVO> calcSum(List<ProductVO> iolist) {
		int iSum = 0;
		int oSum = 0;

		for (ProductVO proVO : iolist) {
			if (proVO.isIo_inout()) {
				iSum += (proVO.getIo_price() * proVO.getIo_quan());
			} else {
				oSum += (proVO.getIo_price() * proVO.getIo_quan());
			}

			proVO.setIo_in_sum(iSum);
			proVO.setIo_out_sum(oSum);
		}
		return iolist;
	}

	@Override
	public List<ProductVO> selectAll() {
		List<ProductVO> productVOList = productDao.selectAll();
		return calcSum(productVOList);
	}

	@Override
	public ProductVO findById(Long seq) {
		return productDao.findById(seq);
	}

	@Override
	public int insert(ProductVO vo) {
		return productDao.insert(vo);
	}

	@Override
	public int update(ProductVO vo) {
		return productDao.update(vo);
	}

	@Override
	public int delete(long seq) {
		
		return  productDao.delete(seq);
	}
}

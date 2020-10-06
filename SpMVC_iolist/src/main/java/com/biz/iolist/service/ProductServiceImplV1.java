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
	public ProductVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ProductVO vo) {
		return productDao.insert(vo);
	}

	@Override
	public int update(ProductVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		return  productDao.delete(seq);
	}
}

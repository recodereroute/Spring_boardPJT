package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.GoodsDTO;
import Model.GoodsReviewsDTO;
import repository.GoodsRepository;

public class GoodsDetailService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsDetail(String prodNum, Model model) {
		GoodsDTO dto = goodsRepository.goodsDetail(prodNum);
		//jsp에서는 속성명을 받는다.
		model.addAttribute("goodsCommand", dto); //"식별자"(속성명), 넘겨줄 값(속성값)
	}
}

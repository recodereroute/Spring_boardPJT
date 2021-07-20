package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.CartDTO;
import repository.GoodsRepository;

public class GoodsCartAddService {
	@Autowired
	GoodsRepository goodsRepository;
	public void cartAdd(int cartQty, String prodNum, int prodPrice, Model model, HttpSession session) {
		CartDTO dto = new CartDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		int cartPrice = prodPrice * cartQty;
		
		dto.setCartPrice(cartPrice);
		dto.setCartQty(cartQty);
		dto.setMemId(memId);
		dto.setProdNum(prodNum);
		int i = goodsRepository.cartAdd(dto); //성공하면 1, 실패한 경우0
		model.addAttribute("num", i);//실패한 경우 다시 장바구니에 담으라고 해주기 위해서
	}
}

package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.PaymentDTO;
import repository.GoodsRepository;

public class DoPaymentService {
	@Autowired
	GoodsRepository goodsRepository;
	public void payment(String purchaseNum, String paymentApprPrice, 
					    String paymentNumber, HttpSession session,
					    Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		
		PaymentDTO dto = new PaymentDTO();
		dto.setMemId(memId);
		dto.setPurchaseNum(purchaseNum);
		dto.setPaymentApprPrice(paymentApprPrice);
		dto.setPaymentNumber(paymentNumber);
		dto.setPaymentMethod("카드");
		goodsRepository.payment(dto);
		model.addAttribute("payment",paymentApprPrice);
	}
	
}
package service.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import repository.GoodsRepository;

public class GoodsCartRemoveService {
	@Autowired
	GoodsRepository goodsRepository;
	public void cartRemove(String prodNums, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		String []prodNumMap = prodNums.split(",");
		List<String> cs = new ArrayList<String>();
		for(String prodNum : prodNumMap) {
			cs.add(prodNum);
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("prodNum", cs);
		condition.put("memId" ,memId);
		goodsRepository.cartRemove(condition);
	}
}

package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsCommand;
import service.goods.GoodsDeleteService;
import service.goods.GoodsDetailService;
import service.goods.GoodsListService;
import service.goods.GoodsNumberService;
import service.goods.GoodsUpdateService;
import service.goods.GoodsWriteService;
import validator.GoodsCommandValidate;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsNumberService goodsNumberService;
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@Autowired
	GoodsDeleteService goodsDeleteService;
	
	@RequestMapping("goodsDel")
	public String goodsDel(@RequestParam(value="prodNum")String prodNum, HttpSession session) {
		goodsDeleteService.goodsDel(prodNum, session);
		return "redirect:goodsList";
	}
	
	@RequestMapping(value = "goodsJoin", method = RequestMethod.POST) /// IOC
	public String goodsJoin(HttpSession session,GoodsCommand goodsCommand, Errors errors) {
		new GoodsCommandValidate().validate(goodsCommand, errors);
		if(errors.hasErrors()) {
			return "goods/goodsJoin";
		}
		goodsWriteService.goodsInsrt(goodsCommand, session);
		return "redirect:goodsList";
	}
	//주소와 jsp 파일은 다름을 인지해야함
	@RequestMapping("goodsRegist") /// IOC
	public String goodsRegist(Model model) {
		//Model : 자바에서 만들어진 값을 jsp에 전달하기 위해서 사용
		goodsNumberService.goodsNum(model);
		return "goods/goodsJoin";
	}
	@RequestMapping("goodsList")
	public String list(Model model) {
		goodsListService.goodsList(model);
		return "goods/goodsList";
	}
	// jsp 화면에 있던 쿼리스트링값을 받아오려면 requestParam을 이용
	@RequestMapping("prodDetail")
	public String goodsDetail(Model model,@RequestParam(value = "prodNum") String prodNum) {
		goodsDetailService.goodsDetail(prodNum, model);
		return "goods/goodsDetail";
	}
	@RequestMapping("prodModify")
	public String prodModify(@RequestParam(value="prodNum")String prodNum, Model model) {
		goodsDetailService.goodsDetail(prodNum, model);
		return "goods/goodsModify";
	}
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(GoodsCommand goodsCommand, Errors errors, HttpSession session) {
		new GoodsCommandValidate().validate(goodsCommand, errors);
		if(errors.hasErrors()) {
			//값을 command로 받았으므로 오류가 발생하여 값을 보낼때 다시 command로 전달된다.
			return "goods/goodsModify";
		}
		//파일 저장을 위한 경로를 가져오기 위해 세션 사용 - 로그인값 가져오기 위해 사용하는거 아님.
		goodsUpdateService.goodsUpdate(goodsCommand, session);
		return "redirect:/goods/goodsList";
	}
}
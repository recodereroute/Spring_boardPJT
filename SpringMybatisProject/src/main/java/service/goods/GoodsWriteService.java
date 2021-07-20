package service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.AuthInfoDTO;
import Model.GoodsDTO;
import command.GoodsCommand;
import repository.GoodsRepository;

public class GoodsWriteService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsInsrt(GoodsCommand goodsCommand, HttpSession session) {
		/// goodsCommand가 가지고 있는 값을 디비에 저장하기 위해서는 
		/// DTO에 저장한다.
		GoodsDTO dto = new GoodsDTO();
		AuthInfoDTO authInfoDTO = (AuthInfoDTO)session.getAttribute("authInfo");
		
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdNum(goodsCommand.getProdNum());
		dto.setProdName(goodsCommand.getProdName());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdSupplyer(goodsCommand.getProdSupplyer());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setRecommend(goodsCommand.getRecommend());
		dto.setEmployeeId(authInfoDTO.getGrade());
		
		
		String prodImage = "";
		int i = goodsCommand.getProdImage().length;
		for(MultipartFile mf : goodsCommand.getProdImage()) {
			//확장자를 알기위해서 오리지널 파일 네임을 가져온다.
			String original = mf.getOriginalFilename();
			//확장자 추출
			String originalExt = original.substring(original.lastIndexOf("."));
			//유일한 id부여받음
			String store = UUID.randomUUID().toString().replace("-", "") + originalExt;
			prodImage += store  + ",";
			//파일을 시스템에 저장
			String filePath = session.getServletContext().getRealPath("WEB-INF/view/goods/upload");
			File file = new File(filePath + "/" + store);
			//파일저장
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		dto.setProdImage(prodImage);
		goodsRepository.goodsWrite(dto);
	}
}

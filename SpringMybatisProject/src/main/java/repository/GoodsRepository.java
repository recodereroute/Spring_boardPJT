package repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.CartDTO;
import Model.GoodsDTO;
import Model.GoodsReviewsDTO;
import Model.OrderListDTO;
import Model.PaymentDTO;
import Model.ProductCartDTO;
import Model.PurchaseDTO;
import Model.ReviewDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.goodsMapper";
	String statement;
	
	public void cartRemove(Map<String, Object> condition) {
		statement = namespace + ".cartRemove";
		sqlSession.delete(statement,condition);
	}
	public void cartProdDel(CartDTO dto) {
		statement = namespace + ".cartProdDel";
		sqlSession.delete(statement, dto);
	}
	public GoodsReviewsDTO goodsReviews(String prodNum) {
		statement = namespace + ".goodsReviews";
		return sqlSession.selectOne(statement, prodNum);
	}
	public void reviewUpdate(ReviewDTO dto) {
		statement = namespace + ".reviewUpdate";
		sqlSession.update(statement, dto);
	}
	public ReviewDTO reviewInfo(ReviewDTO dto) {
		statement = namespace + ".reviewInfo";
		return sqlSession.selectOne(statement, dto);
	}
	public void reviewWrite(ReviewDTO dto) {
		statement = namespace + ".reviewWrite";
		sqlSession.insert(statement, dto);
	}
	public void payment(PaymentDTO dto) {
		statement = namespace + ".payment";
		sqlSession.insert(statement,dto);
	}
	public List<OrderListDTO> baseOrderList(String memId){
		statement = namespace + ".baseOrderList";
		return sqlSession.selectList(statement, memId);
	}
	public int purchaseListInsert(CartDTO dto) {
		statement = namespace + ".purchaseListInsert";
		return sqlSession.insert(statement, dto);
	}
	public void cartDelete(CartDTO dto) {
		statement = namespace + ".cartDelete";
		sqlSession.delete(statement, dto);
	}
	public void purchaseInsert(PurchaseDTO dto) {
		statement = namespace + ".purchaseInsert";
		sqlSession.insert(statement, dto);
	}
	public void goodsQtyDown(CartDTO dto) {
		statement = namespace + ".goodsQtyDown";
		sqlSession.update(statement, dto);
	}
	public ProductCartDTO cartList(CartDTO dto) {
		statement = namespace + ".cartList";
		return sqlSession.selectOne(statement, dto);
	}
	public List<String> memProdNum(String memId){
		statement = namespace + ".memProdNum";
		return sqlSession.selectList(statement, memId);
	}
	public int cartAdd(CartDTO dto) {
		statement = namespace + ".cartAdd";
		int i = sqlSession.insert(statement, dto);
		System.out.println("상품이 추가되었습니다.");
		return i;
	}
	public void goodsDel(String prodNum) {
		statement = namespace + ".goodsDel";
		sqlSession.delete(statement, prodNum);
	}
	public void goodsUpdate(GoodsDTO dto) {
		statement = namespace + ".goodsUpdate";
		int i = sqlSession.update(statement, dto);
		System.out.println(i + "개가 수정되었습니다.");
	}
	public String goodsNum() {
		statement = namespace + ".goodsNum";
		return sqlSession.selectOne(statement);
	}
	public List<GoodsDTO> goodsList() {
		statement = namespace + ".goodsList";
		return sqlSession.selectList(statement);
	}
	public void goodsWrite(GoodsDTO dto) {
		statement = namespace + ".goodsWrite";
		sqlSession.insert(statement, dto);
	}
	public GoodsDTO goodsDetail(String prodNum) {
		statement = namespace + ".goodsDetail";
		return sqlSession.selectOne(statement, prodNum);
	}
}
package Model;

public class ProductCartDTO {
	GoodsDTO goodsDTO;
	CartDTO cartDTO;

	public GoodsDTO getGoodsDTO() {
		return goodsDTO;
	}
	public void setGoodsDTO(GoodsDTO goodsDTO) {
		this.goodsDTO = goodsDTO;
	}
	public CartDTO getCartDTO() {
		return cartDTO;
	}
	public void setCartDTO(CartDTO cartDTO) {
		this.cartDTO = cartDTO;
	}
	
}
package cafe.jjdev.mall.vo;

public class Product {
	private int productNo;
	private int productCommonNo;
	private String productColor;
	private int productSize;
	private int productStock;
	
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getProductCommonNo() {
		return productCommonNo;
	}
	public void setProductCommonNo(int productCommonNo) {
		this.productCommonNo = productCommonNo;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public int getProductSize() {
		return productSize;
	}
	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productCommonNo=" + productCommonNo + ", productColor="
				+ productColor + ", productSize=" + productSize + ", productStock=" + productStock + "]";
	}
		
}

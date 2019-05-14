package cafe.jjdev.mall.vo;

public class Category {
	private int CategoryNo;
	private String categoryName;
	private int getCategoryNo;
	
	public int getCategoryNo() {
		return CategoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		CategoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getGetCategoryNo() {
		return getCategoryNo;
	}
	public void setGetCategoryNo(int getCategoryNo) {
		this.getCategoryNo = getCategoryNo;
	}
	
	@Override
	public String toString() {
		return "Category [CategoryNo=" + CategoryNo + ", categoryName=" + categoryName + ", getCategoryNo="
				+ getCategoryNo + "]";
	}
	

	
	
	
}

package admin.category;

public class Category2DepthCodeDTO {
	
	private String categoryCode;
	private String depth2Name;
	
	public Category2DepthCodeDTO() {
		super();
	}

	public Category2DepthCodeDTO(String categoryCode, String depth2Name) {
		super();
		this.categoryCode = categoryCode;
		this.depth2Name = depth2Name;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getDepth2Name() {
		return depth2Name;
	}

	public void setDepth2Name(String depth2Name) {
		this.depth2Name = depth2Name;
	}

	@Override
	public String toString() {
		return "Category2DepthCodeDTO [categoryCode=" + categoryCode + ", depth2Name=" + depth2Name + "]";
	}
	
}

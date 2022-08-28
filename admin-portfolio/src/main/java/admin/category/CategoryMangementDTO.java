package admin.category;

public class CategoryMangementDTO {
	
	private String categoryCode;
	private String largeMenuCode;
	private String largeMenu;
	private String smallMenuCode;
	private String smallMenu;
	private String usage;
	
	public CategoryMangementDTO() {
	
	}

	public CategoryMangementDTO(String categoryCode, String largeMenuCode, String largeMenu, String smallMenuCode,
			String smallMenu, String usage) {
		super();
		this.categoryCode = categoryCode;
		this.largeMenuCode = largeMenuCode;
		this.largeMenu = largeMenu;
		this.smallMenuCode = smallMenuCode;
		this.smallMenu = smallMenu;
		this.usage = usage;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getLargeMenuCode() {
		return largeMenuCode;
	}

	public void setLargeMenuCode(String largeMenuCode) {
		this.largeMenuCode = largeMenuCode;
	}

	public String getLargeMenu() {
		return largeMenu;
	}

	public void setLargeMenu(String largeMenu) {
		this.largeMenu = largeMenu;
	}

	public String getSmallMenuCode() {
		return smallMenuCode;
	}

	public void setSmallMenuCode(String smallMenuCode) {
		this.smallMenuCode = smallMenuCode;
	}

	public String getSmallMenu() {
		return smallMenu;
	}

	public void setSmallMenu(String smallMenu) {
		this.smallMenu = smallMenu;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	@Override
	public String toString() {
		return "CategoryMangementDTO [categoryCode=" + categoryCode + ", largeMenuCode=" + largeMenuCode
				+ ", largeMenu=" + largeMenu + ", smallMenuCode=" + smallMenuCode + ", smallMenu=" + smallMenu
				+ ", usage=" + usage + "]";
	}

}

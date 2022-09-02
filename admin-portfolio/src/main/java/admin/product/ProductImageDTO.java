package admin.product;

public class ProductImageDTO {
	
	private String productCode;
	private String imagePath;
	private String imageName;
	
	public ProductImageDTO() {
		super();
	}

	public ProductImageDTO(String productCode, String imagePath, String imageName) {
		super();
		this.productCode = productCode;
		this.imagePath = imagePath;
		this.imageName = imageName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "ProductImageDTO [productCode=" + productCode + ", imagePath=" + imagePath + ", imageName=" + imageName
				+ "]";
	}

}

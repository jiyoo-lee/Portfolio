package admin.product;

public class ProductDTO {
	
	private String categoryCode;
	private String code;
	private String name;
	private String sub_desc;
	private String price;
	private String discount;
	private String discountPrice;
	private String stock;
	private String usageSale;
	private String earlySoldout;
	private String detailDesc;
	
	public ProductDTO() {

	}

	public ProductDTO(String categoryCode, String code, String name, String sub_desc, String price, String discount,
			String discountPrice, String stock, String usageSale, String earlySoldout, String detailDesc) {
		super();
		this.categoryCode = categoryCode;
		this.code = code;
		this.name = name;
		this.sub_desc = sub_desc;
		this.price = price;
		this.discount = discount;
		this.discountPrice = discountPrice;
		this.stock = stock;
		this.usageSale = usageSale;
		this.earlySoldout = earlySoldout;
		this.detailDesc = detailDesc;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSub_desc() {
		return sub_desc;
	}

	public void setSub_desc(String sub_desc) {
		this.sub_desc = sub_desc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getUsageSale() {
		return usageSale;
	}

	public void setUsageSale(String usageSale) {
		this.usageSale = usageSale;
	}

	public String getEarlySoldout() {
		return earlySoldout;
	}

	public void setEarlySoldout(String earlySoldout) {
		this.earlySoldout = earlySoldout;
	}

	public String getDetailDesc() {
		return detailDesc;
	}

	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}

	@Override
	public String toString() {
		return "ProductDTO [categoryCode=" + categoryCode + ", code=" + code + ", name=" + name + ", sub_desc="
				+ sub_desc + ", price=" + price + ", discount=" + discount + ", discountPrice=" + discountPrice
				+ ", stock=" + stock + ", usageSale=" + usageSale + ", earlySoldout=" + earlySoldout + ", detailDesc="
				+ detailDesc + "]";
	}
}
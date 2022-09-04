package admin.coupon;

public class CouponDTO {

	private long id;
	private String name;
	private String type;
	private String usageStart;
	private String usageEnd;
	private String discountType;
	private String priceOrRate;
	private String minPrice;
	private String imagePath;
	
	public CouponDTO() {
		super();
	}

	public CouponDTO(long id, String name, String type, String usageStart, String usageEnd, String discountType,
			String priceOrRate, String minPrice, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.usageStart = usageStart;
		this.usageEnd = usageEnd;
		this.discountType = discountType;
		this.priceOrRate = priceOrRate;
		this.minPrice = minPrice;
		this.imagePath = imagePath;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsageStart() {
		return usageStart;
	}

	public void setUsageStart(String usageStart) {
		this.usageStart = usageStart;
	}

	public String getUsageEnd() {
		return usageEnd;
	}

	public void setUsageEnd(String usageEnd) {
		this.usageEnd = usageEnd;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getPriceOrRate() {
		return priceOrRate;
	}

	public void setPriceOrRate(String priceOrRate) {
		this.priceOrRate = priceOrRate;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "CouponDTO [id=" + id + ", name=" + name + ", type=" + type + ", usageStart=" + usageStart
				+ ", usageEnd=" + usageEnd + ", discountType=" + discountType + ", priceOrRate=" + priceOrRate
				+ ", minPrice=" + minPrice + ", imagePath=" + imagePath + "]";
	}
	
}

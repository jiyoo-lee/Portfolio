package admin.coupon;

public class CouponDTOBuilder {
	private long id;
	private String name;
	private String type;
	private String usageStart;
	private String usageEnd;
	private String discountType;
	private String priceOrRate;
	private String minPrice;
	private String imagePath;
	
	public CouponDTOBuilder() {
		
	}
	
	public CouponDTOBuilder id(long id) {
		this.id = id;
		return this;
	}
	
	public CouponDTOBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public CouponDTOBuilder type(String type) {
		this.type = type;
		return this;
	}
	
	public CouponDTOBuilder usageStart(String usageStart) {
		this.usageStart = usageStart;
		return this;
	}
	
	public CouponDTOBuilder usageEnd(String usageEnd) {
		this.usageEnd = usageEnd;
		return this;
	}
	
	public CouponDTOBuilder discountType(String discountType) {
		this.discountType = discountType;
		return this;
	}
	
	public CouponDTOBuilder priceOrRate(String priceOrRate) {
		this.priceOrRate = priceOrRate;
		return this;
	}
	
	public CouponDTOBuilder minPrice(String minPrice) {
		this.minPrice = minPrice;
		return this;
	}
	
	public CouponDTOBuilder imagePath(String imagePath) {
		this.imagePath = imagePath;
		return this;
	}
	
	public CouponDTO build() {
		return new CouponDTO(id, name, type, usageStart, usageEnd, discountType, priceOrRate, minPrice, imagePath);
	}
}

package admin.configuration;

public class PaymentConfigDTO {
	private Long id;
	private String bankName;
	private String accountNumber;
	private String creditUsage;
	private String mobileUsage;
	private String voucherUsage;
	private String pointUsage;
	private Integer minUsagePoint;
	private Integer maxUsagePoint;
	private String cashReceiptUsage;
	private String shippingCompanyName;
	private Integer shippingCost;
	private String deliveryDateUsage;
	private String createDatetime;
	
	public PaymentConfigDTO() {
		super();
	}

	public PaymentConfigDTO(Long id, String bankName, String accountNumber, String creditUsage, String mobileUsage,
			String voucherUsage, String pointUsage, Integer minUsagePoint, Integer maxUsagePoint,
			String cashReceiptUsage, String shippingCompanyName, Integer shippingCost, String deliveryDateUsage,
			String createDatetime) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.creditUsage = creditUsage;
		this.mobileUsage = mobileUsage;
		this.voucherUsage = voucherUsage;
		this.pointUsage = pointUsage;
		this.minUsagePoint = minUsagePoint;
		this.maxUsagePoint = maxUsagePoint;
		this.cashReceiptUsage = cashReceiptUsage;
		this.shippingCompanyName = shippingCompanyName;
		this.shippingCost = shippingCost;
		this.deliveryDateUsage = deliveryDateUsage;
		this.createDatetime = createDatetime;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCreditUsage() {
		return creditUsage;
	}

	public void setCreditUsage(String creditUsage) {
		this.creditUsage = creditUsage;
	}

	public String getMobileUsage() {
		return mobileUsage;
	}

	public void setMobileUsage(String mobileUsage) {
		this.mobileUsage = mobileUsage;
	}

	public String getVoucherUsage() {
		return voucherUsage;
	}

	public void setVoucherUsage(String voucherUsage) {
		this.voucherUsage = voucherUsage;
	}

	public String getPointUsage() {
		return pointUsage;
	}

	public void setPointUsage(String pointUsage) {
		this.pointUsage = pointUsage;
	}

	public Integer getMinUsagePoint() {
		return minUsagePoint;
	}

	public void setMinUsagePoint(Integer minUsagePoint) {
		this.minUsagePoint = minUsagePoint;
	}

	public Integer getMaxUsagePoint() {
		return maxUsagePoint;
	}

	public void setMaxUsagePoint(Integer maxUsagePoint) {
		this.maxUsagePoint = maxUsagePoint;
	}

	public String getCashReceiptUsage() {
		return cashReceiptUsage;
	}

	public void setCashReceiptUsage(String cashReceiptUsage) {
		this.cashReceiptUsage = cashReceiptUsage;
	}

	public String getShippingCompanyName() {
		return shippingCompanyName;
	}

	public void setShippingCompanyName(String shippingCompanyName) {
		this.shippingCompanyName = shippingCompanyName;
	}

	public Integer getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Integer shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getDeliveryDateUsage() {
		return deliveryDateUsage;
	}

	public void setDeliveryDateUsage(String deliveryDateUsage) {
		this.deliveryDateUsage = deliveryDateUsage;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	@Override
	public String toString() {
		return "PaymentConfigDTO [id=" + id + ", bankName=" + bankName + ", accountNumber=" + accountNumber
				+ ", creditUsage=" + creditUsage + ", mobileUsage=" + mobileUsage + ", voucherUsage=" + voucherUsage
				+ ", pointUsage=" + pointUsage + ", minUsagePoint=" + minUsagePoint + ", maxUsagePoint=" + maxUsagePoint
				+ ", cashReceiptUsage=" + cashReceiptUsage + ", shippingCompanyName=" + shippingCompanyName
				+ ", shippingCost=" + shippingCost + ", deliveryDateUsage=" + deliveryDateUsage + ", createDatetime="
				+ createDatetime + "]";
	}
	
	
}
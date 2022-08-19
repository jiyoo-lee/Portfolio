package admin;

public class PaymentConfigDTO {
	
	private String bank;
	private String account;
	private String min_point;
	private String max_point;
	private String credit;
	private String mobile;
	private String voucher;
	private String receipt;
	private String shipping_name;
	private String shipping_cost;
	private String delivery_date;
	
	public PaymentConfigDTO() {
		
	}
	
	

	public PaymentConfigDTO(String bank, String account, String min_point, String max_point, String credit,
			String mobile, String voucher, String receipt, String shipping_name, String shipping_cost,
			String delivery_date) {
		super();
		this.bank = bank;
		this.account = account;
		this.min_point = min_point;
		this.max_point = max_point;
		this.credit = credit;
		this.mobile = mobile;
		this.voucher = voucher;
		this.receipt = receipt;
		this.shipping_name = shipping_name;
		this.shipping_cost = shipping_cost;
		this.delivery_date = delivery_date;
	}



	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getMin_point() {
		return min_point;
	}

	public void setMin_point(String min_point) {
		this.min_point = min_point;
	}

	public String getMax_point() {
		return max_point;
	}

	public void setMax_point(String max_point) {
		this.max_point = max_point;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getShipping_name() {
		return shipping_name;
	}

	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}

	public String getShipping_cost() {
		return shipping_cost;
	}

	public void setShipping_cost(String shipping_cost) {
		this.shipping_cost = shipping_cost;
	}

	public String getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	

}

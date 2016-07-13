package entities_2;

public class Fine {
	String customname;
	String phonenumber;
	String roomType;
	String ProOrderTime;
	float FinePrice;
	String FineDate;
	public Fine(String customname, String phonenumber, String roomType,
			String proOrderTime, float finePrice, String fineDate) {
		super();
		this.customname = customname;
		this.phonenumber = phonenumber;
		this.roomType = roomType;
		ProOrderTime = proOrderTime;
		FinePrice = finePrice;
		FineDate = fineDate;
	}
	public String getCustomname() {
		return customname;
	}
	public void setCustomname(String customname) {
		this.customname = customname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getProOrderTime() {
		return ProOrderTime;
	}
	public void setProOrderTime(String proOrderTime) {
		ProOrderTime = proOrderTime;
	}
	public float getFinePrice() {
		return FinePrice;
	}
	public void setFinePrice(float finePrice) {
		FinePrice = finePrice;
	}
	public String getFineDate() {
		return FineDate;
	}
	public void setFineDate(String fineDate) {
		FineDate = fineDate;
	}
}

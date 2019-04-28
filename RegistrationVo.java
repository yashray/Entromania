package Vo;

public class RegistrationVo {

	private int registrationId;
	private String name;
	private String dateofbirth;
	private String 	gender;
	private long mobile;
	private LoginVo loginvo;
	
	public LoginVo getLoginvo() {
		return loginvo;
	}
	public void setLoginvo(LoginVo loginvo) {
		this.loginvo = loginvo;
	}
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobileno) {
		this.mobile = mobileno;
	}
	
	
}

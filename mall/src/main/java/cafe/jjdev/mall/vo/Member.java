/*
	CREATE TABLE `member` (
	`member_no` INT(11) NOT NULL AUTO_INCREMENT,
	`member_id` VARCHAR(45) NOT NULL,
	`member_pw` VARCHAR(45) NOT NULL,
	`member_name` VARCHAR(45) NOT NULL,
	`member_phone` VARCHAR(45) NOT NULL,
	`member_address` VARCHAR(45) NOT NULL,
	`member_gender` VARCHAR(45) NOT NULL,
	`member_level` VARCHAR(45) NOT NULL,
	PRIMARY KEY (`member_no`)
	)
*/

package cafe.jjdev.mall.vo;

public class Member {

	public Member() {
		super();
	}
	private int memberNo;
	private String memberId;
	private String memberPw; 
	private String memberName;
	private String memberPhone;
	private String memberAddress;
	private String memberGender;
	private String memberLevel;
	private String memberEmail;
	private String memberUpdatePw;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberUpdatePw() {
		return memberUpdatePw;
	}
	public void setMemberUpdatePw(String memberUpdatePw) {
		this.memberUpdatePw = memberUpdatePw;
	}
	
	
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberPhone=" + memberPhone + ", memberAddress=" + memberAddress + ", memberGender="
				+ memberGender + ", memberLevel=" + memberLevel + ", memberEmail=" + memberEmail + ", memberUpdatePw="
				+ memberUpdatePw + "]";
	}
	
	
	
}

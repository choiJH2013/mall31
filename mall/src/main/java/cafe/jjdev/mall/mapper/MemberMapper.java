package cafe.jjdev.mall.mapper;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Member;
import cafe.jjdev.mall.vo.UserId;

@Mapper
public interface MemberMapper {
	public Member loginMember(Member member); // 로그인
	public int insertMember(Member member); //회원가입
	public Member getMemberOne(String memberId); // 회원상세정보
	public Member selectUpdate(Member member);	// 비밀번호 변경을위한 밑작업
	public int getMemberUpdatePw(Member member); //비밀번호 변경
	public int getUpdateMember(Member member); //회원정보 수정
	public int deleteMember(Member member);	//회원탈퇴
	public int insertUserId(UserId userId); //회원탈퇴시 입력정보
	public int selectId(Member member); //회원가입시 가입자아이디 중복체크
	public int outSelectId(Member member); // 회원가입시 탈퇴자아이디 중복체크
	public Member searchMemberId(Member member); // 아이디 찾기
	public Member searchMemberPw(Member member); // 비밀번호 찾기
	public Member selectEmail(Member member); // 이메일전송 이메일값 비교
	public int emailUpdateUupw(Member member); // 이메일전송부분 아이디값만으로 비밀번호변경
	
	
}

package cafe.jjdev.mall.service;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.mapper.MemberMapper;
import cafe.jjdev.mall.vo.Member;
import cafe.jjdev.mall.vo.UserId;

@Service
@Transactional
public class MemberService {
	
	@Autowired MemberMapper memberMapper;
    @Autowired public JavaMailSender emailSender;
    
    
	//로그인 매서드
	public Member getMember(Member member) {
		return memberMapper.loginMember(member);
	}
	
	//회원가입 매서드
	public int addMember(Member member) {
		
		int result = memberMapper.selectId(member);
		int result2 = memberMapper.outSelectId(member);
		
		if(result == 1) {
			System.out.println("가입한 아이디중 중복되는 값이 있습니다. addMember() result : " + result);
		} else if(result2 == 1) {
			System.out.println("탈퇴한 아이디중 중복되는 값이 있습니다. addMember() result2 : " + result2);
		}
	
		int re = result + result2;
		
		if(re >= 1) {
			System.out.println("[중복아이디가 있음] 값이담긴채로 리턴");
			
			return re;
		} else {
			System.out.println("[중복아이디가 없음] 값이 없는채로 리턴");
			
			memberMapper.insertMember(member);
			
			return re;
		}
	}
	
	//개인정보 확인 매서드
	public Member getMemberOne(String memberId) {
		System.out.println("[MemberService] memberId : " + memberId);
		return memberMapper.getMemberOne(memberId);
	}
	
	// 비밀번호 확인 후 수정 매서드
	public int passwordUpdate(Member member) {
		System.out.println("[MemberService] member : " + member);
		Member result = memberMapper.selectUpdate(member);

		if(result == null) {
			System.out.println("비밀번호가 다릅니다"); 
			return 0;
		} else {
			System.out.println("아이디 비밀번호 일치 비밀번호 변경 실행");
			return memberMapper.getMemberUpdatePw(member); 
		}
	}
	
	//개인정보 수정 매서드
	public void getUpdateMember(Member member) {
		memberMapper.getUpdateMember(member);
	}
	
	//개인정보 삭제 매서드
	public int removeMember(HttpSession session, Member member) {
		
		Member user = (Member) session.getAttribute("loginMember");
		System.out.println("★★★★★★★★★★★ memberId : " + user.getMemberId());
		System.out.println("★★★★★★★★★★★ memberGender : " + user.getMemberGender());
		
		
		int result = memberMapper.deleteMember(member);
		System.out.println("result : " + result);
		
		if(result == 0) {
			System.out.println("삭제실패");
			return result;
			
		} else {
			//db데이터가 사라져도 세션무효화전에 세션에 담긴값 을 꺼내어서 삭제테이블에 넣자
			
			UserId userId = new UserId();
			userId.setUserId(user.getMemberId());
			userId.setUserGender(user.getMemberGender());
			System.out.println("■■■■■■■■■UserId : " + userId.getUserId());
			System.out.println("■■■■■■■■■UserGender : " + userId.getUserGender());
			
			memberMapper.insertUserId(userId);
			
			//세션 무효화(삭제)
			session.invalidate();
			return result;
		}
	}
	
	// 사용자 Id찾기
	public Member searchMemberId(Member member) {	
		return memberMapper.searchMemberId(member);
	}
	
	// 사용자 Pw찾기 
	public Member searchMemberPw(Member member) {
		return memberMapper.searchMemberPw(member);
	}

	// 입력받은 이메일 과 db이메일 비교
	public Member selectEmail(Member member) {
		
		Member result = memberMapper.selectEmail(member);
		String uupw = null;
		
		if(result == null) {
			
			return result;
			
		} else {

			//이메일 검색후 이메일값 변수에 담음
			String toEmail = result.getMemberEmail();
			String title = "임시비밀번호 발송";
			//임시비밀번호 변수 및 구하기
			
			for(int i=0; i<10; i++) {
				
				uupw = UUID.randomUUID().toString().replace("-", "");
				System.out.println("   " + uupw);
			}
			
			System.out.println("[MemberService] temporaryPassword : " + uupw);
		
			SimpleMailMessage message = new SimpleMailMessage();
			
	        message.setTo(toEmail); 
	        message.setSubject(title); 
	        message.setText(uupw);
	        emailSender.send(message);
	        
	        member.setMemberPw(uupw);
	        memberMapper.emailUpdateUupw(member);
	        System.out.println("[service] member"+member);
	        
	        return member;
		}
		
	}
	
	
	
	
}

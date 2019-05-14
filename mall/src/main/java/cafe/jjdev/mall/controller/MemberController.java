package cafe.jjdev.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cafe.jjdev.mall.service.MemberService;
import cafe.jjdev.mall.vo.Member;

@Controller
public class MemberController {
	//실무에서 사용하는 세션은 서블릿의 세션 스피링의 세션 스프링시큐리트를 쓰는법  우리는 서블릿에서 세션을 가져옴
	@Autowired
	private MemberService memberService;

	
	// 1. 로그인 폼
	@GetMapping("/member/login")
	public String getMember(HttpSession session) {
		System.out.println("로그인 get요청");
		if(session.getAttribute("loginMember") != null) {		
			return "redirect:"+"/";
		} else {
			return "/member/login";  //  member/login.jsp생성 
		}
	}
	
	// 2. 로그인 처리
	@PostMapping("/member/login")
	public String getMember(HttpSession session, Member member) {
		System.out.println("로그인 post요청");
		
		Member loginMember = memberService.getMember(member);
		
		if(loginMember == null) {
			System.out.println("로그인실패");
			return "redirect:"+"/";
		} else {
			System.out.println("로그인성공");
			session.setAttribute("loginMember", loginMember);
		}
		System.out.println("리턴 /맴버/로그인화면");
		return "/member/login";
	}
	
	// 3. 로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		System.out.println("로그아웃요청");
		session.invalidate();
		return "redirect:"+"/";
	}
	
	// 4. 회원가입 폼 GET addMember
	@GetMapping("/member/addMember")
	public String addMember() {
		System.out.println("회원가입폼 리턴");
		return "/member/addMember";
	}
	
	// 5. 회원가입 액션 POST addMember
	@PostMapping("/member/addMember")
	public String addMember(Member member) {
		System.out.println("회원가입 POST매서드 실행");
		int result = memberService.addMember(member);
		System.out.println("회원가입 POST매서드 후 리턴 /member/login 위치");
		
		if(result != 0) {
			System.out.println("회원가입실패");
			
			return "/member/addMember";
		} else {
			System.out.println("회원가입성공");
			
			return "/member/login";
		}	
	}
	
	// 6. 개인정보확인
	@GetMapping("/member/getMemberOne")
	public String getMemberOne(Model model, HttpSession session) {
		System.out.println("개인정보확인 매서드 실행");
		
		System.out.println("session : " + session.getAttribute("loginMember"));
		//세션의 ID값을 활용하자
		Member member = (Member) session.getAttribute("loginMember");
		//세션의 ID값은 유니크키이며 중복되지않는값이며 변동되지 않을꺼이니 db접근할떄 사용하여 새로 업데이트된 db정보들을 가져와서 뷰에 뿌려준다
		Member member2 = memberService.getMemberOne(member.getMemberId());
		model.addAttribute("member", member2);

		return "/member/getMemberOne";
	}
	
	// 7. 비밀번호 수정 폼
	@GetMapping("member/passwordUpdate")
	public String passwordUpdate(Model model, HttpSession session) {
		
		Member member = (Member) session.getAttribute("loginMember");
		model.addAttribute("member", member);
		
		System.out.println("비밀번호 수정 요청 비밀번호 폼 화면출력 리턴");
		return "/member/passwordUpdate";
	}
	
	// 8. 비밀번호 수정 액션
	@PostMapping("/member/passwordUpdate")
	public String passwordUpdate(Model model, Member member) {
		System.out.println("비밀번호 수정 액션 실행 입력값 memberId,Pw,UpPw : " + member);
			int result = memberService.passwordUpdate(member);
			
			if(result == 0) {
				System.out.println("비밀번호 불일치");
				model.addAttribute("member", member);
				return "/member/passwordUpdate";
				
			} else {
				System.out.println("비밀번호 일치");

				return "redirect:"+"/member/getMemberOne";
			}
	}

	// 9. 회원정보 수정 폼
	@GetMapping("/member/getUpdateMember")
	public String getUpdateMember(Model model, HttpSession session) {
		//세션의 값을 활용하자
		Member member = (Member) session.getAttribute("loginMember");
		Member member2 = memberService.getMemberOne(member.getMemberId());
		model.addAttribute("member", member2);
		
		return "/member/getUpdateMember";
	}
	
	// 10. 회원정보 수정 액션
	@PostMapping("/member/getUpdateMember")
	public String getUpdateMember(Member member) {
		System.out.println("Member : " + member);

		memberService.getUpdateMember(member);

		return "redirect:"+"/member/getMemberOne";
	}
	
	// 11. 회원탈퇴 폼 MemberController.removeMember -> removeMember.jsp
	@GetMapping("/member/removeMember")
	public String removeMember(Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("loginMember");
		model.addAttribute("member", member);
		
		return "/member/removeMember";
	}
	
	// 12. 회원탈퇴 액션 MemberController.removeMember -> MemberService.removeMember ->
	@PostMapping("/member/removeMember")
	public String removeMember(HttpSession session, Member member) {
		int result = memberService.removeMember(session, member);
		
		if(result == 0){
			System.out.println("탈퇴실패 이동");
			
			return "/member/removeMember";
			
		} else {
			System.out.println("탈퇴성공 이동");
			
			return "redirect:"+"/";
		}
	}
	
	// 13. 아이디 찾기 폼
	@GetMapping("/member/searchMemberId")
	public String searchMemberId() {
		
		return "/member/searchMemberId";
	}
	
	// 14. 아이디 찾기 액션
	@PostMapping("/member/searchMemberId")
	public String searchMemberId(Model model, Member member) {
		Member searchId = memberService.searchMemberId(member);
		System.out.println("searchId " + searchId);
		
		model.addAttribute("searchId", searchId);
		
		return "/member/searchMemberIdView";
	}

	// 15. 전화번호로 비밀번호 찾기
	@GetMapping("/member/selectSearchMemberPwPhone")
	public String selectSearchMemberPwPhone() {
		return "/member/selectSearchMemberPwPhone";
	}	
	// 15-2. 이메일로 비밀번호 찾기
	@GetMapping("/member/selectSearchMemberPwEmail")
	public String selectSearchMemberPwEmail() {
		return "/member/selectSearchMemberPwEmail";
	}
	
	// 16. 비밀번호 찾기 액션
	@PostMapping("/member/searchMemberPw")
	public String searchMemberPw(Model model, Member member) {
		System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎ Memeber" + member);
		Member searchPw = memberService.searchMemberPw(member);
		System.out.println("＠＠＠＠＠＠＠＠＠＠＠＠＠＠ searchPw" + searchPw);
		
		model.addAttribute("searchPw", searchPw);
		return "/member/searchMemberPwView";
	}
	
	// 17. 이메일 전송으로 비밀번호 찾기 폼
	@GetMapping("/member/searchEmailMemberPw")
	public String emailSearchMemberPw() {
		System.out.println("이메일전송 메소드 실행");

		return "/member/searchEmailMemberPw";
	}
	
	// 18. 이메일 전송으로 비밀번호 찾기 액션
	@PostMapping("/member/searchEmailMemberPw")
	public String emailSearchMemberPw(Model model, Member member) {
		System.out.println("이메일전송 액션");
	
		//입력받은 이메일 db이메일과 일치하는지 확인
		Member result = memberService.selectEmail(member);
		
		if(result == null) {
			System.out.println("이메일을 찾을 수 없습니다");
			
			return "/member/searchEmailMemberPw";
		} else {
			System.out.println("이메일을 찾았습니다 이메일로 임시비밀번호를 발송하였습니다.");
			
			model.addAttribute("member", result);
			return "/member/searchEmailMemberPwView";
		}
	}
	
	
	// 내일과제
	// 아이디찾기,비밀번호찾기는 팀과제
	// member_out_id 테이블 생성 후 탈퇴시 사용ID 저장
	
	
}

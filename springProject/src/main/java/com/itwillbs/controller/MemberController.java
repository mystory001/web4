package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	//member관련 들고오기
	
	//부모(인터페이스) = 자식(인터페이스를 상속받은 클래스) 객체 생성
	
	
	//MemberService 객체 생성 → 멤버 변수
//	MemberService memberService = new MemberService(); 자바단 안에서 객체 생성
	//멤버변수를 정의하고 root-context.xml에서 객체를 생성해서 멤버 변수에 전달(주입)
	//의존관계주입(DI, Dependency Injection) : 스프링에서 객체를 생성하는 방식
	private MemberService memberService;
	
	//1) memberService를 받는 생성자 준비 
	//   → root-context.xml에서 생성자를 통해서 객체생성값 전달
//	@Inject
//	public MemberController(MemberService memberService) {
//		System.out.println("MemberController 생성자");
//		this.memberService = memberService;
//	}
	
	//2) memberService를 받는 set메소드 준비
	//	 → root-context.xml에서 set메소드를 통해서 객체생성값 전달 
	@Inject
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	
	
	
	
	
	//가상주소 /member/insert → /WEB-INF/view/member/insert.jsp연결
	//http://localhost:8080/myweb/member/insert 가상주소
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		//  /insert → /WEB-INF/views/member/insert.jsp 주소 변경 없이 이동하는 방식(forword)
		return "/member/insert";
	}
	
	//http://localhost:8080/myweb/member/insertPro 가상주소(POST 방식)
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
//	public String insertPro(사용하고자 하는 값의 변수 정의)
		//insert.jsp 태그 이름 id,pw,name와 
		//MemberDTO 멤버변수 이름 id,pw,name이 일치하면 자동으로 동작
		System.out.println("MemberController insertPro()");
		//회원가입처리
		//request 한글처리
//		try {
//			request.setCharacterEncoding("utf-8");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		//request 태그이름에 해당하는 파라미터 값을 가져오기 → 변수에 저장
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		
//		//패키지 com.itwillbs.domain 파일 MemberDTO(MemberBean, MemberVO)
//		//MemberDTO 객체 생성
//		//애노테이션이 없기 때문에 web.xml에 작성할 필요가 없다
//		MemberDTO memberDTO = new MemberDTO();
//		//set 메소드 호출. 값을 저장
//		memberDTO.setId(id);
//		memberDTO.setPw(pw);
//		memberDTO.setName(name);
		
		//출력 get 메소드 호출
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPw());
		System.out.println(memberDTO.getName());
		
		//처리 작업 패키지 com.itwillbs.service 파일 MemberService
		//→ 리턴형 없는 insertMember(memberDTO 주소) 메소드 정의
		//패키지 		 com.itwillbs.dao 	  파일 MemberDAO
		//→ 리턴형 없는 insertMember(memberDTO 주소) 메소드 정의

		//MemberService insertMember() 메소드 호출
		memberService.insertMember(memberDTO);
		
		// /member/login 주소 변경하면서 이동(redirect:)
		return "redirect:/member/login";
	}
	
	//가상주소 /member/login → /WEB-INF/view/member/login.jsp연결
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "/member/login";
	}
	
	//http://localhost:8080/myweb/member/loginPro 가상주소(POST 방식)
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("MemberController loginPro()");
		//로그인 처리
		
		// /member/main 주소 변경하면서 이동(redirect:)
		return "redirect:/member/main";
	}
	
	//가상주소 /member/main → /WEB-INF/view/member/main.jsp연결
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		return "/member/main";
	}
	
	//가상주소 /member/info → /WEB-INF/view/member/info.jsp연결
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info() {
		return "/member/info";
	}
	
	//가상주소 /member/update → /WEB-INF/view/member/update.jsp연결
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		return "/member/update";
	}
	
	//http://localhost:8080/myweb/member/updatePro 가상주소(POST 방식)
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro() {
		System.out.println("MemberController updatePro()");
		//회원가입처리
		
		// /member/main 주소 변경하면서 이동(redirect:)
		return "redirect:/member/main";
	}
	
	//가상주소 /member/delete → /WEB-INF/view/member/delete.jsp연결
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		return "/member/delete";
	}
	
	//http://localhost:8080/myweb/member/deletePro 가상주소(POST 방식)
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro() {
		System.out.println("MemberController deletePro()");
		//회원가입처리
		
		// /member/main 주소 변경하면서 이동(redirect:)
		return "redirect:/member/login";
	}
	
}//닫는 괄호

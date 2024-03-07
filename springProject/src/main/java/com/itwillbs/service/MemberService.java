package com.itwillbs.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

public class MemberService {

	//MemberDAO 객체 생성 → 멤버 변수
//	MemberDAO memberDAO = new MemberDAO();
	private MemberDAO memberDAO;
	
	//set 메소드 정의
	@Inject
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	//리턴형 없는 insertMember(memberDTO 주소) 메소드 정의
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberService insertMember()");
		
		//가입날짜 설정
		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));

			//MemberDAO insertMember() 메소드 호출
			memberDAO.insertMember(memberDTO);

	}
	
	
}// 닫는 괄호

package com.itwillbs.dao;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.itwillbs.domain.MemberDTO;

public class MemberDAO {
	
	//멤버변수 정의 javax.sql.DataSource
//	private DataSource dataSource;
	//스프링에서 디비연결 정보를 받아서 sql구문을 실행하는 프로그램 제공(테스트용으로해보기)
	private SimpleJdbcTemplate jdbcTemplate;
	
	
	
	//set 메소드
	@Inject
	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	
	
	//리턴형 없는 insertMember(memberDTO 주소) 메소드 정의
	String sql = "insert into members(id,pw,name,date) values(?,?,?,?)";
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO insertMember()");
		jdbcTemplate.update(sql, memberDTO.getId(),memberDTO.getPw(),memberDTO.getName(),memberDTO.getDate());
		
		
	}

	

}// 닫는 괄호

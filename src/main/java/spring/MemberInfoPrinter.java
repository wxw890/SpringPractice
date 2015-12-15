package spring;

import org.springframework.beans.factory.annotation.Autowired;

//선택된 멤머 리스트를 출력해주는 서비스를 하는 모듈

public class MemberInfoPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	/*public void setMemberDao(MemberDao memberDao) { //Autowired를 통해 set메서드 부분을 생략가능하다.(정확하지않음)
		this.memberDao = memberDao;
	}*/
	/*
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}*/
	
	public void printMemberInfo(String email){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			System.out.println("데이터 없음");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
}

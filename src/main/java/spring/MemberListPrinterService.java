package spring;

import java.util.Collection;
//전체 리스트 출력해주는 서비스를 하는 모듈
public class MemberListPrinterService {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinterService(MemberDao memberDao, MemberPrinter printer){
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void selectAll(){
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members){
			printer.print(m);
		}
	}
}

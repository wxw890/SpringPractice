package spring;

import java.util.Collection;

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

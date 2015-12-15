package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


//전체 리스트 출력해주는 서비스를 하는 모듈
public class MemberListPrinterService {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	@Autowired
	public MemberListPrinterService(@Qualifier("memberDao")MemberDao memberDao, @Qualifier("memberPrinter")MemberPrinter printer){
		this.memberDao = memberDao;//@Qualifier를 통해 주입받고 싶은 정보를 주입받을 수있다.(빈 스캐너, annotation를 생각해보면서 주입할수 있다.)
		this.printer = printer;
	}
	
	public void selectAll(){
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members){
			printer.print(m);
		}
	}
}

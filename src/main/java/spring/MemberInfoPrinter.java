package spring;
//선택된 멤머 리스트를 출력해주는 서비스를 하는 모듈
public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
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

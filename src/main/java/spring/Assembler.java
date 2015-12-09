package spring;
//내가 쓰고자하는 객체를 합쳐서.. 즉, 조립을 해서 사용하기위해서 필요하다.(팩토리랑 비슷함)
public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler(){
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService(memberDao);
	}
	public MemberDao getMemberDao(){
		return memberDao;
	}
	public MemberRegisterService getRegSvc(){ return regSvc;}
}

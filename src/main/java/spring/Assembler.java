package spring;
//내가 쓰고자하는 객체를 합쳐서.. 즉, 조립을 해서 사용하기위해서 필요하다.(팩토리랑 비슷함)
public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler(){
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao); //주입해주고 있다. --->spring에서는 xml에서 이작업을 구현해야한다.
		pwdSvc = new ChangePasswordService(memberDao);	//주입해주고 있다.
	}
	public MemberDao getMemberDao(){
		return memberDao;
	}
	public MemberRegisterService getRegSvc(){ return regSvc;}
	public ChangePasswordService getPwSvc(){ return pwdSvc;}
}

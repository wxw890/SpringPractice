package spring;
//서비스 단
import java.util.Date;
//비번
public class ChangePasswordService {
	private MemberDao memberDao;
	public ChangePasswordService(){}
	public ChangePasswordService(MemberDao memberDao){ //주입받고있다 MemberDao
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPw, String newPw){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPw, newPw);
		memberDao.insert(member);
	}
}

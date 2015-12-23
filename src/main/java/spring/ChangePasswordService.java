package spring;
//서비스 단
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;
//비번 변경
public class ChangePasswordService {
	private MemberDao memberDao;
	public ChangePasswordService(){}
	public ChangePasswordService(MemberDao memberDao){ //주입받고있다 MemberDao
		this.memberDao = memberDao;
	}
	@Transactional //트랜잭션 처리를 위한 annotation
	public void changePassword(String email, String oldPw, String newPw){
		Member member = memberDao.selectByEmail(email);
		if(member == null){ //이메일 중복 검사만 하고있다 
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPw, newPw);
		memberDao.insert(member);
	}
}

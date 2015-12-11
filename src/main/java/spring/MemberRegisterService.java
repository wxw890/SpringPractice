package spring;
//서비스 단 
import java.util.Date;
//가입
public class MemberRegisterService {
	private MemberDao memberDao;
	public MemberRegisterService(){}
	public MemberRegisterService(MemberDao memberDao){//주입받고있다 MemberDao
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null){
			throw new AlreadyExistingMemberException("이메일 중복:" + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}

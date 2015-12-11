package spring;
import java.util.Collection;
//DB연결 가장 말단
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap<String, Member>();//db대신에 사용하는것 HashMap사용...
	
	public Member selectByEmail(String email){//중복 이메일 확인
		return map.get(email);
	}
	
	public void insert(Member member){//회원가입
		member.setId(++nextId);
		map.put(member.getEmail(), member);
		
	}
	
	public void update(Member member){//회원변경
		map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll(){//Collection 타입은 array, vector의 최상위 부모로써 나중에 vecter나 array 아무거나 사용가능함
		return map.values();
	}
}

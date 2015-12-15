package spring;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
//DB연결 가장 말단
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	private static long nextId = 0;
	//private Map<String, Member> map = new HashMap<String, Member>();//db대신에 사용하는것 HashMap사용...
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	public Member selectByEmail(String email){//중복 이메일 확인
		String sql="select * from MEMBER where EMAIL=?";
		List<Member> results=jdbcTemplate.query(sql, new RowMapperImpl(), email);//rse는 sql문의 결과값을 받아오는 역할(여기서 rse는 new RowMapperImpl()를 사용)
		return results.isEmpty()?null:results.get(0);
	}
	
	class RowMapperImpl implements RowMapper{ //그냥 클래스를 직접 만들어서 해보는 것
		public Object mapRow(ResultSet rs, int arg1) throws SQLException{
			Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
					rs.getTimestamp("REGDATE"));
			member.setId(rs.getLong("ID"));
			return member;
		}
	}
	public void insert(Member member){//회원가입
		member.setId(++nextId);
		//map.put(member.getEmail(), member);
		
	}
	
	public void update(Member member){//회원변경
		//map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll(){//Collection 타입은 array, vector의 최상위 부모로써 나중에 vecter나 array 아무거나 사용가능함
		String sql="select * from MEMBER ";
		List<Member> results=jdbcTemplate.query(sql, new RowMapperImpl());//rse는 sql문의 결과값을 받아오는 역할
		return results;
	}
}

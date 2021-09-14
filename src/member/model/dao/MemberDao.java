package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;


public class MemberDao {
	// sql/member/member-query.properties 읽어와서 담을 필드
	private Properties query = new Properties();
	
	// MemberDao 객체 생성 시  query에 xml 파일 안의 sql문 저장
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.xml").getPath();
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 1. 로그인 기능
	public Member loginMember(Connection conn, String email, String pwd) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getInt("user_no"),
										rset.getString("user_email"),
										rset.getString("user_pwd"),
										rset.getString("nickname"),
										rset.getTimestamp("eroll_date"),
										rset.getString("user_type"),
										rset.getString("profile_img"),
										rset.getString("target_hour"),
										rset.getInt("user_coin"),
										rset.getInt("report_count"),
										rset.getString("status"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return loginUser;
	}
	
	
	// 2. 회원 가입 기능
	public int insertMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserEmail());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getNickName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 3. 회원 정보 수정 기능
	public int updateMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			/*pstmt.setXXX*/
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} 
	
	// 4. userNo로 member 객체 조회
	public Member selectMember(Connection conn, int userNo) {
		Member mem = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = query.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mem = new Member(/*rset.getXXX*/);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mem;
	}
	
	// 5. 비밀번호 수정 기능
	public int updatePwd(Connection conn, int userNo, String userPwd, String newPwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			/*pstmt.setXXX*/
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	// 6. 회원 탈퇴 기능 
	public int deleteMember(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			/*pstmt.setXXX*/
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
} 

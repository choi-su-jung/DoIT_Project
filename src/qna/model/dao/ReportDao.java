package qna.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



import static common.JDBCTemplate.close;

import qna.model.vo.BoardReport;
import qna.model.vo.Notice;
import qna.model.vo.Reply;
import qna.model.vo.ReplyReport;
import qna.model.vo.Report;

public class ReportDao {
	private Properties query = new Properties();
	
	public ReportDao() {
		String fileName = ReportDao.class.getResource("/sql/report/report-query.xml").getPath();
		try {
			query.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	// 게시글 신고
	public int boardReport(Connection conn, Report r) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("boardReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReport_content());
			pstmt.setInt(2, r.getUser_no());
			pstmt.setInt(3, r.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 댓글 신고
	public int replyReport(Connection conn, Report r) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("replyReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReport_content());
			pstmt.setInt(2, r.getUser_no());
			pstmt.setInt(3, r.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	// boardReport에 값 넣기
	public int boardReportManager(Connection conn, BoardReport br) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("reportBoardManager");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, br.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// replyReport에 값 넣기
	public int replyReportManager(Connection conn, ReplyReport rr) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("reportReplyManager");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rr.getReply_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	// 댓글 신고 회원 조회
	public int replyReportRefer(Connection conn, Report r, ReplyReport rr) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("replyReportRefer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, r.getUser_no());
			pstmt.setInt(2, rr.getReply_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 게시판 신고 회원 조회
	public int boardReportRefer(Connection conn, Report r, BoardReport br) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = query.getProperty("boardReportRefer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, r.getUser_no());
			pstmt.setInt(2, br.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 게시글 신고 처리시 회원 신고 횟수 +1
	public int memberBoardReportCount(Connection conn, int board_no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("memberBoardReportCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
	
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	// 게시글 신고 처리시 게시글 신고 횟수 + 1
	public int boardReportCount(Connection conn, int board_no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("boardReportCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
	
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	// 댓글 신고 처리시 회원 신고 횟수 +1
	public int memberReplyReportCount(Connection conn, int reply_no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("memberReplyReportCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reply_no);
	
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
	// 댓글 신고 처리시 댓글 신고 횟수 + 1
	public int replyReportCount(Connection conn, int reply_no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = query.getProperty("replyReportCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reply_no);
	
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

//	// 게시글 작성자 회원번호 알아오기
//	public int selectWriter(Connection conn, int board_no) {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String sql = query.getProperty("selectWriter");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1, board_no);
//		
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}


}

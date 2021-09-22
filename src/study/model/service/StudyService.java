package study.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import study.model.dao.StudyDao;
import study.model.vo.MemberJoinStudy;
import study.model.vo.Study;

import static common.JDBCTemplate.*;

public class StudyService {
	private StudyDao sd = new StudyDao();

	// 스터디방 리스트 조회
	public List<Study> selectStudyList() {
		Connection conn = getConnection();
		
		List<Study> StudyList = sd.selectStudyList(conn);
		
		close(conn);
		
		return StudyList;
	}
	// 스터디방별 가입된 회원 조회
	public List<Study> selectStudyMemberList() {
		Connection conn = getConnection();
		
		List<Study> StudyMemberList = sd.selectStudyMemberList(conn);
		
		close(conn);
		
		return StudyMemberList;
	}

	// 스터디방 생성
	public int insertStudyRoom(Study s) {
		Connection conn = getConnection();
		
		// Study 테이블 insert
		int result1 = sd.insertStudy(conn,s);
		// Attachment 테이블 insert
		int result2 = sd.insertStudyPhoto(conn,s.getsImgList());
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1 > 0 && result2 > 0 ? 1 : 0;
	}

	// 스터디방 1개 조회
	public Study selectStudyRoom(int s_no) {
		Connection conn = getConnection();
		
		Study s = sd.selectStudyRoom(conn, s_no);
		
		close(conn);
		
		
		return s;
	}

	// 스터디방 삭제(status N으로)
	public int deleteStudy(int[] deleteStudyArrInt) {
		Connection conn = getConnection();
		int resultSum = 0;
		for(int i=0; i<deleteStudyArrInt.length; i++) {	
			int result = sd.deleteStudy(conn,deleteStudyArrInt[i]);
			resultSum += result;
		}
		
		if(resultSum>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return resultSum;
	}

	// 스터디방 갯수 알아오기
	public int selectStudyListNumber() {
		Connection conn = getConnection();
		
		int result = sd.selectStudyListNumber(conn);
		
		close(conn);
		
		return result;
	}
	
	// 스터디방 가입
	public int insertMemberJoinStudy(MemberJoinStudy mjs) {
		Connection conn = getConnection();
		
		int result = sd.insertMemberJoinStudy(conn,mjs);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	// 스터디방 가입 여부 조회
	public MemberJoinStudy selectMemberJoinStudy(int userNo,int s_no) {
		Connection conn = getConnection();
		
		MemberJoinStudy mjs = sd.selectMemberJoinStudy(conn,userNo,s_no);
		
		close(conn);
		
		return mjs;
	}

	// 멤버별 가입한 스터디방 갯수 조회
	public int memberJoinStudyNum(int userNo) {
		Connection conn= getConnection();
		
		int result = sd.memberJoinStudyNum(conn,userNo);
		
		close(conn);
		
		return result;
	}
	
	// 스터디방별 가입된 회원수
	public int StudyMemberCount(int s_no) {
		Connection conn= getConnection();
		
		int result = sd.StudyMemberCount(conn,s_no);
		
		close(conn);
		
		return result;
	}

	


	
	
}











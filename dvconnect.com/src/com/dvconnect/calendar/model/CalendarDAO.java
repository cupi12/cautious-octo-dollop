package com.dvconnect.calendar.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dvconnect.common.ConnectionManager;
import com.dvconnect.member.model.MemberVO;
import com.dvconnect.qna.model.QnaVO;

public class CalendarDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int calInsert(CalendarVO vo) {//일정등록
		int r=0;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = ConnectionManager.getConnnect();
			
			String sql = "insert into calendar(seq, id, calendarDate, schedule) values ((select nvl(max(seq),1)+1 from calendar)  , ?, TO_DATE(?,'YYYYMMDD') , ?)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getCalendarDate());
			psmt.setString(3, vo.getSchedule());
			
			r= psmt.executeUpdate();
			
			System.out.println(r + "건이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		return r;
				
	}//end of calInsert
	
	public ArrayList<CalendarVO> calList() {//전체조회
		ArrayList<CalendarVO> list = new ArrayList<CalendarVO>();
		
		Connection conn = null;
		conn = ConnectionManager.getConnnect();
		try {
			PreparedStatement psmt = null;
			String sql = "select * from calendar order by calendarDate asc";
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				CalendarVO vo = new CalendarVO();
				vo.setId(rs.getString("id"));
				vo.setCalendarDate(rs.getString("calendarDate"));
				vo.setSchedule(rs.getString("schedule"));	
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		
		return list;
	}//end of getQnaList
	
	public CalendarVO getCal(String calendarDate) {
		CalendarVO vo = new CalendarVO();
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnnect();
			PreparedStatement psmt = null;			
			String sql = "select * FROM calendar WHERE calendarDate=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, calendarDate);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setCalendarDate(rs.getString("calendarDate"));
				vo.setId(rs.getString("id"));
				vo.setSchedule(rs.getString("schedule"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		return vo;
	}//end of getQna
	public int calUpdate(CalendarVO cal) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update calendar set schedule=? where calendarDate =? ";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, cal.getSchedule());
			psmt.setString(2, cal.getCalendarDate());


			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}//end of calUpdate
	
}

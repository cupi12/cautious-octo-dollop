package com.dvconnect.qna.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dvconnect.common.ConnectionManager;
import com.dvconnect.member.model.MemberVO;



public class QnaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<QnaVO> getMainQnaList() {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
	
		
		Connection conn = null;
		conn = ConnectionManager.getConnnect();
		try {
			int position = 1;
			PreparedStatement psmt = null;
//			select * from qna order by seq desc
			String sql ="select * FROM qna order by seq desc";

			psmt = conn.prepareStatement(sql);			
		         
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				QnaVO vo = new QnaVO();
				vo.setContents(rs.getString("contents"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setNickName(rs.getString("nickName"));				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		
		return list;
	}//end of getQnaList
	
	
	public int getCount(String title, String contents) {
		String strWhere = " where 1 = 1";
		if (title != null && !title.isEmpty()) {
			strWhere += " and title = ?";
		}
		if (contents != null && !contents.isEmpty()) {
			strWhere += " and contents like '%' || ? || '%'";
		}
		int cnt = 0;

		Connection conn = ConnectionManager.getConnnect();
		try {
			String sql = "select count(*) AS cnt from qna" + strWhere ;
			PreparedStatement psmt = conn.prepareStatement(sql);
			int position = 1;
			if (title != null && !title.isEmpty()) {
				psmt.setString(position++, title);
			}
			if (contents != null && !contents.isEmpty()) {
				psmt.setString(position++, contents);
			}
			rs = psmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return cnt;
	}
	
	public int QnaDelete(int seq) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "delete from qna where seq= ? ";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setInt(1, seq);
			

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 삭제됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}//end of QnaUpdate
	

	public void QnaInsert(QnaVO vo) {
		Connection conn = null;
		PreparedStatement psmt = null;

		String sql = "insert into QNA (seq, title, contents, nickname,id, regdt) values ((select nvl(max(seq),0)+1 from qna), ?, ?, ?, ?, sysdate )";

		conn = ConnectionManager.getConnnect();
		try {
			
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContents());
			psmt.setString(3, vo.getNickName());
			psmt.setString(4, vo.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
	}//end of QnaInsert
	
	public QnaVO getQna(int seq) {
		QnaVO vo = new QnaVO();
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnnect();
			PreparedStatement psmt = null;			
			String sql = "select * FROM qna WHERE seq=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, seq);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setNickName(rs.getString("nickName"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setId(rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		return vo;
	}//end of getQna
	
	public ArrayList<QnaVO> getQnaList(int start, int end, String seq, String contents) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String strWhere = " where 1 = 1";
		if (seq != null && !seq.isEmpty()) {
			strWhere += " and seq = ?";
		}
		if (contents != null && !contents.isEmpty()) {
			strWhere += " and contents like '%' || ? || '%'";
		}
		Connection conn = null;
		conn = ConnectionManager.getConnnect();
		try {
			int position = 1;
			PreparedStatement psmt = null;
//			select * from qna order by seq desc
			String sql = "select B.* from (select A.*, rownum rn from ("
					+ "select * FROM qna"+  strWhere+ "order by seq desc"
							+ "  ) A  )B where rn between ? and ?  ";
//			String sql = 
//			"SELECT B.* FROM ( SELECT A.*, ROWNUM rn FROM ( " + " select * from qna order by seq desc " 
//			+ " ) A ) B WHERE rn BETWEEN ? AND ?";
			psmt = conn.prepareStatement(sql);
			if (seq != null && !seq.isEmpty()) {
				strWhere += " and seq = ?";
			}
			if (contents != null && !contents.isEmpty()) {
				strWhere += " and contents like '%' || ? || '%'";
			}
		       psmt.setInt(position++, start);
		         psmt.setInt(position, end);
		         
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				QnaVO vo = new QnaVO();
				vo.setContents(rs.getString("contents"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setNickName(rs.getString("nickName"));				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		
		return list;
	}//end of getQnaList
	
	
	public int QnaUpdate(QnaVO vo) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update Qna set  title =?, contents=? where seq=?";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContents());
			psmt.setInt(3, vo.getSeq());
			

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
	}//end of QnaUpdate
	
	
}

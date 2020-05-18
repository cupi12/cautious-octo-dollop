package com.dvconnect.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dvconnect.common.ConnectionManager;

public class MemberDAO {
	
	public MemberVO getMember(String id) {
		MemberVO vo = new MemberVO();
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnnect();
			PreparedStatement psmt = null;
			String sql = "select * FROM member2 WHERE id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setNickName(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		return vo;
	}
	
	public int memberInsert(MemberVO member) {//회원등록
		int r=0;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = ConnectionManager.getConnnect();
			
			String sql = "insert into member2( id, pwd, email, nickname) values (?, ?, ?, ?)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getEmail());
			psmt.setString(4, member.getNickName());
			
			r= psmt.executeUpdate();
			
			System.out.println(r + "건이 등록되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		return r;
				
	}//end of memberInsert

}

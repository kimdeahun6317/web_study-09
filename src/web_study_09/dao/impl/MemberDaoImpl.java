package web_study_09.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web_study_09.dao.MemberDao;
import web_study_09.ds.JdbcUtil;
import web_study_09.dto.Member;

public class MemberDaoImpl implements MemberDao {
	private static final MemberDaoImpl instance = new MemberDaoImpl();

	private MemberDaoImpl() {
	}

	public static MemberDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Member> selectMemberByAll() {

		String sql = "SELECT NAME, USERID,PWD,EMAIL,PHONE,ADMIN,JOINDATE FROM MEMBER";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Member> list = new ArrayList<Member>();
				do {
					list.add(getMember(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	

	@Override
	public Member selectMemberByUserId(Member member) {
		String sql = "SELECT NAME, USERID,PWD,EMAIL,PHONE,ADMIN,JOINDATE "
				+ "FROM MEMBER "
				+ "WHERE USERID = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, member.getUserId());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getMember(rs);
				}
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	@Override
	public int insertMember(Member member) {
		String sql = "INSERT INTO MEMBER(NAME, USERID, PWD, EMAIL, PHONE, ADMIN) VALUES (?,?,?,?,?,?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement psmt = con.prepareStatement(sql)){
			
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getUserId());
			psmt.setString(3, member.getPwd());
			psmt.setString(4, member.getEmail());
			psmt.setString(5, member.getPhone());
			psmt.setInt(6, member.getAdmin());
			//psmt.setTimestamp(7, new Timestamp(member.getJoinDate().getTime()));
			
			return psmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateMember(Member member) {
		String sql = "UPDATE MEMBER SET name=?,pwd=?,email=?,phone=?,admin=?,JOINDATE=? WHERE userid=? ";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getPwd());
				pstmt.setString(3, member.getEmail());
				pstmt.setString(4, member.getPhone());
				pstmt.setInt(5, member.getAdmin());
				//pstmt.setDate(6, member.getJoinDate());
				pstmt.setTimestamp(6, new Timestamp(member.getJoinDate().getTime()));
				
				pstmt.setString(7, member.getUserId());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteMember(Member member) {
		String sql = "DELETE FROM MEMBER WHERE userid = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
				pstmt.setString(1, member.getUserId());
				return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Member getMember(ResultSet rs) throws SQLException {
		String name = rs.getString("NAME");
		String userId = rs.getString("USERID");
		String pwd = rs.getString("PWD");
		String email = rs.getString("EMAIL");
		String phone = rs.getString("PHONE");
		int admin = rs.getInt("ADMIN");
		Date joinDate = rs.getTimestamp("JOINDATE");
		
		
		return new Member(name, userId, pwd, email, phone, admin,joinDate);
	}

}

package com.projectbru.demo.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.projectbru.demo.model.MemberBean;
import com.projectbru.demo.util.ConnectDB;

@Repository
public class MemberDao {

	public MemberBean meber(String memberUsername, String memberPassword,String roleId,String status) {
		
		MemberBean bean = new MemberBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			sql.append(" SELECT * FROM member WHERE mem_username = ? AND mem_password = ? AND mem_role = ?");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setString(1,memberUsername);
			prepared.setString(2,memberPassword);
			prepared.setString(3,roleId);

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setMemUsername(rs.getString("mem_username"));
				bean.setMemPassword(rs.getString("mem_password"));
				bean.setMemRole(rs.getString("mem_role"));
			}
		
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return bean ;
		
	}
	
	// insert member
	public void insert (MemberBean bean) {
		    ConnectDB con = new ConnectDB();
	 		PreparedStatement prepared = null;
	 		StringBuilder sql = new StringBuilder();
	 		
	 		
	 		
    		// Date dNow = new Date();
          // 	 SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
      
        //    bean.setMemCreateDate(ft.format(dNow));
        // 	bean.setMemEditdata(ft.format(dNow));
	 		
	 		try {
				sql.append(" INSERT INTO member(mem_username,mem_password,mem_name,mem_add,mem_phone,mem_createDate,mem_editdata,mem_statusdelete,mem_role) VALUES(?,?,?,?,?,?,?,'1','2') "  );
				prepared = con.openConnect().prepareStatement(sql.toString());
				prepared.setString(1, bean.getMemUsername());
				prepared.setString(2, bean.getMemPassword());
				prepared.setString(3, bean.getMemName());
				prepared.setString(4, bean.getMemAdd());
				prepared.setString(5, bean.getMemPhone());
				prepared.setString(6, bean.getMemCreateDate());
				prepared.setString(7, bean.getMemEditdata());
				//prepared.setInt(8, bean.getMemStatusdelete());
			prepared.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		
	}
	// update member
	   public void  update(MemberBean bean) {
		    ConnectDB con = new ConnectDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();
		   
			try {
				sql.append("UPDATE member SET mem_username = ? ,mem_password = ?,mem_name = ?,mem_add = ?,mem_phone = ?,mem_editdata = ? WHERE mem_id = ? ");
				prepared = con.openConnect().prepareStatement(sql.toString());
				prepared.setString(1, bean.getMemUsername());
				prepared.setString(2, bean.getMemPassword());
				prepared.setString(3, bean.getMemName());
				prepared.setString(4, bean.getMemAdd());
				prepared.setString(5, bean.getMemPhone());
				prepared.setString(6, bean.getMemEditdata());
				prepared.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
	   }
	   public List<MemberBean> findAll(){
		   List<MemberBean> list = new ArrayList<>();
		   ConnectDB con = new ConnectDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();

			try {
				sql.append(" SELECT * FROM member ");
				prepared = con.openConnect().prepareStatement(sql.toString());
				ResultSet rs = prepared.executeQuery();

				while (rs.next()) {
					MemberBean bean = new MemberBean();
					bean.setMemId(rs.getInt("mem_id"));
					bean.setMemUsername(rs.getString("mem_username"));
					bean.setMemPassword(rs.getString("mem_password"));
					bean.setMemName(rs.getString("mem_name"));
					bean.setMemAdd(rs.getString("mem_add"));
					bean.setMemPhone(rs.getString("mem_phone"));
					bean.setMemCreateDate(rs.getString("mem_createDate"));
					bean.setMemEditdata(rs.getString("mem_editdata"));
					bean.setMemStatusdelete(rs.getString("mem_statusdelete"));
					
					list.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		   return list;
	   }
	
	   
	   //ckuser
	   public MemberBean ckuser(String memberUsername) {
			
			MemberBean bean = new MemberBean();
			ConnectDB con = new ConnectDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();
			
			try {
				sql.append(" SELECT * FROM member WHERE mem_username = ? ");
				prepared = con.openConnect().prepareStatement(sql.toString());
				prepared.setString(1,memberUsername);
				ResultSet rs = prepared.executeQuery();
				while (rs.next()) {
					bean.setMemUsername(rs.getString("mem_username"));
				}
			
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			return bean ;
			
		}
	   
	// End Class
}

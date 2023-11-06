package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import connectDB.ConnectDB;
import entity.LoaiPhong;
public class LoaiPhong_DAO {
	public ArrayList<LoaiPhong> getAllLoaiPhong() {
		ArrayList<LoaiPhong> dsLP = new ArrayList<LoaiPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from tbl_LoaiPhong";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				LoaiPhong lp = new LoaiPhong(ma, ten);
				dsLP.add(lp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsLP;
	}
	public String getMaLoaiPTheoTen(String ten) {
		String ma = "";
		String sql = "select MaLoaiPhong from tbl_LoaiPhong where TenLoaiPhong = N'"+ten+"'";
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			rs.next();
			ma = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ma;
	}
}

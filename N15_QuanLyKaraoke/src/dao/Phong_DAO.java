package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connectDB.ConnectDB;
import java.sql.Statement;

import entity.LoaiPhong;
import entity.PhongHat;
public class Phong_DAO {
	public ArrayList<PhongHat> getAllPhong() {
		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				double donGia = rs.getDouble(3);
				String tinhTrang = rs.getString(4);
				int sucChua = rs.getInt(5);
				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
				
				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
				dsPhong.add(p);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhong;
	}
	// thêm phòng mới
	public void addPhong(PhongHat p) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into tbl_PhongHat values(?,?,?,?,?,?)");
				statement.setString(1, p.getMaPhongHat());
				statement.setString(2, p.getTenPhongHat());
				statement.setDouble(3, p.getGiaPhong());
				statement.setString(4, p.getTinhTrang());
				statement.setInt(5, p.getSucChua());
				statement.setString(6, p.getLoaiPhong().getMaLoaiPhong());
				statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	// kiểm tra mã có trùng không
	public int kiemTraMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_PhongHat WHERE MaPhongHat = ?");
			statement.setString(1, ma);
			 ResultSet resultSet = statement.executeQuery();
			 resultSet.next();
		     int count = resultSet.getInt(1);
		     return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	//Xóa phòng trên SQL
	public boolean delete_Phong(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM tbl_PhongHat WHERE MaPhongHat =?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
					
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	//Cập nhật thông tin phòng
	public void capNhat_PhongHat(PhongHat ph) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("UPDATE tbl_PhongHat SET TenPhongHat=? , GiaPhong=? , TinhTrang=? , SucChua=? , MaLoaiPhong=? WHERE MaPhongHat=?");
			stmt.setString(1, ph.getTenPhongHat());
			stmt.setDouble(2, ph.getGiaPhong());
			stmt.setString(3, ph.getTinhTrang());
			stmt.setInt(4, ph.getSucChua());
			stmt.setString(5, ph.getLoaiPhong().getMaLoaiPhong());
			stmt.setString(6, ph.getMaPhongHat());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

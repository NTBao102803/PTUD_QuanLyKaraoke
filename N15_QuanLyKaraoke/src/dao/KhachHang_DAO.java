package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.PhongHat;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * from tbl_KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String soDienThoai = rs.getString(3);
				String cCCD = rs.getString(4);
				int gioiTinh = rs.getInt(5);
				String diaChi = rs.getString(6);
//				int soLanSuDung = rs.getInt(7);
				KhachHang kh = new KhachHang(ma, ten, soDienThoai, cCCD, gioiTinh, diaChi);
				dsKhachHang.add(kh);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	
	// thêm khách hàng mới
		public void addKhachHang(KhachHang kh) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement statement = null;
			try {
					statement = con.prepareStatement("insert into tbl_KhachHang values(?,?,?,?,?,?)");
					statement.setString(1, kh.getMaKhachHang());
					statement.setString(2, kh.getTenKhachHang());
					statement.setString(3, kh.getSoDienThoai());
					statement.setString(4, kh.getCCCD());
					statement.setInt(5, kh.getGioiTinh());
					statement.setString(6, kh.getDiaChi());
//					statement.setInt(7, kh.getSoLanSuDung());
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
				statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_KhachHang WHERE MaKhachHang = ?");
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
		//Xóa khách hàng trên SQL
		public boolean delete_KhachHang(String ma) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("DELETE FROM tbl_KhachHang WHERE MaKhachHang =?");
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
		//Cập nhật thông tin khách hàng
		public void capNhat_KhachHang(KhachHang kh) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("UPDATE tbl_KhachHang SET TenKhachHang=? , SoDienThoai=? , CCCD=? , GioiTinh=? , DiaChi=? WHERE MaKhachHang=?");
				stmt.setString(1, kh.getTenKhachHang());
				stmt.setString(2, kh.getSoDienThoai());
				stmt.setString(3, kh.getCCCD());
				stmt.setInt(4, kh.getGioiTinh());
				stmt.setString(5, kh.getDiaChi());
//				stmt.setInt(6, kh.getSoLanSuDung());
				stmt.setString(7, kh.getMaKhachHang());
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




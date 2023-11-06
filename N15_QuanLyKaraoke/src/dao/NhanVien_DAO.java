package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;

import connectDB.ConnectDB;
import entity.NhanVien;


public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT* from tbl_NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				Date ngaySinh = rs.getDate(3);
				String soDienThoai = rs.getString(4);
				String cCCD = rs.getString(5);
				int gioiTinh = rs.getInt(6);
				String diaChi = rs.getString(7);
				String chucVu = rs.getString(8);
				String trangThai = rs.getString(9);
				NhanVien nv = new NhanVien(ma, ten, ngaySinh, soDienThoai, cCCD, gioiTinh, diaChi, chucVu, trangThai);
				dsNhanVien.add(nv);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	// tìm nhân viên theo mã
	public NhanVien getNVtheoMa(String maNV) {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "SELECT MaNhanVien, TenNhanVien, NgaySinh, SoDienThoai, CCCD, GioiTinh, DiaChi, ChucVu, TrangThai FROM tbl_NhanVien WHERE MaNhanVien ='"+maNV+"'";
			stmt=con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				 nv = new NhanVien(rs.getString(1), rs.getString(2), 
						 rs.getDate(3), rs.getString(4), rs.getString(5),
						 rs.getInt(6), rs.getString(7), 
						 rs.getString(8), rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return nv;
	}
	// tìm nhân viên theo tên đăng nhập
	public NhanVien timNhanVienTheoTaiKhoan(String user) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select nv.MaNhanVien, TenNhanVien, NgaySinh, SoDienThoai, CCCD, GioiTinh, DiaChi, ChucVu, TrangThai from tbl_NhanVien nv join tbl_TaiKhoan tk on nv.MaNhanVien = tk.MaNhanVien where TenDangNhap = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				Date ngaySinh = rs.getDate(3);
				String soDienThoai = rs.getString(4);
				String cCCD = rs.getString(5);
				int gioiTinh = rs.getInt(6);
				String diaChi = rs.getString(7);
				String chucVu = rs.getString(8);
				String trangThai = rs.getString(9);
				NhanVien nv = new NhanVien(ma, ten, ngaySinh, soDienThoai, cCCD, gioiTinh, diaChi, chucVu, trangThai);
				return nv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
}

package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;
import entity.NhanVien;

public class TaiKhoan_DAO {
	public ArrayList<TaiKhoan> getAllTaiKhoan() {
		ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select TenDangNhap, MatKhau, tk.MaNhanVien from tbl_TaiKhoan tk join tbl_NhanVien nv on tk.MaNhanVien = nv.MaNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tenDangNhap = rs.getString(1);
				String matKhau = rs.getString(2);
				NhanVien nv = new NhanVien(rs.getString(3));
				TaiKhoan tk = new TaiKhoan(tenDangNhap, matKhau, nv);
				dsTaiKhoan.add(tk);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}
	public TaiKhoan getTaiKHoanTheoTenDN(String tenDN) {
//		PreparedStatement stmt = null;
		TaiKhoan tk = new TaiKhoan();
		try {
//			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select TenDangNhap, MatKhau, tk.MaNhanVien from tbl_TaiKhoan tk join tbl_NhanVien nv on tk.MaNhanVien = nv.MaNhanVien where TenDangNhap ='"+tenDN+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				tk = new TaiKhoan(rs.getString("TenDangNhap"),rs.getString("MatKhau"), new NhanVien(rs.getString("MaNhanVien")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tk;
	}
//	 đổi mật khẩu
	public boolean DoiMK(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update tbl_TaiKhoan set MatKhau = ? where tenDangNhap = ?");
			stmt.setString(2, tk.getTenDangNhap());
			stmt.setString(1, tk.getMatKhau());
			n = stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	// lấy lại mật khẩu
	public void QuenMatKhau(String ma, String soDienThoai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("Update tbl_TaiKhoan set MatKhau = ? from tbl_TaiKhoan tk join tbl_NhanVien nv on nv.MaNhanVien = tk.MaNhanVien where SoDienThoai = '" + soDienThoai + "'");
			stmt.setString(1, ma);
			stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}

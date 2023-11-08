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
import entity.PhongHat;


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
	// tim nhan vien theo ten
	public NhanVien getNVtheoTen(String ten) {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			
			String sql = "SELECT MaNhanVien, TenNhanVien, NgaySinh, SoDienThoai, CCCD, GioiTinh, DiaChi, ChucVu, TrangThai FROM tbl_NhanVien WHERE TenNhanVien ='"+ten+"'" ;
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
	// thêm nhan vien mới
	public void addNhanVien(NhanVien nv) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
				stmt = con.prepareStatement("insert into tbl_NhanVien values(?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, nv.getMaNhanVien());
				stmt.setString(2, nv.getTenNhanVien());
				stmt.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
				stmt.setString(4, nv.getSoDienThoai());
				stmt.setString(5, nv.getcCCD());
				stmt.setInt(6, nv.getGioiTinh());
				stmt.setString(7, nv.getDiaChi());
				stmt.setString(8, nv.getChucVu());
				stmt.setString(9, nv.getTrangThai());
				
				stmt.executeUpdate();
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
	}
	// kiểm tra mã nhan vien có trùng không
	public int kiemTraMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_NhanVien WHERE MaNhanVien = ?");
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
	//kiem tra SDT
	public int kiemTraSDT(String sdt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_NhanVien WHERE SoDienThoai = ?");
			statement.setString(1, sdt);
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
	//kiem tra CCCD
		public int kiemTraCCCD(String cccd) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement statement = null;
			try {
				statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_NhanVien WHERE CCCD = ?");
				statement.setString(1, cccd);
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
	//Cập nhật thông tin nhan vien
	public void capNhat_NhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
//			SELECT MaNhanVien, TenNhanVien, NgaySinh, SoDienThoai, CCCD, GioiTinh, DiaChi, ChucVu, TrangThai FROM tbl_NhanVien WHERE MaNhanVien ='"+maNV+"'";
			stmt = con.prepareStatement("UPDATE tbl_NhanVien SET TenNhanVien=? , NgaySinh=? , SoDienThoai=? , CCCD=? ,  GioiTinh=?, DiaChi=? , ChucVu=? , TrangThai=?  WHERE MaNhanVien=?");
			stmt.setString(1, nv.getTenNhanVien());
			stmt.setDate(2, new java.sql.Date(nv.getNgaySinh().getTime()));
			stmt.setString(3, nv.getSoDienThoai());
			stmt.setString(4, nv.getcCCD());
			stmt.setInt(5, nv.getGioiTinh());
			stmt.setString(6, nv.getDiaChi());
			stmt.setString(7, nv.getChucVu());
			stmt.setString(8, nv.getTrangThai());
			stmt.setString(9, nv.getMaNhanVien());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
}

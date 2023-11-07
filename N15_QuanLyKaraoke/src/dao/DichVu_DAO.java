package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.KhachHang;

public class DichVu_DAO {
	public ArrayList<DichVu> getAllDichVu() {
		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * from tbl_DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				float gia = rs.getFloat(3);
				int soLuong = rs.getInt(4);
				String donVi = rs.getString(5);
				String trangThai = rs.getString(6);
				
				DichVu dv = new DichVu(ma, ten, gia, soLuong, donVi, trangThai);
				dsDichVu.add(dv);
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsDichVu;
	}
	
	// thêm dịch vụ mới
			public void addDichVu(DichVu dv) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement statement = null;
				try {
						statement = con.prepareStatement("insert into tbl_DichVu values(?,?,?,?,?,?)");
						statement.setString(1, dv.getMaDichVu());
						statement.setString(2, dv.getTenDichVu());
						statement.setFloat(3, dv.getGiaDichVu());
						statement.setInt(4, dv.getSoLuong());
						statement.setString(5, dv.getDonVi());
						statement.setString(6, dv.getTrangThai());
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
					statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_DichVu WHERE MaDichVu = ?");
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
			//Xóa Dịch vụ trên SQL
			public boolean delete_DichVu(String ma) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = null;
				int n = 0;
				try {
					stmt = con.prepareStatement("DELETE FROM tbl_DichVu WHERE MaDichVu =?");
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
			//Cập nhật thông tin Dịch vụ
			public void capNhat_DichVu(DichVu dv) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = null;
				try {
					stmt = con.prepareStatement("UPDATE tbl_DichVu SET TenDichVu=? , GiaDichVu=? , SoLuong=? , DonVi=? , TrangThai=? WHERE MaDichVu=?");
					stmt.setString(1, dv.getTenDichVu());
					stmt.setFloat(2, dv.getGiaDichVu());
					stmt.setInt(3, dv.getSoLuong());
					stmt.setString(4, dv.getDonVi());
					stmt.setString(5,dv.getTrangThai());
					stmt.setString(6, dv.getMaDichVu());
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






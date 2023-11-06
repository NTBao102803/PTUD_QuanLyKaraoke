package entity;

import java.util.Objects;

public class PhongHat {
	private String maPhongHat;
	private String tenPhongHat;
	private LoaiPhong loaiPhong;
	private double giaPhong;
	private String tinhTrang;
	private int sucChua;
	// constructor
	public PhongHat(String maPhongHat, String tenPhongHat, LoaiPhong loaiPhong, double giaPhong, String tinhTrang,
			int sucChua) {
		super();
		this.maPhongHat = maPhongHat;
		this.tenPhongHat = tenPhongHat;
		this.loaiPhong = loaiPhong;
		this.giaPhong = giaPhong;
		this.tinhTrang = tinhTrang;
		this.sucChua = sucChua;
	}
	public PhongHat(String maPhongHat) {
		super();
		this.maPhongHat = maPhongHat;
	}
	public PhongHat() {
		super();
	}
	// get and set
	public String getMaPhongHat() {
		return maPhongHat;
	}
	public void setMaPhongHat(String maPhongHat) {
		this.maPhongHat = maPhongHat;
	}
	public String getTenPhongHat() {
		return tenPhongHat;
	}
	public void setTenPhongHat(String tenPhongHat) {
		this.tenPhongHat = tenPhongHat;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhongHat);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHat other = (PhongHat) obj;
		return Objects.equals(maPhongHat, other.maPhongHat);
	}
	// toString
	@Override
	public String toString() {
		return "PhongHat [maPhongHat=" + maPhongHat + ", tenPhongHat=" + tenPhongHat + ", loaiPhong=" + loaiPhong
				+ ", giaPhong=" + giaPhong + ", tinhTrang=" + tinhTrang + ", sucChua=" + sucChua + "]";
	}
	
	

	
}

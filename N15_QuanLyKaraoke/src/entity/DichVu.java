package entity;

import java.util.Objects;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private float giaDichVu;
	private int soLuong;
	private String donVi;
	private String trangThai;
	
	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DichVu(String maDichVu, String tenDichVu, float giaDichVu, int soLuong, String donVi, String trangThai) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.giaDichVu = giaDichVu;
		this.soLuong = soLuong;
		this.donVi = donVi;
		this.trangThai = trangThai;
	}
	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public float getGiaDichVu() {
		return giaDichVu;
	}
	public void setGiaDichVu(float giaDichVu) {
		this.giaDichVu = giaDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", giaDichVu=" + giaDichVu + ", soLuong="
				+ soLuong + ", donVi=" + donVi + ", trangThai=" + trangThai + "]";
	}
}

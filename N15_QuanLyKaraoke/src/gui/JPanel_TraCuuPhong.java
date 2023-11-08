/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.LoaiPhong;
import entity.PhongHat;

/**
 *
 * @author PC
 */
public class JPanel_TraCuuPhong extends javax.swing.JPanel {

    private Phong_DAO phong_dao;
	private LoaiPhong_DAO loaiPhong_dao;
	private DefaultTableModel model_Phong;
	private ArrayList<PhongHat> listPhong;
	/**
     * Creates new form JPanel_TraCuuPhong
     */
    public JPanel_TraCuuPhong() {
    	try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		phong_dao = new Phong_DAO();
		loaiPhong_dao = new LoaiPhong_DAO();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTieuDe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jLabelTenPhong = new javax.swing.JLabel();
        jLabelSucChua = new javax.swing.JLabel();
        jLabelTinhTrang = new javax.swing.JLabel();
        jTextFieldTenPhong = new javax.swing.JTextField();
        jLabelTenPhong1 = new javax.swing.JLabel();
        jComboBoxTinhTrang = new javax.swing.JComboBox<>();
        jComboBoxLoaiPhong = new javax.swing.JComboBox<>();
        jComboBoxSucChua = new javax.swing.JComboBox<>();
        jLabelGiaPhong = new javax.swing.JLabel();
        jTextFieldGiaPhong = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jButtonLamMoi = new javax.swing.JButton();
        jPanelDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePhongHat = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1250, 720));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tra cứu phòng");
        jLabel1.setPreferredSize(new java.awt.Dimension(168, 75));
        jPanelTieuDe.add(jLabel1);

        add(jPanelTieuDe, java.awt.BorderLayout.PAGE_START);

        jPanelBody.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin tra cứu phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanelBody.setPreferredSize(new java.awt.Dimension(745, 425));

        jLabelTenPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTenPhong.setText("Tên phòng:");

        jLabelSucChua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSucChua.setText("Sức chứa:");

        jLabelTinhTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTinhTrang.setText("Tình trạng:");

        jTextFieldTenPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelTenPhong1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTenPhong1.setText("Loại Phòng:");

        jComboBoxTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Trống", "Đang sử dụng", "Phòng chờ" }));
        jComboBoxTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTinhTrangActionPerformed(evt);
            }
        });
        jComboBoxLoaiPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
		/* Đổ dữ liệu lên comboBox */
		ArrayList<LoaiPhong> listLoaiPhong = loaiPhong_dao.getAllLoaiPhong();
		for (LoaiPhong lp : listLoaiPhong) {
			jComboBoxLoaiPhong.addItem(lp.getTenLoaiPhong());
		}
        jComboBoxSucChua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxSucChua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        jLabelGiaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGiaPhong.setText("Giá phòng:");

        jTextFieldGiaPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonTimKiem.setIcon(new javax.swing.ImageIcon("item/search25.png")); // NOI18N
        jButtonTimKiem.setText("Tìm kiếm");
        jButtonTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timKiem();
			}
		});

        jButtonLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLamMoi.setIcon(new javax.swing.ImageIcon("item/refresh25.png")); // NOI18N
        jButtonLamMoi.setText("Làm mới");
        jButtonLamMoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadPhong();
				clear_Phong();
			}
		});
        
        
        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addComponent(jLabelSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelBodyLayout.createSequentialGroup()
                            .addComponent(jLabelTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBodyLayout.createSequentialGroup()
                            .addComponent(jLabelTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 116, Short.MAX_VALUE)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addComponent(jLabelGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBodyLayout.createSequentialGroup()
                        .addComponent(jLabelTenPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBodyLayout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jButtonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTenPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(348, 348, 348))
        );

        add(jPanelBody, java.awt.BorderLayout.CENTER);

        jPanelDanhSach.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng hát", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanelDanhSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanelDanhSach.setPreferredSize(new java.awt.Dimension(745, 365));

        jScrollPane1.setBackground(new java.awt.Color(242, 242, 242));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTablePhongHat.setBackground(new java.awt.Color(242, 242, 242));
        jTablePhongHat.setModel(model_Phong = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã phòng", "Tên phòng", "Loại phòng", "Giá phòng", "Tình trạng", "Sức chứa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTablePhongHat.setGridColor(new java.awt.Color(204, 204, 204));
        jTablePhongHat.setShowGrid(true);
        jScrollPane1.setViewportView(jTablePhongHat);
        // load dữ liệu phòng lên table
        loadPhong();
        
        
        javax.swing.GroupLayout jPanelDanhSachLayout = new javax.swing.GroupLayout(jPanelDanhSach);
        jPanelDanhSach.setLayout(jPanelDanhSachLayout);
        jPanelDanhSachLayout.setHorizontalGroup(
            jPanelDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanelDanhSachLayout.setVerticalGroup(
            jPanelDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanelDanhSach, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTinhTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTinhTrangActionPerformed

    // đọc dữ liệu vào bảng phòng
    public void loadPhong() {
    	model_Phong.setRowCount(0);
		listPhong = phong_dao.getAllPhong();
		for (PhongHat ph : listPhong) {
			model_Phong.addRow(new Object[] { 
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua() });
		}
	}
    // làm mới 
	public void clear_Phong() {
		jTextFieldTenPhong.setText("");
		jComboBoxLoaiPhong.setSelectedIndex(0);
		jComboBoxTinhTrang.setSelectedIndex(0);
		jComboBoxSucChua.setSelectedIndex(0);
		jTextFieldGiaPhong.setText("");
	}
	// tìm kiếm phòng
	public void timKiem() {
		String ten = jTextFieldTenPhong.getText().trim();
		String loaiPhong = jComboBoxLoaiPhong.getSelectedItem().toString();
		String sucChua = jComboBoxSucChua.getSelectedItem().toString();
		String giaPhong = jTextFieldGiaPhong.getText().trim();
		String tinhTrang = jComboBoxTinhTrang.getSelectedItem().toString();
		// tình trạng, loại phòng và sức chứa
		if (!loaiPhong.equalsIgnoreCase("Tất cả") && !tinhTrang.equalsIgnoreCase("Tất cả") && !sucChua.equalsIgnoreCase("Tất cả")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoLPTTSC(loaiPhong, tinhTrang, sucChua);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
		// loại phòng vs tình trạng
		else if (!loaiPhong.equalsIgnoreCase("Tất cả") && !tinhTrang.equalsIgnoreCase("Tất cả")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoLPTT(loaiPhong, tinhTrang);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
		// loại phòng vs sức chứa
		else if (!loaiPhong.equalsIgnoreCase("Tất cả") && !sucChua.equalsIgnoreCase("Tất cả")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoLPSC(loaiPhong, sucChua);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
		// tình trạng với sức chứa
		else if (!tinhTrang.equalsIgnoreCase("Tất cả") && !sucChua.equalsIgnoreCase("Tất cả")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoTTSC(tinhTrang, sucChua);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
		// loại phòng
		else if (!loaiPhong.equalsIgnoreCase("Tất cả")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoLoaiPhong(loaiPhong);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
		// tình trạng
		else if (!tinhTrang.equalsIgnoreCase("Tất cả")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoTinhTrang(tinhTrang);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
		// sức chứa
		else if (!sucChua.equalsIgnoreCase("Tất cả")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoSucChua(sucChua);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
		// tên phòng
		else if (!ten.equalsIgnoreCase("")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoTenPhong(ten);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
		// giá phòng
		else if (!giaPhong.equalsIgnoreCase("")) {
			ArrayList<PhongHat> dsPhongHat = phong_dao.getAllPhongTheoGiaPhong(giaPhong);
			model_Phong.setRowCount(0);
			for (PhongHat ph : dsPhongHat) {
				model_Phong.addRow(new Object[] {
					ph.getMaPhongHat(), ph.getTenPhongHat() ,
					ph.getLoaiPhong().getTenLoaiPhong(),
					ph.getGiaPhong(), ph.getTinhTrang(), 
					ph.getSucChua()
				});
			}
		}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLamMoi;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JComboBox<String> jComboBoxLoaiPhong;
    private javax.swing.JComboBox<String> jComboBoxSucChua;
    private javax.swing.JComboBox<String> jComboBoxTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelGiaPhong;
    private javax.swing.JLabel jLabelSucChua;
    private javax.swing.JLabel jLabelTenPhong;
    private javax.swing.JLabel jLabelTenPhong1;
    private javax.swing.JLabel jLabelTinhTrang;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelDanhSach;
    private javax.swing.JPanel jPanelTieuDe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePhongHat;
    private javax.swing.JTextField jTextFieldGiaPhong;
    private javax.swing.JTextField jTextFieldTenPhong;
    // End of variables declaration//GEN-END:variables
}

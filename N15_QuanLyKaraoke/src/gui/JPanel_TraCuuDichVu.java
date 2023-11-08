/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVu_DAO;
import entity.DichVu;
import entity.PhongHat;

/**
 *
 * @author PC
 */
public class JPanel_TraCuuDichVu extends javax.swing.JPanel {

    private DefaultTableModel model_DichVu;
	private DichVu_DAO dichVu_dao;
	private ArrayList<DichVu> listDichVu;
	/**
     * Creates new form JPanel_TraCuuDichVu
     */
    public JPanel_TraCuuDichVu() {
    	try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	dichVu_dao = new DichVu_DAO();
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTieuDe = new javax.swing.JPanel();
        jLabelTieuDe = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jLabelTenDichVu = new javax.swing.JLabel();
        jLabelGiaDichVu = new javax.swing.JLabel();
        jTextFieldTenDichVu = new javax.swing.JTextField();
        jComboBoxGiaDichVu = new javax.swing.JComboBox<>();
        jLabelTrangThai = new javax.swing.JLabel();
        jComboBoxTrangThai = new javax.swing.JComboBox<>();
        jLabelSoLuong = new javax.swing.JLabel();
        jTextFieldSoLuong = new javax.swing.JTextField();
        jLabelDonVi = new javax.swing.JLabel();
        jComboBoxDonVi = new javax.swing.JComboBox<>();
        jButtonTìmKiem = new javax.swing.JButton();
        jButtonLamMoi = new javax.swing.JButton();
        jPanelLast = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDichVu = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1250, 720));
        setLayout(new java.awt.BorderLayout());

//        jPanelTieuDe.setBackground(new java.awt.Color(242, 242, 242, 242));
        jPanelTieuDe.setPreferredSize(new java.awt.Dimension(1250, 75));

        jLabelTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTieuDe.setText("Tra cứu dịch vụ");
        jLabelTieuDe.setPreferredSize(new java.awt.Dimension(177, 70));
        jPanelTieuDe.add(jLabelTieuDe);

        add(jPanelTieuDe, java.awt.BorderLayout.PAGE_START);

        jPanelBody.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanelBody.setPreferredSize(new java.awt.Dimension(1250, 400));

        jLabelTenDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTenDichVu.setText("Tên dịch vụ: ");

        jLabelGiaDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGiaDichVu.setText("Giá dịch vụ:");

        jTextFieldTenDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jComboBoxGiaDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxGiaDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTrangThai.setText("Trạng thái:");

        jComboBoxTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn", "Sắp hết", "Ngừng bán", " " }));

        jLabelSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSoLuong.setText("Số lượng:");

        jTextFieldSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelDonVi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDonVi.setText("Đơn vị:");

        jComboBoxDonVi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxDonVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thùng", "Lon", "Chai", "Dĩa", "Gói" }));

        jButtonTìmKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonTìmKiem.setIcon(new javax.swing.ImageIcon("item/search25.png")); // NOI18N
        jButtonTìmKiem.setText("Tìm Kiếm");
        jButtonTìmKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTìmKiemActionPerformed(evt);
            }
        });

        jButtonLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLamMoi.setIcon(new javax.swing.ImageIcon("item/refresh25.png")); // NOI18N
        jButtonLamMoi.setText("Làm mới");
        jButtonLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBodyLayout.createSequentialGroup()
                                .addComponent(jLabelGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBodyLayout.createSequentialGroup()
                                .addComponent(jLabelTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jButtonTìmKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(179, 179, 179)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelBodyLayout.createSequentialGroup()
                            .addComponent(jLabelSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBoxDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBodyLayout.createSequentialGroup()
                            .addComponent(jLabelTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTìmKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        add(jPanelBody, java.awt.BorderLayout.CENTER);

        jPanelLast.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanelLast.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanelLast.setPreferredSize(new java.awt.Dimension(474, 365));

        jTableDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableDichVu.setModel(model_DichVu = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn vị", "Giá dịch vụ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            @Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa bất kỳ ô nào trên bảng
			}
        });
        jScrollPane1.setViewportView(jTableDichVu);
        // load dữ liệu bảng dịch vụ
        loadDichVu();
        
        
        javax.swing.GroupLayout jPanelLastLayout = new javax.swing.GroupLayout(jPanelLast);
        jPanelLast.setLayout(jPanelLastLayout);
        jPanelLastLayout.setHorizontalGroup(
            jPanelLastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1146, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLastLayout.setVerticalGroup(
            jPanelLastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLastLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanelLast, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTìmKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTìmKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTìmKiemActionPerformed

    private void jButtonLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLamMoiActionPerformed

    // đọc dữ liệu vào bảng dịch vụ
    public void loadDichVu() {
    	model_DichVu.setRowCount(0);
		listDichVu = dichVu_dao.getAllDichVu();
		for (DichVu dv : listDichVu) {
			model_DichVu.addRow(new Object[] { 
					dv.getMaDichVu(), dv.getTenDichVu() , dv.getGiaDichVu(), dv.getSoLuong() ,
					dv.getDonVi(), dv.getTrangThai()});
		}
	}
    // làm mới 
	public void clear_Phong() {
		jTextFieldTenDichVu.setText("");
		jComboBoxTrangThai.setSelectedIndex(0);
		jComboBoxDonVi.setSelectedIndex(0);
		jComboBoxGiaDichVu.setSelectedIndex(0);
		jTextFieldSoLuong.setText("");
	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLamMoi;
    private javax.swing.JButton jButtonTìmKiem;
    private javax.swing.JComboBox<String> jComboBoxDonVi;
    private javax.swing.JComboBox<String> jComboBoxGiaDichVu;
    private javax.swing.JComboBox<String> jComboBoxTrangThai;
    private javax.swing.JLabel jLabelDonVi;
    private javax.swing.JLabel jLabelGiaDichVu;
    private javax.swing.JLabel jLabelSoLuong;
    private javax.swing.JLabel jLabelTenDichVu;
    private javax.swing.JLabel jLabelTieuDe;
    private javax.swing.JLabel jLabelTrangThai;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelLast;
    private javax.swing.JPanel jPanelTieuDe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDichVu;
    private javax.swing.JTextField jTextFieldSoLuong;
    private javax.swing.JTextField jTextFieldTenDichVu;
    // End of variables declaration//GEN-END:variables
}

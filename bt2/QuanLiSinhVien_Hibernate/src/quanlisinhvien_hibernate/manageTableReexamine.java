/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien_hibernate;

import dao.TableReexamineDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojos.TableReexamine;
import static quanlisinhvien_hibernate.Login.account;

/**
 *
 * @author DoDuyPhuong
 */
public class manageTableReexamine extends javax.swing.JFrame {

    /**
     * Creates new form manageTableReexamine
     */
    private manageClassRoom mClassRoom;
    private final String[] columnNames = {
        "STT", "ID", "From Date", "End Date", "Học Kỳ", "Năm Học", "Status", "Created", "Mofidied"
    };
    private boolean actionAdd = false;

    public manageTableReexamine() {
        this.setResizable(false);
        initComponents();
        initLayout();
    }

    public manageTableReexamine(manageClassRoom mClassRoom) {
        this.setResizable(false);
        this.mClassRoom = mClassRoom;
        this.mClassRoom.setVisible(false);
        initComponents();
        initLayout();
    }

    private void initLayout() {
        this.jCreateReexamine.setVisible(false);
        List<TableReexamine> listTableReexamine = TableReexamineDAO.getListTableReexamine();
        if (listTableReexamine.size() > 0) {
            int stt = 1;
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);
            // "STT", "ID", "From Date", "End Date", "Học Kỳ", "Năm Học", "Status", "Created", "Mofidied"
            for (TableReexamine tr : listTableReexamine) {
                String[] rows = new String[9];
                rows[0] = String.valueOf(stt);
                rows[1] = tr.getId().toString();
                rows[2] = tr.getStartDate().toString();
                rows[3] = tr.getEndDate().toString();
                rows[4] = tr.getHocKy();
                rows[5] = tr.getNamHoc();
                if (tr.getStatus() == 1) {
                    rows[6] = "Active";
                } else {
                    rows[6] = "Inactive";
                }
                rows[7] = tr.getCreated();
                rows[8] = tr.getModified();

                tableModel.addRow(rows);
                stt++;
            }

            jTableReexamine.setModel(tableModel);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);
            jTableReexamine.setModel(tableModel);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReexamine = new javax.swing.JTable();
        jbtnViewReexamine = new javax.swing.JButton();
        jbtnViewAdd = new javax.swing.JButton();
        jCreateReexamine = new javax.swing.JPanel();
        jFromDate = new com.toedter.calendar.JDateChooser();
        jEndDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbHK = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jYear = new com.toedter.calendar.JYearChooser();
        jbtnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox();
        jbtnClose = new javax.swing.JButton();
        jbtnBack = new javax.swing.JButton();
        jbtnViewUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("Quản Lý Phúc Khảo");
        jTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTableReexamine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableReexamine);

        jbtnViewReexamine.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnViewReexamine.setText("View ");

        jbtnViewAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnViewAdd.setText("Add");
        jbtnViewAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnViewAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("From:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("To:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Học Kỳ:");

        jcbHK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbHK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HK1", "HK2", "HK3" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Năm học:");

        jbtnAdd.setText("Create");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Status");

        jcbStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Inactive" }));

        jbtnClose.setText("Close");
        jbtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jCreateReexamineLayout = new javax.swing.GroupLayout(jCreateReexamine);
        jCreateReexamine.setLayout(jCreateReexamineLayout);
        jCreateReexamineLayout.setHorizontalGroup(
            jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCreateReexamineLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbHK, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCreateReexamineLayout.createSequentialGroup()
                        .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jCreateReexamineLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jCreateReexamineLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jYear, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCreateReexamineLayout.createSequentialGroup()
                        .addComponent(jbtnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnAdd)
                        .addContainerGap())))
        );
        jCreateReexamineLayout.setVerticalGroup(
            jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCreateReexamineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jCreateReexamineLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(jYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnAdd)
                            .addComponent(jbtnClose)))
                    .addGroup(jCreateReexamineLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbHK, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jCreateReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jbtnBack.setText("Back");
        jbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackActionPerformed(evt);
            }
        });

        jbtnViewUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnViewUpdate.setText("Update");
        jbtnViewUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnViewUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnViewReexamine, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnViewUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnViewAdd)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCreateReexamine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtnBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCreateReexamine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnViewReexamine)
                    .addComponent(jbtnViewAdd)
                    .addComponent(jbtnViewUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbtnViewAdd, jbtnViewUpdate});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnViewAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnViewAddActionPerformed
        if (this.jCreateReexamine.isVisible() == false) {
            this.jCreateReexamine.setVisible(true);
            actionAdd = true;
            this.jbtnAdd.setText("Add");
            this.jcbStatus.setVisible(false);
            this.jLabel5.setVisible(false);
            this.jbtnClose.setVisible(false);
        } else if (actionAdd == false && this.jCreateReexamine.isVisible() == true) {
            // Đang hiển thị update
            actionAdd = true;
            this.jbtnAdd.setText("Add");
            this.jcbStatus.setVisible(false);
            this.jLabel5.setVisible(false);
            this.jbtnClose.setVisible(false);
        } else {
            this.jCreateReexamine.setVisible(!this.jCreateReexamine.isVisible());
        }
    }//GEN-LAST:event_jbtnViewAddActionPerformed

    private void jbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBackActionPerformed
        // TODO add your handling code here:
        this.mClassRoom.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtnBackActionPerformed

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        // TODO add your handling code here:
        Date From = this.jFromDate.getDate();
        Date End = this.jEndDate.getDate();
        System.out.println(End.after(From));
        if (End.after(From)) {
            String hocKy = String.valueOf(jcbHK.getItemAt(jcbHK.getSelectedIndex()));
            String namHoc = String.valueOf(this.jYear.getYear());
            if (actionAdd == true) {
                // Thêm mới
                TableReexamine tReexamine = new TableReexamine(hocKy, 1, namHoc, From, End, account.getUserName(), account.getUserName());
                boolean checkCreate = TableReexamineDAO.createTableReeaxamine(tReexamine);
                if (checkCreate) {
                    JOptionPane.showMessageDialog(null, "Tạo lịch phúc khảo thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    this.jCreateReexamine.setVisible(false);
                    initLayout();
                }
            } else {
                // Cập nhật
                String _status = String.valueOf(jcbStatus.getItemAt(jcbStatus.getSelectedIndex()));

                int status = 0;
                if (_status.equals("Active")) {
                    status = 1;
                }

                TableReexamine tReexamine = new TableReexamine(hocKy, status, namHoc, From, End, account.getUserName());
                
                if (tReexamine != null) {
                    boolean checkUpdate = TableReexamineDAO.updateTableReeaxamine(tReexamine);
                    if (checkUpdate) {
                        JOptionPane.showMessageDialog(null, "Cập nhật lịch phúc khảo thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        this.jCreateReexamine.setVisible(false);
                        initLayout();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Xảy ra lỗi cập nhật.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    initLayout();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ngày kết thúc chưa hợp lệ.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnViewUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnViewUpdateActionPerformed
        // TODO add your handling code here:
        int selectRow = jTableReexamine.getSelectedRow();
        if (selectRow >= 0) {
            try {
                if (this.jCreateReexamine.isVisible() == false) {
                    actionAdd = false;
                    this.jCreateReexamine.setVisible(true);
                    this.jbtnAdd.setText("Submit");
                    this.jcbStatus.setVisible(true);
                    this.jLabel5.setVisible(true);
                    this.jbtnClose.setVisible(true);
                } else if (actionAdd == true && this.jCreateReexamine.isVisible() == true) {
                    actionAdd = false;
                    this.jCreateReexamine.setVisible(true);
                    this.jbtnAdd.setText("Submit");
                    this.jcbStatus.setVisible(true);
                    this.jLabel5.setVisible(true);
                    this.jbtnClose.setVisible(true);
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                String from = (String) jTableReexamine.getValueAt(selectRow, 2);
                Date x = sdf.parse(from);
                this.jFromDate.setDate(x);

                String end = (String) jTableReexamine.getValueAt(selectRow, 3);
                Date y = sdf.parse(end);
                this.jEndDate.setDate(y);

                String hocKy = (String) jTableReexamine.getValueAt(selectRow, 4);
                this.jcbHK.setSelectedItem(hocKy);

                String namHoc = (String) jTableReexamine.getValueAt(selectRow, 5);
                System.out.println(namHoc);
                this.jYear.setValue(Integer.valueOf(namHoc));

                String status = (String) jTableReexamine.getValueAt(selectRow, 6);
                this.jcbStatus.setSelectedItem(status);
            } catch (ParseException ex) {
                Logger.getLogger(manageTableReexamine.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng để thực hiện", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jbtnViewUpdateActionPerformed

    private void jbtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCloseActionPerformed
        // TODO add your handling code here:
        this.jCreateReexamine.setVisible(false);
    }//GEN-LAST:event_jbtnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(manageTableReexamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageTableReexamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageTableReexamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageTableReexamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageTableReexamine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jCreateReexamine;
    private com.toedter.calendar.JDateChooser jEndDate;
    private com.toedter.calendar.JDateChooser jFromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReexamine;
    private javax.swing.JLabel jTitle;
    private com.toedter.calendar.JYearChooser jYear;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnBack;
    private javax.swing.JButton jbtnClose;
    private javax.swing.JButton jbtnViewAdd;
    private javax.swing.JButton jbtnViewReexamine;
    private javax.swing.JButton jbtnViewUpdate;
    private javax.swing.JComboBox jcbHK;
    private javax.swing.JComboBox jcbStatus;
    // End of variables declaration//GEN-END:variables
}

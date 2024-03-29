/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien_hibernate;

import dao.ReexamineDAO;
import dao.StudentDAO;
import dao.TableReexamineDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojos.Reexamine;
import pojos.Student;
import pojos.TableReexamine;
import static quanlisinhvien_hibernate.Login.account;

/**
 *
 * @author DoDuyPhuong
 */
public class studentReexamine extends javax.swing.JFrame {

    /**
     * Creates new form studentReexamine
     */
    private studentLayout sLayout = null;
    private TableReexamine tReexamine = null;
    private final String[] columnNames = {
        "STT", "ID", "Môn Học", "Cột Điểm", "Điểm Đề Nghị", "Mô Tả", "Trạng Thái"
    };

    public studentReexamine() {
        this.setResizable(false);
        initComponents();
        initLayout();
        this.jtxtSuggestScore.addKeyListener(this.kAdapter);
    }

    public studentReexamine(studentLayout sLayout) {
        this.setResizable(false);
        this.sLayout = sLayout;
        this.sLayout.setVisible(false);
        initComponents();
        initLayout();
        this.jtxtSuggestScore.addKeyListener(this.kAdapter);
    }

    KeyAdapter kAdapter = new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char input = e.getKeyChar();
            if ((input < '0' || input > '9') && input != '.') {
                e.consume();
            }
        }
    };

    private void initLayout() {
        this.tReexamine = TableReexamineDAO.getTableReeaxamineActive();
        if (tReexamine != null) {
            String t = tReexamine.getNamHoc() + " - " + tReexamine.getHocKy();
            this.jHeader.setText(t);
        } else {
            String t = "Hiện phúc khảo chưa được mở.";
            this.jHeader.setText(t);
        }
//        List<Reexamine> listReexamine = ReexamineDAO.getListReexamine(account.getUserName());
        List<Reexamine> listReexamine = ReexamineDAO.getListReexamine("1742001");
        if (listReexamine.size() > 0) {
            int stt = 1;
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);
            //"STT", "ID", "Môn Học", "Cột Điểm", "Điểm Đề Nghị", "Mô Tả", "Trạng Thái"
            for (Reexamine re : listReexamine) {
                String[] rows = new String[7];
                rows[0] = String.valueOf(stt);
                rows[1] = String.valueOf(re.getId());
                rows[2] = re.getCourse();
                rows[3] = re.getRowScore();
                rows[4] = re.getSuggestScore().toString();
                rows[5] = re.getDescription();
                rows[6] = re.getStatus();

                tableModel.addRow(rows);
                stt++;
            }

            jTableReexamine.setModel(tableModel);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);
            jTableReexamine.setModel(tableModel);
        }

//        Student sd = StudentDAO.getStudent(account.getUserName());
        Student sd = StudentDAO.getStudent("1742001");
        if (sd != null) {
            this.jtxtMSSV.setText(sd.getMaStudent());
            this.jtxtName.setText(sd.getNameStudent());
        }
    }

    private boolean validateForm() {
        boolean validate = false;
        StringBuilder msgErr = new StringBuilder();

        String course = this.jtxtCourse.getText();
        String suggestScore = this.jtxtSuggestScore.getText();
        String description = this.jDescription.getText();

        if (course.equals("")) {
            validate = true;
            msgErr.append("Vui lòng nhập môn học.");
            msgErr.append("\n");
        }

        if (suggestScore.equals("")) {
            msgErr.append("Điểm đề nghị không thể trống");
            msgErr.append("\n");
        } else {
            Double tmp = Double.valueOf(suggestScore);
            if (tmp > 10 || tmp < 0) {
                validate = true;
                msgErr.append("Điểm đề nghị không hợp lệ");
                msgErr.append("\n");
            }
        }

        if (description.equals("")) {
            validate = true;
            msgErr.append("CMND không thể trống");
            msgErr.append("\n");
        }

        if (validate == true) {
            JOptionPane.showMessageDialog(null, msgErr, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return validate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReexamine = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jHeader = new javax.swing.JLabel();
        jPannelViewReexamine = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtMSSV = new javax.swing.JTextField();
        jtxtName = new javax.swing.JTextField();
        jtxtCourse = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtSuggestScore = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDescription = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jbtnCreate = new javax.swing.JButton();
        jcbRowScore = new javax.swing.JComboBox();
        jBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Yêu Cầu Phúc Khảo");

        jHeader.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jHeader.setText("2019");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("MSSV:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Họ tên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Môn học:");

        jtxtMSSV.setEnabled(false);
        jtxtMSSV.setMinimumSize(new java.awt.Dimension(6, 24));

        jtxtName.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Cột điểm:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Điểm đề nghị:");

        jDescription.setColumns(20);
        jDescription.setRows(5);
        jScrollPane2.setViewportView(jDescription);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Lý do:");

        jbtnCreate.setText("Create");
        jbtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateActionPerformed(evt);
            }
        });

        jcbRowScore.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbRowScore.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Giữa Kỳ", "Cuối Kỳ", "Tổng Kết" }));

        javax.swing.GroupLayout jPannelViewReexamineLayout = new javax.swing.GroupLayout(jPannelViewReexamine);
        jPannelViewReexamine.setLayout(jPannelViewReexamineLayout);
        jPannelViewReexamineLayout.setHorizontalGroup(
            jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPannelViewReexamineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtName)
                    .addComponent(jtxtCourse)
                    .addComponent(jtxtMSSV, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtSuggestScore, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jcbRowScore, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnCreate)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18))
        );
        jPannelViewReexamineLayout.setVerticalGroup(
            jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPannelViewReexamineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPannelViewReexamineLayout.createSequentialGroup()
                        .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbRowScore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jtxtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jtxtSuggestScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPannelViewReexamineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtxtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPannelViewReexamineLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnCreate)
                .addContainerGap())
        );

        jPannelViewReexamineLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jcbRowScore, jtxtSuggestScore});

        jBack.setText("Back");
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBack)
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPannelViewReexamine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPannelViewReexamine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed
        //TODO add your handling code here:
        boolean checkForm = validateForm();
        if (checkForm == false) {
            String mssv = this.jtxtMSSV.getText();
            String name = this.jtxtName.getText();
            String course = this.jtxtCourse.getText();
            String rowScore = (String) jcbRowScore.getItemAt(jcbRowScore.getSelectedIndex());
            Double suggestScore = Double.valueOf(this.jtxtSuggestScore.getText());
            String description = this.jDescription.getText();
            String status = "Chưa Xem";
            Reexamine re = new Reexamine(mssv, name, course, rowScore, suggestScore, description, status, this.tReexamine.getId());
            boolean checkCreate = ReexamineDAO.createReexamine(re);
            if (checkCreate) {
                JOptionPane.showMessageDialog(null, "Tạo phúc khảo thành công.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                this.jtxtCourse.setText("");
                this.jtxtSuggestScore.setText("");
                this.jDescription.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Xảy ra lỗi khởi tạo.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            initLayout();
        }
    }//GEN-LAST:event_jbtnCreateActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        // TODO add your handling code here:
        this.sLayout.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBackActionPerformed

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
            java.util.logging.Logger.getLogger(studentReexamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentReexamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentReexamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentReexamine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentReexamine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JTextArea jDescription;
    private javax.swing.JLabel jHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPannelViewReexamine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableReexamine;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JComboBox jcbRowScore;
    private javax.swing.JTextField jtxtCourse;
    private javax.swing.JTextField jtxtMSSV;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtSuggestScore;
    // End of variables declaration//GEN-END:variables
}

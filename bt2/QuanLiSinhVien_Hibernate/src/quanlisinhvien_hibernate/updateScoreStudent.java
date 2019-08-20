/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien_hibernate;

import dao.CalenderCourseDAO;
import dao.StudentDAO;
import dao.TableScoreDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import pojos.CalenderCourse;
import pojos.Student;
import pojos.TableScore;

/**
 *
 * @author CPU12407-local
 */
public class updateScoreStudent extends javax.swing.JDialog {

    private String className = "", idCourse = "", mStudent = "";
    private int type = 0;
    CalenderCourse cCourse = null;
    Student sd = null;
    /**
     * Creates new form updateScoreStudent
     */
    public updateScoreStudent() {
        initComponents();
        initLayout();
    }

    public updateScoreStudent(String _className, String idCourse, String _mStudent) {
        this.className = _className;
        this.idCourse = idCourse;
        this.mStudent = _mStudent;

        initComponents();
        initLayout();
    }

    public updateScoreStudent(String _className, String idCourse, String _mStudent, int type) {
        this.className = _className;
        this.idCourse = idCourse;
        this.mStudent = _mStudent;
        this.type = type;

        initComponents();
        initLayout();
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
        cCourse = CalenderCourseDAO.getCalenderCourse(this.className, this.idCourse);
        sd = StudentDAO.getStudent(mStudent);
        TableScore tbScore = TableScoreDAO.getRowInTableScore(cCourse.getId(), sd);
        if (tbScore != null) {
            if (this.type == 0) {
                jtfMSSV.setText(tbScore.getStudent().getMaStudent());
                jtfName.setText(tbScore.getStudent().getNameStudent());
                jtfDiemGK.setText(String.valueOf(tbScore.getScoreMiddleTest()));
                jtfDiemCK.setText(String.valueOf(tbScore.getScoreFinalTest()));
                jtfDiemKhac.setText(String.valueOf(tbScore.getScoreDifferent()));
                jtfDiemTong.setText(String.valueOf(tbScore.getFinalScore()));

                jtfDiemGK.addKeyListener(this.kAdapter);
                jtfDiemCK.addKeyListener(this.kAdapter);
                jtfDiemKhac.addKeyListener(this.kAdapter);
                jtfDiemTong.addKeyListener(this.kAdapter);
            }

            if (this.type == 1) {
                jtfDiemGK.setEditable(false);
                jtfDiemCK.setEditable(false);
                jtfDiemKhac.setEditable(false);
                jtfDiemTong.setEditable(false);
                jbtUpdate.setVisible(false);
                
                this.jLabel5.setText("ĐIỂM MÔN HỌC");
                jtfMSSV.setText(tbScore.getStudent().getMaStudent());
                jtfName.setText(tbScore.getStudent().getNameStudent());
                jtfDiemGK.setText(String.valueOf(tbScore.getScoreMiddleTest()));
                jtfDiemCK.setText(String.valueOf(tbScore.getScoreFinalTest()));
                jtfDiemKhac.setText(String.valueOf(tbScore.getScoreDifferent()));
                jtfDiemTong.setText(String.valueOf(tbScore.getFinalScore()));
            }

        } else {
            this.jLabel5.setText("Chưa có danh sách điểm");
            this.jPanel1.setVisible(false);
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

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtfDiemCK = new javax.swing.JTextField();
        jtfMSSV = new javax.swing.JTextField();
        jtfDiemTong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfDiemGK = new javax.swing.JTextField();
        jtfDiemKhac = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jbtUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CẬP NHẬT ĐIỂM");
        jLabel5.setToolTipText("");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Điểm tổng:");

        jtfMSSV.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Điểm CK:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("MSSV:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Điểm khác:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Điểm GK:");

        jtfName.setEnabled(false);

        jbtUpdate.setText("Cập nhật");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfDiemTong, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDiemKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDiemCK, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDiemGK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbtUpdate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtfDiemCK, jtfDiemGK, jtfDiemKhac, jtfDiemTong, jtfMSSV, jtfName});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfDiemGK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiemCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiemKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiemTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jbtUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtfDiemCK, jtfDiemGK, jtfDiemKhac, jtfDiemTong, jtfMSSV, jtfName});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed

        boolean validateFrom = validateScore();
        if (!validateFrom) {
            TableScore tbScore = TableScoreDAO.getRowInTableScore(cCourse.getId(), sd);
            
            tbScore.setScoreMiddleTest(Double.valueOf(jtfDiemGK.getText()));
            tbScore.setScoreFinalTest(Double.valueOf(jtfDiemCK.getText()));
            tbScore.setScoreDifferent(Double.valueOf(jtfDiemKhac.getText()));
            tbScore.setFinalScore(Double.valueOf(jtfDiemTong.getText()));

            boolean checkUpdate = TableScoreDAO.updateTableScore(tbScore);
            if(checkUpdate) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công.");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công.");
            }
            
            this.dispose();
        }
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private boolean validateScore() {
        boolean validate = false;
        double diemGK = 0;
        double diemCK = 0;
        double diemKhac = 0;
        double diemTong = 0;
        StringBuilder msgErr = new StringBuilder();

        if (jtfDiemGK.getText().equals("")) {
            validate = true;
            msgErr.append("Điểm giữa kỳ không thể trông");
            msgErr.append("\n");
        } else {
            diemGK = Double.valueOf(jtfDiemGK.getText());
            if (diemGK > 10 || diemGK < 0) {
                validate = true;
                msgErr.append("Điểm giữa kỳ không hợp lệ");
                msgErr.append("\n");
            }
        }

        if (jtfDiemCK.getText().equals("")) {
            msgErr.append("Điểm cuối kỳ không thể trông");
            msgErr.append("\n");
        } else {
            diemCK = Double.valueOf(jtfDiemCK.getText());
            if (diemCK > 10 || diemCK < 0) {
                validate = true;
                msgErr.append("Điểm cuối kỳ không hợp lệ");
                msgErr.append("\n");
            }
        }

        if (jtfDiemKhac.getText().equals("")) {
            msgErr.append("Điểm khác không thể trông");
            msgErr.append("\n");
        } else {
            Double.valueOf(jtfDiemKhac.getText());
            if (diemKhac > 10 || diemKhac < 0) {
                validate = true;
                msgErr.append("Điểm khác không hợp lệ");
                msgErr.append("\n");
            }
        }

        if (jtfDiemTong.getText().equals("")) {
            msgErr.append("Điểm tổng không thể trông");
            msgErr.append("\n");
        } else {
            Double.valueOf(jtfDiemTong.getText());
            if (diemTong > 10 || diemTong < 0) {
                validate = true;
                msgErr.append("Điểm tổng kỳ không hợp lệ");
                msgErr.append("\n");
            }
        }

        if (validate == true) {
            JOptionPane.showMessageDialog(null, msgErr, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return validate;
    }

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
            java.util.logging.Logger.getLogger(updateScoreStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateScoreStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateScoreStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateScoreStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateScoreStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JTextField jtfDiemCK;
    private javax.swing.JTextField jtfDiemGK;
    private javax.swing.JTextField jtfDiemKhac;
    private javax.swing.JTextField jtfDiemTong;
    private javax.swing.JTextField jtfMSSV;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
}
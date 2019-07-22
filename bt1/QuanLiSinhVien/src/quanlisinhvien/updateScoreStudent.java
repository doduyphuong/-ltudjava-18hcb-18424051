/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien;

import component.ClassRoomCourse;
import component.TableScore;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static quanlisinhvien.manageClassRoom.school;

/**
 *
 * @author CPU12407-local
 */
public class updateScoreStudent extends javax.swing.JDialog {

    private String className = "", idCourse = "", mStudent = "";
    private TableScore tbScore;
    private ClassRoomCourse crc;

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

    KeyAdapter kAdapter = new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char input = e.getKeyChar();
            if ((input < '0' || input > '9') && input != '.') {
                e.consume();
            }
        }
    };

    private void initLayout() {
        this.crc = school.getClassRoomCourse(this.className, this.idCourse);
        this.tbScore = crc.getTableScore(this.mStudent);
        jtfMSSV.setText(this.tbScore.getSd().getMSSV());
        jtfName.setText(this.tbScore.getSd().getName());
        jtfDiemGK.setText(String.valueOf(this.tbScore.getScoreMiddleTest()));
        jtfDiemCK.setText(String.valueOf(this.tbScore.getScoreFinalTest()));
        jtfDiemKhac.setText(String.valueOf(this.tbScore.getScoreDifferent()));
        jtfDiemTong.setText(String.valueOf(this.tbScore.getFinalScore()));
       
        jtfDiemGK.addKeyListener(this.kAdapter);
        jtfDiemCK.addKeyListener(this.kAdapter);
        jtfDiemKhac.addKeyListener(this.kAdapter);
        jtfDiemTong.addKeyListener(this.kAdapter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfDiemGK = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfMSSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbtUpdate = new javax.swing.JButton();
        jtfDiemKhac = new javax.swing.JTextField();
        jtfDiemCK = new javax.swing.JTextField();
        jtfDiemTong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("MSSV:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Điểm GK:");

        jtfMSSV.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jtfName.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cập nhật điểm");
        jLabel5.setToolTipText("");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jbtUpdate.setText("Cập nhật");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Điểm CK:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Điểm khác:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Điểm tổng:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(134, 134, 134))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfDiemTong, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDiemKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDiemCK, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDiemGK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtUpdate)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtfDiemCK, jtfDiemGK, jtfDiemKhac, jtfDiemTong, jtfMSSV, jtfName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfDiemGK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiemCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiemKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiemTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jbtUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtfDiemCK, jtfDiemGK, jtfDiemKhac, jtfDiemTong, jtfMSSV, jtfName});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed

        boolean validateFrom = validateScore();
        if (!validateFrom) {
            this.tbScore.setScoreMiddleTest(Double.valueOf(jtfDiemGK.getText()));
            this.tbScore.setScoreFinalTest(Double.valueOf(jtfDiemCK.getText()));
            this.tbScore.setScoreDifferent(Double.valueOf(jtfDiemKhac.getText()));
            this.tbScore.setFinalSrore(Double.valueOf(jtfDiemTong.getText()));
            
            this.crc.setTableScore(this.tbScore, className);
            school.setClassRoomCourse(this.className, this.idCourse, this.crc);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.");
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
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JTextField jtfDiemCK;
    private javax.swing.JTextField jtfDiemGK;
    private javax.swing.JTextField jtfDiemKhac;
    private javax.swing.JTextField jtfDiemTong;
    private javax.swing.JTextField jtfMSSV;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
}

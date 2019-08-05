/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien;

import component.Account;
import component.ClassRoom;
import component.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static quanlisinhvien.Login.account;
import static quanlisinhvien.Login.school;

/**
 *
 * @author CPU12407-local
 */
public class manageClassRoom extends javax.swing.JFrame {

    private final int FILE_OPEN = 1;
    private String[] columnNames = {
        "STT", "Lớp học", "Số sinh viên"
    };
    Login lg;

    /**
     * Creates new form manageClassRoom
     */
    public manageClassRoom() {
        initComponents();
        initLayout();
    }

    public manageClassRoom(Login _lg) {
        this.lg = _lg;
        initComponents();
        initLayout();
        this.lg.setVisible(false);
    }

    private void initLayout() {
        this.jPanelChangePasswd.setVisible(false);
        ArrayList<ClassRoom> listClassRoom = school.getListRoom();
        if (listClassRoom.size() > 0) {
            int stt = 1;
            DefaultTableModel tableModel = new DefaultTableModel();
            DefaultComboBoxModel comboboxModel = new DefaultComboBoxModel();
            tableModel.setColumnIdentifiers(columnNames);
            for (ClassRoom cr : listClassRoom) {
                String[] rows = new String[3];
                rows[0] = String.valueOf(stt);
                rows[1] = cr.getName();
                rows[2] = String.valueOf(cr.getListStudent().size());

                tableModel.addRow(rows);
                comboboxModel.addElement(cr.getName());
                stt++;
            }

            jTableClassRoom.setModel(tableModel);
            jcbClassRoom.setModel(comboboxModel);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);
            jTableClassRoom.setModel(tableModel);
            jcbClassRoom.setModel(new javax.swing.DefaultComboBoxModel(new String[]{}));
        }

    }

    private void operateFile(String title, int type) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(title);
        int choose = -1;
        switch (type) {
            case FILE_OPEN:
                choose = chooser.showOpenDialog(null);
                break;
        }

        if (choose == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            switch (type) {
                case FILE_OPEN:
                    readFile(file);
                    break;
            }
        }
    }

    private void readFile(File file) {
        try {
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);
                String line;
                // Lấy tên lớp
                line = br.readLine();
                String[] _className = line.split(",");

                ClassRoom cr;
                cr = school.getClassRoom(_className[0]);
                boolean checkExist = true;
                if (cr.checkNameClass("")) {
                    checkExist = false;
                    
                } else {
                    cr = new ClassRoom();
                }
                
                cr.setName(_className[0]);

                // Lấy filter name
//            line = br.readLine();
//            String[] filterName = line.split(",");
//            this.columnNames = filterName;
                // Lấy thông tin Student
                while ((line = br.readLine()) != null) {
                    String[] inforStudent = line.split(",");
                    Student student = new Student(inforStudent[0], inforStudent[1], inforStudent[3]);
                    int sex = -1;
                    if (inforStudent[2].equalsIgnoreCase("Nam")) {
                        sex = 0;
                    }

                    if (inforStudent[2].equalsIgnoreCase("Nữ")) {
                        sex = 1;
                    }

                    student.setSex(sex);
                    cr.addStudent(student);
                    if (!school.checkAccountExist(inforStudent[0])) {
                        Account _account = new Account(inforStudent[0], inforStudent[0], _className[0]);
                        school.getListAccount().add(_account);
                    }
                }

                if (checkExist == false) {
                    school.addClass(cr);
                    school.setNumClass(school.getNumClass() + 1);
                } else {
                    school.setClassRoom(cr, _className[0]);
                }

                br.close();
            }
            initLayout();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error to open file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClassRoom = new javax.swing.JTable();
        jbtImport = new javax.swing.JButton();
        jcbClassRoom = new javax.swing.JComboBox();
        jbtViewClass = new javax.swing.JButton();
        jbtLogout = new javax.swing.JButton();
        jPanelChangePasswd = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpfPasswdOld = new javax.swing.JPasswordField();
        jpfPasswdNew = new javax.swing.JPasswordField();
        jpfPasswdAgaint = new javax.swing.JPasswordField();
        jbtChangePass = new javax.swing.JButton();
        jbtChangePasswd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý lớp học");

        jTableClassRoom.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableClassRoom);

        jbtImport.setText("Import");
        jbtImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtImportActionPerformed(evt);
            }
        });

        jcbClassRoom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtViewClass.setText("View Class");
        jbtViewClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewClassActionPerformed(evt);
            }
        });

        jbtLogout.setText("Logout");
        jbtLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLogoutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Đổi mật khẩu");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Mật khẩu củ:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Mật khẩu mới:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Xác nhận lại MK:");

        jbtChangePass.setText("Thay đổi");
        jbtChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtChangePassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelChangePasswdLayout = new javax.swing.GroupLayout(jPanelChangePasswd);
        jPanelChangePasswd.setLayout(jPanelChangePasswdLayout);
        jPanelChangePasswdLayout.setHorizontalGroup(
            jPanelChangePasswdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChangePasswdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChangePasswdLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanelChangePasswdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanelChangePasswdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jpfPasswdNew, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpfPasswdOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpfPasswdAgaint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jbtChangePass)
                .addGap(72, 72, 72))
        );

        jPanelChangePasswdLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jpfPasswdAgaint, jpfPasswdNew, jpfPasswdOld});

        jPanelChangePasswdLayout.setVerticalGroup(
            jPanelChangePasswdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChangePasswdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChangePasswdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jpfPasswdOld, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanelChangePasswdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jpfPasswdNew, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtChangePass))
                .addGap(18, 18, 18)
                .addGroup(jPanelChangePasswdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jpfPasswdAgaint, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)))
        );

        jPanelChangePasswdLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jpfPasswdAgaint, jpfPasswdNew, jpfPasswdOld});

        jbtChangePasswd.setText("Đổi MK");
        jbtChangePasswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtChangePasswdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbClassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtViewClass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelChangePasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbtChangePasswd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jbtLogout, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtChangePasswd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbClassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtViewClass)
                            .addComponent(jbtImport)))
                    .addComponent(jPanelChangePasswd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtImportActionPerformed
        operateFile("Choose file import", FILE_OPEN);
    }//GEN-LAST:event_jbtImportActionPerformed

    private void jbtViewClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewClassActionPerformed
        String nameClass = String.valueOf(jcbClassRoom.getItemAt(jcbClassRoom.getSelectedIndex()));
        if (!nameClass.equals("null")) {
            manageStudent mStudent = new manageStudent(nameClass, this);
            mStudent.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa có danh sách lớp học.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jbtViewClassActionPerformed

    private void jbtLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLogoutActionPerformed
        this.lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtLogoutActionPerformed

    private boolean validateForm() {
        boolean validate = false;
        String oldPass = jpfPasswdOld.getText();
        String newPass = jpfPasswdNew.getText();
        String againtPass = jpfPasswdAgaint.getText();
        StringBuilder msgErr = new StringBuilder();

        if (oldPass.equals("")) {
            validate = true;
            msgErr.append("Vui lòng nhập mật khẩu.");
            msgErr.append("\n");
        }

        if (newPass.equals("")) {
            validate = true;
            msgErr.append("Vui lòng nhập mật khẩu mới");
            msgErr.append("\n");
        }

        if (againtPass.equals("")) {
            validate = true;
            msgErr.append("Vui lòng nhập lại mật khẩu");
            msgErr.append("\n");
        }

        if (validate == false) {
            if (!account.getPasswd().equals(oldPass)) {
                validate = true;
                msgErr.append("Nhập mật khẩu chưa đúng.");
                msgErr.append("\n");
            } else {
                if (!againtPass.equals(newPass)) {
                    validate = true;
                    msgErr.append("Nhập lại mật khẩu chưa đúng.");
                    msgErr.append("\n");
                }
            }
        }

        if (validate == true) {
            JOptionPane.showMessageDialog(null, msgErr, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return validate;
    }

    private void jbtChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtChangePassActionPerformed
        boolean validate = validateForm();
        if (!validate) {
            String username = account.getUsername();
            String passwd = account.getPasswd();
            for (Account _account : school.getListAccount()) {
                if (_account.getUsername().equals(username) && _account.getPasswd().equals(passwd)) {
                    account.setPasswd(jpfPasswdNew.getText());
                    school.getListAccount().set(school.getListAccount().indexOf(_account), _account);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            this.lg.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jbtChangePassActionPerformed

    private void jbtChangePasswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtChangePasswdActionPerformed
        this.jPanelChangePasswd.setVisible(!this.jPanelChangePasswd.isVisible());
    }//GEN-LAST:event_jbtChangePasswdActionPerformed

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
            java.util.logging.Logger.getLogger(manageClassRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageClassRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageClassRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageClassRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageClassRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelChangePasswd;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClassRoom;
    private javax.swing.JButton jbtChangePass;
    private javax.swing.JButton jbtChangePasswd;
    private javax.swing.JButton jbtImport;
    private javax.swing.JButton jbtLogout;
    private javax.swing.JButton jbtViewClass;
    private javax.swing.JComboBox jcbClassRoom;
    private javax.swing.JPasswordField jpfPasswdAgaint;
    private javax.swing.JPasswordField jpfPasswdNew;
    private javax.swing.JPasswordField jpfPasswdOld;
    // End of variables declaration//GEN-END:variables
}

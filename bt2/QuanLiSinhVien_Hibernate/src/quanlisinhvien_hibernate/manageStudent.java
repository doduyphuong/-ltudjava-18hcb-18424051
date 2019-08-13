/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien_hibernate;

import dao.ClassRoomDAO;
import dao.StudentDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojos.ClassRoom;
import pojos.Student;

/**
 *
 * @author CPU12407-local
 */
public class manageStudent extends javax.swing.JFrame {

    private final int FILE_OPEN = 1;
    private final int FILE_SAVE = 2;
    private String className = "17HCB";
    private String[] columnNames = {
        "STT", "MSSV", "Họ tên", "Giới tính", "CMND"
    };
    addStudent a;
    manageClassRoom mClassRoom;

    /**
     * Creates new form manageStudent
     */
    public manageStudent() {
        initComponents();
        initLayout();
    }

    public manageStudent(String className, manageClassRoom _mClassRoom) {
        this.className = className;
        this.mClassRoom = _mClassRoom;
        initComponents();
        initLayout();
        this.mClassRoom.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jbtImport = new javax.swing.JButton();
        jbtExport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudent = new javax.swing.JTable();
        jbAddStudent = new javax.swing.JButton();
        jbtUpdate = new javax.swing.JButton();
        jbtViewCourse = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sinh viên");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jbtImport.setText("Import");
        jbtImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtImportActionPerformed(evt);
            }
        });

        jbtExport.setText("Export");
        jbtExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExportActionPerformed(evt);
            }
        });

        jTableStudent.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableStudent);

        jbAddStudent.setText("Add Student");
        jbAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddStudentActionPerformed(evt);
            }
        });

        jbtUpdate.setText("Update");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });

        jbtViewCourse.setText("View Course");
        jbtViewCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewCourseActionPerformed(evt);
            }
        });

        jbtBack.setText("Back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtViewCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAddStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtExport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtImport)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtImport, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtExport)
                        .addComponent(jbAddStudent)
                        .addComponent(jbtUpdate)
                        .addComponent(jbtViewCourse)
                        .addComponent(jbtBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO addStudent your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jbtImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtImportActionPerformed
        operateFile("Choose file import", FILE_OPEN);
    }//GEN-LAST:event_jbtImportActionPerformed

    private void jbtExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExportActionPerformed
        operateFile("Export file", FILE_SAVE);
    }//GEN-LAST:event_jbtExportActionPerformed

    private void jbAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddStudentActionPerformed
        if (this.a == null) {
            this.a = new addStudent(this.className);
            this.a.setVisible(true);
        } else {
            this.a.setVisible(true);
        }

    }//GEN-LAST:event_jbAddStudentActionPerformed

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed
        this.initLayout();
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void jbtViewCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewCourseActionPerformed
        manageCalenderCourse calenderCourse = new manageCalenderCourse(this.className, this);
        calenderCourse.setVisible(true);
    }//GEN-LAST:event_jbtViewCourseActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        this.mClassRoom.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtBackActionPerformed

    private void operateFile(String title, int type) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(title);
        int choose = -1;
        switch (type) {
            case FILE_OPEN:
                choose = chooser.showOpenDialog(null);
                break;
            case FILE_SAVE:
                choose = chooser.showSaveDialog(null);
                break;
        }

        if (choose == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            switch (type) {
                case FILE_OPEN:
                    readFile(file);
                    break;
                case FILE_SAVE:
                    writeFile(file);
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
                String[] _className = line  .split(",");
                String maLop = _className[0].replaceAll("﻿", "");
                ClassRoom cr = ClassRoomDAO.getClassRoom(maLop);
                if(cr == null) {
                    cr.setMaClass(_className[0]);
                    ClassRoomDAO.createClassRoom(cr);
                }

                // Lấy filter name
//            line = br.readLine();
//            String[] filterName = line.split(",");
//            this.columnNames = filterName;
                // Lấy thông tin Student
                while ((line = br.readLine()) != null) {
                    String[] inforStudent = line.split(",");
                    Student student = new Student(inforStudent[0], inforStudent[1], inforStudent[3], cr);
                    int sex = -1;
                    if (inforStudent[2].equalsIgnoreCase("Nam")) {
                        sex = 0;
                    }

                    if (inforStudent[2].equalsIgnoreCase("Nữ")) {
                        sex = 1;
                    }

                    student.setSex(sex);
                    StudentDAO.createStudent(student);
                }
                br.close();
            }
            initLayout();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error to open file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void writeFile(File file) {
        try {
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), StandardCharsets.UTF_8)
            );

            // Ghi tên lớp
            bw.append(this.className);
            bw.append(',');
            bw.append(',');
            bw.append(',');
            bw.append("\r\n");

            // Ghi các filter
            bw.append(this.columnNames[1]);
            bw.append(',');
            bw.append(this.columnNames[2]);
            bw.append(',');
            bw.append(this.columnNames[3]);
            bw.append(',');
            bw.append(this.columnNames[4]);
            bw.append("\r\n");

            // Kiểm tra xem lớp có sinh viên hay không
            ClassRoom cr = ClassRoomDAO.getClassRoom(this.className);
            if (cr.getListStudent().size() > 0) {
                // Lấy danh sách học sinh trong lớp
                for (Student sd : cr.getListStudent()) {
                    bw.append(sd.getMaStudent());
                    bw.append(',');
                    bw.append(sd.getNameStudent());
                    bw.append(',');
                    if (sd.getSex() == 0) {
                        bw.append("Nam");
                    } else {
                        bw.append("Nữ");
                    }
                    bw.append(',');
                    bw.append(sd.getCmnd());
                    bw.append("\r\n");
                }
            }

//            bw.write(data.toString());
            bw.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error to save file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initLayout() {
        ClassRoom cr = ClassRoomDAO.getClassRoom(this.className);
        if (0 < cr.getListStudent().size()) {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);
            int stt = 1;

            for (Student sd : cr.getListStudent()) {
                String[] rows = new String[5];
                rows[0] = String.valueOf(stt);
                rows[1] = sd.getMaStudent();
                rows[2] = sd.getNameStudent();
                if (sd.getSex() == 0) {
                    rows[3] = "Nam";
                } else {
                    rows[3] = "Nữ";
                }
                rows[4] = sd.getCmnd();

                tableModel.addRow(rows);
                stt++;
            }

            jTableStudent.setModel(tableModel);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);
            jTableStudent.setModel(tableModel);
        }

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
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageStudent().setVisible(true);
//                mStudent = new manageStudent();
//                mStudent.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStudent;
    private javax.swing.JButton jbAddStudent;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtExport;
    private javax.swing.JButton jbtImport;
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JButton jbtViewCourse;
    // End of variables declaration//GEN-END:variables
}

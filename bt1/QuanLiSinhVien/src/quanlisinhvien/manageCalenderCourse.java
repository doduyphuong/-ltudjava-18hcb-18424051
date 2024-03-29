/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien;

import component.CalenderCourse;
import component.ClassRoom;
import component.ClassRoomCourse;
import component.Course;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static quanlisinhvien.Login.school;

/**
 *
 * @author CPU12407-local
 */
public class manageCalenderCourse extends javax.swing.JFrame {

    private final int FILE_OPEN = 1;
    private final int FILE_SAVE = 2;
    private String className = "17HCB";
    private String[] columnNames = {
        "STT", "Mã môn", "Tên môn", "Phòng học"
    };

    manageStudent mStudent;

    /**
     * Creates new form manageCalenderCourse
     */
    public manageCalenderCourse() {
        initComponents();
        initLayout();
    }

    public manageCalenderCourse(String _className, manageStudent mStudent) {
        this.className = _className;
        this.mStudent = mStudent;
        initComponents();
        initLayout();
        this.mStudent.setVisible(false);
    }

    private void initLayout() {
        ClassRoom cr = school.getClassRoom(className);
        ArrayList<CalenderCourse> listCalenderCourse = cr.getListCourse();
        if (listCalenderCourse.size() > 0) {
            int stt = 1;
            DefaultTableModel tableModel = new DefaultTableModel();
            DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
            tableModel.setColumnIdentifiers(columnNames);
            for (CalenderCourse calenderCourse : listCalenderCourse) {
                String[] rows = new String[4];
                rows[0] = String.valueOf(stt);
                rows[1] = calenderCourse.getCourse().getId();
                rows[2] = calenderCourse.getCourse().getName();
                rows[3] = calenderCourse.getLocation();

                tableModel.addRow(rows);
                cbModel.addElement(calenderCourse.getCourse().getId());
                stt++;
            }

            jtCalenderCourse.setModel(tableModel);
            jcbClassCourse.setModel(cbModel);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);
            jtCalenderCourse.setModel(tableModel);
            jcbClassCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[]{}));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtCalenderCourse = new javax.swing.JTable();
        jbtImport = new javax.swing.JButton();
        jbtExport = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();
        jcbClassCourse = new javax.swing.JComboBox();
        jbtnViewClassCourse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý lịch học");

        jtCalenderCourse.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtCalenderCourse);

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

        jbtBack.setText("Back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        jcbClassCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnViewClassCourse.setText("Class Course");
        jbtnViewClassCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnViewClassCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbClassCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnViewClassCourse)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtImport)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtImport)
                        .addComponent(jbtExport)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbClassCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnViewClassCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtImportActionPerformed
        operateFile("Choose file import", FILE_OPEN);
    }//GEN-LAST:event_jbtImportActionPerformed

    private void jbtExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExportActionPerformed
        operateFile("Export file", FILE_SAVE);
    }//GEN-LAST:event_jbtExportActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        this.mStudent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jbtnViewClassCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnViewClassCourseActionPerformed
        String idCourse = String.valueOf(jcbClassCourse.getItemAt(jcbClassCourse.getSelectedIndex()));
        if (!idCourse.equals("null")) {
            manageClassRoomCourse mClassRoomCourse = new manageClassRoomCourse(this, this.className, idCourse);
            mClassRoomCourse.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa có danh sách lịch học.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbtnViewClassCourseActionPerformed

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
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // Lấy tên lớp
            line = br.readLine();
//                String[] _className = line.split(",");

            ArrayList<ClassRoomCourse> listRoomCourse = new ArrayList<ClassRoomCourse>();
            
            ClassRoom cr = new ClassRoom();
            cr = school.getClassRoom(className);
            cr.getListCourse().clear();
            while ((line = br.readLine()) != null) {
                String[] _calenderCourse = line.split(",");

                // Tạo một thời khóa biểu cho môn học
                Course course = new Course(_calenderCourse[0], _calenderCourse[1]);
                CalenderCourse calenderCourse = new CalenderCourse(course, _calenderCourse[2]);
                
                
                cr.addCalenderCourse(calenderCourse);
                ClassRoomCourse crc = new ClassRoomCourse();
                crc.setClassName(className);
                crc.setIdCourse(_calenderCourse[0]);

                // Lấy danh sách sinh viên của lớp gán vào lớp học của môn
                crc.setListStudent(school.getClassRoom(className).getListStudent());
//                    
                listRoomCourse.add(crc);
            }

            school.setListRoomCourse(listRoomCourse);
            school.setClassRoom(cr, className);
            br.close();

            initLayout();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error to open file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void writeFile(File file) {

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
            java.util.logging.Logger.getLogger(manageCalenderCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageCalenderCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageCalenderCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageCalenderCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageCalenderCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtExport;
    private javax.swing.JButton jbtImport;
    private javax.swing.JButton jbtnViewClassCourse;
    private javax.swing.JComboBox jcbClassCourse;
    private javax.swing.JTable jtCalenderCourse;
    // End of variables declaration//GEN-END:variables
}

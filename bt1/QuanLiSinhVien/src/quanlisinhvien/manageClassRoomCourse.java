/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien;

import component.ClassRoomCourse;
import component.Student;
import component.TableScore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static quanlisinhvien.Login.school;

/**
 *
 * @author CPU12407-local
 */
public class manageClassRoomCourse extends javax.swing.JFrame {

    private String className = "", idCourse = "";
    manageCalenderCourse mcc;
    private final int FILE_OPEN = 1;
    addStudent a;
    updateScoreStudent uScoreStudent;
    private int type = 0;

    private final String[] columnNamesStudent = {
        "STT", "MSSV", "Họ tên", "Giới tính", "CMND"
    };

    private final String[] columnNamesTableScore = {
        "STT", "MSSV", "Họ tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng", "Kết quả"
    };

    /**
     * Creates new form manageClassRoomCourse
     */
    public manageClassRoomCourse() {
        initComponents();
        initLayout(this.columnNamesStudent);
        jbtnImportTableScore.setVisible(false);
        jPanelStatistic.setVisible(false);
        jbtReload.setVisible(false);
        this.setTitle(this.className + "-" + this.idCourse);
    }

    public manageClassRoomCourse(manageCalenderCourse _mcc, String _className, String _idCourse) {
        this.className = _className;
        this.idCourse = _idCourse;
        this.mcc = _mcc;
        this.type = 0;

        initComponents();
        initLayout(this.columnNamesStudent);
        jbtnImportTableScore.setVisible(false);
        jPanelStatistic.setVisible(false);
        jbtReload.setVisible(false);
        this.setTitle(this.className + "-" + this.idCourse);

        this.mcc.setVisible(false);
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
        jTableClassCourse = new javax.swing.JTable();
        jbtViewListStudent = new javax.swing.JButton();
        jbtViewTableScore = new javax.swing.JButton();
        jbtnImportTableScore = new javax.swing.JButton();
        jbtnBack = new javax.swing.JButton();
        jPanelStatistic = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfTotalFail = new javax.swing.JTextField();
        jtfTotalPass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfPercentFail = new javax.swing.JTextField();
        jtfPercentPass = new javax.swing.JTextField();
        jbtRemoveUpdate = new javax.swing.JButton();
        jbtAddStudent = new javax.swing.JButton();
        jbtUpdate = new javax.swing.JButton();
        jbtReload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableClassCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"123", "123", "123", "123"},
                {null, null, null, null},
                {"asd", "asd", "sad", null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableClassCourse);

        jbtViewListStudent.setText("DS Sinh Viên");
        jbtViewListStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewListStudentActionPerformed(evt);
            }
        });

        jbtViewTableScore.setText("Xem Bảng Điểm");
        jbtViewTableScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewTableScoreActionPerformed(evt);
            }
        });

        jbtnImportTableScore.setText("Import");
        jbtnImportTableScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImportTableScoreActionPerformed(evt);
            }
        });

        jbtnBack.setText("Back");
        jbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Thống kê:");

        jLabel3.setText("Số sinh viên rớt:");

        jLabel4.setText("Số sinh viên đậu:");

        jtfTotalFail.setText("0");
        jtfTotalFail.setDoubleBuffered(true);
        jtfTotalFail.setEnabled(false);
        jtfTotalFail.setName(""); // NOI18N

        jtfTotalPass.setText("0");
        jtfTotalPass.setEnabled(false);

        jLabel1.setText("Tỉ lệ:");

        jLabel5.setText("Tỉ lệ:");

        jtfPercentFail.setText("0");
        jtfPercentFail.setEnabled(false);

        jtfPercentPass.setText("0");
        jtfPercentPass.setEnabled(false);

        javax.swing.GroupLayout jPanelStatisticLayout = new javax.swing.GroupLayout(jPanelStatistic);
        jPanelStatistic.setLayout(jPanelStatisticLayout);
        jPanelStatisticLayout.setHorizontalGroup(
            jPanelStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatisticLayout.createSequentialGroup()
                .addGroup(jPanelStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStatisticLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStatisticLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfTotalFail, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jtfTotalPass))
                        .addGap(18, 18, 18)))
                .addGroup(jPanelStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelStatisticLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfPercentFail, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelStatisticLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfPercentPass)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanelStatisticLayout.setVerticalGroup(
            jPanelStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatisticLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfTotalFail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtfPercentFail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfTotalPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfPercentPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtRemoveUpdate.setText("Xóa");
        jbtRemoveUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRemoveUpdateActionPerformed(evt);
            }
        });

        jbtAddStudent.setText("Thêm SV");
        jbtAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddStudentActionPerformed(evt);
            }
        });

        jbtUpdate.setText("Cập nhật DS");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });

        jbtReload.setText("Reload");
        jbtReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnImportTableScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtReload)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jPanelStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtAddStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtRemoveUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtViewListStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtViewTableScore))))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbtViewListStudent, jbtViewTableScore});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtViewListStudent)
                            .addComponent(jbtnBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtViewTableScore, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnImportTableScore)
                    .addComponent(jbtRemoveUpdate)
                    .addComponent(jbtAddStudent)
                    .addComponent(jbtUpdate)
                    .addComponent(jbtReload))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtViewListStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewListStudentActionPerformed
        this.type = 0;
        initLayout(this.columnNamesStudent);
        jbtnImportTableScore.setVisible(false);
        jPanelStatistic.setVisible(false);
        this.jbtReload.setVisible(false);
        jbtAddStudent.setVisible(true);
        jbtUpdate.setVisible(true);
        jbtRemoveUpdate.setText("Xóa");
    }//GEN-LAST:event_jbtViewListStudentActionPerformed

    private void jbtViewTableScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewTableScoreActionPerformed
        this.type = 1;
        initLayout(this.columnNamesTableScore);
        jbtnImportTableScore.setVisible(true);
        jPanelStatistic.setVisible(true);
        this.jbtReload.setVisible(true);
        jbtRemoveUpdate.setText("Sửa");
        jbtAddStudent.setVisible(false);
        jbtUpdate.setVisible(false);
    }//GEN-LAST:event_jbtViewTableScoreActionPerformed

    private void jbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBackActionPerformed
        this.mcc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtnBackActionPerformed

    private void jbtnImportTableScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImportTableScoreActionPerformed
        operateFile("Choose file import", FILE_OPEN);
    }//GEN-LAST:event_jbtnImportTableScoreActionPerformed

    private void jbtRemoveUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRemoveUpdateActionPerformed
        int selectRow = jTableClassCourse.getSelectedRow();
        if (selectRow >= 0) {
            String _mssv = (String) jTableClassCourse.getValueAt(selectRow, 1);
            if (this.type == 0) {
                int res = JOptionPane.showConfirmDialog(this, "Có muốn xóa sinh viên khỏi khóa học không?", "Remove", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {
                    boolean removeStatus = removeStudent(_mssv);
                    if (removeStatus) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công", "Status", JOptionPane.INFORMATION_MESSAGE);
                        initLayout(this.columnNamesStudent);
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa không thành công ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (this.uScoreStudent == null) {
                    this.uScoreStudent = new updateScoreStudent(this.className, this.idCourse, _mssv);
                    this.uScoreStudent.setVisible(true);
                } else {
                    this.uScoreStudent = new updateScoreStudent(this.className, this.idCourse, _mssv);
                    this.uScoreStudent.setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng để thực hiện", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbtRemoveUpdateActionPerformed

    private void jbtAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddStudentActionPerformed
        if (this.a == null) {
            this.a = new addStudent(this.className, this.idCourse);
            this.a.setVisible(true);
        } else {
            this.a.setVisible(true);
        }
    }//GEN-LAST:event_jbtAddStudentActionPerformed

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed
        initLayout(this.columnNamesStudent);
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void jbtReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtReloadActionPerformed
        initLayout(this.columnNamesTableScore);
    }//GEN-LAST:event_jbtReloadActionPerformed

    private boolean removeStudent(String _mssv) {
        boolean result = false;
        ClassRoomCourse classRoomCourse = school.getClassRoomCourse(this.className, this.idCourse);
        ArrayList<Student> listStudent = new ArrayList<Student>();
        listStudent = classRoomCourse.getListStudent();

        int _index = -1;
        for (Student student : listStudent) {
            if (student.checkMSSV(_mssv)) {
                result = true;
                _index = listStudent.indexOf(student);
            }
        }

        if (result) {
            listStudent.remove(_index);
            classRoomCourse.setListStudent(listStudent);
            school.setClassRoomCourse(this.className, this.idCourse, classRoomCourse);
        }

        return result;
    }

    private void initLayout(String[] _columnName) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(_columnName);
        jTableClassCourse.setModel(tableModel);
        ClassRoomCourse classRoomCourse = school.getClassRoomCourse(this.className, this.idCourse);
        int stt = 1;

        if (this.type == 0) {
            ArrayList<Student> listStudent = classRoomCourse.getListStudent();
            if (listStudent.size() > 0) {
                for (Student student : listStudent) {
                    String[] rows = new String[5];
                    rows[0] = String.valueOf(stt);
                    rows[1] = student.getMSSV();
                    rows[2] = student.getName();
                    if (student.getSex() == 0) {
                        rows[3] = "Nam";
                    } else {
                        rows[3] = "Nữ";
                    }
                    rows[3] = student.getCMND();

                    tableModel.addRow(rows);
                    stt++;
                }

                jTableClassCourse.setModel(tableModel);
            }
        }

        if (this.type == 1) {
            ArrayList<TableScore> listTableScore = classRoomCourse.getListTableScore();
            if (listTableScore.size() > 0) {
                for (TableScore ts : listTableScore) {
                    String[] rows = new String[8];
                    rows[0] = String.valueOf(stt);
                    rows[1] = ts.getSd().getMSSV();
                    rows[2] = ts.getSd().getName();
                    rows[3] = String.valueOf(ts.getScoreMiddleTest());
                    rows[4] = String.valueOf(ts.getScoreFinalTest());
                    rows[5] = String.valueOf(ts.getScoreDifferent());
                    rows[6] = String.valueOf(ts.getFinalScore());
                    rows[7] = ts.getResult();

                    tableModel.addRow(rows);
                    stt++;
                }
                jTableClassCourse.setModel(tableModel);
                jtfTotalFail.setText(String.valueOf(classRoomCourse.getTotalFail()));
                jtfPercentFail.setText(String.valueOf(classRoomCourse.getPercentFail()));
                jtfTotalPass.setText(String.valueOf(classRoomCourse.getTotalPass()));
                jtfPercentPass.setText(String.valueOf(classRoomCourse.getPercentPass()));
            }
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
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // Lấy tên lớp
            line = br.readLine();
//            String[] _className = line.split(",");

            ClassRoomCourse classRoomCourse = school.getClassRoomCourse(this.className, this.idCourse);
            ArrayList<TableScore> listTableScore = classRoomCourse.getListTableScore();
            while ((line = br.readLine()) != null) {
                String[] _tableScore = line.split(",");

                // Tạo một thời khóa biểu cho môn học
                TableScore tbScore = new TableScore();
                Student sd = new Student(_tableScore[0], _tableScore[1]);
                tbScore.setSd(sd);
                tbScore.setScoreMiddleTest(Double.parseDouble(_tableScore[2]));
                tbScore.setScoreFinalTest(Double.parseDouble(_tableScore[3]));
                tbScore.setScoreDifferent(Double.parseDouble(_tableScore[4]));
                tbScore.setFinalSrore(Double.parseDouble(_tableScore[5]));

                listTableScore.add(tbScore);
            }

            classRoomCourse.setListTableScore(listTableScore);
            school.setClassRoomCourse(this.className, this.idCourse, classRoomCourse);
            br.close();

            initLayout(this.columnNamesTableScore);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error to open file: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(manageClassRoomCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageClassRoomCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageClassRoomCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageClassRoomCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageClassRoomCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelStatistic;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClassCourse;
    private javax.swing.JButton jbtAddStudent;
    private javax.swing.JButton jbtReload;
    private javax.swing.JButton jbtRemoveUpdate;
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JButton jbtViewListStudent;
    private javax.swing.JButton jbtViewTableScore;
    private javax.swing.JButton jbtnBack;
    private javax.swing.JButton jbtnImportTableScore;
    private javax.swing.JTextField jtfPercentFail;
    private javax.swing.JTextField jtfPercentPass;
    private javax.swing.JTextField jtfTotalFail;
    private javax.swing.JTextField jtfTotalPass;
    // End of variables declaration//GEN-END:variables
}

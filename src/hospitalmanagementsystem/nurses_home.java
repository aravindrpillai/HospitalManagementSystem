

package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



public class nurses_home extends javax.swing.JFrame {

    
    
    public nurses_home() {
        initComponents();
        
         table("SELECT * FROM nurses WHERE (id > 0) ORDER BY nurse_name ASC ");
        
        field_nurse_id.setEnabled(false);
        
        panel_btn_update.setVisible(false);
        panel_btn_remove.setVisible(false);
        panel_btn_add_nurse.setVisible(false);
    }

    
/*----------------------------------------------------------------------------*/    
// Function For : Establishing Connection with DATABASE
/*----------------------------------------------------------------------------*/    
    private Connection database() {
        Connection con = null;
        String db_url = "jdbc:mysql://localhost:3306/hospitalms";
        String db_driver = "com.mysql.jdbc.Driver";
        String db_username = "root";
        String db_password = "";
        
        try {
            Class.forName(db_driver);
            con = DriverManager.getConnection(db_url,db_username,db_password);
            } 
        catch (SQLException | ClassNotFoundException ex) { JOptionPane.showMessageDialog(null,ex); }
        return con;
    }

    
/*----------------------------------------------------------------------------*/    
// Function For : displaying DB values to table as per Query
// Example      : table("SELECT * FROM tbl_name"); 
/*----------------------------------------------------------------------------*/    
private void table(String query){
    Connection conn = database();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    try
    {
    pst = conn.prepareStatement(query);
    rs = pst.executeQuery();
    displayTable.setModel(DbUtils.resultSetToTableModel(rs));
    displayTable.setVisible(true);
    }
    catch(Exception ex)
    { JOptionPane.showMessageDialog(null,ex); }
}    
   
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        header_button_patients = new javax.swing.JButton();
        header_button_doctors = new javax.swing.JButton();
        header_button_nurses = new javax.swing.JButton();
        header_button_rooms = new javax.swing.JButton();
        header_button_receptionist = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        home_buttton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        add_nurse_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        field_nurse_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        field_nurse_id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        field_nurse_qualification = new javax.swing.JTextField();
        panel_btn_update = new javax.swing.JButton();
        panel_btn_remove = new javax.swing.JButton();
        panel_btn_add_nurse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Hospital Management System");

        header_button_patients.setText("Patients");
        header_button_patients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                header_button_patientsActionPerformed(evt);
            }
        });

        header_button_doctors.setText("Doctors");
        header_button_doctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                header_button_doctorsActionPerformed(evt);
            }
        });

        header_button_nurses.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        header_button_nurses.setText("Nurses");
        header_button_nurses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                header_button_nursesActionPerformed(evt);
            }
        });

        header_button_rooms.setText("Rooms");
        header_button_rooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                header_button_roomsActionPerformed(evt);
            }
        });

        header_button_receptionist.setText("Receptionist");
        header_button_receptionist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                header_button_receptionistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(header_button_patients, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header_button_doctors, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header_button_nurses, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header_button_rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header_button_receptionist)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(header_button_receptionist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header_button_rooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header_button_nurses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header_button_doctors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header_button_patients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("All Rights Reserved.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("MBCET Mini Project");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        home_buttton.setBackground(new java.awt.Color(204, 255, 102));
        home_buttton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        home_buttton.setText("Home");
        home_buttton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_butttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nurses");

        add_nurse_button.setText("Add Nurse");
        add_nurse_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_nurse_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home_buttton, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(add_nurse_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(add_nurse_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(home_buttton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
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
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Nurse Name : ");

        jLabel6.setText("Nurse Id");

        jLabel7.setText("Qualification :");

        panel_btn_update.setBackground(new java.awt.Color(51, 255, 0));
        panel_btn_update.setText("Update");
        panel_btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panel_btn_updateActionPerformed(evt);
            }
        });

        panel_btn_remove.setBackground(new java.awt.Color(255, 51, 102));
        panel_btn_remove.setText("Remove Nurse");
        panel_btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panel_btn_removeActionPerformed(evt);
            }
        });

        panel_btn_add_nurse.setBackground(new java.awt.Color(51, 102, 255));
        panel_btn_add_nurse.setText("+ Add Nurse");
        panel_btn_add_nurse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panel_btn_add_nurseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panel_btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel_btn_add_nurse, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_nurse_name, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_nurse_id, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(field_nurse_qualification))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field_nurse_name, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(field_nurse_id)
                    .addComponent(field_nurse_qualification))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_btn_add_nurse, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(panel_btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(panel_btn_remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void header_button_patientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_header_button_patientsActionPerformed
        this.dispose();
        new patients_home().setVisible(true);
    }//GEN-LAST:event_header_button_patientsActionPerformed

    private void header_button_doctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_header_button_doctorsActionPerformed
        this.dispose();
        new doctors_home().setVisible(true);
    }//GEN-LAST:event_header_button_doctorsActionPerformed

    private void header_button_nursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_header_button_nursesActionPerformed
        this.dispose();
        new nurses_home().setVisible(true);
    }//GEN-LAST:event_header_button_nursesActionPerformed

    private void header_button_roomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_header_button_roomsActionPerformed
        this.dispose();
        new rooms_home().setVisible(true);
    }//GEN-LAST:event_header_button_roomsActionPerformed

    private void header_button_receptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_header_button_receptionistActionPerformed
        this.dispose();
        new receptionist_home().setVisible(true);
    }//GEN-LAST:event_header_button_receptionistActionPerformed

    private void home_butttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_butttonActionPerformed
        this.dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_home_butttonActionPerformed

    private void displayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseClicked

        int row = displayTable.getSelectedRow();

        field_nurse_id.setText(displayTable.getModel().getValueAt(row,0).toString());
        field_nurse_name.setText(displayTable.getModel().getValueAt(row,1).toString());
        field_nurse_qualification.setText(displayTable.getModel().getValueAt(row,2).toString());

        panel_btn_update.setVisible(true);
        panel_btn_remove.setVisible(true);
        panel_btn_add_nurse.setVisible(false);
    }//GEN-LAST:event_displayTableMouseClicked

    private void panel_btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panel_btn_updateActionPerformed

        int id = Integer.parseInt(field_nurse_id.getText());
        String name = field_nurse_name.getText();
        String qualification = field_nurse_qualification.getText();

        if((!name.equals("")) && (!qualification.equals("")))
        {

            String update_value = "nurse_name = '"+name+"',qualification = '"+qualification+"'";
            String query = "UPDATE nurses SET "+update_value+" WHERE id = '"+id+"'";

            try {
                int flag = database().createStatement().executeUpdate(query);
                if(flag == 1)  JOptionPane.showMessageDialog(null,"Successfully Updated");
                else JOptionPane.showMessageDialog(null,"Error in Updation..");
            }
            catch (SQLException ex) { JOptionPane.showMessageDialog(null,"Error in Updation"); }

            table("SELECT * FROM nurses WHERE (id > 0) ORDER BY nurse_name ASC");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Fields cannot be left unfilled");
        }
    }//GEN-LAST:event_panel_btn_updateActionPerformed

    private void panel_btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panel_btn_removeActionPerformed

        int response = JOptionPane.showConfirmDialog(null, "Are you sure?");

        if(response == 0)
        {

            int id = Integer.parseInt(field_nurse_id.getText());

            try {
                int executeUpdate = database().createStatement().executeUpdate("DELETE FROM nurses WHERE id="+id);

                if(executeUpdate != 1) JOptionPane.showMessageDialog(null,"Failed To Execute");
                else JOptionPane.showMessageDialog(null,"Successfully Removed");

                field_nurse_name.setText(null);
                field_nurse_id.setText(null);
                field_nurse_qualification.setText(null);

                panel_btn_update.setVisible(false);
                panel_btn_remove.setVisible(false);
                panel_btn_add_nurse.setVisible(false);
                table("SELECT * FROM nurses WHERE (id > 0) ORDER BY nurse_name ASC");

            }
            catch (SQLException ex) {JOptionPane.showMessageDialog(null,"Error in Deletion\n\n"+ex); }
        }

    }//GEN-LAST:event_panel_btn_removeActionPerformed

    private void panel_btn_add_nurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panel_btn_add_nurseActionPerformed
        String query = "INSERT INTO nurses (nurse_name,qualification) VALUES ('"+field_nurse_name.getText()+"','"+field_nurse_qualification.getText()+"')";
        try {
            if(database().prepareStatement(query).executeUpdate() == 1)
            {
                JOptionPane.showMessageDialog(null,"New Nurse Added Successfully");
                field_nurse_name.setText(null);
                field_nurse_id.setText(null);
                field_nurse_qualification.setText(null);

                panel_btn_update.setVisible(false);
                panel_btn_remove.setVisible(false);
                panel_btn_add_nurse.setVisible(false);

                table("SELECT * FROM nurses WHERE (id > 0) ORDER BY nurse_name ASC");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Failed To Add New Nurse.");
            }

        }
        catch (SQLException ex) {JOptionPane.showMessageDialog(null,"Database Error \n\n"+ex);}
    }//GEN-LAST:event_panel_btn_add_nurseActionPerformed

    private void add_nurse_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_nurse_buttonActionPerformed

        field_nurse_name.setText(null);
        field_nurse_id.setText(null);
        field_nurse_qualification.setText(null);

        panel_btn_update.setVisible(false);
        panel_btn_remove.setVisible(false);
        panel_btn_add_nurse.setVisible(true);
    }//GEN-LAST:event_add_nurse_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(nurses_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nurses_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nurses_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nurses_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nurses_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_nurse_button;
    private javax.swing.JTable displayTable;
    private javax.swing.JTextField field_nurse_id;
    private javax.swing.JTextField field_nurse_name;
    private javax.swing.JTextField field_nurse_qualification;
    private javax.swing.JButton header_button_doctors;
    private javax.swing.JButton header_button_nurses;
    private javax.swing.JButton header_button_patients;
    private javax.swing.JButton header_button_receptionist;
    private javax.swing.JButton header_button_rooms;
    private javax.swing.JButton home_buttton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton panel_btn_add_nurse;
    private javax.swing.JButton panel_btn_remove;
    private javax.swing.JButton panel_btn_update;
    // End of variables declaration//GEN-END:variables

}

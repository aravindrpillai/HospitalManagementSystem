
package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class patient_records extends javax.swing.JFrame {

    int global_patient_id = 0;
    int global_report_id = 0;
    
    public patient_records(int patient_id) {
        initComponents();
        
        global_patient_id=patient_id;
        
        /*--display patient name on the side navigation bar-----*/
        String query = "SELECT patient_name FROM patients WHERE id = "+patient_id;
        try
        {
           ResultSet rs = database().prepareStatement(query).executeQuery();
           while(rs.next())  patient_name_display.setText(rs.getString("patient_name"));
        }
        catch(Exception ex){ JOptionPane.showMessageDialog(null,"Data Fetching Error : \n\n"+ex); }
        /*-------------------------------------------------------*/
        
        check_for_data(patient_id);
        table("");
        
        update_button.setVisible(false);
        delete_button.setVisible(false);
        add_button.setVisible(false);
        
        admitted_panel.setVisible(false);   
        fill_comboxes();
        
        
    }
    
    
    
    
    private void fill_comboxes(){
        combo_doctor_list.removeAllItems();
        combo_rooms_list.removeAllItems();
        
        ResultSet rs = null;
        try
        {
           rs = database().prepareStatement("SELECT id,doctor_name FROM doctors WHERE (id > 0)").executeQuery();
           while(rs.next()) { combo_doctor_list.addItem(rs.getString("id")+"-"+rs.getString("doctor_name")); }
           
           rs = database().prepareStatement("SELECT room_number FROM rooms WHERE type='AC'").executeQuery();
           while(rs.next()) { combo_rooms_list.addItem(rs.getString("room_number")); }
        }
        catch(Exception ex){ JOptionPane.showMessageDialog(null,"Data Fetching Error : \n\n"+ex); }
        
    }
    
    
    private void check_for_data(int patient_id){
        ResultSet rs = null;
        String query = "SELECT patient_id FROM reports WHERE patient_id = "+patient_id;
        try
        {
           rs = database().prepareStatement(query).executeQuery();
           int i=0; while(rs.next())i+=1;

            if(i==0)
            {
                query = "INSERT INTO reports (patient_id) VALUES ("+patient_id+")";
                if(database().prepareStatement(query).executeUpdate() == 1) table("");
                else
                {
                    this.dispose();
                    new list_patients().setVisible(true);
                }   
            }
        }
        catch(Exception ex){ JOptionPane.showMessageDialog(null,"Data Fetching Error : \n\n"+ex); }
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
// Example      : table("AND id=2");
/*----------------------------------------------------------------------------*/    
private void table(String where_condition){
    
    String query = "SELECT reports.id,patients.patient_name,reports.report,doctors.doctor_name,reports.admitted FROM reports INNER JOIN patients on reports.patient_id = patients.id INNER JOIN doctors on reports.doctor_id = doctors.id WHERE (reports.patient_id = "+global_patient_id+") "+where_condition+" ORDER BY reports.id DESC" ;

    ResultSet rs = null;
    
    try
    {
    rs = database().prepareStatement(query).executeQuery();
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
        jPanel4 = new javax.swing.JPanel();
        home_buttton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        patient_name_display = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        combo_doctor_list = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        form_report = new javax.swing.JTextArea();
        admitted_checkbox = new javax.swing.JCheckBox();
        admitted_panel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        combo_rooms_list = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        admitted_date_field = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        discharged_date_field = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        combo_room_type = new javax.swing.JComboBox();
        update_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        add_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Hospital Management System");

        header_button_patients.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        home_buttton.setBackground(new java.awt.Color(204, 255, 102));
        home_buttton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        home_buttton.setText("Home");
        home_buttton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_butttonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Patient Records");

        jButton3.setText("Add Patient");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("List Patients");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Patient Name : ");

        patient_name_display.setText("#");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patient_name_display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_name_display, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setText("New Record");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home_buttton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(home_buttton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Doctor : ");

        jLabel7.setText("Medical Report : ");

        form_report.setColumns(20);
        form_report.setRows(5);
        jScrollPane2.setViewportView(form_report);

        admitted_checkbox.setText("Admitted");
        admitted_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admitted_checkboxActionPerformed(evt);
            }
        });

        admitted_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Room Number : ");

        jLabel9.setText("Admitted On : ");

        jLabel10.setText("Discharged On : ");

        jLabel11.setText("Type : ");

        combo_room_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "Non AC" }));
        combo_room_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_room_typeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout admitted_panelLayout = new javax.swing.GroupLayout(admitted_panel);
        admitted_panel.setLayout(admitted_panelLayout);
        admitted_panelLayout.setHorizontalGroup(
            admitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admitted_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(admitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(discharged_date_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admitted_date_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, admitted_panelLayout.createSequentialGroup()
                        .addGroup(admitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(admitted_panelLayout.createSequentialGroup()
                        .addGroup(admitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(combo_room_type, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(admitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_rooms_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(admitted_panelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        admitted_panelLayout.setVerticalGroup(
            admitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admitted_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(admitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(admitted_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_rooms_list, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(combo_room_type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admitted_date_field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discharged_date_field, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        update_button.setBackground(new java.awt.Color(153, 255, 102));
        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        delete_button.setBackground(new java.awt.Color(255, 0, 0));
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        add_button.setBackground(new java.awt.Color(153, 153, 255));
        add_button.setText("Add New Record");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_button, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)
                        .addComponent(combo_doctor_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(admitted_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admitted_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(admitted_checkbox, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(combo_doctor_list))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(admitted_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(update_button, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new patients_home().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new list_patients().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void displayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseClicked
        int row = displayTable.getSelectedRow();
        int report_id = Integer.parseInt(displayTable.getModel().getValueAt(row,0).toString());
        
        update_button.setVisible(true);
        delete_button.setVisible(true);
        add_button.setVisible(false);
        
        global_report_id = report_id;
        
        ResultSet rs = null;
        String query = "SELECT reports.doctor_id,reports.report,reports.admitted,reports.admitted_date,reports.discharge_date,doctors.doctor_name,rooms.room_number,rooms.type FROM reports INNER JOIN doctors on reports.doctor_id = doctors.id INNER JOIN rooms on reports.room_number = rooms.room_number WHERE reports.id="+report_id;
        
        try
        {
            rs = database().prepareStatement(query).executeQuery();
            while(rs.next())
            {
                String doctor_combo_bor_selection = String.valueOf(rs.getString("doctor_id")+"-"+rs.getString("doctor_name"));
                combo_doctor_list.setSelectedItem(doctor_combo_bor_selection);
                
                form_report.setText(rs.getString("report"));
                
                String admitted = rs.getString("admitted");
                if(admitted.equals("No"))
                {
                    admitted_checkbox.setSelected(false);
                    admitted_panel.setVisible(false);
                }
                else
                {
                    admitted_checkbox.setSelected(true);
                    admitted_panel.setVisible(true);
                }
                
                String room_type = String.valueOf(rs.getString("type"));
                String room_number = String.valueOf(rs.getString("room_number"));
                
                //JOptionPane.showMessageDialog(null,room_type+" - "+room_number);
                
                combo_room_type.setSelectedItem(room_type);
                combo_rooms_list.setSelectedItem(room_number);
                
                String admitted_date = rs.getString("admitted_date");
                String discharge_date = rs.getString("discharge_date");
                
                try
                {
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                admitted_date_field.setDate(df.parse(admitted_date)); 
                discharged_date_field.setDate(df.parse(discharge_date)); 
                }
                catch(Exception ex) {}
            }
            
        }
        catch(Exception ex) { JOptionPane.showMessageDialog(null,ex); }

        
        
    }//GEN-LAST:event_displayTableMouseClicked

    
    
    private void admitted_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admitted_checkboxActionPerformed
      boolean i=  admitted_checkbox.isSelected();
       admitted_panel.setVisible(i);
      
    }//GEN-LAST:event_admitted_checkboxActionPerformed

    
    
    
    private void combo_room_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_room_typeActionPerformed
         String room_type = (String) combo_room_type.getSelectedItem();
       combo_rooms_list.removeAllItems();
         ResultSet rs = null;
       
        if(room_type.equals("AC"))
        {
            try
            {
               rs = database().prepareStatement("SELECT room_number FROM rooms WHERE type = 'AC'").executeQuery();
               while(rs.next()) { combo_rooms_list.addItem(rs.getString("room_number")); }
            }
            catch(Exception ex){ JOptionPane.showMessageDialog(null,"Data Fetching Error : \n\n"+ex); }
        }
        else
        {
            try
            {
               rs = database().prepareStatement("SELECT room_number FROM rooms WHERE (type != 'AC')").executeQuery();
               while(rs.next()) { combo_rooms_list.addItem(rs.getString("room_number")); }
            }
            catch(Exception ex){ JOptionPane.showMessageDialog(null,"Data Fetching Error : \n\n"+ex); }
        }
    }//GEN-LAST:event_combo_room_typeActionPerformed

    
    
    
    
    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
       
       String combo_doc_sel = (String) combo_doctor_list.getSelectedItem();
       String[] split = combo_doc_sel.split("-");
       int doctor_id = Integer.parseInt(split[0]);
       String doctor_name = split[1];
       
       String report = form_report.getText();
       
       String admitted = "No";
       String room_type = "Non AC";
       int room_number = 0;
       String admitted_date = "0000-00-00";
       String discharged_date = "0000-00-00";
       
       
       if(admitted_checkbox.isSelected() == true)
       {    
           admitted = "Yes";
           room_type = (String) combo_room_type.getSelectedItem();
           room_number = Integer.parseInt((String) combo_rooms_list.getSelectedItem());
           
           Format formatter = new SimpleDateFormat("yyyy-MM-dd");
           admitted_date = formatter.format(admitted_date_field.getDate());
           discharged_date = formatter.format(discharged_date_field.getDate());
       }
       
       String update = "doctor_id="+doctor_id+", room_number="+room_number+", report='"+report+"', admitted='"+admitted+"', admitted_date='"+admitted_date+"', discharge_date='"+discharged_date+"'";
       String query = "UPDATE reports SET "+update+" WHERE id = "+global_report_id;       
        
        //JOptionPane.showMessageDialog(null,query); 
       
        try {
                int flag = database().createStatement().executeUpdate(query);
                if(flag == 1)  JOptionPane.showMessageDialog(null,"Successfully Updated");
                else JOptionPane.showMessageDialog(null,"Error in Updation..");
            }
            catch (SQLException ex) { JOptionPane.showMessageDialog(null,"Error in Updation"); }

            table("");
       
       
    }//GEN-LAST:event_update_buttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        //combo_doctor_list.setSelectedItem(doctor_combo_bor_selection);
        form_report.setText(null);

        admitted_checkbox.setSelected(true);
        admitted_panel.setVisible(true);

        //combo_room_type.setSelectedItem(room_type);
        //combo_rooms_list.setSelectedItem(room_number);

        admitted_date_field.setDate(null); 
        discharged_date_field.setDate(null); 

        update_button.setVisible(false);
        delete_button.setVisible(false);
        add_button.setVisible(true);
       
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
       
       String combo_doc_sel = (String) combo_doctor_list.getSelectedItem();
       String[] split = combo_doc_sel.split("-");
       int doctor_id = Integer.parseInt(split[0]);
       String doctor_name = split[1];
       
       String report = form_report.getText();
       
       String admitted = "No";
       String room_type = "Non AC";
       int room_number = 0;
       String admitted_date = "0000-00-00";
       String discharged_date = "0000-00-00";
       
       
       if(admitted_checkbox.isSelected() == true)
       {    
           admitted = "Yes";
           room_type = (String) combo_room_type.getSelectedItem();
           room_number = Integer.parseInt((String) combo_rooms_list.getSelectedItem());
           
           Format formatter = new SimpleDateFormat("yyyy-MM-dd");
           admitted_date = formatter.format(admitted_date_field.getDate());
           discharged_date = formatter.format(discharged_date_field.getDate());
       }
       
       String values = "("+global_patient_id+", "+doctor_id+", "+room_number+", '"+report+"', '"+admitted+"', '"+admitted_date+"', '"+discharged_date+"')";
       String query = "INSERT INTO reports (patient_id,doctor_id,room_number,report,admitted,admitted_date,discharge_date) VALUES "+values;
        
        JOptionPane.showMessageDialog(null,query); 
       
        try {
                int flag = database().createStatement().executeUpdate(query);
                if(flag == 1)  JOptionPane.showMessageDialog(null,"Successfully Added New Record");
                else JOptionPane.showMessageDialog(null,"Error In New Record Creation..");
            }
            catch (SQLException ex) { JOptionPane.showMessageDialog(null,"Error In New Record Creation"); }

            table("");
       
       
    }//GEN-LAST:event_add_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
       int response = JOptionPane.showConfirmDialog(null, "Are you sure?");
        
        if(response == 0)
        {
           
       String query = "DELETE FROM reports WHERE id="+global_report_id;
        
        try { 
           int executeUpdate = database().createStatement().executeUpdate(query); 
            
           if(executeUpdate != 1) JOptionPane.showMessageDialog(null,"Failed To Execute");
           else 
           {
                form_report.setText(null);

                admitted_checkbox.setSelected(true);
                admitted_panel.setVisible(true);
                admitted_date_field.setDate(null); 
                discharged_date_field.setDate(null); 

                update_button.setVisible(false);
                delete_button.setVisible(false);
                add_button.setVisible(true);
               
               
                update_button.setVisible(false);
                delete_button.setVisible(false);
                add_button.setVisible(false);
                JOptionPane.showMessageDialog(null,"Successfully Removed");
           }
                
        table("");
            
            } 
        catch (SQLException ex) {JOptionPane.showMessageDialog(null,"Error in Deletion\n\n"+ex); }
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(patient_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient_records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient_records(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JCheckBox admitted_checkbox;
    private com.toedter.calendar.JDateChooser admitted_date_field;
    private javax.swing.JPanel admitted_panel;
    private javax.swing.JComboBox combo_doctor_list;
    private javax.swing.JComboBox combo_room_type;
    private javax.swing.JComboBox combo_rooms_list;
    private javax.swing.JButton delete_button;
    private com.toedter.calendar.JDateChooser discharged_date_field;
    private javax.swing.JTable displayTable;
    private javax.swing.JTextArea form_report;
    private javax.swing.JButton header_button_doctors;
    private javax.swing.JButton header_button_nurses;
    private javax.swing.JButton header_button_patients;
    private javax.swing.JButton header_button_receptionist;
    private javax.swing.JButton header_button_rooms;
    private javax.swing.JButton home_buttton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel patient_name_display;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables

}

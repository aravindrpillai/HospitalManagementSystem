

package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



public class rooms_home extends javax.swing.JFrame {

        int global_room_number = 0;
        int global_report_id = 0;

        
  public rooms_home() {
        initComponents();
        /*Only where condition required "WHERE rooms.room_number=101"*/
        table("");
        
        fill_nurse_list_combo();
        
        button_panel.setVisible(false);
        
        disp_patient_name.setEnabled(false);
        disp_doctor_name.setEnabled(false);
        disp_admitted_date.setEnabled(false);
        disp_report.setEnabled(false);

        
        
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
private void table(String where_condition){
    
    String required_data = "rooms.room_number,rooms.type,nurses.nurse_name";
    String query = "SELECT "+required_data+" FROM rooms INNER JOIN nurses on rooms.nurse_id = nurses.id "+where_condition;
    
    try
    {
        ResultSet rs = database().prepareStatement(query).executeQuery();
        displayTable.setModel(DbUtils.resultSetToTableModel(rs));
        displayTable.setVisible(true);
    }
    catch(Exception ex) { JOptionPane.showMessageDialog(null,ex); }
}    
   
    
/*----------------------------------------------------------------------------*/    
// Function For : displaying DB values to table as per Query
// Example      : table("SELECT * FROM tbl_name"); 
/*----------------------------------------------------------------------------*/    
private void table_for_rooms(){
    
    String required_data = "reports.id,patients.patient_name,reports.admitted_date,reports.discharge_date";
    String query = "SELECT "+required_data+" FROM reports INNER JOIN patients on reports.patient_id = patients.id WHERE reports.room_number="+global_room_number;
    
    try
    {
        ResultSet rs = database().prepareStatement(query).executeQuery();
        roomTable.setModel(DbUtils.resultSetToTableModel(rs));
        roomTable.setVisible(true);
    }
    catch(Exception ex) { JOptionPane.showMessageDialog(null,ex); }
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
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        home_buttton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        search_room_number = new javax.swing.JTextField();
        search_room_number_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        room_type_combo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        room_number_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        disp_patient_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        disp_doctor_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        disp_admitted_date = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        disp_report = new javax.swing.JTextArea();
        combo_nurses_list = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        disp_discharge_date = new com.toedter.calendar.JDateChooser();
        button_panel = new javax.swing.JPanel();
        saveBButton = new javax.swing.JButton();

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

        header_button_nurses.setText("Nurses");
        header_button_nurses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                header_button_nursesActionPerformed(evt);
            }
        });

        header_button_rooms.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
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

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("All Rights Reserved.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("MBCET Mini Project");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        home_buttton.setBackground(new java.awt.Color(204, 255, 102));
        home_buttton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        home_buttton.setText("Home");
        home_buttton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_butttonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Rooms");

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        search_room_number_button.setText("Search");
        search_room_number_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_room_number_buttonActionPerformed(evt);
            }
        });

        jLabel4.setText("Room Number : ");

        room_type_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "List All", "AC", "Non AC" }));
        room_type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_type_comboActionPerformed(evt);
            }
        });

        jLabel5.setText("Type : ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(search_room_number, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_room_number_button))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(room_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search_room_number_button, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(room_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search_room_number))
                .addContainerGap())
        );

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
        jScrollPane2.setViewportView(displayTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(home_buttton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(143, 143, 143))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(home_buttton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        roomTable.setModel(new javax.swing.table.DefaultTableModel(
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
        roomTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roomTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Room History : ");

        room_number_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(room_number_label, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(room_number_label, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Patient Name : ");

        jLabel6.setText("Doctor  : ");

        jLabel7.setText("Admitted Date : ");

        jLabel11.setText("Report : ");

        disp_report.setColumns(20);
        disp_report.setRows(5);
        jScrollPane3.setViewportView(disp_report);

        jLabel12.setText("Nurse In Charge :");

        jLabel13.setText("Discharge Date : ");

        button_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        saveBButton.setBackground(new java.awt.Color(102, 255, 51));
        saveBButton.setText("Save");
        saveBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout button_panelLayout = new javax.swing.GroupLayout(button_panel);
        button_panel.setLayout(button_panelLayout);
        button_panelLayout.setHorizontalGroup(
            button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, button_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        button_panelLayout.setVerticalGroup(
            button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button_panelLayout.createSequentialGroup()
                .addComponent(saveBButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(disp_patient_name, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(disp_doctor_name))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(disp_admitted_date, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane3))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_nurses_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(disp_discharge_date, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                    .addComponent(button_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(disp_patient_name, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(disp_doctor_name)
                    .addComponent(disp_admitted_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_nurses_list, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(disp_discharge_date, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))))
                .addGap(13, 13, 13)
                .addComponent(button_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    
    
    private void room_type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_type_comboActionPerformed
        
        room_number_label.setVisible(false);
        
        button_panel.setVisible(false);
        
        String room_type = (String) room_type_combo.getSelectedItem();
        
        if(room_type.equals("AC")) table(" WHERE type= 'AC'");
        else
            {
                if(room_type.equals("Non AC")) table(" WHERE type= 'Non AC'");
                else table("");
            }
        
    }//GEN-LAST:event_room_type_comboActionPerformed

    
    
    
    private void search_room_number_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_room_number_buttonActionPerformed
        
        button_panel.setVisible(false);
        
        room_number_label.setVisible(false);
        
        int room_number= 0;
        if(!search_room_number.getText().equals("")) 
        {
            try { room_number = Integer.parseInt(search_room_number.getText());  table("WHERE room_number = "+room_number); }
            catch(Exception ex) { JOptionPane.showMessageDialog(null,"Room Number Should Numeric"); }
        }
        else table("");
    }//GEN-LAST:event_search_room_number_buttonActionPerformed

    
    
    private void displayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseClicked
        int row = displayTable.getSelectedRow();
        global_room_number = Integer.parseInt(displayTable.getModel().getValueAt(row,0).toString());
        
        room_number_label.setText("Room Number : "+global_room_number);
          
        table_for_rooms();
        
    }//GEN-LAST:event_displayTableMouseClicked

    private void saveBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBButtonActionPerformed
        String nurse = (String)combo_nurses_list.getSelectedItem();
        String[] split = nurse.split("-");
        int nurse_id = Integer.parseInt(split[0]);
       
        Date d_discharge_date       = disp_discharge_date.getDate();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String discharge_date       = formatter.format(d_discharge_date);
        
        
        String update_rooms = "UPDATE rooms SET nurse_id = "+nurse_id+" WHERE room_number = "+global_room_number;
        String update_records = "UPDATE reports SET discharge_date = '"+discharge_date+"' WHERE id = "+global_report_id;
        
        try {
                int flag1 = database().createStatement().executeUpdate(update_rooms);
                int flag2 = database().createStatement().executeUpdate(update_records);
                if((flag1 == 1) && (flag2 == 1))   JOptionPane.showMessageDialog(null,"Successfully Updated");
                else JOptionPane.showMessageDialog(null,"Error in Updation..");
            }
        catch (SQLException ex) { JOptionPane.showMessageDialog(null,"Error in Updation"); }

        table("");
        table_for_rooms();
        
    }//GEN-LAST:event_saveBButtonActionPerformed

    
    private void fill_nurse_list_combo(){
    
        String query = "SELECT id,nurse_name FROM nurses WHERE (id>0)";
        try
        {
            ResultSet rs = database().prepareStatement(query).executeQuery();
            while(rs.next())
            {
                combo_nurses_list.addItem(rs.getString("id")+"-"+rs.getString("nurse_name"));
            }
        }
        catch(Exception ex) { JOptionPane.showMessageDialog(null,ex); }
    
    }
    
    
    
    
    private void roomTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTableMouseClicked
        
        button_panel.setVisible(true);
        
        int row = roomTable.getSelectedRow();
        global_report_id = Integer.parseInt(roomTable.getModel().getValueAt(row,0).toString());
        
        /* Now We have id's of both REPORT table and ROOM Table [global_report_id,global_room_id] */
        
        String required_data = "patients.patient_name,doctors.doctor_name,reports.admitted_date,reports.report,reports.discharge_date";
        String query = "SELECT "+required_data+" FROM reports INNER JOIN patients on reports.patient_id = patients.id  INNER JOIN doctors on reports.doctor_id = doctors.id WHERE reports.id="+global_report_id;

        try
        {
            ResultSet rs = database().prepareStatement(query).executeQuery();
            
            while(rs.next())
            {
                disp_patient_name.setText(rs.getString("patient_name"));
                disp_doctor_name.setText(rs.getString("doctor_name"));
                disp_admitted_date.setDate(rs.getDate("admitted_date"));
                disp_discharge_date.setDate(rs.getDate("discharge_date"));
                disp_report.setText(rs.getString("report"));
            }
        
            /*-code to get nurse ID-*/
            String nurse_in_charge = null;
            query = "SELECT rooms.nurse_id,nurses.nurse_name FROM rooms INNER JOIN nurses on rooms.nurse_id = nurses.id WHERE rooms.room_number="+global_room_number;

            try
            {
                rs = database().prepareStatement(query).executeQuery();
                while(rs.next())
                {
                   nurse_in_charge = rs.getString("nurse_id")+"-"+rs.getString("nurse_name");
                }
            }catch(Exception ex){JOptionPane.showMessageDialog(null,"Error : \n\n"+ex);}
            
            //JOptionPane.showMessageDialog(null,nurse_in_charge);
            
            combo_nurses_list.setSelectedItem(nurse_in_charge);
            /*----------------------*/
            
        }
        catch(SQLException ex) { JOptionPane.showMessageDialog(null,ex); }
        
    }//GEN-LAST:event_roomTableMouseClicked

    
    
    
    private void home_butttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_butttonActionPerformed
        this.dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_home_butttonActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(rooms_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rooms_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rooms_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rooms_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rooms_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel button_panel;
    private javax.swing.JComboBox combo_nurses_list;
    private com.toedter.calendar.JDateChooser disp_admitted_date;
    private com.toedter.calendar.JDateChooser disp_discharge_date;
    private javax.swing.JTextField disp_doctor_name;
    private javax.swing.JTextField disp_patient_name;
    private javax.swing.JTextArea disp_report;
    private javax.swing.JTable displayTable;
    private javax.swing.JButton header_button_doctors;
    private javax.swing.JButton header_button_nurses;
    private javax.swing.JButton header_button_patients;
    private javax.swing.JButton header_button_receptionist;
    private javax.swing.JButton header_button_rooms;
    private javax.swing.JButton home_buttton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable roomTable;
    private javax.swing.JLabel room_number_label;
    private javax.swing.JComboBox room_type_combo;
    private javax.swing.JButton saveBButton;
    private javax.swing.JTextField search_room_number;
    private javax.swing.JButton search_room_number_button;
    // End of variables declaration//GEN-END:variables

}

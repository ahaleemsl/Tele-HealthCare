/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EmergencyWorkArea;

import Business.DischargedPatient.DischargedPatient;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.EmergencyOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import Business.VitalSign.VitalSign;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Neelu
 */
public class CheckAlertsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EmergencyOrganization emergencyOrganization;
    private UserAccount userAccount;
    private Enterprise enterprise;
    
    
    /**
     * Creates new form CheckAlertsJPanel
     */
    public CheckAlertsJPanel(JPanel upc, EmergencyOrganization eo, UserAccount ua, Enterprise e) {
        initComponents();
        userAccount = ua;
        userProcessContainer = upc;
        emergencyOrganization = eo;
        enterprise = e;
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        genButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        iotTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Check Alerts From IOT Devices");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 16, -1, -1));

        genButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        genButton.setText("Generate Data");
        genButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genButtonActionPerformed(evt);
            }
        });
        add(genButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 109, 210, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Check Alerts From Patients");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("View Vital Signs");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 401, 240, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("View Medical Records");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 401, 240, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Send Help");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 530, 240, 53));

        iotTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iotTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Vital Signs", "Primary Doctor", "Treated For", "Timestamp"
            }
        ));
        jScrollPane2.setViewportView(iotTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 1150, 130));
    }// </editor-fold>//GEN-END:initComponents

    private void genButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genButtonActionPerformed
        // TODO add your handling code here:
         
         int xbp = 10;
         int xht = 10;
         int xrr = 10;
         int xw = 10;
         int ybp = 10;
         int yht = 10;
         int yrr = 10;
         int yw = 10;
         int zbp = 10;
         int zht = 10;
         int zrr = 10;
         int zw = 10;
         int flag = 0;
         
         
        
            for(DischargedPatient patient:enterprise.getDischargedPatientDirectory().getDischargedPatientList()){
                
                if(flag==0){
                    VitalSign vs = patient.getVitalSignHistory().addVitalSign();
                    vs.setBloodPressure(xbp);
                    vs.setHeartRate(xht);
                    vs.setRespiratoryRate(xrr);
                    vs.setWeight(xw);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    vs.setTimestamp(timeStamp);
                    vs.setStatusReport("Abnormal");
                    flag=1;
                    continue;
                }
                else if(flag==1){
                    VitalSign vs = patient.getVitalSignHistory().addVitalSign();
                    vs.setBloodPressure(ybp);
                    vs.setHeartRate(yht);
                    vs.setRespiratoryRate(yrr);
                    vs.setWeight(yw);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    vs.setTimestamp(timeStamp);
                    vs.setStatusReport("Abnormal");
                    flag=2;
                    continue;
                }
                else if(flag==2){
                    VitalSign vs = patient.getVitalSignHistory().addVitalSign();
                    vs.setBloodPressure(zbp);
                    vs.setHeartRate(zht);
                    vs.setRespiratoryRate(zrr);
                    vs.setWeight(zw);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    vs.setTimestamp(timeStamp);
                    vs.setStatusReport("Normal");
                    flag=0;
                    break;
                }
                
                return;
            }
        
        //fillColor();
        populateTable();
       
        
    }//GEN-LAST:event_genButtonActionPerformed

    public void fillColor(){
         DefaultTableModel model = (DefaultTableModel) iotTable.getModel();
        iotTable = new javax.swing.JTable(){    
             public Component prepareRenderer(TableCellRenderer r, int rw, int col) 
             { 
                 Component c = super.prepareRenderer(r, rw, col); c.setBackground(Color.GREEN);
                 if(col==0){ c.setBackground(Color.RED); 
                 }       
                 return c;
             }  
         };
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int selectedRow = iotTable.getSelectedRow();
        if(selectedRow>=0){
            
            DischargedPatient patient = (DischargedPatient)iotTable.getValueAt(selectedRow, 0);
            VitalSignJPanel panel = new VitalSignJPanel(userProcessContainer,patient);
            userProcessContainer.add("VitalSignJPanel", panel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
            
        }else{
            JOptionPane.showMessageDialog(null,"Please select a row from the alert table","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = iotTable.getSelectedRow();
        if(selectedRow>=0){
            DischargedPatient patient = (DischargedPatient)iotTable.getValueAt(selectedRow, 0);
        MedicalRecordJPanel panel = new MedicalRecordJPanel(userProcessContainer,patient);
            userProcessContainer.add("MedicalRecordJPanel", panel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
            
        }else{
            JOptionPane.showMessageDialog(null,"Please select a row from the alert table","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Emergency Services Activated!","Information",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    public void populateTable(){
          
         DefaultTableModel model = (DefaultTableModel) iotTable.getModel();
        
                        model.setRowCount(0);
        
        for(DischargedPatient patient:enterprise.getDischargedPatientDirectory().getDischargedPatientList()){
            for(VitalSign vs:patient.getVitalSignHistory().getVitalSignList()){
                if(vs.getStatusReport().equalsIgnoreCase("Abnormal")){
                   Object[] row = new Object[5];
                        row[0] = patient;
                        row[1]=vs.getStatusReport();
                        row[2]=patient.getPrimaryDoctor();
                        row[3]=patient.getMedicalRecord().getTreatedFor();
                        row[4]=vs.getTimestamp();
                        
                        model.addRow(row);
                        
                }
            }
        }
        iotTable.setBackground(Color.RED);
        iotTable.setForeground(Color.BLACK);
     
            
         
        
        ColoringCellRenderer r = new ColoringCellRenderer();
        r.setHighlighted(4, 2, true);
        Component c = r.getTableCellRendererComponent(iotTable, ui, true, true, 3, 5);
        c.setBackground(Color.red);
       
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton genButton;
    private javax.swing.JTable iotTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
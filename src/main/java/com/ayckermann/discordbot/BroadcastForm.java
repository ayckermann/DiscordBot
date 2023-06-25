/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ayckermann.discordbot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.api.entities.Guild;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class BroadcastForm extends javax.swing.JFrame {

    /**
     * Creates new form BroadcastForm
     */
    Database db = new Database();
    Broadcast jda = new Broadcast();
    public BroadcastForm() throws SQLException {
        initComponents();
        loadGuild();
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
        tblTable = new javax.swing.JTable();
        btnBroadUsers = new javax.swing.JButton();
        btdnBroadGuildMembers = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBroadcast = new javax.swing.JTextArea();
        btnBroadAllGuild = new javax.swing.JButton();
        ddGuild = new javax.swing.JComboBox<>();
        btnBroadGuild = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Message", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTable);

        btnBroadUsers.setBackground(new java.awt.Color(0, 102, 0));
        btnBroadUsers.setForeground(new java.awt.Color(255, 255, 255));
        btnBroadUsers.setText("TO USERS IN DATABASE");
        btnBroadUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadUsersActionPerformed(evt);
            }
        });

        btdnBroadGuildMembers.setBackground(new java.awt.Color(102, 102, 0));
        btdnBroadGuildMembers.setForeground(new java.awt.Color(255, 255, 255));
        btdnBroadGuildMembers.setText("TO SELECTED GUILD'S MEMBERS");
        btdnBroadGuildMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdnBroadGuildMembersActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Message");

        txtBroadcast.setColumns(20);
        txtBroadcast.setRows(5);
        jScrollPane2.setViewportView(txtBroadcast);

        btnBroadAllGuild.setBackground(new java.awt.Color(0, 102, 51));
        btnBroadAllGuild.setForeground(new java.awt.Color(255, 255, 255));
        btnBroadAllGuild.setText("TO GUILDS IN DATABASE");
        btnBroadAllGuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadAllGuildActionPerformed(evt);
            }
        });

        btnBroadGuild.setBackground(new java.awt.Color(102, 102, 0));
        btnBroadGuild.setForeground(new java.awt.Color(255, 255, 255));
        btnBroadGuild.setText("TO SELECTED GUILD");
        btnBroadGuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadGuildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addComponent(ddGuild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBroadAllGuild, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btdnBroadGuildMembers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBroadUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBroadGuild, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(ddGuild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnBroadUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBroadAllGuild)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBroadGuild)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btdnBroadGuildMembers)))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void loadGuild() throws SQLException{
        ResultSet resultSet= db.load("SELECT * FROM guild", null);
        while (resultSet.next()) {            
            String name = resultSet.getString("guildName");
            String id = resultSet.getString("guildId");
            ddGuild.addItem(name + "/" +id);
        }
    }
    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked

    }//GEN-LAST:event_tblTableMouseClicked

    private void btnBroadUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadUsersActionPerformed
        try {
            jda.broadcastToUsersInDb(txtBroadcast.getText());
        } catch (SQLException ex) {
            Logger.getLogger(BroadcastForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBroadUsersActionPerformed

    private void btdnBroadGuildMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdnBroadGuildMembersActionPerformed
        String comboBox = (String) ddGuild.getSelectedItem();
        String[] parts = comboBox.split("/");
        String guildId = parts[1];
        System.out.println(guildId);
        try {
            jda.broadcastToGuildMembers(guildId,txtBroadcast.getText());
        } catch (SQLException ex) {
            Logger.getLogger(BroadcastForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btdnBroadGuildMembersActionPerformed

    private void btnBroadAllGuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadAllGuildActionPerformed
         try {
            jda.broadcastToAllGuild(txtBroadcast.getText());
        } catch (SQLException ex) {
            Logger.getLogger(BroadcastForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBroadAllGuildActionPerformed

    private void btnBroadGuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadGuildActionPerformed
        String comboBox = (String) ddGuild.getSelectedItem();
        String[] parts = comboBox.split("/");
        String guildId = parts[1];
        System.out.println(guildId);
        try {
            jda.broadcastToGuild(guildId,txtBroadcast.getText());
        } catch (SQLException ex) {
            Logger.getLogger(BroadcastForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBroadGuildActionPerformed

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
            java.util.logging.Logger.getLogger(BroadcastForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BroadcastForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BroadcastForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BroadcastForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BroadcastForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BroadcastForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdnBroadGuildMembers;
    private javax.swing.JButton btnBroadAllGuild;
    private javax.swing.JButton btnBroadGuild;
    private javax.swing.JButton btnBroadUsers;
    private javax.swing.JComboBox<String> ddGuild;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextArea txtBroadcast;
    // End of variables declaration//GEN-END:variables
}

package com.ayckermann.discordbot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.SingleSelectionModel;
import javax.swing.table.DefaultTableModel;


public class MainForm extends javax.swing.JFrame {

    Database db = new Database();
    Broadcast jda = new Broadcast();
    
    SingleSelectionModel selectionModel = new DefaultSingleSelectionModel();

    public MainForm() throws SQLException {
        initComponents();
        menuBar.setSelectionModel(selectionModel);
        panelCommand.setVisible(false);
        panelBroadcast.setVisible(false);
        panelUser.setVisible(false);
        panelGuild.setVisible(false);
        panelLog.setVisible(false);
        panelAdmin.setVisible(false);
        
        //Message
        tblMessage.getColumnModel().getColumn(0).setMaxWidth(25);
        tblMessage.getColumnModel().getColumn(1).setMinWidth(100);
        tblMessage.getColumnModel().getColumn(2).setMinWidth(200);
        txtIdMessage.setVisible(false);
        this.dataMessage();
        
        //broadcast
        tblBroadcast.getColumnModel().getColumn(0).setMaxWidth(25);
        tblBroadcast.getColumnModel().getColumn(1).setMinWidth(150);
        tblBroadcast.getColumnModel().getColumn(2).setMinWidth(100);
        tblBroadcast.getColumnModel().getColumn(3).setMinWidth(80);
        
        
        //command
        tblCommand.getColumnModel().getColumn(0).setMaxWidth(25);
        tblCommand.getColumnModel().getColumn(1).setMinWidth(100);
        tblCommand.getColumnModel().getColumn(2).setMinWidth(200);
        txtIdCommand.setVisible(false);
       
        
        //user
        tblUser.getColumnModel().getColumn(0).setMinWidth(150);
        tblUser.getColumnModel().getColumn(0).setMaxWidth(250);
       
        //guild
        tblGuild.getColumnModel().getColumn(0).setMinWidth(150);
        tblGuild.getColumnModel().getColumn(0).setMaxWidth(250);
        
        //log
        tblLog.getColumnModel().getColumn(0).setMaxWidth(25);
        dateFromLog.setDateFormatString("yyyy-MM-dd");
        dateToLog.setDateFormatString("yyyy-MM-dd");
        
        //admin
        tblAdmin.getColumnModel().getColumn(0).setMaxWidth(25);
        txtIdAdmin.setVisible(false);

    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        panelMessage = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMessage = new javax.swing.JTable();
        txtMsgMessage = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRespondMessage = new javax.swing.JTextArea();
        btnAddMessage = new javax.swing.JButton();
        labelMsgMessage = new javax.swing.JLabel();
        labelRespondMessage = new javax.swing.JLabel();
        btnDeleteMessage = new javax.swing.JButton();
        btnUpdateMessage = new javax.swing.JButton();
        txtIdMessage = new javax.swing.JTextField();
        panelCommand = new javax.swing.JPanel();
        txtIdCommand = new javax.swing.JTextField();
        labelCommand = new javax.swing.JLabel();
        txtCommand = new javax.swing.JTextField();
        labelRespondCommand = new javax.swing.JLabel();
        spSlash1 = new javax.swing.JScrollPane();
        txtRespondCommand = new javax.swing.JTextArea();
        spSlash2 = new javax.swing.JScrollPane();
        tblCommand = new javax.swing.JTable();
        labelPrefix = new javax.swing.JLabel();
        txtPrefix = new javax.swing.JTextField();
        btnDeleteCommand = new javax.swing.JButton();
        btnUpdateCommand = new javax.swing.JButton();
        panelBroadcast = new javax.swing.JPanel();
        spBroadcast = new javax.swing.JScrollPane();
        tblBroadcast = new javax.swing.JTable();
        labelMsgBroadcast = new javax.swing.JLabel();
        spBrodcast1 = new javax.swing.JScrollPane();
        txtBroadcast = new javax.swing.JTextArea();
        ddGuild = new javax.swing.JComboBox<>();
        ddBroadType = new javax.swing.JComboBox<>();
        btnBroadcast = new javax.swing.JButton();
        btnSchedule = new javax.swing.JButton();
        inputDate = new com.toedter.calendar.JDateChooser();
        inputHour = new javax.swing.JSpinner();
        inputMinute = new javax.swing.JSpinner();
        labelDate = new javax.swing.JLabel();
        labelDate1 = new javax.swing.JLabel();
        labelDate2 = new javax.swing.JLabel();
        panelUser = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        labelUser = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        labelUserId = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnDeleteUser = new javax.swing.JButton();
        panelGuild = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGuild = new javax.swing.JTable();
        labelUser1 = new javax.swing.JLabel();
        txtGuildId = new javax.swing.JTextField();
        labelUserId1 = new javax.swing.JLabel();
        txtGuildname = new javax.swing.JTextField();
        btnDeleteGuild = new javax.swing.JButton();
        panelLog = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLog = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        dateFromLog = new com.toedter.calendar.JDateChooser();
        btnSearchLog = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dateToLog = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        panelAdmin = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        txtAdminname = new javax.swing.JTextField();
        btnAddAdmin = new javax.swing.JButton();
        labelMsgMessage1 = new javax.swing.JLabel();
        labelRespondMessage1 = new javax.swing.JLabel();
        btnDeleteAdmin = new javax.swing.JButton();
        btnUpdateAdmin = new javax.swing.JButton();
        txtIdAdmin = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        menuMessage = new javax.swing.JMenu();
        menuCommand = new javax.swing.JMenu();
        menuBroadcast = new javax.swing.JMenu();
        menuUser = new javax.swing.JMenu();
        menuGuild = new javax.swing.JMenu();
        menuLog = new javax.swing.JMenu();
        menuAdmin = new javax.swing.JMenu();
        listAdmin = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        listLogout = new javax.swing.JMenuItem();
        listExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aya Bot Admin");
        setName("Aya Bot Admin"); // NOI18N
        setSize(new java.awt.Dimension(800, 450));

        panelMessage.setBackground(new java.awt.Color(204, 255, 255));

        tblMessage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Message", "Respond"
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
        tblMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMessageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMessage);

        txtMsgMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMsgMessageActionPerformed(evt);
            }
        });

        txtRespondMessage.setColumns(20);
        txtRespondMessage.setRows(5);
        jScrollPane2.setViewportView(txtRespondMessage);

        btnAddMessage.setBackground(new java.awt.Color(0, 102, 0));
        btnAddMessage.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMessage.setText("ADD");
        btnAddMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMessageActionPerformed(evt);
            }
        });

        labelMsgMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMsgMessage.setText("Message");

        labelRespondMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRespondMessage.setText("Respond");

        btnDeleteMessage.setBackground(new java.awt.Color(153, 0, 0));
        btnDeleteMessage.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteMessage.setText("DELETE");
        btnDeleteMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMessageActionPerformed(evt);
            }
        });

        btnUpdateMessage.setBackground(new java.awt.Color(153, 153, 0));
        btnUpdateMessage.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateMessage.setText("UPDATE");
        btnUpdateMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMessageActionPerformed(evt);
            }
        });

        txtIdMessage.setEditable(false);
        txtIdMessage.setText("id");
        txtIdMessage.setFocusable(false);
        txtIdMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMessageLayout = new javax.swing.GroupLayout(panelMessage);
        panelMessage.setLayout(panelMessageLayout);
        panelMessageLayout.setHorizontalGroup(
            panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMessageLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMessageLayout.createSequentialGroup()
                        .addComponent(labelRespondMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(panelMessageLayout.createSequentialGroup()
                        .addGroup(panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMessageLayout.createSequentialGroup()
                                        .addGap(121, 121, 121)
                                        .addComponent(btnUpdateMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelMessageLayout.createSequentialGroup()
                                        .addGap(243, 243, 243)
                                        .addComponent(btnDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMsgMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelMsgMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMessageLayout.setVerticalGroup(
            panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(panelMessageLayout.createSequentialGroup()
                        .addComponent(labelMsgMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMsgMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRespondMessage, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(panelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelCommand.setBackground(new java.awt.Color(204, 255, 255));
        panelCommand.setPreferredSize(new java.awt.Dimension(800, 450));

        txtIdCommand.setEditable(false);
        txtIdCommand.setText("id");
        txtIdCommand.setFocusable(false);
        txtIdCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCommandActionPerformed(evt);
            }
        });

        labelCommand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCommand.setText("Command");

        txtCommand.setEditable(false);
        txtCommand.setEnabled(false);
        txtCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCommandActionPerformed(evt);
            }
        });

        labelRespondCommand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRespondCommand.setText("Respond");

        txtRespondCommand.setColumns(20);
        txtRespondCommand.setRows(5);
        spSlash1.setViewportView(txtRespondCommand);

        tblCommand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Command", "Respond"
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
        tblCommand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCommandMouseClicked(evt);
            }
        });
        spSlash2.setViewportView(tblCommand);

        labelPrefix.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPrefix.setText("Prefix");

        txtPrefix.setEditable(false);
        txtPrefix.setForeground(new java.awt.Color(0, 0, 0));
        txtPrefix.setText("/");
        txtPrefix.setEnabled(false);
        txtPrefix.setFocusable(false);
        txtPrefix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrefixActionPerformed(evt);
            }
        });

        btnDeleteCommand.setBackground(new java.awt.Color(153, 0, 0));
        btnDeleteCommand.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCommand.setText("DELETE");
        btnDeleteCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCommandActionPerformed(evt);
            }
        });

        btnUpdateCommand.setBackground(new java.awt.Color(153, 153, 0));
        btnUpdateCommand.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCommand.setText("UPDATE");
        btnUpdateCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCommandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCommandLayout = new javax.swing.GroupLayout(panelCommand);
        panelCommand.setLayout(panelCommandLayout);
        panelCommandLayout.setHorizontalGroup(
            panelCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCommandLayout.createSequentialGroup()
                .addGroup(panelCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCommandLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCommandLayout.createSequentialGroup()
                                .addComponent(labelPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(txtIdCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRespondCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCommand)
                            .addComponent(spSlash1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCommandLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnUpdateCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnDeleteCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(spSlash2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCommandLayout.setVerticalGroup(
            panelCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCommandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCommandLayout.createSequentialGroup()
                        .addGroup(panelCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPrefix)
                            .addComponent(txtPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelCommand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelRespondCommand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spSlash1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(panelCommandLayout.createSequentialGroup()
                        .addComponent(spSlash2, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        panelBroadcast.setBackground(new java.awt.Color(204, 255, 255));

        tblBroadcast.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Message", "Destination", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBroadcast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBroadcastMouseClicked(evt);
            }
        });
        spBroadcast.setViewportView(tblBroadcast);

        labelMsgBroadcast.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMsgBroadcast.setText("Message");

        txtBroadcast.setColumns(20);
        txtBroadcast.setRows(5);
        spBrodcast1.setViewportView(txtBroadcast);

        ddBroadType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TO USERS IN DATABASE", "TO GUILDS IN DATABASE", "TO SELECTED GUILD", "TO SELECTED GUILD'S MEMBER" }));

        btnBroadcast.setBackground(new java.awt.Color(0, 102, 51));
        btnBroadcast.setForeground(new java.awt.Color(255, 255, 255));
        btnBroadcast.setText("BROADCAST NOW");
        btnBroadcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadcastActionPerformed(evt);
            }
        });

        btnSchedule.setBackground(new java.awt.Color(153, 153, 0));
        btnSchedule.setForeground(new java.awt.Color(255, 255, 255));
        btnSchedule.setText("SCHEDULE BROADCAST");
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

        inputDate.setDateFormatString("dd/MM/yyyy");
        inputDate.setMinSelectableDate(date());

        inputHour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        inputMinute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        labelDate.setText("Date");

        labelDate1.setText("Hour");

        labelDate2.setText("Minute");

        javax.swing.GroupLayout panelBroadcastLayout = new javax.swing.GroupLayout(panelBroadcast);
        panelBroadcast.setLayout(panelBroadcastLayout);
        panelBroadcastLayout.setHorizontalGroup(
            panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBroadcastLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMsgBroadcast, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(spBrodcast1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelBroadcastLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ddGuild, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ddBroadType, 0, 345, Short.MAX_VALUE)))
                        .addGroup(panelBroadcastLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(btnBroadcast)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBroadcastLayout.createSequentialGroup()
                                        .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelDate2)
                                            .addComponent(inputMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(btnSchedule)))))
                .addGap(28, 28, 28)
                .addComponent(spBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBroadcastLayout.setVerticalGroup(
            panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBroadcastLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labelMsgBroadcast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBroadcastLayout.createSequentialGroup()
                        .addComponent(spBrodcast1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(ddBroadType, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(ddGuild, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(labelDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDate1)
                            .addComponent(labelDate2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBroadcastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBroadcast, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(panelBroadcastLayout.createSequentialGroup()
                        .addComponent(spBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                        .addGap(37, 37, 37))))
        );

        panelUser.setBackground(new java.awt.Color(204, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "Username", "Display Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUser);

        labelUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelUser.setText("Username");

        txtUserId.setEditable(false);
        txtUserId.setEnabled(false);

        labelUserId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelUserId.setText("User Id");

        txtUsername.setEditable(false);
        txtUsername.setEnabled(false);

        btnDeleteUser.setBackground(new java.awt.Color(153, 0, 0));
        btnDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setText("DELETE");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUserLayout.createSequentialGroup()
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addComponent(labelUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        panelGuild.setBackground(new java.awt.Color(204, 255, 255));

        tblGuild.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Guild Id", "Guild Name", "Default Channel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblGuild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGuildMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblGuild);

        labelUser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelUser1.setText("Guild Name");

        txtGuildId.setEditable(false);
        txtGuildId.setEnabled(false);

        labelUserId1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelUserId1.setText("Guild Id");

        txtGuildname.setEditable(false);
        txtGuildname.setEnabled(false);

        btnDeleteGuild.setBackground(new java.awt.Color(153, 0, 0));
        btnDeleteGuild.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteGuild.setText("DELETE");
        btnDeleteGuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteGuildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGuildLayout = new javax.swing.GroupLayout(panelGuild);
        panelGuild.setLayout(panelGuildLayout);
        panelGuildLayout.setHorizontalGroup(
            panelGuildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGuildLayout.createSequentialGroup()
                .addGroup(panelGuildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGuildLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelGuildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUserId1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGuildId, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGuildLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelGuildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGuildname, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGuildLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnDeleteGuild, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGuildLayout.setVerticalGroup(
            panelGuildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuildLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelGuildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGuildLayout.createSequentialGroup()
                        .addComponent(labelUserId1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGuildId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGuildname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnDeleteGuild, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        panelLog.setBackground(new java.awt.Color(204, 255, 255));

        tblLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "User Id", "Username", "Incoming", "Outgoing", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblLog);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Log");

        btnSearchLog.setBackground(new java.awt.Color(153, 153, 0));
        btnSearchLog.setText("SEARCH");
        btnSearchLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchLogActionPerformed(evt);
            }
        });

        jLabel2.setText("Filter from :");
        jLabel2.setAlignmentX(0.5F);

        jLabel3.setText("To :");

        javax.swing.GroupLayout panelLogLayout = new javax.swing.GroupLayout(panelLog);
        panelLog.setLayout(panelLogLayout);
        panelLogLayout.setHorizontalGroup(
            panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(panelLogLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateFromLog, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateToLog, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSearchLog, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelLogLayout.setVerticalGroup(
            panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateFromLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateToLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearchLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelAdmin.setBackground(new java.awt.Color(204, 255, 255));

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password"
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
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblAdmin);

        txtAdminname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminnameActionPerformed(evt);
            }
        });

        btnAddAdmin.setBackground(new java.awt.Color(0, 102, 0));
        btnAddAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAddAdmin.setText("ADD");
        btnAddAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdminActionPerformed(evt);
            }
        });

        labelMsgMessage1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMsgMessage1.setText("Username");

        labelRespondMessage1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRespondMessage1.setText("Password");

        btnDeleteAdmin.setBackground(new java.awt.Color(153, 0, 0));
        btnDeleteAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteAdmin.setText("DELETE");
        btnDeleteAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAdminActionPerformed(evt);
            }
        });

        btnUpdateAdmin.setBackground(new java.awt.Color(153, 153, 0));
        btnUpdateAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateAdmin.setText("UPDATE");
        btnUpdateAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAdminActionPerformed(evt);
            }
        });

        txtIdAdmin.setEditable(false);
        txtIdAdmin.setText("id");
        txtIdAdmin.setFocusable(false);
        txtIdAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAdminActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addComponent(labelRespondMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAdminname, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAddAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelAdminLayout.createSequentialGroup()
                                    .addGap(121, 121, 121)
                                    .addComponent(btnUpdateAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelAdminLayout.createSequentialGroup()
                                    .addGap(243, 243, 243)
                                    .addComponent(btnDeleteAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(labelMsgMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addComponent(labelMsgMessage1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdminname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRespondMessage1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209)
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuBar.setSelectionModel(null);

        menuMessage.setText("Message");
        menuMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMessageMouseClicked(evt);
            }
        });
        menuBar.add(menuMessage);

        menuCommand.setText("Command");
        menuCommand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCommandMouseClicked(evt);
            }
        });
        menuBar.add(menuCommand);

        menuBroadcast.setText("Broadcast");
        menuBroadcast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBroadcastMouseClicked(evt);
            }
        });
        menuBar.add(menuBroadcast);

        menuUser.setText("User List");
        menuUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUserMouseClicked(evt);
            }
        });
        menuBar.add(menuUser);

        menuGuild.setText("Guild List");
        menuGuild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuGuildMouseClicked(evt);
            }
        });
        menuBar.add(menuGuild);

        menuLog.setText("Log");
        menuLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogMouseClicked(evt);
            }
        });
        menuBar.add(menuLog);

        menuAdmin.setText("Admin");

        listAdmin.setText("Admin");
        listAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAdminActionPerformed(evt);
            }
        });
        menuAdmin.add(listAdmin);
        menuAdmin.add(jSeparator1);

        listLogout.setText("Log Out");
        listLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listLogoutActionPerformed(evt);
            }
        });
        menuAdmin.add(listLogout);

        listExit.setText("Exit");
        listExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listExitActionPerformed(evt);
            }
        });
        menuAdmin.add(listExit);

        menuBar.add(menuAdmin);

        setJMenuBar(menuBar);
        menuBar.getAccessibleContext().setAccessibleParent(menuMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGuild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCommand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGuild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCommand, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void dataMessage(){

        try {
            ResultSet resultSet =  db.load("SELECT * FROM msg_respond", null);
            DefaultTableModel tableModel = (DefaultTableModel)tblMessage.getModel();
            tableModel.setRowCount(0); //reset data
            
            while (resultSet.next()) {
                int id = resultSet.getInt("idMessage");
                String message =  resultSet.getString("message");
                String respond = resultSet.getString("respond");

                Object[] rowData = {id,message,respond};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println(ex);        }
    }
    
    private void setFieldMessage(){
        int row = tblMessage.getSelectedRow();
        String id = Integer.toString((int)tblMessage.getValueAt(row,0));
        txtIdMessage.setText(id);
        txtMsgMessage.setText((String)tblMessage.getValueAt(row,1));
        txtRespondMessage.setText((String)tblMessage.getValueAt(row,2));
    }
    
     private void voidMessage(){
        txtIdMessage.setText("");
        txtMsgMessage.setText("");
        txtRespondMessage.setText("");
    }
     
    
    void dataCommand(){
        try {

        ResultSet resultSet =  db.load("SELECT * FROM slash_command", null);
        DefaultTableModel tableModel = (DefaultTableModel)tblCommand.getModel();
        tableModel.setRowCount(0); //reset data

        while (resultSet.next()) {
            int id = resultSet.getInt("idSlash");
            String command =  resultSet.getString("slashCommand");
            String respond = resultSet.getString("respondSlash");

            Object[] rowData = {id,command,respond};
            tableModel.addRow(rowData);
        }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setFieldCommand(){
        int row = tblCommand.getSelectedRow();
        String id = Integer.toString((int)tblCommand.getValueAt(row,0));
        txtIdCommand.setText(id);
        txtCommand.setText((String)tblCommand.getValueAt(row,1));
        txtRespondCommand.setText((String)tblCommand.getValueAt(row,2));
    }
    private void voidCommand(){
        txtIdCommand.setText("");
        txtCommand.setText("");
        txtRespondCommand.setText("");
    }
    
    void dataBroadcast(){
     try {
            ResultSet resultSet =  db.load("SELECT * FROM broadcast", null);
            DefaultTableModel tableModel = (DefaultTableModel)tblBroadcast.getModel();
            tableModel.setRowCount(0); //reset data
            
            while (resultSet.next()) {
                int id = resultSet.getInt("idBroadcast");
                String message =  resultSet.getString("messageBroadcast");
                String destiniation = resultSet.getString("sentTo");
                String date = resultSet.getString("dateSent");

                Object[] rowData = {id,message,destiniation,date};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void loadGuild() throws SQLException{
        ResultSet resultSet= db.load("SELECT * FROM guild", null);
        while (resultSet.next()) {            
            String name = resultSet.getString("guildName");
            String id = resultSet.getString("guildId");
            ddGuild.addItem(name + "/" +id);
        }
    }
    private void voidBroadcast(){
        txtBroadcast.setText("");
    }
    
    Date date(){
        LocalDateTime localDateTime = LocalDateTime.now();

        // Convert LocalDateTime to Date
        ZoneId zoneId = ZoneId.systemDefault(); // Get the default time zone
        Date date = Date.from(localDateTime.atZone(zoneId).toInstant());
        return date;
    }
    
     void broadcastListener(String message, String schedule){
        String type = ddBroadType.getSelectedItem().toString();

        if(type.equals("TO USERS IN DATABASE")){
            try {
                jda.broadcastToUsersInDb(message,schedule);
                Object[] data ={message,type,schedule};
                db.edit("INSERT INTO broadcast (messageBroadcast, sentTo, dateSent) VALUES(?,?,?)", data);
            } catch (SQLException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(type.equals("TO GUILDS IN DATABASE")){
            try {
                jda.broadcastToAllGuild(message,schedule);
                Object[] data ={message,type,schedule};
                db.edit("INSERT INTO broadcast (messageBroadcast, sentTo, dateSent) VALUES(?,?,?)", data);
            } catch (SQLException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(type.equals("TO SELECTED GUILD")){
            String comboBox = (String) ddGuild.getSelectedItem();
            String[] parts = comboBox.split("/");
            String guildId = parts[1];
 
            try {
                jda.broadcastToGuild(guildId,message,schedule );
                String sentTo = "TO GUILD "+parts[0] ; 
                Object[] data ={message,sentTo,schedule};
                db.edit("INSERT INTO broadcast (messageBroadcast, sentTo, dateSent) VALUES(?,?,?)", data);
            } catch (SQLException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(type.equals("TO SELECTED GUILD'S MEMBER")){
            String comboBox = (String) ddGuild.getSelectedItem();
            String[] parts = comboBox.split("/");
            String guildId = parts[1];

            try {
                jda.broadcastToGuildMembers(guildId,message,schedule);
                String sentTo = "TO "+parts[0] +"GUILD MEMBER" ; 
                Object[] data ={message,sentTo,schedule};
                db.edit("INSERT INTO broadcast (messageBroadcast, sentTo, dateSent) VALUES(?,?,?)", data);
            } catch (SQLException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dataBroadcast();
            
    }
     
    void dataUser(){
        try {
        ResultSet resultSet =  db.load("SELECT * FROM user", null);
        DefaultTableModel tableModel = (DefaultTableModel)tblUser.getModel();
        tableModel.setRowCount(0); //reset data

        while (resultSet.next()) {
            String id = resultSet.getString("userId");
            String displayName =  resultSet.getString("displayName");
            String username = resultSet.getString("username");

            Object[] rowData = {id,username,displayName};
            tableModel.addRow(rowData);
        }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setFieldUser(){
        int row = tblUser.getSelectedRow();

        txtUserId.setText((String)tblUser.getValueAt(row,0));
        txtUsername.setText((String)tblUser.getValueAt(row,1));
    }
    private void voidUser(){
        txtUserId.setText("");
        txtUsername.setText("");
    }
    
    void dataGuild(){
        try {
        ResultSet resultSet =  db.load("SELECT * FROM guild", null);
        DefaultTableModel tableModel = (DefaultTableModel)tblGuild.getModel();
        tableModel.setRowCount(0); //reset data

        while (resultSet.next()) {
            String id = resultSet.getString("guildId");
            String guildName =  resultSet.getString("guildName");
            String defaultChannel = resultSet.getString("defaultChannel");

            Object[] rowData = {id,guildName,defaultChannel};
            tableModel.addRow(rowData);
        }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setFieldGuild(){
        int row = tblGuild.getSelectedRow();

        txtGuildId.setText((String)tblGuild.getValueAt(row,0));
        txtGuildname.setText((String)tblGuild.getValueAt(row,1));
    }
    private void voidGuuld(){
        txtGuildId.setText("");
        txtGuildname.setText("");
    }
    
    void dataLog(){
        try {
            ResultSet resultSet =  db.load("SELECT * FROM log ORDER BY id DESC", null);
            DefaultTableModel tableModel = (DefaultTableModel)tblLog.getModel();
            tableModel.setRowCount(0); //reset data
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userId =  resultSet.getString("userId");
                String username =  resultSet.getString("username");
                String incoming= resultSet.getString("incoming");
                String outgoing = resultSet.getString("outgoing");
                String date = resultSet.getString("date");

                Object[] rowData = {id,userId,username,incoming,outgoing,date};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void filterLog(){
        DefaultTableModel tableModel = (DefaultTableModel)tblLog.getModel();
        tableModel.setRowCount(0); //reset data
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        inputFormat.setTimeZone(TimeZone.getTimeZone("WIB"));
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateFrom = dateFromLog.getDate();
        Date dateTo = dateToLog.getDate();
        String stringFrom = outputFormat.format(dateFrom);
        String stringTo = outputFormat.format(dateTo);
   
        try {
                ResultSet resultSet =  db.load("SELECT * FROM log WHERE date(date)>=" + "date('"+ stringFrom+"') and date(date)<=" + "date('"+ stringTo+"')" , null);
            
                while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username =  resultSet.getString("username");
                String incoming= resultSet.getString("incoming");
                String outgoing = resultSet.getString("outgoing");
                String date = resultSet.getString("date");

                Object[] rowData = {id,username,incoming,outgoing,date};
                tableModel.addRow(rowData);
            }
        }
        catch (SQLException e) {
        }
    }
    public void dataAdmin(){

        try {
            ResultSet resultSet =  db.load("SELECT * FROM admin", null);
            DefaultTableModel tableModel = (DefaultTableModel)tblAdmin.getModel();
            tableModel.setRowCount(0); //reset data
            
            while (resultSet.next()) {
                int id = resultSet.getInt("idAdmin");
                String message =  resultSet.getString("adminname");
                String respond = resultSet.getString("password");

                Object[] rowData = {id,message,respond};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println(ex);        }
    }
    private void setFieldAdmin(){
        int row = tblAdmin.getSelectedRow();
        String id = Integer.toString((int)tblAdmin.getValueAt(row,0));
        txtIdAdmin.setText(id);
        txtAdminname.setText((String)tblAdmin.getValueAt(row,1));
        txtPassword.setText((String)tblAdmin.getValueAt(row,2));
    }
     private void voidAdmin(){
        txtAdminname.setText("");
        txtPassword.setText("");
    }
        
    private void menuMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMessageMouseClicked
       
        selectionModel.setSelectedIndex(0);
        this.dataMessage();
        panelMessage.setVisible(true);
        
        panelCommand.setVisible(false);
        panelBroadcast.setVisible(false);
        panelUser.setVisible(false);
        panelGuild.setVisible(false);
        panelLog.setVisible(false);
        panelAdmin.setVisible(false);

        
        
    }//GEN-LAST:event_menuMessageMouseClicked

    private void menuCommandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCommandMouseClicked
        selectionModel.setSelectedIndex(1);
        this.dataCommand();
        panelCommand.setVisible(true);
        
        panelMessage.setVisible(false);
        panelBroadcast.setVisible(false);
        panelUser.setVisible(false);
        panelGuild.setVisible(false);
        panelLog.setVisible(false);
        panelAdmin.setVisible(false);
    }//GEN-LAST:event_menuCommandMouseClicked

    private void tblMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMessageMouseClicked
        setFieldMessage();
    }//GEN-LAST:event_tblMessageMouseClicked

    private void txtMsgMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMsgMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMsgMessageActionPerformed

    private void btnAddMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMessageActionPerformed
        if(txtMsgMessage.getText().isBlank() || txtRespondMessage.getText().isBlank() ){
            JOptionPane.showInternalMessageDialog(null, "Ada data yang masih kosong");
        }
        else{
            Object[] checkUnique = {txtMsgMessage.getText()};
            ResultSet resultSet = db.load("SELECT message FROM msg_respond WHERE message=?", checkUnique);
            try {
                if(!resultSet.next()){
                    Object[] rowData = {txtMsgMessage.getText(),txtRespondMessage.getText() };
                    db.edit("INSERT INTO msg_respond (message,respond) VALUES(?,?)", rowData);
                    this.dataMessage();
                }
                else{
                    JOptionPane.showInternalMessageDialog(null, "Message must be unique");
                }
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "SQL error, try see the form");
            }


        }
        voidMessage();
    }//GEN-LAST:event_btnAddMessageActionPerformed

    private void btnDeleteMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMessageActionPerformed
        int row = tblMessage.getSelectedRow();

        int id = (int)tblMessage.getValueAt(row,0);

        Object[] data = {Integer.toString(id)};

        db.edit("DELETE FROM msg_respond WHERE idMessage=?", data);
        this.dataMessage();
        voidMessage();

    }//GEN-LAST:event_btnDeleteMessageActionPerformed

    private void btnUpdateMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMessageActionPerformed
        
        if(txtMsgMessage.getText().isBlank() || txtRespondMessage.getText().isBlank() ){
            JOptionPane.showInternalMessageDialog(null, "Ada data yang masih kosong");
        }
        else{
            Object[] checkUnique = {txtMsgMessage.getText()};
            ResultSet resultSet = db.load("SELECT message FROM msg_respond WHERE message=?", checkUnique);
            try {
                int counter= 0;
                
                while (resultSet.next()) {
                    counter++;
                    
                }
                if(counter == 1){
                    Object[] rowData = {txtMsgMessage.getText(),txtRespondMessage.getText(), txtIdMessage.getText()};

                    PreparedStatement preparedStmt = db.connection.prepareStatement("UPDATE msg_respond SET message =?, respond=? WHERE idMessage=?");            
                    
                    preparedStmt.setString (1, rowData[0].toString());
                    preparedStmt.setString (2, rowData[1].toString());
                    preparedStmt.setString (3, rowData[2].toString());
                    preparedStmt.executeUpdate();
                    
                    this.dataMessage();        
                }
                else{
                    JOptionPane.showInternalMessageDialog(null, "Message must be unique");
                }
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "SQL error, Message might not unique");
            }



        }
        voidMessage();
        

    }//GEN-LAST:event_btnUpdateMessageActionPerformed

    private void txtIdMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMessageActionPerformed

    private void menuBroadcastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBroadcastMouseClicked
        selectionModel.setSelectedIndex(2);
        this.dataBroadcast();
        try {
            this.loadGuild();
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelBroadcast.setVisible(true);
        
        panelMessage.setVisible(false);
        panelCommand.setVisible(false);
        panelUser.setVisible(false);
        panelGuild.setVisible(false);
        panelLog.setVisible(false);

    }//GEN-LAST:event_menuBroadcastMouseClicked

    private void menuUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUserMouseClicked
        selectionModel.setSelectedIndex(3);
        this.dataUser();
        panelUser.setVisible(true);
        
        panelCommand.setVisible(false);
        panelBroadcast.setVisible(false);
        panelMessage.setVisible(false);
        panelGuild.setVisible(false);
        panelLog.setVisible(false);
        panelAdmin.setVisible(false);
    }//GEN-LAST:event_menuUserMouseClicked

    private void menuGuildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGuildMouseClicked
        selectionModel.setSelectedIndex(4);
        this.dataGuild();
        panelGuild.setVisible(true);
        
        panelCommand.setVisible(false);
        panelBroadcast.setVisible(false);
        panelUser.setVisible(false);
        panelMessage.setVisible(false);
        panelLog.setVisible(false);
        panelAdmin.setVisible(false);
    }//GEN-LAST:event_menuGuildMouseClicked

    private void menuLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogMouseClicked
        selectionModel.setSelectedIndex(5);
        this.dataLog();
        panelLog.setVisible(true);
        
        panelCommand.setVisible(false);
        panelBroadcast.setVisible(false);
        panelUser.setVisible(false);
        panelGuild.setVisible(false);
        panelMessage.setVisible(false);
        panelAdmin.setVisible(false);
    }//GEN-LAST:event_menuLogMouseClicked

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        try{
            String message = txtBroadcast.getText();
            if(message==null || message.isEmpty()){
                JOptionPane.showInternalMessageDialog(null, "Pesan Masih Kosong");

            }else{

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date raw = inputDate.getDate();
                String date = formatter.format(raw);

                int valueHour = ((Number) (inputHour.getValue())).intValue();

                String hour = Integer.toString(valueHour);
                if(valueHour < 10){
                    hour = "0"+hour;
                }

                int valueMinute = ((Number) (inputMinute.getValue())).intValue();
                String minute = Integer.toString(valueMinute);
                if(valueMinute < 10){
                    minute = "0"+minute;
                }

                String schedule = date +" "+hour+":"+minute ;
                System.out.println(schedule);
                broadcastListener(message,schedule);

            }

        }
        catch(NullPointerException e){
            JOptionPane.showInternalMessageDialog(null, "Data Masih Kosong");

        }
        catch(Exception E){
            JOptionPane.showInternalMessageDialog(null, "Error yang lain");
            System.out.println(E);
        }
        voidBroadcast();
    }//GEN-LAST:event_btnScheduleActionPerformed

    private void btnBroadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadcastActionPerformed
        try{
            String message = txtBroadcast.getText();
            if(message==null || message.isEmpty()){
                JOptionPane.showInternalMessageDialog(null, "Pesan Masih Kosong");

            }else{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime currentDateTime = LocalDateTime.now();
                String now = currentDateTime.format(formatter);
                broadcastListener(message,now);
            }
        }
        catch(NullPointerException e){
            JOptionPane.showInternalMessageDialog(null, "Data Masih Kosong");

        }
        catch(Exception E){
            JOptionPane.showInternalMessageDialog(null, "Error yang lain");
            System.out.println(E);
        }
        voidBroadcast();
    }//GEN-LAST:event_btnBroadcastActionPerformed

    private void tblBroadcastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBroadcastMouseClicked

    }//GEN-LAST:event_tblBroadcastMouseClicked

    private void txtIdCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCommandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCommandActionPerformed

    private void txtCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCommandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCommandActionPerformed

    private void tblCommandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCommandMouseClicked
        this.setFieldCommand();
    }//GEN-LAST:event_tblCommandMouseClicked

    private void txtPrefixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrefixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrefixActionPerformed

    private void btnDeleteCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCommandActionPerformed
        int row = tblCommand.getSelectedRow();

        int id = (int)tblCommand.getValueAt(row,0);

        Object[] data = {Integer.toString(id)};

        db.edit("DELETE FROM slash_command WHERE idSlash=?", data);
        this.dataCommand();
        this.voidCommand();
    }//GEN-LAST:event_btnDeleteCommandActionPerformed

    private void btnUpdateCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCommandActionPerformed
        Object[] data = {txtRespondCommand.getText(), txtIdCommand.getText()};

        db.edit("UPDATE slash_command SET respondSlash=? WHERE idSlash=?", data);
        this.dataCommand();
        this.voidCommand();
    }//GEN-LAST:event_btnUpdateCommandActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        this.setFieldUser();
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        int row = tblUser.getSelectedRow();

        String id = (String)tblUser.getValueAt(row,0);

        Object[] data = {id};
        
        try {
            PreparedStatement preparedStmt = db.connection.prepareStatement("DELETE FROM user WHERE userId=?");
            
            for(int i =0; i<data.length ;i++){
                preparedStmt.setString ((i+1), data[i].toString());
            }
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Failed to delete");
        }

        this.dataUser();
        this.voidUser();

    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void tblGuildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGuildMouseClicked
        this.setFieldGuild();
    }//GEN-LAST:event_tblGuildMouseClicked

    private void btnDeleteGuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteGuildActionPerformed
        int row = tblGuild.getSelectedRow();

        String id = (String)tblGuild.getValueAt(row,0);

        Object[] data = {id};

        db.edit("DELETE FROM guild WHERE guildId=?", data);
        this.dataGuild();
        this.voidGuuld();
    }//GEN-LAST:event_btnDeleteGuildActionPerformed

    private void listAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAdminActionPerformed
        selectionModel.setSelectedIndex(6);
        this.dataAdmin();
        panelAdmin.setVisible(true);
 
        
        panelCommand.setVisible(false);
        panelBroadcast.setVisible(false);
        panelUser.setVisible(false);
        panelGuild.setVisible(false);
        panelMessage.setVisible(false);
        panelLog.setVisible(false);
    }//GEN-LAST:event_listAdminActionPerformed

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
        this.setFieldAdmin();
    }//GEN-LAST:event_tblAdminMouseClicked

    private void txtAdminnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminnameActionPerformed

    private void btnAddAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdminActionPerformed
        if(txtAdminname.getText().isBlank() || txtPassword.getText().isBlank() ){
            JOptionPane.showInternalMessageDialog(null, "Ada data yang masih kosong");
        }
        else{
            Object[] checkUnique = {txtAdminname.getText()};
            ResultSet resultSet = db.load("SELECT adminname FROM admin WHERE adminname=?", checkUnique);
            try {
                if(!resultSet.next()){
                    Object[] rowData = {txtAdminname.getText(),txtPassword.getText() };
                    db.edit("INSERT INTO admin (adminname,password) VALUES(?,?)", rowData);
                    this.dataAdmin();
                }
                else{
                    JOptionPane.showInternalMessageDialog(null, "Username must be unique");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        voidAdmin();
        
        
    }//GEN-LAST:event_btnAddAdminActionPerformed

    private void btnDeleteAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAdminActionPerformed
        int row = tblAdmin.getSelectedRow();

        int id = (int)tblAdmin.getValueAt(row,0);

        Object[] data = {Integer.toString(id)};

        db.edit("DELETE FROM admin WHERE idAdmin=?", data);
        this.dataAdmin();
        voidAdmin();
    }//GEN-LAST:event_btnDeleteAdminActionPerformed

    private void btnUpdateAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAdminActionPerformed
     if(txtAdminname.getText().isBlank() || txtPassword.getText().isBlank() ){
            JOptionPane.showInternalMessageDialog(null, "Ada data yang masih kosong");
        }
        else{
            Object[] checkUnique = {txtAdminname.getText()};
            ResultSet resultSet = db.load("SELECT adminname FROM admin WHERE adminname=?", checkUnique);
            try {
                int counter= 0;
                
                while (resultSet.next()) {
                    counter++;
                    
                }
                if(counter == 1){
                    Object[] rowData = {txtAdminname.getText(),txtPassword.getText(), txtIdAdmin.getText()};

                    PreparedStatement preparedStmt = db.connection.prepareStatement("UPDATE admin SET adminname =?, password=? WHERE idAdmin=?");            
                    
                    preparedStmt.setString (1, rowData[0].toString());
                    preparedStmt.setString (2, rowData[1].toString());
                    preparedStmt.setString (3, rowData[2].toString());
                    preparedStmt.executeUpdate();
                    
                    this.dataAdmin();
                }
                else{
                    JOptionPane.showInternalMessageDialog(null, "Message must be unique");
                }
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "SQL error, Message might not unique");
            }



        }
        voidAdmin();
        
    }//GEN-LAST:event_btnUpdateAdminActionPerformed

    private void txtIdAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAdminActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void listLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listLogoutActionPerformed
        this.dispose();
        jda.jda.shutdown();
        try {
            db.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        new LoginForm().setVisible(true);
        
        
    }//GEN-LAST:event_listLogoutActionPerformed

    private void listExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listExitActionPerformed

        System.exit(0);
    }//GEN-LAST:event_listExitActionPerformed

    private void btnSearchLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchLogActionPerformed
     
        if(dateFromLog.getDate()!=null && dateToLog.getDate() != null){
           filterLog();
        }else{
             JOptionPane.showInternalMessageDialog(null, "Date null");

        }
        
    }//GEN-LAST:event_btnSearchLogActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdmin;
    private javax.swing.JButton btnAddMessage;
    private javax.swing.JButton btnBroadcast;
    private javax.swing.JButton btnDeleteAdmin;
    private javax.swing.JButton btnDeleteCommand;
    private javax.swing.JButton btnDeleteGuild;
    private javax.swing.JButton btnDeleteMessage;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JButton btnSearchLog;
    private javax.swing.JButton btnUpdateAdmin;
    private javax.swing.JButton btnUpdateCommand;
    private javax.swing.JButton btnUpdateMessage;
    private com.toedter.calendar.JDateChooser dateFromLog;
    private com.toedter.calendar.JDateChooser dateToLog;
    private javax.swing.JComboBox<String> ddBroadType;
    private javax.swing.JComboBox<String> ddGuild;
    private com.toedter.calendar.JDateChooser inputDate;
    private javax.swing.JSpinner inputHour;
    private javax.swing.JSpinner inputMinute;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel labelCommand;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDate1;
    private javax.swing.JLabel labelDate2;
    private javax.swing.JLabel labelMsgBroadcast;
    private javax.swing.JLabel labelMsgMessage;
    private javax.swing.JLabel labelMsgMessage1;
    private javax.swing.JLabel labelPrefix;
    private javax.swing.JLabel labelRespondCommand;
    private javax.swing.JLabel labelRespondMessage;
    private javax.swing.JLabel labelRespondMessage1;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelUser1;
    private javax.swing.JLabel labelUserId;
    private javax.swing.JLabel labelUserId1;
    private javax.swing.JMenuItem listAdmin;
    private javax.swing.JMenuItem listExit;
    private javax.swing.JMenuItem listLogout;
    private javax.swing.JMenu menuAdmin;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBroadcast;
    private javax.swing.JMenu menuCommand;
    private javax.swing.JMenu menuGuild;
    private javax.swing.JMenu menuLog;
    private javax.swing.JMenu menuMessage;
    private javax.swing.JMenu menuUser;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelBroadcast;
    private javax.swing.JPanel panelCommand;
    private javax.swing.JPanel panelGuild;
    private javax.swing.JPanel panelLog;
    private javax.swing.JPanel panelMessage;
    private javax.swing.JPanel panelUser;
    private javax.swing.JScrollPane spBroadcast;
    private javax.swing.JScrollPane spBrodcast1;
    private javax.swing.JScrollPane spSlash1;
    private javax.swing.JScrollPane spSlash2;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTable tblBroadcast;
    private javax.swing.JTable tblCommand;
    private javax.swing.JTable tblGuild;
    private javax.swing.JTable tblLog;
    private javax.swing.JTable tblMessage;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtAdminname;
    private javax.swing.JTextArea txtBroadcast;
    private javax.swing.JTextField txtCommand;
    private javax.swing.JTextField txtGuildId;
    private javax.swing.JTextField txtGuildname;
    private javax.swing.JTextField txtIdAdmin;
    private javax.swing.JTextField txtIdCommand;
    private javax.swing.JTextField txtIdMessage;
    private javax.swing.JTextField txtMsgMessage;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPrefix;
    private javax.swing.JTextArea txtRespondCommand;
    private javax.swing.JTextArea txtRespondMessage;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

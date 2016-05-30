package view;

import control.RoomController;
import javax.swing.JOptionPane;

public class MainWindow extends javax.swing.JFrame 
{
    RoomController map;
  
    public MainWindow(RoomController map) 
    {
        this.map = map;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        print(map.getCurrentRoomDescription(), true);
    }
    
    private void print(String s, boolean append)
    {
        if (!append)
        {
            clearConsole();
        }
        jTextAreaMain.append(s + System.lineSeparator());
    }
    
    private void clearConsole()
    {
        jTextAreaMain.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogInventory = new javax.swing.JDialog();
        jScrollPaneInventory = new javax.swing.JScrollPane();
        jTableInventory = new javax.swing.JTable();
        jPanelMain = new javax.swing.JPanel();
        jScrollPaneMain = new javax.swing.JScrollPane();
        jTextAreaMain = new javax.swing.JTextArea();
        jTextFieldInput = new javax.swing.JTextField();
        jButtonDoAction = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jButtonInventory = new javax.swing.JButton();
        jProgressBarHealth = new javax.swing.JProgressBar();
        jLabelHp = new javax.swing.JLabel();

        jTableInventory.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneInventory.setViewportView(jTableInventory);

        javax.swing.GroupLayout jDialogInventoryLayout = new javax.swing.GroupLayout(jDialogInventory.getContentPane());
        jDialogInventory.getContentPane().setLayout(jDialogInventoryLayout);
        jDialogInventoryLayout.setHorizontalGroup(
            jDialogInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );
        jDialogInventoryLayout.setVerticalGroup(
            jDialogInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cirkus Dungeon Simulator");

        jTextAreaMain.setColumns(20);
        jTextAreaMain.setRows(5);
        jTextAreaMain.setFocusable(false);
        jScrollPaneMain.setViewportView(jTextAreaMain);

        jTextFieldInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInputActionPerformed(evt);
            }
        });

        jButtonDoAction.setText("Bingo");
        jButtonDoAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoActionActionPerformed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitle.setText("Eventyr Tid");

        jButtonInventory.setText("Inventory");
        jButtonInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventoryActionPerformed(evt);
            }
        });

        jProgressBarHealth.setBackground(new java.awt.Color(0, 255, 0));
        jProgressBarHealth.setForeground(new java.awt.Color(255, 0, 0));
        jProgressBarHealth.setValue(50);
        jProgressBarHealth.setStringPainted(true);

        jLabelHp.setText("HP:");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelHp)
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBarHealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(jButtonDoAction, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jButtonInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 220, Short.MAX_VALUE))
                    .addComponent(jScrollPaneMain)
                    .addComponent(jTextFieldInput))
                .addContainerGap())
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(17, 17, 17)
                .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDoAction)
                        .addComponent(jButtonInventory))
                    .addComponent(jProgressBarHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDoActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoActionActionPerformed
        String s = jTextFieldInput.getText();
        print(map.processInput(s), false);
        print(map.getCurrentRoomDescription(), true);
        jTextFieldInput.setText("");
    }//GEN-LAST:event_jButtonDoActionActionPerformed
    
    private void jButtonInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInventoryActionPerformed

    private void jTextFieldInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInputActionPerformed
        // Calls the action button
        jButtonDoActionActionPerformed(evt);
    }//GEN-LAST:event_jTextFieldInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDoAction;
    private javax.swing.JButton jButtonInventory;
    private javax.swing.JDialog jDialogInventory;
    private javax.swing.JLabel jLabelHp;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JProgressBar jProgressBarHealth;
    private javax.swing.JScrollPane jScrollPaneInventory;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JTable jTableInventory;
    private javax.swing.JTextArea jTextAreaMain;
    private javax.swing.JTextField jTextFieldInput;
    // End of variables declaration//GEN-END:variables
}

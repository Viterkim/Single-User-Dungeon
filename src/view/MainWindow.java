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
    }
    
    private void print(String s)
    {
        clearConsole();
        jTextAreaMain.append(s);
    }
    
    private void clearConsole()
    {
        jTextAreaMain.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMain = new javax.swing.JTextArea();
        jTextFieldInput = new javax.swing.JTextField();
        jButtonDoAction = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonInventory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cirkus Dungeon Simulator");

        jTextAreaMain.setColumns(20);
        jTextAreaMain.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMain);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Eventyr Tid");

        jButtonInventory.setText("Inventory");
        jButtonInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextFieldInput)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jButtonDoAction, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jButtonInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 203, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDoAction)
                    .addComponent(jButtonInventory))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDoActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoActionActionPerformed
        String s = jTextFieldInput.getText();
        print(map.processInput(s));
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMain;
    private javax.swing.JTextField jTextFieldInput;
    // End of variables declaration//GEN-END:variables
}

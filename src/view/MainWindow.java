package view;

import control.RoomController;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Player;

public class MainWindow extends javax.swing.JFrame 
{
    RoomController map;
  
    public MainWindow(RoomController rc) 
    {
        this.map = rc;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        print(map.getPlayer().getStory(), true);
        print(map.getCurrentRoomDescription(""), true);
        update();
    }
    
    public void print(String s, boolean append)
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
    
    private void update() 
    {
        int maxHp = map.getPlayer().getMaxHp();
        int currentHp = map.getPlayer().getCurrentHp();
        jLabelCurrentGold.setText("" + map.getPlayer().getGold());
        jProgressBarHealth.setMaximum(maxHp);
        jProgressBarHealth.setString(currentHp + "/" + maxHp);
        jProgressBarHealth.setValue(currentHp);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogHelp = new javax.swing.JDialog();
        jLabelHelp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaHelp = new javax.swing.JTextArea();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabelSearch = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jScrollPaneMain = new javax.swing.JScrollPane();
        jTextAreaMain = new javax.swing.JTextArea();
        jTextFieldInput = new javax.swing.JTextField();
        jButtonDoAction = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jProgressBarHealth = new javax.swing.JProgressBar();
        jLabelHp = new javax.swing.JLabel();
        jLabelGold = new javax.swing.JLabel();
        jLabelCurrentGold = new javax.swing.JLabel();
        jButtonHelp = new javax.swing.JButton();

        jDialogHelp.setTitle("Help Window");
        jDialogHelp.setMinimumSize(new java.awt.Dimension(400, 563));
        jDialogHelp.setPreferredSize(new java.awt.Dimension(400, 563));
        jDialogHelp.setResizable(false);
        jDialogHelp.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHelp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHelp.setText("Help");
        jDialogHelp.getContentPane().add(jLabelHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2, 380, 20));

        jTextAreaHelp.setColumns(20);
        jTextAreaHelp.setLineWrap(true);
        jTextAreaHelp.setRows(5);
        jTextAreaHelp.setFocusable(false);
        jScrollPane1.setViewportView(jTextAreaHelp);

        jDialogHelp.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 380, 470));

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyTyped(evt);
            }
        });
        jDialogHelp.getContentPane().add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 505, 330, -1));

        jLabelSearch.setText("Search:");
        jDialogHelp.getContentPane().add(jLabelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 505, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventyr Simulator 2017");
        setResizable(false);

        jTextAreaMain.setColumns(20);
        jTextAreaMain.setLineWrap(true);
        jTextAreaMain.setRows(5);
        jTextAreaMain.setFocusable(false);
        jScrollPaneMain.setViewportView(jTextAreaMain);

        jTextFieldInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInputActionPerformed(evt);
            }
        });

        jButtonDoAction.setText("Enter");
        jButtonDoAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoActionActionPerformed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Dungeon Simulator 2017");

        jProgressBarHealth.setBackground(new java.awt.Color(255, 0, 0));
        jProgressBarHealth.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBarHealth.setMaximum(30);
        jProgressBarHealth.setToolTipText("");
        jProgressBarHealth.setString("0");
        jProgressBarHealth.setStringPainted(true);

        jLabelHp.setText("HP:");

        jLabelGold.setText("Gold:");

        jLabelCurrentGold.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCurrentGold.setForeground(new java.awt.Color(153, 153, 0));
        jLabelCurrentGold.setText("85");

        jButtonHelp.setText("Help");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneMain)
                    .addComponent(jTextFieldInput)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabelHp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBarHealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelGold)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCurrentGold)
                        .addGap(118, 118, 118)
                        .addComponent(jButtonDoAction, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(jButtonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                        .addComponent(jButtonHelp))
                    .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jProgressBarHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelGold)
                        .addComponent(jLabelHp)
                        .addComponent(jLabelCurrentGold)))
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

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        if (!jDialogHelp.isVisible())
        {
            jDialogHelp.setVisible(true);
            Point p = this.getLocation();
            jDialogHelp.setLocation(p.x + 912, p.y);
            jTextAreaHelp.setText(helpText());
        }
        else
        {
            jTextFieldSearch.setText("");
            jDialogHelp.setVisible(false);
        }
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jButtonDoActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoActionActionPerformed
        String s = jTextFieldInput.getText();
        print(map.processInput(s), false);
        if (!s.equalsIgnoreCase("current")) {
            print(map.getCurrentRoomDescription(s), true);
            map.nextTurn(this, true);
        } else {
            map.nextTurn(this, false);
        }
        jTextFieldInput.setText("");
        update();
    }//GEN-LAST:event_jButtonDoActionActionPerformed

    private void jTextFieldInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInputActionPerformed
        // Calls the action button
        jButtonDoActionActionPerformed(evt);
    }//GEN-LAST:event_jTextFieldInputActionPerformed

    private void jTextFieldSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyTyped
        String line = jTextFieldSearch.getText().toLowerCase();
        String helpText = helpText();
        ArrayList<String> strAr = new ArrayList<>();
        String[] split = helpText.split(System.lineSeparator());
        for (String s : split) 
        {
            if (s.toLowerCase().contains(line))
            {
                strAr.add(s);
            }
        }
        helpText = "";
        for (String s : strAr) 
        {
            helpText += s + System.lineSeparator();
        }
        jTextAreaHelp.setText(helpText);
    }//GEN-LAST:event_jTextFieldSearchKeyTyped
    
    public String helpText()
    {
        return "north/up    |   travels in the given direction" + System.lineSeparator()
                + "east/right   |   travels in the given direction," + System.lineSeparator()
                + "south/down   |   travels in the given direction," + System.lineSeparator()
                + "west/left    |   travels in the given direction" + System.lineSeparator()
                + "retreat  |    retreats back to the room you were in before" + System.lineSeparator()
                + "attack/fight |   uses a turn on damaging a monster" + System.lineSeparator()
                + "pickup   | picks up all items from the floor" + System.lineSeparator()
                + "interact/open + xxx   |   interacts with an object in the room (ex: \"interact chest\")" + System.lineSeparator()
                + "current  |   gives current information about the room you are in" + System.lineSeparator()
                + "load/save    |   loads or saves the game" + System.lineSeparator()
                + "inventory    |  displays your inventory" + System.lineSeparator()
                + "delete   | give it a shot..." + System.lineSeparator()
                + "use + xxx    |   uses an item from your inventory (ex: \"use potion\")" + System.lineSeparator()
                + "story    |   depicts the tale of our epic hero as a figurative tsunami" + System.lineSeparator()
                + "quit |   quits the game";
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDoAction;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JDialog jDialogHelp;
    private javax.swing.JLabel jLabelCurrentGold;
    private javax.swing.JLabel jLabelGold;
    private javax.swing.JLabel jLabelHelp;
    private javax.swing.JLabel jLabelHp;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JProgressBar jProgressBarHealth;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JTextArea jTextAreaHelp;
    private javax.swing.JTextArea jTextAreaMain;
    private javax.swing.JTextField jTextFieldInput;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}


package view;

import control.RoomController;
import javax.swing.JOptionPane;
import model.SaveLoadHandler;

/**
 * GUI used for selecting dungeon size
 */
public class DifficultySelector extends javax.swing.JFrame 
{
    public DifficultySelector() 
    {
        initComponents();
        this.setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEventyr = new javax.swing.JLabel();
        jLabelSize = new javax.swing.JLabel();
        jLabelWidth = new javax.swing.JLabel();
        jSliderX = new javax.swing.JSlider();
        jLabelHeigth = new javax.swing.JLabel();
        jSliderY = new javax.swing.JSlider();
        jButtonGenerate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dungeon Size Selector");
        setMinimumSize(new java.awt.Dimension(400, 281));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEventyr.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelEventyr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEventyr.setText("Dungeon Simulator 2017");
        getContentPane().add(jLabelEventyr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, -1));

        jLabelSize.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSize.setText("Select Dungeon Size:");
        getContentPane().add(jLabelSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 51, 160, -1));

        jLabelWidth.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelWidth.setText("Dungeon Width:");
        getContentPane().add(jLabelWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, -1));

        jSliderX.setMajorTickSpacing(1);
        jSliderX.setMaximum(9);
        jSliderX.setMinimum(2);
        jSliderX.setMinorTickSpacing(1);
        jSliderX.setPaintLabels(true);
        jSliderX.setPaintTicks(true);
        jSliderX.setSnapToTicks(true);
        jSliderX.setValue(5);
        getContentPane().add(jSliderX, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        jLabelHeigth.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelHeigth.setText("Dungeon Heigth:");
        getContentPane().add(jLabelHeigth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jSliderY.setMajorTickSpacing(1);
        jSliderY.setMaximum(9);
        jSliderY.setMinimum(2);
        jSliderY.setMinorTickSpacing(1);
        jSliderY.setPaintLabels(true);
        jSliderY.setPaintTicks(true);
        jSliderY.setSnapToTicks(true);
        jSliderY.setToolTipText("");
        jSliderY.setValue(5);
        getContentPane().add(jSliderY, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        jButtonGenerate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonGenerate.setText("GENERATE DUNGEON");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 330, -1));

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Gets the value of the slider and starts the main window instance
     */
    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        int x = jSliderX.getValue();
        int y = jSliderY.getValue();
        new MainWindow(new RoomController(x, y));
        this.dispose();
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String playerName = JOptionPane.showInputDialog("Load from playername:");
        if (playerName == null || playerName.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid name");
            return;
        }
        RoomController newController = SaveLoadHandler.load(playerName);
        if (newController == null)
        {
            JOptionPane.showMessageDialog(null, "Couldn't find any save for " + playerName);
            return;
        }
        new MainWindow(newController);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JLabel jLabelEventyr;
    private javax.swing.JLabel jLabelHeigth;
    private javax.swing.JLabel jLabelSize;
    private javax.swing.JLabel jLabelWidth;
    private javax.swing.JSlider jSliderX;
    private javax.swing.JSlider jSliderY;
    // End of variables declaration//GEN-END:variables
}

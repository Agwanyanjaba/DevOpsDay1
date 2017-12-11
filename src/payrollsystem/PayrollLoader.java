package payrollsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
//import payrollsystem.PayAdminLogin;
/**
 *
 * @author Wycliffe
 */
public class PayrollLoader extends JFrame  implements ActionListener, PropertyChangeListener
{
        private Task task;
        class Task extends SwingWorker<Void,Void>
{
@Override
  public Void doInBackground()
    {
        Random random = new Random();
        int progress = 0;
         //Initialize progress property.
        setProgress(0);
            while (progress < 100)
            {
            //Sleep for up to one second.
                try
                {
                   Thread.sleep(random.nextInt(1000));
                }
                catch (InterruptedException i)
                {
                    String s = "System Error Occurred ";
                }
                //Make random progress.
                progress += random.nextInt(20);
                setProgress(Math.min(progress, 100));
             }

        return null;
        }
    public void done()
    {
        Toolkit.getDefaultToolkit().beep();
        //jbtnLoader.setEnabled(true);
        setCursor(null); //turn off the wait cursor
        jtaLoader.append("Done!\n");
        new PayrollHome().setVisible(true);
    }
}
    /** Creates new form PayrollLoader */
    public PayrollLoader()
    {
        initComponents();
        jProgressBarLoader.setValue(0);
        jProgressBarLoader.setStringPainted(true);
        //jbtnLoader.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
        
    }
    public void propertyChange(PropertyChangeEvent evt)
    {
    if ("progress".equals(evt.getPropertyName()))
    {
    int progress = (Integer) evt.getNewValue();
    jProgressBarLoader.setValue(progress);
    jProgressBarLoader.setForeground(Color.GREEN);
    
    jtaLoader.append(String.format(
    "\nCompleted %d%% of Loading Payroll System Modules", task.getProgress()));

    }
    if(task.getProgress()==100)
    {
      this.dispose();
    }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLoader = new javax.swing.JPanel();
        jbtnCancelLoading = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaLoader = new javax.swing.JTextArea();
        jlblLogo = new javax.swing.JLabel();
        jlblLoaderTitle = new javax.swing.JLabel();
        jProgressBarLoader = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 255));

        jPanelLoader.setBackground(new java.awt.Color(0, 102, 204));
        jPanelLoader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 204), null, null));
        jPanelLoader.setToolTipText("wybosoft loader");

        jbtnCancelLoading.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnCancelLoading.setText("Cancel Loading");
        jbtnCancelLoading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelLoadingActionPerformed(evt);
            }
        });

        jtaLoader.setBackground(new java.awt.Color(204, 204, 255));
        jtaLoader.setColumns(20);
        jtaLoader.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jtaLoader.setRows(5);
        jtaLoader.setText("Loading please wait...");
        jScrollPane1.setViewportView(jtaLoader);

        jlblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/ICO/wybosoft.gif"))); // NOI18N

        jlblLoaderTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jlblLoaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblLoaderTitle.setText("Wybosoft University College.");

        jProgressBarLoader.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanelLoaderLayout = new javax.swing.GroupLayout(jPanelLoader);
        jPanelLoader.setLayout(jPanelLoaderLayout);
        jPanelLoaderLayout.setHorizontalGroup(
            jPanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBarLoader, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoaderLayout.createSequentialGroup()
                .addGroup(jPanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLoaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlblLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLoaderLayout.createSequentialGroup()
                                .addComponent(jlblLoaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                .addGap(100, 100, 100))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)))
                    .addGroup(jPanelLoaderLayout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(jbtnCancelLoading)))
                .addGap(108, 108, 108))
        );
        jPanelLoaderLayout.setVerticalGroup(
            jPanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaderLayout.createSequentialGroup()
                .addGroup(jPanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoaderLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jlblLoaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jbtnCancelLoading))
                    .addGroup(jPanelLoaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlblLogo)))
                .addGap(18, 18, 18)
                .addComponent(jProgressBarLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelLoader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelLoader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelLoadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelLoadingActionPerformed
        //Cancels loading of the of the payroll system
        new PayAdminLogin().setVisible(true);
    }//GEN-LAST:event_jbtnCancelLoadingActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) throws ClassNotFoundException
    {
        try
        {
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (InstantiationException ex)
        {
            Logger.getLogger(PayrollHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PayrollHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(PayrollHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            
            public void run()
            {
                new PayrollLoader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelLoader;
    private javax.swing.JProgressBar jProgressBarLoader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCancelLoading;
    private javax.swing.JLabel jlblLoaderTitle;
    private javax.swing.JLabel jlblLogo;
    private javax.swing.JTextArea jtaLoader;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet.");

    }

   
}

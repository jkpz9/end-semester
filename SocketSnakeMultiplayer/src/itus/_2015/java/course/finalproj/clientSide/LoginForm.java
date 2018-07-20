package itus._2015.java.course.finalproj.clientSide;

import itus._2015.java.course.finalproj.common.Message;
import itus._2015.java.course.finalproj.common.User;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame implements inReceiveMessage {
    static public User user = null;
    static public String IP;
    static public String Port;
    static public Socket socket = null;
    
    ListenServer listenServer = null;
    /**
     * Creates new form LoginFrame
     */
    public LoginForm() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void connectServer()
    {
        IP = txtIP.getText();
        Port = txtPort.getText();
        
        try {
            if (socket==null)
            {
                socket = new Socket(IP, Integer.parseInt(Port));
                listenServer = new ListenServer(socket);
                listenServer.receive = this;
                listenServer.start();
                ImageIcon icon = new ImageIcon("resources/IMG/ok.png");
                JOptionPane.showMessageDialog(null, "Connected to SERVER", 
                "SUCESS MESSAGE", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can't connect to Server!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IOException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can't connect to Server!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPort = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        tx_username = new javax.swing.JTextField();
        tx_password = new javax.swing.JPasswordField();
        bntLOGIN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tx_repassword1 = new javax.swing.JPanel();
        tx_username1 = new javax.swing.JTextField();
        tx_password1 = new javax.swing.JPasswordField();
        bntREGISTER = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tx_password2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(21, 101, 192));

        txtPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPort.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPort.setText("1238");
        txtPort.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IP");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Port");

        txtIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIP.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIP.setText("127.0.0.1");
        txtIP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));

        tx_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tx_username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tx_username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        tx_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_usernameActionPerformed(evt);
            }
        });

        tx_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tx_password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));

        bntLOGIN.setBackground(new java.awt.Color(255, 51, 51));
        bntLOGIN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntLOGIN.setForeground(new java.awt.Color(255, 255, 255));
        bntLOGIN.setText("LOGIN");
        bntLOGIN.setBorder(null);
        bntLOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLOGINActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tx_password, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tx_username, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bntLOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_username, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(bntLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        tx_repassword1.setBackground(new java.awt.Color(45, 50, 54));

        tx_username1.setBackground(new java.awt.Color(60, 65, 71));
        tx_username1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tx_username1.setForeground(new java.awt.Color(204, 204, 204));
        tx_username1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tx_username1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));

        tx_password1.setBackground(new java.awt.Color(60, 65, 71));
        tx_password1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tx_password1.setForeground(new java.awt.Color(204, 204, 204));
        tx_password1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));

        bntREGISTER.setBackground(new java.awt.Color(234, 76, 135));
        bntREGISTER.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntREGISTER.setForeground(new java.awt.Color(255, 255, 255));
        bntREGISTER.setText("REGISTER");
        bntREGISTER.setBorder(null);
        bntREGISTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntREGISTERActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Retype Password");

        tx_password2.setBackground(new java.awt.Color(60, 65, 71));
        tx_password2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tx_password2.setForeground(new java.awt.Color(204, 204, 204));
        tx_password2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));

        javax.swing.GroupLayout tx_repassword1Layout = new javax.swing.GroupLayout(tx_repassword1);
        tx_repassword1.setLayout(tx_repassword1Layout);
        tx_repassword1Layout.setHorizontalGroup(
            tx_repassword1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tx_repassword1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(tx_repassword1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tx_password2)
                    .addGroup(tx_repassword1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addGroup(tx_repassword1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bntREGISTER, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(tx_password1)
                            .addComponent(tx_username1))))
                .addGap(27, 27, 27))
        );
        tx_repassword1Layout.setVerticalGroup(
            tx_repassword1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tx_repassword1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_username1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tx_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(bntREGISTER, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tx_repassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tx_repassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tx_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_usernameActionPerformed

    private void bntLOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLOGINActionPerformed
        String username;
        String password;        
        
        connectServer();
                
        username = tx_username.getText().trim();
        password = String.valueOf(tx_password.getPassword()).trim();
        
        if(username.compareTo("")==0 || password.compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(null, "Please filled in all required fields", "Error",  JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        
        if (listenServer!=null)
        {
            try {
                listenServer.SendMessage(0, new User(username, password));
            } catch (IOException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bntLOGINActionPerformed

    private void bntREGISTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntREGISTERActionPerformed
        String username;
        String password;
        String repassword;

        connectServer();
        
        username = tx_username1.getText();
        password = String.valueOf(tx_password1.getPassword());
        repassword = String.valueOf(tx_password2.getPassword());

        if(username.compareTo("")==0 || password.compareTo("") == 0 && repassword.compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(null, "Please filled in all required fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(password.compareTo("") != 0 && password.compareTo(repassword) != 0)
        {
            JOptionPane.showMessageDialog(null, "Password and Re-Type Password is not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (listenServer!=null)
        {
            try {
                listenServer.SendMessage(1, new User(username, password));
            } catch (IOException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bntREGISTERActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLOGIN;
    private javax.swing.JButton bntREGISTER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tx_password;
    private javax.swing.JPasswordField tx_password1;
    private javax.swing.JPasswordField tx_password2;
    private javax.swing.JPanel tx_repassword1;
    private javax.swing.JTextField tx_username;
    private javax.swing.JTextField tx_username1;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ReceiveMessage(Message msg) throws IOException {
        switch (msg.getType()) {
            case 0: {
                user = (User) msg.getObject();
                if (user != null) {
                    listenServer.user = user;
                    //JOptionPane.showMessageDialog(null, "Ok", "Message", 1);

                    /* Create and display the form */
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            System.out.println("CLIENT");
                            //new Main(listenServer).setVisible(true);
                           // new RoomFrame(listenServer).setVisible(true);
                           new MainGame(user.getUsername(),listenServer).setVisible(true);
;                        }
                    });
                    //this.setVisible(false);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username or password error!", "Message", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            case 1: {
                JOptionPane.showMessageDialog(null, msg.getObject(), "Message", JOptionPane.ERROR_MESSAGE);
                break;
            }

        }
    }
}
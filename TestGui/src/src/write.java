
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class write extends java.awt.Frame {

    /**
     * Creates new form write
     */
    Connection myconObj;  // to connect DB
     Statement myStatObj =null;  // to execute queries
     ResultSet myresObj =null; // present the data fetch from queries
   //  Statement stmt;          // Statement for static SQL Statement
    PreparedStatement pstmt; //Prepared statment
     ResultSetMetaData mymeta = null; // to process queries
     
    public write() {
        initComponents();
    }

    public void db(){
         try {
             myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/localDB", "MMP", "1234");
             myStatObj = myconObj.createStatement();
             myresObj = myStatObj.executeQuery("SELECT * from MMP.MyTable");
             mymeta = myresObj.getMetaData();
             System.out.println("Database connected"); 
        
             int columnNo = mymeta.getColumnCount();
            //System.out.println(columnNo);
            for(int i=1; i<=columnNo; i++){
                System.out.print(mymeta.getColumnName(i)+ "\t");
            }
            
            System.out.println();
            while(myresObj.next()){
                for(int i =1; i<=columnNo; i++){
                    System.out.print(myresObj.getObject(i)+ "\t");
                }
                System.out.println();
            }    
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textInput = new javax.swing.JTextField();
        addText = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Insert text");

        addText.setText("Add");
        addText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTextActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(addText)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(textInput, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void addTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTextActionPerformed
        // TODO add your handling code here:
      
        //Add annotation
        
        String annotation = textInput.getText();
            try {
                db();
                String query = "UPDATE MYTABLE SET ANNOTATION ="+ annotation; //WHERE ID EQUALS TO 
                PreparedStatement annotate = myconObj.prepareStatement(query);
                annotate.setString(3, annotation);
                annotate.execute();
                System.out.println("Annotate successfully!");
        
            } catch (SQLException ex) {
                
                ex.printStackTrace();
                System.out.println("Not successful.");    
            } 
        
    }//GEN-LAST:event_addTextActionPerformed
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //if one image was selected
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new write().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addText;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textInput;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.GUI;
import edu.esprit.util.MyConnection;
import edu.esprit.DAO.ServiceDAO;
import edu.esprit.entities.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Majdi Chaabene
 */
public class AdminGererInscription extends javax.swing.JFrame {
    List<Service> listepension = new ArrayList<Service>();
    List<Service> listetoilettage = new ArrayList<Service>();
    ServiceDAO pension = new ServiceDAO();
    ServiceDAO toilettage = new ServiceDAO();
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pre = null;

    /**
     * Creates new form InscriptionService
     */
    public AdminGererInscription() {
        initComponents();
        try {
            con = MyConnection.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(AdminGererInscription.class.getName()).log(Level.SEVERE, null, ex);
        }

        Update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public void Update() {
        try {
            String sql = "select * from clients,inscription,services where clients.id_Client=inscription.id_Client AND services.id_Service=inscription.id_Service";
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneladmininscription = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        chart = new javax.swing.JButton();
        pdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        chart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/GUI/1393821460_statistics.png"))); // NOI18N
        chart.setText("Pie Chart");
        chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartActionPerformed(evt);
            }
        });

        pdf.setText("Générer pdf");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneladmininscriptionLayout = new javax.swing.GroupLayout(paneladmininscription);
        paneladmininscription.setLayout(paneladmininscriptionLayout);
        paneladmininscriptionLayout.setHorizontalGroup(
            paneladmininscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneladmininscriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneladmininscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addGroup(paneladmininscriptionLayout.createSequentialGroup()
                        .addGroup(paneladmininscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneladmininscriptionLayout.setVerticalGroup(
            paneladmininscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneladmininscriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chart)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneladmininscription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneladmininscription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
      
// TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
         String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/pidev";     
        String login = "root"; 
        String  password = "";
        Connection connection;
        try {
             Class.forName(driver);
            connection = DriverManager.getConnection(url,login,password);
            // - Connexion à la base
            connection=DriverManager.getConnection(url, login, password);
            // - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\classic.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // - Paramètres à envoyer au rapport
            Map  parameters = new HashMap();
            parameters.put("Titre", "Titre");
            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Majdi Chaabene\\Desktop\\fiche.pdf");
        }

        catch (JRException e) {
            System.out.println("erreur de compilation"+ e.getMessage());
         } catch (SQLException e) {
            System.out.println("erreur SQL"+e.getMessage());
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(affichage.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:                                     

// TODO add your handling code here:
    }//GEN-LAST:event_pdfActionPerformed

    private void chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartActionPerformed
        listepension = pension.DisplayAllServicesinscripourpension();
        listetoilettage = toilettage.DisplayAllServicesinscripourtoilettage();
        DefaultPieDataset dataset;
        dataset = new DefaultPieDataset();
        dataset.setValue("pension", new Double(listepension.size()));
        dataset.setValue("toilettage", new Double(listetoilettage.size()));
        JFreeChart chart=ChartFactory.createPieChart3D("Pie Chart", dataset,true,true,true);
        PiePlot3D p=(PiePlot3D)chart.getPlot();
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(700,500);
    }//GEN-LAST:event_chartActionPerformed

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
            java.util.logging.Logger.getLogger(AdminGererInscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminGererInscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminGererInscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminGererInscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGererInscription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel paneladmininscription;
    private javax.swing.JButton pdf;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

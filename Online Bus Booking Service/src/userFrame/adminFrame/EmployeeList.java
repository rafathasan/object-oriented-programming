/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userFrame.adminFrame;

import classes.Bus;
import classes.user.Employee;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import operations.FindEmployee;
import operations.SystemErrorHandle;

/**
 *
 * @author Administrator
 */
public class EmployeeList extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame1
     */
    public EmployeeList() {
        super("Employee List");
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setBorder(null);
        setVisible(true);
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
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setBackground(new java.awt.Color(60, 74, 77));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1);

        jTable1.setBackground(new java.awt.Color(60, 74, 77));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Cell", "Email", "Address", "UserName", "Salary (Hour)", "Daily Hour", "Monthly Days", "UUID", "Password", "LastPayroll"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);

        jMenu1.setText("Table");

        jMenuItem2.setText("Load Data to Table");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Save Data from Table");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem1.setText("Clear Table");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("View Date as PDF");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            JDialog dialog = new JOptionPane(new EmployeeEditPanel(jTable1), -1, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null).createDialog("Edit");
            dialog.pack();
            dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new SwingWorker(){
            
                float progress=0;
                JProgressBar bar = new JProgressBar();
                JOptionPane pane = new JOptionPane(bar);
                JDialog dialLog = pane.createDialog(null, "Loading");
                        
                @Override
                protected void done() {
                    dialLog.setTitle("Done");
                    jTable1.clearSelection();
                    jTable1.setVisible(true);
                    new SwingWorker() {
                        @Override
                        protected Object doInBackground() throws Exception {
                            Thread.sleep(5000);
                            dialLog.dispose();
                            return null;
                        }
                    }.execute();
                }

                @Override
                protected void process(List list) {
                    
                    progress = Float.parseFloat(list.get(list.size()-1).toString());
                    
                    bar.setValue((int) progress);
                }

                @Override
                protected Object doInBackground() throws InterruptedException{
                    
                    jTable1.setVisible(false);
                    
                /////////////////////////////Editable:START//////////////////////////////
                    ArrayList<Employee> list;
                try{
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("EMPLOYEE")));
                    list = (ArrayList<Employee>) ois.readObject();
                    ois.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Data Retrive Failed");
                    return false;
                }
                /////////////////////////////Editable:END//////////////////////////////
                    
                    new SwingWorker(){
                        @Override
                        protected Object doInBackground() throws Exception {
                            dialLog.setModal(false);
                            dialLog.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() - dialLog.getSize().width,
                                    GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() 
                                            - dialLog.getSize().height 
                                            - (Toolkit.getDefaultToolkit().getScreenSize().height 
                                                    - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height) );
                            dialLog.setVisible(true);
                            return null;
                        }
                    }.execute();
                    
                    /////////////////////////////Editable:START//////////////////////////////
                    DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
                    dm.setRowCount(0);
                    for(int i=0;i<list.size();i++){
                        dm.addRow(new Object[]{
                            list.get(i).getName(),
                            list.get(i).getCell(),
                            list.get(i).getEmail(),
                            list.get(i).getAddress(),
                            list.get(i).getUser(),
                            list.get(i).getSalaryInHour(),
                            list.get(i).getHour(),
                            list.get(i).getDays(),
                            list.get(i).getId(),
                            list.get(i).getPassword(),
                            list.get(i).getLastPayroll()
                        });
                        
                        publish( ((float) 100/list.size()) + progress);////////progressBar///////////////
                        
                        try{
                            Thread.sleep(100);
                        }catch(Exception ex){
                            if(JOptionPane.showOptionDialog(null, "Create Error Report", "Thread Inturupt Exception", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==JOptionPane.OK_OPTION){
                                SystemErrorHandle.reportError(ex);
                            }
                        }
                    }
                    /////////////////////////////Editable:END//////////////////////////////
                    publish(100);
                    jTable1.setModel(dm);
                    return true;
                }
                
            }.execute();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
        jTable1.setModel(dm);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showOptionDialog(null, "Current Data will be replaced", "Overwrite Data", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null) == JOptionPane.OK_OPTION){
            new SwingWorker(){

                    float progress=0;
                    JProgressBar bar = new JProgressBar();
                    JOptionPane pane = new JOptionPane(bar);
                    JDialog dialLog = pane.createDialog(null, "Loading");

                    @Override
                    protected void done() {
                        dialLog.setTitle("Done");
                        jTable1.clearSelection();
                        jTable1.setVisible(true);
                        new SwingWorker() {
                            @Override
                            protected Object doInBackground() throws Exception {
                                Thread.sleep(5000);
                                dialLog.dispose();
                                return null;
                            }
                        }.execute();
                    }

                    @Override
                    protected void process(List list) {

                        progress = Float.parseFloat(list.get(list.size()-1).toString());

                        bar.setValue((int) progress);
                    }

                    @Override
                    protected Object doInBackground(){

                        jTable1.setVisible(false);

                    /////////////////////////////Editable:START//////////////////////////////
                    ArrayList<Employee> list = new ArrayList<Employee>();
                    for(int i=0;i<jTable1.getRowCount();i++){
                        list.add(new Employee(jTable1.getValueAt(i, 0).toString(),
                                jTable1.getValueAt(i, 1).toString(),
                                jTable1.getValueAt(i, 2).toString(),
                                jTable1.getValueAt(i, 3).toString(),
                                jTable1.getValueAt(i, 4).toString(),
                                Integer.valueOf(jTable1.getValueAt(i, 5).toString()),
                                Integer.valueOf(Integer.valueOf(jTable1.getValueAt(i, 6).toString())),
                                Integer.valueOf(Integer.valueOf(jTable1.getValueAt(i, 7).toString())),
                                jTable1.getValueAt(i, 8).toString(),
                                jTable1.getValueAt(i, 9).toString(),
                                jTable1.getValueAt(i, 10).toString()
                        ));

                        publish( ((float) 100/jTable1.getRowCount()) + progress);////////progressBar///////////////

                        try{
                            Thread.sleep(100);
                        }catch(Exception ex){
                        }
                    }
                    publish(100);
                    /////////////////////////////Editable:END//////////////////////////////

                        new SwingWorker(){
                            @Override
                            protected Object doInBackground() throws Exception {
                                dialLog.setModal(false);
                                dialLog.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() - dialLog.getSize().width,
                                        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() 
                                                - dialLog.getSize().height 
                                                - (Toolkit.getDefaultToolkit().getScreenSize().height 
                                                        - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height) );
                                dialLog.setVisible(true);
                                return null;
                            }
                        }.execute();

                        /////////////////////////////Editable:START//////////////////////////////
                        try{
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("EMPLOYEE")));
                            oos.writeObject(list);
                            oos.flush();
                            oos.close();
                        }catch(Exception ex){
                            if(JOptionPane.showOptionDialog(null, "Send Error report", "File write Exception", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==JOptionPane.OK_OPTION){
                                    SystemErrorHandle.reportError(ex);
                                }
                        }
                        /////////////////////////////Editable:END//////////////////////////////
                        return true;
                    }

                }.execute();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()>-1 && JOptionPane.showOptionDialog(null, "This Will Instantly Remove the User From the Database", "Comfirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==JOptionPane.YES_OPTION){
            FindEmployee.deleteEmployeeById(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
            DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
            dm.removeRow(jTable1.getSelectedRow());
            jTable1.setModel(dm);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Document doc = new Document();
            JFileChooser jfc = new JFileChooser();
            jfc.setSelectedFile(new File("temp.pdf"));
            //jfc.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
            //jfc.showSaveDialog(this);
            try{
                PdfWriter.getInstance(doc, new FileOutputStream(jfc.getSelectedFile()));
                doc.open();
                
                DottedLineSeparator dottedline = new DottedLineSeparator();
                dottedline.setOffset(-2);
                dottedline.setGap(2f);
                
                doc.add(Image.getInstance("logo.png"));
//                doc.add(Chunk.NEWLINE);
//                doc.add(dottedline);
//                doc.add(Chunk.NEWLINE);
                PdfPTable tab = new PdfPTable(4);
                tab.addCell("Name");
                tab.addCell("Cell");
                tab.addCell("Email");
                tab.addCell("Address");
                
                for(Employee temp:FindEmployee.getEmployee()){
                    tab.addCell(temp.getName());
                    tab.addCell(temp.getCell());
                    tab.addCell(temp.getEmail());
                    tab.addCell(temp.getAddress());
                }
                
                doc.add(tab);

                
                doc.close();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + jfc.getSelectedFile().getAbsolutePath() );
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "PDF Creation Failed");
            }
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

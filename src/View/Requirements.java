
package View;

import Model.DAO.RequirementDAO;
import Model.DAO.UserDAO;
import Model.Project;
import Model.Requirement;
import Model.User;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Requirements extends javax.swing.JFrame {

    public Requirements() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) requirementsTable.getModel();
        requirementsTable.setRowSorter(new TableRowSorter(model));
        readRequirementsTable();
        
    }
    
    public void readRequirementsTable() {
        DefaultTableModel model = (DefaultTableModel) requirementsTable.getModel();
        RequirementDAO rdao = new RequirementDAO();

        for (Requirement r : rdao.read()) {
            UserDAO udao = new UserDAO();

            model.addRow(new Object[]{
                r.getId(),
                r.getName(),
                r.getAuthor(),
                r.getDescription()
            });

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requirementsTable = new javax.swing.JTable();
        createButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REQTOOL - Projects");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        requirementsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Owner", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        requirementsTable.setSelectionBackground(new java.awt.Color(44, 51, 87));
        requirementsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                requirementsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(requirementsTable);
        if (requirementsTable.getColumnModel().getColumnCount() > 0) {
            requirementsTable.getColumnModel().getColumn(0).setMinWidth(75);
            requirementsTable.getColumnModel().getColumn(0).setPreferredWidth(75);
            requirementsTable.getColumnModel().getColumn(0).setMaxWidth(75);
            requirementsTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            requirementsTable.getColumnModel().getColumn(2).setMinWidth(150);
            requirementsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            requirementsTable.getColumnModel().getColumn(2).setMaxWidth(150);
            requirementsTable.getColumnModel().getColumn(3).setMinWidth(500);
            requirementsTable.getColumnModel().getColumn(3).setPreferredWidth(500);
            requirementsTable.getColumnModel().getColumn(3).setMaxWidth(500);
        }

        createButton.setBackground(new java.awt.Color(44, 51, 87));
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setText("New Requirement");
        createButton.setBorder(null);
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(44, 51, 87));
        backButton.setText("Back");
        backButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(44, 51, 87), 3, true));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        JOptionPane.showMessageDialog(null, ProjectsRUD.id);
        this.setVisible(false);
        new RequirementsC().setVisible(true);
    }//GEN-LAST:event_createButtonActionPerformed

    private void requirementsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requirementsTableMouseClicked

        int selected = requirementsTable.getSelectedRow();
        TableModel model = requirementsTable.getModel();
        int selectedId = (int) model.getValueAt(selected, 0);
        
        Requirement.setStaticId(selectedId);
                
        this.setVisible(false);
        new RequirementsRUD().setVisible(true);
    }//GEN-LAST:event_requirementsTableMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        new Projects().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Requirements().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton createButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable requirementsTable;
    // End of variables declaration//GEN-END:variables
}

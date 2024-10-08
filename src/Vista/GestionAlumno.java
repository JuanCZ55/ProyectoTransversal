/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Alumno;
import Persistencia.AlumnoData;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GestionAlumno extends javax.swing.JInternalFrame {

    private class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private final NonEditableTableModel modelo = new NonEditableTableModel();
    private AlumnoData alumnoDate = new AlumnoData();

    /**
     * Creates new form GestionAlumno
     */
    public GestionAlumno() {
        initComponents();
        modelo.addColumn("Id Alumno");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Estado");
        jTable1.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFDocumento = new javax.swing.JTextField();
        jTFApellido = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jBInsert = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jbDes = new javax.swing.JButton();
        jBAct = new javax.swing.JButton();
        jRBEstado = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBActualizar = new javax.swing.JButton();
        jDCFecha = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("Alumnos");

        jLabel2.setText("Documento:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Fecha de nacimiento:");

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBInsert.setText("Insertar");
        jBInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertActionPerformed(evt);
            }
        });

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jbDes.setText("Deshabilitar");
        jbDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDesActionPerformed(evt);
            }
        });

        jBAct.setText("Activar");
        jBAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActActionPerformed(evt);
            }
        });

        jRBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBEstadoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(jTFApellido)
                                    .addComponent(jRBEstado)
                                    .addComponent(jDCFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jBActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBInsert)
                .addGap(46, 46, 46)
                .addComponent(jBModificar)
                .addGap(35, 35, 35)
                .addComponent(jbDes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAct)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(jRBEstado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInsert)
                    .addComponent(jBModificar)
                    .addComponent(jbDes)
                    .addComponent(jBAct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jBActualizar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBEstadoActionPerformed

    private void jBInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsertActionPerformed
        try {
            if (jTFDocumento.getText().isEmpty() || jTFApellido.getText().isEmpty() || jTFNombre.getText().isEmpty() || jDCFecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "llenar todos los campos, dni con 8 digitos");
                return;
            }
            int dni = Integer.parseInt(jTFDocumento.getText());
            String apellido = jTFApellido.getText();
            String nombre = jTFNombre.getText();
            LocalDate fechN = jDCFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            boolean estado = jRBEstado.isSelected();

            Alumno nuevoAlumno = new Alumno(dni, apellido, nombre, fechN, estado);

            if (nuevoAlumno.getDni() >= 8) {
                for (Alumno listarAlumno : alumnoDate.listarAlumnos()) {
                    if (listarAlumno.getDni() == nuevoAlumno.getDni()) {
                        JOptionPane.showMessageDialog(null, "El alumno ya existe.");
                        return;
                    }
                }
            } else {

                alumnoDate.guardarAlumno(nuevoAlumno);
                JOptionPane.showMessageDialog(null, "Alumno guardado correctamente.");
                actualizarTabla();
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Campos Vacios");
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(null, "Error: Datos Invalidos");

        }

    }//GEN-LAST:event_jBInsertActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        try {

            if (jTFDocumento.getText().isEmpty() || jTFApellido.getText().isEmpty() || jTFNombre.getText().isEmpty() || jDCFecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "llenar todos los campos, dni con 8 digitos");
                return;
            }
            int dni = Integer.parseInt(jTFDocumento.getText());
            String apellido = jTFApellido.getText();
            String nombre = jTFNombre.getText();
            LocalDate fechN = jDCFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            boolean estado = jRBEstado.isSelected();

            Alumno alum = new Alumno(dni, apellido, nombre, fechN, estado);
            if (alum.getDni() >= 8) {
                for (Alumno listarAlumno : alumnoDate.listarAlumnos()) {
                    if (listarAlumno.getDni() == alum.getDni()) {
                        JOptionPane.showMessageDialog(null, "El alumno ya existe.");
                        return;
                    }
                }
            } else {

                alumnoDate.actualizarAlumno(alum);
                JOptionPane.showMessageDialog(null, "Alumno modificado correctamente.");
                actualizarTabla();
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Campos Vacios");
        }


    }//GEN-LAST:event_jBModificarActionPerformed

    private void jbDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDesActionPerformed
        try {
            int dni = Integer.parseInt(jTFDocumento.getText());
            if (dni >= 8) {
                for (Alumno listarAlumno : alumnoDate.listarAlumnos()) {
                    if (listarAlumno.getDni() == dni) {
                        alumnoDate.bajaLogica(dni);
                        actualizarTabla();
                        JOptionPane.showMessageDialog(null, "Se le dio la baja al alumno");
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "DNI invalido debe colocar 8 digitos");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }


    }//GEN-LAST:event_jbDesActionPerformed

    private void jBActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActActionPerformed
        try {
             int dni = Integer.parseInt(jTFDocumento.getText());
            if (dni >= 8) {
                for (Alumno listarAlumno : alumnoDate.listarAlumnos()) {
                    if (listarAlumno.getDni() == dni) {
                        alumnoDate.altaLogica(dni);
                        actualizarTabla();
                        JOptionPane.showMessageDialog(null, "Se le dio el alta al alumno");
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "DNI invalido debe colocar 8 digitos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }//GEN-LAST:event_jBActActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        try {
            int dni = Integer.parseInt(jTFDocumento.getText());
            
            JOptionPane.showMessageDialog(this, alumnoDate.buscarAlumno(dni).toString());
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Error: error de formato");
        }

    }//GEN-LAST:event_jBBuscarActionPerformed
    private void actualizarTabla() {
        modelo.setRowCount(0);

        for (Alumno aux : alumnoDate.listarAlumnos()) {

            modelo.addRow(new Object[]{
                aux.getIdAlumno(),
                aux.getDni(),
                aux.getApellido(),
                aux.getNombre(),
                aux.getFechaNac(),
                aux.isActivo()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAct;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBInsert;
    private javax.swing.JButton jBModificar;
    private com.toedter.calendar.JDateChooser jDCFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBEstado;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFDocumento;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbDes;
    // End of variables declaration//GEN-END:variables
}

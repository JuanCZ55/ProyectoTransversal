/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Materia;
import Persistencia.MateriaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GestionMateria extends javax.swing.JInternalFrame {

    private class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private final NonEditableTableModel modelo = new NonEditableTableModel();
    private MateriaData materiaData = new MateriaData();

    public GestionMateria() {
        initComponents();
        modelo.addColumn("Id Materia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        modelo.addColumn("Estado");
        jTable1.setModel(modelo);
        actualizarTabla();
        

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jTFAnio = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBDeshabilitar = new javax.swing.JButton();
        jBHabilitar = new javax.swing.JButton();
        jRBEstado = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBActualizar = new javax.swing.JButton();

        jLabel1.setText("Materia");

        jLabel2.setText("Código:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Año:");

        jLabel5.setText("Estado:");

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBNuevo.setText("Nuevo");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBDeshabilitar.setText("Deshabilitar");
        jBDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeshabilitarActionPerformed(evt);
            }
        });

        jBHabilitar.setText("Habilitar");
        jBHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHabilitarActionPerformed(evt);
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
        jScrollPane1.setViewportView(jTable1);

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
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jBModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBDeshabilitar)
                        .addGap(45, 45, 45)
                        .addComponent(jBHabilitar)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jBBuscar))
                            .addComponent(jTFAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRBEstado))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBActualizar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTFAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(jRBEstado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNuevo)
                    .addComponent(jBModificar)
                    .addComponent(jBDeshabilitar)
                    .addComponent(jBHabilitar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBActualizar)
                .addGap(257, 257, 257))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBEstadoActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed

        try {
            if (jTFNombre.getText().isEmpty() || jTFAnio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                return;
            }

            
            String nombre = jTFNombre.getText();
            int anio = Integer.parseInt(jTFAnio.getText());
            boolean estado = jRBEstado.isSelected();

            Materia nuevaMateria = new Materia(nombre, anio, estado);

            materiaData.guardarMateria(nuevaMateria);
            actualizarTabla();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Error: Datos numéricos inválidos");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Campos vacíos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado");
        }
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        try {
            if (jTFCodigo.getText().isEmpty() || jTFNombre.getText().isEmpty() || jTFAnio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                return;
            }
            if( jTFNombre.getText().charAt(0)==' ' ){
                JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente");
                return;
            }

            int codigo = Integer.parseInt(jTFCodigo.getText());
            String nombre = jTFNombre.getText();
            int anio = Integer.parseInt(jTFAnio.getText());
            boolean estado = jRBEstado.isSelected();

            Materia materiaExistente = new Materia(codigo, nombre, anio, estado);

            materiaData.actualizarMateria(materiaExistente);
            actualizarTabla();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Datos numéricos inválidos");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Campos vacíos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado");
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeshabilitarActionPerformed

        try {
            if (jTFCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El Campo no pueden estar vacios");
                return;
            }
            int id = Integer.parseInt(jTFCodigo.getText());

            materiaData.bajaLogica(id);
            actualizarTabla();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error Código inválido, debe ser un número");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error Campos vacíos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado");
        }
    }//GEN-LAST:event_jBDeshabilitarActionPerformed

    private void jBHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHabilitarActionPerformed
           try {
            if (jTFCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El Campo no pueden estar vacios");
                return;
            }
            int id = Integer.parseInt(jTFCodigo.getText());
            
            materiaData.altaLogica(id);
            actualizarTabla();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error Código inválido, debe ser un número");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error Campos vacíos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado");
        }
    }//GEN-LAST:event_jBHabilitarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        try {
            if (jTFCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El Campo no pueden estar vacios");
                return;
            }
            int id = Integer.parseInt(jTFCodigo.getText());
            
            if(materiaData.buscarMateria(id)!=null){
                JOptionPane.showMessageDialog(this, materiaData.buscarMateria(id).toString());
            }
            
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Error: error de formato");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jBActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBDeshabilitar;
    private javax.swing.JButton jBHabilitar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFAnio;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
     private void actualizarTabla() {
        modelo.setRowCount(0);

        for (Materia aux : materiaData.listarMaterias()) {

            modelo.addRow(new Object[]{
                aux.getIdMateria(),
                aux.getNombre(),
                aux.getAnioMateria(),
                aux.isActivo()
            });
        }
    }
}

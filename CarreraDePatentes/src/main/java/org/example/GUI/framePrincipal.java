package org.example.GUI;


import com.thoughtworks.qdox.parser.impl.Parser;
import org.example.Conectar.ConexionBD;
import org.example.Main;
import org.example.Module.Jugador;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class framePrincipal extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private javax.swing.JButton BotonAgregarJugador;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoNombrePatenteNueva1;
    private javax.swing.JTextField CampoPatenteNueva;
    private javax.swing.JTextArea areaDeTextoEstadisticas;
    private javax.swing.JButton botonEnviarPatente;
    private javax.swing.JButton botonRefrescar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private int ordenActual;
    private String ultimaPatente;

    // End of variables declaration
    public framePrincipal() {
    }


    private void initComponents() {


        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        BotonAgregarJugador = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        CampoPatenteNueva = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CampoNombrePatenteNueva1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        botonEnviarPatente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botonRefrescar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDeTextoEstadisticas = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1016, 630));
        setResizable(false);

        // Cargar el icono
        URL logoURL = Main.class.getResource("/CDPb.png");
        if(logoURL != null) {
            ImageIcon icon = new ImageIcon(logoURL);
            setIconImage(icon.getImage());
        }else{
            ErrorPopUp.showErrorDialog(this, "No se pudo cargar el logo");
        }

        //todo: No tengo permisos suficientes
        /*
        // Agregar el WindowListener a la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ConexionBD.cerrarServidores(); // Llamar a tu método para cerrar los servidores
                dispose(); // Cerrar la ventana
            }
        });
*/
        jPanel4.setBackground(new java.awt.Color(110, 172, 216));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 600));


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},

                },
                new String[]{
                        "Nombre", "Patente", "Días 1°"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        URL imgURL = Main.class.getResource("/carrera de patentes v3.png");

        if (imgURL != null) {
            jLabel1.setIcon(new javax.swing.ImageIcon(imgURL));
        } else{
            ErrorPopUp.showErrorDialog(this, "No se pudo cargar la imagen");
        }


        jPanel1.setBackground(new java.awt.Color(0, 36, 194));

        jPanel2.setBackground(new java.awt.Color(252, 252, 252));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel4.setText("Nombre: ");

        CampoNombre.setBackground(new java.awt.Color(245, 245, 245));
        CampoNombre.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        CampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreActionPerformed(evt);
            }
        });

        BotonAgregarJugador.setBackground(new java.awt.Color(245, 245, 245));
        BotonAgregarJugador.setText("Agregar");
        BotonAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(BotonAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonAgregarJugador))
                                .addGap(16, 16, 16))
        );

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 252, 252));
        jLabel2.setText("Agregar nuevo Jugador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 36, 194));

        jPanel5.setBackground(new java.awt.Color(252, 252, 252));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setText("Nombre: ");

        CampoPatenteNueva.setBackground(new java.awt.Color(245, 245, 245));
        CampoPatenteNueva.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        CampoPatenteNueva.setToolTipText("");
        CampoPatenteNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPatenteNuevaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel6.setText("Patente: ");

        CampoNombrePatenteNueva1.setBackground(new java.awt.Color(245, 245, 245));
        CampoNombrePatenteNueva1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        CampoNombrePatenteNueva1.setToolTipText("");
        CampoNombrePatenteNueva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombrePatenteNueva1ActionPerformed(evt);
            }
        });

        jLabel7.setText("En caso de no tener las ultimas letras, ingrese \" * \" en su lugar");

        botonEnviarPatente.setBackground(new java.awt.Color(245, 245, 245));
        botonEnviarPatente.setText("Agregar Patente");
        botonEnviarPatente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarPatenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel7))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(CampoPatenteNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(1, 1, 1))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(CampoNombrePatenteNueva1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonEnviarPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(67, 67, 67))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(CampoNombrePatenteNueva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(CampoPatenteNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonEnviarPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                .addComponent(jLabel7)
                                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 252, 252));
        jLabel3.setText("Agregar Nueva Patente ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
        );

        botonRefrescar.setText("Orden:  Patentes");
        botonRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRefrescarActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 36, 194));
        jPanel6.setPreferredSize(new java.awt.Dimension(343, 130));

        areaDeTextoEstadisticas.setBackground(new java.awt.Color(245, 245, 245));
        areaDeTextoEstadisticas.setColumns(23);
        areaDeTextoEstadisticas.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        areaDeTextoEstadisticas.setRows(3);
        areaDeTextoEstadisticas.setBorder(null);
        areaDeTextoEstadisticas.setEditable(false);

        jScrollPane2.setViewportView(areaDeTextoEstadisticas);
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);


        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(252, 252, 252));
        jLabel8.setText("Estadísticas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(jLabel8)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonRefrescar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(33, 33, 33))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonRefrescar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>


    public void setUltimaPatente(String ultimaPatente) {
        this.ultimaPatente = ultimaPatente;
    }

    private void BotonAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {

        String nombre = CampoNombre.getText();
        ConexionBD.conectarBD();

        try {
            if (!nombre.isBlank()) {
                if (!nombreRepetido(nombre)) {
                    Jugador jugador = new Jugador(nombre);
                    ConexionBD.cargarDato(jugador);
                    ConexionBD.desconaectarBD();
                } else {
                    ErrorPopUp.showErrorDialog(this, "El nombre esta repetido");


                }
            } else {
                ErrorPopUp.showErrorDialog(this, "El nombre está vacío");
            }
        } catch (SQLException e) {
            ErrorPopUp.showErrorDialog(this, "No se pudieron cargar los datos");
        }

        CampoNombre.setText("");
        cargarTablaJugadores(ordenActual);
    }

    private void CampoNombreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botonRefrescarActionPerformed(java.awt.event.ActionEvent evt) {

        ordenActual++;
        if (ordenActual > 3) {
            ordenActual = 1;
        }
        cambiarTextoBotonRefrescar(ordenActual);
        cargarTablaJugadores(ordenActual);
    }

    public void cambiarTextoBotonRefrescar(int orden) {

        switch (orden) {
            case 1:
                botonRefrescar.setText("Orden:  Patentes");
                break;
            case 2:
                botonRefrescar.setText("Orden:  Días Primero");
                break;
            case 3:
                botonRefrescar.setText("Orden: Alfabetico");
        }

    }


    private void CampoPatenteNuevaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void CampoNombrePatenteNueva1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botonEnviarPatenteActionPerformed(java.awt.event.ActionEvent evt) {

        String nombre = CampoNombrePatenteNueva1.getText();
        String patente = CampoPatenteNueva.getText().toUpperCase();


        if (nombreRepetido(nombre) && patenteValida(patente)) {

            try {
                ConexionBD.conectarBD();
                ConexionBD.editarDato(nombre, patente);
                ConexionBD.desconaectarBD();
                ErrorPopUp.showErrorDialog(this, "Se modifico la patente de forma exitosa");
                setUltimaPatente(patente);
            } catch (SQLException e) {
                ErrorPopUp.showErrorDialog(this, "No se pudieron actualzar los datos");
            }
        } else {
            ErrorPopUp.showErrorDialog(this, "La Patente o el nombre no son validos");
        }

        CampoPatenteNueva.setText("");
        CampoNombrePatenteNueva1.setText("");
        cargarTablaJugadores(ordenActual);

        mostrarEstadisticas();

    }


    private boolean patenteValida(String patente) {
        boolean rta = false;
        if (patente.length() == 7) {
            rta = validarPatente(patente);
            System.out.println(rta);
        }
        return rta;
    }

    public static boolean validarPatente(String patente) {

        boolean rta = false;
        // Crear un patrón a partir de la expresión regular
        Pattern modeloPatenteCompleto = Pattern.compile("^[A-Z]{2}[0-9]{3}[A-Z]{2}$");
        Pattern modeloPatenteParcial = Pattern.compile("^[A-Z]{2}[0-9]{3}\\*{2}$");

        // Crear un matcher para la cadena de la patente
        Matcher matcherParcial = modeloPatenteParcial.matcher(patente);
        Matcher matcherCompleto = modeloPatenteCompleto.matcher(patente);

        // Verificar si la cadena coincide con el patrón
        if (matcherCompleto.matches() || matcherParcial.matches()) {
            rta = true;
        }
        return rta;
    }


    public void empezarPrograma() {

        //ConexionBD.iniciarServidores();
        initComponents();
        ordenActual = 1;
        ultimaPAtenteAgregada();
        cargarTablaJugadores(ordenActual);
        mostrarEstadisticas();
        actualizarDiasGanando();

        setVisible(true);
    }

    private boolean nombreRepetido(String nombre) {

        boolean rta = false;
        ArrayList<Jugador> jugadores = Jugador.bajarArrayListDeJugadoresdeDB();

        for (Jugador j : jugadores) {
            if (j.getNombre().equals(nombre)) {
                rta = true;
            }
        }
        return rta;
    }


    //Cargar la tabla de jugadores
    private void cargarTablaJugadores(int orden) {

        ArrayList<Jugador> jugadores;

        jugadores = Jugador.bajarArrayListDeJugadoresdeDB();
        ordenarJugadores(jugadores, orden);
        modificarTabla(jugadores);

    }


    private void ordenarJugadores(ArrayList<Jugador> jugadores, int orden) {
        switch (orden) {
            case 1:
                ordenarTablaPorPatentes(jugadores);
                break;
            case 2:
                ordenarTablaPorDiasPrimero(jugadores);
                break;
            case 3:
                ordenarTablaPorNombre(jugadores);
                break;
        }
    }

    private ArrayList<Jugador> ordenarTablaPorPatentes(ArrayList<Jugador> jugadores) {

        jugadores.sort(Comparator.comparing(Jugador::getPatente).reversed());
        return jugadores;
    }

    private ArrayList<Jugador> ordenarTablaPorDiasPrimero(ArrayList<Jugador> jugadores) {

        jugadores.sort(Comparator.comparing(Jugador::getDias_primero).reversed());
        return jugadores;
    }

    private ArrayList<Jugador> ordenarTablaPorNombre(ArrayList<Jugador> jugadores) {

        jugadores.sort(Comparator.comparing(Jugador::getNombre));
        return jugadores;
    }

    private void modificarTabla(ArrayList<Jugador> jugadores) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < jugadores.size(); i++) {

            Jugador j = jugadores.get(i);
            model.setValueAt(j.getNombre(), i, 0);
            model.setValueAt(j.getPatente(), i, 1);
            model.setValueAt(j.getDias_primero(), i, 2);
        }

    }


    private void actualizarDiasGanando() {

        Jugador jugador = getJugadorGanando();
        if (jugador != null) {
            try {
                int diasAAumentar = diasAAumetar();
                if (diasAAumentar != 0) {
                    jugador.setDias_primero(jugador.getDias_primero() + diasAAumentar);
                    actualizarDiasEnBD(jugador);
                    actualizarFechaEnBD();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private Jugador getJugadorGanando() {
        ArrayList<Jugador> jugadores;
        Jugador jugadorRetorno = null;
        jugadores = Jugador.bajarArrayListDeJugadoresdeDB();
        jugadores.sort(Comparator.comparing(Jugador::getPatente).reversed());

        if (!jugadores.isEmpty()) {
            jugadorRetorno = jugadores.getFirst();
        }

        return jugadorRetorno;

    }

    private int diasAAumetar() throws SQLException {

        long diasEntreFechas = 0;
        LocalDate fechaActual = LocalDate.now();
        LocalDate ultimaFechaRegistrada = ConexionBD.pedirUltimaFechaRegistrada();
        System.out.println(ultimaFechaRegistrada);
        if (!ultimaFechaRegistrada.isEqual(fechaActual)) {
            diasEntreFechas = ChronoUnit.DAYS.between(fechaActual, ultimaFechaRegistrada);
            System.out.println(diasEntreFechas);
        }

        return (int) diasEntreFechas * -1;
    }

    public void actualizarDiasEnBD(Jugador jugador) throws SQLException {

        ConexionBD.conectarBD();
        ConexionBD.editarDato(jugador.getNombre(), jugador.getDias_primero());
        ConexionBD.desconaectarBD();

    }

    public void actualizarFechaEnBD() throws SQLException {

        ConexionBD.conectarBD();
        ConexionBD.cargarDato(LocalDate.now());
        ConexionBD.desconaectarBD();
    }


    public void mostrarEstadisticas() {

        String mensaje = String.format("""
                El Jugador que más días primero va es:  %s con %s día/s
                La patente más reciente es: %s
                La ultima patente agregada es: %s
                """, getNombreJugadorMasGanador() ,getDatoMayoJugador("dias_primero"), getDatoMayoJugador("patente"), ultimaPatente);

        areaDeTextoEstadisticas.setText(mensaje);
    }


    private String getDatoMayoJugador(String columna) {
        String dato = "";
        try {
            ConexionBD.conectarBD();
            dato = ConexionBD.pedirDatoEspecificoJugadores(columna);
            ConexionBD.desconaectarBD();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dato;

    }

    private void ultimaPAtenteAgregada() {
        try {
            ConexionBD.conectarBD();
            ultimaPatente = ConexionBD.pedirDatoUltimoJugadorIngresadoABD("patente");
            ConexionBD.desconaectarBD();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private String getNombreJugadorMasGanador(){
        ArrayList<Jugador> jugador;
        String nombre = "";
        try {
        ConexionBD.conectarBD();
            jugador = ConexionBD.pedirDatosJugadores();

           nombre = getNombreJugadorQueVaGanando(jugador);
            ConexionBD.desconaectarBD();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nombre;
    }


    private String getNombreJugadorQueVaGanando(ArrayList<Jugador> jugadores)
    {
        String nombre = "";
        for(Jugador j : jugadores){
            String diaPrimero = getDatoMayoJugador("dias_primero");

            if(j.getDias_primero() == Integer.parseInt(diaPrimero)){
                nombre = j.getNombre();
            }

        }
    return nombre;
    }



}






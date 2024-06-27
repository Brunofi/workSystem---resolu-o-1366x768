/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.view;

import br.com.porschegt3cup.controller.TelaCadastroPecaController;
import br.com.porschegt3cup.controller.TelaEntradaPecaController;
import br.com.porschegt3cup.controller.TelaPedidoPecaController;
import br.com.porschegt3cup.controller.TelaSaidaPecaController;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public class TelaPedidoPeca extends javax.swing.JInternalFrame {

    private final TelaPedidoPecaController controller;

    /**
     * Creates new form TelaLocacao
     */
    public TelaPedidoPeca() {
        initComponents();
        controller = new TelaPedidoPecaController(this);
        controller.carregarListaDeChassisSaida();
        controller.carregarListaDeSessoes();
        controller.carregarListaDeEtapas();
        controller.carregarListaMotivo();
    }

    private boolean existeCamposObrigatoriosVaziosCabecalio() {

        if (cbChassis.getSelectedItem().toString().isEmpty()
                || cbEtapa.getSelectedItem().toString().isEmpty()
                || cbSessao.getSelectedItem().toString().isEmpty()
                || txtQuantidadeSaida.getText().isEmpty()
                || cbMotivo.getSelectedItem().toString().isEmpty()) {
            return true;

        } else {
            return false;
        }

    }

    private boolean existeCamposObrigatoriosVaziosCabecalioParaCarregarLista() {

        if (cbChassis.getSelectedItem().toString().isEmpty()
                || cbEtapa.getSelectedItem().toString().isEmpty()
                || cbSessao.getSelectedItem().toString().isEmpty()) {
            return true;

        } else {
            return false;
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
        jLabel9 = new javax.swing.JLabel();
        cbChassis = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbEtapa = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbSessao = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbMotivo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtNumeroMotorCambio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnLancar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPecasPedidas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnCancelarPeca = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSolicitarPecas = new javax.swing.JTable();
        cbLado = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidadeSaida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLPesquisar = new javax.swing.JTextField();
        btnProcurar = new javax.swing.JButton();
        btnLancar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela Saida Peças");
        setPreferredSize(new java.awt.Dimension(1530, 905));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("*Preenchimento obrigatório");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("*Etapa");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("*Sessao");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("*Motivo");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Nº Motor/Cambio");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("*Chassis");

        btnLancar1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnLancar1.setText("Carregar");
        btnLancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbChassis, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSessao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNumeroMotorCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroMotorCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel10))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbChassis)
                            .addComponent(cbEtapa)))
                    .addComponent(btnLancar1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblPecasPedidas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblPecasPedidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Part Number", "Descrição", "Quantidade", "Motivo", "Status"
            }
        ));
        tblPecasPedidas.setFocusable(false);
        tblPecasPedidas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPecasPedidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPecasPedidas);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Lista de peças pedidas");

        btnCancelarPeca.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnCancelarPeca.setText("Cancelar Peça");
        btnCancelarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPecaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarPeca)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarPeca)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Solicitação de Peças");

        tblSolicitarPecas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblSolicitarPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Part Number", "Descrição"
            }
        ));
        tblSolicitarPecas.setFocusable(false);
        tblSolicitarPecas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSolicitarPecas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblSolicitarPecas);

        cbLado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "D.E", "D.D", "T.E", "T.D" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Lado");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Quantidade");

        txtQuantidadeSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtQuantidadeSaida.setPreferredSize(new java.awt.Dimension(500, 28));
        txtQuantidadeSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeSaidaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Pesquisar");

        txtLPesquisar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLPesquisar.setPreferredSize(new java.awt.Dimension(500, 28));

        btnProcurar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProcurar.setText("Buscar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        btnLancar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnLancar.setText("Lancar");
        btnLancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(cbLado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQuantidadeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnLancar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnProcurar))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbLado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidadeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnLancar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Locacao");

        setBounds(0, 0, 921, 690);
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void txtQuantidadeSaidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeSaidaKeyTyped
        String caracteresPermitidos = "0123456789";
        if (!caracteresPermitidos.contains(evt.getKeyChar() + "")) {
            evt.consume();
    }//GEN-LAST:event_txtQuantidadeSaidaKeyTyped
    }
    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        controller.procuraPecaNoEstoque();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnLancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancarActionPerformed
        if (existeCamposObrigatoriosVaziosCabecalio()) {
            JOptionPane.showMessageDialog(null, "é necessario preencher os campos obrigatórios para orçar uma peça");
        } else {
            controller.registrarOrcamento();
        }


    }//GEN-LAST:event_btnLancarActionPerformed

    private void btnCancelarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPecaActionPerformed
        controller.cancelarPecaSolicitada();
    }//GEN-LAST:event_btnCancelarPecaActionPerformed

    private void btnLancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancar1ActionPerformed
        if (existeCamposObrigatoriosVaziosCabecalioParaCarregarLista()) {
            JOptionPane.showMessageDialog(null, "para carregar os dados preencha Chassis, etapa e sessão");
        }else{
        controller.atualizaTabelaPecasPedidasPorChassisEEtapa();
        }
    }//GEN-LAST:event_btnLancar1ActionPerformed

    public JTextField getTxtNumeroMotorCambio() {
        return txtNumeroMotorCambio;
    }

    public void setTxtNumeroMotorCambio(JTextField txtNumeroMotorCambio) {
        this.txtNumeroMotorCambio = txtNumeroMotorCambio;
    }

    public JTable getTblPecasPedidas() {
        return tblPecasPedidas;
    }

    public void setTblPecasPedidas(JTable tblPecasPedidas) {
        this.tblPecasPedidas = tblPecasPedidas;
    }

    public JTable getTblSolicitarPecas() {
        return tblSolicitarPecas;
    }

    public void setTblSolicitarPecas(JTable tblSolicitarPecas) {
        this.tblSolicitarPecas = tblSolicitarPecas;
    }

    public JComboBox<String> getCbChassis() {
        return cbChassis;
    }

    public void setCbChassis(JComboBox<String> cbChassis) {
        this.cbChassis = cbChassis;
    }

    public JComboBox<String> getCbEtapa() {
        return cbEtapa;
    }

    public void setCbEtapa(JComboBox<String> cbEtapa) {
        this.cbEtapa = cbEtapa;
    }

    public JComboBox<String> getCbLado() {
        return cbLado;
    }

    public void setCbLado(JComboBox<String> cbLado) {
        this.cbLado = cbLado;
    }

    public JComboBox<String> getCbMotivo() {
        return cbMotivo;
    }

    public void setCbMotivo(JComboBox<String> cbMotivo) {
        this.cbMotivo = cbMotivo;
    }

    public JComboBox<String> getCbSessao() {
        return cbSessao;
    }

    public void setCbSessao(JComboBox<String> cbSessao) {
        this.cbSessao = cbSessao;
    }

    public JTable getTblSaidaPeca() {
        return tblPecasPedidas;
    }

    public void setTblSaidaPeca(JTable tblSaidaPeca) {
        this.tblPecasPedidas = tblSaidaPeca;
    }

    public JTextField getTxtLPesquisar() {
        return txtLPesquisar;
    }

    public void setTxtLPesquisar(JTextField txtLPesquisar) {
        this.txtLPesquisar = txtLPesquisar;
    }

    public JTextField getTxtQuantidadeSaida() {
        return txtQuantidadeSaida;
    }

    public void setTxtQuantidadeSaida(JTextField txtQuantidadeSaida) {
        this.txtQuantidadeSaida = txtQuantidadeSaida;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPeca;
    private javax.swing.JButton btnLancar;
    private javax.swing.JButton btnLancar1;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JComboBox<String> cbChassis;
    private javax.swing.JComboBox<String> cbEtapa;
    private javax.swing.JComboBox<String> cbLado;
    private javax.swing.JComboBox<String> cbMotivo;
    private javax.swing.JComboBox<String> cbSessao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPecasPedidas;
    private javax.swing.JTable tblSolicitarPecas;
    private javax.swing.JTextField txtLPesquisar;
    private javax.swing.JTextField txtNumeroMotorCambio;
    private javax.swing.JTextField txtQuantidadeSaida;
    // End of variables declaration//GEN-END:variables

}

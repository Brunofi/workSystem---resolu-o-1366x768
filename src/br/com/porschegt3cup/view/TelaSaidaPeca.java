/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.view;

import br.com.porschegt3cup.controller.TelaCadastroPecaController;
import br.com.porschegt3cup.controller.TelaEntradaPecaController;
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
public class TelaSaidaPeca extends javax.swing.JInternalFrame {

    private final TelaSaidaPecaController controller;

    /**
     * Creates new form TelaLocacao
     */
    public TelaSaidaPeca() {
        initComponents();
        controller = new TelaSaidaPecaController(this);
        controller.carregarListaDeColaboradores();
        controller.carregarListaDeChassisSaida();
        controller.carregarListaDeSessoes();
        controller.carregarListaDeEtapas();
        controller.carregarListaMotivo();
    }

    private boolean existeCamposObrigatoriosVazios() {

        if (cbTipo.getSelectedItem().toString().isEmpty()
                || cbChassis.getSelectedItem().toString().isEmpty()
                || cbEtapa.getSelectedItem().toString().isEmpty()
                || cbLado.getSelectedItem().toString().isEmpty()
                || txtQuantidadeSaida.getText().isEmpty()
                || cbSessao.getSelectedItem().toString().isEmpty()
                || cbMotivo.getSelectedItem().toString().isEmpty()
                || cbColaboradorEntrega.getSelectedItem().toString().isEmpty()
                || cbColaboradorRetira.getSelectedItem().toString().isEmpty())
        {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidadeSaida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSaidaPeca = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        rBtnPartNumber = new javax.swing.JRadioButton();
        rBtnDescricao = new javax.swing.JRadioButton();
        btnProcurar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbChassis = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbChassisCedente = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbLado = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbSessao = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbMotivo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbColaboradorEntrega = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbColaboradorRetira = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbEtapa = new javax.swing.JComboBox<>();
        btnLimparCampos = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("*Qtidade saída");

        txtQuantidadeSaida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuantidadeSaida.setPreferredSize(new java.awt.Dimension(500, 28));
        txtQuantidadeSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeSaidaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Pesquisar");

        txtLPesquisar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLPesquisar.setPreferredSize(new java.awt.Dimension(500, 28));

        tblSaidaPeca = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblSaidaPeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Part Number", "Descrição", "Estado", "Quantidade", "Locação", "Sub-Locação", "ID estoque", "ID peça", "ID locação"
            }
        ));
        tblSaidaPeca.setFocusable(false);
        tblSaidaPeca.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSaidaPeca.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSaidaPeca);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONSUMO", "VALE-PECA" }));
        cbTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbTipoFocusLost(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("*Chassis");

        buttonGroup1.add(rBtnPartNumber);
        rBtnPartNumber.setText("Part Number");

        buttonGroup1.add(rBtnDescricao);
        rBtnDescricao.setText("Descrição");

        btnProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/porschegt3cup/icones/iconFind.png"))); // NOI18N
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("*Tipo");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Chassis cedente");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Lado");

        cbLado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "D.E", "D.D", "T.E", "T.D" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("*Sessao");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("*Motivo");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("*Colab. Entrega");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("*Colab. Retira");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("*Etapa");

        btnLimparCampos.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(745, 745, 745)
                        .addComponent(btnLimparCampos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rBtnPartNumber)
                                .addGap(18, 18, 18)
                                .addComponent(rBtnDescricao))
                            .addComponent(txtLPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel12)
                                        .addComponent(cbLado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbChassis, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(txtQuantidadeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(cbColaboradorEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbColaboradorRetira, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbChassisCedente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rBtnPartNumber)
                            .addComponent(rBtnDescricao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbChassis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbLado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidadeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbColaboradorEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbColaboradorRetira, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbChassisCedente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Locacao");

        setBounds(0, 0, 921, 626);
    }// </editor-fold>//GEN-END:initComponents


    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (existeCamposObrigatoriosVazios()) {
            JOptionPane.showMessageDialog(null, "é necessario preencher os campos obrigatórios para registrar a saida de uma peça");
        } else {
            controller.registrarSaida();
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        rBtnPartNumber.setSelected(true);
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

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        controller.apagarCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void cbTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbTipoFocusLost
        controller.verificaTipoConsumo();
    }//GEN-LAST:event_cbTipoFocusLost

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JComboBox<String> getCbChassis() {
        return cbChassis;
    }

    public void setCbChassis(JComboBox<String> cbChassis) {
        this.cbChassis = cbChassis;
    }

    public JComboBox<String> getCbChassisCedente() {
        return cbChassisCedente;
    }

    public void setCbChassisCedente(JComboBox<String> cbChassisCedente) {
        this.cbChassisCedente = cbChassisCedente;
    }

    public JComboBox<String> getCbColaboradorEntrega() {
        return cbColaboradorEntrega;
    }

    public void setCbColaboradorEntrega(JComboBox<String> cbColaboradorEntrega) {
        this.cbColaboradorEntrega = cbColaboradorEntrega;
    }

    public JComboBox<String> getCbColaboradorRetira() {
        return cbColaboradorRetira;
    }

    public void setCbColaboradorRetira(JComboBox<String> cbColaboradorRetira) {
        this.cbColaboradorRetira = cbColaboradorRetira;
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

    public JComboBox<String> getCbTipo() {
        return cbTipo;
    }

    public void setCbTipo(JComboBox<String> cbTipo) {
        this.cbTipo = cbTipo;
    }

    public JRadioButton getrBtnDescricao() {
        return rBtnDescricao;
    }

    public void setrBtnDescricao(JRadioButton rBtnDescricao) {
        this.rBtnDescricao = rBtnDescricao;
    }

    public JRadioButton getrBtnPartNumber() {
        return rBtnPartNumber;
    }

    public void setrBtnPartNumber(JRadioButton rBtnPartNumber) {
        this.rBtnPartNumber = rBtnPartNumber;
    }

    public JTable getTblSaidaPeca() {
        return tblSaidaPeca;
    }

    public void setTblSaidaPeca(JTable tblSaidaPeca) {
        this.tblSaidaPeca = tblSaidaPeca;
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
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbChassis;
    private javax.swing.JComboBox<String> cbChassisCedente;
    private javax.swing.JComboBox<String> cbColaboradorEntrega;
    private javax.swing.JComboBox<String> cbColaboradorRetira;
    private javax.swing.JComboBox<String> cbEtapa;
    private javax.swing.JComboBox<String> cbLado;
    private javax.swing.JComboBox<String> cbMotivo;
    private javax.swing.JComboBox<String> cbSessao;
    private javax.swing.JComboBox<String> cbTipo;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rBtnDescricao;
    private javax.swing.JRadioButton rBtnPartNumber;
    private javax.swing.JTable tblSaidaPeca;
    private javax.swing.JTextField txtLPesquisar;
    private javax.swing.JTextField txtQuantidadeSaida;
    // End of variables declaration//GEN-END:variables

}

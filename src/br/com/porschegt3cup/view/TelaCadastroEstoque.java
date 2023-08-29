/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.view;

import br.com.porschegt3cup.controller.TelaCadastroEstoqueController;
import br.com.porschegt3cup.controller.TelaCadastroPecaController;
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
public class TelaCadastroEstoque extends javax.swing.JInternalFrame {

    private final TelaCadastroEstoqueController controller;
    //private String tipoPesquisa;

    /**
     * Creates new form TelaLocacao
     */
    public TelaCadastroEstoque() {
        initComponents();
        controller = new TelaCadastroEstoqueController(this);
    }

    private boolean existeCamposObrigatoriosVazios() {
        if (txtPesquisaPeca.getText().isEmpty()
                || txtPesquisaLocacao.getText().isEmpty()) {
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
        jLabel4 = new javax.swing.JLabel();
        txtPesquisaPeca = new javax.swing.JTextField();
        btnProcurarPeca = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtPesquisaLocacao = new javax.swing.JTextField();
        btnProcurarLocacao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLocacao = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        btnLimparPeca = new javax.swing.JButton();
        btnLimparLocacao = new javax.swing.JButton();
        rBtnPartNumber = new javax.swing.JRadioButton();
        rBtnDescricao = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Pesquisar Peça:");

        txtPesquisaPeca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPesquisaPeca.setPreferredSize(new java.awt.Dimension(500, 28));

        btnProcurarPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/porschegt3cup/icones/iconFind.png"))); // NOI18N
        btnProcurarPeca.setToolTipText("Procurar");
        btnProcurarPeca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProcurarPeca.setPreferredSize(new java.awt.Dimension(80, 80));
        btnProcurarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarPecaActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel17.setText("_____________________________________________________________________________________________________");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Pesquisar Locação:");

        txtPesquisaLocacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPesquisaLocacao.setPreferredSize(new java.awt.Dimension(500, 28));

        btnProcurarLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/porschegt3cup/icones/iconFind.png"))); // NOI18N
        btnProcurarLocacao.setToolTipText("Procurar");
        btnProcurarLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProcurarLocacao.setPreferredSize(new java.awt.Dimension(80, 80));
        btnProcurarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarLocacaoActionPerformed(evt);
            }
        });

        tblPecas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Locação", "Locação", "Sub Locação"
            }
        ));
        tblLocacao.setFocusable(false);
        tblLocacao.getTableHeader().setReorderingAllowed(false);
        tblLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLocacaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLocacao);

        tblPecas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Locação", "Locação", "Sub Locação"
            }
        ));
        tblPecas.setFocusable(false);
        tblPecas.getTableHeader().setReorderingAllowed(false);
        tblPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPecasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPecas);

        btnLimparPeca.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLimparPeca.setText("Limpar");
        btnLimparPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparPecaActionPerformed(evt);
            }
        });

        btnLimparLocacao.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLimparLocacao.setText("Limpar");
        btnLimparLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparLocacaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBtnPartNumber);
        rBtnPartNumber.setText("Part Number");

        buttonGroup1.add(rBtnDescricao);
        rBtnDescricao.setText("Descrição");
        rBtnDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnDescricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtnPartNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtnDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtPesquisaPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnProcurarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel18)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtPesquisaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnProcurarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLimparPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLimparLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(808, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rBtnPartNumber)
                        .addComponent(rBtnDescricao)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnProcurarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisaPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparPeca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel17)
                .addGap(34, 34, 34)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPesquisaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimparLocacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Locacao");

        setBounds(0, 0, 1599, 905);
    }// </editor-fold>//GEN-END:initComponents


    private void btnProcurarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarPecaActionPerformed

        controller.procurarPeca();

    }//GEN-LAST:event_btnProcurarPecaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        controller.cadastrarPecaNoEstoque();


    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnProcurarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarLocacaoActionPerformed
        controller.procurarLocacao();
    }//GEN-LAST:event_btnProcurarLocacaoActionPerformed

    private void tblLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLocacaoMouseClicked
        controller.preencherIdLocacao();
    }//GEN-LAST:event_tblLocacaoMouseClicked

    private void tblPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPecasMouseClicked
        controller.preencherIdPeca();
    }//GEN-LAST:event_tblPecasMouseClicked

    private void btnLimparPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparPecaActionPerformed
        controller.apagarCamposPeca();
    }//GEN-LAST:event_btnLimparPecaActionPerformed

    private void btnLimparLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparLocacaoActionPerformed
        controller.apagarCamposLocacao();
    }//GEN-LAST:event_btnLimparLocacaoActionPerformed

    private void rBtnDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnDescricaoActionPerformed
        //  tipoPesquisa="descricao";
    }//GEN-LAST:event_rBtnDescricaoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        rBtnPartNumber.setSelected(true);
    }//GEN-LAST:event_formInternalFrameOpened

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

   

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public void setBtnCadastrar(JButton btnCadastrar) {
        this.btnCadastrar = btnCadastrar;
    }

    public JTable getTblLocacao() {
        return tblLocacao;
    }

    public void setTblLocacao(JTable tblLocacao) {
        this.tblLocacao = tblLocacao;
    }

    public JTable getTblPecas() {
        return tblPecas;
    }

    public void setTblPecas(JTable tblPeca) {
        this.tblPecas = tblPeca;
    }

    public JTextField getTxtPesquisaLocacao() {
        return txtPesquisaLocacao;
    }

    public void setTxtPesquisaLocacao(JTextField txtPesquisaLocacao) {
        this.txtPesquisaLocacao = txtPesquisaLocacao;
    }

    public JTextField getTxtPesquisaPeca() {
        return txtPesquisaPeca;
    }

    public void setTxtPesquisaPeca(JTextField txtPesquisaPeca) {
        this.txtPesquisaPeca = txtPesquisaPeca;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimparLocacao;
    private javax.swing.JButton btnLimparPeca;
    private javax.swing.JButton btnProcurarLocacao;
    private javax.swing.JButton btnProcurarPeca;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rBtnDescricao;
    private javax.swing.JRadioButton rBtnPartNumber;
    private javax.swing.JTable tblLocacao;
    private javax.swing.JTable tblPecas;
    private javax.swing.JTextField txtPesquisaLocacao;
    private javax.swing.JTextField txtPesquisaPeca;
    // End of variables declaration//GEN-END:variables
}

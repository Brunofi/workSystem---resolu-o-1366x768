/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.view;

import br.com.porschegt3cup.controller.TelaAlteracaoQtdEstoqueController;
import br.com.porschegt3cup.controller.TelaCadastroPecaController;
import br.com.porschegt3cup.controller.TelaEntradaPecaController;
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
public class TelaAlteracaoQtdEstoque extends javax.swing.JInternalFrame {

    private final TelaAlteracaoQtdEstoqueController controller;

    /**
     * Creates new form TelaLocacao
     */
    public TelaAlteracaoQtdEstoque() {
        initComponents();
        controller = new TelaAlteracaoQtdEstoqueController(this);
    }

    private boolean existeCamposObrigatoriosVazios() {

        if (txtQuantidadeAtual.getText().isEmpty()) {
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
        txtQuantidadeAtual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntradaPeca = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        rBtnPartNumber = new javax.swing.JRadioButton();
        rBtnDescricao = new javax.swing.JRadioButton();
        btnProcurar = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela Entrada Peças");
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("*Alterar quantidade:");

        txtQuantidadeAtual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuantidadeAtual.setPreferredSize(new java.awt.Dimension(500, 28));
        txtQuantidadeAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeAtualKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Pesquisar");

        txtLPesquisar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLPesquisar.setPreferredSize(new java.awt.Dimension(500, 28));

        tblEntradaPeca = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblEntradaPeca.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEntradaPeca.setFocusable(false);
        tblEntradaPeca.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEntradaPeca.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEntradaPeca);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

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

        btnLimparCampos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rBtnPartNumber)
                        .addGap(18, 18, 18)
                        .addComponent(rBtnDescricao))
                    .addComponent(txtLPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar))
            .addComponent(btnLimparCampos, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rBtnPartNumber)
                            .addComponent(rBtnDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimparCampos)
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Locacao");

        setBounds(0, 0, 1065, 608);
    }// </editor-fold>//GEN-END:initComponents


    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        if (existeCamposObrigatoriosVazios()) {
            JOptionPane.showMessageDialog(null, "é necessario preencher os campos obrigatórios paragistrar a entrada de uma peça");
        } else {
            controller.alterarQtdEstoque();
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        rBtnPartNumber.setSelected(true);
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtQuantidadeAtualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeAtualKeyTyped
        String caracteresPermitidos = "0123456789";
        if (!caracteresPermitidos.contains(evt.getKeyChar() + "")) {
            evt.consume();
    }//GEN-LAST:event_txtQuantidadeAtualKeyTyped
    }
    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        controller.procuraPecaNoEstoque();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        controller.apagarCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnProcurar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rBtnDescricao;
    private javax.swing.JRadioButton rBtnPartNumber;
    private javax.swing.JTable tblEntradaPeca;
    private javax.swing.JTextField txtLPesquisar;
    private javax.swing.JTextField txtQuantidadeAtual;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnRegistrar() {
        return btnAlterar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnAlterar = btnRegistrar;
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

    public JTable getTblEntradaPeca() {
        return tblEntradaPeca;
    }

    public void setTblEntradaPeca(JTable tblEntradaPeca) {
        this.tblEntradaPeca = tblEntradaPeca;
    }

    public JTextField getTxtLPesquisar() {
        return txtLPesquisar;
    }

    public void setTxtLPesquisar(JTextField txtLPesquisar) {
        this.txtLPesquisar = txtLPesquisar;
    }

    public JTextField getTxtQuantidadeAtual() {
        return txtQuantidadeAtual;
    }

    public void setTxtQuantidadeAtual(JTextField txtQuantidadeAtual) {
        this.txtQuantidadeAtual = txtQuantidadeAtual;
    }

  

    
}

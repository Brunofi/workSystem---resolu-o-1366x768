/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.view;


import br.com.porschegt3cup.controller.TelaCadastroUsuarioController;
import br.com.porschegt3cup.controller.TelaInventarioController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public class TelaInventario extends javax.swing.JInternalFrame {

    private final TelaInventarioController controller;

    /**
     * Creates new form TelaLocacao
     */
    public TelaInventario() {
        initComponents();
        controller = new TelaInventarioController(this);
        controller.carregarLocacoes();
    }

    private boolean existeCamposObrigatoriosVazios() {
        if (cbLocacao.getSelectedItem().toString().isEmpty()) {
            return true;

        } else {
            return false;
        }

    }

    void deixarCamposazios() {
        
        cbLocacao.setSelectedItem(null);
        
    }

    public JButton getBtnAplicar() {
        return btnAplicar;
    }

    public void setBtnAplicar(JButton btnAplicar) {
        this.btnAplicar = btnAplicar;
    }

    public JButton getBtnLimparPesquisa() {
        return btnLimparPesquisa;
    }

    public void setBtnLimparPesquisa(JButton btnLimparPesquisa) {
        this.btnLimparPesquisa = btnLimparPesquisa;
    }

    public JButton getBtnProcurar() {
        return btnProcurar;
    }

    public void setBtnProcurar(JButton btnProcurar) {
        this.btnProcurar = btnProcurar;
    }

    public JComboBox<String> getCbLocacao() {
        return cbLocacao;
    }

    public void setCbLocacao(JComboBox<String> cbLocacao) {
        this.cbLocacao = cbLocacao;
    }

    public JTable getTblInventario() {
        return tblInventario;
    }

    public void setTblInventario(JTable tblInventario) {
        this.tblInventario = tblInventario;
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnProcurar = new javax.swing.JButton();
        btnAplicar = new javax.swing.JButton();
        btnLimparPesquisa = new javax.swing.JButton();
        cbLocacao = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Usuario");
        setPreferredSize(new java.awt.Dimension(1530, 905));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Pesquisar");

        btnProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/porschegt3cup/icones/iconFind.png"))); // NOI18N
        btnProcurar.setToolTipText("Procurar");
        btnProcurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProcurar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        btnAplicar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAplicar.setText("Aplicar");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        btnLimparPesquisa.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLimparPesquisa.setText("Limpar campos");
        btnLimparPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparPesquisaActionPerformed(evt);
            }
        });

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PART NUMBER", "DESCRIÇÃO", "ESTADO", "LOCAÇÃO", "SUB LOCAÇÃO", "QTD ANTIGA", "QTD ATUAL"
            }
        ));
        tblInventario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblInventario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(845, 845, 845)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimparPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(925, 925, 925))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimparPesquisa)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Locacao");

        setBounds(0, 0, 1022, 585);
    }// </editor-fold>//GEN-END:initComponents


    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        if (existeCamposObrigatoriosVazios()) {
            JOptionPane.showMessageDialog(null, "é necessario selecionar uma locação para iniciar o inventario");
        } else {
            controller.obterPecasNaTabelaDeInventario();
        }
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        controller.aplicarInventario();

    }//GEN-LAST:event_btnAplicarActionPerformed

    private void btnLimparPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparPesquisaActionPerformed
        controller.apagarCampos();
    }//GEN-LAST:event_btnLimparPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnLimparPesquisa;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JComboBox<String> cbLocacao;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblInventario;
    // End of variables declaration//GEN-END:variables
}

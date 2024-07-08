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
import br.com.porschegt3cup.controller.TelaVisualizacaoPedidoController;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public class TelaVisualizacaoPedido extends javax.swing.JInternalFrame {

    private final TelaVisualizacaoPedidoController controller;

    /**
     * Creates new form TelaLocacao
     */
    public TelaVisualizacaoPedido() {
        initComponents();
        controller = new TelaVisualizacaoPedidoController(this);
        controller.carregarListaDeChassisSaida();
        controller.carregarListaDeSessoes();
        controller.carregarListaDeEtapas();
        controller.carregarListaStatusPesqusisa();
        controller.carregarListaStatusAlterado();
        controller.carregarListaEstadoPeca();
        cbEstadoPeca.setVisible(false);
        lbEstadoPeca.setVisible(false);
    }

    private boolean todosOsFiltrosEstaoVazios() {

        if (cbChassis.getSelectedItem().toString().isEmpty()
                && cbEtapa.getSelectedItem().toString().isEmpty()
                && cbSessao.getSelectedItem().toString().isEmpty()
                && cbStatusPesquisa.getSelectedItem().toString().isEmpty()) {
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

    private boolean verificaPreenchimentoEstadoPeca() {
        if (cbStatusAlterado.getSelectedItem().toString().equals("ENTREGUE") && !cbEstadoPeca.getSelectedItem().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    private void escondeCbEstadoPeca() {
        cbEstadoPeca.setVisible(false);
        lbEstadoPeca.setVisible(false);
        cbStatusAlterado.setSelectedIndex(0);
        cbEstadoPeca.setSelectedIndex(0);

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
        cbStatusPesquisa = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnLancar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPecasPedidas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnAlteraStatus = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cbStatusAlterado = new javax.swing.JComboBox<>();
        lbEstadoPeca = new javax.swing.JLabel();
        cbEstadoPeca = new javax.swing.JComboBox<>();

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
        jLabel9.setText("Filtros");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Etapa");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Sessao");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Status");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Chassis");

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
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbChassis, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbStatusPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(184, Short.MAX_VALUE))
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
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatusPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLancar1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel10))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbChassis)
                            .addComponent(cbEtapa))))
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
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Part Number", "Descrição", "Qtd Pedida", "Motivo", "Chassis", "Qtd Estoque", "Locação", "Status"
            }
        ));
        tblPecasPedidas.setFocusable(false);
        tblPecasPedidas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPecasPedidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPecasPedidas);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Lista de peças pedidas");

        btnAlteraStatus.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAlteraStatus.setText("Alterar status");
        btnAlteraStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraStatusActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Alterar status para:");

        cbStatusAlterado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusAlteradoActionPerformed(evt);
            }
        });

        lbEstadoPeca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEstadoPeca.setText("Estado peça entregue");

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbStatusAlterado, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbEstadoPeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbEstadoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAlteraStatus)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbStatusAlterado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(26, 26, 26)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbEstadoPeca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lbEstadoPeca)
                                    .addGap(26, 26, 26)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnAlteraStatus)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Locacao");

        setBounds(0, 0, 921, 690);
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void btnAlteraStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraStatusActionPerformed
        if (cbStatusAlterado.getSelectedItem().toString().equals("ENTREGUE") && !cbEstadoPeca.getSelectedItem().toString().isEmpty()) {
            controller.alteraStatusIncluiEstadoDaPeca();
            escondeCbEstadoPeca();

        } else if (!cbStatusAlterado.getSelectedItem().toString().equals("ENTREGUE")) {
            controller.alteraStatusPeca();
        } else {
            JOptionPane.showMessageDialog(null, "É necessário preencher o ESTADO PEÇA ENTREGUE para prosseguir");
        }
    }//GEN-LAST:event_btnAlteraStatusActionPerformed

    private void btnLancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancar1ActionPerformed

        controller.visualizarPecasPedidas();

    }//GEN-LAST:event_btnLancar1ActionPerformed

    private void cbStatusAlteradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusAlteradoActionPerformed
        if (cbStatusAlterado.getSelectedItem().toString().equals("ENTREGUE")) {
            cbEstadoPeca.setVisible(true);
            lbEstadoPeca.setVisible(true);

        } else {
            cbEstadoPeca.setVisible(false);
            lbEstadoPeca.setVisible(false);
        }
    }//GEN-LAST:event_cbStatusAlteradoActionPerformed

    public JLabel getLbEstadoPeca() {
        return lbEstadoPeca;
    }

    public void setLbEstadoPeca(JLabel lbEstadoPeca) {
        this.lbEstadoPeca = lbEstadoPeca;
    }

    public JComboBox<String> getCbEstadoPeca() {
        return cbEstadoPeca;
    }

    public void setCbEstadoPeca(JComboBox<String> cbEstadoPeca) {
        this.cbEstadoPeca = cbEstadoPeca;
    }

    public JComboBox<String> getCbStatusPesquisa() {
        return cbStatusPesquisa;
    }

    public void setCbStatusPesquisa(JComboBox<String> cbStatusPesquisa) {
        this.cbStatusPesquisa = cbStatusPesquisa;
    }

    public JComboBox<String> getCbStatusAlterado() {
        return cbStatusAlterado;
    }

    public void setCbStatusAlterado(JComboBox<String> cbStatusAlterado) {
        this.cbStatusAlterado = cbStatusAlterado;
    }

    public JTable getTblPecasPedidas() {
        return tblPecasPedidas;
    }

    public void setTblPecasPedidas(JTable tblPecasPedidas) {
        this.tblPecasPedidas = tblPecasPedidas;
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlteraStatus;
    private javax.swing.JButton btnLancar1;
    private javax.swing.JComboBox<String> cbChassis;
    private javax.swing.JComboBox<String> cbEstadoPeca;
    private javax.swing.JComboBox<String> cbEtapa;
    private javax.swing.JComboBox<String> cbSessao;
    private javax.swing.JComboBox<String> cbStatusAlterado;
    private javax.swing.JComboBox<String> cbStatusPesquisa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEstadoPeca;
    private javax.swing.JTable tblPecasPedidas;
    // End of variables declaration//GEN-END:variables

}

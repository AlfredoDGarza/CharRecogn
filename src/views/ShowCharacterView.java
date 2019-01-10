/*
 * @(#)ShowCharacterView.java 1.0 01/11/2016
 */
package views;

/**
 * Interfaz gráfica en el cuál muestra la información de un caracter almacenado
 *
 * @author Alfredo de la Garza
 * @version 1.0 01/11/2016
 * @since 1.0
 */
public class ShowCharacterView extends javax.swing.JFrame {

    /**
     * Caracter a mostrar
     */
    models.Char character;

    /**
     * Constructor de la clase.
     *
     * @param character información del caracter a mostrar
     */
    public ShowCharacterView(models.Char character) {
        initComponents();

        this.character = character;
        showInformation();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInformation = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblCharacter = new javax.swing.JLabel();
        txtCharacter = new javax.swing.JTextField();
        lblBits = new javax.swing.JLabel();
        txtBits = new javax.swing.JTextField();
        btnModify = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CharRecogn | Caracter");
        setIconImage(getIconImage());
        setResizable(false);

        pnlInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Información de caracter"));

        lblId.setText("ID");

        txtId.setText("1");
        txtId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtId.setEnabled(false);

        lblCharacter.setText("Caracter");

        txtCharacter.setText("A");
        txtCharacter.setEnabled(false);

        lblBits.setText("Bits");

        txtBits.setText("01110100011000111111100011000110001");
        txtBits.setEnabled(false);

        btnModify.setText("Modificar");
        btnModify.setFocusPainted(false);
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.setToolTipText("");
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.setToolTipText("");
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInformationLayout = new javax.swing.GroupLayout(pnlInformation);
        pnlInformation.setLayout(pnlInformationLayout);
        pnlInformationLayout.setHorizontalGroup(
            pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformationLayout.createSequentialGroup()
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(lblCharacter)
                            .addComponent(lblBits))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBits, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(txtCharacter, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformationLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlInformationLayout.setVerticalGroup(
            pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCharacter)
                    .addComponent(txtCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBits)
                    .addComponent(txtBits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModify, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(346, 234));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Modifica las propiedades del caracter.
     *
     * @param evt
     */
    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
        txtCharacter.setEnabled(true);
        txtBits.setEnabled(true);

        txtId.requestFocus();
    }//GEN-LAST:event_btnModifyActionPerformed

    /**
     * Elimina un caracter almacenado en la base de datos
     *
     * @param evt
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int des = javax.swing.JOptionPane.showConfirmDialog(null, "Seguro que desea elimniar el caracter con nombre " + character.getCharacter(), "Eliminar caracter", javax.swing.JOptionPane.YES_NO_OPTION);

        if (des == 0) {
            int res = connection.Chars.deleteCharacter(character.getId());

            if (res == 1) {
                javax.swing.JOptionPane.showMessageDialog(null, "El caracter se ha eliminado con éxito", "Eliminar caracter", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                MainView mainView = new MainView();
                mainView.setVisible(true);
            }

            this.dispose();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * Guarda el caracter modificado
     *
     * @param evt
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int des = javax.swing.JOptionPane.showConfirmDialog(null, "Seguro que desea guardar el caracter modificado", "Guardar", javax.swing.JOptionPane.YES_NO_OPTION);

        if (des == 0) {
            int idChar = Integer.parseInt(txtId.getText());
            String nameChar = txtCharacter.getText();
            String vecBits = txtBits.getText();

            int res = connection.Chars.modifyCharacter(idChar, nameChar, vecBits);

            if (res == 1) {
                javax.swing.JOptionPane.showMessageDialog(null, "El caracter se ha guardado con éxito", "Eliminar caracter", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                MainView mainView = new MainView();
                mainView.setVisible(true);
            }

            this.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Muestra la información del caracter en sus respectivos campos de texto
     */
    private void showInformation() {
        txtId.setText(String.valueOf(character.getId()));
        txtCharacter.setText(String.valueOf(character.getCharacter()));
        txtBits.setText(String.valueOf(character.getBits()));
    }

    /**
     * Retorna el ícono del frame.
     *
     * @return ícono del frame
     */
    @Override
    public java.awt.Image getIconImage() {
        java.awt.Image retValue = java.awt.Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resources/icons/icon-app-1.png"));

        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblBits;
    private javax.swing.JLabel lblCharacter;
    private javax.swing.JLabel lblId;
    private javax.swing.JPanel pnlInformation;
    private javax.swing.JTextField txtBits;
    private javax.swing.JTextField txtCharacter;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}

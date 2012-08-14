package org.netbeans.gradle.project;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JTextArea;

@SuppressWarnings("serial") // Don't care about serialization
public class CustomActionPanel extends javax.swing.JPanel {
    public CustomActionPanel() {
        initComponents();
    }

    private String[] splitText(String text, String delimiters) {
        StringTokenizer tokenizer = new StringTokenizer(text, delimiters);
        List<String> result = new LinkedList<String>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                result.add(token);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public String[] getTasks() {
        String text = jTasksEdit.getText();
        if (text == null) {
            return new String[0];
        }

        return splitText(text, " \t\n\r\f");
    }

    public String[] getArguments() {
        String text = jArgsTextArea.getText();
        if (text == null) {
            return new String[0];
        }

        return splitText(text, "\n\r");
    }

    public String[] getJvmArguments() {
        String text = jJvmArgsTextArea.getText();
        if (text == null) {
            return new String[0];
        }

        return splitText(text, "\n\r");
    }

    private void traverseWithTab(JTextArea textArea, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_TAB) {
            boolean forward = (event.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) == 0;
            if (forward) {
                textArea.transferFocus();
            }
            else {
                textArea.transferFocusBackward();
            }
            event.consume();
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

        jTasksCaption = new javax.swing.JLabel();
        jTasksEdit = new javax.swing.JTextField();
        jArgsCaption = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jArgsTextArea = new javax.swing.JTextArea();
        jJvmArgsCaption = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jJvmArgsTextArea = new javax.swing.JTextArea();

        org.openide.awt.Mnemonics.setLocalizedText(jTasksCaption, org.openide.util.NbBundle.getMessage(CustomActionPanel.class, "CustomActionPanel.jTasksCaption.text")); // NOI18N

        jTasksEdit.setText(org.openide.util.NbBundle.getMessage(CustomActionPanel.class, "CustomActionPanel.jTasksEdit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jArgsCaption, org.openide.util.NbBundle.getMessage(CustomActionPanel.class, "CustomActionPanel.jArgsCaption.text")); // NOI18N

        jArgsTextArea.setColumns(20);
        jArgsTextArea.setRows(5);
        jArgsTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jArgsTextAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jArgsTextArea);

        org.openide.awt.Mnemonics.setLocalizedText(jJvmArgsCaption, org.openide.util.NbBundle.getMessage(CustomActionPanel.class, "CustomActionPanel.jJvmArgsCaption.text")); // NOI18N

        jJvmArgsTextArea.setColumns(20);
        jJvmArgsTextArea.setRows(5);
        jJvmArgsTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jJvmArgsTextAreaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jJvmArgsTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jTasksEdit, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTasksCaption)
                            .addComponent(jArgsCaption)
                            .addComponent(jJvmArgsCaption))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTasksCaption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTasksEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jArgsCaption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jJvmArgsCaption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jArgsTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jArgsTextAreaKeyPressed
        traverseWithTab(jArgsTextArea, evt);
    }//GEN-LAST:event_jArgsTextAreaKeyPressed

    private void jJvmArgsTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jJvmArgsTextAreaKeyPressed
        traverseWithTab(jJvmArgsTextArea, evt);
    }//GEN-LAST:event_jJvmArgsTextAreaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jArgsCaption;
    private javax.swing.JTextArea jArgsTextArea;
    private javax.swing.JLabel jJvmArgsCaption;
    private javax.swing.JTextArea jJvmArgsTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jTasksCaption;
    private javax.swing.JTextField jTasksEdit;
    // End of variables declaration//GEN-END:variables
}

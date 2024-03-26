import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Localiza extends JFrame {
    private JComboBox<String> comboBox;
    private JButton btnOk, btnCancelar;
    private Insere insere;

    public Localiza(Insere insere) {
        super("Localizar Texto");
        setSize(400, 200);
        this.insere = insere;

        this.setLocationRelativeTo(null); // Janela fica centralizada no centro da tela

        // Criando JComboBox
        comboBox = new JComboBox<>();
        comboBox.setEditable(true); // Permite a entrada do usuário

        // Adicionando KeyListener
        comboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String texto = (String) comboBox.getSelectedItem();
                    if (texto != null && !texto.isEmpty()) {
                        if (insere.getTxtArea().getText().contains(texto)) {
                            comboBox.addItem(texto);
                        }
                        comboBox.setSelectedItem("");
                    }
                }
            }
        });

        // Criando JButton Ok
        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = (String) comboBox.getSelectedItem();
                if (texto != null && !texto.isEmpty()) {
                    if (insere.getTxtArea().getText().contains(texto)) {
                        comboBox.addItem(texto);
                    }
                    comboBox.setSelectedItem("");
                }
            }
        });

        // Criando JButton Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Criando painel para botões
        JPanel pnlBotoes = new JPanel();
        pnlBotoes.add(btnOk);
        pnlBotoes.add(btnCancelar);

        // Criando painel para combobox
        JPanel pnlTexto = new JPanel();
        pnlTexto.add(new JLabel("Localiza:"));
        pnlTexto.add(comboBox);

        this.getContentPane().add(pnlTexto, BorderLayout.CENTER);
        this.getContentPane().add(pnlBotoes, BorderLayout.SOUTH);
    }
}

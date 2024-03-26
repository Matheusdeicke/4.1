import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Localiza extends JFrame {

    // Componentes
    private JButton btnProcurar;
    private JButton btnCancelar;
    private JTextField txtField;
    private JTextArea txtArea;
    private JScrollPane scrlPane;
    private Insere insere;

    public Localiza(Insere insere){
        super("Procurar Texto");
        setSize(400, 200);

        this.insere = insere;

        this.setLocationRelativeTo(null); // Centraliza a janela na tela
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha o programa ao fechar a janela

        txtField = new JTextField(20);
        txtField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procurarTexto();
            }
        });

        txtArea = new JTextArea(10, 20);
        txtArea.setEditable(false);

        scrlPane = new JScrollPane(txtArea);
        scrlPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        btnProcurar = new JButton("OK");
        btnProcurar.setMnemonic('O');
        btnProcurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procurarTexto();
            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setMnemonic('C');
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Cria container
        JPanel pnl = new JPanel();
        pnl.add(btnProcurar);
        pnl.add(btnCancelar);
        pnl.add(txtField);

        this.getContentPane().add(pnl, BorderLayout.SOUTH);
        this.getContentPane().add(scrlPane, BorderLayout.CENTER);
    }

    private void procurarTexto() {
        String textoProcurado = txtField.getText();
        String textoArea = insere.getTxtArea().getText();
    
        String[] sentences = textoArea.split("\\."); // Divide o texto em frases
    
        for (String sentence : sentences) {
            if (sentence.contains(textoProcurado)) { // Se a frase contém o texto procurado
                txtArea.append(sentence.trim() + ".\n"); // Adiciona a frase à área de texto
            }
        }
    
        txtField.setText("");
    }
}
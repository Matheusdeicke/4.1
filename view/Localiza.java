import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Localiza extends JDialog implements ActionListener {

    private JComboBox<String> txtPesquisa;
    private JButton btnPesquisa;
    private JButton btnCancelar;
    private JTextArea textArea;
    private Highlighter highlighter;

    public Localiza(JFrame textArea) {
        super(textArea, "Localiza");

        this.setModal(true);

        // Inicializa os componentes
        txtPesquisa = new JComboBox<>();
        txtPesquisa.addItem("............");
        txtPesquisa.setEditable(true);
        btnPesquisa = new JButton("Buscar");
        btnCancelar = new JButton("Cancelar");
        JLabel lblTexto = new JLabel("Localizar:");

        btnPesquisa.addActionListener(this);
        btnCancelar.addActionListener(this);

        setLayout(new BorderLayout());

        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlButton.add(btnCancelar);
        pnlButton.add(btnPesquisa);

        JPanel pnlField = new JPanel();
        pnlField.setLayout(new FlowLayout());

        pnlField.add(lblTexto);
        pnlField.add(txtPesquisa);

        add(pnlField, BorderLayout.NORTH);
        add(pnlButton, BorderLayout.CENTER);

        // Define o tamanho do JFrame
        setSize(300, 120);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);

        // Inicializa o highlighter
        // highlighter = textArea.getHighlighter();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCancelar) {
            this.dispose();
            
        } else if (e.getSource() == btnPesquisa) {
            String pesquisaPal = txtPesquisa.getSelectedItem().toString();
            String textoCompleto = textArea.getText();
            int posInicial = textoCompleto.indexOf(pesquisaPal);
            
            if (posInicial >= 0) {
                try {
                    highlighter.removeAllHighlights();
                    highlighter.addHighlight(posInicial, posInicial + pesquisaPal.length(), new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

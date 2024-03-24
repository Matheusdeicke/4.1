import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Insere extends JFrame{
    
    private JButton btnInserir;
    private JTextField txtField;
    private JTextArea txtArea;
    private JScrollPane scrlPane;

    public Insere(){
        super("Teste JTextArea e JTextField");
        setSize(400, 300);

        this.setLocationRelativeTo(null); // Janela fica centralizada no centro da tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela

        // Criando JTextField
        txtField = new JTextField(20);

        // Criando JTextArea
        txtArea = new JTextArea(10, 20);
        txtArea.setEditable(false);

        // Criando JScrollPane
        scrlPane = new JScrollPane(txtArea);
        scrlPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Criando JButton
        btnInserir = new JButton("Insere linha:");
        btnInserir.setMnemonic('I');
        btnInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append(txtField.getText() + "\n");
                txtField.setText("");
            }
        });

        JPanel pnl = new JPanel(); // Cria container para colocar o botão e o campo para digitar o texto
        pnl.add(btnInserir);
        pnl.add(txtField);

        this.getContentPane().add(pnl, BorderLayout.SOUTH);
        this.getContentPane().add(scrlPane, BorderLayout.CENTER);
        

    }
}
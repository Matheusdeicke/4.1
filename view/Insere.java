import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Insere extends JFrame implements ActionListener, KeyListener{
    
    private JButton btnInserir;
    private JTextField txtField;
    private JTextArea txtArea;
    private JScrollPane scrollPane;
  
    public Insere(){
        super("Teste JTextArea e JTextField");
        
        // instanciando campo de texto
        txtArea = new JTextArea();
        txtArea.addKeyListener(this);

        // instanciando o JScrollPane e adicionando o JTextArea
        scrollPane = new JScrollPane(txtArea);

        // instanciando botão
        btnInserir = new JButton("Insere linha");
        btnInserir.addActionListener(this);

        // Instanciando campo de entrada
        txtField = new JTextField(20);
        txtField.addKeyListener(this);

        // add o botão e input
        JPanel pnl = new JPanel();
        pnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnl.add(btnInserir);
        pnl.add(txtField);

        // add componentes no JFrame
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(pnl, BorderLayout.SOUTH);

        // define o tamanho do JFrame
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInserir) {
            adicionarTexto();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarTexto();
        } else if (e.getKeyCode() == KeyEvent.VK_F && e.isControlDown()) {
            
                Localiza l = new Localiza(txtArea);
                l.setVisible(true);

                //para ilustrar (tem que estar dentro do frmPesquisa)
                //txtTexto.append(str); // para adicionar texto ao final                            
        }

    }

    private void adicionarTexto() {
        String newLine = txtField.getText();
        txtArea.append(newLine + "\n");
        txtField.setText("");//limpar o conteúdo
        txtField.requestFocus();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
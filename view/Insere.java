import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Insere extends JFrame implements ActionListener, KeyListener{
    
    private JButton btnInserir;
    private JTextField txtField;
    private JTextArea txtArea;
    private JScrollPane scrollPane;
    private JFrame Frame;
    private String nomeUsuario;
    private int cont;
  
    public Insere(String nomeUsuario){

        super(nomeUsuario);
        this.nomeUsuario = nomeUsuario;

        setTitle(nomeUsuario);
        
        this.Frame = new JFrame();
        
        // Instanciando campo de texto
        txtArea = new JTextArea();
        txtArea.addKeyListener(this);
        // this.Frame.add(txtArea);

        // Instanciando o JScrollPane e adicionando o JTextArea
        scrollPane = new JScrollPane(txtArea);

        // Instanciando botão
        btnInserir = new JButton("Insere linha");
        btnInserir.addActionListener(this);

        // Instanciando campo de entrada
        txtField = new JTextField(20);
        txtField.addKeyListener(this);

        // Adicionando o botão e input
        JPanel pnl = new JPanel();
        pnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnl.add(btnInserir);
        pnl.add(txtField);

        // Adicionando componentes no JFrame
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(pnl, BorderLayout.SOUTH);

        // Definindo o tamanho do JFrame
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ao fechar a janela o programa encerra
        setLocationRelativeTo(null); // O programa abre no centro da tela
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInserir) {
            adicionarTexto();
            AcoesBotao acao = new AcoesBotao();
            acao.actionPerformed(e);
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
            
                Localiza l = new Localiza(Frame);
                l.setVisible(true);

                //para ilustrar (tem que estar dentro do frmPesquisa)
                //txtTexto.append(str); // para adicionar texto ao final                            
        }

    }

private class AcoesBotao implements ActionListener{
    public void actionPerformed(ActionEvent e){
        cont++;
        txtArea.setText("Total de cliques no button:" + cont);
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

    public static String solicitaNome(){
        return JOptionPane.showInputDialog(null, "Qual é o seu nome?");
    }
}
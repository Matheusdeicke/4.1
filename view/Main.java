import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        // Perguntar o nome do usuário
        String nomeUsuario = Insere.solicitaNome();
        
        // Definir o título da janela principal com o nome do usuário
        JFrame frame = new JFrame();
        frame.setTitle(nomeUsuario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        Insere i = new Insere(nomeUsuario);
        frame.add(i);
        
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
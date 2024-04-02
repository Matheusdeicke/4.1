import java.io.*;

public class Salva {
    public void salvarNoTxt(String texto){
        try {
            FileWriter out = new FileWriter("texto.txt");
            BufferedWriter buff = new BufferedWriter(out);

            buff.write(texto);
            buff.close();
        } catch (IOException e){
            e.printStackTrace();
        }


        
    }
}

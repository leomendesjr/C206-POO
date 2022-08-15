package lucktester;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadSorteadora extends Thread{
    
    JLabel lable;   
    JFrame tela;    
    int num;    
    int id;
    
    public void run()
    {
        Random r = new Random();   
        num = r.nextInt(6);     
        tela.repaint();
        lable.setText(Integer.toString(num));
    }   
}

package lucktester;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadChecadora extends Thread{
    
    JLabel lable;
    int r1;   
    int r2;   
    int r3;    
    JFrame tela;    
    int pts;   
    int id;
    
    public ThreadChecadora(int rl1, int rl2, int rl3)
    {
        r1 = rl1;
        r2 = rl2;
        r3 = rl3;
    }
    
    public void run()
    {
        if(r1 == r2)
        {
            if(r2 == r3)
            {
                pts = 2;  
            }
            else
            {
                pts = 1;
            }
        }
        else if (r2 == r3)
        {
            pts = 1;
        }
        else pts = 0;
        int atual = Integer.parseInt(lable.getText());
        atual += pts;
        lable.setText(Integer.toString(atual));   
    }   
}

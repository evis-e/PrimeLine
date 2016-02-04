import javax.swing.*;
import java.awt.*;

/**
 * Created by evis on 15/06/06.
 */
public class DrawLine extends JPanel {
    private int w, h, num = 1;

    void increaseN(){
        this.num++;
    }

    int getN(){
        return this.num;
    }

    public DrawLine(int w, int h){
        this.w = w;
        this.h = h;
    }

    /*
     * d=1 -> N   d=2 -> E   d=3 ->S   d=4 -> W
     */
    void drawFibLine(Graphics g){
        int x = w / 2, y = h / 2, d = 1;
        int l = 3;
        for(int i = 1; i < num; i++){
            if(isPrime(i)){
                d++;
                if(d > 4) d = 1;
            }
            if(d == 1){
                g.drawLine(x, y, x, y - l);
                y -= l;
            }
            else if(d == 2){
                g.drawLine(x, y, x + l, y);
                x += l;
            }
            else if(d == 3){
                g.drawLine(x, y, x, y + l);
                y += l;
            }
            else{
                g.drawLine(x, y, x - l, y);
                x -= l;
            }
        }
    }

    private boolean isPrime(int p) {
        if(p == 2) return true;
        if(p < 3) return false;
        if(p % 2 == 0) return false;
        for(int i = 3; i*i <= p; i += 2) if (p % i == 0) return false;
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Set  anti-alias to make the drawings look cooler
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        drawFibLine(g);

        g.setColor(Color.CYAN);
        g.drawString(Integer.toString(num), 10, 20);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by evis on 15/06/06.
 */
public class PrimeLine extends JFrame {
    private final int width = 1000, height = 600, speed = 50, maxN = 10000;
    private Timer timer;
    private DrawLine draw;

    public PrimeLine(){
        setTitle("Prime Line");
        setSize(width, height);
        setResizable(true);
        setLocationRelativeTo(null);

        draw = new DrawLine(width, height);
        draw.setBackground(Color.DARK_GRAY);
        add(draw);
        setVisible(true);
        timer = new Timer(speed, new MyActionListener());
        timer.start();
    }
    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(draw.getN() > maxN) timer.stop();
            draw.increaseN();
            draw.repaint();
        }
    }
    public static void main(String[] args){
        new PrimeLine();
    }
}

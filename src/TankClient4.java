import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;

public class TankClient4 extends Frame{

    int x = 50, y=50;//坦克的左上角

    public static void main(String[] args){
        TankClient4 tc = new TankClient4();
        tc.launchFrame();
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,30,30);
        g.setColor(c);

        y+=5;

    }

    public void launchFrame(){
        this.setLocation(300,300);
        this.setSize( 800,600);
        this.setTitle("TankWar");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setBackground(Color.GREEN);
        this.setResizable(false);
        this.setVisible(true);
        new Thread (new PaintThread()).start();
    }

    private class PaintThread implements Runnable{ //内部类可以非常方便的访问包装类的方法，不方便公开的，只为包装类服务的类应当定义为内部类
        public void run(){
            while(true){
                repaint();//重画 机制
                try {
                    Thread.sleep(150);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}

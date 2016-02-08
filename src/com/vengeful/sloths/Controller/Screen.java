package com.vengeful.sloths.Controller;


import javax.swing.JFrame;
import com.vengeful.sloths.View.AreaView.AreaView;


public class Screen extends JFrame implements Runnable{

    public Screen(AreaView av) {
        this.av = av;
        initUI();
    }

    private AreaView av;

    private void initUI() {

        add(av);

        setTitle("A game");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        int count = 0;

        while(true) {
            long lastTime = System.currentTimeMillis();

            //Actual Code goes here

            av.repaint();
            //EntityObserver eo = (EntityObserver)av.getPlayer();

//            if ( count%20 == 4 ) {
//                eo.alertDirectionChange(Direction.E);
//            } else if ( count%20 == 8) {
//                eo.alertDirectionChange(Direction.N);
//            } else if ( count%20 == 12) {
//                eo.alertDirectionChange(Direction.W);
//            } else if ( count%20 == 16) {
//                eo.alertDirectionChange(Direction.S);
//            }

            //End of actual code

            long delta = System.currentTimeMillis() - lastTime;
            if (delta < 50) {
                try {
                    Thread.sleep((50 - delta));
                } catch (Exception e) {
                    //dont care
                }

            }
            //System.out.Println(count++);
        }
    }
    public void start() {
        new Thread(this).start();
    }
//    public static void main(String[] args) {
//
//
//
//
//
//
//    }
}
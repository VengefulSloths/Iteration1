package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Utility.Direction;

import javax.swing.JFrame;

public class driver extends JFrame implements Runnable{

	public driver() {
    	av = new AreaView();
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
		int ay=1;
        while(true) {
        	long lastTime = System.currentTimeMillis();
        	
        	//Actual Code goes here
        	av.repaint();
        	EntityObserver eo = (EntityObserver)av.getPlayer();

//			int xlist[] = {	1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//							2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,
//							5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,
//							4,4,4,4,3,3,3,3,2,2,2,2,1,1,1,1};
//			int ylist[] = {	2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,
//							5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,
//							4,4,4,4,3,3,3,3,2,2,2,2,1,1,1,1,
//							1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,};
//			if (count%4 == 0) eo.alertMove(xlist[count%64],ylist[count%64],200);
//        	if ( count%64 == 16 ) {
//            	eo.alertDirectionChange(Direction.LEFT);
//        	} else if ( count%64 == 32) {
//        		eo.alertDirectionChange(Direction.UP);
//        	} else if ( count%64 == 48) {
//        		eo.alertDirectionChange(Direction.RIGHT);
//        	} else if ( count%64 == 0) {
//        		eo.alertDirectionChange(Direction.DOWN);
//        	}

			if (count%25 == 0 && count < 125) eo.alertMove(1,ay++,1000);

			//End of actual code
        	
        	long delta = System.currentTimeMillis() - lastTime;
        	if (delta < 50) {
        		try {
        			Thread.sleep((50 - delta));
        		} catch (Exception e) {
        			//dont care
        		}
        		
        	}
        	System.out.println(count++);
        }
    }
    public void start() {
    	new Thread(this).start();
    }
    public static void main(String[] args) {


        driver ex = new driver();
        ex.setVisible(true);
    	
        ex.start();
        

        
    }
}
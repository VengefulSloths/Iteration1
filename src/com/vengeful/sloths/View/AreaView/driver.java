package com.vengeful.sloths.View.AreaView;

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

        while(true) {
        	long lastTime = System.currentTimeMillis();
        	
        	//Actual Code goes here
        	
        	av.repaint();
        	EntityObserver eo = (EntityObserver)av.getPlayer();

        	if ( count%20 == 4 ) {
            	eo.alertDirectionChange(Direction.RIGHT);
        	} else if ( count%20 == 8) {
        		eo.alertDirectionChange(Direction.UP);
        	} else if ( count%20 == 12) {
        		eo.alertDirectionChange(Direction.LEFT);
        	} else if ( count%20 == 16) {
        		eo.alertDirectionChange(Direction.DOWN);
        	}
        	
        	//End of actual code
        	
        	long delta = System.currentTimeMillis() - lastTime;
        	if (delta < 250) {
        		try {
        			Thread.sleep((250 - delta));
        		} catch (Exception e) {
        			//dont care
        		}
        		
        	}
			count++;
//        	System.out.println(count++);
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
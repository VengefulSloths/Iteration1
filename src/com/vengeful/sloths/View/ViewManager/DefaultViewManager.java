package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
//all together we have 6 JPanels: an overall background/holder, an areaview, a secondary view panel (containing StatsView, HUDView, InventoryView),
// and the three panels within the secondary view panel: (StatsVIEW, HUDView, InventoryView)
//note/edit: backgroundPanel might not be necessary: the DefaultViewManager overall is a JPanel, and therefore IS the backgroundPanel

public class DefaultViewManager extends ViewManager {

    //JPanel backgroundPanel; //might not be necessary - defaultViewManager is the backgroundPanel
    AreaView areaView;
    JPanel sidePanel; //edit: make private or protected or something because this shouldn't be set elsewhere? it's all contained in this class
    //HUDView hudview;
    //StatsView statsview;
    ListInventoryView inventoryView;
    private static final int viewWidth = 1100;
    private static final int viewHeight = 800;

    private static final double areaViewWidthProportion = 0.75;
    private static final double areaViewHeightProportion = 1.0;
    private static final double sidePanelWidthProportion = 0.25;
    private static final double sidePanelHeightProportion = 1.0;
    private static final double inventoryViewWidthProportion = 1.0;
    private static final double inventoryViewHeightProportion = 0.40; //edit: this will change when StatsView and HUDView are added

    private static final int areaViewWidth =(int) (areaViewWidthProportion * viewWidth);
    private static final int areaViewHeight = (int) (areaViewHeightProportion * viewHeight);
    private static final int sidePanelWidth = (int) (sidePanelWidthProportion * viewWidth);
    private static final int sidePanelHeight = (int) (sidePanelHeightProportion * viewHeight);
    private static final int inventoryViewWidth = (int) (inventoryViewWidthProportion * sidePanelWidth); //relative to the sidePanelWidth
    private static final int inventoryViewHeight = (int) (inventoryViewHeightProportion * sidePanelHeight); //relative to the sidePanelHeight

    /* View getters and setters */
    public AreaView getAreaView() {
        return areaView;
    }
    public void setAreaView(AreaView areaView) {
        this.areaView = areaView;
    }
    public ListInventoryView getInventoryView() {
        return inventoryView;
    }
    public void setInventoryView(ListInventoryView inventoryView) {
        this.inventoryView = inventoryView;
    }

    public DefaultViewManager() {

        /* Create all of the segments of the overall view */
        //backgroundPanel = new JPanel(new BorderLayout());
        sidePanel = new JPanel();
        areaView = new AreaView();
        inventoryView = new ListInventoryView();


        this.setPreferredSize(new Dimension(viewWidth,viewHeight));
        sidePanel.setPreferredSize(new Dimension(sidePanelWidth, sidePanelHeight));
        areaView.setPreferredSize(new Dimension(areaViewWidth, areaViewHeight));
        inventoryView.setPreferredSize(new Dimension(inventoryViewWidth, inventoryViewHeight));

        this.setBackground(Color.BLACK);
        sidePanel.setBackground(Color.BLUE);
        areaView.setBackground(Color.WHITE);
        inventoryView.setBackground(Color.RED);

        setLayout(new BorderLayout()); //set the layout of the DefaultViewManager to BorderLayout
        sidePanel.setLayout(new BorderLayout()); //set the layout of the sidePanel to BorderLayout
        //inventoryView.setLayout(new BorderLayout());//set layout of inventoryView....maybe this isn't appropriate in this class?

        sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));


        //sidePanel.add(inventoryView, BorderLayout.CENTER); //eventually, will add StatsView and HUDView to sidePanel
        sidePanel.add(inventoryView, BorderLayout.SOUTH);
        add(areaView, BorderLayout.WEST);
        add(sidePanel, BorderLayout.EAST);


    }
}

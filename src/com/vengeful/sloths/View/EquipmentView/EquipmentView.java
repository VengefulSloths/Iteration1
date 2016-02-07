package com.vengeful.sloths.View.EquipmentView;

import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.View.Observers.ProxyObserver;
import com.vengeful.sloths.View.View;
import com.vengeful.sloths.Models.ObserverManager;

import java.awt.*;

/**
 * Created by echristiansen on 2/1/2016.
 */

public abstract class EquipmentView extends View implements EquipmentObserver{

    String defaultEquipmentBackground = "resources/inventoryBackground.jpg";


    public EquipmentView() {

    }

    public EquipmentView(Equipped equipped) {
        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyObserver peo = new ProxyEquipmentObserver(this, equipped);
        ObserverManager.instance().addProxyObserver(peo);

    }

    public EquipmentView(Equipped equipped, int width, int height) {

        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyObserver peo = new ProxyEquipmentObserver(this, equipped);
        ObserverManager.instance().addProxyObserver(peo);
    }

    public abstract void setSelected(EquipmentViewObject item);
    public abstract void setDeselected(EquipmentViewObject item);





}



import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class InventoryItemViewObject extends ViewObject {

    private final Image itemImage;

    public InventoryItemViewObject(int x, int y, String image) {
        this.x = x;
        this.y = y;

        ImageIcon itemIcon = new ImageIcon(image);
        itemImage = itemIcon.getImage();
    }

    @Override
    void paintComponent(Graphics2D g) {
        g.drawImage(itemImage, x, y, this);
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryViewObjectManager {
    private ArrayList<InventoryItemViewObject> itemList;

    public ListInventoryViewObjectManager() {
        itemList = new ArrayList<InventoryItemViewObject>();
    }

    public void addInventoryItemViewObject(InventoryItemViewObject item) {
        //We can sort on iterator because it will be called less
        itemList.add(item);
    }


    public Iterator<InventoryItemViewObject> iterator() {
//        itemList.sort(new Comparator<InventoryItemViewObject>() {
//            private int viewObjectClassToHeightIndex(InventoryItemViewObject vo) {
//                if (vo.getClass() == EntityMapViewObject.class) return 100;
//                else if (vo.getClass() == TerrainMapViewObject.class) return 0;
//                else return 1000;
//            }
//            public int compare(InventoryItemViewObject left, InventoryItemViewObject right) {
//                return viewObjectClassToHeightIndex(left) - viewObjectClassToHeightIndex(right);
//            }
//        });
        return itemList.iterator();
    }

}

package com.vengeful.sloths.View.AreaView.Observers;

import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.Models.Map.MapItems.*;

public interface EntityObserver extends ModelObserver{
	void alertDirectionChange(Direction d);
	void alertMove(int x, int y, long animationTime);
	void alertDrop(int x, int y, MapItem itemToDrop);
}

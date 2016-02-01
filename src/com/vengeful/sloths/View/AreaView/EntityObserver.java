package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Utility.Direction;

public interface EntityObserver extends ModelObserver{
	void alertDirectionChange(Direction d);
	void alertMove(int x, int y, long animationTime);
}

package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.View.AreaView.Direction;

public interface EntityObserver {
	void alertDirectionChange(Direction d);
	void alertMove(int x, int y);
}

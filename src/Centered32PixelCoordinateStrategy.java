
public class Centered32PixelCoordinateStrategy extends CoordinateStrategy {
	private int xOffset;
	private int yOffset;
	public Centered32PixelCoordinateStrategy(CameraView cv, AreaView av) {
		this.cv = cv;
		yOffset = av.getAreaHeight()/2 - cv.getY()*32/2;
		xOffset = av.getAreaWidth()/2 - cv.getX()*32/2;
	}
	@Override
	public int convertToPixelsX(int x) {
		return xOffset+x*32;
	}

	@Override
	public int convertToPixelsY(int y) {
		return yOffset+y*32;
	}

}

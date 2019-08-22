package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShape extends Shape {
	private Color colorInside = Color.WHITE;
	private String colorInsideEdge = "bela";
	
	public abstract void fill(Graphics g);

	public Color getColorInside() {
		return colorInside;
	}

	public void setColorInside(Color colorInside) {
		this.colorInside = colorInside;
	}
	
	public String getColorInsideEdge() {
		return colorInsideEdge;
	}

	public void setColorInsideEdge(String colorInsideEdge) {
		this.colorInsideEdge = colorInsideEdge;
	}
	

	public String getHexColor(Color color) {
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		String hex = String.format("#%02x%02x%02x", red,green,blue);
		return hex;
	}
}

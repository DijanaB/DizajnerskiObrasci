package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
	private Color bojaUnutrasnjosti = Color.WHITE;
	private String bojaUnutrasnjostiStr = "bela";
	
	public abstract void popuni(Graphics g);

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public String getBojaUnutrasnjostiStr() {
		return bojaUnutrasnjostiStr;
	}

	public void setBojaUnutrasnjostiStr(String bojaUnutrasnjostiStr) {
		this.bojaUnutrasnjostiStr = bojaUnutrasnjostiStr;
	}
	

	public String getHexColor(Color color) {
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		String hex = String.format("#%02x%02x%02x", red,green,blue);
		return hex;
	}
}

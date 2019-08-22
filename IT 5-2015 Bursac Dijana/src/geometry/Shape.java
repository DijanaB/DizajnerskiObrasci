package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable, Cloneable{
	private Color color = Color.BLACK;
	private String colorOfEdge = "crna";
	private boolean selected;

	public Shape(){

	}
	public Shape(Color color){
		this.color = color;
	}

	/* promeniti  */
	public abstract void drawIt(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String getHexColor(Color color) {
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		String hex = String.format("#%02x%02x%02x", red,green,blue);
		return hex;
	}

	public static Color findColor(String color){
		if(color.equalsIgnoreCase("crna"))
			return Color.BLACK;
		else if(color.equalsIgnoreCase("bela"))
			return Color.WHITE;
		else if(color.equalsIgnoreCase("plava"))
			return Color.BLUE;
		else if(color.equalsIgnoreCase("crvena"))
			return Color.RED;
		else if(color.equalsIgnoreCase("zuta"))
			return Color.YELLOW;
		else if(color.equalsIgnoreCase("zelena"))
			return Color.GREEN;
		else if(color.equalsIgnoreCase("pink"))
			return Color.PINK;
		else
			return Color.BLACK;
	}
	
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getColorOfEdge() {
		return colorOfEdge;
	}

	public void setColorOfEdge(String colorOfEdge) {
		this.colorOfEdge = colorOfEdge;
	}

	public static boolean checkNumber(int number)throws Exception{
		if(number<=0)
			throw new Exception();
		else
			return true;
		
	}

}

package geometry;

import java.awt.Color;
import java.awt.Graphics;

import geometry.HexagonAdapter;
import hexagon.Hexagon;

public class HexagonAdapter extends SurfaceShape  {
	
	private Hexagon hexagon;
	
	
	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public HexagonAdapter() {
		
	}
	
	public HexagonAdapter(Hexagon hexagon) {
		this.hexagon = hexagon;
		
	}
	
	public HexagonAdapter(int x,int y,int r,Color BorderColor, Color AreaColor) {
		this.hexagon = new Hexagon(x,y,r);
		this.hexagon.setBorderColor(BorderColor);
		this.hexagon.setAreaColor(AreaColor);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Hexagon){
			Hexagon pomocni  = (Hexagon) o;
			return this.hexagon.getR() - pomocni.getR();
		}
		else 
			return 0;
	}


	


	@Override
	public void fill(Graphics g) {
	
		g.setColor(hexagon.getAreaColor());
		
		
	}

	@Override
	public void drawIt(Graphics g) {
		hexagon.paint(g);
		
		
	}

	@Override
	public void selected(Graphics g) {
	
		/*g.setColor(Color.BLUE);
		hexagon.setSelected(true);
		super.setSelected(true);	*/
		if(isSelected())
			hexagon.setSelected(true);
		else
			hexagon.setSelected(false);
		
		
		
	}
	
	public String toString() {
		return "Hexagon: ("+getHexagon().getX()+","+getHexagon().getY()+"), radius: "+getHexagon().getR()+", outline: "+getHexagon().getBorderColor()+", fill: "+getHexagon().getAreaColor()+", selected: "+isSelected();
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	public HexagonAdapter clone() {
		Hexagon hexagon = new Hexagon(getXCoordinate(), getYCoordinate(), getR());
		hexagon.setBorderColor(getEdgeColor());
		hexagon.setAreaColor(getAreaColor());
		return new HexagonAdapter(hexagon);
	}

	public int getR() {
		return hexagon.getR();
	}

	public void setR(int r) {
		hexagon.setR(r);
	}

	public int getXCoordinate() {
		return hexagon.getX();
	}

	public int getYCoordinate() {
		return hexagon.getY();
	}

	public Color getEdgeColor() {
		return hexagon.getBorderColor();
	}

	public void setEdgeColor(Color color) {
		hexagon.setBorderColor(color);
	}

	public Color getAreaColor() {
		return hexagon.getAreaColor();
	}

	public void setAreaColor(Color color) {
		hexagon.setAreaColor(color);
	}

}

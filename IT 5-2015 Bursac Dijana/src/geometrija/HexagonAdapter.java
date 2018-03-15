package geometrija;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;

public class HexagonAdapter extends PovrsinskiOblik  {
	
	private Hexagon hexagon;
	
	
	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public HexagonAdapter() {
		
	}
	
	public HexagonAdapter(int x,int y,int r,Color bojaKonture, Color bojaUnutrasnjosti) {
		this.hexagon = new Hexagon(x,y,r);
		this.hexagon.setBorderColor(bojaKonture);
		this.hexagon.setAreaColor(bojaUnutrasnjosti);
		
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
	public void popuni(Graphics g) {
	
		g.setColor(hexagon.getAreaColor());
		
		
	}

	@Override
	public void crtajSe(Graphics g) {
		hexagon.paint(g);
		
		
	}

	@Override
	public void selektovan(Graphics g) {
	
		g.setColor(Color.BLUE);
		hexagon.setSelected(true);
		super.setSelektovan(true);	
		
		
		
	}
	
	public String toString() {
		return "Hexagon: ("+getHexagon().getX()+","+getHexagon().getY()+"), radius: "+getHexagon().getR()+", outline: "+getHexagon().getBorderColor()+", fill: "+getHexagon().getAreaColor()+", selected: "+isSelektovan();
	}

	@Override
	public boolean sadrzi(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	

}

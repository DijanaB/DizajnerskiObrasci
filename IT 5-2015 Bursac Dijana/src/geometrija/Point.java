package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape implements Moveable{
	private int x;
	private int y;


	public Point(){

	}
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, Color color){
		this(x, y);
		setColor(color);
	}	

	public String toString(){

		return "Point: (" + x+ ","+ getY()+ "), "+getHexColor(getColor())+", selected: "+isSelected();
	}

	public boolean equals(Object obj){
		if(obj instanceof Point){
			Point helper=(Point) obj;
			if(x==helper.getX() && y==helper.getY())
				return true;
			else
				return false;
		}
		else 
			return false;
	}

	public void moveTo(int newX, int newY){
		x = newX;
		y = newY;
	}

	public void moveFor(int newX, int newY){
		x = x + newX;
		y = y + newY;
	}

	public double distance(Point t2){
		double dx = x - t2.x;
		double dy = y - t2.getY();
		double out = Math.sqrt(dx*dx + dy*dy);

		return out;
	}
	public boolean contains(int x, int y){
		Point mestoKlika = new Point(x, y);
		if(mestoKlika.distance(this)<=2)
			return true;
		else
			return false;

	}
	public void selected(Graphics g){
		g.setColor(findColor("plava"));
		g.drawRect(this.getX()-3, this.getY()-3, 6, 6);
	}
	public void drawIt(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelected())
			selected(g);

	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Point){
			Point pomocna  = (Point) o;
			Point nula = new Point(0, 0);
			Point drugaPomocna = new Point(x, y);
			int pom1 = (int) nula.distance(drugaPomocna);
			int pom2 = (int) nula.distance(pomocna);

			return pom1 - pom2;

		}
		else
			return 0;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void setX(int newX)throws Exception{
		if(newX<0)
			throw new Exception("X has to be at least 0!");
		else
			x = newX;
	}
	public void setY(int newY)throws Exception{
		if(newY<0)
			throw new Exception("Y has to be at least 0!");
		else
			y = newY;
	}

}

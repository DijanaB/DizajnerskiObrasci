package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape implements Moveable{
	private Point pStart;
	private Point pEnd;

	public Line(){

	}
	public Line(Point pStart, Point pEnd){
		this.pStart = pStart;
		this.pEnd = pEnd;
	}

	public Line(Point pStart, Point pEnd, Color color){
		this(pStart, pEnd);
		setColor(color);
	}

	public Point middleOfLine(){
		int middleX = (pStart.getX() + pEnd.getX()) / 2;
		int middleY = (pStart.getY() + pEnd.getY()) / 2;
		return new Point(middleX, middleY);
	}

	public String toString(){
		return "Line: startPoint ("+pStart.getX()+"," +pStart.getY()+"), endPoint (" + pEnd.getX()+","+ pEnd.getY()+"), "+ getHexColor(getColor())+", selected:"+isSelected();
	}

	public boolean equals(Object obj){
		if(obj instanceof Line){
			Line helper=(Line) obj;
			if(this.pStart.equals(helper.pStart) && this.pEnd.equals(helper.pEnd))
				return true;
			else
				return false;
		}
		else 
			return false;
	}


	public double lenght(){
		return pStart.distance(pEnd);
	}

	public void moveFor(int x, int y)throws Exception{
		pStart.setX(pStart.getX()+x);
		pStart.setY(pStart.getY()+y);
		pEnd.setX(pEnd.getX()+x);
		pEnd.setY(pEnd.getY()+y);

	}
	
	public void moveTo(int x, int y) throws Exception{
		int rx = pStart.getX() - pEnd.getX();
		int ry = pStart.getY() - pEnd.getY();
		pStart.setX(x);
		pStart.setY(y);
		pEnd.setX(x+rx);
		pEnd.setY(y+ry);
		
		
	}
	
	public boolean contains(int x, int y){
		Point clickPlace = new Point(x, y);
		if(clickPlace.distance(pStart)+clickPlace.distance(pEnd)-this.lenght()<=0.5)
			return true;
		 else 
			return false;		
	}
	public void selected(Graphics g){
		g.setColor(Color.BLUE);
		pStart.selected(g);
		pEnd.selected(g);
		middleOfLine().selected(g);
	}
	public void drawIt(Graphics g){
		g.setColor(getColor());
		g.drawLine(pStart.getX(), pStart.getY(), pEnd.getX(), pEnd.getY());
		if(isSelected())
			selected(g);
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Line){
			Line helper  = (Line) o;
			//Linija drugaPomocna = new Linija(tPocetna, tKrajnja);
			return (int) (this.lenght()-helper.lenght());

		}
		else
			return 0;
	}
	public Point getpStart() {
		return pStart;
	}
	public void setpStart(Point pStart) {
		this.pStart = pStart;
	}
	public Point getpEnd() {
		return pEnd;
	}
	public void setpEnd(Point pEnd) {
		this.pEnd = pEnd;
	}

	

}

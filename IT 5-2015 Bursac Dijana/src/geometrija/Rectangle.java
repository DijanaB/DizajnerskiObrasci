package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Square{
	private int width;


	public Rectangle(){

	}
	public Rectangle(Point upLeft, int width, int height){
		super(upLeft, height);
		this.width = width;
	}
	public Rectangle(Point upLeft, int width, int height, Color color){
		this(upLeft, width, height);
		setColor(color);
	}

	public Rectangle(Point upLeft, int width, int height, Color colorOfEdge, Color colorInside){
		this(upLeft, width, height, colorOfEdge);
		setColorInside(colorInside);
	}

	public Line diagonal(){
		return new Line(upLeft, new Point(upLeft.getX() + width,upLeft.getY() + edgeLength));
	}

	public void moveTo(int x, int y) throws Exception{
		upLeft.setX(x);
		upLeft.setY(y);
	}
	public void moveFor(int x, int y) throws Exception{
		upLeft.setX(upLeft.getX()+x);
		upLeft.setY(upLeft.getY()+y);

	}

	public Point rectangleCenter(){
		return diagonal().middleOfLine();
	}

	public String toString(){
		return "Rectangle: ("+upLeft.getX()+","+upLeft.getY()+"), width: "+getSirina()+", height: "+edgeLength+", outline: "+getHexColor(getColor())+", fill: "+ getHexColor(getColorInside())+", selected: "+isSelected();
	}

	public boolean equals(Object obj){
		if(obj instanceof Rectangle){
			Rectangle helper=(Rectangle) obj;
			if(this.upLeft.equals(helper.upLeft) && this.edgeLength==helper.edgeLength && this.width==helper.width)
				return true;
			else
				return false;
		}
		else 
			return false;
	}


	public int surface(){
		return edgeLength * width;
	}
	public int circumference(){
		return  2 * edgeLength + 2 * width;
	}
	public boolean contains(int x, int y) {
		if(this.getUpLeft().getX()<=x 
				&& x<=(this.getUpLeft().getX() + width)
				&& this.getUpLeft().getY()<=y 
				&& y<=(this.getUpLeft().getY() + edgeLength))
			return true;
		else 
			return false;

	}
	public void selected(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Line(getUpLeft(), new Point(getUpLeft().getX()+width, getUpLeft().getY())).selected(g);
		new Line(getUpLeft(), new Point(getUpLeft().getX(), getUpLeft().getY()+edgeLength)).selected(g);
		new Line(new Point(getUpLeft().getX()+width, getUpLeft().getY()), diagonal().getpEnd()).selected(g);
		new Line(new Point(getUpLeft().getX(), getUpLeft().getY()+edgeLength), diagonal().getpEnd()).selected(g);
	}
	public void drawIt(Graphics g){
		g.setColor(getColor());
		g.drawRect(upLeft.getX(), upLeft.getY(), width, edgeLength);
		fill(g);
		if(isSelected())
			selected(g);
	}
	public void fill(Graphics g){
		g.setColor(getColorInside());
		g.fillRect(upLeft.getX()+1, upLeft.getY()+1, width-1, edgeLength-1);
	}

	public int getVisina() {
		return edgeLength;
	}
	public int getSirina() {
		return width;
	}

	public void setVisina(int visina) throws Exception{
		if(visina <= 0)
			throw new Exception("Duzina visine mora biti pozitivan broj!");
		else
			this.edgeLength = visina;
	}
	public void setSirina(int sirina) throws Exception{
		if(sirina <= 0)
			throw new Exception("Duzina sirine mora biti pozitivan broj!");
		else
			this.width = sirina;
		
	}
	
	

}

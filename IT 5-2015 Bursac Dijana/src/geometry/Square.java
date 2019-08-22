package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends SurfaceShape implements Moveable{
	protected Point upLeft;
	protected int edgeLength;


	public Square(){

	}
	public Square(Point upLeft, int edgeLength){
		this.upLeft = upLeft;
		this.edgeLength = edgeLength;
	}
	public Square(Point upLeft, int edgeLenght, Color color){
		setColor(color);
		this.upLeft = upLeft;
		this.edgeLength = edgeLenght;
		//this(goreLevo, duzinaStranice);
		//this.boja = boja;
	}

	public Square(Point upLeft, int edgeLength, Color edgeColor, Color insideColor){
		this(upLeft,edgeLength,edgeColor);
		setColorInside(insideColor);
		//this(goreLevo, duzinaStranice);
		//this.boja = boja;
	}
	
	public Square(Point upLeft, int edgeLength, String edgeColor, String insideColor){
		this(upLeft,edgeLength);
		setColorOfEdge(edgeColor);
		setColorInsideEdge(insideColor);
		//this(goreLevo, duzinaStranice);
		//this.boja = boja;
	}


	public Line diagonal(){
		return new Line(upLeft, new Point(upLeft.getX() + edgeLength,upLeft.getY() + edgeLength));
	}

	public Point squareCenter(){
		return diagonal().middleOfLine();
	}

	public String toString(){
		return "Square: ("+upLeft.getX()+","+upLeft.getY()+"), "+edgeLength+", outline: "+getHexColor(getColor())+", fill: "+ getHexColor(getColorInside())+", selected: "+isSelected();
	}
	
	public String description(){
		return "Point up left=("+upLeft.getX()+","+upLeft.getY()+"),edge length="+edgeLength + ", edge color: \"" + getColorOfEdge() + "\", surface color: \"" + getColorInsideEdge() + "\"";
	}

	public boolean equals(Object obj){
		if(obj instanceof Square){
			Square pomocni=(Square) obj;
			if(this.upLeft.equals(pomocni.upLeft) && this.edgeLength==pomocni.edgeLength)
				return true;
			else
				return false;
		}
		else 
			return false;
	}

	public void moveTo(int x, int y) throws Exception{
		upLeft.setX(x);
		upLeft.setY(y);
	}

	public void moveFor(int x, int y) throws Exception{
		upLeft.setX(upLeft.getX()+x);
		upLeft.setY(upLeft.getY()+y);
	}

	public int circumference(){
		return 4 * edgeLength;
	}
	public int surface(){
		return edgeLength * edgeLength;
	}
	public boolean contains(int x, int y) {
		if(this.getUpLeft().getX()<=x 
				&& x<=(this.getUpLeft().getX() + edgeLength)
				&& this.getUpLeft().getY()<=y 
				&& y<=(this.getUpLeft().getY() + edgeLength))
			return true;
		else 
			return false;

	}
	public void selected(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Line(getUpLeft(), new Point(getUpLeft().getX()+edgeLength, getUpLeft().getY())).selected(g);
		new Line(getUpLeft(), new Point(getUpLeft().getX(), getUpLeft().getY()+edgeLength)).selected(g);
		new Line(new Point(getUpLeft().getX()+edgeLength, getUpLeft().getY()), diagonal().getpEnd()).selected(g);
		new Line(new Point(getUpLeft().getX(), getUpLeft().getY()+edgeLength), diagonal().getpEnd()).selected(g);

	}
	public void drawIt(Graphics g){
		g.setColor(getColor());
		g.drawRect(upLeft.getX(), upLeft.getY(), edgeLength, edgeLength);
		fill(g);
		if(isSelected())
			selected(g);
	}
	public void fill(Graphics g){
		g.setColor(getColorInside());
		g.fillRect(upLeft.getX()+1, upLeft.getY()+1, edgeLength-1, edgeLength-1);
	}

	public int compareTo(Object o) {
		if(o instanceof Square){
			Square helper  = (Square) o;
			return this.surface() - helper.surface();
		}
		else 
			return 0;
	}
	public Point getUpLeft() {
		return upLeft;
	}

	public void setUpLeft(Point goreLevo) {
		this.upLeft = goreLevo;
	}
	public void setEdgeLength(int duzinaStranica) throws Exception{
		if(duzinaStranica<=0)
			throw new Exception("Edge length must be positive number!");
		else
			this.edgeLength = duzinaStranica;
	}
	public int getEdgeLength() {
		return edgeLength;
	}

	


}

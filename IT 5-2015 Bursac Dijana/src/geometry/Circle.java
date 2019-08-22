package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape implements Moveable{
	private Point centar;
	private int r;


	public Circle(){

	}
	public Circle(Point centar, int r){
		this.centar = centar;
		this.r = r;
	}
	public Circle(Point centar, int r, Color boja){
		this(centar, r);
		setColor(boja);
	}
	
	public Circle(Point centar, int r, Color bojaKonture, Color bojaUnutrasnjosti){
		this(centar, r, bojaKonture);
		setColorInside(bojaUnutrasnjosti);
	}

	public String toString(){
		return "Circle: (" + centar.getX() + ","+centar.getY()+"), radius: "+getR()+", outline: "+getHexColor(getColor())+", fill: "+getHexColor(getColorInside())+" selected: "+isSelected();
	}

	public void moveTo(int x, int y) throws Exception{
		centar.setX(x);
		centar.setY(y);
	}
	public void moveFor(int x, int y) throws Exception{
		centar.setX(centar.getX()+x);
		centar.setY(centar.getY()+y);
	}
	public double povrsina(){
		return r * r * Math.PI;
	}
	public double obim(){
		return 2 * r * Math.PI;
	}
	public boolean contains(int x, int y){
		Point mestoKlika = new Point(x, y);
		if(mestoKlika.distance(centar)<=r)
			return true;
		else
			return false;
		
	}
	public void selected(Graphics g) {
		// TODO Auto-generated method stub
		new Line(new Point(centar.getX(), centar.getY()-r), new Point(centar.getX(), centar.getY() + r)).selected(g);
		new Line(new Point(centar.getX()-r, centar.getY()), new Point(centar.getX()+r, centar.getY())).selected(g);
	}
	public void drawIt(Graphics g){
		fill(g);
		g.setColor(getColor());
		g.drawOval(centar.getX()-r, centar.getY()-r, 2*r, r*2);
		if(isSelected())
			selected(g);
	}
	public void fill(Graphics g){
		g.setColor(getColorInside());
		g.fillOval(centar.getX()-r, centar.getY()-r, 2*r+1, r*2+1);
	}

	public int compareTo(Object o) {
		if(o instanceof Circle){
			Circle pomocni  = (Circle) o;
			return this.r - pomocni.r;
		}
		else
			return 0;
	}
	public Point getCentar() {
		return centar;
	}
	public int getR() {
		return r;
	}
	public void setCentar(Point centar) {
		this.centar = centar;
	}
	public void setR(int r) throws Exception{
		if(r <= 0)
			throw new Exception("Duzina poluprecnika mora biti pozitivan broj!");
		else
			this.r = r;		
	}




}

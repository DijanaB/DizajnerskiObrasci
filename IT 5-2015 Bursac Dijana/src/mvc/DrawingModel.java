package mvc;

import java.util.ArrayList;
import java.util.Stack;

import geometrija.Oblik;

public class DrawingModel {

	private ArrayList <Oblik> shapes = new ArrayList <Oblik>(); 
	private Stack <Oblik> stackShapes = new Stack <Oblik>();
	
	public ArrayList<Oblik> getShapes(){
		return shapes;
		
			
	}
	
	public void add(Oblik shape) {
		
		shapes.add(shape);
	}
	
	public boolean remove (Oblik shape) {
		
		return shapes.remove(shape);
	}
	
	public Oblik get (int i) {
		
		return shapes.get(i);
	}

	public Stack<Oblik> getStackShapes() {
		return stackShapes;
	}

	public void setStackShapes(Stack<Oblik> stackShapes) {
		this.stackShapes = stackShapes;
	}

	public void setShapes(ArrayList<Oblik> shapes) {
		this.shapes = shapes;
	}
	
	
}

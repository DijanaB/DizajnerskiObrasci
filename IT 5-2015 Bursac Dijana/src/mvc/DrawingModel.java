package mvc;

import java.util.ArrayList;
import java.util.Stack;

import geometrija.Oblik;

public class DrawingModel {

	private ArrayList <Oblik> shapes = new ArrayList <Oblik>(); 
	private Stack <Oblik> stackShapesUndo = new Stack <Oblik>();
	
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

	public Stack<Oblik> getStackShapesUndo() {
		return stackShapesUndo;
	}

	public void setStackShapes(Stack<Oblik> stackShapes) {
		this.stackShapesUndo = stackShapes;
	}

	public void setShapes(ArrayList<Oblik> shapes) {
		this.shapes = shapes;
	}
	
	
}

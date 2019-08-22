package mvc;

import java.util.ArrayList;
import java.util.Stack;

import geometry.Shape;

public class DrawingModel {

	private ArrayList <Shape> shapes = new ArrayList <Shape>(); 
	private Stack <Shape> stackShapesUndo = new Stack <Shape>();
	
	public ArrayList<Shape> getShapes(){
		return shapes;
		
			
	}
	
	public void add(Shape shape) {
		
		shapes.add(shape);
		System.out.println("DODAO SAM GA U LSITU OBJEKATA I IMA IH ");
		
	}
	
	public boolean remove (Shape shape) {
		
		return shapes.remove(shape);
	}
	
	public Shape get (int i) {
		
		return shapes.get(i);
	}

	public Stack<Shape> getStackShapesUndo() {
		return stackShapesUndo;
	}

	public void setStackShapes(Stack<Shape> stackShapes) {
		this.stackShapesUndo = stackShapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	
}

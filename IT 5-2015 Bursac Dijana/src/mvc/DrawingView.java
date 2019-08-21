package mvc;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import geometrija.Shape;

public class DrawingView extends JPanel {
 
	private DrawingModel model;
	
	public DrawingView() {
		
		super();
		setBackground(Color.WHITE);
		
	}
	
	public void setModel(DrawingModel model) {
		
		this.model=model;
		
	}
	
	public void paint (Graphics g) {
		
		super.paint(g);
		if(model!=null) {
			
			Iterator<Shape> it = model.getShapes().iterator();
			while (it.hasNext()) {
				
				it.next().drawIt(g);
				
			}
			repaint();
		}
		
		
	}
}

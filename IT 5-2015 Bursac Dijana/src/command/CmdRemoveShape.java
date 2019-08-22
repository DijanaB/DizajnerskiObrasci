package command;

import geometry.Shape;
import mvc.DrawingModel;

public class CmdRemoveShape implements Command{

	DrawingModel model = new DrawingModel();
	Shape o;
	
	public CmdRemoveShape() {
	
	}
	
	public CmdRemoveShape(Shape o, DrawingModel model) {
		
		this.model=model;
		this.o=o;
		
	}
	
	@Override
	public void execute() {
		
		model.remove(o);
	}

	@Override
	public void unexecute() {
		
		model.add(o);
		
	}

}

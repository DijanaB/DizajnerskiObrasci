package command;

import geometry.Shape;
import mvc.DrawingModel;

public class CmdAddShape implements Command {

	DrawingModel model = new DrawingModel();
	Shape o;
	
	public CmdAddShape() {
		
		
	}
	
	public CmdAddShape(Shape o, DrawingModel model) {
		
		this.model=model;
		this.o=o;
		
		
	}
	
	@Override
	public void execute() {
		
		model.add(o);
	
	}

	@Override
	public void unexecute() {
		
		model.remove(o);
		
	}

}

package command;

import geometrija.Oblik;
import mvc.DrawingModel;

public class CmdAddShape implements Command {

	DrawingModel model = new DrawingModel();
	Oblik o;
	
	public CmdAddShape() {
		
		
	}
	
	public CmdAddShape(Oblik o, DrawingModel model) {
		
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

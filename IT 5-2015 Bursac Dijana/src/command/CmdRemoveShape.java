package command;

import geometrija.Oblik;
import mvc.DrawingModel;

public class CmdRemoveShape implements Command{

	DrawingModel model = new DrawingModel();
	Oblik o;
	
	public CmdRemoveShape() {
	
	}
	
	public CmdRemoveShape(Oblik o, DrawingModel model) {
		
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

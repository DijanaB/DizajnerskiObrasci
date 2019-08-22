package command;

import geometry.HexagonAdapter;

public class CmdUpdateHexagon implements Command {

	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter originalState;
	//private String commandLog;
	
	public CmdUpdateHexagon(HexagonAdapter oldState, HexagonAdapter newState) {
		this.oldState = oldState;
		this.newState = newState;
	}
	
	@Override
	public void execute() {
		
		originalState = (HexagonAdapter) oldState.clone();
		oldState.getHexagon().setX(newState.getHexagon().getX());
		oldState.getHexagon().setY(newState.getHexagon().getY());
		oldState.setR(newState.getR());
	
	
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setAreaColor(newState.getAreaColor());
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}

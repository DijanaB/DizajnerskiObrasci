package observer;

public class ButtonObserver implements Observer {
	
	private boolean status;
	
	public ButtonObserver() {
		
	}

	public ButtonObserver(Subject s) {
		
		s.addObserver(this);
		
	}
	
	@Override
	public void update(boolean status) {
		
		this.status = status;
		
	}

}

package observer;

import java.util.ArrayList;

public class Button implements Subject {
	
	ArrayList<Observer> observers;
	private boolean status;
	
	public Button() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		int observerIndex = observers.indexOf(o);
		observers.remove(observerIndex);		
	}

	@Override
	public void notifyAllObservers() {
		for(Observer observer: observers) {
			
			observer.update(status);
		}
		
	}

}

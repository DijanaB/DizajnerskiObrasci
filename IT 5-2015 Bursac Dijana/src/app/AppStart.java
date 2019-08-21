package app;

import mvc.DrawingController;
import mvc.DrawingModel;
import mvc.Frame;
import observer.ButtonObserver;

public class AppStart  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		DrawingModel model = new DrawingModel();
		Frame frame = new Frame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setController(controller);
		frame.setVisible(true);
		
		
		
		
	}

}

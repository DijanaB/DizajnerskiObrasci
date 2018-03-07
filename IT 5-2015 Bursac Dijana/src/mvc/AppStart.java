package mvc;

import wb.Crtanje;

public class AppStart  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DrawingModel model = new DrawingModel();
		Crtanje frame = new Crtanje();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setController(controller);
		frame.setVisible(true);
		
	}

}

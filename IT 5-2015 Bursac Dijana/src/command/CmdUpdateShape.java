package command;

import geometry.Circle;
import geometry.HexagonAdapter;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Square;
import mvc.DrawingModel;

public class CmdUpdateShape implements Command {
	
	private Shape original;
	private Shape newState;
	private Shape oldState;
	private DrawingModel model = new DrawingModel();

	public CmdUpdateShape(Shape original,Shape newState) {


		this.original = original;
		this.newState = newState;

	}

	@Override
	public void execute() {
		
		if(original instanceof Point){
			try {
				
				oldState = new Point();
				
				((Point) oldState).setX(((Point) original).getX());
				((Point) oldState).setY(((Point) original).getY());
				oldState.setColor(original.getColor());
				oldState.setSelected(original.isSelected());


				((Point) original).setX(((Point) newState).getX());
				((Point) original).setY(((Point) newState).getY());
				original.setColor(newState.getColor());
				
				original.setSelected(newState.isSelected());
				
			

			} catch (NumberFormatException e1) {
				
			} catch (Exception e1) {

			}


		} else if(original instanceof Line) {

			oldState = new Line();

			((Line) oldState).setpStart(((Line) original).getpStart());
			((Line) oldState).setpEnd(((Line) original).getpEnd());
			oldState.setColor(original.getColor());
			oldState.setSelected(original.isSelected());


			((Line) original).setpStart(((Line) newState).getpStart());
			((Line) original).setpEnd(((Line) newState).getpEnd());

			original.setColor(newState.getColor());
			original.setSelected(newState.isSelected());


		}else if(original instanceof Circle) {

			oldState=new Circle();

			
			try {
				((Circle) oldState).setCentar(((Circle) original).getCentar());
				((Circle) oldState).setR(((Circle) original).getR());
				oldState.setColor(original.getColor());
				((Circle) oldState).setColorInside(((Circle) original).getColorInside());
				oldState.setSelected(original.isSelected());

				((Circle) original).setCentar(((Circle) newState).getCentar());
				((Circle) original).setR(((Circle) newState).getR());
				original.setColor(newState.getColor());
				((Circle) original).setColorInside(((Circle) newState).getColorInside());
				System.out.println("SELEKTOVAN SAM I IDE NA PROMENU");
				original.setSelected(newState.isSelected());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		} else if(original instanceof Rectangle) {

			oldState = new Rectangle();

			try {

				((Rectangle) oldState).setUpLeft(((Rectangle) original).getUpLeft());
				((Rectangle) oldState).setSirina(((Rectangle) original).getSirina());
				((Rectangle) oldState).setEdgeLength(((Rectangle) original).getEdgeLength());
				((Rectangle) oldState).setColor(original.getColor());
				((Rectangle) oldState).setColorInside(((Rectangle) original).getColorInside());
				oldState.setSelected(original.isSelected());

				((Rectangle) original).setUpLeft(((Rectangle) newState).getUpLeft());
				((Rectangle) original).setSirina(((Rectangle) newState).getSirina());
				((Rectangle) original).setEdgeLength(((Rectangle) newState).getEdgeLength());
				((Rectangle) original).setColor(newState.getColor());
				((Rectangle) original).setColorInside(((Rectangle) newState).getColorInside());
				original.setSelected(newState.isSelected());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		}  else if(original instanceof Square) {

			oldState = new Square();



		
			try {
				((Square) oldState).setUpLeft(((Square) original).getUpLeft());
				((Square) oldState).setEdgeLength(((Square) original).getEdgeLength());
				((Square) oldState).setColor(original.getColor());
				((Square) oldState).setColorInside(((Square) original).getColorInside());
				oldState.setSelected(original.isSelected());

				((Square) original).setUpLeft(((Square) newState).getUpLeft());
				((Square) original).setEdgeLength(((Square) newState).getEdgeLength());
				((Square) original).setColor(newState.getColor());
				((Square) original).setColorInside(((Square) newState).getColorInside());
				original.setSelected(newState.isSelected());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			



		}else if(original instanceof HexagonAdapter) {

			oldState=new HexagonAdapter();
			//System.out.println(oldState.toString());
			
			((HexagonAdapter) oldState).getHexagon().setX(((HexagonAdapter) original).getHexagon().getX());
			((HexagonAdapter) oldState).getHexagon().setY(((HexagonAdapter) original).getHexagon().getY());
			((HexagonAdapter) oldState).getHexagon().setR(((HexagonAdapter) original).getHexagon().getR());
			((HexagonAdapter) oldState).getHexagon().setBorderColor(((HexagonAdapter) original).getHexagon().getBorderColor());
			((HexagonAdapter) oldState).getHexagon().setAreaColor(((HexagonAdapter) original).getHexagon().getAreaColor());
			((HexagonAdapter) oldState).setSelected(original.isSelected());

			
			((HexagonAdapter) original).getHexagon().setX(((HexagonAdapter) newState).getHexagon().getX());
			((HexagonAdapter) original).getHexagon().setY(((HexagonAdapter) newState).getHexagon().getY());
			((HexagonAdapter) original).getHexagon().setR(((HexagonAdapter) newState).getHexagon().getR());
			((HexagonAdapter) original).getHexagon().setBorderColor(((HexagonAdapter) newState).getHexagon().getBorderColor());
			((HexagonAdapter) original).getHexagon().setAreaColor(((HexagonAdapter) newState).getHexagon().getAreaColor());
			((HexagonAdapter) original).setSelected(newState.isSelected());



		}
		
		
		
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}

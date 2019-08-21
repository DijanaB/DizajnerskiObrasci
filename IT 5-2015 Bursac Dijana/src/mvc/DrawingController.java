package mvc;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import command.CmdAddShape;
import command.CmdRemoveShape;
import command.CmdUpdateShape;
import geometrija.HexagonAdapter;
import geometrija.Circle;
import geometrija.Square;
import geometrija.Line;
import geometrija.Shape;
import geometrija.Rectangle;
import geometrija.Point;
import hexagon.Hexagon;

public class DrawingController {
	
	private boolean potvrda;
	private Shape selected;
	private int korak = 1;
	Point t1 = null;
	
	private DrawingModel model = new DrawingModel();
	private Frame frame = new Frame();
	private CmdAddShape cmdAddShape ;
	private CmdRemoveShape cmdRemoveShape;
	private  CmdUpdateShape cmdUpdateShape;
	
	
	public DrawingController (DrawingModel model, Frame frame) {
		
		this.model= model;
		this.frame = frame;
		
	}
	
	public void deleteShape() {
		
		Object[] opcije={"Yes","No"};
		int n = JOptionPane.showOptionDialog(null,"Are you sure you want to delete shape?","Warning", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);
		if(n==0){
			
			ArrayList<Shape> oblici = new ArrayList<Shape>();
			
			for(int i=0; i<model.getShapes().size(); i++) {
				
				if(model.getShapes().get(i).isSelected() == true) {
					
					oblici.add(model.getShapes().get(i));
				}
				
				
			}
			
			
			for(int i=0; i<oblici.size(); i++) {
				
				cmdRemoveShape = new CmdRemoveShape(oblici.get(i),model);
				
				model.getStackShapesUndo().add(oblici.get(i));
				cmdRemoveShape.execute();
			}
		
			
			
			/*for(int i=0;i<model.getStackShapes().size();i++){
				if(model.getStackShapes().elementAt(i).isSelektovan()){
					model.getStackShapes().removeElementAt(i);
					model.remove(selektovan);
				}
			}
			selektovan=null;*/
			frame.getBtnDelete().setEnabled(false);
			//btnObrisi.setEnabled(false);
			frame.getBtnModify().setEnabled(false);
			//btnModifikuj.setEnabled(false);
			frame.getPnlModify().setVisible(false);
			//frame.getPnlModifikacija().setVisible(false);
			//pnlModifikacija.setVisible(false);
			
		}
	}
	
	public void unSelectShape() {
		
		for(int i=0;i<model.getShapes().size();i++)
	    {
	    	//uklanja se selektovan objekat ako postoji takav
	    	if(model.getShapes().get(i).isSelected())
	    	{
	    		model.getShapes().get(i).setSelected(false);
	    	}
	    }
		
		
		
		/*for(int i=0;i<model.getStackShapes().size();i++)
	    {
	    	//uklanja se selektovan objekat ako postoji takav
	    	if(model.getStackShapes().elementAt(i).isSelektovan())
	    	{
	    		model.getStackShapes().elementAt(i).setSelektovan(false);
	    	}
	    }*/
	}

	public void mouseClickedPnl(int x, int y, Color outLine, Color fillColor) throws Exception {
		
		
		//unSelectShape();
		//System.out.println(model.getStackShapes().size()+"**************");
		
		if(frame.getSelectedButton() == frame.getBtnPoint()){
			
			
			Point t = new Point(x,y,outLine);
			cmdAddShape = new CmdAddShape(t, model);
			cmdAddShape.execute();
			//t.crtajSe(podlogaZaCrtanje.getGraphics());
			System.out.println(t.toString());
			model.getStackShapesUndo().add(t);
			//model.getStackShapes().push(t);
			
			//model.add(t);
			
		}else if (frame.getSelectedButton() == frame.getBtnLine()){
			if(korak == 1){
				t1 = new Point(x, y);
				korak++;
			}else{
				Point t2 = new Point(x, y);		
				Line l = new Line(t1,t2,frame.getBtnEdgeColor().getBackground());
				cmdAddShape = new CmdAddShape(l, model);
				cmdAddShape.execute();
				
				model.getStackShapesUndo().add(l);
				//l.crtajSe(podlogaZaCrtanje.getGraphics());
				System.out.println(l.toString());
				//model.getStackShapes().push(l);
				//model.add(l);
				korak = 1;
			}
		}else if (frame.getSelectedButton() == frame.getBtnSquare()){
			Point t = new Point(x, y);

			potvrda = true;
			while(potvrda){
				String inp = JOptionPane.showInputDialog(null,"Unesite duzinu stranice:","Kvadrat, unos duzine stranice:", JOptionPane.QUESTION_MESSAGE);

				try {
					if(inp == null)
						return;


					int duzina = Integer.parseInt(inp);

					if(duzina <= 0){
						System.out.println("Error! Number is too low");
					}else{
						Square k = new Square(t, duzina,outLine,fillColor);
						cmdAddShape = new CmdAddShape(k, model);
						cmdAddShape.execute();
						model.getStackShapesUndo().add(k);
						//k.crtajSe(podlogaZaCrtanje.getGraphics());
						System.out.println(k.toString());
						//model.getStackShapes().push(k);
						//model.add(k);
						potvrda = false;
					}


				} catch (NumberFormatException e) {
					System.out.println("Error! You entered string!");

				}
			}

		}else if (frame.getSelectedButton() == frame.getBtnHexagon()){
			potvrda = true;
			while(potvrda){
				String inp = JOptionPane.showInputDialog(null,"Unesite duzinu poluprecnika:","Heksagon, unos duzine poluprecnika:", JOptionPane.QUESTION_MESSAGE);

				try {
					if(inp == null)
						return;


					int R = Integer.parseInt(inp);

					if(R <= 0){
						System.out.println("Error! Number is too low");
					}else{						
						HexagonAdapter h = new HexagonAdapter(x, y, R, frame.getBtnEdgeColor().getBackground(), frame.getBtnInsideColor().getBackground());
						model.getStackShapesUndo().add(h);
						cmdAddShape = new CmdAddShape(h, model);
						cmdAddShape.execute();
						
						//Kvadrat k = new Kvadrat(t, duzina,outLine,fillColor);
						//k.crtajSe(podlogaZaCrtanje.getGraphics();
						System.out.println(h.toString());
						//model.getStackShapes().push(h);
						//model.add(h);
						potvrda = false;
					}


				} catch (NumberFormatException e) {
					System.out.println("Greska! Unet string!");

				}
			}

		}else if (frame.getSelectedButton() == frame.getBtnRectangle()){
			Point t = new Point(x, y);
			potvrda=true;
			while(potvrda){
				try{
					String inp1 = JOptionPane.showInputDialog(null,"Unesite duzinu stranice:","Pravougaonik, unos duzine stranice:", JOptionPane.QUESTION_MESSAGE);
					if(inp1==null)
						break;
					
					int duzina = Integer.parseInt(inp1);
					
					if(duzina>0){
						String inp2 = JOptionPane.showInputDialog(null,"Unesite visinu:","Pravougaonik, unos duzine stranice:", JOptionPane.QUESTION_MESSAGE);
						if(inp2 == null)
							break;
						int visina = Integer.parseInt(inp2);
						if(visina>0){
							Rectangle p = new Rectangle(t,duzina,visina,frame.getBtnEdgeColor().getBackground(),frame.getBtnInsideColor().getBackground());
							System.out.println(p.toString());
							cmdAddShape = new CmdAddShape(p, model);
							cmdAddShape.execute();
							model.getStackShapesUndo().add(p);
							//p.crtajSe(podlogaZaCrtanje.getGraphics());
							//model.getStackShapes().push(p);
							//model.add(p);
							potvrda=false;
						}
						else{
							System.out.println("Unesli ste negativan broj!");
						}

					}else{
						System.out.println("Uneli ste negativan broj!");
					}

				}
				catch(NumberFormatException e){
				
					System.out.println("Greska! Unet string!");
				}


			}





		}else if (frame.getSelectedButton() == frame.getBtnCircle()){
			Point t = new Point(x, y);
			potvrda=true;
			while(potvrda){
				try{
					String inp = JOptionPane.showInputDialog(null,"Unesite poluprecnik:","Krug, unos poluprecnika:", JOptionPane.QUESTION_MESSAGE);
					if(inp == null)
						break;
					int r =Integer.parseInt(inp);
					if(r>0){
						Circle kr=new Circle(t,r,frame.getBtnEdgeColor().getBackground(),frame.getBtnInsideColor().getBackground());
						//kr.crtajSe(podlogaZaCrtanje.getGraphics());
						cmdAddShape = new CmdAddShape(kr, model);
						cmdAddShape.execute();
						frame.getTextArea().append(kr.toString()+"\n");
						
						model.getStackShapesUndo().add(kr);
						System.out.println(kr.toString());
						//model.getStackShapes().push(kr);
						//model.add(kr);
						potvrda=false;
					}else{
						System.out.println("Uneli ste negativan broj!");
					}
				}
				catch(NumberFormatException e){
					System.out.println("Greska! Unet string!");
				}



			}


			/////SELEKCIJAAAA
		}else if(frame.getSelectedButton()==frame.getBtnSelect()){
			
			frame.omoguciDugmad(false);
			frame.getPnlModify().setVisible(true);
			frame.getPanelModifyK().setVisible(false);
			//setPnlModification();
			
			/*if(selektovan!= null){
				selektovan.setSelektovan(false);
				
				
				
			}

			selektovan = null;*/
			
			int m = 0;
			
			for(int i = 0; i < model.getShapes().size();i++)
			{
				if(model.getShapes().get(i).contains(x, y))
				{
					
					selected = model.getShapes().get(i);
					Shape s = (Shape) model.getShapes().get(i).clone();
					selected.setSelected(true);
					frame.omoguciDugmad(true);
					
					model.getStackShapesUndo().add(s);
					
					cmdUpdateShape = new CmdUpdateShape(s, model.getStackShapesUndo().get(i));
					
					cmdUpdateShape.execute();
					
					setPnlModification();
					m++;
				
					//OVO JE SELEKTOVANJE UKOLIKO SU DVA OBJEKTA JEDAN PREKO DRUGOG DA SELEKTUJE ONOG KOJI JE NA VRHU
					if(m>1) {
						
						for(int j = 0; j < model.getShapes().size();j++) {
							
							if(!model.getShapes().get(j).equals(model.getStackShapesUndo().peek())) {
								
								model.getShapes().get(j).setSelected(false);
								
							}
						}
						
					}
					
					
					
					
				
					//return;
					
				}
				
				
				
				
				
				
			}
			
			
			if(m==0) {
				
				unSelectShape();
				
			} 
			
			
			
			/*for(int i = model.getStackShapes().size()-1; i >= 0; i--){

				if(model.getStackShapes().elementAt(i).sadrzi(x, y)){
			
						
					selektovan = model.getStackShapes().elementAt(i);
					selektovan.setSelektovan(true);
					frame.omoguciDugmad(true);
					frame.setSelektovan(selektovan);
					
					
					frame.omoguciModifikaciju(true); //prikazuje se panel modifikacija
					
					//omoguciModifikaciju(true);
						
					
					//pnlModifikacija.setVisible(true);
					
					frame.getPnlModifikacijaK().setVisible(true);
					
					
				
					return;
				}
				
			}*/
			
			
		}/*else if(frame.getSelektovanoDugme() == frame.getBtnToFront()) {
			
			for(int i=0;i<model.getStackShapes().size();i++) {
				
				if(model.getStackShapes().elementAt(i).isSelektovan()==true) {
					
					Oblik pomocni;
					pomocni = model.getStackShapes().elementAt(i+1);
					model.getStackShapes().elementAt(i+1) = model.getStackShapes().elementAt(i).isSelektovan();
					
					
					
					
				}
				
			}
			
			
			}*/
		
	}
	
	public void shapeModification() {
		
		Shape s;
		frame.getPnlModifyK().setEnabled(true);
		
		if(selected instanceof Point){
			try {
				
				s = (Shape) selected.clone();
				
				
				((Point)selected).setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Point)selected).setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Point)selected).setColor(frame.getBtnColorEd().getBackground());
				((Point)selected).setSelected(false);
				
				cmdUpdateShape = new CmdUpdateShape(s, selected);
				cmdAddShape.execute();
				
			

			} catch (NumberFormatException e1) {
				
			} catch (Exception e1) {

			}


		}else if(selected instanceof Line){
			try {
				
				s = (Shape) selected.clone();
				
				((Line)selected).getpStart().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Line)selected).getpStart().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Line)selected).getpEnd().setX(Integer.parseInt(frame.getTxtX2().getText()));
				((Line)selected).getpEnd().setY(Integer.parseInt(frame.getTxtY2().getText()));
				((Line)selected).setColor(frame.getBtnColorEd().getBackground());
				((Line)selected).setSelected(false);
				
				cmdUpdateShape = new CmdUpdateShape(s, selected);
				cmdAddShape.execute();
				
				
			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}else if(selected instanceof Rectangle){
			try {
				((Rectangle)selected).getUpLeft().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Rectangle)selected).getUpLeft().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Rectangle)selected).setEdgeLength(Integer.parseInt(frame.getTxtLength().getText()));
				((Rectangle)selected).setEdgeLength(Integer.parseInt(frame.getTxtHeight().getText()));


				((Rectangle)selected).setColor(frame.getBtnColorEd().getBackground());
				((Rectangle)selected).setColorInside(frame.getBtnColorIn().getBackground());
				((Rectangle)selected).setSelected(false);
				
				

			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}else if(selected instanceof Square){
			try {
				((Square)selected).getUpLeft().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Square)selected).getUpLeft().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Square)selected).setEdgeLength(Integer.parseInt(frame.getTxtLength().getText()));


				((Square)selected).setColor(frame.getBtnColorEd().getBackground());
				((Square)selected).setColorInside(frame.getBtnColorIn().getBackground());
				((Square)selected).setSelected(false);
				
				
			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}else if(selected instanceof Circle){
			try {
				((Circle)selected).getCentar().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Circle)selected).getCentar().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Circle)selected).setR(Integer.parseInt(frame.getTxtR().getText()));


				((Circle)selected).setColor(frame.getBtnColorEd().getBackground());
				((Circle)selected).setColorInside(frame.getBtnColorIn().getBackground());
				((Circle)selected).setSelected(false);
				
				

			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}else if(selected instanceof HexagonAdapter){
			try {
				((HexagonAdapter)selected).getHexagon().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((HexagonAdapter)selected).getHexagon().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((HexagonAdapter)selected).getHexagon().setR(Integer.parseInt(frame.getTxtR().getText()));


				((HexagonAdapter)selected).getHexagon().setBorderColor(frame.getBtnColorEd().getBackground());
				((HexagonAdapter)selected).getHexagon().setAreaColor(frame.getBtnColorIn().getBackground());
				((HexagonAdapter)selected).setSelected(false);
				
				

			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}
	}
	public void setPnlModification() {
		
		frame.getPanelModifyK().setVisible(false);
		int a=0;
		for(int i = 0; i < model.getShapes().size();i++) {
			
	
			if(model.getShapes().get(i).isSelected())
			{
				a++;
				System.out.println("NASAO SAM SELEKTOVAN OBJEKAT");
			}
			
		}
		if(a==1) {
			
			frame.getPanelModifyK().setVisible(true);
			
		}else if(a>1) {
			
			frame.getPanelModifyK().setVisible(false);
		}
		
	}
}

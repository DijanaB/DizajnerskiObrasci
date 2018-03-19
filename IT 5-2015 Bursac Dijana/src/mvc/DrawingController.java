package mvc;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import command.CmdAddShape;
import command.CmdRemoveShape;
import command.CmdUpdateShape;
import geometrija.HexagonAdapter;
import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Oblik;
import geometrija.Pravougaonik;
import geometrija.Tacka;
import hexagon.Hexagon;
import wb.Crtanje;

public class DrawingController {
	
	private boolean potvrda;
	private Oblik selektovan;
	private int korak = 1;
	Tacka t1 = null;
	
	private DrawingModel model = new DrawingModel();
	private Crtanje frame = new Crtanje();
	private CmdAddShape cmdAddShape ;
	private CmdRemoveShape cmdRemoveShape;
	private  CmdUpdateShape cmdUpdateShape;
	
	
	public DrawingController (DrawingModel model, Crtanje frame) {
		
		this.model= model;
		this.frame = frame;
		
	}
	
	public void deleteShape() {
		
		Object[] opcije={"Da","Ne"};
		int n = JOptionPane.showOptionDialog(null,"Da li ste sigurni da zelite da obrisete objekat?","Upozorenje", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);
		if(n==0){
			
			ArrayList<Oblik> oblici = new ArrayList<Oblik>();
			
			for(int i=0; i<model.getShapes().size(); i++) {
				
				if(model.getShapes().get(i).isSelektovan() == true) {
					
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
			
			frame.getBtnObrisi().setEnabled(false);
			//btnObrisi.setEnabled(false);
			frame.getBtnModifikuj().setEnabled(false);
			//btnModifikuj.setEnabled(false);
			frame.getPnlModifikacijaK().setVisible(false);
			//frame.getPnlModifikacija().setVisible(false);
			//pnlModifikacija.setVisible(false);
			
		}
	}
	
	public void unSelectShape() {
		
		for(int i=0;i<model.getShapes().size();i++)
	    {
	    	//uklanja se selektovan objekat ako postoji takav
	    	if(model.getShapes().get(i).isSelektovan())
	    	{
	    		model.getShapes().get(i).setSelektovan(false);
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
		
		if(frame.getSelektovanoDugme() == frame.getBtnTacka()){
			
			
			Tacka t = new Tacka(x,y,outLine);
			cmdAddShape = new CmdAddShape(t, model);
			cmdAddShape.execute();
			//t.crtajSe(podlogaZaCrtanje.getGraphics());
			System.out.println(t.toString());
			model.getStackShapesUndo().add(t);
			//model.getStackShapes().push(t);
			
			//model.add(t);
			
		}else if (frame.getSelektovanoDugme() == frame.getBtnLinija()){
			if(korak == 1){
				t1 = new Tacka(x, y);
				korak++;
			}else{
				Tacka t2 = new Tacka(x, y);		
				Linija l = new Linija(t1,t2,frame.getBtnBojaIvice().getBackground());
				cmdAddShape = new CmdAddShape(l, model);
				cmdAddShape.execute();
				
				model.getStackShapesUndo().add(l);
				//l.crtajSe(podlogaZaCrtanje.getGraphics());
				System.out.println(l.toString());
				//model.getStackShapes().push(l);
				//model.add(l);
				korak = 1;
			}
		}else if (frame.getSelektovanoDugme() == frame.getBtnKvadrat()){
			Tacka t = new Tacka(x, y);

			potvrda = true;
			while(potvrda){
				String inp = JOptionPane.showInputDialog(null,"Unesite duzinu stranice:","Kvadrat, unos duzine stranice:", JOptionPane.QUESTION_MESSAGE);

				try {
					if(inp == null)
						return;


					int duzina = Integer.parseInt(inp);

					if(duzina <= 0){
						System.out.println("Greska broj mali!");
					}else{
						Kvadrat k = new Kvadrat(t, duzina,outLine,fillColor);
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
					System.out.println("Greska! Unet string!");

				}
			}

		}else if (frame.getSelektovanoDugme() == frame.getBtnHexagon()){
			potvrda = true;
			while(potvrda){
				String inp = JOptionPane.showInputDialog(null,"Unesite duzinu poluprecnika:","Heksagon, unos duzine poluprecnika:", JOptionPane.QUESTION_MESSAGE);

				try {
					if(inp == null)
						return;


					int R = Integer.parseInt(inp);

					if(R <= 0){
						System.out.println("Greska broj mali!");
					}else{						
						HexagonAdapter h = new HexagonAdapter(x, y, R, frame.getBtnBojaIvice().getBackground(), frame.getBtnBojaUnutrasnjosti().getBackground());
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

		}else if (frame.getSelektovanoDugme() == frame.getBtnPravougaonik()){
			Tacka t = new Tacka(x, y);
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
							Pravougaonik p = new Pravougaonik(t,duzina,visina,frame.getBtnBojaIvice().getBackground(),frame.getBtnBojaUnutrasnjosti().getBackground());
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





		}else if (frame.getSelektovanoDugme() == frame.getBtnKrug()){
			Tacka t = new Tacka(x, y);
			potvrda=true;
			while(potvrda){
				try{
					String inp = JOptionPane.showInputDialog(null,"Unesite poluprecnik:","Krug, unos poluprecnika:", JOptionPane.QUESTION_MESSAGE);
					if(inp == null)
						break;
					int r =Integer.parseInt(inp);
					if(r>0){
						Krug kr=new Krug(t,r,frame.getBtnBojaIvice().getBackground(),frame.getBtnBojaUnutrasnjosti().getBackground());
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



		}else if(frame.getSelektovanoDugme()==frame.getBtnSelektuj()){
			
			frame.omoguciDugmad(false);
			frame.getPnlModifikacija().setVisible(true);
			frame.getPnlModifikacijaK().setVisible(false);
			
			/*if(selektovan!= null){
				selektovan.setSelektovan(false);
				
				
				
			}

			selektovan = null;*/
			
			int m = 0;
			
			for(int i = 0; i < model.getShapes().size();i++)
			{
				if(model.getShapes().get(i).sadrzi(x, y))
				{
					
					selektovan = model.getShapes().get(i);
					Oblik s = (Oblik) model.getShapes().get(i).clone();
					selektovan.setSelektovan(true);
					
					model.getStackShapesUndo().add(s);
					cmdUpdateShape = new CmdUpdateShape(s, model.getStackShapesUndo().get(i));
					cmdUpdateShape.execute();
					frame.omoguciDugmad(true);
					frame.setSelektovan(selektovan);
					
					
					frame.omoguciModifikaciju(true); //prikazuje se panel modifikacija
					
					//omoguciModifikaciju(true);
						
					
					//pnlModifikacija.setVisible(true);
					
					frame.getPnlModifikacijaK().setVisible(true);
					m++;
					
					if(m>1) {
						
						for(int j = 0; j < model.getShapes().size();j++) {
							
							if(!model.getShapes().get(j).equals(model.getStackShapesUndo().peek())) {
								
								model.getShapes().get(j).setSelektovan(false);
								
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
		
		Oblik s;
		
		if(selektovan instanceof Tacka){
			try {
				
				s = (Oblik) selektovan.clone();
				
				
				((Tacka)selektovan).setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Tacka)selektovan).setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Tacka)selektovan).setBoja(frame.getBtnBojaI().getBackground());
				((Tacka)selektovan).setSelektovan(false);
				
				cmdUpdateShape = new CmdUpdateShape(s, selektovan);
				cmdAddShape.execute();
				
			

			} catch (NumberFormatException e1) {
				
			} catch (Exception e1) {

			}


		}else if(selektovan instanceof Linija){
			try {
				
				s = (Oblik) selektovan.clone();
				
				((Linija)selektovan).gettPocetna().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Linija)selektovan).gettPocetna().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Linija)selektovan).gettKrajnja().setX(Integer.parseInt(frame.getTxtX2().getText()));
				((Linija)selektovan).gettKrajnja().setY(Integer.parseInt(frame.getTxtY2().getText()));
				((Linija)selektovan).setBoja(frame.getBtnBojaI().getBackground());
				((Linija)selektovan).setSelektovan(false);
				
				cmdUpdateShape = new CmdUpdateShape(s, selektovan);
				cmdAddShape.execute();
				
				
			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}else if(selektovan instanceof Pravougaonik){
			try {
				((Pravougaonik)selektovan).getGoreLevo().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Pravougaonik)selektovan).getGoreLevo().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Pravougaonik)selektovan).setDuzinaStranice(Integer.parseInt(frame.getTxtDuzina().getText()));
				((Pravougaonik)selektovan).setDuzinaStranice(Integer.parseInt(frame.getTxtVisina().getText()));


				((Pravougaonik)selektovan).setBoja(frame.getBtnBojaI().getBackground());
				((Pravougaonik)selektovan).setBojaUnutrasnjosti(frame.getBtnBojaU().getBackground());
				((Pravougaonik)selektovan).setSelektovan(false);
				
				

			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}else if(selektovan instanceof Kvadrat){
			try {
				((Kvadrat)selektovan).getGoreLevo().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Kvadrat)selektovan).getGoreLevo().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Kvadrat)selektovan).setDuzinaStranice(Integer.parseInt(frame.getTxtDuzina().getText()));


				((Kvadrat)selektovan).setBoja(frame.getBtnBojaI().getBackground());
				((Kvadrat)selektovan).setBojaUnutrasnjosti(frame.getBtnBojaU().getBackground());
				((Kvadrat)selektovan).setSelektovan(false);
				
				
			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}else if(selektovan instanceof Krug){
			try {
				((Krug)selektovan).getCentar().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((Krug)selektovan).getCentar().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((Krug)selektovan).setR(Integer.parseInt(frame.getTxtR().getText()));


				((Krug)selektovan).setBoja(frame.getBtnBojaI().getBackground());
				((Krug)selektovan).setBojaUnutrasnjosti(frame.getBtnBojaU().getBackground());
				((Krug)selektovan).setSelektovan(false);
				
				

			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}else if(selektovan instanceof HexagonAdapter){
			try {
				((HexagonAdapter)selektovan).getHexagon().setX(Integer.parseInt(frame.getTxtX1().getText()));
				((HexagonAdapter)selektovan).getHexagon().setY(Integer.parseInt(frame.getTxtY1().getText()));
				((HexagonAdapter)selektovan).getHexagon().setR(Integer.parseInt(frame.getTxtR().getText()));


				((HexagonAdapter)selektovan).getHexagon().setBorderColor(frame.getBtnBojaI().getBackground());
				((HexagonAdapter)selektovan).getHexagon().setAreaColor(frame.getBtnBojaU().getBackground());
				((HexagonAdapter)selektovan).setSelektovan(false);
				
				

			} catch (NumberFormatException e1) {

			} catch (Exception e1) {

			}
		}
	}
}

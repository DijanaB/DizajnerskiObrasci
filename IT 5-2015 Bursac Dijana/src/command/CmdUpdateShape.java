package command;

import geometrija.HexagonAdapter;
import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Oblik;
import geometrija.Pravougaonik;
import geometrija.Tacka;
import mvc.DrawingModel;

public class CmdUpdateShape implements Command {
	
	private Oblik original;
	private Oblik newState;
	private Oblik oldState;
	private DrawingModel model = new DrawingModel();

	public CmdUpdateShape(Oblik original,Oblik newState) {


		this.original = original;
		this.newState = newState;

	}

	@Override
	public void execute() {
		
		if(original instanceof Tacka){
			try {
				
				oldState = new Tacka();
				
				((Tacka) oldState).setX(((Tacka) original).getX());
				((Tacka) oldState).setY(((Tacka) original).getY());
				oldState.setBoja(original.getBoja());
				oldState.setSelektovan(original.isSelektovan());


				((Tacka) original).setX(((Tacka) newState).getX());
				((Tacka) original).setY(((Tacka) newState).getY());
				original.setBoja(newState.getBoja());
				original.setSelektovan(newState.isSelektovan());
				
			

			} catch (NumberFormatException e1) {
				
			} catch (Exception e1) {

			}


		} else if(original instanceof Linija) {

			oldState = new Linija();

			((Linija) oldState).settPocetna(((Linija) original).gettPocetna());
			((Linija) oldState).settKrajnja(((Linija) original).gettKrajnja());
			oldState.setBoja(original.getBoja());
			oldState.setSelektovan(original.isSelektovan());


			((Linija) original).settPocetna(((Linija) newState).gettPocetna());
			((Linija) original).settKrajnja(((Linija) newState).gettKrajnja());

			original.setBoja(newState.getBoja());
			original.setSelektovan(newState.isSelektovan());


		}else if(original instanceof Krug) {

			oldState=new Krug();

			
			try {
				((Krug) oldState).setCentar(((Krug) original).getCentar());
				((Krug) oldState).setR(((Krug) original).getR());
				oldState.setBoja(original.getBoja());
				((Krug) oldState).setBojaUnutrasnjosti(((Krug) original).getBojaUnutrasnjosti());
				oldState.setSelektovan(original.isSelektovan());

				((Krug) original).setCentar(((Krug) newState).getCentar());
				((Krug) original).setR(((Krug) newState).getR());
				original.setBoja(newState.getBoja());
				((Krug) original).setBojaUnutrasnjosti(((Krug) newState).getBojaUnutrasnjosti());
				original.setSelektovan(newState.isSelektovan());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		} else if(original instanceof Pravougaonik) {

			oldState = new Pravougaonik();

			try {

				((Pravougaonik) oldState).setGoreLevo(((Pravougaonik) original).getGoreLevo());
				((Pravougaonik) oldState).setSirina(((Pravougaonik) original).getSirina());
				((Pravougaonik) oldState).setDuzinaStranice(((Pravougaonik) original).getDuzinaStranice());
				((Pravougaonik) oldState).setBoja(original.getBoja());
				((Pravougaonik) oldState).setBojaUnutrasnjosti(((Pravougaonik) original).getBojaUnutrasnjosti());
				oldState.setSelektovan(original.isSelektovan());

				((Pravougaonik) original).setGoreLevo(((Pravougaonik) newState).getGoreLevo());
				((Pravougaonik) original).setSirina(((Pravougaonik) newState).getSirina());
				((Pravougaonik) original).setDuzinaStranice(((Pravougaonik) newState).getDuzinaStranice());
				((Pravougaonik) original).setBoja(newState.getBoja());
				((Pravougaonik) original).setBojaUnutrasnjosti(((Pravougaonik) newState).getBojaUnutrasnjosti());
				original.setSelektovan(newState.isSelektovan());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		}  else if(original instanceof Kvadrat) {

			oldState = new Kvadrat();



		
			try {
				((Kvadrat) oldState).setGoreLevo(((Kvadrat) original).getGoreLevo());
				((Kvadrat) oldState).setDuzinaStranice(((Kvadrat) original).getDuzinaStranice());
				((Kvadrat) oldState).setBoja(original.getBoja());
				((Kvadrat) oldState).setBojaUnutrasnjosti(((Kvadrat) original).getBojaUnutrasnjosti());
				oldState.setSelektovan(original.isSelektovan());

				((Kvadrat) original).setGoreLevo(((Kvadrat) newState).getGoreLevo());
				((Kvadrat) original).setDuzinaStranice(((Kvadrat) newState).getDuzinaStranice());
				((Kvadrat) original).setBoja(newState.getBoja());
				((Kvadrat) original).setBojaUnutrasnjosti(((Kvadrat) newState).getBojaUnutrasnjosti());
				original.setSelektovan(newState.isSelektovan());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			



		}else if(original instanceof HexagonAdapter) {

			oldState=new HexagonAdapter();
			System.out.println(oldState);
			
			((HexagonAdapter) oldState).getHexagon().setX(((HexagonAdapter) original).getHexagon().getX());
			((HexagonAdapter) oldState).getHexagon().setY(((HexagonAdapter) original).getHexagon().getY());
			((HexagonAdapter) oldState).getHexagon().setR(((HexagonAdapter) original).getHexagon().getR());
			((HexagonAdapter) oldState).getHexagon().setBorderColor(((HexagonAdapter) original).getHexagon().getBorderColor());
			((HexagonAdapter) oldState).getHexagon().setAreaColor(((HexagonAdapter) original).getHexagon().getAreaColor());
			((HexagonAdapter) oldState).setSelektovan(original.isSelektovan());

			
			((HexagonAdapter) original).getHexagon().setX(((HexagonAdapter) newState).getHexagon().getX());
			((HexagonAdapter) original).getHexagon().setY(((HexagonAdapter) newState).getHexagon().getY());
			((HexagonAdapter) original).getHexagon().setR(((HexagonAdapter) newState).getHexagon().getR());
			((HexagonAdapter) original).getHexagon().setBorderColor(((HexagonAdapter) newState).getHexagon().getBorderColor());
			((HexagonAdapter) original).getHexagon().setAreaColor(((HexagonAdapter) newState).getHexagon().getAreaColor());
			((HexagonAdapter) original).setSelektovan(newState.isSelektovan());



		}
		
		
		
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}

package wb;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import geometrija.Oblik;
public class PodlogaZaCrtanje extends JPanel {
private List<Oblik> listaOblika;
	
	public PodlogaZaCrtanje()
	{
		listaOblika=new ArrayList<Oblik>();
	}
	
	public void add(Oblik o){
		
		listaOblika.add(o);
		
	}
	
	public void remove(Oblik o)
	{
		listaOblika.remove(o);
		
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (Oblik o : listaOblika)
		{
			o.crtajSe(g);
		}
		
		repaint();
	}
}

package wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.HexagonAdapter;
import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Oblik;
import geometrija.Pravougaonik;
import geometrija.Tacka;
import mvc.DrawingController;
import mvc.DrawingModel;
import mvc.DrawingView;

import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import observer.Button;
import observer.Observer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.NoninvertibleTransformException;
import java.util.Stack;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import java.awt.Panel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Crtanje extends JFrame {



	
	private JPanel pnlGlavni;
	private DrawingView podlogaZaCrtanje;
	private DrawingModel model;
	Stack<Oblik> stekOblika = new Stack<Oblik>();
	JButton selektovanoDugme = null;
	//private int korak = 1;
	//Tacka t1 = null;
	JButton btnBojaUnutrasnjosti;
	JButton btnBojaIvice;
	Oblik selektovan; //imam ga u drawing controlleru treba izbrisati njegovo pojavljivanje odje
	JButton btnModifikuj;
	JButton btnObrisi;
	boolean potvrda;
	private JPanel pnlModifikacija;
	private JTextField txtX1;
	private JTextField txtDuzina;
	private JTextField txtY1;
	private JTextField txtVisina;
	private JTextField txtR;
	JButton btnBojaU;
	JLabel lblBojaU;
	JButton btnBojaI;
	JLabel lblBojaI;
	JLabel lblX1;
	JLabel lblY1;
	JLabel lblDuzina;
	JLabel lblVisina;
	JLabel lblR;
	JPanel pnlModifikacijaK;
	private JLabel lblX2;
	private JLabel lblY2;
	private JTextField txtX2;
	private JTextField txtY2;
	private JLabel lblNaziva1;
	private JLabel lblNaziva2;
	private JButton btnBoja;
	JButton btnTacka;
	JButton btnKrug;
	JButton btnLinija;
	JButton btnKvadrat;
	JButton btnPravougaonik;
	JButton btnSelektuj;
	private DrawingController controller;
	private JPanel pnlFrontAndBack;
	private JButton btnToFront;
	private JButton btnToBack;
	private JButton btnBringToFront;
	private JButton btnBringToBack;
	private JButton btnHexagon;
	private JPanel pnlIspis;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private Button btn = new Button();
	/**
	 * Launch the application.
	 */
	public JPanel getPnlModifikacija() {
		return pnlModifikacija;
	}



	public void setPnlModifikacija(JPanel pnlModifikacija) {
		this.pnlModifikacija = pnlModifikacija;
	}



	public JButton getBtnSelektuj() {
		return btnSelektuj;
	}



	public void setBtnSelektuj(JButton btnSelektuj) {
		this.btnSelektuj = btnSelektuj;
	}

	public void setController (DrawingController controller) {
	 this.controller = controller;	
	}
	
	
	
	public JButton getSelektovanoDugme() {
		return selektovanoDugme;
	}



	public JButton getBtnBojaU() {
		return btnBojaU;
	}



	public void setBtnBojaU(JButton btnBojaU) {
		this.btnBojaU = btnBojaU;
	}



	public JButton getBtnBojaI() {
		return btnBojaI;
	}



	public void setBtnBojaI(JButton btnBojaI) {
		this.btnBojaI = btnBojaI;
	}



	public void setSelektovanoDugme(JButton selektovanoDugme) {
		this.selektovanoDugme = selektovanoDugme;
	}



	public JButton getBtnTacka() {
		return btnTacka;
	}



	public JButton getBtnHexagon() {
		return btnHexagon;
	}



	public void setBtnHexagon(JButton btnHexagon) {
		this.btnHexagon = btnHexagon;
	}



	public void setBtnTacka(JButton btnTacka) {
		this.btnTacka = btnTacka;
	}



	public JTextField getTxtX1() {
		return txtX1;
	}



	public void setTxtX1(JTextField txtX1) {
		this.txtX1 = txtX1;
	}



	public JTextField getTxtDuzina() {
		return txtDuzina;
	}



	public void setTxtDuzina(JTextField txtDuzina) {
		this.txtDuzina = txtDuzina;
	}



	public JTextField getTxtY1() {
		return txtY1;
	}



	public void setTxtY1(JTextField txtY1) {
		this.txtY1 = txtY1;
	}



	public JTextField getTxtVisina() {
		return txtVisina;
	}



	public void setTxtVisina(JTextField txtVisina) {
		this.txtVisina = txtVisina;
	}



	public JTextField getTxtR() {
		return txtR;
	}



	public void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}



	public JTextField getTxtX2() {
		return txtX2;
	}



	public void setTxtX2(JTextField txtX2) {
		this.txtX2 = txtX2;
	}



	public JTextField getTxtY2() {
		return txtY2;
	}



	public void setTxtY2(JTextField txtY2) {
		this.txtY2 = txtY2;
	}



	public JButton getBtnKrug() {
		return btnKrug;
	}



	public void setBtnKrug(JButton btnKrug) {
		this.btnKrug = btnKrug;
	}



	public JButton getBtnLinija() {
		return btnLinija;
	}



	public void setBtnLinija(JButton btnLinija) {
		this.btnLinija = btnLinija;
	}



	public JButton getBtnModifikuj() {
		return btnModifikuj;
	}



	public void setBtnModifikuj(JButton btnModifikuj) {
		this.btnModifikuj = btnModifikuj;
	}



	public JButton getBtnObrisi() {
		return btnObrisi;
	}



	public void setBtnObrisi(JButton btnObrisi) {
		this.btnObrisi = btnObrisi;
	}



	public JButton getBtnKvadrat() {
		return btnKvadrat;
	}



	public void setBtnKvadrat(JButton btnKvadrat) {
		this.btnKvadrat = btnKvadrat;
	}



	public JButton getBtnPravougaonik() {
		return btnPravougaonik;
	}



	public void setBtnPravougaonik(JButton btnPravougaonik) {
		this.btnPravougaonik = btnPravougaonik;
	}



	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crtanje frame = new Crtanje();
					frame.setVisible(true);
					frame.setTitle("Paint, IT5-2015 Bursac Dijana");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}



	public void setBtnBojaUnutrasnjosti(JButton btnBojaUnutrasnjosti) {
		this.btnBojaUnutrasnjosti = btnBojaUnutrasnjosti;
	}



	public JButton getBtnBojaIvice() {
		return btnBojaIvice;
	}



	public void setBtnBojaIvice(JButton btnBojaIvice) {
		this.btnBojaIvice = btnBojaIvice;
	}



	public JButton getBtnToFront() {
		return btnToFront;
	}



	public void setBtnToFront(JButton btnToFront) {
		this.btnToFront = btnToFront;
	}



	public JButton getBtnToBack() {
		return btnToBack;
	}



	public void setBtnToBack(JButton btnToBack) {
		this.btnToBack = btnToBack;
	}



	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}



	public void setBtnBringToFront(JButton btnBringToFront) {
		this.btnBringToFront = btnBringToFront;
	}



	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}



	public void setBtnBringToBack(JButton btnBringToBack) {
		this.btnBringToBack = btnBringToBack;
	}



	/**
	 * Create the frame.
	 */
	public Crtanje() {
		podlogaZaCrtanje= new DrawingView();
		model = new DrawingModel();
		podlogaZaCrtanje.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent m) {
				//System.out.println("x " + m.getX() + "y " + m.getY() );
				pnlModifikacija.setVisible(true);
				pnlModifikacijaK.setVisible(false);
				btnObrisi.setEnabled(false);
				btnModifikuj.setEnabled(false);
				
				try {
					controller.mouseClickedPnl(m.getX(),m.getY(),btnBojaIvice.getBackground(),btnBojaUnutrasnjosti.getBackground());
				} catch (CloneNotSupportedException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
			    for(int i=0;i<stekOblika.size();i++)
			    {
			    	//uklanja se selektovan objekat ako postoji takav
			    	if(stekOblika.elementAt(i).isSelektovan())
			    	{
			    		stekOblika.elementAt(i).setSelektovan(false);
			    	}
			    }
				
				if(selektovanoDugme == btnTacka){
					
					Tacka t = new Tacka(m.getX(), m.getY(),btnBojaIvice.getBackground());
					t.crtajSe(podlogaZaCrtanje.getGraphics());
					stekOblika.push(t);
					model.add(t);
					
				}else if (selektovanoDugme == btnLinija){
					if(korak == 1){
						t1 = new Tacka(m.getX(), m.getY());
						korak++;
					}else{
						Tacka t2 = new Tacka(m.getX(), m.getY());
						Linija l = new Linija(t1,t2,btnBojaIvice.getBackground());
						l.crtajSe(podlogaZaCrtanje.getGraphics());
						stekOblika.push(l);
						model.add(l);
						korak = 1;
					}
				}else if (selektovanoDugme == btnKvadrat){
					Tacka t = new Tacka(m.getX(), m.getY());

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
								Kvadrat k = new Kvadrat(t, duzina,btnBojaIvice.getBackground(),btnBojaUnutrasnjosti.getBackground());
								k.crtajSe(podlogaZaCrtanje.getGraphics());
								stekOblika.push(k);
								model.add(k);
								potvrda = false;
							}


						} catch (NumberFormatException e) {
							System.out.println("Greska! Unet string!");

						}
					}

				}else if (selektovanoDugme == btnPravougaonik){
					Tacka t = new Tacka(m.getX(), m.getY());
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
									Pravougaonik p = new Pravougaonik(t,duzina,visina,btnBojaIvice.getBackground(),btnBojaUnutrasnjosti.getBackground());
									p.crtajSe(podlogaZaCrtanje.getGraphics());
									stekOblika.push(p);
									model.add(p);
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





				}else if (selektovanoDugme == btnKrug){
					Tacka t = new Tacka(m.getX(), m.getY());
					potvrda=true;
					while(potvrda){
						try{
							String inp = JOptionPane.showInputDialog(null,"Unesite poluprecnik:","Krug, unos poluprecnika:", JOptionPane.QUESTION_MESSAGE);
							if(inp == null)
								break;
							int r =Integer.parseInt(inp);
							if(r>0){
								Krug kr=new Krug(t,r,btnBojaIvice.getBackground(),btnBojaUnutrasnjosti.getBackground());
								kr.crtajSe(podlogaZaCrtanje.getGraphics());
								stekOblika.push(kr);
								model.add(kr);
								potvrda=false;
							}else{
								System.out.println("Uneli ste negativan broj!");
							}
						}
						catch(NumberFormatException e){
							System.out.println("Greska! Unet string!");
						}



					}



				}else if(selektovanoDugme==btnSelektuj){
					
					omoguciDugmad(false);
					pnlModifikacija.setVisible(false);
					if(selektovan!= null){
						selektovan.setSelektovan(false);
						
						
						
					}

					selektovan = null;
					
					
					for(int i = stekOblika.size()-1; i >= 0; i--){

						if(stekOblika.elementAt(i).sadrzi(m.getX(), m.getY())){
					
								
							selektovan = stekOblika.elementAt(i);
							selektovan.setSelektovan(true);
							omoguciDugmad(true);
							omoguciModifikaciju(true);
								
							
							pnlModifikacija.setVisible(true);
						
						
							return;
						}
						
					}
					
					
				}*/ catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		podlogaZaCrtanje.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 652);
		pnlGlavni = new JPanel();
		pnlGlavni.setBackground(Color.WHITE);
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlGlavni);
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		pnlGlavni.add(podlogaZaCrtanje, BorderLayout.CENTER);

		JPanel pnlKomponente = new JPanel();
		pnlKomponente.setBackground(Color.PINK);
		pnlGlavni.add(pnlKomponente, BorderLayout.NORTH);
		pnlKomponente.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlOblici = new JPanel();
		pnlOblici.setBackground(Color.WHITE);
		pnlKomponente.add(pnlOblici);
		pnlOblici.setLayout(new MigLayout("", "[100px][100px][5px]", "[14px][23px][23px][23px]"));

		JLabel lblOblici = new JLabel("Oblici:");
		pnlOblici.add(lblOblici, "cell 0 0,alignx center,aligny top");

		btnTacka = new JButton("Tacka");

		btnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obojajDugme(btnTacka);
			}
		});
		pnlOblici.add(btnTacka, "cell 0 1,grow");

		btnKvadrat = new JButton("Kvadrat");
		btnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obojajDugme(btnKvadrat);
			}
		});

		btnLinija = new JButton("Linija");
		btnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obojajDugme(btnLinija);
			}
		});
		
				btnPravougaonik = new JButton("Pravougaonik");
				btnPravougaonik.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						obojajDugme(btnPravougaonik);
					}
				});
				pnlOblici.add(btnPravougaonik, "cell 1 1,grow");
		pnlOblici.add(btnLinija, "cell 0 2,grow");
		
				btnKrug = new JButton("Krug");
				btnKrug.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						obojajDugme(btnKrug);
					}
				});
				pnlOblici.add(btnKrug, "cell 1 2,growx,aligny top");
		pnlOblici.add(btnKvadrat, "cell 0 3,grow");
		
		btnHexagon = new JButton("Hexagon");
		btnHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obojajDugme(btnHexagon);
			}
		});
		pnlOblici.add(btnHexagon, "cell 1 3,growx");
		
		pnlFrontAndBack = new JPanel();
		pnlFrontAndBack.setBackground(Color.WHITE);
		pnlKomponente.add(pnlFrontAndBack);
		pnlFrontAndBack.setLayout(new MigLayout("", "[]", "[][][]"));
		
		btnToFront = new JButton("To Front");
		btnToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obojajDugme(btnToFront);
			}
		});
		pnlFrontAndBack.add(btnToFront, "flowy,cell 0 0,grow");
		
		btnToBack = new JButton("To Back");
		btnToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obojajDugme(btnToBack);
			}
		});
		pnlFrontAndBack.add(btnToBack, "cell 0 0,growx");
		
		btnBringToFront = new JButton("Bring To Front");
		btnBringToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				obojajDugme(btnBringToFront);
			}
		});
		pnlFrontAndBack.add(btnBringToFront, "cell 0 1,growx");
		
		btnBringToBack = new JButton("Bring To Back");
		btnBringToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				obojajDugme(btnBringToBack);
			}
		});
		pnlFrontAndBack.add(btnBringToBack, "cell 0 2,growx,aligny bottom");

		JPanel pnlBoje = new JPanel();
		pnlBoje.setBackground(Color.WHITE);
		pnlKomponente.add(pnlBoje);
		pnlBoje.setLayout(new MigLayout("", "[95.00][95.00]", "[45.00][]"));

		btnBojaIvice = new JButton("");
		btnBojaIvice.setBackground(Color.BLACK);
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color c = jcc.showDialog(null, "Izaberite boju", Color.BLACK);
				btnBojaIvice.setBackground(c);
			}
		});
		pnlBoje.add(btnBojaIvice, "cell 0 0,grow");

		btnBojaUnutrasnjosti = new JButton("");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color c = jcc.showDialog(null, "Izaberite boju", Color.BLACK);
				btnBojaUnutrasnjosti.setBackground(c);
			}
		});
		btnBojaUnutrasnjosti.setBackground(Color.WHITE);
		pnlBoje.add(btnBojaUnutrasnjosti, "cell 1 0,grow");

		JLabel lblBojaIvice = new JLabel("Boja ivice");
		pnlBoje.add(lblBojaIvice, "cell 0 1,alignx center");

		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti");
		pnlBoje.add(lblBojaUnutrasnjosti, "cell 1 1,alignx center");

		JPanel pnlNaredbe = new JPanel();
		pnlNaredbe.setBackground(Color.WHITE);
		pnlKomponente.add(pnlNaredbe);
		pnlNaredbe.setLayout(new MigLayout("", "[]", "[][][]"));

		btnSelektuj = new JButton("Selektuj");
		btnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obojajDugme(btnSelektuj);


			}
		});
		pnlNaredbe.add(btnSelektuj, "cell 0 0,growx");

		btnModifikuj = new JButton("Modifikuj");
		
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//obojajDugme(btnModifikuj);
				
				btnObrisi.setEnabled(false);
				
				controller.shapeModification();
				
				pnlModifikacija.setVisible(true);
				pnlModifikacijaK.setVisible(false);
				
				
				/*
				if(selektovan instanceof Tacka){
					try {
						
						((Tacka)selektovan).setX(Integer.parseInt(txtX1.getText()));
						((Tacka)selektovan).setY(Integer.parseInt(txtY1.getText()));
						((Tacka)selektovan).setBoja(btnBojaI.getBackground());
						((Tacka)selektovan).setSelektovan(false);
						
					

					} catch (NumberFormatException e1) {
						
					} catch (Exception e1) {

					}


				}else if(selektovan instanceof Linija){
					try {
						((Linija)selektovan).gettPocetna().setX(Integer.parseInt(txtX1.getText()));
						((Linija)selektovan).gettPocetna().setY(Integer.parseInt(txtY1.getText()));
						((Linija)selektovan).gettKrajnja().setX(Integer.parseInt(txtX2.getText()));
						((Linija)selektovan).gettKrajnja().setY(Integer.parseInt(txtY2.getText()));
						((Linija)selektovan).setBoja(btnBojaI.getBackground());
						((Linija)selektovan).setSelektovan(false);
						
						
					} catch (NumberFormatException e1) {

					} catch (Exception e1) {

					}
				}else if(selektovan instanceof Pravougaonik){
					try {
						((Pravougaonik)selektovan).getGoreLevo().setX(Integer.parseInt(txtX1.getText()));
						((Pravougaonik)selektovan).getGoreLevo().setY(Integer.parseInt(txtY1.getText()));
						((Pravougaonik)selektovan).setDuzinaStranice(Integer.parseInt(txtDuzina.getText()));
						((Pravougaonik)selektovan).setDuzinaStranice(Integer.parseInt(txtVisina.getText()));


						((Pravougaonik)selektovan).setBoja(btnBojaI.getBackground());
						((Pravougaonik)selektovan).setBojaUnutrasnjosti(btnBojaU.getBackground());
						((Pravougaonik)selektovan).setSelektovan(false);
						
						

					} catch (NumberFormatException e1) {

					} catch (Exception e1) {

					}
				}else if(selektovan instanceof Kvadrat){
					try {
						((Kvadrat)selektovan).getGoreLevo().setX(Integer.parseInt(txtX1.getText()));
						((Kvadrat)selektovan).getGoreLevo().setY(Integer.parseInt(txtY1.getText()));
						((Kvadrat)selektovan).setDuzinaStranice(Integer.parseInt(txtDuzina.getText()));


						((Kvadrat)selektovan).setBoja(btnBojaI.getBackground());
						((Kvadrat)selektovan).setBojaUnutrasnjosti(btnBojaU.getBackground());
						((Kvadrat)selektovan).setSelektovan(false);
						
						
					} catch (NumberFormatException e1) {

					} catch (Exception e1) {

					}
				}else if(selektovan instanceof Krug){
					try {
						((Krug)selektovan).getCentar().setX(Integer.parseInt(txtX1.getText()));
						((Krug)selektovan).getCentar().setY(Integer.parseInt(txtY1.getText()));
						((Krug)selektovan).setR(Integer.parseInt(txtR.getText()));


						((Krug)selektovan).setBoja(btnBojaI.getBackground());
						((Krug)selektovan).setBojaUnutrasnjosti(btnBojaU.getBackground());
						((Krug)selektovan).setSelektovan(false);
						
						

					} catch (NumberFormatException e1) {

					} catch (Exception e1) {

					}
				}*/
			
			
			}
		});
		btnModifikuj.setEnabled(false);
		pnlNaredbe.add(btnModifikuj, "cell 0 1");

		btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.deleteShape();
/*
				Object[] opcije={"Da","Ne"};
				int n = JOptionPane.showOptionDialog(null,"Da li ste sigurni da zelite da obrisete objekat?","Upozorenje", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);
				if(n==0){
					for(int i=0;i<stekOblika.size();i++){
						if(stekOblika.elementAt(i).isSelektovan()){
							stekOblika.removeElementAt(i);
							model.remove(selektovan);
						}
					}
					selektovan=null;
					
				
					btnObrisi.setEnabled(false);
					btnModifikuj.setEnabled(false);
					pnlModifikacija.setVisible(false);

				}
				*/
				
			}
		});
		btnObrisi.setEnabled(false);
		pnlNaredbe.add(btnObrisi, "cell 0 2,growx");
		
		btnBoja = new JButton("");
		btnBoja.setVisible(false);
		pnlKomponente.add(btnBoja);

		pnlModifikacija = new JPanel();
		pnlModifikacija.setBackground(Color.PINK);
		pnlGlavni.add(pnlModifikacija, BorderLayout.SOUTH);
		pnlModifikacija.setVisible(true);

		pnlModifikacijaK = new JPanel();
		pnlModifikacijaK.setVisible(false);
		pnlModifikacijaK.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
			}
		});
		pnlModifikacijaK.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				
			}
		});
		pnlModifikacija.setLayout(new BorderLayout(0, 0));
		pnlModifikacijaK.setBackground(Color.PINK);
		pnlModifikacija.add(pnlModifikacijaK, BorderLayout.NORTH);
		pnlModifikacijaK.setLayout(new MigLayout("", "[][51.00,grow][][51.00,grow][20.00][51.00,grow][][51.00,grow][][51.00,grow]", "[][32.00][36.00]"));

		lblNaziva1 = new JLabel("");
		lblNaziva1.setEnabled(false);
		lblNaziva1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblNaziva1, "cell 1 0");

		lblNaziva2 = new JLabel("");
		lblNaziva2.setEnabled(false);
		lblNaziva2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblNaziva2, "cell 3 0");

		lblX1 = new JLabel("X:");
		lblX1.setEnabled(false);
		lblX1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblX1, "cell 0 1,alignx trailing");

		txtX1 = new JTextField();
		

		txtX1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtX1.setEnabled(false);
		txtX1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(txtX1, "cell 1 1,growx,aligny center");
		txtX1.setColumns(10);

		lblX2 = new JLabel("X:");
		lblX2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblX2.setEnabled(false);
		pnlModifikacijaK.add(lblX2, "cell 2 1,alignx trailing");

		txtX2 = new JTextField();
		txtX2.setText("");
		txtX2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtX2.setEnabled(false);
		txtX2.setColumns(10);
		pnlModifikacijaK.add(txtX2, "cell 3 1,growx");

		lblBojaI = new JLabel("Boja Ivice:");
		lblBojaI.setEnabled(false);
		lblBojaI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblBojaI, "cell 4 1,alignx right");

		btnBojaI = new JButton("");
		btnBojaI.setEnabled(false);
		btnBojaI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc2 = new JColorChooser();
				Color c = jcc2.showDialog(null, "Izaberite boju", Color.BLACK);
				btnBojaI.setBackground(c);
			}
		});
		pnlModifikacijaK.add(btnBojaI, "cell 5 1,grow");

		lblDuzina = new JLabel("Duzina:");
		lblDuzina.setEnabled(false);
		lblDuzina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblDuzina, "cell 6 1,alignx trailing");

		txtDuzina = new JTextField();
		txtDuzina.setEnabled(false);
		txtDuzina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDuzina.setColumns(10);
		pnlModifikacijaK.add(txtDuzina, "cell 7 1,growx");

		lblR = new JLabel("r:");
		lblR.setEnabled(false);
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblR, "cell 8 1,alignx trailing");

		txtR = new JTextField();
		txtR.setEnabled(false);
		txtR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtR.setColumns(10);
		pnlModifikacijaK.add(txtR, "cell 9 1,growx");

		lblY1 = new JLabel("Y:");
		lblY1.setEnabled(false);
		lblY1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblY1, "cell 0 2,alignx trailing");

		txtY1 = new JTextField();
		txtY1.setText("");
		txtY1.setEnabled(false);
		txtY1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtY1.setColumns(10);
		pnlModifikacijaK.add(txtY1, "cell 1 2,growx,aligny center");

		lblY2 = new JLabel("Y:");
		lblY2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblY2.setEnabled(false);
		pnlModifikacijaK.add(lblY2, "cell 2 2,alignx trailing");

		txtY2 = new JTextField();
		txtY2.setText("");
		txtY2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtY2.setEnabled(false);
		txtY2.setColumns(10);
		pnlModifikacijaK.add(txtY2, "cell 3 2,growx");

		lblBojaU = new JLabel("Boja unutrsanjosti:");
		lblBojaU.setEnabled(false);
		lblBojaU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblBojaU, "cell 4 2");

		btnBojaU = new JButton("");
		btnBojaU.setEnabled(false);
		btnBojaU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color c = jcc.showDialog(null, "Izaberite boju", Color.BLACK);
				btnBojaU.setBackground(c);
			}
		});
		pnlModifikacijaK.add(btnBojaU, "cell 5 2,grow");

		lblVisina = new JLabel("Visina:");
		lblVisina.setEnabled(false);
		lblVisina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifikacijaK.add(lblVisina, "cell 6 2,alignx trailing");

		txtVisina = new JTextField();
		txtVisina.setEnabled(false);
		txtVisina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtVisina.setColumns(10);
		pnlModifikacijaK.add(txtVisina, "cell 7 2,growx");
		
		pnlIspis = new JPanel();
		pnlIspis.setBackground(Color.PINK);
		pnlIspis.setVisible(true);
		pnlModifikacija.add(pnlIspis, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
		GroupLayout gl_pnlIspis = new GroupLayout(pnlIspis);
		gl_pnlIspis.setHorizontalGroup(
			gl_pnlIspis.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIspis.createSequentialGroup()
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
					.addGap(28))
		);
		gl_pnlIspis.setVerticalGroup(
			gl_pnlIspis.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIspis.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlIspis.setLayout(gl_pnlIspis);
		
	
	}

	public JPanel getPnlModifikacijaK() {
		return pnlModifikacijaK;
	}



	public void setPnlModifikacijaK(JPanel pnlModifikacijaK) {
		this.pnlModifikacijaK = pnlModifikacijaK;
	}



	public JTextArea getTextArea() {
		return textArea;
	}



	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}



	public void obojajDugme(JButton d){
		if(selektovanoDugme != null){
			
			if(selektovanoDugme == d){
				//System.out.println("gasim dugme");
				/*for(int i=0;i<stekOblika.size();i++)
			    {
			    	//uklanja se selektovan objekat ako postoji takav
			    	if(stekOblika.elementAt(i).isSelektovan())
			    	{
			    		stekOblika.elementAt(i).setSelektovan(false);
			    	}
			    }*/
				//controller.unSelectShape();
				selektovanoDugme.setBackground(btnBoja.getBackground());
				selektovanoDugme = null;
				pnlModifikacija.setVisible(true);
				pnlModifikacijaK.setVisible(false);
				//selektovan=null;
				//selekciju ispravljati
				btnObrisi.setEnabled(false);
				btnModifikuj.setEnabled(false);
				
				return;
			}
			
			selektovanoDugme.setBackground(d.getBackground());
			
		}

			selektovanoDugme = d;
			selektovanoDugme.setBackground(Color.PINK);
			//selektovan.setSelektovan(false);
			
			

		
	

	}


	/*public void novaPozadina(){
		Pravougaonik p = new Pravougaonik(new Tacka(0,0), pnlPozadinaZaCrtanje.getWidth(), pnlPozadinaZaCrtanje.getHeight(), Color.WHITE, Color.WHITE);
		p.crtajSe(pnlPozadinaZaCrtanje.getGraphics());
		for(int i = 0; i < stekOblika.size(); i++){
			stekOblika.elementAt(i).crtajSe(pnlPozadinaZaCrtanje.getGraphics());	
		}
	}*/
	public void omoguciModifikaciju(boolean p){
		


		if(p==true){
			txtX1.setText("");
			txtX2.setText("");
			txtY1.setText("");
			txtY2.setText("");
			lblNaziva1.setText("");
			lblNaziva2.setText("");
			txtDuzina.setText("");
			txtVisina.setText("");
			txtR.setText("");
			if(selektovan instanceof Tacka){
				lblBojaI.setEnabled(true);
				btnBojaI.setEnabled(true);
				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblBojaU.setEnabled(false);
				btnBojaU.setEnabled(false);
				lblDuzina.setEnabled(false);
				txtDuzina.setEnabled(false);
				lblVisina.setEnabled(false);
				txtVisina.setEnabled(false);		
				lblR.setEnabled(false);
				txtR.setEnabled(false);
				lblNaziva1.setEnabled(true);
				lblNaziva2.setEnabled(false);

				lblNaziva1.setText("Koordinate tacke:");

				txtX1.setText(""+((Tacka)selektovan).getX());
				txtY1.setText(""+((Tacka)selektovan).getY());
				btnBojaI.setBackground(selektovan.getBoja());
				

			}else if(selektovan instanceof Linija){

				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(true);
				txtY2.setEnabled(true);
				lblX2.setEnabled(true);
				lblY2.setEnabled(true);
				lblBojaI.setEnabled(true);
				btnBojaI.setEnabled(true);
				lblBojaU.setEnabled(false);
				btnBojaU.setEnabled(false);
				lblDuzina.setEnabled(false);
				txtDuzina.setEnabled(false);
				lblVisina.setEnabled(false);
				txtVisina.setEnabled(false);		
				lblR.setEnabled(false);
				txtR.setEnabled(false);
				lblNaziva1.setEnabled(true);
				lblNaziva2.setEnabled(true);

				lblNaziva1.setText("Koordinate pocetne tacke:");
				lblNaziva2.setText("Koordinate krajnje tacke:");


				txtX1.setText("" + ((Linija) selektovan).gettPocetna().getX());
				txtY1.setText("" + ((Linija) selektovan).gettPocetna().getY());

				txtX2.setText("" + ((Linija) selektovan).gettKrajnja().getX());
				txtY2.setText("" + ((Linija) selektovan).gettKrajnja().getY());

				btnBojaI.setBackground(((Linija)selektovan).getBoja());
				

			}else if(selektovan instanceof Pravougaonik){
				lblBojaI.setEnabled(true);
				btnBojaI.setEnabled(true);
				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblDuzina.setEnabled(true);
				txtDuzina.setEnabled(true);
				lblBojaU.setEnabled(true);
				btnBojaU.setEnabled(true);
				lblVisina.setEnabled(true);
				txtVisina.setEnabled(true);
				lblR.setEnabled(false);
				txtR.setEnabled(false);
				lblNaziva1.setEnabled(true);
				lblNaziva2.setEnabled(false);

				lblNaziva1.setText("Koordinate tacke gore levo:");

				txtX1.setText(""+((Pravougaonik)selektovan).getGoreLevo().getX());
				txtY1.setText(""+((Pravougaonik)selektovan).getGoreLevo().getY());
				txtDuzina.setText(""+((Pravougaonik)selektovan).getSirina());
				txtVisina.setText(""+((Pravougaonik)selektovan).getVisina());

				btnBojaI.setBackground(((Pravougaonik)selektovan).getBoja());
				btnBojaU.setBackground(((Pravougaonik)selektovan).getBojaUnutrasnjosti());
				

			}else if(selektovan instanceof Kvadrat){

				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblBojaI.setEnabled(true);
				btnBojaI.setEnabled(true);
				lblBojaU.setEnabled(true);
				btnBojaU.setEnabled(true);
				lblDuzina.setEnabled(true);
				txtDuzina.setEnabled(true);
				lblVisina.setEnabled(false);
				txtVisina.setEnabled(false);		
				lblR.setEnabled(false);
				txtR.setEnabled(false);
				lblNaziva1.setEnabled(true);
				lblNaziva2.setEnabled(false);

				lblNaziva1.setText("Koordinate tacke gore levo:");

				txtX1.setText(""+((Kvadrat)selektovan).getGoreLevo().getX());
				txtY1.setText(""+((Kvadrat)selektovan).getGoreLevo().getY());
				txtDuzina.setText(""+((Kvadrat)selektovan).getDuzinaStranica());

				btnBojaI.setBackground(((Kvadrat)selektovan).getBoja());
				btnBojaU.setBackground(((Kvadrat)selektovan).getBojaUnutrasnjosti());
				
			}else if(selektovan instanceof Krug){

				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblBojaI.setEnabled(true);
				btnBojaI.setEnabled(true);
				lblBojaU.setEnabled(true);
				btnBojaU.setEnabled(true);
				lblR.setEnabled(true);
				txtR.setEnabled(true);
				lblDuzina.setEnabled(false);
				txtDuzina.setEnabled(false);
				lblVisina.setEnabled(false);
				txtVisina.setEnabled(false);
				lblNaziva1.setEnabled(true);
				lblNaziva2.setEnabled(false);

				lblNaziva1.setText("Koordinate centra:");

				txtX1.setText(""+((Krug)selektovan).getCentar().getX());
				txtY1.setText(""+((Krug)selektovan).getCentar().getY());
				txtR.setText(""+((Krug)selektovan).getR());

				btnBojaI.setBackground(((Krug)selektovan).getBoja());
				btnBojaU.setBackground(((Krug)selektovan).getBojaUnutrasnjosti());
				
			}else if(selektovan instanceof HexagonAdapter){

				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblBojaI.setEnabled(true);
				btnBojaI.setEnabled(true);
				lblBojaU.setEnabled(true);
				btnBojaU.setEnabled(true);
				lblR.setEnabled(true);
				txtR.setEnabled(true);
				lblDuzina.setEnabled(false);
				txtDuzina.setEnabled(false);
				lblVisina.setEnabled(false);
				txtVisina.setEnabled(false);
				lblNaziva1.setEnabled(true);
				lblNaziva2.setEnabled(false);

				lblNaziva1.setText("Koordinate centra:");

				txtX1.setText(""+((HexagonAdapter)selektovan).getHexagon().getX());
				txtY1.setText(""+((HexagonAdapter)selektovan).getHexagon().getY());
				txtR.setText(""+((HexagonAdapter)selektovan).getHexagon().getR());

				btnBojaI.setBackground(((HexagonAdapter)selektovan).getHexagon().getBorderColor());
				btnBojaU.setBackground(((HexagonAdapter)selektovan).getHexagon().getAreaColor());
				
			}
			
			}
		
		

	}
	public Oblik getSelektovan() {
		return selektovan;
	}



	public void setSelektovan(Oblik selektovan) {
		this.selektovan = selektovan;
	}



	public void omoguciDugmad(boolean t){
		btnModifikuj.setEnabled(t);
		btnObrisi.setEnabled(t);

		/////////////////////////////////////////////////////////////////////




	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}



	public DrawingView getView() {
		// TODO Auto-generated method stub
		return podlogaZaCrtanje;
	}
}

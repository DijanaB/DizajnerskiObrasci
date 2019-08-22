package mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.HexagonAdapter;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Square;

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


public class Frame extends JFrame {

	private JPanel pnlMain;
	private DrawingView drawingSurface;
	private DrawingModel model;
	Stack<Shape> stackShapes = new Stack<Shape>();
	JButton selectedButton = null;
	//private int korak = 1;
	//Tacka t1 = null;
	JButton btnInsideColor;
	JButton btnEdgeColor;
	Shape selected; //imam ga u drawing controlleru treba izbrisati njegovo pojavljivanje odje
	JButton btnModify;
	JButton btnDelete;
	boolean confirmation;
	private JPanel pnlModify;
	private JTextField txtX1;
	private JTextField txtLength;
	private JTextField txtY1;
	private JTextField txtHeight;
	private JTextField txtR;
	JButton btnColorIn;
	JLabel lblColorIn;
	JButton btnColorEd;
	JLabel lblColorEd;
	JLabel lblX1;
	JLabel lblY1;
	JLabel lblLength;
	JLabel lblHeight;
	JLabel lblR;
	JPanel pnlModifyK;
	private JLabel lblX2;
	private JLabel lblY2;
	private JTextField txtX2;
	private JTextField txtY2;
	private JLabel lblName1;
	private JLabel lblName2;
	private JButton btnColor;
	JButton btnPoint;
	JButton btnCircle;
	JButton btnLine;
	JButton btnSquare;
	JButton btnRectangle;
	JButton btnSelect;
	private DrawingController controller;
	private JPanel pnlFrontAndBack;
	private JButton btnToFront;
	private JButton btnToBack;
	private JButton btnBringToFront;
	private JButton btnBringToBack;
	private JButton btnHexagon;
	private JPanel pnlOutput;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private Button btn = new Button();
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Frame() {
		
		
		drawingSurface= new DrawingView();
		model = new DrawingModel();
		drawingSurface.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent m) {
				//System.out.println("x " + m.getX() + "y " + m.getY() );
				pnlModify.setVisible(true);
				pnlModifyK.setVisible(false);
				btnDelete.setEnabled(false);
				btnModify.setEnabled(false);
				
				try {
					controller.mouseClickedPnl(m.getX(),m.getY(),btnEdgeColor.getBackground(),btnInsideColor.getBackground());
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
		drawingSurface.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 652);
		pnlMain = new JPanel();
		pnlMain.setBackground(Color.WHITE);
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlMain);
		pnlMain.setLayout(new BorderLayout(0, 0));
		pnlMain.add(drawingSurface, BorderLayout.CENTER);

		JPanel pnlKomponente = new JPanel();
		pnlKomponente.setBackground(Color.PINK);
		pnlMain.add(pnlKomponente, BorderLayout.NORTH);
		pnlKomponente.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlOblici = new JPanel();
		pnlOblici.setBackground(Color.WHITE);
		pnlKomponente.add(pnlOblici);
		pnlOblici.setLayout(new MigLayout("", "[100px][100px][5px]", "[14px][23px][23px][23px]"));

		JLabel lblOblici = new JLabel("Oblici:");
		pnlOblici.add(lblOblici, "cell 0 0,alignx center,aligny top");

		btnPoint = new JButton("Tacka");

		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obojajDugme(btnPoint);
			}
		});
		pnlOblici.add(btnPoint, "cell 0 1,grow");

		btnSquare = new JButton("Kvadrat");
		btnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obojajDugme(btnSquare);
			}
		});

		btnLine = new JButton("Linija");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obojajDugme(btnLine);
			}
		});
		
				btnRectangle = new JButton("Pravougaonik");
				btnRectangle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						obojajDugme(btnRectangle);
					}
				});
				pnlOblici.add(btnRectangle, "cell 1 1,grow");
		pnlOblici.add(btnLine, "cell 0 2,grow");
		
				btnCircle = new JButton("Krug");
				btnCircle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						obojajDugme(btnCircle);
					}
				});
				pnlOblici.add(btnCircle, "cell 1 2,growx,aligny top");
		pnlOblici.add(btnSquare, "cell 0 3,grow");
		
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

		btnEdgeColor = new JButton("");
		btnEdgeColor.setBackground(Color.BLACK);
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color c = jcc.showDialog(null, "Izaberite boju", Color.BLACK);
				btnEdgeColor.setBackground(c);
			}
		});
		pnlBoje.add(btnEdgeColor, "cell 0 0,grow");

		btnInsideColor = new JButton("");
		btnInsideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color c = jcc.showDialog(null, "Izaberite boju", Color.BLACK);
				btnInsideColor.setBackground(c);
			}
		});
		btnInsideColor.setBackground(Color.WHITE);
		pnlBoje.add(btnInsideColor, "cell 1 0,grow");

		JLabel lblBojaIvice = new JLabel("Boja ivice");
		pnlBoje.add(lblBojaIvice, "cell 0 1,alignx center");

		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti");
		pnlBoje.add(lblBojaUnutrasnjosti, "cell 1 1,alignx center");

		JPanel pnlNaredbe = new JPanel();
		pnlNaredbe.setBackground(Color.WHITE);
		pnlKomponente.add(pnlNaredbe);
		pnlNaredbe.setLayout(new MigLayout("", "[]", "[][][]"));

		btnSelect = new JButton("Selektuj");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obojajDugme(btnSelect);


			}
		});
		pnlNaredbe.add(btnSelect, "cell 0 0,growx");

		btnModify = new JButton("Modifikuj");
		
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//obojajDugme(btnModifikuj);
				
				btnDelete.setEnabled(false);
				
				controller.shapeModification();
				
				pnlModify.setVisible(true);
				pnlModifyK.setVisible(false);
				
				
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
		btnModify.setEnabled(false);
		pnlNaredbe.add(btnModify, "cell 0 1");

		btnDelete = new JButton("Obrisi");
		btnDelete.addActionListener(new ActionListener() {
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
		btnDelete.setEnabled(false);
		pnlNaredbe.add(btnDelete, "cell 0 2,growx");
		
		btnColor = new JButton("");
		btnColor.setVisible(false);
		pnlKomponente.add(btnColor);

		pnlModify = new JPanel();
		pnlModify.setBackground(Color.PINK);
		pnlMain.add(pnlModify, BorderLayout.SOUTH);
		pnlModify.setVisible(true);

		pnlModifyK = new JPanel();
		pnlModifyK.setVisible(false);
		pnlModifyK.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
			}
		});
		pnlModifyK.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				
			}
		});
		pnlModify.setLayout(new BorderLayout(0, 0));
		pnlModifyK.setBackground(Color.PINK);
		pnlModify.add(pnlModifyK, BorderLayout.NORTH);
		pnlModifyK.setLayout(new MigLayout("", "[][51.00,grow][][51.00,grow][20.00][51.00,grow][][51.00,grow][][51.00,grow]", "[][32.00][36.00]"));

		lblName1 = new JLabel("");
		lblName1.setEnabled(false);
		lblName1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblName1, "cell 1 0");

		lblName2 = new JLabel("");
		lblName2.setEnabled(false);
		lblName2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblName2, "cell 3 0");

		lblX1 = new JLabel("X:");
		lblX1.setEnabled(false);
		lblX1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblX1, "cell 0 1,alignx trailing");

		txtX1 = new JTextField();
		

		txtX1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtX1.setEnabled(false);
		txtX1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(txtX1, "cell 1 1,growx,aligny center");
		txtX1.setColumns(10);

		lblX2 = new JLabel("X:");
		lblX2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblX2.setEnabled(false);
		pnlModifyK.add(lblX2, "cell 2 1,alignx trailing");

		txtX2 = new JTextField();
		txtX2.setText("");
		txtX2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtX2.setEnabled(false);
		txtX2.setColumns(10);
		pnlModifyK.add(txtX2, "cell 3 1,growx");

		lblColorEd = new JLabel("Boja Ivice:");
		lblColorEd.setEnabled(false);
		lblColorEd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblColorEd, "cell 4 1,alignx right");

		btnColorEd = new JButton("");
		btnColorEd.setEnabled(false);
		btnColorEd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc2 = new JColorChooser();
				Color c = jcc2.showDialog(null, "Izaberite boju", Color.BLACK);
				btnColorEd.setBackground(c);
			}
		});
		pnlModifyK.add(btnColorEd, "cell 5 1,grow");

		lblLength = new JLabel("Duzina:");
		lblLength.setEnabled(false);
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblLength, "cell 6 1,alignx trailing");

		txtLength = new JTextField();
		txtLength.setEnabled(false);
		txtLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLength.setColumns(10);
		pnlModifyK.add(txtLength, "cell 7 1,growx");

		lblR = new JLabel("r:");
		lblR.setEnabled(false);
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblR, "cell 8 1,alignx trailing");

		txtR = new JTextField();
		txtR.setEnabled(false);
		txtR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtR.setColumns(10);
		pnlModifyK.add(txtR, "cell 9 1,growx");

		lblY1 = new JLabel("Y:");
		lblY1.setEnabled(false);
		lblY1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblY1, "cell 0 2,alignx trailing");

		txtY1 = new JTextField();
		txtY1.setText("");
		txtY1.setEnabled(false);
		txtY1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtY1.setColumns(10);
		pnlModifyK.add(txtY1, "cell 1 2,growx,aligny center");

		lblY2 = new JLabel("Y:");
		lblY2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblY2.setEnabled(false);
		pnlModifyK.add(lblY2, "cell 2 2,alignx trailing");

		txtY2 = new JTextField();
		txtY2.setText("");
		txtY2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtY2.setEnabled(false);
		txtY2.setColumns(10);
		pnlModifyK.add(txtY2, "cell 3 2,growx");

		lblColorIn = new JLabel("Boja unutrsanjosti:");
		lblColorIn.setEnabled(false);
		lblColorIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblColorIn, "cell 4 2");

		btnColorIn = new JButton("");
		btnColorIn.setEnabled(false);
		btnColorIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color c = jcc.showDialog(null, "Izaberite boju", Color.BLACK);
				btnColorIn.setBackground(c);
			}
		});
		pnlModifyK.add(btnColorIn, "cell 5 2,grow");

		lblHeight = new JLabel("Visina:");
		lblHeight.setEnabled(false);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlModifyK.add(lblHeight, "cell 6 2,alignx trailing");

		txtHeight = new JTextField();
		txtHeight.setEnabled(false);
		txtHeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHeight.setColumns(10);
		pnlModifyK.add(txtHeight, "cell 7 2,growx");
		
		pnlOutput = new JPanel();
		pnlOutput.setBackground(Color.PINK);
		pnlOutput.setVisible(true);
		pnlModify.add(pnlOutput, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
		GroupLayout gl_pnlIspis = new GroupLayout(pnlOutput);
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
		pnlOutput.setLayout(gl_pnlIspis);
		
	
	}


	public void obojajDugme(JButton d){
		if(selectedButton != null){
			
			if(selectedButton == d){
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
				selectedButton.setBackground(btnColor.getBackground());
				selectedButton = null;
				pnlModify.setVisible(true);
				pnlModifyK.setVisible(false);
				//selektovan=null;
				//selekciju ispravljati
				btnDelete.setEnabled(false);
				btnModify.setEnabled(false);
				
				return;
			}
			
			selectedButton.setBackground(d.getBackground());
			
		}

			selectedButton = d;
			selectedButton.setBackground(Color.PINK);
			//selektovan.setSelektovan(false);
			
			

		
	

	}


	/*public void novaPozadina(){
		Pravougaonik p = new Pravougaonik(new Tacka(0,0), pnlPozadinaZaCrtanje.getWidth(), pnlPozadinaZaCrtanje.getHeight(), Color.WHITE, Color.WHITE);
		p.crtajSe(pnlPozadinaZaCrtanje.getGraphics());
		for(int i = 0; i < stekOblika.size(); i++){
			stekOblika.elementAt(i).crtajSe(pnlPozadinaZaCrtanje.getGraphics());	
		}
	}*/
	public void enableModification(boolean p){
		


		if(p==true){
			txtX1.setText("");
			txtX2.setText("");
			txtY1.setText("");
			txtY2.setText("");
			lblName1.setText("");
			lblName2.setText("");
			txtLength.setText("");
			txtHeight.setText("");
			txtR.setText("");
			if(selected instanceof Point){
				lblColorEd.setEnabled(true);
				btnColorEd.setEnabled(true);
				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblColorIn.setEnabled(false);
				btnColorIn.setEnabled(false);
				lblLength.setEnabled(false);
				txtLength.setEnabled(false);
				lblHeight.setEnabled(false);
				txtHeight.setEnabled(false);		
				lblR.setEnabled(false);
				txtR.setEnabled(false);
				lblName1.setEnabled(true);
				lblName2.setEnabled(false);

				lblName1.setText("Koordinate tacke:");

				txtX1.setText(""+((Point)selected).getX());
				txtY1.setText(""+((Point)selected).getY());
				btnColorEd.setBackground(selected.getColor());
				

			}else if(selected instanceof Line){

				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(true);
				txtY2.setEnabled(true);
				lblX2.setEnabled(true);
				lblY2.setEnabled(true);
				lblColorEd.setEnabled(true);
				btnColorEd.setEnabled(true);
				lblColorIn.setEnabled(false);
				btnColorIn.setEnabled(false);
				lblLength.setEnabled(false);
				txtLength.setEnabled(false);
				lblHeight.setEnabled(false);
				txtHeight.setEnabled(false);		
				lblR.setEnabled(false);
				txtR.setEnabled(false);
				lblName1.setEnabled(true);
				lblName2.setEnabled(true);

				lblName1.setText("Koordinate pocetne tacke:");
				lblName2.setText("Koordinate krajnje tacke:");


				txtX1.setText("" + ((Line) selected).getpStart().getX());
				txtY1.setText("" + ((Line) selected).getpStart().getY());

				txtX2.setText("" + ((Line) selected).getpEnd().getX());
				txtY2.setText("" + ((Line) selected).getpEnd().getY());

				btnColorEd.setBackground(((Line)selected).getColor());
				

			}else if(selected instanceof Rectangle){
				lblColorEd.setEnabled(true);
				btnColorEd.setEnabled(true);
				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblLength.setEnabled(true);
				txtLength.setEnabled(true);
				lblColorIn.setEnabled(true);
				btnColorIn.setEnabled(true);
				lblHeight.setEnabled(true);
				txtHeight.setEnabled(true);
				lblR.setEnabled(false);
				txtR.setEnabled(false);
				lblName1.setEnabled(true);
				lblName2.setEnabled(false);

				lblName1.setText("Koordinate tacke gore levo:");

				txtX1.setText(""+((Rectangle)selected).getUpLeft().getX());
				txtY1.setText(""+((Rectangle)selected).getUpLeft().getY());
				txtLength.setText(""+((Rectangle)selected).getSirina());
				txtHeight.setText(""+((Rectangle)selected).getVisina());

				btnColorEd.setBackground(((Rectangle)selected).getColor());
				btnColorIn.setBackground(((Rectangle)selected).getColorInside());
				

			}else if(selected instanceof Square){

				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblColorEd.setEnabled(true);
				btnColorEd.setEnabled(true);
				lblColorIn.setEnabled(true);
				btnColorIn.setEnabled(true);
				lblLength.setEnabled(true);
				txtLength.setEnabled(true);
				lblHeight.setEnabled(false);
				txtHeight.setEnabled(false);		
				lblR.setEnabled(false);
				txtR.setEnabled(false);
				lblName1.setEnabled(true);
				lblName2.setEnabled(false);

				lblName1.setText("Koordinate tacke gore levo:");

				txtX1.setText(""+((Square)selected).getUpLeft().getX());
				txtY1.setText(""+((Square)selected).getUpLeft().getY());
				txtLength.setText(""+((Square)selected).getEdgeLength());

				btnColorEd.setBackground(((Square)selected).getColor());
				btnColorIn.setBackground(((Square)selected).getColorInside());
				
			}else if(selected instanceof Circle){

				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblColorEd.setEnabled(true);
				btnColorEd.setEnabled(true);
				lblColorIn.setEnabled(true);
				btnColorIn.setEnabled(true);
				lblR.setEnabled(true);
				txtR.setEnabled(true);
				lblLength.setEnabled(false);
				txtLength.setEnabled(false);
				lblHeight.setEnabled(false);
				txtHeight.setEnabled(false);
				lblName1.setEnabled(true);
				lblName2.setEnabled(false);

				lblName1.setText("Koordinate centra:");

				txtX1.setText(""+((Circle)selected).getCentar().getX());
				txtY1.setText(""+((Circle)selected).getCentar().getY());
				txtR.setText(""+((Circle)selected).getR());

				btnColorEd.setBackground(((Circle)selected).getColor());
				btnColorIn.setBackground(((Circle)selected).getColorInside());
				
			}else if(selected instanceof HexagonAdapter){

				txtX1.setEnabled(true);
				txtY1.setEnabled(true);
				lblX1.setEnabled(true);
				lblY1.setEnabled(true);
				txtX2.setEnabled(false);
				txtY2.setEnabled(false);
				lblX2.setEnabled(false);
				lblY2.setEnabled(false);
				lblColorEd.setEnabled(true);
				btnColorEd.setEnabled(true);
				lblColorIn.setEnabled(true);
				btnColorIn.setEnabled(true);
				lblR.setEnabled(true);
				txtR.setEnabled(true);
				lblLength.setEnabled(false);
				txtLength.setEnabled(false);
				lblHeight.setEnabled(false);
				txtHeight.setEnabled(false);
				lblName1.setEnabled(true);
				lblName2.setEnabled(false);

				lblName1.setText("Koordinate centra:");

				txtX1.setText(""+((HexagonAdapter)selected).getHexagon().getX());
				txtY1.setText(""+((HexagonAdapter)selected).getHexagon().getY());
				txtR.setText(""+((HexagonAdapter)selected).getHexagon().getR());

				btnColorEd.setBackground(((HexagonAdapter)selected).getHexagon().getBorderColor());
				btnColorIn.setBackground(((HexagonAdapter)selected).getHexagon().getAreaColor());
				
			}
			
			}
		
		

	}
	public Shape getSelektovan() {
		return selected;
	}



	public void setSelektovan(Shape selektovan) {
		this.selected = selektovan;
	}



	public void omoguciDugmad(boolean t){
		btnModify.setEnabled(t);
		btnDelete.setEnabled(t);




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
		return drawingSurface;
	}
	
	/*--------------------------GETTERS AND SETTERS--------------------------------*/

	public JPanel getPnlMain() {
		return pnlMain;
	}

	public void setPnlMain(JPanel pnlMain) {
		this.pnlMain = pnlMain;
	}

	public DrawingView getDrawingSurface() {
		return drawingSurface;
	}

	public void setDrawingSurface(DrawingView drawingSurface) {
		this.drawingSurface = drawingSurface;
	}

	public DrawingModel getModel() {
		return model;
	}

	public void setModel(DrawingModel model) {
		this.model = model;
	}

	public Stack<Shape> getStackShapes() {
		return stackShapes;
	}

	public void setStackShapes(Stack<Shape> stackShapes) {
		this.stackShapes = stackShapes;
	}

	public JButton getSelectedButton() {
		return selectedButton;
	}

	public void setSelectedButton(JButton selectedButton) {
		this.selectedButton = selectedButton;
	}

	public JButton getBtnInsideColor() {
		return btnInsideColor;
	}

	public void setBtnInsideColor(JButton btnInsideColor) {
		this.btnInsideColor = btnInsideColor;
	}

	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}

	public void setBtnEdgeColor(JButton btnEdgeColor) {
		this.btnEdgeColor = btnEdgeColor;
	}

	public Shape getSelected() {
		return selected;
	}

	public void setSelected(Shape selected) {
		this.selected = selected;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(JButton btnModify) {
		this.btnModify = btnModify;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public JPanel getPnlModify() {
		return pnlModify;
	}

	public void setPnlModify(JPanel pnlModify) {
		this.pnlModify = pnlModify;
	}

	public JTextField getTxtX1() {
		return txtX1;
	}

	public void setTxtX1(JTextField txtX1) {
		this.txtX1 = txtX1;
	}

	public JTextField getTxtLength() {
		return txtLength;
	}

	public void setTxtLength(JTextField txtLength) {
		this.txtLength = txtLength;
	}

	public JTextField getTxtY1() {
		return txtY1;
	}

	public void setTxtY1(JTextField txtY1) {
		this.txtY1 = txtY1;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtR() {
		return txtR;
	}

	public void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}

	public JButton getBtnColorIn() {
		return btnColorIn;
	}

	public void setBtnColorIn(JButton btnColorIn) {
		this.btnColorIn = btnColorIn;
	}

	public JButton getBtnColorEd() {
		return btnColorEd;
	}

	public void setBtnColorEd(JButton btnColorEd) {
		this.btnColorEd = btnColorEd;
	}

	public JPanel getPnlModifyK() {
		return pnlModifyK;
	}

	public void setPnlModifyK(JPanel pnlModifyK) {
		this.pnlModifyK = pnlModifyK;
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

	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

	public JButton getBtnPoint() {
		return btnPoint;
	}

	public void setBtnPoint(JButton btnPoint) {
		this.btnPoint = btnPoint;
	}

	public JButton getBtnCircle() {
		return btnCircle;
	}

	public void setBtnCircle(JButton btnCircle) {
		this.btnCircle = btnCircle;
	}

	public JButton getBtnLine() {
		return btnLine;
	}

	public void setBtnLine(JButton btnLine) {
		this.btnLine = btnLine;
	}

	public JButton getBtnSquare() {
		return btnSquare;
	}

	public void setBtnSquare(JButton btnSquare) {
		this.btnSquare = btnSquare;
	}

	public JButton getBtnRectangle() {
		return btnRectangle;
	}

	public void setBtnRectangle(JButton btnRectangle) {
		this.btnRectangle = btnRectangle;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}

	public DrawingController getController() {
		return controller;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public JPanel getPnlFrontAndBack() {
		return pnlFrontAndBack;
	}

	public void setPnlFrontAndBack(JPanel pnlFrontAndBack) {
		this.pnlFrontAndBack = pnlFrontAndBack;
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

	public JButton getBtnHexagon() {
		return btnHexagon;
	}

	public void setBtnHexagon(JButton btnHexagon) {
		this.btnHexagon = btnHexagon;
	}

	public JPanel getPnlIspis() {
		return pnlOutput;
	}

	public void setPnlIspis(JPanel pnlIspis) {
		this.pnlOutput = pnlIspis;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public Button getBtn() {
		return btn;
	}

	public void setBtn(Button btn) {
		this.btn = btn;
	}

	public JPanel getPanelModifyK() {
		return pnlModifyK;
	}



	public JTextArea getTextArea() {
		return textArea;
	}



	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


}

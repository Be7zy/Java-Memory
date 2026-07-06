import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Memory {
	
	final Font Schrift = new Font("Arial", Font.BOLD, 40);
	final Font Schrift2 = new Font("Arial", Font.BOLD, 26);
	final Font Schrift3 = new Font("Arial", Font.PLAIN, 20);
	final Font Schrift4 = new Font("Arial", Font.PLAIN, 12);
	int Felder = 30; //Anzahl der Felder bestimmen
	int FeldRaster = setRaster(Felder);
	int Versuche = 0;
	ArrayList <Integer> List1 = getRandomNums(Felder/2);
	int Zeit = 0;
	int ButtDruck = 0;
	boolean druck2 = false;
	JButton[] butt = new JButton[Felder];
	JLabel[] labb = new JLabel[Felder];
	JButton admin = new JButton("Felder Aufedecken");
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	Timer time = new Timer(1000, null);
	Timer Paar_Timer = new Timer(600, null);
	JLabel SpielM = new JLabel("Spielmenü",SwingConstants.CENTER);
	JLabel SpielZeit = new JLabel("Zeit:           " + Zeit,SwingConstants.LEFT);
	JLabel SpielVer = new JLabel("Versuche:    " + Versuche,SwingConstants.LEFT);
	int[] Paar = new int[2];
	MemIcons Micons = new MemIcons();
	ImageIcon[] Bilder = Micons.getIcons(Felder/2);

	
	public static void main(String[] args) {
		Memory M1 = new Memory();
		//StringsMain M2 = new StringsMain();
	}
	
		public Memory(){
		
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				if(evt.getSource().equals(time)) {
					Zeit++;
					SpielZeit.setText("Zeit:           " + Zeit);
				}
				
				else if(evt.getSource().equals(Paar_Timer)) {
					Druck2_aus();
					ButtDruck = 0;
					Paar_Timer.stop();
					
				}
				
				else if (evt.getSource().equals(admin)) {
					for(int i = 0; i<Felder; i++) {
						//butt[i].setText("" + List1.get(i));
						butt[i].setIcon(Bilder[List1.get(i)-1]);
						butt[i].setBackground(Color.getHSBColor(0.06F, 1F, 0.9F));
					}
				}
				
				else {
				ButtDruck++;
				for(int i = 0; i<Felder; i++) {
					if (evt.getSource().equals(butt[i])) {
						//butt[i].setText("" + List1.get(i));
						//butt[i].setBackground(Color.getHSBColor(0.06F, 1F, 0.9F));
						//butt[i].setForeground(Color.DARK_GRAY);
						//butt[i].setIcon(Bilder[List1.get(i)-1]);
						butt[i].setVisible(false);
						labb[i].setVisible(true);
						
						switch (ButtDruck) {
							
						case 1:
							Paar[0] = i;
							break;
						case 2:
							Paar[1] = i;
							break;
						}
							
								
						
						
						break;
					}
				}
				
				if (ButtDruck == 2 && !druck2) Druck2_ein();
				
			}
				
				
				
				
				
			}
		};
		
		
		SpielM.setFont(Schrift2);
		SpielM.setForeground(Color.white);
		SpielZeit.setFont(Schrift3);
		SpielZeit.setForeground(Color.white);
		SpielVer.setFont(Schrift3);
		SpielVer.setForeground(Color.white);
		panel.setBackground(Color.black);
		panel2.setBackground(Color.black);
		frame.setBounds(800, 300, FeldRaster*120+200, Felder/FeldRaster*120 + 30);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.add(panel2);
		admin.setBounds(FeldRaster*120, 180, 150, 40);
		admin.addActionListener(act);
		admin.setFont(Schrift4);
		panel.setBounds(0, 0, FeldRaster*120, Felder/FeldRaster*120 + 30);
		panel2.setBounds(FeldRaster*120, 0, 200, Felder/FeldRaster*120 + 30);
		panel2.add(SpielM);
		panel2.add(admin);
		SpielM.setBounds(FeldRaster*120, 20, 150, 50);
		panel2.add(SpielZeit);
		SpielZeit.setBounds(FeldRaster*120, 100, 200, 50);
		panel2.add(SpielVer);
		SpielVer.setBounds(FeldRaster*120, 130, 150, 50);
		admin.setVisible(false);
		frame.setResizable(false);
		
		for (int i = 0; i < Felder;i++) {
			butt[i] = getButt();
			labb[i] = new JLabel("",SwingConstants.CENTER);
			labb[i].setFocusable(false);
			labb[i].setBorder(null);
			labb[i].setVisible(false);
			labb[i].setIcon(Bilder[List1.get(i)-1]);
			butt[i].setBounds(((i+FeldRaster)%FeldRaster)*115+15, 20+(115*(i/FeldRaster)), 100, 100);
			labb[i].setBounds(butt[i].getBounds());
			butt[i].addActionListener(act);
			panel.add(butt[i]);
			panel.add(labb[i]);
		}
		panel.setLayout(null);
		panel2.setLayout(null);
		frame.setVisible(true);
		time.addActionListener(act);
		Paar_Timer.addActionListener(act);
		time.start();
		
		
	}
	
	
	public JButton getButt() {
		JButton butt = new JButton();
		butt.setBackground(Color.gray);
		//butt.setFont(Schrift);
		butt.setFocusable(false);
		//butt.setBorder(null);
		return butt;
	}
	
	public ArrayList <Integer> getRandomNums (int Menge){
		ArrayList <Integer> li = new ArrayList<>();
		ArrayList <Integer> li2 = new ArrayList<>();
		ArrayList <Integer> li3= new ArrayList<>();
		Random ra = new Random();
		Random ra2 = new Random();
		
		for(int i = 0; i < Menge; i++) {
			
			do {
				int za = ra.nextInt(Menge) + 1;
				if(li.contains(za)) {
				}
				else {
				li.add(za);
				break;
				}
			
			}while(true);
			
			do {
				int za = ra2.nextInt(Menge) + 1;
				if(li2.contains(za)) {
				}
				else {
				li2.add(za);
				break;
				}
			
			}while(true);
		}
		
		for(int i = 0; i<Menge; i++) {
			li3.add(li.get(i));
			li3.add(li2.get(i));
		}
		
		
		return li3;
	}
	
	public void Druck2_ein() {
		ButtDruck--;
		Versuche++;
		SpielVer.setText("Versuche:    " + Versuche);
		System.out.println("2 Gedrückt");
		for(int i = 0; i < Felder;i++) {
			butt[i].setEnabled(false);
		}
		druck2 = true;
		Paar_Timer.restart();
	}
	
	public void Druck2_aus() {
		druck2 = false;
		for(int i = 0; i < Felder;i++) {
			butt[i].setEnabled(true);
			
		}
		
		if(List1.get(Paar[0]) == List1.get(Paar[1])) {
			labb[Paar[0]].setVisible(false);
			labb[Paar[1]].setVisible(false);
		}
		else {
			butt[Paar[0]].setVisible(true);
			butt[Paar[0]].setBackground(Color.gray);
			butt[Paar[1]].setVisible(true);
			butt[Paar[1]].setBackground(Color.gray);
			labb[Paar[0]].setVisible(false);
			labb[Paar[1]].setVisible(false);
		}
	}
	
	public int setRaster(int Felder) {
		
		if (Felder == 30) return 6;
		else if (Felder == 40) return 8;
		else if (Felder >= 50 && Felder <= 100) return 10;
		else if (Felder > 100) return 20;
		else return 5;
	}
	
}


import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class MemIcons {
	
	String IconOrdner = "Icons";
	File F = new File(IconOrdner);
	File[] IcoPfad = F.listFiles();
	
	
	public ImageIcon[] getIcons (int Menge){
		ImageIcon[] Icons = new ImageIcon[Menge];
		ArrayList<String> Pfade = new ArrayList<>();
		Random ran = new Random();
		
		for(int i = 0; i < Menge; i++) {
			
			do {
				
				int Rzahl = ran.nextInt(IcoPfad.length);
				
				if(Pfade.contains(IcoPfad[Rzahl].toString())) {
					
				}
				
				else {
					Pfade.add(IcoPfad[Rzahl].toString());
					break;
				}
			} while(true);
			
			
			Icons[i] = new ImageIcon(Pfade.get(i));
		}
		
		return Icons;
		
	}
	
}

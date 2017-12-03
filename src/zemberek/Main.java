package zemberek;

import java.io.IOException;


public class Main {
	static FrekansHesaplama fH = new FrekansHesaplama();
	static DosyaIslemeleri dI = new DosyaIslemeleri();
	
	public static void main(String[] str) throws IOException{
		dI.DosyadanOku();
		for(int i=0;i<dI.kelime.length;i++)
			if(dI.koku[i] != null && dI.koku[i] != " ")	
				dI.DosyadanYaz(dI.koku[i]);
		//fH.FrekansHesapla();
	}
}

package zemberek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class FrekansHesaplama {
	static DosyaIslemeleri dI = new DosyaIslemeleri();
	List<String> mylist = new ArrayList<String>();
	private String[] kelime = new String[750];
	private int[] KTekrar = new int[750];
	
	public void FrekansHesapla() throws IOException{
		File file = new File("C:/Users/okan/Desktop/PROJE - 1/OZET METINLER/SadeceKok/1-7.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			kelime = line.split(" ");
		}
		
		int i,j;
		List<String> list = new ArrayList<String>();
		for(i = 0; i < kelime.length; i++){ 
			if (list.contains(kelime[i]))
				continue;
			list.add(kelime[i]);
			for(j = 0; j < kelime.length; j++){
				if(kelime[i].equals(kelime[j])){
					KTekrar[i]++;
				}
			}
		}
		
		for(i = 0; i < kelime.length; i++ ){
			if(kelime[i] != null && KTekrar[i] != 0)
				System.out.println("Kelime: "+kelime[i]+" - Frekansı: "+KTekrar[i]);
		}
		
		fr.close();
		br.close();
		
	}

}

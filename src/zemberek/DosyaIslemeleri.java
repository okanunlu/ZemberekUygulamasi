package zemberek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;


public class DosyaIslemeleri  {
	FrekansHesaplama fH = new FrekansHesaplama();
	private String[] kelime=new String[750];
	private String[] koku = new String[750];
	private String[] stopWords = {"acaba", "ama", "ancak", "artık", "asla", "aslında", "az", "altmış", "altı", "arada", "ayrıca", "bana", "bazen", "bazı", "bazıları", "bazısı", "belki", "ben", "beni",
			"benden", "beri", "benim", "beş", "bile", "bin", "bir", "birçoğu", "birçok", "birçokları", "biri", "birisi", "birkaç", "birkaçı", "birkez", "birşey", "birşeyi", "biz", "bize", "bizden",
			"bizi", "bizim", "böyle", "böylece", "bu", "buna", "bunda", "bundan", "bunlar", "bunları", "bunların", "bunu", "bunun", "burada", "bütün", "çoğu", "çoğuna", "çoğunu", "çok", "çünkü",
			"da", "daha", "de", "dahi", "defa", "değil", "demek", "diğer", "diğeri", "diğerleri", "diye", "dolayı", "doksan", "dokuz", "dolayı", "dolayısıyla", "dört", "elbette", "en" ,"edecek", 
			"eden", "ederek", "edilecek", "ediliyor", "edilmesi", "ediyor", "eğer", "elli", "etmesi", "etti", "ettiği", "ettiğini", "fakat", "falan", "felan", "filan", "gene", "gibi", "göre",
			"halen", "hangi", "hangisi", "hani", "hatta", "hem", "henüz", "hep", "hepsi", "hepsine", "hepsini", "her", "her biri", "herhangi", "herkes", "herkese", "herkesi", "herkesin", "hiç",
			"hiç kimse", "hiçbiri", "hiçbirine", "hiçbirini", "için", "içinde", "ile", "ise", "işte", "iki", "ilgili", "itibaren", "itibariyle", "kaç", "kadar", "karşın", "katrilyon", "kendi", 
			"kendine", "kendilerine", "kendini", "kendisi", "kendisine", "kendisini", "kez", "ki", "kim", "kimden", "kime", "kimi", "kimse", "kırk", "kimin", "kimisi", "madem", "mı", "mi", "milyar", 
			"milyon", "mu", "mü", "nasıl", "ne", "ne kadar", "ne zaman", "neden", "nedenle", "nedir", "nerde", "nerede", "nereden", "nereye", "nesi", "neyse", "niçin", "niye","o", "olan", "olarak", 
			"oldu", "olduğu", "olduğunu", "olduklarını", "olmadı", "olmadığı", "olmak", "olması", "olmayan", "olmaz", "olsa", "olsun", "olup", "olur", "olursa", "oluyor", "on", "ona", "ondan", "onlar", 
			"onlara", "onlardan", "onları", "onların", "onu", "onun", "otuz", "orada", "oysa", "oysaki", "öbürü", "ön", "önce", "ötürü", "öyle", "pek", "rağmen", "sadece", "sanki", "sana", "sekiz", "seksen", 
			"sen", "senden", "seni", "senin", "siz", "sizden", "size", "sizi", "sizin", "son", "sonra", "seobilog", "şayet", "şey", "şeyden", "şeyi", "şeyler", "şimdi", "şöyle", "şu", "şuna", "şunda", "şundan",
			"şunlar", "şunları", "şunu", "şunun", "tarafından", "trilyon", "tabi", "tamam", "tüm", "tümü", "üzere", "üç", "üzere", "var", "vardı", "ve", "veya", "veyahut", "ya", "ya da", "yani", "yapacak", 
			"yapılan", "yapılması", "yapıyor", "yapmak", "yaptı", "yaptığı", "yaptığını", "yaptıkları", "yedi", "yerine", "yetmiş", "yine", "yirmi", "yoksa", "yüz", "zaten", "zira"};

 	public void DosyadanOku() throws IOException{
 		Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());
 
		File file = new File("C:/Users/okan/Desktop/PROJE - 1/OZET METINLER/Metinler(1-5)/2.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		List<String> list = new ArrayList<String>();
		int i,j;
		
		while ((line = br.readLine()) != null) {
			kelime = line.split("( )|(\\.)|(\\')|(\\,)|(\\?)");
			for(i = 0; i < kelime.length; i++)
				list.add(kelime[i]);
		}
		
		
		
		line = list.toString();
		kelime = line.split(" ");
		for(j = 0; j < kelime.length; j++){
	    	if(zemberek.kelimeDenetle(kelime[j]))
				 koku[j] = zemberek.kelimeCozumle(kelime[j])[0].kok().icerik();
	    	else
	    		 koku[j] = kelime[j];
	    }
		//fH.FrekansHesapla();
		
		br.close();
		fr.close();
	}
 	
	public void DosyadanYaz(String str) throws IOException{
		File file = new File("C:/Users/okan/Desktop/PROJE - 1/OZET METINLER/SadeceKok/2-7.txt");
		if(!file.exists()) file.createNewFile();
		
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(str + " ");
		
		bw.close();
		fw.close();
	}
}

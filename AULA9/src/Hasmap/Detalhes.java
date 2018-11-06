package Hasmap;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Detalhes {
	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Stack - ");
		lista.add("Overflow - ");
		lista.add("Bug Do Milenio - ");
		lista.add("Goku");
		
		String str1 = lista.get(0);
		String str2 = lista.get(1);
		String str3 = lista.get(2);
		String srt4 = lista.get(3);
		
		System.out.println(str1 + str2 + str3 + srt4);

		System.out.println("____________________________________________\n\n");
		
		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "Stack - ");
		hashMap.put(2, "Overflow - ");
		hashMap.put(3,"Capitão America");
		
		String str = hashMap.get(1);
		String str5 = hashMap.get(2);
		String str6 = hashMap.get(3);
		
		
		System.out.println(str +str5 + str6 );
		JOptionPane.showMessageDialog(null,"HasMap "+ str +" - " + str5+" - " + str6,"Aula08",2);
		
	}
	
	
}

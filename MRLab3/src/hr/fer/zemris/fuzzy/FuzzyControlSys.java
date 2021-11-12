package hr.fer.zemris.fuzzy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FuzzyControlSys {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		IDefuzzifier def = new COADefuzzifier();
		FuzzySystem fsAkcel = new AkcelFuzzySystemMin(def);
		FuzzySystem fsKormilo = new KormiloFuzzySystemMin(def);
		
		while(true) {
			String lnIn = br.readLine();
			if(lnIn != null) {
				if(lnIn.equals("KRAJ")) {
					return;
				} else {
					String[] parts = lnIn.split(" ");
					
					int L = Integer.parseInt(parts[0]);
					int D = Integer.parseInt(parts[1]);
					int LK = Integer.parseInt(parts[2]);
					int DK = Integer.parseInt(parts[3]);
					int V = Integer.parseInt(parts[4]);
					int S = Integer.parseInt(parts[5]);
					
					String lnOut = fsAkcel.zakljuci(L,D,LK,DK,V,S) + " " + fsKormilo.zakljuci(L,D,LK,DK,V,S);
					System.out.println(lnOut);
					System.out.flush();
				}
			}			
		}
	}
}

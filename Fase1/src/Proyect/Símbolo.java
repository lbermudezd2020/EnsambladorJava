package Proyect;

public class Símbolo {
	
	public char[] inv= {'1','2','3','4','5','6','7','8','9'};

	public String verifSim(String cadena) {
		
		if(cadena.length()<=10) {
			int b1=0;
			for(int i=0;i<inv.length;i++) {
				if(cadena.charAt(0)==inv[i]) {
					b1=1;
					i=inv.length;
				}
			}
			if(b1==1) {
				return "";
			}else {
				return "SIMBOLO";
			}
		}else {
			return "";
		}
	}

}

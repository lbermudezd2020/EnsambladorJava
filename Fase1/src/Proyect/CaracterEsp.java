package Proyect;

public class CaracterEsp {
	public String[] carEsp= {"?","$","@","."};
	
	public String verCarEsp(String cadena) {
		int b1=0;
		for(int i=0;i<carEsp.length;i++) {
			if(cadena.equals(carEsp[i])) {
				b1=1;
				i=carEsp.length;
			}
		}
		if(b1==1) {
			return "CARACTER ESPECIAL";
		}else {
			return "";
		}
	}
	
}

package Proyect;

public class Registro {
	
	String[] registros= {"AX","BX","CX","DX","AH","AL","BH","BL","CH","CL","DH","DL","SI","DI","SP","BP","SS","CS","DS","ES"};
	
	public String verifReg(String cadena) {
		int i=0;
		int bandera=0;
		while(i<registros.length) {
			if(registros[i].equals(cadena)||cadena.equals(registros[i].toLowerCase())) {
				bandera=1;
				i=registros.length;
			}
			i++;
		}
		if(bandera==1) {
			return "REGISTRO"; 
		}else {
			return "";
		}
	}

}

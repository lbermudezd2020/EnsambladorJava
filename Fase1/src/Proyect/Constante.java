package Proyect;

public class Constante {
	
	public char[] dig= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	public String verUno(String cadena,String c,int tam) {
		int p1= cadena.indexOf(c);
		int p2= cadena.lastIndexOf(c);
		if(p1==0) {
			if(p2==tam-1) {
				return "CONSTANTE CARACTER";
			}else {
				return "";
			}
		}else {
			return "";
		}
	}
	
	public String verBinario(String cadena,int tam) {
		if((cadena.indexOf('B')==tam-1)|(cadena.indexOf('b')==tam-1)) {
			int b=0;
			for(int i=0;i<(tam-1);i++) {
				if((cadena.charAt(i)!='0')&(cadena.charAt(i)!='1')) {
					i=tam;
					b=1;
				}
			}
			if(b==1) {
				return "";
			}else {
				return "CONSTANTE NUMERICA BINARIA";
			}
		}else {
			return "";
		}
	}
	
	public String verHex(String cadena, int tam) {
		if(cadena.charAt(0)=='0') {
			if((cadena.charAt(tam-1)=='h')|(cadena.charAt(tam-1)=='H')) {
				int b1=0;
				for(int i=1;i<(tam-1);i++) {
					b1=0;
					for(int j=0;j<dig.length;j++) {
						if(cadena.charAt(i)==dig[j]) {
							b1=1;
							j=dig.length;
						}
					}
					if(b1!=1) {
						i=tam;
					}
				}
				if(b1==0) {
					return "";
				}else {
					return "CONSTANTE NUMERICA HEXADECIMAL";
				}
			}else {
				return "";
			}
		}else {
			return "";
		}
	}
	
	public String verDec(String cadena,int tam) {
		int b1=0;
		for(int i=0; i<tam;i++) {
			b1=0;
			for(int j=0;j<10;j++) {
				if(cadena.charAt(i)==dig[j]) {
					b1=1;
					j=10;
				}
			}
			if(b1==0) {
				i=tam;
			}
		}
		if(b1==0) {
			return "";
		}else {
			return "CONSTANTE NUMERICA DECIMAL";
		}
	}
	
	public String verDos(String cadena,int tam) {
		String cad;
		cad= verBinario(cadena,tam);
		if(cad.equals("")) {
			cad=verHex(cadena,tam);
			if(cad.equals("")) {
				cad=verDec(cadena,tam);
				return cad;
			}else {
				return cad;
			}
		}else {
			return cad;
		}
	}
	
	public String verifCons(String cadena) {
		String cad;
		int tam= cadena.length();
		cad=verUno(cadena,"'",tam);
		if(cad.equals("")) {
			cad=verUno(cadena,"\"",tam);
			if(cad.equals("")) {
				cad=verDos(cadena,tam);
				return cad;
			}else {
				return cad;
			}
		}else {
			return cad;
		}
	}

}

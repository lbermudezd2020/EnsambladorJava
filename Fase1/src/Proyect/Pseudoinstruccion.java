package Proyect;

public class Pseudoinstruccion {
	
	public String[] grupPse= {"DATA SEGMENT","STACK SEGMENT","CODE SEGMENT","ENDS","DB","DW","EQU",
			                  "BYTE PRT","MACRO","ENDM","PROC","ENDP","DUP("};
	
	public String verifPse(String cadena) {
		int b1=0;
		for(int i=0;i<(grupPse.length-1);i++) {
			if(cadena.equals(grupPse[i])|cadena.equals(grupPse[i].toLowerCase())) {
				b1=1;
				i=grupPse.length;
			}
		}
		if(b1==1) {
			return "PSEUDOINSTRUCCI�N";
		}else {
			if(cadena.length()>=6) {
				String c1=cadena.substring(0, 4);
				String c2=cadena.substring(4,cadena.length()-1);
				if(c1.equals(grupPse[grupPse.length-1])|c1.equals(grupPse[grupPse.length-1].toLowerCase())) {
					if(cadena.endsWith(")")) {
						String cad=new CaracterEsp().verCarEsp(c2);
						if(cad.equals("")) {
							cad=new Constante().verifCons(c2);
							if(cad.equals("")) {
								return "";
							}else {
								if(cad.equals("CONSTANTE CAR�CTER")) {
									return "PSEUDOINSTRUCCI�N";
								}else {
									if(cad.equals("CONSTANTE NUM�RICA DECIMAL")) {
										return "PSEUDOINSTRUCCI�N";
									}else {
										//Condici�n nueva agregada, antes return "";
										if(cad.equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
											return "PSEUDOINSTRUCCI�N";
										}else {
											if(cad.equals("CONSTANTE NUM�RICA BINARIA")) {
												return "PSEUDOINSTRUCCI�N";
											}else {
												return "";
											}
										}
									}
								}
							}
						}else {
							if(c2.equals("?")) {
								return "PSEUDOINSTRUCCI�N";
							}else {
								return "";
							}
						}
					}else {
						return "";
					}
				}else {
					return "";
				}
			}else {
				return "";
			}
		}
	}

}

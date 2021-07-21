package Proyect;

import java.util.StringTokenizer;

public class Instrucción {
	
	public String[] grupIns= {"AAM","CWD","LODSB","RET","LES","DEC","RCL","XCHG","JCXZ","JNA","JNLE","JS"};
	
	public String verifIns(String cadena) {
		int b1=0;
		for(int i=0;i<grupIns.length;i++) {
			if(cadena.equals(grupIns[i])|cadena.equals(grupIns[i].toLowerCase())) {
				b1=1;
				i=grupIns.length;
			}
		}
		if(b1==1) {
			return "INSTRUCCI�N";
		}else {
			return "";
		}
	}
	
	public String codificaRegDestino(String reg) {
		if(reg.equals("AX")||reg.equals("ax")||reg.equals("AL")||reg.equals("al")) {
			return "000";
		}else {
			if(reg.equals("BX")||reg.equals("bx")||reg.equals("BL")||reg.equals("bl")) {
				return "011";
			}else {
				if(reg.equals("CX")||reg.equals("cx")||reg.equals("CL")||reg.equals("cl")) {
					return "001";
				}else {
					if(reg.equals("DX")||reg.equals("dx")||reg.equals("DL")||reg.equals("dl")) {
						return "010";
					}else {
						if(reg.equals("SP")||reg.equals("sp")||reg.equals("AH")||reg.equals("ah")) {
							return "100";
						}else {
							if(reg.equals("BP")||reg.equals("bp")||reg.equals("CH")||reg.equals("ch")) {
								return "101";
							}else {
								if(reg.equals("SI")||reg.equals("si")||reg.equals("DH")||reg.equals("dh")) {
									return "110";
								}else {
									return "111";//Para DI,BH
								}
							}
						}
					}
				}
			}
		}
	}
	
	public String codificaRegFuente(String reg) {
		if(reg.equals("AX")||reg.equals("ax")||reg.equals("AL")||reg.equals("al")) {
			return "11 000";
		}else {
			if(reg.equals("BX")||reg.equals("bx")||reg.equals("BL")||reg.equals("bl")) {
				return "11 011";
			}else {
				if(reg.equals("CX")||reg.equals("cx")||reg.equals("CL")||reg.equals("cl")) {
					return "11 001";
				}else {
					if(reg.equals("DX")||reg.equals("dx")||reg.equals("DL")||reg.equals("dl")) {
						return "11 010";
					}else {
						if(reg.equals("SP")||reg.equals("sp")||reg.equals("AH")||reg.equals("ah")) {
							return "11 100";
						}else {
							if(reg.equals("BP")||reg.equals("bp")||reg.equals("CH")||reg.equals("ch")) {
								return "11 101";
							}else {
								if(reg.equals("SI")||reg.equals("si")||reg.equals("DH")||reg.equals("dh")) {
									return "11 110";
								}else {
									return "11 111";//Para DI,BH
								}
							}
						}
					}
				}
			}
		}
	}
	
	public String calculaDirAAM() {
		String codB="1101010000001010";
		String codHex="";
		codHex=Integer.toHexString(Integer.parseInt(codB, 2));
		return codHex;
	}
	
	public String calculaDirCWD() {
		String codB="10011001";
		String codHex="";
		codHex=Integer.toHexString(Integer.parseInt(codB, 2));
		return codHex;
	}
	
	public String calculaDirLODSB() {
		String codB="10101100";
		String codHex="";
		codHex=Integer.toHexString(Integer.parseInt(codB, 2));
		return codHex;
	}
	
	public String calculaDirRET() {
		String codB="11000011";
		String codHex="";
		codHex=Integer.toHexString(Integer.parseInt(codB, 2));
		return codHex;
	}
	//MODIFICAR A PARTIR DE AQU� PARA OBTENER DIRECCI�N COMPLETA
	public String calculaDirLES(String op1,int tam,String dirOp2, String codOp2) {
		String cantBytes;
		StringTokenizer st1= new StringTokenizer(codOp2," ");
		String mod=st1.nextToken();
		String m=st1.nextToken();
		String reg=codificaRegDestino(op1);
		String codB="11000100"+mod+reg+m;
		cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
		if(codOp2.equals("00 110")) {
			cantBytes=cantBytes+dirOp2.substring(0, 2)+dirOp2.substring(2,4);
		}
		return cantBytes;//retorna la cantidad de bytes
	}
	
	public String calculaDirDEC(String op1,String tipo1,int tam) {//CAMBIA A dirMem,codMem,tamVar CON UNA VARIABLE
		String cantBytes;
		String codB="1111111";
		if(tipo1.equals("REGISTRO")) {
			if(tam==1) {
				codB=codB+"0";
			}else {
				codB=codB+"1";
			}
			StringTokenizer st1= new StringTokenizer(codificaRegFuente(op1)," ");
			String mod=st1.nextToken();
			String r=st1.nextToken();
			codB=codB+mod+"001"+r;
			cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
		}else {
			if(tam==1) {
				codB=codB+"0";
			}else {
				codB=codB+"1";
			}
			StringTokenizer st1= new StringTokenizer(tipo1," ");
			String mod=st1.nextToken();
			String m=st1.nextToken();
			codB= codB+mod+"001"+m;
			cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
			if(tipo1.equals("00 110")) {
				cantBytes=cantBytes+op1.substring(0, 2)+op1.substring(2,4);
			}
		}
		return cantBytes;
	}
	
	public String calculaDirRCL(String op1,String tipo1,String op2,String tipo2) {//SE ASUME EL TAMA�O DE 1 BYTE, cuando es una variable es (dirMen,codMem,op2,tipo2) 
		String cantBytes="";
		String codB;
		if(tipo1.equals("REGISTRO")) {
			if(op2.equals("cl")|op2.equals("CL")) {
				StringTokenizer st1= new StringTokenizer(codificaRegFuente(op2)," ");
				String mod=st1.nextToken();
				String r=st1.nextToken();
				codB="11000010"+mod+"010"+r;
				cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
			}else {
				if(op2.equals("1")) {
					StringTokenizer st1= new StringTokenizer(codificaRegFuente(op1)," ");
					String mod=st1.nextToken();
					String r=st1.nextToken();
					codB="11010000"+mod+"010"+r;//revisar si hay desplazamiento
					cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
				}else {
					StringTokenizer st1= new StringTokenizer(codificaRegFuente(op1)," ");
					String mod=st1.nextToken();
					String r=st1.nextToken();
					codB="11000000"+mod+"010"+r;
					if(tipo2.equals("CONSTANTE NUM�RICA DECIMAL")) {
						String inm=Integer.toBinaryString(Integer.parseInt(op2));
						while(inm.length()<8) {
							inm="0"+inm;
						}
						codB=codB+inm;
						cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
					}else {
						if(tipo2.equals("CONSTANTE NUM�RICA BINARIA")) {
							String inm=op2.substring(0, op2.length()-1);
							codB=codB+inm;
							cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
						}else {
							if(tipo2.equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
								String inm=op2.substring(1, op2.length()-1);
								cantBytes=Integer.toHexString(Integer.parseInt(codB, 2))+inm;
							}
						}
					}
				}
			}
		}else {
			if(op2.equals("cl")|op2.equals("CL")) {
				StringTokenizer st1= new StringTokenizer(codificaRegFuente(op2)," ");
				String mod=st1.nextToken();
				String r=st1.nextToken();
				codB="11000010"+mod+"010"+r;//revisar el tama�o de desplazamiento
				cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
			}else {
				if(op2.equals("1")) {
					StringTokenizer st1= new StringTokenizer(op1," ");
					String mod=st1.nextToken();
					String r=st1.nextToken();
					codB="11010000"+mod+"010"+r;
					cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
					if(tipo1.equals("00 110")) {
						cantBytes=cantBytes+op1.substring(2,4)+op1.substring(0, 2);
					}
				}else {
					StringTokenizer st1= new StringTokenizer(op1," ");
					String mod=st1.nextToken();
					String r=st1.nextToken();
					codB="11000000"+mod+"010"+r;
					cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
					if(tipo1.equals("00 110")) {
						cantBytes=cantBytes+op1.substring(2,4)+op1.substring(0, 2);
					}
					if(tipo2.contains("DECIMAL")) {
						String inm=Integer.toHexString(Integer.parseInt(op2));
						while(inm.length()<2) {
							inm="0"+inm;
						}
						cantBytes=cantBytes+inm;
					}else {
						if(tipo2.contains("BINARIA")) {
							String inm=op2.substring(0, op2.length()-1);
							cantBytes=cantBytes+Integer.toHexString(Integer.parseInt(inm, 2));;
						}else {
							if(tipo2.contains("HEXADECIMAL")) {
								String inm=op2.substring(1, op2.length()-1);
								cantBytes=cantBytes+inm;
							}
						}
					}
				}
			}
		}
		return cantBytes;
	}
	
	public String calculaDirXCHG(String op1,String op2,String tipo2, int tam) {//CAMBIA A op1,dirMem,codMem,tamVar CON UNA VARIABL
		String cantBytes;
		String reg=codificaRegDestino(op1);
		String codB="1000011";
		if(tam==1) {
			codB=codB+"0";
		}else {
			codB=codB+"1";
		}
		if(tipo2.equals("REGISTRO")) {
			StringTokenizer st1= new StringTokenizer(codificaRegFuente(op2)," ");
			String mod=st1.nextToken();
			String r=st1.nextToken();
			codB=codB+mod+reg+r;
			cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
		}else {
			StringTokenizer st1= new StringTokenizer(tipo2," ");
			String mod=st1.nextToken();
			String m=st1.nextToken();
			codB=codB+mod+reg+m;
			cantBytes=Integer.toHexString(Integer.parseInt(codB, 2));
			if(tipo2.equals("00 110")) {
				cantBytes=cantBytes+op2.substring(0, 2)+op2.substring(2,4);
			}
		}	
		return cantBytes;
	}
	//
	public String calculaDirJCXZ(String dirEt) {
		String codB="11100011";
		String codHex="";
		codHex=Integer.toHexString(Integer.parseInt(codB, 2))+dirEt;
		return codHex;
	}
	
	public String calculaDirJNA(String dirEt) {
		String codC="01110110";
		String codHex="";
		codHex=Integer.toHexString(Integer.parseInt(codC, 2))+dirEt;
		return codHex;
	}
	
	public String calculaDirJNLE(String dirEt) {
		String codC="01111111";
		String codHex="";
		codHex=Integer.toHexString(Integer.parseInt(codC, 2))+dirEt;
		return codHex;
	}
	
	public String calculaDirJS(String dirEt) {
		String codC="01111000";
		String codHex="";
		codHex=Integer.toHexString(Integer.parseInt(codC, 2))+dirEt;
		return codHex;
	}

}

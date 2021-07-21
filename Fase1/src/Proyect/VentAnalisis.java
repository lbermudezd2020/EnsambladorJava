package Proyect;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VentAnalisis extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private JButton botonPagAnterior;
    private JButton botonPagSiguiente;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JTextArea textarea1;
    private JTextArea textarea2;
    private JTextArea textarea3;
    
    private JButton botonPagAnt;
    private JButton botonPagSig;
    private JLabel jL1;
    private JLabel jL2;
    private JLabel jL3;
    private JLabel jL4;
    private JLabel jL5;
    private JScrollPane jScrollP1;
    private JScrollPane jScrollP2;
    private JScrollPane jScrollP3;
    private JScrollPane jScrollP4;
    private JScrollPane jScrollP5;
    private JSeparator jS1;
    private JSeparator jS2;
    private JSeparator jS3;
    private JSeparator jS4;
    private JSeparator jS5;
    private JTextArea texta1;
    private JTextArea texta2;
    private JTextArea texta3;
    private JTextArea texta4;
    private JTextArea texta5;
    
    ArrayList <String> elementSeparados= new ArrayList<String>(); //Almacena los elementos segmentados
    ArrayList <String> elementIdentificados= new ArrayList<String>();
    ArrayList <String> lineasOrigen= new ArrayList<String>();
    ArrayList <String> lineasContador= new ArrayList<String>();
    ArrayList <String> lineas= new ArrayList<String>();//Son las lineas con mensaje correcto o incorrecto
    ArrayList <String> tablaSc1= new ArrayList<String>();
    ArrayList <String> tablaSc2= new ArrayList<String>();
    ArrayList <String> tablaSc3= new ArrayList<String>();
    ArrayList <String> tablaSc4= new ArrayList<String>();
    ArrayList <String> tablaSc5= new ArrayList<String>();
    //DECLARAR UNA COLECCI�N DE DIRECCIONES DEL CONTADOR
    private int numLin=0,NUM_LIN_MAX=22,contadorProg=0;
    private int numLinT=0,NUM_LIN_MAX_T=22;
    
    public VentAnalisis() {
    	inicializarComponentes();
    }
    //Comienza el inicializador de componenetes
    private void inicializarComponentes() {
    	botonPagAnterior= new JButton();
    	botonPagSiguiente= new JButton();
    	jLabel1= new JLabel();
    	jLabel2= new JLabel();
    	jLabel3= new JLabel();
    	jScrollPane1= new JScrollPane();
    	jScrollPane2= new JScrollPane();
    	jScrollPane3= new JScrollPane();
    	jSeparator1= new JSeparator();
    	jSeparator2= new JSeparator();
    	jSeparator3= new JSeparator();
    	textarea1= new JTextArea();
    	textarea2= new JTextArea();
    	textarea3= new JTextArea();
    	
    	botonPagAnt= new JButton();
    	botonPagSig= new JButton();
    	jL1= new JLabel();
    	jL2= new JLabel();
    	jL3= new JLabel();
    	jL4= new JLabel();
    	jL5= new JLabel();
    	jScrollP1= new JScrollPane();
    	jScrollP2= new JScrollPane();
    	jScrollP3= new JScrollPane();
    	jScrollP4= new JScrollPane();
    	jScrollP5= new JScrollPane(); 
    	jS1= new JSeparator();
    	jS2= new JSeparator();
    	jS3= new JSeparator();
    	jS4= new JSeparator();
    	jS5= new JSeparator();
    	texta1= new JTextArea();
    	texta2= new JTextArea();
    	texta3= new JTextArea();
    	texta4= new JTextArea();
    	texta5= new JTextArea();
    	
    	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	setTitle("AN�LISIS SINT�CTICO");
    	
    	botonPagAnterior.setText("Pag. Ant.");
    	botonPagSiguiente.setText("Pag. Sig.");
    	jLabel1.setText("L�neas de c�digo");
    	jLabel2.setText("C�digo M�quina/Mensaje de error");
    	jLabel3.setText("CP");
    	botonPagAnterior.setEnabled(false);
    	botonPagSiguiente.setEnabled(false);
    	
    	botonPagAnt.setText("Pag. Ant.");
    	botonPagSig.setText("Pag. Sig.");
    	jL1.setText("S�MBOLO");
    	jL2.setText("TIPO");
    	jL3.setText("VALOR");
    	jL4.setText("TAMA�O(BYTES) ");
    	jL5.setText("  DIRECCI�N");
    	botonPagAnt.setEnabled(false);
    	botonPagSig.setEnabled(false);
    	
    	botonPagAnterior.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			botonPagAnteriorActionPerformed();
    		}
    	});
    	botonPagSiguiente.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			botonPagSiguienteActionPerformed();
    		}
    	});
    	botonPagAnt.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			botonPagAntActionPerformed();
    		}
    	});
    	botonPagSig.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			botonPagSigActionPerformed();
    		}
    	});
        
        textarea1.setEditable(false);
        textarea1.setColumns(20);
        textarea1.setRows(5);
        textarea1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textarea1.setEnabled(false);
        jScrollPane1.setViewportView(textarea1);
        textarea2.setEditable(false);
        textarea2.setColumns(20);
        textarea2.setRows(5);
        textarea2.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textarea2.setEnabled(false);
        jScrollPane2.setViewportView(textarea2);
        textarea3.setEditable(false);
        textarea3.setColumns(10);
        textarea3.setRows(5);
        textarea3.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textarea3.setEnabled(false);
        jScrollPane3.setViewportView(textarea3);
        
        texta1.setEditable(false);
        texta1.setColumns(20);
        texta1.setRows(5);
        texta1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        texta1.setEnabled(false);
        jScrollP1.setViewportView(texta1);
        texta2.setEditable(false);
        texta2.setColumns(20);
        texta2.setRows(5);
        texta2.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        texta2.setEnabled(false);
        jScrollP2.setViewportView(texta2);
        texta3.setEditable(false);
        texta3.setColumns(10);
        texta3.setRows(5);
        texta3.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        texta3.setEnabled(false);
        jScrollP3.setViewportView(texta3);
        texta4.setEditable(false);
        texta4.setColumns(20);
        texta4.setRows(5);
        texta4.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        texta4.setEnabled(false);
        jScrollP4.setViewportView(texta4);
        texta5.setEditable(false);
        texta5.setColumns(10);
        texta5.setRows(5);
        texta5.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        texta5.setEnabled(false);
        jScrollP5.setViewportView(texta5);
        
        GroupLayout g1 = new GroupLayout(getContentPane());
        getContentPane().setLayout(g1);
        g1.setHorizontalGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(g1.createSequentialGroup()
                .addContainerGap()
                .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(g1.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE))
                    .addGroup(g1.createSequentialGroup()
                        .addGroup(g1.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3)
                            .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                    .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    		.addComponent(jLabel1)
                    		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    		.addComponent(jSeparator1))
                    .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    		.addComponent(jLabel2)
                    		.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    		.addComponent(jSeparator2))
                            .addContainerGap(61, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(botonPagSiguiente)
                            .addComponent(botonPagAnterior))
                     .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        	.addComponent(jL1)
                        	.addComponent(jScrollP1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        	.addComponent(jS1))
                     .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                     		.addComponent(jL2)
                     		.addComponent(jScrollP2, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                     		.addComponent(jS2))
                     .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                     		.addComponent(jL3)
                     		.addComponent(jScrollP3, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                     		.addComponent(jS3))
                     .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                     		.addComponent(jL4)
                     		.addComponent(jScrollP4, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                     		.addComponent(jS4))
                     .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                     		.addComponent(jL5)
                     		.addComponent(jScrollP5, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                     		.addComponent(jS5))
                     .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING)
                             .addComponent(botonPagSig)
                             .addComponent(botonPagAnt))
                        .addGap(41, 41, 41)))
                )
        );
        g1.setVerticalGroup(
                g1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(g1.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(g1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    	.addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jL1)
                        .addComponent(jL2)
                        .addComponent(jL3)
                        .addComponent(jL4)
                        .addComponent(jL5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING)
                    	.addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jS1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jS2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jS3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jS4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jS5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(g1.createParallelGroup(GroupLayout.Alignment.LEADING)
                    	.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollP1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollP2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollP3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollP4, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollP5, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addGroup(g1.createSequentialGroup()
                            .addGap(17,17,17)
                            .addComponent(botonPagSiguiente)
                            .addGap(17, 17, 17)
                            .addComponent(botonPagAnterior))
                        .addGroup(g1.createSequentialGroup()
                                .addGap(17,17,17)
                                .addComponent(botonPagSig)
                                .addGap(17, 17, 17)
                                .addComponent(botonPagAnt)))
                     
                    .addGap(54, 54, 54))
            );
    	pack();
    }//Termina el inicializador de componenetes
    
    public String completaContador(String numHex) {
    	int tamNum=numHex.length();
    	for(int i=tamNum;i<4;i++) {
    		numHex="0"+numHex;
    	}
    	return numHex+"H";
    }
    
    public int verificaExistencia(String var) {
    	int existencia=0,tam;
    	tam=tablaSc1.size();
    	for(int i=0;i<tam;i++) {
    		if(tablaSc1.get(i).equals(var)) {
    			existencia=1;
    			i=tam;
    		}
    	}
    	return existencia;
    }
    
    public void llenaTabla(String simbolo,String tipo,String valor,String tam,String direccion) {
    	tablaSc1.add(simbolo);
		tablaSc2.add(tipo);
		tablaSc3.add(valor);
		tablaSc4.add(tam);
		tablaSc5.add(direccion);
    }
    
    public String multiplicaValor(String cad, int num) {
    	String valMult="";
    	if(cad.startsWith("\"")) {
    		for(int i=0;i<num;i++) {
        		valMult=valMult+cad.substring(1, cad.length()-1);
        	}
    		valMult="\""+valMult+"\"";
    	}else {
    		if(cad.startsWith("'")) {
    			for(int i=0;i<num;i++) {
            		valMult=valMult+cad.substring(1, cad.length()-1);
            	}
    			valMult="'"+valMult+"'";
    		}else {
    			for(int i=0;i<num;i++) {
            		valMult=valMult+" "+cad;
            	}
    		}
    	}
    	return valMult.trim();
    }
    
    public void verificaTamañoDatos(ArrayList <String> elements,ArrayList <String> identificados) {//VER SI VALIDA CORRECTAMENTE
    	String tamVar;
    	int existencia=0;
    	if(elements.get(1).equals("db")|elements.get(1).equals("DB")) {
    		if(identificados.get(2).equals("CONSTANTE CAR�CTER")) {
    			if(elements.size()==3) {
    				existencia=verificaExistencia(elements.get(0));
        			if(existencia==0) {
        				lineas.add("");
        				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            			tamVar=Integer.toString(elements.get(2).length()-2);
            			llenaTabla(elements.get(0),"variable",elements.get(2),tamVar,completaContador(Integer.toHexString(contadorProg)));
            			contadorProg=contadorProg+Integer.parseInt(tamVar);//INCREMENTA CONTADOR
        			}else {
        				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
        				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        			}
    			}else {
    				lineas.add(identificados.get(3)+" '"+elements.get(3)+"' INVALIDO");
    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    			}
    		}else {
    			if(identificados.get(2).equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
					existencia=verificaExistencia(elements.get(0));
					if(existencia==0) {
						if((elements.get(2).length()-2)==4) {//PREGUNTAR SI ES V�LIDO INSERTAR VALORES MENORES
							lineas.add(identificados.get(2)+" '"+elements.get(2)+"' INV�LIDA");
							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    					}else {
    						if((elements.get(2).length()-2)==2){
    							if(elements.size()==3) {
    								lineas.add("");
    								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    								llenaTabla(elements.get(0),"variable",elements.get(2),"1",completaContador(Integer.toHexString(contadorProg)));
    								contadorProg=contadorProg+1;//INCREMENTA CONTADOR
    							}else {
    								lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
    								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    							}
    						}else {
    							lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
    							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    						}
    					}
	    			}else {
	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
	    			}
				}else {
					if(identificados.get(2).equals("CONSTANTE NUM�RICA BINARIA")) {
    					existencia=verificaExistencia(elements.get(0));
    					if(existencia==0) {
    						if((elements.get(2).length()-1)==16) {
    							lineas.add(identificados.get(2)+" '"+elements.get(2)+"' INV�LIDA");
    							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        					}else {
        						if((elements.get(2).length()-1)==8) {
        							if(elements.size()==3) {
        								lineas.add("");
        								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            							llenaTabla(elements.get(0),"variable",elements.get(2),"1",completaContador(Integer.toHexString(contadorProg)));
            							contadorProg=contadorProg+1;//INCREMENTA CONTADOR
        							}else {
        								lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
        								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        							}
        						}else {
        							lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
        							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        						}
        					}
    	    			}else {
    	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
    	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	    			}
    				}else {
    					if(identificados.get(2).equals("CONSTANTE NUM�RICA DECIMAL")) {
        					existencia=verificaExistencia(elements.get(0));
        					if(existencia==0) {
        						if(elements.size()==4) {
        							if(Integer.parseInt(elements.get(2))<65536) {
        								String c1=elements.get(3).substring(0, 4);
            							String c2=elements.get(3).substring(4,elements.get(3).length()-1);
            							if(c1.equals("dup(")|c1.equals("DUP(")) {
            								String cad=new Constante().verifCons(c2);
            								if(cad.equals("CONSTANTE NUM�RICA DECIMAL")) {
            									if(Integer.parseInt(c2)<256) {
            										lineas.add("");
            										lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            				    					tamVar=Integer.toString(1*Integer.parseInt(elements.get(2)));
            				    					llenaTabla(elements.get(0),"variable",multiplicaValor(c2,Integer.parseInt(elements.get(2))),tamVar,completaContador(Integer.toHexString(contadorProg)));
            				    					contadorProg=contadorProg+Integer.parseInt(tamVar);
            									}else {
            										lineas.add("TAMA�O DE LA CONSTANTE NUM�RICA");
            										lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            									}
            								}else {
            									if(cad.equals("CONSTANTE CAR�CTER")) {
            										lineas.add("");
            										lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            				    					tamVar=Integer.toString((c2.length()-2)*Integer.parseInt(elements.get(2)));
            				    					llenaTabla(elements.get(0),"variable",multiplicaValor(c2,Integer.parseInt(elements.get(2))),tamVar,completaContador(Integer.toHexString(contadorProg)));
            				    					contadorProg=contadorProg+Integer.parseInt(tamVar);
            									}else {
            										//lineas.add("INCORRECTO: CONSTANTE INV�LIDA");
            										if(cad.equals("CONSTANTE NUM�RICA BINARIA")) {
            											if((c2.length()-1)==8) {//PENDIENTE DE TAMA�O
            												lineas.add("");
            												lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            												tamVar=Integer.toString(1*Integer.parseInt(elements.get(2)));
                    				    					llenaTabla(elements.get(0),"variable",multiplicaValor(c2,Integer.parseInt(elements.get(2))),tamVar,completaContador(Integer.toHexString(contadorProg)));
                    				    					contadorProg=contadorProg+Integer.parseInt(tamVar);
            											}else {
            												lineas.add("TAMA�O DE LA "+cad+" '"+c2+"'");
            												lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            											}
            										}else {
            											if(cad.equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
            												if((c2.length()-2)==2) {
            													lineas.add("");
            													lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            													tamVar=Integer.toString(1*Integer.parseInt(elements.get(2)));
                        				    					llenaTabla(elements.get(0),"variable",multiplicaValor(c2,Integer.parseInt(elements.get(2))),tamVar,completaContador(Integer.toHexString(contadorProg)));
                        				    					contadorProg=contadorProg+Integer.parseInt(tamVar);//INCREMENTA CONTADOR
            												}else {
            													lineas.add("TAMA�O DE LA "+cad+" '"+c2+"'");
            													lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            												}
            											}else {
            												lineas.add("CONSTANTE INV�LIDA");
            												lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            											}
            										}
            									}
            								}
            							}else {
            								lineas.add("PSEUDOINSTRUCCI�N '"+elements.get(3)+"' INV�LIDA");
            								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            							}
        							}else {
        								lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
        								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        							}
        						}else {
        							if(Integer.parseInt(elements.get(2))<256) {
                						lineas.add("");
                						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
                						llenaTabla(elements.get(0),"variable",elements.get(2),"1",completaContador(Integer.toHexString(contadorProg)));
                						contadorProg=contadorProg+1;//INCREMENTA CONTADOR
                					}else {
                							lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
                							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
                					}
        						}
        	    			}else {
        	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
        	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        	    			}
        				}else {
        					lineas.add("CONSTANTE INV�LIDA");
        					lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        				}
    				}
				}
    		}
    	}else {
    		if(elements.get(1).equals("dw")|elements.get(1).equals("DW")) {
    			if(identificados.get(2).equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
					existencia=verificaExistencia(elements.get(0));
					if(existencia==0) {
						if((elements.get(2).length()-2)==4) {
							if(elements.size()==4) {
								lineas.add(""+identificados.get(2)+" '"+elements.get(2)+"' INV�LIDA");
								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
							}else {
								lineas.add("");
								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
								llenaTabla(elements.get(0),"variable",elements.get(2),"2",completaContador(Integer.toHexString(contadorProg)));
								contadorProg=contadorProg+2;//INCREMENTA CONTADOR
							}
    					}else {
    						lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
    						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    					}
	    			}else {
	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
	    			}
				}else {
					if(identificados.get(2).equals("CONSTANTE NUM�RICA BINARIA")) {
    					existencia=verificaExistencia(elements.get(0));
    					if(existencia==0) {
    						if((elements.get(2).length()-1)==16) {
    							if(elements.size()==4) {
    								lineas.add(""+identificados.get(2)+" '"+elements.get(2)+"' INV�LIDA");
    								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    							}else {
    								lineas.add("");
    								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    								llenaTabla(elements.get(0),"variable",elements.get(2),"2",completaContador(Integer.toHexString(contadorProg)));
    								contadorProg=contadorProg+2;//INCREMENTA CONTADOR
    							}
        					}else {
        						lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
        						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        					}
    	    			}else {
    	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
    	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	    			}
    				}else {
    					if(identificados.get(2).equals("CONSTANTE NUM�RICA DECIMAL")) {
        					existencia=verificaExistencia(elements.get(0));
        					if(existencia==0) {
        						if(Integer.parseInt(elements.get(2))<65536) {
        							if(elements.size()==4) {
        								String c1=elements.get(3).substring(0, 4);
        								String c2=elements.get(3).substring(4,elements.get(3).length()-1);
        								if(c1.equals("dup(")|c1.equals("DUP(")) {
        									String cad=new Constante().verifCons(c2);
        									if(cad.equals("CONSTANTE NUM�RICA DECIMAL")) {
        										if(Integer.parseInt(c2)<65536) {
        											lineas.add("");
        											lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        				    						tamVar=Integer.toString(2*Integer.parseInt(elements.get(2)));
        				    						llenaTabla(elements.get(0),"variables",multiplicaValor(c2, Integer.parseInt(elements.get(2))),tamVar,completaContador(Integer.toHexString(contadorProg)));
        				    						contadorProg=contadorProg+Integer.parseInt(tamVar);//INCREMENTA CONTADOR
        										}else {
        											lineas.add("TAMA�O DE LA CONSTANTE NUM�RICA");
        											lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        										}
        									}else {
        										//lineas.add("INCORRECTO: CONSTANTE INV�LIDA");
        										if(cad.equals("CONSTANTE NUM�RICA BINARIA")) {
        											if((c2.length()-1)==16) {//PENDIENTE DE TAMA�O
        												lineas.add("");
        												lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        												tamVar=Integer.toString(2*Integer.parseInt(elements.get(2)));
            				    						llenaTabla(elements.get(0),"variables",multiplicaValor(c2, Integer.parseInt(elements.get(2))),tamVar,completaContador(Integer.toHexString(contadorProg)));
            				    						contadorProg=contadorProg+Integer.parseInt(tamVar);//INCREMENTA CONTADOR
        											}else {
        												lineas.add("TAMA�O DE LA "+cad+" '"+c2+"'");
        												lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        											}
        										}else {
        											if(cad.equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
        												if((c2.length()-2)==4) {
        													lineas.add("");
        													lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        													tamVar=Integer.toString(2*Integer.parseInt(elements.get(2)));
                				    						llenaTabla(elements.get(0),"variables",multiplicaValor(c2, Integer.parseInt(elements.get(2))),tamVar,completaContador(Integer.toHexString(contadorProg)));
                				    						contadorProg=contadorProg+Integer.parseInt(tamVar);//INCREMENTA CONTADOR
        												}else {
        													lineas.add("TAMA�O DE LA "+cad+" '"+c2+"'");
        													lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        												}
        											}else {
        												lineas.add(cad+" '"+c2+"'");
        												lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        											}
        										}
        									}
        								}else {
        									lineas.add("PSEUDOINSTRUCCI�N '"+elements.get(3)+"' INV�LIDA");
        									lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        								}
        							}else {
        								lineas.add("");
        								lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        								llenaTabla(elements.get(0),"variable",elements.get(2),"2",completaContador(Integer.toHexString(contadorProg)));
        								contadorProg=contadorProg+2;//INCREMENTA CONTADOR
        							}
            					}else {
            						lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
            						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            					}
        	    			}else {
        	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
        	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        	    			}
        				}else {
        					lineas.add(identificados.get(2)+" '"+elements.get(2)+"' INV�LIDA");
        					lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        				}
    				}
				}
    		}else {
    			if(elements.get(1).equals("equ")|elements.get(1).equals("EQU")) {//PREGUNTAR DEBIDO A QUE LA DIRECCI�N SE OCUPA EN LA INSTRUCCI�N
    				if(elements.size()==3) {
    					if(identificados.get(2).equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
        					existencia=verificaExistencia(elements.get(0));
        					if(existencia==0) {
        						if((elements.get(2).length()-2)==4) {
            						lineas.add("");
            						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            						llenaTabla(elements.get(0),"constante hexadecimal",elements.get(2),"2","-");
            						contadorProg=contadorProg+2;//INCREMENTA CONTADOR
            					}else {
            						lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
            						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            					}
        	    			}else {
        	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
        	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        	    			}
        				}else {
        					if(identificados.get(2).equals("CONSTANTE NUM�RICA BINARIA")) {
            					existencia=verificaExistencia(elements.get(0));
            					if(existencia==0) {
            						if((elements.get(2).length()-1)==16) {
                						lineas.add("");
                						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
                						llenaTabla(elements.get(0),"constante binaria",elements.get(2),"2","-");
                						contadorProg=contadorProg+2;//INCREMENTA CONTADOR
                					}else {
                						lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
                						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
                					}
            	    			}else {
            	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
            	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
            	    			}
            				}else {
            					if(identificados.get(2).equals("CONSTANTE NUM�RICA DECIMAL")) {
                					existencia=verificaExistencia(elements.get(0));
                					if(existencia==0) {
                						if(Integer.parseInt(elements.get(2))<65536) {
                    						lineas.add("");
                    						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
                    						llenaTabla(elements.get(0),"constante decimal",elements.get(2),"2","-");
                    						contadorProg=contadorProg+2;//INCREMENTA CONTADOR
                    					}else {
                    						lineas.add("TAMA�O DE LA "+identificados.get(2)+" '"+elements.get(2)+"'");
                    						lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
                    					}
                	    			}else {
                	    				lineas.add("S�MBOLO '"+elements.get(0)+"' REPETIDO");
                	    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
                	    			}
                				}else {
                					lineas.add(identificados.get(2)+" '"+elements.get(2)+"' INV�LIDA");
                					lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
                				}
            				}
        				}
    				}else {
    					lineas.add("LIMITE DE ELEMENTOS EXCEDIDO");
    					lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    				}
    			}else {
    				lineas.add("PSEUDOINSTRUCCI�N "+elements.get(1)+" INV�LIDA");
    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    			}
    		}
    	}
    }
    
    public void trataDataSeg(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	for(int g=0;g< elements.size();g++) {//REVISAR CONDICI�N
    		if(identificados.get(g).equals("S�MBOLO")) {
    				if(g!=0) {
    					cadError=cadError+", "+"POSICI�N DE '"+elements.get(g)+"'";
    				}
    			}else {
    				if(identificados.get(g).equals("PSEUDOINSTRUCCI�N")) {
    					if(g!=1&g!=3) {
    						cadError=cadError+", "+"POSICI�N DE '"+elements.get(g)+"'";
        				}
    				}else {
    					if(identificados.get(g).equals("CONSTANTE CAR�CTER")) {
    						if(g!=2) {
    							cadError=cadError+", "+"POSICI�N DE '"+elements.get(g)+"'";
    	    				}
    					}else {
    						if(identificados.get(g).startsWith("CONSTANTE NUM�RICA")) {
    							if(g!=2) {
    								cadError=cadError+", "+"POSICI�N DE '"+elements.get(g)+"'";
    	        				}
    						}else {
    							if(identificados.get(g).equals("PSEUDOINSTRUCCI�N")&elements.get(g).contains("DUP(")) {//VERIFICAR SI DETECTA DUP(
    								if(g!=3) {
    									cadError=cadError+", "+"POSICI�N DE '"+elements.get(g)+"'";
    		        				}
    							}else {
    								if(identificados.get(g).equals("ELEMENTO INV�LIDO")) {
    	        						cadError=cadError+", "+"ELEMENTO '"+elements.get(g)+"' INV�LIDO";
    	        					}
    							}
    						}
    					}
    				}
    			}
    	}
    	if(cadError=="") {
    		if(elements.size()>2) {
    			if(elements.size()<5) {
    				verificaTamañoDatos(elements,identificados);
    			}else {
    				lineas.add("LIMITE DE ELEMENTOS EXCEDIDO");
    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    			}
    		}else {
    			lineas.add("FALTAN ELEMENTOS");
    			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    		}
    	}else {
    		lineas.add(cadError.substring(2));
    		lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	}
    }
    
    public void verificaTamañoStack(ArrayList <String> elements,ArrayList <String> identificados) {
    	String tamVar="";
    	if(elements.get(0).equals("dw")|elements.get(0).equals("DW")) {
    		if(identificados.get(1).equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
    			lineas.add(identificados.get(1)+" '"+elements.get(1)+"' INV�LIDA");
    			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    		}else {
    			if(identificados.get(1).equals("CONSTANTE NUM�RICA BINARIA")) {
    				lineas.add(identificados.get(1)+" '"+elements.get(1)+"' INV�LIDA");
    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        		}else {
        			if(identificados.get(1).equals("CONSTANTE NUM�RICA DECIMAL")) {
        				if(Integer.parseInt(elements.get(1))<65536) {
        					String c1=elements.get(2).substring(0, 4);
    						String c2=elements.get(2).substring(4,elements.get(2).length()-1);
    						if(c1.equals("dup(")|c1.equals("DUP(")) {
    							String cad=new Constante().verifCons(c2);
    							if(cad.equals("CONSTANTE NUM�RICA DECIMAL")) {
    								if(Integer.parseInt(c2)<65536) {
    									lineas.add("");
    									lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    									tamVar=Integer.toString(2*Integer.parseInt(elements.get(1)));
    									contadorProg=contadorProg+Integer.parseInt(tamVar);//INCREMENTA CONTADOR
    								}else {
    									lineas.add("TAMA�O DE LA "+cad);
    									lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    								}
    							}else {
    								//lineas.add("INCORRECTO: "+cad+" '"+elements.get(1)+"' INV�LIDA");
    								if(cad.equals("CONSTANTE NUM�RICA BINARIA")) {
    									if((c2.length()-1)==16) {//PENDIENTE DE TAMA�O
    										lineas.add("");
    										lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    										tamVar=Integer.toString(2*Integer.parseInt(elements.get(1)));
    										contadorProg=contadorProg+Integer.parseInt(tamVar);//INCREMENTA CONTADOR
    									}else {
    										lineas.add("TAMA�O DE LA "+cad+" '"+c2+"'");
    										lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    									}
    								}else {
    									if(cad.equals("CONSTANTE NUM�RICA HEXADECIMAL")) {
    										if((c2.length()-2)==4) {
    											lineas.add("");
    											lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    											tamVar=Integer.toString(2*Integer.parseInt(elements.get(1)));
    											contadorProg=contadorProg+Integer.parseInt(tamVar);//INCREMENTA CONTADOR
    										}else {
    											lineas.add("TAMA�O DE LA "+cad+" '"+c2+"'");
    											lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    										}
    									}else {
    										lineas.add("CONSTANTE INV�LIDA");
    										lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    									}
    								}
    							}
    						}else {
    							lineas.add("PSEUDOINSTRUCCI�N '"+elements.get(2)+"' INV�LIDA");
    							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    						}
        				}else {
        					lineas.add("TAMA�O DE LA "+identificados.get(1)+" '"+elements.get(1)+"'");
        					lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        				}
            		}
        		}
    		}
    	}else {
    		lineas.add("PSEUDOINSTRUCCI�N '"+elements.get(0)+"' INV�LIDA");
    		lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	}
    }
    
    public void trataStackSeg(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	for(int g=0;g< elements.size();g++) {//REVISAR CONDICI�N
    		if(identificados.get(g).equals("PSEUDOINSTRUCCI�N")) {
    			if(g!=0&g!=2) {
    				cadError=cadError+", "+"POSICI�N DE '"+elements.get(g)+"'";
        		}
    		}else {
    			if(identificados.get(g).startsWith("CONSTANTE NUM�RICA")) {
    				if(g!=1) {
    					cadError=cadError+", "+"POSICI�N DE '"+elements.get(g)+"'";
    	    		}
    			}else {
    				if(identificados.get(g).equals("CONSTANTE CAR�CTER")) {
    					cadError=cadError+", "+"INV�LIDA CONSTANTE CAR�CTER '"+elements.get(g)+"'";
    				}else {
    					if(identificados.get(g).equals("PSEUDOINSTRUCCI�N")&elements.get(g).contains("DUP(")) {//VERIFICAR SI DETECTA DUP(
        					if(g!=2) {
        						cadError=cadError+", "+"POSICI�N DE '"+elements.get(g)+"'";
        					}
        				}else {
        					if(identificados.get(g).equals("ELEMENTO INV�LIDO")) {
        						cadError=cadError+", "+"ELEMENTO '"+elements.get(g)+"' INV�LIDO";
        					}
        				}
    				}
    			}
    		}
    	}
    	if(cadError=="") {
    		if(elements.size()>2) {
    			if(elements.size()<4) {
    				verificaTamañoStack(elements,identificados);
    			}else {
    				lineas.add("LIMITE DE ELEMENTOS EXCEDIDO");
    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    			}
    		}else {
    			lineas.add("FALTAN ELEMENTOS");
    			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    		}
    	}else {
    		lineas.add(cadError.substring(2));
    		lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	}
    }
    
    public String verificaInsAAM(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
		if(elements.size()>1) {
			cadError="OPERANDOS NO PERMITIDOS";
		}else {
			String dir="";
			dir=new Instrucción().calculaDirAAM();
			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
			lineas.add(dir.toUpperCase()+"H");
			contadorProg= contadorProg+(int)(dir.length()/2);
		}
		return cadError;
    }
    
    public String verificaInsCWD(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()>1) {
			cadError="OPERANDOS NO PERMITIDOS";
		}else {
			String dir="";
			dir=new Instrucción().calculaDirCWD();
			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
			lineas.add(dir.toUpperCase()+"H");
			contadorProg= contadorProg+(int)(dir.length()/2);
		}
    	return cadError;
    }
    
    public String verificaInsLODSB(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()>1) {
			cadError="OPERANDOS NO PERMITIDOS";
		}else {
			String dir="";
			dir=new Instrucción().calculaDirLODSB();
			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
			lineas.add(dir.toUpperCase()+"H");
			contadorProg= contadorProg+(int)(dir.length()/2);
		}
    	return cadError;
    }
    
    public String verificaInsRET(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()>1) {
			cadError="OPERANDOS NO PERMITIDOS";
		}else {
			String dir="";
			dir=new Instrucción().calculaDirRET();
			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
			lineas.add(dir.toUpperCase()+"H");
			contadorProg= contadorProg+(int)(dir.length()/2);
		}
    	return cadError;
    }
    
    public int localizaConstante(String v) {//REGRESA EL TAMA�O EN BYTES
    	int resp=0,tam;
    	tam=tablaSc1.size();
    	for(int i=0;i<tam;i++) {
    		if(tablaSc1.get(i).equals(v)&tablaSc2.get(i).contains("constante")) {
    			resp=Integer.parseInt(tablaSc4.get(i));
    			i=tam;
    		}
    	}
    	return resp;
    }
    
    public int localizaVariable(String v) {//REGRESA EL TAMA�O EN BYTES
    	int resp=0,tam;
    	tam=tablaSc1.size();
    	for(int i=0;i<tam;i++) {
    		if(tablaSc1.get(i).equals(v)&tablaSc2.get(i).equals("variable")) {
    			resp=Integer.parseInt(tablaSc4.get(i));
    			i=tam;
    		}
    	}
    	return resp;
    }
    
    public String obtenValorVariable(String v) {//REGRESA EL TAMA�O EN BYTES
    	int tam;
    	String resp="";
    	tam=tablaSc1.size();
    	for(int i=0;i<tam;i++) {
    		if(tablaSc1.get(i).equals(v)&(tablaSc2.get(i).equals("variable")|tablaSc2.get(i).contains("constante"))) {
    			resp=tablaSc3.get(i);
    			i=tam;
    		}
    	}
    	return resp;
    }
    
    public String obtenDirMemoria(String v) {//REGRESA EL TAMA�O EN BYTES
    	String resp="";
    	int tam;
    	tam=tablaSc1.size();
    	for(int i=0;i<tam;i++) {
    		if(tablaSc1.get(i).equals(v)) {
    			resp=tablaSc5.get(i).substring(0, tablaSc5.get(i).length());
    			i=tam;
    		}
    	}
    	return resp;
    }
    
    public int clasificaReg(String reg) {//REGRESA EL TAMA�O DEL REGISTRO EN BYTES
    	int resp=0;
    	if(reg.contains("X")|reg.contains("x")|reg.equals("BP")|reg.equals("bp")|reg.equals("SP")|reg.equals("sp")|reg.equals("DI")|reg.equals("di")|reg.equals("SI")|reg.equals("si")|reg.equals("SS")|reg.equals("ss")|reg.equals("CS")|reg.equals("cs")|reg.equals("DS")|reg.equals("ds")|reg.equals("ES")|reg.equals("es")) {
    		resp=2;
    	}else {
    		if(reg.contains("H")|reg.contains("h")|reg.contains("L")|reg.contains("l")) {
    			resp=1;
    		}
    	}
    	return resp;
    }
    
    public int verifValorInm(String valor,String tipo) {//REGRESA VALOR EN BYTES
    	int resp=0;
    	if(tipo.contains("CAR�CTER")) {
    		resp=valor.length()-2;
    	}else {
    		if(tipo.contains("HEXADECIMAL")) {
    			resp=(int)((valor.length()-2)/2);
    		}else {
    			if(tipo.contains("BINARIA")) {
    				resp=(int)((valor.length()-1)/8);
    			}else {
    				if(tipo.contains("DECIMAL")) {
    					if(Integer.parseInt(valor)<256) {
    						resp=1;
    					}else {
    						if(Integer.parseInt(valor)<65536) {
    							resp=2;
    						}
    					}
    				}
    			}
    		}
    	}
    	return resp;
    }
    
    public int verificaRegPermitido(String reg) {
    	if(reg.equals("ES") | reg.equals("es") | reg.equals("CS") | reg.equals("cs") | reg.equals("SS") | reg.equals("ss") | reg.equals("DS") | reg.equals("ds")) {
    		return 0;
    	}else {
    		return 1;
    	}
    }
    
    public String verificaInsLES(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()<4) {
    		if(elements.size()==3) {
    			//VERIFICA TIPO DE OPERANDOS
    			if(identificados.get(1).equals("REGISTRO") & (verificaRegPermitido(identificados.get(1))==1)) {//VERIFICA EL TIPO DE REGISTROS PERMITIDOS
    				int tamVar;
    				String valVar="";
    				String codMem="";
    				String tipo="";
    				String dirMem="";
    				if(elements.get(2).contains("[") & elements.get(2).contains("]")) {
    					int i=elements.get(2).indexOf("[");
    					String cad1=elements.get(2).substring(0,i);
    					tamVar=localizaVariable(cad1);
    					valVar=obtenValorVariable(cad1);
    					if(tamVar!=0) {
    						dirMem=obtenDirMemoria(cad1);
    						if(!valVar.contains("\"")) {
    							tamVar= tamVar/new StringTokenizer(valVar," ").countTokens();    //obtiene el tama�o de un elemento del vector
    						}else {
    							tamVar= tamVar/(valVar.length()-2);
    						}
    						codMem="00 110";// corresponde al mod y r/m
    						if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("DI")) {
    							codMem="00 101";
    						}else {
    							if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX")) {
    								codMem="00 111";
    							}else {
    								if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("SI")) {
    									codMem="00 100";
    								}else {
    									if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bp+si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BP+SI")) {
    										codMem="00 010";
    									}else {
    										if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bp+di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BP+DI")) {
    											codMem="00 011";
    										}else {
    											if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx+si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX+SI")) {
    	    										codMem="00 000";
    	    									}else {
    	    										if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx+di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX+DI")) {
    	    											codMem="00 001";
    	    										}
    	    									}
    										}
    									}
    								}
    							}
    						}
    					}
    				}else {
    					tamVar=localizaVariable(elements.get(2));
    					//M�TODO QUE SE ENCARGA DE OBTENER LA DIRECCI�N DE LA TABLA DE S�MBOLOS
    					dirMem=obtenDirMemoria(elements.get(2));
    					valVar=obtenValorVariable(elements.get(2));
    					codMem="00 110";// corresponde al mod y r/m
    				}
    				if(tamVar!=0) {//verificar
    					int tamReg=clasificaReg(elements.get(1));
    					if(tamVar==tamReg & tamReg==1) {
    						//CALCULA DIRECCI�N
        					String cod;
        					tipo=new Constante().verifCons(valVar);
        					if(tipo.equals("CONSTANTE CAR�CTER")) {//EN CASO NECESARIO SE REQUERIR� EL N�MERO DENTRO DEL PAR�NTESIS PARA SABER LA LOCALIDAD EXTRAIDA
        						valVar=Integer.toString(tamVar/(valVar.length()-2));
        					}else {
        						valVar=Integer.toString(tamVar);
        					}
    	        			cod=new Instrucción().calculaDirLES(elements.get(1),tamReg,dirMem,codMem);
    	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	        			lineas.add(cod.toUpperCase()+"H");
    	        			contadorProg= contadorProg+(cod.length()/2);
    					}else {                                    //CREAR UN M�TODO PARA EXTRAER LA DIRECCI�N
    						cadError="TAMA�O DE OPERANDOS DIFERENTE";
    					}
    				}else {
    					cadError="OPERANDO '"+elements.get(1)+"' NO PERMITIDO";
    				}
    			}else {
    				cadError="OPERANDO '"+elements.get(1)+"' NO PERMITIDO";
    			}
    		}else {
    			cadError="FALTA OPERANDO(S)";
    		}
    	}else {
    		cadError="N�MERO DE OPERANDOS EXCEDIDO";
    	}
    	return cadError;
    }
    
    public String verificaInsDEC(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()<3) {
    		if(elements.size()==2) {
    			if(identificados.get(1).equals("REGISTRO") & (verificaRegPermitido(identificados.get(1))==1)) {
    				//CALCULA DIRECCI�N
    				String cod;
    				int tamReg=clasificaReg(elements.get(1));
        			cod=new Instrucción().calculaDirDEC(elements.get(1),identificados.get(1),tamReg);
        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        			lineas.add(cod.toUpperCase()+"H");
        			contadorProg= contadorProg+(cod.length()/2);//NO HAY DESPLAZAMIENTO
    			}else {
    				int tamVar;
    				String valVar="";
    				String tipo="";
    				String dirMem="";
    				String codMem="";
    				if(elements.get(1).contains("[") & elements.get(2).contains("]")) {
    					int i=elements.get(1).indexOf("[");
    					String cad1=elements.get(1).substring(0,i);
    					tamVar=localizaVariable(cad1);
    					valVar=obtenValorVariable(cad1);
    					if(tamVar!=0) {
    						dirMem=obtenDirMemoria(cad1);
    						if(!valVar.contains("\"")) {
    							tamVar= tamVar/new StringTokenizer(valVar," ").countTokens();    //obtiene el tama�o de un elemento del vector
    						}else {
    							tamVar= tamVar/(valVar.length()-2);
    						}
    						codMem="00 110";// corresponde al mod y r/m
    						if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("DI")) {
    							codMem="00 101";
    						}else {
    							if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX")) {
    								codMem="00 111";
    							}else {
    								if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("SI")) {
    									codMem="00 100";
    								}else {
    									if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bp+si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BP+SI")) {
    										codMem="00 010";
    									}else {
    										if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bp+di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BP+DI")) {
    											codMem="00 011";
    										}else {
    											if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx+si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX+SI")) {
    	    										codMem="00 000";
    	    									}else {
    	    										if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx+di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX+DI")) {
    	    											codMem="00 001";
    	    										}
    	    									}
    										}
    									}
    								}
    							}
    						}
    					}
    				}else {
    					tamVar=localizaVariable(elements.get(1));
    					valVar=obtenValorVariable(elements.get(1));
    					dirMem=obtenDirMemoria(elements.get(1));
    					codMem="00 110";// corresponde al mod y r/m
    				}
    				if(tamVar!=0) {
    					//CALCULA DIRECCI�N
    					String cod;
    					tipo=new Constante().verifCons(valVar);
    					if(tipo.equals("CONSTANTE CAR�CTER")) {
    						valVar=Integer.toString(tamVar/(valVar.length()-2));
    					}else {
    						valVar=Integer.toString(tamVar);
    					}
    					cod=new Instrucción().calculaDirDEC(dirMem,codMem,tamVar);//ENV�A LA CANTIDAD DE BYTES Y QUE CONSTANTE ES
    					lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    					lineas.add(cod.toUpperCase()+"H");
            			contadorProg= contadorProg+(cod.length()/2);//CONSIDERAR DESPLAZAMIENTO
    				}else {
    					cadError="OPERANDO '"+elements.get(1)+"' NO PERMITIDO";
    				}
    			}
    		}else {
    			cadError="FALTA UN OPERANDO";
    		}
    	}else {
    		cadError="N�MERO DE OPERANDOS EXCEDIDO";
    	}
    	return cadError;
    }
    
    public String verificaInsRCL(ArrayList <String> elements,ArrayList <String> identificados) {//COMPLETAR
    	String cadError="";
    	if(elements.size()<4) {
    		if(elements.size()==3) {
    			if(identificados.get(1).equals("REGISTRO") & (verificaRegPermitido(identificados.get(1))==1)) {
    				int tamReg=clasificaReg(elements.get(1));
    				if(tamReg==1) {
    					//REVISA EL TIPO DE VALOR INMEDIATO Y TAMA�O
    					int valInmediato=verifValorInm(elements.get(2),identificados.get(2));
    					if(valInmediato==1) {
    						//CALCULA DIRECCI�N
    						String dir="";
    	        			dir=new Instrucción().calculaDirRCL(elements.get(1),identificados.get(1),elements.get(2),identificados.get(2));
    	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	        			lineas.add(dir.toUpperCase()+"H");
    	        			contadorProg= contadorProg+(dir.length()/2);
    					}else {
    						if(valInmediato==0) {
    							if(elements.get(2).equals("CL")|elements.get(2).equals("cl")) {
    								//CALCULA DIRECCI�N
    	    						String dir="";
    	    	        			dir=new Instrucción().calculaDirRCL(elements.get(1),identificados.get(1),elements.get(2),identificados.get(2));
    	    	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	    	        			lineas.add(dir.toUpperCase()+"H");
    	    	        			contadorProg= contadorProg+(int)(dir.length()/2);
    							}else {
    								if(localizaConstante(elements.get(2))==1) {
    									String dir="";
        	    	        			dir=new Instrucción().calculaDirRCL(elements.get(1),identificados.get(1),obtenValorVariable(elements.get(2)),identificados.get(2));
        	    	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        	    	        			lineas.add(dir.toUpperCase()+"H");
        	    	        			contadorProg= contadorProg+(int)(dir.length()/2);
    								}else {
    									cadError="OPERANDO '"+elements.get(2)+"'  NO PERMITIDO";
    								}
    							}
    						}else {
    							cadError="TAMA�O DE OPERANDOS DIFERENTE";
    						}
    					}
    				}else {
    					cadError="TAMA�O INCORRECTO DE REGISTRO";
    				}
    			}else {
    				int tamVar;
    				String dirMem="";
    				String codMem="";
    				String valVar="";
    				if(elements.get(1).contains("[") & elements.get(1).contains("]")) {
    					int i=elements.get(2).indexOf("[");
    					String cad1=elements.get(2).substring(0,i);
    					tamVar=localizaVariable(cad1);
    					valVar=obtenValorVariable(cad1);
    					if(tamVar!=0) {
    						dirMem=obtenDirMemoria(cad1);
    						if(!valVar.contains("\"")) {
    							tamVar= tamVar/new StringTokenizer(valVar," ").countTokens();    //obtiene el tama�o de un elemento del vector
    						}else {
    							tamVar= tamVar/(valVar.length()-2);
    						}
    						codMem="00 110";// corresponde al mod y r/m
    						if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("DI")) {
    							codMem="00 101";
    						}else {
    							if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX")) {
    								codMem="00 111";
    							}else {
    								if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("SI")) {
    									codMem="00 100";
    								}else {
    									if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bp+si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BP+SI")) {
    										codMem="00 010";
    									}else {
    										if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bp+di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BP+DI")) {
    											codMem="00 011";
    										}else {
    											if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx+si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX+SI")) {
    	    										codMem="00 000";
    	    									}else {
    	    										if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx+di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX+DI")) {
    	    											codMem="00 001";
    	    										}
    	    									}
    										}
    									}
    								}
    							}
    						}
    					}
    				}else {
    					tamVar=localizaVariable(elements.get(1));
    					//M�TODO QUE SE ENCARGA DE OBTENER LA DIRECCI�N DE LA TABLA DE S�MBOLOS
    					dirMem=obtenDirMemoria(elements.get(1));
    					valVar=obtenValorVariable(elements.get(1));
    					codMem="00 110";// corresponde al mod y r/m
    				}
					if(tamVar!=0) {
						if(tamVar==1) {
							int valInmediato=verifValorInm(elements.get(2),identificados.get(2));
	    					if(valInmediato==1) {
	    						//CALCULA DIRECCI�N
	    						String dir="";
	    	        			dir=new Instrucción().calculaDirRCL(dirMem,codMem,elements.get(2),identificados.get(2));//FALTA REVISAR 
	    	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
	    	        			lineas.add(dir.toUpperCase()+"H");
	    	        			contadorProg= contadorProg+(int)(dir.length()/2);
	    					}else {
	    						if(valInmediato==0) {
	    							if(elements.get(2).equals("CL")|elements.get(2).equals("cl")) {
	    								//CALCULA DIRECCI�N
	    	    						String dir="";
	    	    	        			dir=new Instrucción().calculaDirRCL(dirMem,codMem,elements.get(2),identificados.get(2));//
	    	    	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
	    	    	        			lineas.add(dir.toUpperCase()+"H");
	    	    	        			contadorProg= contadorProg+(int)(dir.length()/2);
	    							}else {
	    								cadError="OPERANDO '"+elements.get(2)+"'  NO PERMITIDO";
	    							}
	    						}else {
	    							if(localizaConstante(elements.get(2))==1) {
    									String dir="";
        	    	        			dir=new Instrucción().calculaDirRCL(elements.get(1),identificados.get(1),obtenValorVariable(elements.get(2)),identificados.get(2));
        	    	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        	    	        			lineas.add(dir.toUpperCase()+"H");
        	    	        			contadorProg= contadorProg+(int)(dir.length()/2);
    								}else {
    									cadError="OPERANDO '"+elements.get(2)+"'  NO PERMITIDO";
    								}
	    						}
	    					}
						}else {
							cadError="TAMA�O DEL OPERANDO '"+elements.get(1)+"' NO PERMITIDO";
						}
					}else {
						cadError="OPERANDO '"+elements.get(1)+"' NO PERMITIDO";
					}
    			}
    		}else {
    			cadError="FALTA OPERANDO(S)";
    		}
    	}else {
    		cadError="N�MERO DE OPERANDOS EXCEDIDO";
    	}
    	return cadError;
    }
    
    public String verificaInsXCHG(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()<4) {
    		if(elements.size()==3) {
    			if(identificados.get(1).equals("REGISTRO") & (verificaRegPermitido(identificados.get(1))==1)) {
    				int tamReg=clasificaReg(elements.get(1));
    				int val2=clasificaReg(elements.get(2));
    				if(val2!=0) {
    					if(val2==tamReg) {
    						//CALCULA DIRECCI�N
    						String cod;
    						cod=new Instrucción().calculaDirXCHG(elements.get(1),elements.get(2),identificados.get(2),tamReg);
    	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	        			lineas.add(cod.toUpperCase()+"H");
    	        			contadorProg= contadorProg+(cod.length()/2);
    					}else {
    						cadError="TAMA�O DE OPERANDOS DIFERENTE";
    					}
    				}else {
    					int tamVar;
        				String valVar="";
        				String tipo="";
        				String dirMem="";
        				String codMem="";
        				if(elements.get(2).contains("[")) {
        					int i=elements.get(2).indexOf("[");
        					String cad1=elements.get(2).substring(0,i);
        					tamVar=localizaVariable(cad1);
        					valVar=obtenValorVariable(cad1);
        					if(tamVar!=0) {
        						dirMem=obtenDirMemoria(cad1);
        						if(!valVar.contains("\"")) {
        							tamVar= tamVar/new StringTokenizer(valVar," ").countTokens();    //obtiene el tama�o de un elemento del vector
        						}else {
        							tamVar= tamVar/(valVar.length()-2);
        						}
        						codMem="00 110";// corresponde al mod y r/m
        						if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("DI")) {
        							codMem="00 101";
        						}else {
        							if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX")) {
        								codMem="00 111";
        							}else {
        								if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("SI")) {
        									codMem="00 100";
        								}else {
        									if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bp+si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BP+SI")) {
        										codMem="00 010";
        									}else {
        										if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bp+di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BP+DI")) {
        											codMem="00 011";
        										}else {
        											if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx+si")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX+SI")) {
        	    										codMem="00 000";
        	    									}else {
        	    										if(elements.get(2).substring(i+1,elements.get(2).length()-1).equals("bx+di")|elements.get(2).substring(i+1,elements.get(2).length()-1).equals("BX+DI")) {
        	    											codMem="00 001";
        	    										}
        	    									}
        										}
        									}
        								}
        							}
        						}
        					}
        				}else {
        					tamVar=localizaVariable(elements.get(2));
        					valVar=obtenValorVariable(elements.get(2));
        					dirMem=obtenDirMemoria(elements.get(2));
        					codMem="00 110";// corresponde al mod y r/m
        				}
        				if(tamVar!=0) {
        					if(tamVar==tamReg) {
        						//CALCULA DIRECCI�N
        						String cod;
            					tipo=new Constante().verifCons(valVar);
            					if(tipo.equals("CONSTANTE CAR�CTER")) {
            						valVar=Integer.toString(tamVar/(valVar.length()-2));
            					}else {
            							valVar=Integer.toString(tamVar);
            					}
        	        			cod=new Instrucción().calculaDirXCHG(elements.get(1),dirMem,codMem,tamReg);
        	        			lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        	        			lineas.add(cod.toUpperCase()+"H");
        	        			contadorProg= contadorProg+(cod.length()/2);
        					}else {
        						cadError="TAMA�O DE OPERANDOS DIFERENTE";
        					}
        				}else {
        					cadError="OPERANDO '"+elements.get(1)+"' NO PERMITIDO";
        				}
    				}
    			}else {
    				cadError="OPERANDO '"+elements.get(1)+"' NO PERMITIDO";
    			}
    		}else {
    			cadError="FALTA OPERANDO(S)";
    		}
    	}else {
    		cadError="N�MERO DE OPERANDOS EXCEDIDO";
    	}
    	return cadError;
    }
    
    public int verificaExistEtiqueta(String etiqueta) {
    	int valor=0,i,tam;
    	tam=tablaSc1.size();
    	for(i=0;i<tam;i++) {
    		if(tablaSc1.get(i).equals(etiqueta)&tablaSc2.get(i).equals("etiqueta")) {
    			valor=1;
    			i=tam;
    		}
    	}
    	return valor;
    }
    
    public String verificaInsJCXZ(ArrayList <String> elements,ArrayList <String> identificados) {//Por l�gica la etiqueta si se encuentra en la tabla est� antes que el salto
    	String cadError="";
    	if(elements.size()<3) {
    		if(elements.size()==2) {
    			int valor1=verificaExistEtiqueta(elements.get(1));//verifica exitencia de la etiqueta en la tabla
        		if(valor1==0) {
        			cadError="ETIQUETA NO DEFINIDA PREVIAMENTE";
        		}else {
        			String dir="";
        			dir=obtenDirMemoria(elements.get(1));
        			String dir1= dir.substring(0, 2);
        			String dir2= dir.substring(2, 4);
        			if(dir1.equals("00")) {
        				dir=new Instrucción().calculaDirJCXZ(dir2);
        				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        				lineas.add(dir.toUpperCase()+"H");
            			contadorProg= contadorProg+(int)(dir.length()/2);//SE SUMA UN BYTE DE DESPLAZAMIENTO
            			//DESPU�S CAMBIAR EL BYTE POR LA DIRECCI�N DE DESPLAZAMIENTO DE LA ETIQUETA
        			}else {
        				cadError="SALTO NO PERMITIDO";
        			}
        		}                                                      
    		}else {
    			cadError="FALTA UN OPERANDO";
    		}
    	}else {
    		cadError=identificados.get(0)+" CON EXCESO DE ELEMENTOS";
    	}
    	return cadError;
    }
    
    public String verificaInsJNA(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()<3) {
    		if(elements.size()==2) {
    			int valor1=verificaExistEtiqueta(elements.get(1));
        		if(valor1==0) {
        			cadError="ETIQUETA NO DEFINIDA PREVIAMENTE";
        		}else {
        			String dir="";
        			dir=obtenDirMemoria(elements.get(1));
        			String dir1= dir.substring(0, 2);
        			String dir2= dir.substring(2, 4);
        			if(dir1.equals("00")) {
        				dir=new Instrucción().calculaDirJNA(dir2);
        				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        				lineas.add(dir.toUpperCase()+"H");
            			contadorProg= contadorProg+(int)(dir.length()/2);//SE SUMA UN BYTE DE DESPLAZAMIENTO
            			//DESPU�S CAMBIAR EL BYTE POR LA DIRECCI�N DE DESPLAZAMIENTO DE LA ETIQUETA
        			}else {
        				cadError="SALTO NO PERMITIDO";
        			}
        		}
    		}else {
    			cadError="FALTA UN OPERANDO";
    		}
    	}else {
    		cadError=identificados.get(0)+" CON EXCESO DE ELEMENTOS";
    	}
    	return cadError;
    }
    
    public String verificaInsJNLE(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()<3) {
    		if(elements.size()==2) {
    			int valor1=verificaExistEtiqueta(elements.get(1));
        		if(valor1==0) {
        			cadError="ETIQUETA NO DEFINIDA PREVIAMENTE";
        		}else {
        			String dir="";
        			dir=obtenDirMemoria(elements.get(1));
        			String dir1= dir.substring(0, 2);
        			String dir2= dir.substring(2, 4);
        			if(dir1.equals("00")) {
        				dir=new Instrucción().calculaDirJNLE(dir2);
        				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        				lineas.add(dir.toUpperCase()+"H");
            			contadorProg= contadorProg+(int)(dir.length()/2);//SE SUMA UN BYTE DE DESPLAZAMIENTO
            			//DESPU�S CAMBIAR EL BYTE POR LA DIRECCI�N DE DESPLAZAMIENTO DE LA ETIQUETA
        			}else {
        				cadError="SALTO NO PERMITIDO";
        			}
        		}
    		}else {
    			cadError="FALTA UN OPERANDO";
    		}
    	}else {
    		cadError=identificados.get(0)+" CON EXCESO DE ELEMENTOS";
    	}
    	return cadError;
    }
    
    public String verificaInsJS(ArrayList <String> elements,ArrayList <String> identificados) {
    	String cadError="";
    	if(elements.size()<3) {
    		if(elements.size()==2) {
    			int valor1=verificaExistEtiqueta(elements.get(1));
        		if(valor1==0) {
        			cadError="ETIQUETA NO DEFINIDA PREVIAMENTE";
        		}else {
        			String dir="";
        			dir=obtenDirMemoria(elements.get(1));
        			String dir1= dir.substring(0, 2);
        			String dir2= dir.substring(2, 4);
        			if(dir1.equals("00")) {
        				dir=new Instrucción().calculaDirJS(dir2);
        				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
        				lineas.add(dir.toUpperCase()+"H");
            			contadorProg= contadorProg+(int)(dir.length()/2);//SE SUMA UN BYTE DE DESPLAZAMIENTO
            			//DESPU�S CAMBIAR EL BYTE POR LA DIRECCI�N DE DESPLAZAMIENTO DE LA ETIQUETA
        			}else {
        				cadError="SALTO NO PERMITIDO";
        			}
        		}
    		}else {
    			cadError="FALTA UN OPERANDO";
    		}
    	}else {
    		cadError=identificados.get(0)+" CON EXCESO DE ELEMENTOS";
    	}
    	return cadError;
    }
    
    public String verificaEtiqueta(ArrayList <String> elements,ArrayList <String> identificados,String linea) {
    	String cadError="";
    	if(elements.size()<2) {
    		//verifica que es una etiqueta
    		int tam,i;
    		tam=linea.length();
    		i=elements.get(0).length();
    		if(i<tam) {
    			String c=linea.substring(i, i+1);
    			if(!c.equals(":")) {
    				cadError=identificados.get(0)+" NO V�LIDO";
    			}else {
    				llenaTabla(elements.get(0), "etiqueta", "-", "-",completaContador(Integer.toHexString(contadorProg)));
    				lineas.add("");
    				lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    			}
    		}else {
    			cadError=identificados.get(0)+" NO V�LIDO";
    		}
    	}else {
    		cadError=identificados.get(0)+" NO V�LIDO";
    	}
    	return cadError;
    }
    
    public void trataCodeSeg(ArrayList <String> elements,ArrayList <String> identificados,String linea) {
    	String cadError="";
    	if(elements.get(0).equals("AAM")|elements.get(0).equals("aam")) {//Identifica desde el primer elemento de la linea
			cadError= verificaInsAAM(elements,identificados);
		}else {
			if(elements.get(0).equals("CWD")|elements.get(0).equals("cwd")) {
				cadError=verificaInsCWD(elements,identificados);
			}else {
				if(elements.get(0).equals("LODSB")|elements.get(0).equals("lodsb")) {
					cadError=verificaInsLODSB(elements,identificados);
				}else {
					if(elements.get(0).equals("RET")|elements.get(0).equals("ret")) {
						cadError=verificaInsRET(elements,identificados);
					}else {
						if(elements.get(0).equals("LES")|elements.get(0).equals("les")) {
							cadError=verificaInsLES(elements,identificados);
						}else {
							if(elements.get(0).equals("DEC")|elements.get(0).equals("dec")) {
								cadError=verificaInsDEC(elements,identificados);
							}else {
								if(elements.get(0).equals("RCL")|elements.get(0).equals("rcl")) {
									cadError=verificaInsRCL(elements,identificados);
								}else {
									if(elements.get(0).equals("XCHG")|elements.get(0).equals("xchg")) {
										cadError=verificaInsXCHG(elements,identificados);
									}else {
										if(elements.get(0).equals("JCXZ")|elements.get(0).equals("jcxz")) {
											cadError=verificaInsJCXZ(elements,identificados);
										}else {
											if(elements.get(0).equals("JNA")|elements.get(0).equals("jna")) {
												cadError=verificaInsJNA(elements,identificados);
											}else {
												if(elements.get(0).equals("JNLE")|elements.get(0).equals("jnle")) {
													cadError=verificaInsJNLE(elements,identificados);
												}else {
													if(elements.get(0).equals("JS")|elements.get(0).equals("js")) {
														cadError=verificaInsJS(elements,identificados);
													}else {
														if(identificados.get(0).equals("S�MBOLO")) {
															cadError=verificaEtiqueta(elements,identificados,linea);
														}else {
															cadError=identificados.get(0)+" NO V�LIDO"; //TEMPORALMENTE S�LO INSTRUCCIONES (INCLUIR PROC O ENDP)
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
    	if(!cadError.equals("")) {
    		lineas.add(cadError);
    		lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
    	}
    }
    
    public void analisis(ArrayList <String>a1,ArrayList <String>a2,ArrayList <String>a3) {
    	elementSeparados=a1;
    	elementIdentificados=a2;
    	lineasOrigen=a3;
    	lineasContador.clear();
    	String cadError="",cadSegment="";
    	ArrayList <String> elementosData= new ArrayList<String>();
    	ArrayList <String> elementosDataIdent= new ArrayList<String>();
    	ArrayList <String> elementosStack= new ArrayList<String>();
    	ArrayList <String> elementosStackIdent= new ArrayList<String>();
    	ArrayList <String> elementosCode= new ArrayList<String>();
    	ArrayList <String> elementosCodeIdent= new ArrayList<String>();
    	String cadena1="";
    	int i,g=0,b1=0,b2=0,b3=0,bData=0,bStack=0,bCode=0;
    	for(int a=0;a< lineasOrigen.size();a++) {
    		cadena1=lineasOrigen.get(a);
    		if(!cadena1.isEmpty()) { //Se rechazan las cadenas vac�as
    			cadena1=cadena1.trim();//Elimina espacios al inicio y final de la cadena
      			 if(!cadena1.startsWith(";")) {
      				 if(cadena1.contains(";")) {//Identifica todas las l�neas que tengan comentarios
      				 cadena1=cadena1.split(";")[0].trim();
      				 }
      				 int iCad1=-1,sigLinea=0;
      				 elementosData.clear();
      				 elementosDataIdent.clear();
      				 elementosStack.clear();
      				 elementosStackIdent.clear();
      				 elementosCode.clear();
     				 elementosCodeIdent.clear();
      				 for(i=g;i< elementSeparados.size()&sigLinea==0;i++) {
      					 iCad1=cadena1.indexOf(elementSeparados.get(i),iCad1+1);
      					 if(iCad1!=-1) {
      						if((elementSeparados.get(i).equals("DATA SEGMENT")|elementSeparados.get(i).equals("data segment")|bData==1)&(b1==0)) {//REVISAR CONDICI�N
      						//REVISAR SI UNA VEZ LE�DO UN DATA SEGMENT SE REQUIERE AVISAR QUE LA SECCI�N EST� REPETIDA
      							if((elementSeparados.get(i).equals("DATA SEGMENT")|elementSeparados.get(i).equals("data segment"))&(cadena1.equals("DATA SEGMENT")|cadena1.equals("data segment"))&(bData==0)) {//CONDICI�N ACTUALIZADA
      								cadSegment="DATA SEGMENT";
      								bData=1;
      								contadorProg=0;
      							}else {
      								if(elementSeparados.get(i).equals("ENDS")|elementSeparados.get(i).equals("ends")) {//REVISAR PORQUE NO APARECE EN PANTALLA
              		    				cadSegment="ENDS DATA SEGMENT";
              		    				bData=0;
              		    				b1=1;
              		    			}else {
              		    				if(!elementSeparados.get(i).equals("DATA SEGMENT")&!elementSeparados.get(i).equals("data segment")) {
                  		    				elementosData.add(elementSeparados.get(i));
                  		    				elementosDataIdent.add(elementIdentificados.get(i));
                  		    			}else {
                  		    				if(elementSeparados.get(i).equals("DATA SEGMENT")|elementSeparados.get(i).equals("data segment")) {
                  		    					cadError="PSEUDOINSTRUCCI�N '"+elementSeparados.get(i)+"' REPETIDA";
                  		    				}else {
                  		    					if(elementSeparados.get(i).equals("STACK SEGMENT")|elementSeparados.get(i).equals("stack segment")) {
                      		    					b1=1;
                      		    					i=i-1;
                      		    					cadError="FALTA PSEUDOINSTRUCCI�N 'ENDS'";
                      		    				}else {
                      		    					if(elementSeparados.get(i).equals("CODE SEGMENT")|elementSeparados.get(i).equals("code segment")) {
                          		    					b1=1;
                          		    					i=i-1;
                          		    					cadError="FALTA PSEUDOINSTRUCCI�N 'ENDS'";
                          		    				}else {
                          		    					cadError="ELEMENTO INV�LIDO";
                          		    				}
                      		    				}
                  		    				}
                  		    			}
              		    			}
      							}
          		    		}else {
          		    			if((elementSeparados.get(i).equals("SATCK SEGMENT")|elementSeparados.get(i).equals("stack segment")|bStack==1)&(b2==0)) {
          		    			    //REVISAR SI UNA VEZ LE�DO UN DATA SEGMENT SE REQUIERE AVISAR QUE LA SECCI�N EST� REPETIDA
          		    				if((elementSeparados.get(i).equals("STACK SEGMENT")|elementSeparados.get(i).equals("stack segment"))&(cadena1.equals("STACk SEGMENT")|cadena1.equals("stack segment"))&(bStack==0)) {
          								cadSegment="STACK SEGMENT";
          								bStack=1;
          							}else {
          								if(elementSeparados.get(i).equals("ENDS")|elementSeparados.get(i).equals("ends")) {
          									cadSegment="ENDS STACK SEGMENT";
                  		    				bStack=0;
                  		    				b2=1;
                  		    			}else {
                  		    				if(!elementSeparados.get(i).equals("STACK SEGMENT")&!elementSeparados.get(i).equals("stack segment")) {
                  		    					elementosStack.add(elementSeparados.get(i));
                      		    				elementosStackIdent.add(elementIdentificados.get(i));
                      		    			}else {
                      		    				if(elementSeparados.get(i).equals("STACK SEGMENT")|elementSeparados.get(i).equals("stack segment")) {
                      		    					cadError="PSEUDOINSTRUCCI�NN '"+elementSeparados.get(i)+"' REPETIDA";
                      		    				}else {
                      		    					if(elementSeparados.get(i).equals("DATA SEGMENT")|elementSeparados.get(i).equals("data segment")) {
                          		    					b2=1;
                          		    					i=i-1;
                          		    					cadError="FALTA PSEUDOINSTRUCCI�N 'ENDS'";
                          		    				}else {
                          		    					if(elementSeparados.get(i).equals("CODE SEGMENT")|elementSeparados.get(i).equals("code segment")) {
                              		    					b2=1;
                              		    					i=i-1;
                              		    					cadError="FALTA PSEUDOINSTRUCCI�N 'ENDS'";
                              		    				}
                          		    				}
                      		    				}
                      		    			}
                  		    			}
          							}
          		    			}else {
          		    				if((elementSeparados.get(i).equals("CODE SEGMENT")|elementSeparados.get(i).equals("code segment")|bCode==1)&(b3==0)) {
          		    				//REVISAR SI UNA VEZ LE�DO UN DATA SEGMENT SE REQUIERE AVISAR QUE LA SECCI�N EST� REPETIDA
              		    				if((elementSeparados.get(i).equals("CODE SEGMENT")|elementSeparados.get(i).equals("code segment"))&(cadena1.equals("CODE SEGMENT")|cadena1.equals("code segment"))&(bCode==0)) {
              								cadSegment="CODE SEGMENT";
              								bCode=1;
              							}else {
              								if(elementSeparados.get(i).equals("ENDS")|elementSeparados.get(i).equals("ends")) {
              									cadSegment="ENDS CODE SEGMENT";
                      		    				bCode=0;
                      		    				b3=1;
                      		    			}else {
                      		    				if(!elementSeparados.get(i).equals("CODE SEGMENT")&!elementSeparados.get(i).equals("code segment")) {
                      		    					elementosCode.add(elementSeparados.get(i));
                          		    				elementosCodeIdent.add(elementIdentificados.get(i));
                          		    			}else {
                          		    				if(elementSeparados.get(i).equals("CODE SEGMENT")|elementSeparados.get(i).equals("code segment")) {
                          		    					cadError="PSEUDOINSTRUCCI�NN '"+elementSeparados.get(i)+"' REPETIDA";
                          		    				}else {
                          		    					if(elementSeparados.get(i).equals("DATA SEGMENT")|elementSeparados.get(i).equals("data segment")) {
                              		    					b2=1;
                              		    					i=i-1;
                              		    					cadError="FALTA PSEUDOINSTRUCCI�N 'ENDS'";
                              		    				}else {
                              		    					if(elementSeparados.get(i).equals("CODE SEGMENT")|elementSeparados.get(i).equals("stack segment")) {
                                  		    					b2=1;
                                  		    					i=i-1;
                                  		    					cadError="FALTA PSEUDOINSTRUCCI�N 'ENDS'";
                                  		    				}
                              		    				}
                          		    				}
                          		    			}
                      		    			}
              							}
          		    				}else {
          		    					if((elementSeparados.get(i).equals("ENDS")|elementSeparados.get(i).equals("ends"))&cadena1.equals(elementSeparados.get(i))) {
          		    						cadError="PSEUDOINSTRUCCI�N 'ENDS' REPETIDA";
          		    					}else {
          		    						cadError="ELEMENTO INV�LIDO";
          		    					}
          		    				}
          		    			}
          		    		}
      					 }else {
      						 if(elementosData.size()!=0) {//ACTUALIZAR AL CONSIDERAR CODE SEGMENT
      							 trataDataSeg(elementosData,elementosDataIdent);
      						 }else {
      							 if(elementosStack.size()!=0) {
      								 trataStackSeg(elementosStack,elementosStackIdent);//verificar si s�lo se lee una l�nea en segmento
      							 }else {
      								if(elementosCode.size()!=0) {
      									trataCodeSeg(elementosCode,elementosCodeIdent,cadena1);
      								}else {
      									if(cadSegment!="") {
      										lineas.add("");
      										if(cadSegment.equals("STACK SEGMENT")||cadSegment.equals("CODE SEGMENT")) {
      											lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
      											contadorProg=0;
      										}else {
      											lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
      										}
      										cadSegment="";
      									}else {
      										if(cadError!="") {
      											lineas.add(cadError);
      											lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
         									}else {
         										lineas.add("");//CAMBIAR CADENA A INV�LIDA
         										lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
         									}
      									}
      								}
      							 }
      						 }
      						 sigLinea=1;
      						 g=i;
      					 }
      		    	}
      			 }else {
      				 lineas.add("");
      				 lineasContador.add("");
      			 }
      		 }else {
      			 lineas.add("");
      			 lineasContador.add("");
      		 }
    	}
    	if(elementosData.size()!=0) {//ACTUALIZAR EN CASO DE USAR CODE SEGMENT
    		trataDataSeg(elementosData,elementosDataIdent);
		}else {
			if(elementosStack.size()!=0) {
				trataStackSeg(elementosStack,elementosStackIdent);
			}else {
				if(elementosCode.size()!=0) {
					trataCodeSeg(elementosCode,elementosCodeIdent,cadena1);
				}else {
					if(cadSegment!="") {
						lineas.add("");
						if(cadSegment.equals("STACK SEGMENT")||cadSegment.equals("CODE SEGMENT")) {
							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
							contadorProg=0;
						}else {
							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
						}
						cadSegment="";
					}else {
						if(cadError!="") {
							lineas.add(cadError);
							lineasContador.add(completaContador(Integer.toHexString(contadorProg)).toUpperCase());
						}else {
							lineas.add("");
							lineasContador.add("");
						}
					}
				}
			}
		}
    	textarea1.setEnabled(true);
        textarea2.setEnabled(true);
        textarea3.setEnabled(true);
        int i2=0;
        for(i2=0;i2<NUM_LIN_MAX && i2<lineas.size();i2++) {
        	textarea1.append(lineasOrigen.get(i2)+"\n");
        	textarea2.append(lineas.get(i2)+"\n");
        	textarea3.append(lineasContador.get(i2)+"\n");
        }
        if(i2!=lineas.size()) {
        	numLin=i2;
        	botonPagSiguiente.setEnabled(true);
        }
        llenaTabla();
    }
    
    private void llenaTabla() {
    	texta1.setEnabled(true);
    	texta2.setEnabled(true);
    	texta3.setEnabled(true);
    	texta4.setEnabled(true);
    	texta5.setEnabled(true);
    	int i=0;
    	for(i=0;i<NUM_LIN_MAX_T && i<tablaSc1.size();i++) {
    		texta1.append(tablaSc1.get(i)+"\n");
    		texta2.append(tablaSc2.get(i)+"\n");
    		texta3.append(tablaSc3.get(i)+"\n");
    		texta4.append(tablaSc4.get(i)+"\n");
    		texta5.append(tablaSc5.get(i)+"\n");
    	}
    	if(i!=tablaSc1.size()) {
    		numLinT=i;
    		botonPagSig.setEnabled(true);
    	}
    }
    
    private void botonPagAnteriorActionPerformed() {//MUEVE A LA P�GINA ANTERIOR
    	int i,valAux;
    	textarea1.setText("");
    	textarea2.setText("");
    	textarea3.setText("");
    	botonPagSiguiente.setEnabled(true);
    	valAux=numLin-NUM_LIN_MAX;
    	for(i=0;i<NUM_LIN_MAX;i++) {
    		textarea1.append(lineasOrigen.get(valAux)+"\n");
    		textarea2.append(lineas.get(valAux)+"\n");
    		textarea3.append(lineasContador.get(valAux)+"\n");
    		valAux++;
    		numLin--;
   	    }
    	if(numLin==0) {
    		botonPagAnterior.setEnabled(false);
    		numLin=NUM_LIN_MAX;
    	}
    }
    
    private void botonPagAntActionPerformed() {//ACTUALIZAR CUANDO SE ACTIVE LA QUINTA COLUMNA
    	int i,valAux;
    	texta1.setText("");
    	texta2.setText("");
    	texta3.setText("");
    	texta4.setText("");
    	texta5.setText("");
    	botonPagSig.setEnabled(true);
    	valAux=numLinT-NUM_LIN_MAX_T;
    	for(i=0;i<NUM_LIN_MAX_T;i++) {
    		texta1.append(tablaSc1.get(valAux)+"\n");
    		texta2.append(tablaSc2.get(valAux)+"\n");
    		texta3.append(tablaSc3.get(valAux)+"\n");
    		texta4.append(tablaSc4.get(valAux)+"\n");
    		texta5.append(tablaSc5.get(valAux)+"\n");
    		valAux++;
    		numLinT--;
   	    }
    	if(numLinT==0) {
    		botonPagAnt.setEnabled(false);
    		numLin=NUM_LIN_MAX_T;
    	}
    }
    
    private void botonPagSiguienteActionPerformed() {//MUEVE A LA P�GINA SIGUIENTE
    	int tam,i;
    	tam=lineas.size();
    	textarea1.setText("");
    	textarea2.setText("");
    	textarea3.setText("");
    	botonPagAnterior.setEnabled(true);
    	for(i=0;i<NUM_LIN_MAX && numLin<tam;i++) {
    		textarea1.append(lineasOrigen.get(numLin)+"\n");
    		textarea2.append(lineas.get(numLin)+"\n");
    		textarea3.append(lineasContador.get(numLin)+"\n");
    		numLin++;
   	    }
    	if(numLin==tam) {
    		botonPagSiguiente.setEnabled(false);
    		numLin=numLin-i;
    	}
    }
    
    private void botonPagSigActionPerformed() {//ACTUALIZAR CUANDO SE ACTIVE LA QUINTA COLUMNA
    	int tam,i;
    	tam=tablaSc1.size();
    	texta1.setText("");
    	texta2.setText("");
    	texta3.setText("");
    	texta4.setText("");
    	texta5.setText("");
    	botonPagAnt.setEnabled(true);
    	for(i=0;i<NUM_LIN_MAX_T && numLinT<tam;i++) {
    		texta1.append(tablaSc1.get(numLinT)+"\n");
    		texta2.append(tablaSc2.get(numLinT)+"\n");
    		texta3.append(tablaSc3.get(numLinT)+"\n");
    		texta4.append(tablaSc4.get(numLinT)+"\n");
    		texta5.append(tablaSc5.get(numLinT)+"\n");
    		numLinT++;
   	    }
    	if(numLinT==tam) {
    		botonPagSig.setEnabled(false);
    		numLinT=numLinT-i;
    	}
    }

}

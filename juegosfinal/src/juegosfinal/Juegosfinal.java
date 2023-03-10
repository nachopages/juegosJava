package juegosfinal;

import javax.swing.*;

class Juegosfinal {

	public static void main(String[] args) {	
	    
		int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione un juego:\n"
                    + "1. Ahorcado\n"
                    + "2. Wordle\n"
                    + "3. Salir"));
            switch (opcion) {
                case 1:
                    jugarAhorcado();
                    break;
                case 2:
                    jugarWordle();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

	
	
	
	public static void jugarAhorcado() {
		String[] p =  {"ahorrar","conocer","proceso","sistema","impacto", "resumen", "abrazos"};
		String[][] letras = {{"a","h","o","r","r","a","r"}, {"c","o","n","o","c","e","r"}, {"p","r","o","c","e","s","o"},{"s","i","s","t","e","m","a"},{"i","m","p","a","c","t","o"},{"r","e","s","u","m","e","n"},{"a","b","r","a","z","o","s"}};
		
		String pr="",li,info="";
		
		int nr,img=1,c=0;

		String[] nuevoArray = new String[p.length];
		boolean jg=false;
		int intentos=0;
		
		JOptionPane.showMessageDialog(null, "Usted eligio el ahorcado! Pulse enter para continuar", "Info juego", JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/ahorcado.gif")));
		
		JOptionPane.showMessageDialog(null, "el juego es facil, tendras que ingresar una letra y si es correcta podras ver el progreso de la palabra"+"\nSi se te acaban los 6 intentos perdes el juego.","REGLAS",JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/abc.gif")));
		
		
	
		String [] aciertos=new String[7];
		String [] fallos=new String[7];
		
		for (int i = 0; i < aciertos.length; i++) {
			aciertos[i]="_";
			fallos[i]="";
			
		}
		nr=(int)(Math.random()*p.length);
		pr=p[nr];
		
		while (intentos<6&&jg==false) {
			
			li=JOptionPane.showInputDialog("ingrese una letra");
		
			boolean adivino=false;
			int posicion=-1;
			
							
			for (int i = 0; i <letras.length; i++) {
					if (letras[nr][i].equalsIgnoreCase(li)) {
						aciertos[i]=li;
						posicion=i;
						adivino=true;
						c++;
					}
			}
			
			for (int i = 0; i < aciertos.length; i++) {
				if (c==aciertos.length) {
					jg=true;
				}
			}
	
			if (adivino==false) {
				for (int i = 0; i < fallos.length; i++) {
					if (posicion==-1) {
						fallos[i]+=" "+li;
						i=8;
					}
				}
				intentos++;
				info="letra incorrecta!";
				img++;
			}else {
				info="letra correcta!";
			}

			JOptionPane.showMessageDialog(null, aciertos[0]+" "+aciertos[1]+" "+aciertos[2]+" "+aciertos[3]+" "+aciertos[4]+" "+aciertos[5]+" "+aciertos[6]+"\n"+info+"\nLetras incorrectas: \n"+fallos[0]+" "+fallos[1]+" "+fallos[2]+" "+fallos[3]+" "+fallos[4]+" "+fallos[5]+" "+fallos[6],"info partida",JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/img"+img+".png")));
		}
		
		if (jg==true) {
			JOptionPane.showMessageDialog(null, "Ganaste!"+"\nLa palabra era "+pr, "¡¡GANASTE!!",JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/ganaste.gif")));
			//saco la palabra del array
			int indiceEliminar=-1;
			
			for (int i = 0; i < p.length; i++) {
				if (p[i].equalsIgnoreCase(pr)) {
					indiceEliminar=i;
				}
			}
			
			if (indiceEliminar>=0) {
				
				int j = 0;
				for (int i = 0; i < p.length; i++) {
					if (i!=indiceEliminar) {
						nuevoArray[j]=p[i];
						j++;
					}
					
				}
				p=nuevoArray;
			}
			
			
		} else if (intentos==6) {
			JOptionPane.showMessageDialog(null, "No te quedan mas intentos! la palabra era "+pr, "¡¡PERDISTE!!",JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/gameover.gif")));;
		} 
	}
	
	public static void jugarWordle() {
		
		String [] p = {"barco","actor","angel","artes"};
		String [][] letras= {{"b","a","r","c","o"}, {"a","c","t","o","r"}, {"a","n","g","e","l"}, {"a","r","t","e","s"}};

		String[][] letrasingresadas=new String[6][5];
		String[][] letrasincorrectas=new String[6][5];
		String[][] letrasmalposicionadas=new String[6][5];

		
		String pr="",li;
		int nr, intentos=0,columna=0,c=0;
		
		boolean jg=false;
		
		JOptionPane.showMessageDialog(null, "Usted eligio el Wordle! Pulse enter para continuar", "Info juego", JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/wordle.jpg")));
		
		JOptionPane.showMessageDialog(null, "El juego es asi, se genera una palabra al azar y se le va a pedir que ingrese 5 letras. Luego de haber ingresado 5 letras, podras ver que letras no forman parte de la palabra y que letras forman parte de la palabra pero estan mal posicionadas","reglas",JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/atencion.gif")));
		
		nr=(int)(Math.random()*p.length);
		pr=p[nr];
		System.out.print(pr);
		
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				letrasingresadas[i][j]="_";
				letrasincorrectas[i][j]="";
				letrasmalposicionadas[i][j]="";
			}
		}
		
		
		while (intentos<6&&jg==false) {
			
			for (int i = 0; i < 5; i++) {
				li=JOptionPane.showInputDialog("ingrese letra numero"+(i+1));

				letrasingresadas[columna][i]=li;
				int posicion = -1,indiceMalPosicionadas=0;

				if (letras[nr][i].equalsIgnoreCase(li)) {
					c++;
				}
				
				if (c==5) {
					jg=true;
				}
				
			

				//for y for anidado, suma letras incorrectas y letras correctas pero mal posicionadas a las matrices
				for (int j = 0; j < 5; j++) {
					if (li.equalsIgnoreCase(letras[nr][j])) {
		                if (i != j) {
		                    letrasmalposicionadas[columna][indiceMalPosicionadas++] +=" "+ li;
		                }
		            }

					//suma letras que no estan en ninguna posicion de la matriz letras a la matriz letras incorrectas
				    if (letras[nr][j].equals(li)) {
				        posicion = j;
				        j=6; // Termina el ciclo cuando encontramos la letra en el array
				    }
				}

				if (posicion == -1) {
					letrasincorrectas[columna][i]+=li;
				} 
			}

			//muestro cada matriz con todos los intentos en una misma ventana
			if (columna==0) {
				
				JOptionPane.showMessageDialog(null, letrasingresadas[0][0]+" "+letrasingresadas[0][1]+" "+letrasingresadas[0][2]+" "+letrasingresadas[0][3]+" "+letrasingresadas[0][4]+
													"\nLetras incorrectas:"+"\n"+
													letrasincorrectas[0][0]+" "+letrasincorrectas[0][1]+" "+letrasincorrectas[0][2]+" "+letrasincorrectas[0][3]+" "+letrasincorrectas[0][4]+
													"\nLetras correctas pero mal posicionadas: "+"\n"+
													letrasmalposicionadas[0][0]+" "+letrasmalposicionadas[0][1]+" "+letrasmalposicionadas[0][2]+" "+letrasmalposicionadas[0][3]+" "+letrasmalposicionadas[0][4]);
				
				columna=columna+1;
			
				
			} else if (columna==1) {
				
				JOptionPane.showMessageDialog(null, letrasingresadas[0][0]+" "+letrasingresadas[0][1]+" "+letrasingresadas[0][2]+" "+letrasingresadas[0][3]+" "+letrasingresadas[0][4]+
												"\n"+letrasingresadas[1][0]+" "+letrasingresadas[1][1]+" "+letrasingresadas[1][2]+" "+letrasingresadas[1][3]+" "+letrasingresadas[1][4]+
												"\nLetras incorrectas"+"\n"+"\n"+
												letrasincorrectas[0][0]+" "+letrasincorrectas[0][1]+" "+letrasincorrectas[0][2]+" "+letrasincorrectas[0][3]+" "+letrasincorrectas[0][4]+
												"\n"+
												letrasincorrectas[1][0]+" "+letrasincorrectas[1][1]+" "+letrasincorrectas[1][2]+" "+letrasincorrectas[1][3]+" "+letrasincorrectas[1][4]+
												"\nLetras correctas pero mal posicionadas"+"\n"+"\n"+
												letrasmalposicionadas[0][0]+" "+letrasmalposicionadas[0][1]+" "+letrasmalposicionadas[0][2]+" "+letrasmalposicionadas[0][3]+" "+letrasmalposicionadas[0][4]+
												"\n"+
												letrasmalposicionadas[1][0]+" "+letrasmalposicionadas[1][1]+" "+letrasmalposicionadas[1][2]+" "+letrasmalposicionadas[1][3]+" "+letrasmalposicionadas[1][4]);
				
				columna=columna+1;
			
			} else if (columna==2) {
				
				JOptionPane.showMessageDialog(null, letrasingresadas[0][0]+" "+letrasingresadas[0][1]+" "+letrasingresadas[0][2]+" "+letrasingresadas[0][3]+" "+letrasingresadas[0][4]+
												"\n"+letrasingresadas[1][0]+" "+letrasingresadas[1][1]+" "+letrasingresadas[1][2]+" "+letrasingresadas[1][3]+" "+letrasingresadas[1][4]+
												"\n"+letrasingresadas[2][0]+" "+letrasingresadas[2][1]+" "+letrasingresadas[2][2]+" "+letrasingresadas[2][3]+" "+letrasingresadas[2][4]+
												"\nLetras incorrectas"+"\n"+
												letrasincorrectas[0][0]+" "+letrasincorrectas[0][1]+" "+letrasincorrectas[0][2]+" "+letrasincorrectas[0][3]+" "+letrasincorrectas[0][4]+
												"\n"+
												letrasincorrectas[1][0]+" "+letrasincorrectas[1][1]+" "+letrasincorrectas[1][2]+" "+letrasincorrectas[1][3]+" "+letrasincorrectas[1][4]+
												"\n"+
												letrasincorrectas[2][0]+" "+letrasincorrectas[2][1]+" "+letrasincorrectas[2][2]+" "+letrasincorrectas[2][3]+" "+letrasincorrectas[2][4]+
												
												"\nLetras correctas pero mal posicionadas"+"\n"+
												letrasmalposicionadas[0][0]+" "+letrasmalposicionadas[1][1]+" "+letrasmalposicionadas[1][2]+" "+letrasmalposicionadas[1][3]+" "+letrasmalposicionadas[1][4]+
												"\n"+
												letrasmalposicionadas[1][0]+" "+letrasmalposicionadas[2][1]+" "+letrasmalposicionadas[2][2]+" "+letrasmalposicionadas[2][3]+" "+letrasmalposicionadas[2][4]+
												"\n"+
												letrasmalposicionadas[2][0]+" "+letrasmalposicionadas[3][1]+" "+letrasmalposicionadas[3][2]+" "+letrasmalposicionadas[3][3]+" "+letrasmalposicionadas[3][4]
												);
				columna=columna+1;
				
			} else if (columna==3) {
				
				JOptionPane.showMessageDialog(null, letrasingresadas[0][0]+" "+letrasingresadas[0][1]+" "+letrasingresadas[0][2]+" "+letrasingresadas[0][3]+" "+letrasingresadas[0][4]+
												"\n"+letrasingresadas[1][0]+" "+letrasingresadas[1][1]+" "+letrasingresadas[1][2]+" "+letrasingresadas[1][3]+" "+letrasingresadas[1][4]+
												"\n"+letrasingresadas[2][0]+" "+letrasingresadas[2][1]+" "+letrasingresadas[2][2]+" "+letrasingresadas[2][3]+" "+letrasingresadas[2][4]+
												"\n"+letrasingresadas[3][0]+" "+letrasingresadas[3][1]+" "+letrasingresadas[3][2]+" "+letrasingresadas[3][3]+" "+letrasingresadas[3][4]+
												"\nLetras incorrectas"+"\n"+
												"\n"+
												letrasincorrectas[0][0]+" "+letrasincorrectas[0][1]+" "+letrasincorrectas[0][2]+" "+letrasincorrectas[0][3]+" "+letrasincorrectas[0][4]+
												"\n"+
												letrasincorrectas[1][0]+" "+letrasincorrectas[1][1]+" "+letrasincorrectas[1][2]+" "+letrasincorrectas[1][3]+" "+letrasincorrectas[1][4]+
												"\n"+
												letrasincorrectas[2][0]+" "+letrasincorrectas[2][1]+" "+letrasincorrectas[2][2]+" "+letrasincorrectas[2][3]+" "+letrasincorrectas[2][4]+
												"\n"+
												letrasincorrectas[3][0]+" "+letrasincorrectas[3][1]+" "+letrasincorrectas[3][2]+" "+letrasincorrectas[3][3]+" "+letrasincorrectas[3][4]+
												
												"\nLetras correctas pero mal posicionadas"+"\n"+
												"\n"+
												letrasmalposicionadas[0][0]+" "+letrasmalposicionadas[1][1]+" "+letrasmalposicionadas[1][2]+" "+letrasmalposicionadas[1][3]+" "+letrasmalposicionadas[1][4]+
												"\n"+
												letrasmalposicionadas[1][0]+" "+letrasmalposicionadas[1][1]+" "+letrasmalposicionadas[1][2]+" "+letrasmalposicionadas[1][3]+" "+letrasmalposicionadas[1][4]+
												"\n"+
												letrasmalposicionadas[2][0]+" "+letrasmalposicionadas[2][1]+" "+letrasmalposicionadas[2][2]+" "+letrasmalposicionadas[2][3]+" "+letrasmalposicionadas[2][4]+
												"\n"+
												letrasmalposicionadas[3][0]+" "+letrasmalposicionadas[3][1]+" "+letrasmalposicionadas[3][2]+" "+letrasmalposicionadas[3][3]+" "+letrasmalposicionadas[3][4]);
				
				columna=columna+1;
			
			} else if (columna==4) {
				
				JOptionPane.showMessageDialog(null, letrasingresadas[0][0]+" "+letrasingresadas[0][1]+" "+letrasingresadas[0][2]+" "+letrasingresadas[0][3]+" "+letrasingresadas[0][4]+
												"\n"+letrasingresadas[1][0]+" "+letrasingresadas[1][1]+" "+letrasingresadas[1][2]+" "+letrasingresadas[1][3]+" "+letrasingresadas[1][4]+
												"\n"+letrasingresadas[2][0]+" "+letrasingresadas[2][1]+" "+letrasingresadas[2][2]+" "+letrasingresadas[2][3]+" "+letrasingresadas[2][4]+
												"\n"+letrasingresadas[3][0]+" "+letrasingresadas[3][1]+" "+letrasingresadas[3][2]+" "+letrasingresadas[3][3]+" "+letrasingresadas[3][4]+
												"\n"+letrasingresadas[4][0]+" "+letrasingresadas[4][1]+" "+letrasingresadas[4][2]+" "+letrasingresadas[4][3]+" "+letrasingresadas[4][4]+
												"\nLetras incorrectas"+"\n"+
												"\n"+
												letrasincorrectas[0][0]+" "+letrasincorrectas[0][1]+" "+letrasincorrectas[0][2]+" "+letrasincorrectas[0][3]+" "+letrasincorrectas[0][4]+
												"\n"+
												letrasincorrectas[1][0]+" "+letrasincorrectas[1][1]+" "+letrasincorrectas[1][2]+" "+letrasincorrectas[1][3]+" "+letrasincorrectas[1][4]+
												"\n"+
												letrasincorrectas[2][0]+" "+letrasincorrectas[2][1]+" "+letrasincorrectas[2][2]+" "+letrasincorrectas[2][3]+" "+letrasincorrectas[2][4]+
												"\n"+
												letrasincorrectas[3][0]+" "+letrasincorrectas[3][1]+" "+letrasincorrectas[3][2]+" "+letrasincorrectas[3][3]+" "+letrasincorrectas[3][4]+
												"\n"+
												letrasincorrectas[4][0]+" "+letrasincorrectas[4][1]+" "+letrasincorrectas[4][2]+" "+letrasincorrectas[4][3]+" "+letrasincorrectas[4][4]+
												"\nLetras correctas pero mal posicionadas"+"\n"+
												"\n"+
												letrasmalposicionadas[0][0]+" "+letrasmalposicionadas[1][1]+" "+letrasmalposicionadas[1][2]+" "+letrasmalposicionadas[1][3]+" "+letrasmalposicionadas[1][4]+
												"\n"+
												letrasmalposicionadas[1][0]+" "+letrasmalposicionadas[1][1]+" "+letrasmalposicionadas[1][2]+" "+letrasmalposicionadas[1][3]+" "+letrasmalposicionadas[1][4]+
												"\n"+
												letrasmalposicionadas[2][0]+" "+letrasmalposicionadas[2][1]+" "+letrasmalposicionadas[2][2]+" "+letrasmalposicionadas[2][3]+" "+letrasmalposicionadas[2][4]+
												"\n"+
												letrasmalposicionadas[3][0]+" "+letrasmalposicionadas[3][1]+" "+letrasmalposicionadas[3][2]+" "+letrasmalposicionadas[3][3]+" "+letrasmalposicionadas[3][4]+
												"\n"+
												letrasmalposicionadas[4][0]+" "+letrasmalposicionadas[4][1]+" "+letrasmalposicionadas[4][2]+" "+letrasmalposicionadas[4][3]+" "+letrasmalposicionadas[4][4]);

				columna=columna+1;
					
			} else if (columna==5) {
				
				JOptionPane.showMessageDialog(null, letrasingresadas[0][0]+" "+letrasingresadas[0][1]+" "+letrasingresadas[0][2]+" "+letrasingresadas[0][3]+" "+letrasingresadas[0][4]+
												"\n"+letrasingresadas[1][0]+" "+letrasingresadas[1][1]+" "+letrasingresadas[1][2]+" "+letrasingresadas[1][3]+" "+letrasingresadas[1][4]+
												"\n"+letrasingresadas[2][0]+" "+letrasingresadas[2][1]+" "+letrasingresadas[2][2]+" "+letrasingresadas[2][3]+" "+letrasingresadas[2][4]+
												"\n"+letrasingresadas[3][0]+" "+letrasingresadas[3][1]+" "+letrasingresadas[3][2]+" "+letrasingresadas[3][3]+" "+letrasingresadas[3][4]+
												"\n"+letrasingresadas[4][0]+" "+letrasingresadas[4][1]+" "+letrasingresadas[4][2]+" "+letrasingresadas[4][3]+" "+letrasingresadas[4][4]+
												"\n"+letrasingresadas[5][0]+" "+letrasingresadas[5][1]+" "+letrasingresadas[5][2]+" "+letrasingresadas[5][3]+" "+letrasingresadas[5][4]+
												"\nLetras incorrectas"+"\n"+
												"\n"+
												letrasincorrectas[0][0]+" "+letrasincorrectas[0][1]+" "+letrasincorrectas[0][2]+" "+letrasincorrectas[0][3]+" "+letrasincorrectas[0][4]+
												"\n"+
												letrasincorrectas[1][0]+" "+letrasincorrectas[1][1]+" "+letrasincorrectas[1][2]+" "+letrasincorrectas[1][3]+" "+letrasincorrectas[1][4]+
												"\n"+
												letrasincorrectas[2][0]+" "+letrasincorrectas[2][1]+" "+letrasincorrectas[2][2]+" "+letrasincorrectas[2][3]+" "+letrasincorrectas[2][4]+
												"\n"+
												letrasincorrectas[3][0]+" "+letrasincorrectas[3][1]+" "+letrasincorrectas[3][2]+" "+letrasincorrectas[3][3]+" "+letrasincorrectas[3][4]+
												"\n"+
												letrasincorrectas[4][0]+" "+letrasincorrectas[4][1]+" "+letrasincorrectas[4][2]+" "+letrasincorrectas[4][3]+" "+letrasincorrectas[4][4]+
												"\n"+
												letrasincorrectas[5][0]+" "+letrasincorrectas[5][1]+" "+letrasincorrectas[5][2]+" "+letrasincorrectas[5][3]+" "+letrasincorrectas[5][4]+
												"\nLetras correctas pero mal posicionadas"+"\n"+
												"\n"+
												letrasmalposicionadas[0][0]+" "+letrasmalposicionadas[1][1]+" "+letrasmalposicionadas[1][2]+" "+letrasmalposicionadas[1][3]+" "+letrasmalposicionadas[1][4]+
												"\n"+
												letrasmalposicionadas[1][0]+" "+letrasmalposicionadas[1][1]+" "+letrasmalposicionadas[1][2]+" "+letrasmalposicionadas[1][3]+" "+letrasmalposicionadas[1][4]+
												"\n"+
												letrasmalposicionadas[2][0]+" "+letrasmalposicionadas[2][1]+" "+letrasmalposicionadas[2][2]+" "+letrasmalposicionadas[2][3]+" "+letrasmalposicionadas[2][4]+
												"\n"+
												letrasmalposicionadas[3][0]+" "+letrasmalposicionadas[3][1]+" "+letrasmalposicionadas[3][2]+" "+letrasmalposicionadas[3][3]+" "+letrasmalposicionadas[3][4]+
												"\n"+
												letrasmalposicionadas[5][0]+" "+letrasmalposicionadas[5][1]+" "+letrasmalposicionadas[5][2]+" "+letrasmalposicionadas[5][3]+" "+letrasmalposicionadas[5][4]);

				columna=columna+1;
			}
			
			intentos++;
		
		}
		
		if (jg==true) {
			JOptionPane.showMessageDialog(null, "Ganaste!"+"\nLa palabra era "+pr, "¡¡GANASTE!!",JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/ganaste.gif")));
		}
		
		if (intentos==6) {
			JOptionPane.showMessageDialog(null, "perdiste! la palabra era "+pr, "¡¡PERDISTE!!",JOptionPane.DEFAULT_OPTION, new ImageIcon(Juegosfinal.class.getResource("/img/gameover.gif")));
		}

	}
}

	    
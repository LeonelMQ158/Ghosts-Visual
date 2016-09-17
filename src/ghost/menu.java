/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghost;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class menu {
    

    /**
     * @param args the command line arguments
     */
    String usuarioArray[] = login.usuarios();
    String contraseñaArray[] = login.contraseñas();
    Scanner lea = new Scanner(System.in);
    
       public menu(){
        do{
            System.out.println("---------------------");
            System.out.println("---Menu Principal---");
            System.out.println("---------------------");
            System.out.println("a. Jugar Ghost");
            System.out.println("b. Configuracion");
            System.out.println("c. Reportes");
            System.out.println("d. Mi perfil");
            System.out.println("e. Salir");
            System.out.println("---------------------");
            System.out.print("Inserte la letra de la opcion que desea elegir: ");
            opcionp = lea.next().charAt(0);
            while(opcionp != 'a' && opcionp != 'b' && opcionp != 'c' && opcionp != 'd' && opcionp != 'e'){
                    System.out.print("Inserte el numero de la opcion que desea elegir: ");
                    opcionp = lea.next().charAt(0);
                }
            if(opcionp == 'a'){
                System.out.println("---------------------");
                System.out.println("a. Ingresar Usuario 2");
                System.out.println("b. Regresar al menu principal");
                System.out.print("Insertar la letra de la opcion que desea elegir: ");
                opcionm = lea.next().charAt(0);
                while(opcionm != 'a' && opcionm != 'b'){
                    System.out.print("Insertar la letra de la opcion que desea elegir: ");
                    opcionm = lea.next().charAt(0);
                }
                if(opcionm == 'a'){
                    System.out.println("---------------------");
                    System.out.print("Ingresar el nombre del Usuario 2 registrado: ");
                    usuario2 = lea.next();
                    for(int i = 0; i < usuarioArray.length; i++){
                    if(usuario2.equalsIgnoreCase(usuarioArray[i])){
                        contraseña2 = login.contraseñaArray[i];
                        jugar = true;
                    }
                }
                    if(jugar == true){
                        System.out.print("Bienvenido Jugador 2 " + usuario2 + "\n");
                        new tableroghost();
                        continue;
                    }else{
                        System.out.println("Usuario Inexistente");
                    }
                    continue;
                }else if(opcionm == 'b'){
                    continue;
                }

            }
            if(opcionp == 'b'){
                boolean menu2 = true;
                do{
                    System.out.println("---------------------");
                    System.out.println("a. Dificultad");
                    System.out.println("b. Modo de Juego");
                    System.out.println("c. Regresar al menu principal");
                    System.out.print("Inserte la letra de la opcion que desea elegir: ");
                    opcionm = lea.next().charAt(0);
                    while(opcionm != 'a' && opcionm != 'b' && opcionm != 'c'){
                    System.out.print("Inserte la letra de la opcion que desea elegir: ");
                    opcionm = lea.next().charAt(0);
                     }
                    if(opcionm == 'a'){
                        System.out.println("Elegir Dificultad");
                        System.out.println("a. Normal");
                        System.out.println("b. Experto");
                        System.out.println("c. Genius");
                        dificultad = lea.next().charAt(0);
                        continue;
                    }
                    if(opcionm == 'b'){
                        System.out.println("Elegir Modo de Juego");
                        System.out.println("a. Aleatorio");
                        System.out.println("b. Manual");
                        modoj = lea.next().charAt(0);
                        if(modoj == 'b'){
                        if(dificultad == 'a'){
                            else if(dificultad == 'b'){
                            cordm = new int[8][2];
                            while(difi <8){
                                for(int f = 0; f < cordm.length; f++){
                                    for(int c = 0; c < 2; c++){
                                        if(c !=1 && difi <4){
                                            System.out.print("Insertar la fila para el Fantasma " + (difi + 1) + " del jugador 1: ");
                                            cordnull(f,c);
                                            filaesp = cordm[f][c];
                                        }else if(difi < 4){
                                            System.out.print("Insertar la columna para el Fantasma " + (difi + 1) + " del jugador 1: ");
                                            cordnull(f,c);
                                            while(filaesp > 0 || filaesp < 0 || cordm[f][c] >= 5 || cordm[f][c] <=0 || cordesp[filaesp][cordm[f][c]] == true){
                                                System.out.print("Usar un valor ya sea 1 o 0 para la fila del Fantasma " + (difi + 1) + " del jugador 1. Tener en cuenta los espacios que ya se utilizaron: ");
                                                filaespnull(f, c);
                                                System.out.println("Usar un valor entre 1 - 4 para la columna del Fantasma " + (difi + 1) + " del jugador 1: " );
                                                cordnull(f,c);
                                            }
                                            cordesp[filaesp][cordm[f][c]] = true;
                                        }else if(c !=1 && difi >= 4){
                                            System.out.print("Insertar la fila para el Fantasma " + (difi - 3) + " del jugador 2: ");
                                            cordnull(f,c);
                                            filaesp = cordm[f][c];
                                        }else{
                                            System.out.print("Insertar la columna para el Fantasma " + (difi - 3) + " del jugador 2: ");
                                            cordnull(f,c);
                                            while(filaesp > 5 || filaesp < 5 || cordm[f][c] >= 5 || cordm[f][c] <=0 || cordesp[filaesp][cordm[f][c]] == true){
                                                System.out.print("Usar un valor ya sea 5 o 4 para la fila del Fantasma " + (difi - 3) + " del jugador 2. Tener en cuenta los espacios que ya se utilizaron: ");
                                                filaespnull(f, c);
                                                System.out.print("Usar un valor entre 1 - 4 para la columna del Fantasma " + (difi - 3) + " del jugador 2: " );
                                                cordnull(f,c);
                                            }
                                            cordesp[filaesp][cordm[f][c]] = true;
                                        }
                                    }
                                    difi+=1;
                                }
                            }
                            }
                        if(dificultad == 'c'){
                            cordm = new int[2][2];
                            while(difi <4){
                                for(int f = 0; f < cordm.length; f++){
                                    for(int c = 0; c < 2; c++){
                                        if(c !=1 && difi <2){
                                            System.out.print("Insertar la fila para el Fantasma " + (difi + 1) + " del jugador 1: ");
                                            cordnull(f,c);
                                            filaesp = cordm[f][c];
                                        }else if(difi < 2){
                                            System.out.print("Insertar la columna para el Fantasma " + (difi + 1) + " del jugador 1: ");
                                            cordnull(f,c);
                                            while(filaesp > 0 || filaesp < 0 || cordm[f][c] >= 4 || cordm[f][c] <=1 || cordesp[filaesp][cordm[f][c]] == true){
                                                System.out.print("Usar valor 0 para la fila del Fantasma " + (difi + 1) + " del jugador 1. Tener en cuenta los espacios que ya se utilizaron: ");
                                                filaespnull(f, c);
                                                System.out.print("Usar un valor entre 2 - 3 para la columna del Fantasma " + (difi + 1) + " del jugador 1: " );
                                                cordnull(f,c);
                                            }
                                            cordesp[filaesp][cordm[f][c]] = true;
                                        }else if(c !=1 && difi >= 2){
                                            System.out.print("Insertar la fila para el Fantasma " + (difi - 1) + " del jugador 2: ");
                                            cordnull(f,c);
                                            filaesp = cordm[f][c];
                                        }else{
                                            System.out.print("Insertar la columna para el Fantasma " + (difi - 1) + " del jugador 2: ");
                                            cordnull(f,c);
                                            while(filaesp > 5 || filaesp < 5 || cordm[f][c] >= 4 || cordm[f][c] <=1 || cordesp[filaesp][cordm[f][c]] == true){
                                                System.out.print("Usar valor 5 para la fila del Fantasma " + (difi - 1) + " del jugador 2. Tener en cuenta los espacios que ya se utilizaron: ");
                                                filaespnull(f, c);
                                                System.out.print("Usar un valor entre 2 - 3 para la columna del Fantasma " + (difi - 1) + " del jugador 2: " );
                                                cordnull(f,c);
                                            }
                                            cordesp[filaesp][cordm[f][c]] = true;
                                        }
                                    }
                                    difi+=1;
                                }
                            }
                        }
                        }
                        continue;
                    }
                    if(opcionm == 'c'){
                       break;
                       
                    }
                    menu2 = false;
                }while(menu2 == true);
            }
            if(opcionp == 'c'){
                boolean menu3 = true;
                do{
                    System.out.println("---------------------");
                    System.out.println("a. Descripcion de mis ultimos 10 juegos.");
                    System.out.println("b. Ranking de Jugadores");
                    System.out.println("c. Regresar al menu principal");
                    System.out.print("Insertar la letra de la opcion que desea elegir: ");
                    opcionm = lea.next().charAt(0);
                    while(opcionm != 'a' && opcionm != 'b' && opcionm != 'c'){
                    System.out.print("Inserte la letra de la opcion que desea elegir: ");
                    opcionm = lea.next().charAt(0);
                     }
                    if(opcionm == 'a'){
                        for(int i = 0; i < login.ult10.length; i++){
                            try{
                                System.out.println(i+1+". " + login.ult10[i]);
                            }
                            catch(NullPointerException npe){
                            }
                        }
                        continue;
                    }
                    if(opcionm == 'b'){
                        for (int f=0; f < 5; f++){                
                            try{
                                System.out.println(f+1+". " + login.listaj[f].usuario + " puntaje: " + login.listaj[f].score);
                            }
                            catch(NullPointerException npe){
                                System.out.println("No se ha registrado ningun puntaje aun");
                            }
                        }
                                        continue;
                    }
                    if(opcionm == 'c'){
                       break;
                    }
                    menu3 = false;
                }while(menu3 == true);

            }
            if(opcionp == 'd'){
                boolean menu4 = true;
                do{
                    System.out.println("---------------------");
                    System.out.println("a. Ver mis Datos");
                    System.out.println("b. Cambiar Password");
                    System.out.println("c. Eliminar mi cuenta");
                    System.out.println("d. Regresar al Menu Principal");
                    System.out.print("Insertar la letra de la opcion que desea elegir: ");
                    opcionm = lea.next().charAt(0);
                    while(opcionm != 'a' && opcionm != 'b' && opcionm != 'c' && opcionm != 'd'){
                    System.out.print("Inserte la letra de la opcion que desea elegir: ");
                    opcionm = lea.next().charAt(0);
                     }
                    if(opcionm == 'a'){
                        for(int i = 0; i < usuarioArray.length; i++){
                            if(login.usuario.equalsIgnoreCase(usuarioArray[i])){
                                System.out.println("Usuario: " + usuarioArray[i]);
                                System.out.println("Contraseña: " + contraseñaArray[i]);
                            }
                            if(login.listaj[i] != null){
                                if(login.listaj[i].usuario.equalsIgnoreCase(login.usuario)){
                                    System.out.println("Score: " + login.listaj[i].score);
                                }
                            }else if(i == (usuarioArray.length - 1)){
                                    System.out.println("Score: 0");
                            }
                        }
                        continue;
                    }
                    if(opcionm == 'b'){
                        for(int i = 0; i < usuarioArray.length; i++){
                            if(login.contraseña.equalsIgnoreCase(contraseñaArray[i])){
                                System.out.println("Contraseña Actual: " + contraseñaArray[i]);
                                System.out.print("Contraseña Nueva: ");
                                contraseñaArray[i] = lea.next();
                            }
                        }
                        continue;
                    }
                    if(opcionm == 'c'){
                        for(int i = 0; i < usuarioArray.length; i++){
                            if(login.usuario.equalsIgnoreCase(usuarioArray[i])){
                                usuarioArray[i] = null;
                                contraseñaArray[i] = null;
                                login.listaj[i] = null;
                                login.usuarios_ocupados[i] = false;
                                menu = false;
                            }
                        }
                        continue;
                    }
                    if(opcionm == 'd'){
                        
                        break;
                    }
                    menu4 = false;
                }while(menu4 == true);

            }
            if(opcionp == 'e'){
                  
                menu = false;
                
            }
        }while(menu == true);
    }
       public void cordnull(int fila, int columna){
           while(true){
               try{
               cordm[fila][columna] = lea.nextInt();
               break;
                }catch(InputMismatchException e){
                    System.out.println("Ingresar una variable");
                }
           }
       }
       public void filaespnull(int f, int c){
           while(true)
           {
              try{
               filaesp = lea.nextInt();
               break;
                }catch(InputMismatchException e){
               System.out.println("Ingresar una variable");
                } 
           }
           
       }
  
   }


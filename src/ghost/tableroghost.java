/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghost;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Administrator
 */
public class tableroghost extends javax.swing.JPanel{
    public static int jugador = 1;
    public static boolean jm1 = false;
    public static boolean jm2 = true;
    public static boolean v = true;
    
    JFrame frame = new JFrame();
    JButton seleccionar = new JButton("Selecionar");
    JTextField xsel = new JTextField("Fila Seleccionar");
    JTextField ysel = new JTextField("Columna Seleccionar");
    JTextField xmov = new JTextField("Fila Mover");
    JTextField ymov = new JTextField("Columna Mover");
    JButton mover = new JButton("Mover");
    JFrame tablero = new JFrame();
    static int filas = 6;
    static int columnas = 6;
    JButton lugares[][] = new JButton[filas][columnas];
    Color colorp;
    ImageIcon j1 = new ImageIcon("fantasma.gif");
    ImageIcon j2 = new ImageIcon("fantasma2.gif");
    ImageIcon blanco = new ImageIcon();
    boolean espacios[][] = new boolean[filas][columnas];
    static jugadores jugador1;
    static jugadores jugador2;
    Random am = new Random();
    int amconta = 0;
    boolean errcor = false;
    int f = 0;
    int c = 0;
    int fm = 0;
    int cm = 0;
    JButton posicion;
    Boolean espacio;
    JButton posicion2;
    Boolean espacio2;
    Component mensaje = null;
    int fls = 0;
    int cls = 0;
    int cls2 = 0;
    int flsj2 = 0;
    int flsj = 0;
    boolean coor[][] = new boolean[6][6];
    int amcontar;
    int j1f = 0;
    int j2f = 0;
    boolean jj1 = false;
    boolean jj2 = false;
  
    public tableroghost(){
        
        frame.setTitle("----Ghost_Controles----");
        frame.setSize(450, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,2));
        seleccionar.setEnabled(false);
        frame.add(seleccionar);
        frame.add(xsel);
        frame.add(ysel);
        frame.add(mover);
        frame.add(xmov);
        frame.add(ymov);
        frame.setVisible(true);
        tablero.setTitle("----Ghost_Juego|Dev._by_ALA----");
        tablero.setSize(600, 600);
        tablero.setResizable(false);
        tablero.setLocationRelativeTo(null);
        tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablero.setVisible(true);
        tablero.setLayout(new GridLayout(filas,columnas));
        for(int f = 0; f < filas; f++ ){
            if (f%2 == 0){
                colorp = Color.WHITE;
            }else{
                colorp = Color.BLACK;
            }
            for(int c = 0; c < columnas; c++){
                if(f <= filas && c == 0){
                    lugares[f][c] = new JButton(String.valueOf(f + 1));
                    lugares[f][c].setHorizontalTextPosition(SwingConstants.LEFT);
                    lugares[f][c].setVerticalTextPosition(SwingConstants.CENTER);
                    if(colorp == Color.BLACK){
                        lugares[f][c].setForeground(Color.WHITE);
                    }
                }else if(f == 0 && c <= columnas){
                    lugares[f][c] = new JButton(String.valueOf(c + 1));
                    lugares[f][c].setHorizontalTextPosition(SwingConstants.CENTER);
                    lugares[f][c].setVerticalTextPosition(SwingConstants.TOP);
                    if(colorp == Color.BLACK){
                        lugares[f][c].setForeground(Color.WHITE);
                    }
                }else{
                    lugares[f][c] = new JButton();
                }
                
                lugares[f][c].setBackground(colorp);
                if(colorp.equals(Color.WHITE)){
                    colorp = Color.BLACK;
                }else{
                    colorp = Color.WHITE;
                }
                tablero.add(lugares[f][c]);
            }
        }
        while(jj1 == false && jj2 == false){
            for(int i = 0; i < login.listaj.length; i++){
            if(login.listaj[i] != null){
                if(login.listaj[i].usuario.equalsIgnoreCase(login.usuario)){
                    jugador1 = login.listaj[i];
                    jj1 = true;
                }
            }
            if(login.listaj[i] != null){
                if(login.listaj[i].usuario.equalsIgnoreCase(Configuracion.usuario2)){
                    jugador2 = login.listaj[i];
                    jj2 = true;
                }
            }  
        }
            if(jj1 == false && jj2 == false){
                break;
            }
    }
        while(jj1 == false || jj2 == false){
            for(int i = 0; i < login.listaj.length; i++){
                if(login.listaj[i] == null && jj1 == false){
                   jugador1 = new jugadores(Login.usuario,Login.password,0);
                   login.listaj[i] = jugador1; 
                   jj1 = true;
                }
                if(login.listaj[i] == null && jj2 == false){
                  jugador2 = new jugadores(Configuracion.usuario2,Configuracion.contraseña2,0);
                  login.listaj[i] = jugador2;
                  jj2 = true;
                }
            }
        } 
        switch (Configuracion.dificultad) {
            case 'a':
                fls = 2;
                cls = 5;
                cls2 = 1;
                flsj2 = 4;
                flsj = 6;
                amcontar = 4;
                break;
            case 'b':
                fls = 1;
                cls = 5;
                cls2 = 1;
                flsj2 = 5;
                flsj = 6;
                amcontar = 2;
                break;
            case 'c':
                fls = 1;
                cls = 4;
                cls2 = 2;
                flsj2 = 5;
                flsj = 6;
                amcontar = 1;
                break;
            default:
                break;
        }
        if(Configuracion.modoj == 'a'){
            //Jugador2
            amconta = 0;
            for(int f = 0; f < fls; f++){
                for(int c = cls2; c < cls; c++){
                    lugares[f][c].setIcon(j2);
                }
            }
            while(amconta != amcontar){
                for(int f = 0; f < filas; f++){
                for(int c = 0; c < columnas; c++){
                    if(lugares[f][c].getIcon() == j2 && espacios[f][c] == false && coor[f][c] == false){
                        espacios[f][c] = am.nextBoolean();
                        if(espacios[f][c] == true){
                            coor[f][c] = true;
                            amconta++;
                        }
                    }   
                }
            }
                if(amconta > amcontar || amconta < amcontar){
                    resetconta(j2);
                }
        }
            
            amconta = 0;
            //Jugador 1
            for(int f = flsj2; f < flsj; f++){
                for(int c = cls2; c < cls; c++){
                    lugares[f][c].setIcon(j1);
                }
            }
            while(amconta != amcontar){
                for(int f = 0; f < filas; f++){
                for(int c = 0; c < columnas; c++){
                    if(lugares[f][c].getIcon() == j1 && espacios[f][c] == false && coor[f][c] == false){
                        espacios[f][c] = am.nextBoolean();
                        if(espacios[f][c] == true){
                            coor[f][c] = true;
                            amconta++;
                        }
                    }   
                }
            }
                if(amconta > amcontar || amconta < amcontar){
                    resetconta(j1);
                }
        }
    amconta = 0;
    }else if(Configuracion.modoj == 'b'){
        amconta = 0;
        //Jugador2 
            for(int f = 0; f < 3; f++){
                for(int c = 1; c < 5; c++){
                    if(Configuracion.cordesp[f][c] == true){
                        lugares[f][c].setIcon(j2);
                        if(amconta == 0){
                            espacios[f][c] = false;
                            amconta +=1;
                        }else{
                            espacios[f][c] = true;
                            amconta -= 1;
                        }
                    }
                }
            }
    amconta = 0;
        //Jugador1 
            for(int f = 4; f < 6; f++){
                for(int c = 1; c < 5; c++){
                    if(Configuracion.cordesp[f][c] == true){
                        lugares[f][c].setIcon(j1);
                        if(amconta == 0){
                            espacios[f][c] = false;
                            amconta +=1;
                        }else{
                            espacios[f][c] = true;
                            amconta -=1;
                        }
                    }
                }
            }
        amconta = 0;
    }

        //Espacios en blanco
        for(int f=0; f<filas;f++){
            for(int c =0 ; c<columnas; c++){
                if(lugares[f][c].getIcon() != j1 && lugares[f][c].getIcon() != j2){
                    lugares[f][c].setIcon(blanco);
                }
            }
        }
        
             
        mover.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            f = Integer.parseInt(xsel.getText());
                            f = f-1;
                            c = Integer.parseInt(ysel.getText());
                            c = c-1;
                            fm = Integer.parseInt(xmov.getText());
                            fm = fm-1;
                            cm = Integer.parseInt(ymov.getText());
                            cm = cm -1;
                            } catch (NumberFormatException nfe) {
                            Component mensaje = null;
                            if(f == -1 || c == -1 || fm == -1 || cm == -1){
                            terminar();
                            }
                            JOptionPane.showMessageDialog(mensaje, "Solo se permiten valores numericos en los campos de coordenadas."); 
                            errcor = true;
                            }
                        if(errcor){
                            f = 0;
                            c = 0;
                            fm = 0;
                            cm = 0;
                            xsel.setText("");
                            ysel.setText("");
                            xmov.setText("");
                            ymov.setText("");
                            errcor = false;
                        }
                        if(f > 5 || c > 5 || fm > 5 || cm > 5){
                          JOptionPane.showMessageDialog(mensaje, "No se permiten numeros mayores que 5 en ninguno de los campos."); 
                        }else{
                            JButton posicion = lugares[f][c];
                            Boolean espacio = espacios[f][c];
                            JButton posicion2 = lugares[fm][cm];
                            Boolean espacio2 = espacios[fm][cm];
                            if(jugador == 1 && jm2 == true && lugares[f][c].getIcon()== j1){
                            if(fm - f == - 1 || fm - f == 1 || fm == f){
                                if(cm - c == -1 || cm - c == 1 || cm == c){
                                    if(lugares[f][c].getIcon() == j1 && lugares[fm][cm].getIcon() == blanco ){
                                    posicion.setIcon(blanco);
                                    posicion2.setIcon(j1);
                                    espacio2 = espacio;
                                    espacio = false; 
                                    jugador+=1;
                                    xsel.setText("");
                                    ysel.setText("");
                                    xmov.setText("");
                                    ymov.setText("");
                                }else if(lugares[f][c].getIcon() == j1 && lugares[fm][cm].getIcon() == j2){
                                    if(lugares[fm][cm] == lugares[0][5] || lugares[fm][cm] == lugares[0][0] && espacio == false){
                                            JOptionPane.showMessageDialog(mensaje, "¡Has Ganado! " + jugador1.usuario + " + 3 puntos");
                                            jugador1.score += 3;
                                            jugador = 1;
                                            llenarult(3,0);
                                            terminar();
                                        }
                                    posicion.setIcon(blanco);
                                    posicion2.setIcon(j1);
                                    jugador+=1;
                                    xsel.setText("");
                                    ysel.setText("");
                                    xmov.setText("");
                                    ymov.setText("");
                                    if(espacio2 == true){
                                    JOptionPane.showMessageDialog(mensaje, "Te Comiste un Fantasma Malo");  
                                    }else{
                                    JOptionPane.showMessageDialog(mensaje, "Te Comiste un Fantasma Bueno");
                                    j1f +=1;
                                    if(j1f == amcontar){
                                        JOptionPane.showMessageDialog(mensaje, "¡Has Ganado! " + jugador1.usuario + " + 3 puntos");
                                        jugador1.score +=3;
                                        jugador = 1;
                                        llenarult(3,0);
                                        terminar();
                                    }
                                    }
                                    espacio2 = espacio;
                                    espacio = false;
                                }else if(lugares[fm][cm].getIcon() != blanco && lugares[fm][cm].getIcon() == j1){
                                    JOptionPane.showMessageDialog(mensaje, "Las Coordenadas Elegidas Para El Destino Está Actualmente Ocupada");
                                         }else {
                                    JOptionPane.showMessageDialog(mensaje, "Porfavor Ingresar Las Coordenadas Correctamente en Seleccionar");
                                         }
                            }else{
                                    JOptionPane.showMessageDialog(mensaje, "No Se Permite Moverse Mas de un Espacio"); 
                            }
                        }else{
                                    JOptionPane.showMessageDialog(mensaje, "No Se Permite Moverse Mas de un Espacio"); 
                        }
                 }else if(lugares[f][c].getIcon() != blanco && lugares[f][c].getIcon() == j1 && jugador != 1 && jm1 == true){
                        JOptionPane.showMessageDialog(mensaje, "Es el turno del Jugador " + jugador + ": " + jugador2.usuario);
                 }
                        if(jugador == 2 && jm1 == true && lugares[f][c].getIcon()== j2){
                        if(fm - f == - 1 || fm - f == 1 || fm == f){
                                if(cm - c == -1 || cm - c == 1 || cm == c){
                                    if(lugares[f][c].getIcon() == j2 && lugares[fm][cm].getIcon() == blanco ){
                                    posicion.setIcon(blanco);
                                    posicion2.setIcon(j2);
                                    espacio2 = espacio;
                                    espacio = false; 
                                    jugador -=1;
                                    xsel.setText("");
                                    ysel.setText("");
                                    xmov.setText("");
                                    ymov.setText("");
                                 }else if(lugares[f][c].getIcon() == j2 && lugares[fm][cm].getIcon() == j1){
                                     if(lugares[fm][cm] == lugares[5][5] || lugares[fm][cm] == lugares[5][0] && espacio == false){
                                            JOptionPane.showMessageDialog(mensaje, "¡Has Ganado! " + jugador2.usuario + " + 3 puntos");
                                            jugador2.score += 3;
                                            jugador = 1;
                                            llenarult(0,3);
                                            terminar();
                                        }
                                    posicion.setIcon(blanco);
                                    posicion2.setIcon(j2);
                                    jugador -=1;
                                    xsel.setText("");
                                    ysel.setText("");
                                    xmov.setText("");
                                    ymov.setText("");
                                    if(espacio2 == true){
                                    JOptionPane.showMessageDialog(mensaje, "Te Comiste un Fantasma Malo");  
                                    }else{
                                    JOptionPane.showMessageDialog(mensaje, "Te Comiste un Fantasma Bueno");  
                                    j2f +=1;
                                    if(j2f == amcontar){
                                        JOptionPane.showMessageDialog(mensaje, "¡Has Ganado! " + jugador2.usuario + " + 3 puntos");
                                        jugador2.score +=3;
                                        jugador = 1;
                                        llenarult(0,3);
                                        terminar();
                                        }
                                    }
                                    espacio2 = espacio;
                                    espacio = false;
                                }else if(lugares[fm][cm].getIcon() != blanco && lugares[fm][cm].getIcon() == j2){
                                    JOptionPane.showMessageDialog(mensaje, "Las Coordenadas Elegidas Para El Destino Está Actualmente Ocupada");
                                         }else {
                                    JOptionPane.showMessageDialog(mensaje, "Porfavor Ingresar Las Coordenadas Correctamente en Seleccionar");
                                         }
                            }else{
                                    JOptionPane.showMessageDialog(mensaje, "No Se Permite Moverse Mas de un Espacio"); 
                            }
                        }else{
                                    JOptionPane.showMessageDialog(mensaje, "No Se Permite Moverse Mas de un Espacio"); 
                        }
                      }else if(lugares[f][c].getIcon() != blanco && lugares[f][c].getIcon() == j2 && jugador != 2 && jm2 == true){
                                JOptionPane.showMessageDialog(mensaje, "Es el turno del Jugador " + jugador + ": " + jugador1.usuario); 
                            }
                    }
                        if(jugador == 2 && jm2 == true){
                            jm2 = false;
                            jm1 = true;
                        }else if(jugador == 1 && jm1 == true){
                            jm2 = true;
                            jm1 = false;
                        }
                    }
            });
    }
    public void resetconta(ImageIcon icono){
            for(int f = 0; f < filas; f++){
                for(int c = 0; c < columnas; c++){
                    if(lugares[f][c].getIcon() == icono){
                        espacios[f][c] = false;
                        coor[f][c] = false;
                    }   
                }
            }
            amconta = 0;
        }
    public void terminar(){
        frame.setVisible(false);
        tablero.setVisible(false);
    }
    
    public void llenarult(int p1,int p2){
        for(int i = 0; i < login.ult10.length; i++){
            login.ult10[i] = jugador1.usuario + " " + p1 + " " + jugador2.usuario + " " + p2;  
            if(i == 0){
            i = 0;
            }
            break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
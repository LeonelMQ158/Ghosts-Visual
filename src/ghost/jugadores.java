/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghost;

/**
 *
 * @author Administrator
 */
public class jugadores {
    public int score = 0;
    public String usuario = "Usuario no registrado.";
    public String contraseña;
    public int cont = 0;      
    public void setSco(int score){
        int sco = score;
    }
    public void getSco(){
    }
    public jugadores(String u, String c, int sc){
        if(cont < 5){
            usuario = u;
            contraseña = c;
            score = sc;
        }
    }  

    int getUsu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

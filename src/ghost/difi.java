/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghost;

/**
 *
 * @author alejandro
 */
public class difi {
    Configuracion confi = new Configuracion();
    public void Normal(){
        Configuracion.dificultad = 'a';
        
        
        if (Configuracion.modoj=='b'){
            Configuracion.cordm = new int[16][2];
            while(confi.difi <16){
            for(int f = 0; f < Configuracion.cordm.length; f++){
                for(int c = 0; c < 2; c++){
                    if(c !=1 && confi.difi <8){
                      confi.cordnull(f,c);
                      confi.filaesp = Configuracion.cordm[f][c];
                    }
                    else if(confi.difi < 8){
                        confi.cordnull(f,c);
                        while(confi.filaesp > 1 || confi.filaesp < 0 || Configuracion.cordm[f][c] >= 5 || Configuracion.cordm[f][c] <=0 || Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] == true){
                            confi.filaespnull(f, c);
                            confi.cordnull(f,c);
                        }
                        Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] = true;
                        }else if(c !=1 && confi.difi >= 8){
                            confi.cordnull(f,c);
                            confi.filaesp = Configuracion.cordm[f][c];
                        }else{
                            confi.cordnull(f,c);
                            while(confi.filaesp > 5 || confi.filaesp < 4 || Configuracion.cordm[f][c] >= 5 || Configuracion.cordm[f][c] <=0 || Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] == true){
                                confi.filaespnull(f, c);
                                confi.cordnull(f,c);
                            }
                            Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] = true;
                        }
                }
            confi.difi+=1;
                }
           }
    }
    }
    public void Experto(){
        Configuracion.dificultad = 'b';
            if (Configuracion.modoj=='b'){
            Configuracion.cordm = new int[8][2];
                while(confi.difi <8){
                    for(int f = 0; f < Configuracion.cordm.length; f++){
                        for(int c = 0; c < 2; c++){
                            if(c !=1 && confi.difi <4){
                                confi.cordnull(f,c);
                                confi.filaesp = Configuracion.cordm[f][c];
                            }
                            else if(confi.difi < 4){
                                confi.cordnull(f,c);
                                while(confi.filaesp > 0 || confi.filaesp < 0 || Configuracion.cordm[f][c] >= 5 || Configuracion.cordm[f][c] <=0 || Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] == true){
                                    confi.filaespnull(f, c);
                                    confi.cordnull(f,c);
                                }
                                Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] = true;
                            }else if(c !=1 && confi.difi >= 4){
                                confi.cordnull(f,c);
                                confi.filaesp = Configuracion.cordm[f][c];
                            }else{
                                confi.cordnull(f,c);
                                while(confi.filaesp > 5 || confi.filaesp < 5 || Configuracion.cordm[f][c] >= 5 || Configuracion.cordm[f][c] <=0 || Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] == true){
                                    confi.filaespnull(f, c);
                                    confi.cordnull(f,c);
                                }
                                Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] = true;
                            }
                        }
                    confi.difi+=1;
                                }
                    }
                }
    }
    public void Genius(){
        Configuracion.dificultad = 'b';
        if (Configuracion.modoj=='b'){
            Configuracion.cordm = new int[2][2];
            while(confi.difi <4){
                for(int f = 0; f < Configuracion.cordm.length; f++){
                    for(int c = 0; c < 2; c++){
                        if(c !=1 && confi.difi <2){
                            confi.cordnull(f,c);
                            confi.filaesp = Configuracion.cordm[f][c];
                        }else if(confi.difi < 2){
                            confi.cordnull(f,c);
                            while(confi.filaesp > 0 || confi.filaesp < 0 || Configuracion.cordm[f][c] >= 4 || Configuracion.cordm[f][c] <=1 || Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] == true){
                                confi.filaespnull(f, c);
                                confi.cordnull(f,c);
                            }
                            Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] = true;
                            }else if(c !=1 && confi.difi >= 2){
                                confi.cordnull(f,c);
                                confi.filaesp = Configuracion.cordm[f][c];
                                }else{
                                    confi.cordnull(f,c);
                                    while(confi.filaesp > 5 || confi.filaesp < 5 || Configuracion.cordm[f][c] >= 4 || Configuracion.cordm[f][c] <=1 || Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] == true){
                                    confi.filaespnull(f, c);
                                    confi.cordnull(f,c);
                                }
                            Configuracion.cordesp[confi.filaesp][Configuracion.cordm[f][c]] = true;
                                        }
                                    }
                                    confi.difi+=1;
                                }
                            }
                        }
    }
}


package encripklaus;

import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Clase de un algoritmo propio para encripcion con clave
 * @author Klaus Thelen
 */
public class EncripKlaus {
    
    
   public String exclusivo(String a, String b){
    String  c =null;
    if(a==b){c="0";}
    else {c="1";}    
       
    return c;
    } 
  
       
    
   
    public  String encrip(String mensaje) {
        
        String Mensaje=mensaje;
        String clave="";
        String Binario="";
        String encriptado ="";
        String txtcrip="";
        Scanner  sc=new Scanner(System.in);
        int cam1,cam2,por;
        char c;
        
              
        
        for (int i = 0; i < Mensaje.length(); i++) {
             c = Mensaje.charAt(i);
            int num=c;
           
            do{por=((int)(Math.random()*10));} while(por>10);
            num=num+por;
            if(num>65535){num=num-por;}
            
            Binario="";
            
            clave=clave.concat(Integer.toString(por));
            for (int j = 7; j >= 0; j--) {
                    if(num>=Math.pow(2, j)){
                        Binario=Binario.concat("1");
                        num-=Math.pow(2, j);


                    }
                    else{
                        Binario=Binario.concat("0");
                    }
                }// cierra el for que pasa a ASCCI
             do{cam1=((int)(Math.random()*10));} while(cam1>7);
             do {cam2=((int)(Math.random()*10)); }while(cam2>7 || cam2==cam1);
             String binencriptado="";
            for (int m = 0; m < 8; m++) {
                c=Binario.charAt(m);
                
               
                binencriptado=binencriptado.concat(Character.toString(c));
             }
            encriptado=encriptado.concat(binencriptado);
        }//Cierra el for que recorre tooodo el texto
        //System.out.println(clave);
//        System.out.println(encriptado);
        
          
        String nobin="";
        int secret=0;
        char car = 0;
        char caraux;
         txtcrip="";
        int aux=0; 
         
         for (int i = 0; i < encriptado.length(); i++) {
            caraux=encriptado.charAt(i);
            nobin=nobin.concat(Character.toString(caraux));
             aux++;
            if(aux%8==0){
               secret=0;
               for (int n = 0; n < 8; n++) {
            
                    char g=nobin.charAt(n);
            
                    if(g=='1'){

                    secret+=Math.pow(2,(7-n));

                    }
                }
                 car=((char)secret);
                 nobin="";
                 txtcrip=txtcrip.concat(Character.toString(car));
             }
         }//cierra for  que pasa de binario a caracter
         
          System.out.println(txtcrip);
          try{
          FileWriter fmsg= new FileWriter("Mensaje.txt");
          fmsg.write(Mensaje);
          fmsg.close();
          FileWriter fclave= new FileWriter("Clave.txt");
          fclave.write(clave);
          fclave.close();
          FileWriter fencrip= new FileWriter("Encriptado.txt");
          fencrip.write(txtcrip);
          fencrip.close();
          }
          catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido unn error");
          
          }
          
        return txtcrip;  
     }
    
    public String descencrip(int [] Por, String encrip){
        String Mensaje=encrip;
        
        String Binario="";
        String encriptado ="";
        int[]por=Por;
        char c;
         for (int i = 0; i < Mensaje.length(); i++) {
             c = Mensaje.charAt(i);
             int num=c;
           
           
            num=num-por[i];
           
            
            Binario="";
            
           
            for (int j = 7; j >= 0; j--) {
                    if(num>=Math.pow(2, j)){
                        Binario=Binario.concat("1");
                        num-=Math.pow(2, j);


                    }
                    else{
                        Binario=Binario.concat("0");
                    }
                }// cierra el for que pasa a ASCCI
             
             String binencriptado="";
            for (int m = 0; m < 8; m++) {
                c=Binario.charAt(m);
                
               
                binencriptado=binencriptado.concat(Character.toString(c));
             }
            encriptado=encriptado.concat(binencriptado);
        }//Cierra el for que recorre tooodo el texto
       
      // System.out.println(encriptado);
        
          
        String nobin="";
        int secret=0;
        char car = 0;
        char caraux;
        String txtcrip="";
        int aux=0; 
         
         for (int i = 0; i < encriptado.length(); i++) {
            caraux=encriptado.charAt(i);
            nobin=nobin.concat(Character.toString(caraux));
             aux++;
            if(aux%8==0){
               secret=0;
               for (int n = 0; n < 8; n++) {
            
                    char g=nobin.charAt(n);
            
                    if(g=='1'){

                    secret+=Math.pow(2,(7-n));

                    }
                }
                 car=((char)secret);
                 nobin="";
                 txtcrip=txtcrip.concat(Character.toString(car));
             }
         }//cierra for  que pasa de binario a caracter
         System.out.println(txtcrip);
    try{
          
          
          FileWriter fencrip= new FileWriter("Desencriptado.txt");
          fencrip.write(txtcrip);
          fencrip.close();
          }
          catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido unn error");
          
          }
    
    return txtcrip;
    }
          
 
    
}

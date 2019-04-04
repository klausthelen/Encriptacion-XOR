/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encripklaus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author klaushpportatil
 */
public class Controlador implements ActionListener {
  
    Vista vst=new Vista();
    EncripKlaus mtd=new EncripKlaus();
    
    public Controlador(Vista vst, EncripKlaus mtd){
    this.mtd=mtd;
    this.vst=vst;
    this.vst.jbDes.addActionListener(this);
    this.vst.jbDes.setActionCommand("btDes");
    this.vst.jbEncrip.addActionListener(this);
    this.vst.jbEncrip.setActionCommand("btEncri");
    }
    
    
    public enum bt{
    btDes,
    btEncri
    }
    
    public void actionPerformed(ActionEvent e) {
         switch(bt.valueOf(e.getActionCommand())){
           
             case btDes:
                 String mensajen=vst.jtxtInicial.getText();
                 String clave= vst.jtxtClave.getText();
                 int cl[] = new int[mensajen.length()];
                 for (int i=0; i<mensajen.length();i++){
                        cl[i]=Integer.parseInt
                        (Character.toString(clave.charAt(i)));
                    }
                vst.jtxtFinal.setText(mtd.descencrip(cl,mensajen)) ;
             break;    
             
             case btEncri:
                 String mensaje=vst.jtxtInicial.getText();
                vst.jtxtFinal.setText(mtd.encrip(mensaje));
             break;    
         }
    
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encripklaus;

import java.util.Scanner;

/**
 *
 * @author klaushpportatil
 */
public class Main  {
    public static void main(String[] args) {
    EncripKlaus mtd=new EncripKlaus();
    Vista vst=new Vista();
    Controlador ctrl=new Controlador(vst,mtd);
    
    vst.setVisible(true);
    vst.setTitle("Encriptar");
    vst.setLocationRelativeTo(null);
    vst.setResizable(false);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualagenda;

import Interfaz.Ventana;

/**
 *
 * @author Andre
 */
public class VirtualAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana ven = new Ventana(); 
        ven.setVisible(true); 
        ven.setLocationRelativeTo(null);
        ven.setTitle("AGENDA");
    }
    
}

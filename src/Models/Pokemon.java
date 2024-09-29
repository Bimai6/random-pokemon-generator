/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Mario Lebrero
 */
public class Pokemon {
    String nombre;
    int potencial;
    int generacion;
    ImageIcon gif;
    
    public Pokemon(String line){
        String[] elements = line.split(", ");
        this.nombre = elements[0];
        this.potencial = Integer.parseInt(elements[1]);
        this.generacion = Integer.parseInt(elements[2]);
        try {
            this.gif = new ImageIcon(new URL(elements[3]));
        } catch (MalformedURLException ex) {
            System.out.println("Gif for Pokemon: " + this.nombre + "is incorrect");
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", potencial=" + potencial + ", generacion=" + generacion +  '}';
    }
    
    
}

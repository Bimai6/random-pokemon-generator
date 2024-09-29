/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.*;

/**
 *
 * @author Mario Lebrero Garcia
 */
public class MyFileReader {

    public static String readFile(String filePath) {

        BufferedReader br = null;
        String texto = "";
        try {

            br = new BufferedReader(new FileReader(new File(filePath)));

            String linea;
            while ((linea = br.readLine()) != null && linea.length() != 0) {
                texto += "\n" + linea;
            }

            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return texto.trim();
    }
}

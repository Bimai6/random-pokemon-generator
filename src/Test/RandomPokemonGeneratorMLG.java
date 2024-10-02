/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Controllers.GenerationMenu;
import Models.Pokemon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author Mario Lebrero García
 */
public class RandomPokemonGeneratorMLG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pokeString = Utils.MyFileReader.readFile("src/Sources/listadepokes.txt");
        List<String> pokeListString = Arrays.asList(pokeString.split("\n"));
        List<Pokemon> pokeList = new ArrayList<>();
        pokeListString.stream().forEach(line -> pokeList.add(new Pokemon(line)));
        
        GenerationMenu menu = new GenerationMenu(pokeList);
        menu.setVisible(true);
    }

}

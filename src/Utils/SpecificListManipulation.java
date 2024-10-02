/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Pokemon;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 *
 * @author Mario Lebrero García
 */
public class SpecificListManipulation {
    public static Pokemon generatePokemon(List <Pokemon> pokeList){
        Collections.shuffle(pokeList);
        Random random = new Random();
        int randomInt = random.nextInt(100) + 1;
        final int searchInt;
        
        if(randomInt <= 15){
            searchInt = random.nextInt(2) + 1;
        }else if(randomInt <= 60){
            searchInt = random.nextInt(2) + 3;
        }else if(randomInt <= 90){
            searchInt = random.nextInt(3) + 5;
        }else{
            searchInt = random.nextInt(2) + 8;
        }
        
        Optional <Pokemon> pokeGenerated = pokeList.stream().filter(poke -> poke.getPotencial() == searchInt)
                .findFirst();
        
        return pokeGenerated.orElse(null);
    }
}

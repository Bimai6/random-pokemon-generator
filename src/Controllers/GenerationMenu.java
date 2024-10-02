/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Pokemon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mario Lebrero García
 */
public class GenerationMenu extends JFrame {

    List<Pokemon> storedList;
    JLabel pokeGif;

    public GenerationMenu(List<Pokemon> pokeList) {
        setupWindow();
        setTitle("Random Pokémon Generator");
        this.storedList = pokeList;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setupWindow() {
        setLayout(new BorderLayout());
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setPreferredSize(new Dimension(500, 200));
        backgroundPanel.setLayout(new BorderLayout());

        // Panel de imagen (fondo blanco, imagen placeholder al inicio)
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(Color.WHITE);  // Fondo blanco
        pokeGif = new JLabel();  // JLabel para la imagen
        pokeGif.setHorizontalAlignment(JLabel.CENTER);  // Centrar la imagen

        // Placeholder inicial
        ImageIcon placeholderIcon = new ImageIcon("src/Sources/missigno.png");
        pokeGif.setIcon(placeholderIcon);

        // Añadir la etiqueta de imagen al panel de imagen
        imagePanel.add(pokeGif, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.setPreferredSize(new Dimension(500, 50));

        JButton loginButton = new JButton("DO IT!!!");
        loginButton.addActionListener(e -> {
            Pokemon pokemon = Utils.SpecificListManipulation.generatePokemon(this.storedList);
            System.out.println(pokemon);

            ImageIcon pokemonIcon = pokemon.getGif();
            if (pokemonIcon != null) {
                pokeGif.setIcon(pokemonIcon);
            } else {
                System.out.println("Archivo GIF no encontrado.");
            }
        });

        JButton signinButton = new JButton("Check the team");
        signinButton.addActionListener(e -> {

        });

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {

        });

        buttonPanel.add(loginButton);
        buttonPanel.add(signinButton);
        buttonPanel.add(resetButton);

        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);
        backgroundPanel.add(imagePanel, BorderLayout.CENTER);

        add(backgroundPanel, BorderLayout.CENTER);
    }
}

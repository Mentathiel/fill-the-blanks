package com.example.springboot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class CardTextGenerator {
    private LinkedList<String> prompts;
    private LinkedList<String> cards;

    public CardTextGenerator(){
        prompts = new LinkedList<String>();
        cards = new LinkedList<String>();

        File promptFile = new File("src/main/resources/static/prompt.txt");
        File cardFile = new File("src/main/resources/static/card.txt");

        try {
            Scanner scanner = new Scanner(promptFile);
            while (scanner.hasNextLine()) {
                prompts.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner scanner = new Scanner(cardFile);
            while (scanner.hasNextLine()) {
                cards.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getPrompt(){
        Random rand = new Random();
        return prompts.get(rand.nextInt(prompts.size()));
    }

    public String getCard(){
        Random rand = new Random();
        return cards.get(rand.nextInt(cards.size()));
    }

    public String getAllPrompts(){
        StringBuilder sb = new StringBuilder();
        for(String s : prompts) {
            sb.append(s+"<br/>");
        }
        return sb.toString();
    }

    public String getAllCards(){
        StringBuilder sb = new StringBuilder();
        for(String s : cards) {
            sb.append(s+"<br/>");
        }
        return sb.toString();
    }

    public void addPrompt(String prompt) {
        File promptFile = new File("src/main/resources/static/prompt.txt");

        try(FileWriter fr = new FileWriter(promptFile, true)) {
            fr.write("\n" + prompt);
        }catch (IOException e){
            e.printStackTrace();
        }
        prompts.add(prompt);
    }

    public void addCard(String card) {
        File cardFile = new File("src/main/resources/static/card.txt");

        try(FileWriter fr = new FileWriter(cardFile, true)) {
            fr.write("\n" + card);
        }catch (IOException e){
            e.printStackTrace();
        }
        prompts.add(card);
    }
}

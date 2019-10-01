package com.ruhul.genetics;

import java.util.*;

public class GeneticsAlgo {


    Name name;
    List<GeneratedName> generatedNames = new ArrayList<GeneratedName>();
    int POPULATION_SIZE = 200;
    int currentGeneration = 0;

    public GeneticsAlgo(Name name){
        this.name = name;
    }

    public static void main(String[] args) {
        new GeneticsAlgo(new Name()).run();
    }


    public void run(){
        createRandomPopulation();
        boolean run = true;
        while(run) {
            run = checkPopulation();
            if(!run){
                break;
            }
            printPopulation();

            survivalOfTheFittest();
            printPopulation();
            crossover();
            printPopulation();
            System.out.println("--------------------");
            //break;
        }

    }

    private boolean checkPopulation() {

        for (GeneratedName gname : generatedNames) {
            if (gname.score == 100) {
                System.out.println("Succesfully predicted the name in generation ("+ currentGeneration+")" + gname);
                return false;
            }
        }
     return true;
    }

    private void crossover() {
        currentGeneration ++;
        Random rand = new Random();

        while(generatedNames.size() != POPULATION_SIZE){
            GeneratedName[] parent =  new GeneratedName[] {generatedNames.get(rand.nextInt(POPULATION_SIZE/2)),generatedNames.get(rand.nextInt(POPULATION_SIZE/2))};

            char nameChar[] = new char[name.getLength()];
            for(int i=0 ; i< name.getLength() ; i++){

                nameChar[i] = parent[rand.nextInt(2)].name.charAt(i);
            }

            String newName = new String(nameChar);
            int newScore = name.checkResult(newName);
            generatedNames.add(new GeneratedName(newName, newScore));


        }
        Collections.sort(generatedNames);
    }

    private void survivalOfTheFittest() {

        generatedNames.removeAll(generatedNames.subList(generatedNames.size()/2, generatedNames.size() -1));
    }

    private void printPopulation() {
        generatedNames.forEach(name -> System.out.println(name));
    }

    private void createRandomPopulation() {

     for (int i=0 ;i <POPULATION_SIZE; i++){

         String randomName = generateRandomString(name.getLength());
         GeneratedName gname = new GeneratedName(randomName, name.checkResult(randomName));
         generatedNames.add(gname);
     }

        Collections.sort(generatedNames);



    }

    private String generateRandomString(int length) {

        Random rand  = new Random();
        char randomChar[] = new char[length];
        for (int i = 0; i < length ;i++){
            int randInt = rand.nextInt(26) + 'a';
            randomChar[i] = (char) randInt;
        }
        return new String(randomChar);

    }

    private class GeneratedName implements Comparable<GeneratedName>{

        public String name;
        public int score;


        GeneratedName(String name, int score){

            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Predicted name='" + name + '\'' +
                    ", score=" + score;
        }

        @Override
        public int compareTo(GeneratedName o) {
            return -Integer.compare(this.score, o.score);
        }
    }
}

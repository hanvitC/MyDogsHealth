package Section4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RecFood {
    public MyDog mydog;
    public ArrayList<String> recfoods = new ArrayList<>();
    public String filename;

    public RecFood(MyDog d, String file) {
        mydog = d;
        filename = file;
    }

    public ArrayList<String> readRec() throws FileNotFoundException { // reading the list of recommended foods associated with the health condition;
        try {
            Scanner inFile = new Scanner(new File(filename));
            int specific_line = 0;

            while (inFile.hasNextLine()) {
                specific_line += 1; // and the line number
                String line = inFile.nextLine(); //read the line

                if (specific_line >= Findindex(filename) && specific_line < nextFindindex(filename)-2) {
                    // read the specific lines of health
                    String[] arrline = line.split(", ");
                    String foodname = arrline[0];

                    // add if the dog is allergic to something & the food does not contain the allergic food
                    if (!mydog.allergic.equalsIgnoreCase("no") && !Allergic(arrline)) recfoods.add(foodname);

                    // when not allergic
                    else if (mydog.allergic.equalsIgnoreCase("no")) recfoods.add(foodname);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return recfoods;
        }

    public void printRecFoods() {
        System.out.println("Here are the recommended dog foods for " + mydog.name + "! ");
        System.out.println("======================================");
        for (int i = 0; i < recfoods.size(); i++)
            System.out.println((i + 1) + ". " + recfoods.get(i));
        System.out.println("======================================");
        System.out.println();
    }

    private boolean Allergic(String[] arrline) { // tells if the list of foods contains allergic food
        List linelist = Arrays.asList(arrline);

        if (linelist.contains(mydog.allergic)) return true;
        return false;
    }

    private int Findindex(String filename) { // finding an index to start from a txt file
        try {
            Scanner in = new Scanner(new File(filename));
            int lineindex = 0;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                lineindex++;
                for (int i = 0; i < line.length(); i++) {
                    if (line.contains(String.valueOf(mydog.health)))
                        return lineindex + 1;// if found, return the index of where I need to start reading
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int nextFindindex(String filename) { // finding an index to start from a txt file
        try {
            Scanner nextin = new Scanner(new File(filename));
            int lineindex = 0;
            while (nextin.hasNextLine()) {
                String line = nextin.nextLine();
                lineindex++;
                for (int i = 0; i < line.length(); i++) {
                    if (line.contains(String.valueOf(mydog.health + 1)))
                        return lineindex + 1;// if found, return the index of where I need to start reading
                }
            }
            nextin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

package Section3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyDogsHealth {
    static Scanner kb = new Scanner(System.in);
    static String name;
    static String gender;

    public static void main(String[] args) {
        while (true) {
            System.out.println("My Dot's Health Management");
            System.out.println("Select the menu: Please type a number");

            System.out.println("1. <Find The Best Food For My Dog>");
            System.out.println("2. <When Should I Walk My Dog?>");
            System.out.println("3. <Personalize My Dog's Snacks>");
            System.out.println("4. <End the Program>");
            int menu = kb.nextInt();

            if (menu == 1) { //<Find The Best Food For My Dog>
                System.out.println("<Find The Best Food For My Dog>");
                System.out.println();
                //Q 0: name and gender of dog

                System.out.println("What's the name your dog?");
                name = kb.next();
                System.out.println("What's " + name + "'s gender?: Type F if female/ M if male ");
                gender = kb.next();


                System.out.println("Great! Let's find out what food will be the best for " + name + "! ");
                System.out.println("We will be asking you to answer 3 short questions.");
                System.out.println();
                System.out.println("Ready? Then type 'YES' ! :)");
                String yes = kb.next();
                if (!yes.equalsIgnoreCase("YES")) {
                    System.out.println("Ok that's fine...");
                    System.out.println("Bye!");
                    break;
                }

                System.out.println();

                int size = Size(name);    // Q 1: size
                int age = Age(size);     // Q 2: age
                int health = Health(name);  // Q 3: Current health issues

                // Recommended Dog food
                String rec = FoodRec(name, age, health);
                System.out.println("Here are the recommended dog foods for " + name + "! ");
                System.out.println(rec);


            } else if (menu == 2) { //<When Should I Walk My Dog>
                System.out.println("<When Should I Walk My Dog?>");
                System.out.println();

                // Q 0: name of dog
                System.out.println("What's the name your dog?");
                name = kb.next();

                System.out.println("Great! Let's find out when you should walk " + name + "! ");
                System.out.println("We will be asking you to answer # short questions.");
                System.out.println();

                System.out.println("Ready? Then type 'YES' ! :)");
                String yes = kb.next();
                if (!yes.equalsIgnoreCase("YES")) {
                    System.out.println("Ok Thank you");
                    System.out.println("Bye!");
                    break;
                }


            } else if (menu == 3) { // <Personalize My Dog's Snacks>

            } else break;


        }
    }

    /////////////////
    private static String FoodRec(String name, int age, int health) {
        String recommended = null;
        if (age == 1) { //puppies
            read("pfoodrec.txt", );
            recommended = "";
        } else if (age == 2) { //adults
            read("afoodrec.txt");
            recommended = "";
        } else if (age == 3) { //seniors
            read("sfoodrec.txt");
            recommended = "";
        }
        return recommended;
    }


    private static void read(String filename) {
        try {
            Scanner inFile = new Scanner(new File(filename));

            find();
            while (inFile.hasNextLine()) {
                // expected array of string data
                // foodname grain ingred ingred ...
                String line = inFile.next(); // reading a sentence
                String[] data = line.split(",");
                String foodname = data[0];
                String grain = data[1];
                String ingred[] = new String[data.length - 2];
                for (int i = 2; i < data.length; i++) {
                    if (ingred != null) {
                        ingred[i - 2] = data[i];
                    }
                }
            }
            inFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("No file found");
            return;
        }
    }


    private static int Health(String name) {
        System.out.println("Q 3. Does " + name + " currently have any health issues? : Please type a number from these options");
        // healthy ? answers based on gender
        if (gender.equals("F")) System.out.println("  1. She is healthy!");
        else System.out.println("  1. He is healthy!");

        // other health issues options
        System.out.println("  2. Sensitive Stomach");
        System.out.println("  3. Sensitive Skins ");
        System.out.println("  4. Obesity ");
        System.out.println("  5. Weak Bones");
        int health = kb.nextInt();
        // in case the user puts a wrong answer
        if (health > 5 || health < 0) throw new IllegalArgumentException("Oops! Please type it again");

        //any food that the puppy can't eat
        if (gender.equals("F")) System.out.println("Does she have any food allergies? : Please type a number");
        else System.out.println("Does he have any food allergies? : Please type a number");
        Allergies(name);
        // otherwise, continue

        return health;
    }

    private static int Allergies(String name) {
        System.out.println("Please specify which food " + name + " is allergic to. : Please type a number from these options");
        System.out.println();
        System.out.println("  20. No, my dog is fine with anything.");
        System.out.println("  21. I don't exactly know what it is.");
        System.out.println("  22. Beef");
        System.out.println("  23. Chicken");
        System.out.println("  24. Milk");
        System.out.println("  25. Grain");
        System.out.println("  26. Eggs");


        int allergic = kb.nextInt();
        // in case the user puts a wrong answer
        if (allergic > 26 || allergic < 20) throw new IllegalArgumentException("Oops! Please type it again");
        return allergic;

    }

    private static int Age(int size) {
        if (gender.equals("F")) System.out.println("Q 2. How old is she ?: Please type a number from these options");
        else System.out.println("Q 2. How old is he ? : Please type a number");

        if (size == 1) { // if small
            System.out.println("  1. 2 years old or younger"); // puppies
            System.out.println("  2. 2 years old ~ 8 years old"); // adults
            System.out.println("  3. 8 years old or older"); // seniors

        } else if (size == 2) { // medium
            System.out.println("  1. 2 years old or younger");
            System.out.println("  2. 2 years old ~ 7 years old");
            System.out.println("  3. 7 years old or older");

        } else if (size == 3) { // if large
            System.out.println("  1. 3 years old or younger");
            System.out.println("  2. 3 years old ~ 6 years old");
            System.out.println("  3. 6 years old or older");
        }
        int age = kb.nextInt();

        // in case user types the answer wrong
        if (age < 0 || age > 4) throw new IllegalArgumentException("Oops! Please type it again");
        return age;
    }

    private static int Size(String name) {
        System.out.println("Q 1. How big is " + name + "? : Please type a number from these options");
        System.out.println("  1. Small (Under 10 kg) ");
        System.out.println("  2. Medium (10kg ~ 24 kg) ");
        System.out.println("  3. Large (25 kg or above) ");
        int size = kb.nextInt();

        // in case the user types the answer wrong
        if (size > 3 || size < 0)
            throw new IllegalArgumentException("Oops! Please type it again");
        return size;
    }


}

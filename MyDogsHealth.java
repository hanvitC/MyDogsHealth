package Section4;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyDogsHealth {
    static Scanner kb = new Scanner(System.in);
    // FindBestDogFood
    public MyDog myDog = new MyDog("a", "s", 0, 0, 0, "f");
    public RecFood rec;
    public String filename;
    
    // WhenToWalk

    public static void main(String[] args) throws FileNotFoundException {

        MyDogsHealth best = new MyDogsHealth();

        while (true) {
            System.out.println("My Dog's Health Management");
            System.out.println("Select the menu: Please type a number");

            System.out.println("1. <Find The Best Food For My Dog>");
            System.out.println("2. <When Should I Walk My Dog?>");
            System.out.println("3. <Personalize My Dog's Snacks>");
            System.out.println("4. <End the Program>");
            int menu = kb.nextInt();

            if (menu == 1) { //<Find The Best Food For My Dog>
                best.process_1();

            } else if (menu == 2) { //<When Should I Walk My Dog>
                //needs to be worked on!

            } else if (menu == 3) { // <Personalize My Dog's Snacks>
                //needs to be worked on!
            } else break;
        }
    }

    public void process_1() throws FileNotFoundException {
        while (true) {
            System.out.println("<Find The Best Food For My Dog>");

            System.out.println();
            //Q 0: name and gender of dog

            System.out.println("What's the name your dog?");
            myDog.name = kb.next();
            System.out.println("What's " + myDog.name + "'s gender?: Type F if female/ M if male ");
            myDog.gender = kb.next();

            System.out.println("Great! Let's find out what food will be the best for " + myDog.name + "! ");
            System.out.println("We will be asking you to answer 3 short questions.");
            System.out.println();

            myDog.size =  myDog.Size(); //Q1
            myDog.age = myDog.Age(); //Q2
            myDog.health = myDog.Health(); //Q3-1
            myDog.allergic = myDog.Allergies(); //Q3-2

            if (myDog.age == 1) //puppies
                filename = "pfoodrec.txt";
            else if (myDog.age == 2) //adults
                filename = "afoodrec.txt";
            else if (myDog.age == 3) //seniors
                filename = "sfoodrec.txt";

            rec = new RecFood(myDog,filename);
            rec.readRec();
            rec.printRecFoods();
        }
    }


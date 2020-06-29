package Section4;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyDogsHealth {
    static Scanner kb = new Scanner(System.in);
    // FindBestDogFood
    public MyDog myDog = new MyDog("a", "s", 0, 0, 0, "f");
    public String filename;

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
                best.prcess_2();

            } else if (menu == 3) { // <Personalize My Dog's Snacks>

            } else break;
        }
    }
    public void process_1() throws FileNotFoundException {
        System.out.println("<Find The Best Food For My Dog>");
        System.out.println();
        System.out.println("What's the name your dog?"); //Q 0: name and gender of dog
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

        if (myDog.age == 1) filename = "pfoodrec.txt";
        else if (myDog.age == 2) filename = "afoodrec.txt";
        else if (myDog.age == 3) filename = "sfoodrec.txt";

        RecFood rec = new RecFood(myDog,filename);
        rec.readRec();
        rec.printRecFoods();
    }
    private void prcess_2() {
        System.out.println("<우리 강아지 산책 주기 추천 프로그램>");
        System.out.println();
        System.out.println("강아지의 이름이 뭔가요?"); // Q 0: name of dog
        myDog.name = kb.next();

        System.out.println("알겠습니다 :) 그럼 저희가 언제 " + myDog.name + " 산책을 하면 좋을 지 추천 해 드릴게요! ");
        System.out.println("총 2가지의 질문을 드릴거에요 잘 대답해 주세요!");
        System.out.println();

        myDog.freq = myDog.Freq();// Q1: freq
        WhenToWalk walklist = new WhenToWalk(myDog, "walkdog.txt"); // create WhenToWalk object

        walklist.readFile(); // reads walkdog.txt
        walklist.Unav(); // Q2: list of unav. dates inputted by user
        walklist.printWalkDays();
    }
}

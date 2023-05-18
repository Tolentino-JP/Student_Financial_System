//import java.io.*;
import java.util.*;

public class Student_Financial_System{
    static Scanner pasok = new Scanner(System.in);
    static financial student = new financial();
    static int match;
    
    public static void info(){
        String c;
        System.out.print("Input your Student ID: ");
        c = pasok.nextLine();
        student.id[0] = c;

        System.out.print("Input your Name: ");
        c = pasok.nextLine();
        student.name[0] = c;

        System.out.println("\nCourses: BSTM, BSE, BSP, BSCS, BSEMC, BSIT");
        System.out.print("\nInput your Course: ");
        c = pasok.nextLine();
        student.course[0] = c;

        System.out.print("\nInput how much Tuition Fee in "+ student.course[0] +": ₱ ");
        int money = pasok.nextInt();
        student.tuition[0] = money;

        System.out.print("Input how much Miscellaneous Fee in "+ student.course[0] +": ₱ ");
        money = pasok.nextInt();
        student.misc_fee[0] = money;

        System.out.print("Input how much Non-School Fees: ₱ ");
        money = pasok.nextInt();
        student.non_school[0] = money;

        System.out.print("Input how much you have already paid: ₱");
        money = pasok.nextInt();
        student.already_paid[0] = money;

        student.total_fees[0] = student.tuition[0] + student.misc_fee[0] + student.non_school[0];
        System.out.print("\033[H\033[2J");

    }// end info

    public static void choice(){
        System.out.println(" ____________________INFORMATION____________________");
        System.out.println("                                                    ");
        System.out.println("     Student ID: "+ student.id[0]                    );
        System.out.println("     Student Name: "+ student.name[0]                );
        System.out.println("     Course: "+ student.course[0]                    );
        System.out.println("                                                    ");
        System.out.println("     Total Fees: ₱"+ student.total_fees[0]           );
        System.out.println("     Paid: ₱"+ student.already_paid[0]               );
        System.out.println("                                                    ");
        System.out.println(" ___________________________________________________");
        System.out.println(" ___________________________________________________");
        System.out.println("|                                                   |");
        System.out.println("|    What do you want to do?                        |");
        System.out.println("|                                                   |");
        System.out.println("|    1. Check Balance                               |");
        System.out.println("|    2. Pay School Fees                             |");
        System.out.println("|    3. Offered Subjects                            |");
        System.out.println("|    4. New Student Login                           |");
        System.out.println("|    5. Add Scholarship                             |");
        System.out.println("|    6. Quit                                        |");
        System.out.println("|___________________________________________________|");

        System.out.print("Enter your choice: ");
        int option = pasok.nextInt();
        pasok.nextLine();
        System.out.print("\033[H\033[2J");
        switch(option){
            case 1:
                balance();
                choice();
                break;
            case 2:
                pay();
                choice();
                break;
            case 3:
                subject();
                choice();
                break;
            case 4:
                match = 1;
                break;
            case 6:
                match = 2;
                break;
            case 5:
                break;
        }
        
    }// end  choice

    public static void balance(){
        char main_menu;
        int balance = student.total_fees[0] - student.already_paid[0];
        System.out.println("You want to check Balance.");
        System.out.println("Your Balance is ₱"+ balance);

        do{
            System.out.print("\n\nDo you want to go back to main menu (y/n)? ");
            main_menu = pasok.next().charAt(0);
        }while(main_menu == 'n');
        System.out.print("\033[H\033[2J");
       
        
    }// end balance

    public static void pay(){
        int money = 0;
        System.out.println("You want to pay School Fees...");
        System.out.println("How much you want to pay? ");
        System.out.print("Input ammount: ₱ ");
        money = pasok.nextInt();
        student.already_paid[0] += money;
        int balance = student.total_fees[0] - student.already_paid[0];
        System.out.println("Updated Balance: "+ balance);
        
    }

    public static void subject(){
        if(student.course[0].equals("BSTM")){
            System.out.println("BSTM:");
            System.out.println("     First Semester:                            Second Semester: ");
            System.out.println("                    •PATH-F1                                    •PATH-F2 ");
            System.out.println("                    •FAITH01                                    •NSTP 200");
            System.out.println("                    •RISKMGT                                    •THQUALI ");
            System.out.println("                    •MACRO++                                    •PERTOUR ");
            System.out.println("                    •PHTOUR+                                    •GESELF+ ");
            System.out.println("                    •JOSERIZ                                    •GEHISTO ");
            System.out.println("                    •FORLAN1                                    •GEWORLD ");
            System.out.println("                    •NSTP100                                    •FORLAN2 ");
        }else if(student.course[0].equals("BSE")){
            System.out.println("BSE:");
            System.out.println("     First Semester:                            Second Semester: ");
            System.out.println("                    •CPE-CP1                                    •GELIT01");
            System.out.println("                    •CHE-GEN                                    •CHE-C4E");
            System.out.println("                    •GEMATH+                                    •MATH-01");
            System.out.println("                    •GESELF+                                    •GEHISTO");
            System.out.println("                    •MATH+++                                    •MATH-03");
            System.out.println("                    •NSTP100                                    •JOSERIZ");
            System.out.println("                    •PATH-F1                                    •NSTP200");
            System.out.println("                                                                •PATH-F2");
            System.out.println("                                                                •CE-CAD1");
        }else if(student.course[0].equals("BSP")){
            System.out.println("BSP:");
            System.out.println("     First Semester:                            Second Semester: ");
            System.out.println("                    •GEFIL01                                    •GEFIL02");
            System.out.println("                    •FAITH01                                    •GEMATH+");
            System.out.println("                    •GEWORLD                                    •GESELF+");
            System.out.println("                    •NSTP100                                    •BIOLOGY");
            System.out.println("                    •PATH-F1                                    •NSTP200");
            System.out.println("                    •INTPSYC                                    •GESCIE+");
            System.out.println("                                                                •PSYSTAT");
            System.out.println("                                                                •PATH-F2");   
        }else if(student.course[0].equals("BSCS")){
            System.out.println("BSCS:");
            System.out.println("     First Semester:                            Second Semester: ");
            System.out.println("                    •GEMATH+                                    •NSTP200");
            System.out.println("                    •ITECC01                                    •CSSP101");
            System.out.println("                    •ITECC02                                    •ITECC04");
            System.out.println("                    •GECOMM+                                    •PATH-F2");
            System.out.println("                    •FAITH01                                    •DIFCAL+");
            System.out.println("                    •PATH-F1                                    •GEEMIND");
            System.out.println("                    •NSTP100                                    •GEWORLD");
            System.out.println("                                                                •ITECC03");
        }else if(student.course[0].equals("BSEMC")){
            System.out.println("BSEMC:");
            System.out.println("      First Semester:                            Second Semester: ");
            System.out.println("                     •GEMATH+                                    •NSTP200");
            System.out.println("                     •ITECC01                                    •ITECC04");
            System.out.println("                     •ITECC02                                    •PATH-F2");
            System.out.println("                     •GECOMM+                                    •2DANIMA");
            System.out.println("                     •FAITH01                                    •GEEMIND");
            System.out.println("                     •FREEHDD                                    •INTROGD");
            System.out.println("                     •PATH-F1                                    •GEWORLD");
            System.out.println("                     •NSTP100                                    •ITECC03");
        }else if(student.course[0].equals("BSIT")){
            System.out.println("BSIT:");
            System.out.println("     First Semester:                            Second Semester: ");
            System.out.println("                    •GEMATH+                                    •NSTP200");
            System.out.println("                    •ITECC01                                    •PROETHS");
            System.out.println("                    •ITECC02                                    •ITECC04");
            System.out.println("                    •GECOMM+                                    •PATH-F2");
            System.out.println("                    •FAITH01                                    •DIFCAL+");
            System.out.println("                    •PATH-F1                                    •GEEMIND");
            System.out.println("                    •NSTP100                                    •GEWORLD");
            System.out.println("                                                                •ITECC03");
        }else{
            System.out.println(student.course[0]+" is not available in the system....");
        }
        char main_menu;
        do{
            System.out.print("\n\nDo you want to go back to main menu (y/n)? ");
            main_menu = pasok.next().charAt(0);
        }while(main_menu == 'n');
        System.out.print("\033[H\033[2J");
    }// end subject

    public static void sholarship(){
        System.out.println(" __________________________________________________");
        System.out.println("|                                                  |");
        System.out.println("|     Scholarships:                                |");
        System.out.println("|                                                  |");
        System.out.println("|     1. Jose Rizal                                |");
        System.out.println("|     2. Apolinario Mabini                         |");
        System.out.println("|     3. Emilio Aguinaldo                          |");
        System.out.println("|     4. Manuel Quezon                             |");
        System.out.println("|     5. 100TAG                                    |");
        System.out.println("|     6. 50TAG                                     |");
        System.out.println("|     7. No Scholarship                            |");
        System.out.println("|                                                  |");
        System.out.println("|__________________________________________________|");

        System.out.print("What is  you scholarship?? ");
        String scan = pasok.nextLine();
        student.s_scholarship[0] = scan;

        if(student.s_scholarship[0].equals("Jose Rizal")){
            
        }

    }

    public static void main(String [] args){

        balik:
        while(true){
            match = 0;
            info();
            choice();
    
            if(match == 1){
                continue balik;
            }else if(match == 2){
                break balik;
            }
                
                    
        }//end while

    }// end void main
}// end public class

class financial{
    public String[] id = new String[1];
    public String[] name = new String[1];
    public String[] course = new String[1];
    public String[] s_scholarship = new String[1];
    public int[] tuition = new int[1];
    public int[] misc_fee = new int[1];
    public int[] non_school = new int[1];
    public int[] total_fees = new int[1];
    public int[] already_paid = new int[1];
    
}// end financial
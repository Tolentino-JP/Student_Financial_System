//import java.io.*;
import java.util.*;

public class Student_Financial_System{
    public static Scanner pasok = new Scanner(System.in);
    public static financial student = new financial();
    public static int match, success=-1;
    

    public static void register(){
        String c;
        int times = 0;
        System.out.print("Input your Student ID: ");
        //pasok.nextLine();
        c = pasok.nextLine();
        student.id.add(times, c);

        System.out.print("Input your Name: ");
        c = pasok.nextLine();
        student.name.add(times, c);

        System.out.println("\nCourses: BSTM, BSE, BSP, BSCS, BSEMC, BSIT");
        System.out.print("\nInput your Course: ");
        c = pasok.nextLine();
        student.course.add(times, c);

        System.out.print("\nInput how much Tuition Fee in "+ student.course.get(times) +": ₱ ");
        int money = pasok.nextInt();
        student.tuition.add(times, money);

        System.out.print("Input how much Registration and Miscellaneous Fee in "+ student.course.get(times) +": ₱ ");
        money = pasok.nextInt();
        student.misc_fee.add(times, money);

        System.out.print("Input how much Non-School Fees in "+ student.course.get(times) +": ₱ ");
        money = pasok.nextInt();
        student.non_school.add(times, money);

        System.out.print("Input how much you have already paid: ₱ ");
        money = pasok.nextInt();
        student.already_paid.add(times, money);

        student.total_fees.add(times, student.tuition.get(times) + student.misc_fee.get(times) + student.non_school.get(times));
        System.out.print("\033[H\033[2J");

        

        times++;

    }// end info

    public static void login(){
        System.out.print("Input your Student ID: ");
        String c = pasok.nextLine();
        for(int i=0;i<student.id.size();i++){
            if(student.id.get(i).equals(c)){
                success = i;
                System.out.println("You have LogIn successfully.\n");

                choice();
                break;
            }
        }
        if(success == -1){
            char main_menu;
            System.out.println("No records of \""+ c +"\" in the system....\n");
            do{
                System.out.print("Do you want to go back to main menu (y/n)? ");
                main_menu = pasok.next().charAt(0);
            }while(main_menu != 'y');
        }
        System.out.print("\033[H\033[2J");

    }

    public static void choice(){
        System.out.println(" ____________________INFORMATION____________________");
        System.out.println("                                                    ");
        System.out.println("     Student ID: "+ student.id.get(success));
        System.out.println("     Student Name: "+ student.name.get(success));
        System.out.println("     Course: "+ student.course.get(success));
        System.out.println("                                                    ");
        System.out.println("     Total Fees: ₱"+ student.total_fees.get(success)           );
        System.out.println("     Paid: ₱"+ student.already_paid.get(success)               );
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
                break;
            case 6:
                match = 2;
                break;
            case 5:
                scholarship();
                choice();
                break;
        }
        
    }// end  choice

    public static void balance(){
        char main_menu;
        double balance = student.total_fees.get(success) - student.already_paid.get(success);
        System.out.println("You want to check Balance.");
        System.out.println("Your Balance is ₱"+ balance +"\n");

        do{
            System.out.print("Do you want to go back to main menu (y/n)? ");
            main_menu = pasok.next().charAt(0);
        }while(main_menu != 'y');
        System.out.print("\033[H\033[2J");
       
        
    }// end balance

    public static void pay(){
        int money = 0;
        char main_menu;
        System.out.println("You want to pay School Fees...");
        System.out.println("How much you want to pay? ");
        System.out.print("Input ammount: ₱ ");
        money = pasok.nextInt();
        student.already_paid.set(success, student.already_paid.get(success)+money);
        int balance = student.total_fees.get(success) - student.already_paid.get(success);
        System.out.println("Updated Balance: "+ balance +"\n");

        do{
            System.out.print("Do you want to go back to main menu (y/n)? ");
            main_menu = pasok.next().charAt(0);
        }while(main_menu != 'y');
        System.out.print("\033[H\033[2J");
        
    }

    public static void subject(){
        if(student.course.get(success).equals("BSTM")){
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
        }else if(student.course.get(success).equals("BSE")){
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
        }else if(student.course.get(success).equals("BSP")){
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
        }else if(student.course.get(success).equals("BSCS")){
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
        }else if(student.course.get(success).equals("BSEMC")){
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
        }else if(student.course.get(success).equals("BSIT")){
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
            System.out.println(student.course.get(success)+" course is not available in the system....");
        }
        char main_menu;
        System.out.println();
        do{
            System.out.print("Do you want to go back to main menu (y/n)? ");
            main_menu = pasok.next().charAt(0);
        }while(main_menu != 'y');
        System.out.print("\033[H\033[2J");
    }// end subject

    public static void scholarship(){
        // FIX SCHOLARSHIP
        ArrayList<Integer> scholar = new ArrayList<>(student.non_school);
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
        int scan = pasok.nextInt();
        scholar.set(success, scan);
        System.out.print("\033[H\033[2J");
        if(scholar.get(success) == 1){
            System.out.println("You have Jose Rizal Scholarship.");
            System.out.println("Jose Rizal: ");
            System.out.println("           •100% discount on tuition fees");
            System.out.println("           •100% discount on registration and miscellaneous fees");
            System.out.println("           •P2,500.00 stipend/month");
            System.out.println("           •P2,000.00 book allowance/semester");
            student.tuition.set(success, student.tuition.get(success)-(student.tuition.get(success)*1));
            student.misc_fee.set(success, student.misc_fee.get(success)-(student.misc_fee.get(success)*1));
            student.total_fees.set(success, student.tuition.get(success) + student.misc_fee.get(success) + student.non_school.get(success));

        }else if(scholar.get(success) == 2){
            System.out.println("You have Apolinario Mabini Scholarship.");
            System.out.println("Apolinario Mabini: ");
            System.out.println("                  •100% discount on tuition fees");
            System.out.println("                  •100% discount on registration and miscellaneous fees");
            System.out.println("                  •P1,000.00 stipend/month");
            System.out.println("                  •P1,000.00 book allowance/semester");

            student.tuition.set(success, student.tuition.get(success)-(student.tuition.get(success)*1));
            student.misc_fee.set(success, student.misc_fee.get(success)-(student.misc_fee.get(success)*1));
            student.total_fees.set(success, student.tuition.get(success) + student.misc_fee.get(success) + student.non_school.get(success));

        }else if(scholar.get(success) == 3){
            System.out.println("You have Emilio Aguinaldo Scholarship.");
            System.out.println("Emilio Aguinaldo: ");
            System.out.println("                 •100% discount on tuition fees");
            System.out.println("                 •100% discount on registration and miscellaneous fees");

            student.tuition.set(success, student.tuition.get(success)-(student.tuition.get(success)*1));
            student.misc_fee.set(success, student.misc_fee.get(success)-(student.misc_fee.get(success)*1));
            student.total_fees.set(success, student.tuition.get(success) + student.misc_fee.get(success) + student.non_school.get(success));

        }else if(scholar.get(success) == 4){
            System.out.println("You have Manuel Quezon Scholarship.");
            System.out.println("Manuel Quezon: ");
            System.out.println("              •100% discount on tuition fees");
            System.out.println("              •50% discount on registration and miscellaneous fees");
            
            double new_misc_fee = student.misc_fee.get(success)-(student.misc_fee.get(success)*0.5);
            int converted = (int) new_misc_fee;
            
            student.tuition.set(success, student.tuition.get(success)-(student.tuition.get(success)*1));
            student.misc_fee.set(success, converted);
            student.total_fees.set(success, student.tuition.get(success) + student.misc_fee.get(success) + student.non_school.get(success));
            
        }else if(scholar.get(success) == 6){
            System.out.println("You have 50TAG Scholarship.");
            System.out.println("50TAG: ");
            System.out.println("      •50% discount on tuition fees"); 

            double new_misc_fee = student.tuition.get(success)-(student.tuition.get(success)*0.5);
            int converted = (int) new_misc_fee;
            
            student.tuition.set(success, converted);
            student.total_fees.set(success, student.tuition.get(success) + student.misc_fee.get(success) + student.non_school.get(success));
            
        }else if(scholar.get(success) == 5){
            System.out.println("You have 100TAG Scholarship.");
            System.out.println("100TAG: ");
            System.out.println("      •100% discount on tuition fees");

            student.tuition.set(success, student.tuition.get(success)-(student.tuition.get(success)*1));
            student.total_fees.set(success, student.tuition.get(success) + student.misc_fee.get(success) + student.non_school.get(success));
            
        }else if(scholar.get(success) == 7){
            System.out.println("You do not have any Scholarships...");
            
        }
        char main_menu;
        System.out.println();
        do{
            System.out.print("Do you want to go back to main menu (y/n)? ");
            main_menu = pasok.next().charAt(0);
        }while(main_menu != 'y');
        System.out.print("\033[H\033[2J");

    }

    public static void main(String [] args){

        balik:
        while(true){

            System.out.println(" __________________________________________________");
            System.out.println("|                                                  |");
            System.out.println("|     HELLO STUDENT!                               |");
            System.out.println("|                                                  |");
            System.out.println("|     1. Register an account                       |");
            System.out.println("|     2. LogIn an account                          |");
            System.out.println("|                                                  |");
            System.out.println("|                                                  |");
            System.out.println("|__________________________________________________|");
            System.out.print("What do you want to do?? ");
            int choice = pasok.nextInt();
            pasok.nextLine();
            switch(choice){
                case 1:
                    System.out.print("\033[H\033[2J"); 
                    register();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    login();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    System.out.print("\033[H\033[2J");
            }

            if(match == 2){
                break balik;
            }
                    
        }//end while

    }// end void main
}// end public class

class financial{
    public ArrayList<String> id = new ArrayList<>();
    public ArrayList<String> name = new ArrayList<>();
    public ArrayList<String> course = new ArrayList<>();
    public ArrayList<Integer> tuition = new ArrayList<>();
    public ArrayList<Integer> misc_fee = new ArrayList<>();
    public ArrayList<Integer> non_school = new ArrayList<>();
    public ArrayList<Integer> total_fees = new ArrayList<>();
    public ArrayList<Integer> already_paid = new ArrayList<>();
    public Stack<Integer> s_scholarship = new Stack<>();
}// end financial

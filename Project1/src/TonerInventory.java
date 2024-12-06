import java.util.Scanner;

public class TonerInventory {
    public static void main(String[]args){
        Scanner scanner = new Scanner (System.in);
        Function1 func = new Function1();

        int choice;

        do{
            System.out.println("-----------------");
            System.out.println("-TONER-INVENTORY-");
            System.out.println("-----------------");
            System.out.println();
            System.out.println("1. Add toner\n2. View all toner\n3. Mark toner as used\n4. Remove toner\n5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1: System.out.println("Enter toner name: ");
                String tonerName = scanner.nextLine();
                func.addToner(tonerName);
                break;
                case 2: func.viewToner();
                break;
                case 3: System.out.println("Enter toner number: ");
                int index = scanner.nextInt();
                func.markTonerAsUsed(index);
                break;
                case 4: System.out.println("Enter toner number: ");
                int remIndex = scanner.nextInt();
                func.removeToner(remIndex);
                break;
                case 5: System.out.println("Exiting...");
                break;
                default: System.out.println("Invalid input!");
                break;


            }
        }while(choice != 5);
        scanner.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        University university = new University();
        while(true){
            System.out.println("             ----------------Menu-----------------");
            System.out.println("             add Employee               : 1       |");
            System.out.println("             add Partner                : 2       |");
            System.out.println("             employee[id] is married?   : 3       |");
            System.out.println("             employee[id] is invited?   : 4       |");
            System.out.println("             list invited employee      : 5       |");
            System.out.println("             Exit                       : 6       |");
            System.out.println("             Which option do you choose? :        ");
            int result = input.nextInt();
            System.out.println("             ----------------****-----------------");

            if (result==1) {
                university.AddEmployee();
            }else if (result==2) {
                university.AddPartner();
            }else if (result==3) {
                university.IsMarried();
            }else if (result==4) {
                university.checkInvited();
            }else if (result==5) {
                university.invitedEmployees();
            }else if (result==6) {
                break;
            }
        }
    }
}

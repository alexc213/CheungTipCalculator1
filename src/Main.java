import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!");

        System.out.print("How many people are in your group? ");
        int people = scan.nextInt();
        scan.nextLine();

        System.out.print("What is the tip percentage? ");
        double tipPercentage = scan.nextDouble();
        scan.nextLine();
        while (tipPercentage<0 || tipPercentage>100){
            System.out.print("Please enter a number between 0 and 100: ");
            tipPercentage = scan.nextDouble();
            scan.nextLine();
        }

        System.out.print("Please enter a cost: ");
        double input = scan.nextDouble();
        scan.nextLine();
        double totalCost = input ;

        while (input!=-1){
            while (input<0) {
                System.out.print("Please enter -1 or a positive number: ");
                input = scan.nextDouble();
                scan.nextLine();
            }
            while(input!=-1) {
                System.out.print("Please enter a cost or -1 to stop: ");
                input = scan.nextDouble();
                scan.nextLine();
                totalCost += input;
            }
        }

        double totalTip =  totalCost * (tipPercentage/100);
        double totalBill = totalCost + totalTip;
        double billPerPerson = totalCost/people;
        double tipPerPerson = totalTip/people;
        double totalCostPerPerson = billPerPerson + tipPerPerson;
        System.out.println();
        System.out.println("Total bill before tip: " + formatter.format(totalCost));
        System.out.println("Tip percentage: " + formatter.format(tipPercentage));
        System.out.println("Total tip: " + formatter.format(totalTip));
        System.out.println("Total bill with tip: " + formatter.format(totalBill));
        System.out.println("Per person cost before tip: " + formatter.format(billPerPerson));
        System.out.println("Tip per person: " + formatter.format(tipPerPerson));
        System.out.println("Total cost per person: " + formatter.format(totalCostPerPerson));

    }
}
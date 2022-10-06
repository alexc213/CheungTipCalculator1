import java.util.Scanner;
import java.text.DecimalFormat;
public class TipCalculatorRunner {
    public static void main(String[] args) {
        //objects
        DecimalFormat formatter = new DecimalFormat("#.##");
        Scanner scan = new Scanner(System.in);
        //welcome
        System.out.println("Welcome to the tip calculator!");
        //people
        System.out.print("How many people are in your group? ");
        int people = scan.nextInt();
        scan.nextLine();
        //tip percent
        System.out.print("What is the tip percentage? ");
        int tipPercentage = scan.nextInt();
        scan.nextLine();
        //between 0 and 100
        while (tipPercentage<0 || tipPercentage>100){
            System.out.print("Please enter a number between 0 and 100: ");
            tipPercentage = scan.nextInt();
            scan.nextLine();
        }
        //tip calculator object
        TipCalculator tip = new TipCalculator(people, tipPercentage);

        double input=0;
        //asking for other costs
        while (input!=-1){
            System.out.print("Please enter a cost or -1 to stop: ");
            input = scan.nextDouble();
            scan.nextLine();
            //prevents -1 from being added to final total cost
            if (input!=-1) {
                tip.addMeal(input);;
            }
        }

        //printing
        System.out.println("Total bill before tip: " + formatter.format(tip.getTotalBillBeforeTip()));
        System.out.println("Tip percentage: " + formatter.format(tip.getTipPercentage()));
        System.out.println("Total tip: " + formatter.format(tip.tipAmount()));
        System.out.println("Total bill with tip: " + formatter.format(tip.totalBill()));
        System.out.println("Per person cost before tip: " + formatter.format(tip.perPersonCostBeforeTip()));
        System.out.println("Tip per person: " + formatter.format(tip.perPersonTipAmount()));
        System.out.println("Total cost per person: " + formatter.format(tip.perPersonTotalCost()));

    }
}
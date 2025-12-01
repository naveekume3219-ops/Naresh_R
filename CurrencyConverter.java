import java.util.Scanner;

class CurrencyConverter {

    public static String selectCurrency(Scanner sc, String message) {
        System.out.print(message);
        return sc.next().toUpperCase();
    }
    public static double getRate(String base, String target) {
        if (base.equals("USD") && target.equals("INR")) return 83.20;
        if (base.equals("INR") && target.equals("USD")) return 0.012;
        if (base.equals("USD") && target.equals("EUR")) return 0.92;
        if (base.equals("EUR") && target.equals("USD")) return 1.09;
        if (base.equals("INR") && target.equals("EUR")) return 0.011;
        if (base.equals("EUR") && target.equals("INR")) return 89.50;

        return -1;
    }

    public static double convert(double amount, double rate) {
        return amount * rate;
    }

    public static void displayResult(double amount, String base, double converted, String target) {
        System.out.println("\n===== Conversion Result =====");
        System.out.println(amount + " " + base + " = " + converted + " " + target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Currency Converter =====");

        String base = selectCurrency(sc, "Enter base currency (USD, INR, EUR): ");

        String target = selectCurrency(sc, "Enter target currency: ");

        double rate = getRate(base, target);

        if (rate == -1) {
            System.out.println("❌ Unsupported currency conversion.");
            return;
        }

        System.out.print("Enter amount in " + base + ": ");
        double amount = sc.nextDouble();

        double convertedAmount = convert(amount, rate);

        displayResult(amount, base, convertedAmount, target);

        sc.close();
    }
}

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().getAmountPerPeriod();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRound(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double getRound(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void getAmountPerPeriod() {
        int period;
        int action;
        int amount;
        double resultOut = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        /* Я бы разбил на 3 строки, ибо в одну строку не очень информативно выглядит*/
        action = scanner.nextInt();

        if (action == 1) {
            resultOut = calculateSimplePercent(amount, 0.06, period);// Целесообразно 0,06 вынести в переменную и назвать ее так чтобы было понятно, что это годовая процентная ставка
        } else if (action == 2) {
            resultOut = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultOut);
    }
}

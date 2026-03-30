import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        InputValidator input = new InputValidator(scanner);

        int option;

        do {
            System.out.println("\n=== JAVA CALCULATOR ===");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("0 - Sair");

            option = input.readOption();

            if (option == 0) {
                System.out.println("Encerrando calculadora...");
                break;
            }

            double a = input.readDouble("Digite o primeiro número: ");
            double b = input.readDouble("Digite o segundo número: ");

            try {
                double result;

                switch (option) {
                    case 1 -> result = calculator.add(a, b);
                    case 2 -> result = calculator.subtract(a, b);
                    case 3 -> result = calculator.multiply(a, b);
                    case 4 -> result = calculator.divide(a, b);
                    default -> {
                        System.out.println("Opção inválida.");
                        continue;
                    }
                }

                System.out.println("Resultado: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (true);

        scanner.close();
    }
}
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double value1;
        Double value2;
        String operation;
        boolean loading;

        try {
            do {

                //Primeiro valor necessário para fazer a conta
                System.out.println("Digite o primeiro valor desejado: ");

                //While para caso o valor seja diferente do necessário
                while (!scanner.hasNextDouble()) {
                    System.out.println("Por favor, insira um número válido: ");
                    scanner.next();
                }
                value1 = scanner.nextDouble();

                // Operação necessária para realizar a conta
                System.out.println("Digite a operação desejada ( +, -, /, *): ");

                //While para caso a operação seja diferente do necessário
                while (!scanner.hasNext("[+\\-*/]")) {
                    System.out.println("Por favor, insira uma operação válida: ");
                    scanner.next();
                }
                operation = scanner.next();

                // Segundo valor necessário para fazer a conta
                System.out.println("Digite o segundo valor desejado: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Por favor, insira um número válido: ");
                    scanner.next();
                }
                value2 = scanner.nextDouble();

                // Resultado da operação
                System.out.println("Resultado da operação: " + Calculate(value1, value2, operation));

                loading = checkNewOperation();
            } while (loading);

            // Função de substituir a mensagem de erro padrão, caso o valor seja diferente do pedido
        } catch (InputMismatchException ex) {

            System.out.println("Os valores para cálculo devem ser numéricos =)");
            scanner.next();
        }
    }

    public static boolean checkNewOperation() {
        Scanner sc = new Scanner(System.in);

        // Pergunta se quer fazer outra operação
        System.out.println("Deseja realizar uma nova operação? (S ou N): ");
        return !sc.nextLine().toUpperCase(Locale.ROOT).equals("N");
    }

    public static Double Calculate(Double value1, Double value2, String operation) {
        Double finalCalculation = 0.0;

        // Switch Case para escolha da operação
        switch (operation) {
            case "+":
                finalCalculation = value1 + value2;
                break;
            case "-":
                finalCalculation = value1 - value2;
                break;
            case "/":
                if (value2 != 0) {
                    finalCalculation = value1 / value2;
                } else {
                    System.out.println("Divisão por zero não é permitida!");
                }
                break;
            case "*":
                finalCalculation = value1 * value2;
                break;
            default:
                System.out.println("Operação é inválida =(");
        }

        return finalCalculation;
    }
}


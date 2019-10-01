package coffemachine;

import java.util.Scanner;

public class ConsInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public int ask(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}

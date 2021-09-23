package line;

import java.util.Scanner;

public class InputView {
    private final Scanner sc;

    private InputView() {
        sc = new Scanner(System.in);
    }

    public static InputView newInstance() {
        return new InputView();
    }

    public String inputCoordinate() {
        System.out.println("좌표를 입력하세요.");
        return sc.nextLine();
    }
}

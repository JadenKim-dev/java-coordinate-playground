package line.view;

import java.util.Scanner;

public class InputView {
    private final Scanner sc;

    private InputView() {
        sc = new Scanner(System.in);
    }

    public static InputView newInstance() {
        return new InputView();
    }

    public String inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        return sc.nextLine();
    }

    public void printReinputMessage() {
        System.out.println("좌표 입력이 올바르지 않습니다. 다시 입력해주세요.");
    }
}

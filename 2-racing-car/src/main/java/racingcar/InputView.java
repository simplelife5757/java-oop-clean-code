package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public static RequestDto input() {
        return new RequestDto(inputCarNames(), inputRound());
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return Arrays.stream(SCANNER.nextLine().trim().split(DELIMITER)).collect(Collectors.toList());
    }

    private static int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(SCANNER.next());
    }
}

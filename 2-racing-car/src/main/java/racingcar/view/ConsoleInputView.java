package racingcar.view;

import racingcar.controller.RequestDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public RequestDto input() {
        return new RequestDto(inputCarNames(), inputRound());
    }

    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String carStringNames = scanner.nextLine().trim();
        return Arrays.stream(carStringNames.split(",")).collect(Collectors.toList());
    }

    private Integer inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.next());
    }
}

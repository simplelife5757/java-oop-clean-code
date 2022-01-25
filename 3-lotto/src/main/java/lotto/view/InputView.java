package lotto.view;

import lotto.domain.ManualPurchaseAmount;
import lotto.domain.PurchaseMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static PurchaseMoney inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchaseMoney(SCANNER.nextLine());
    }

    public static ManualPurchaseAmount inputManualPurchaseAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return new ManualPurchaseAmount(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자로 입력해 주세요.");
        }
    }

    public static List<String> inputManualLottoNumbers(Integer purchaseAmount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            manualLottoNumbers.add(inputManualLottoNumber());
        }
        return manualLottoNumbers;
    }

    private static String inputManualLottoNumber() {
        return SCANNER.nextLine();
    }
}

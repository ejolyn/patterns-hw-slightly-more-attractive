package generators;

import person.Phone;
import utils.MyMath;

import java.util.Random;

public class PhoneGenerator extends Generator<Phone> {

    private String number;

    /**
     * Номер телефона генерируется следующим образом:
     * +79[сумма цифр в коде][3 случайных числа][код].
     */
    @Override
    public final void generateParams(final int code) {
        number = "+79"
                + String.format("%02d", MyMath.getDigitsSum(code))
                + String.format("%03d", new Random().nextInt(1000))
                + String.format("%04d", code);
    }

    @Override
    public final Phone buildResponse() {
        return new Phone(number);
    }
}


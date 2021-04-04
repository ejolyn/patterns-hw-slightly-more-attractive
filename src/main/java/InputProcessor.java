import generators.AppearanceGenerator;
import generators.FioGenerator;
import generators.PhoneGenerator;
import generators.PhysGenerator;
import person.Fio;
import person.PersonBuilder;
import person.Phone;
import person.Physical;
import person.appearance.Appearance;

public class InputProcessor {

    public final String processInput(final String input) {
        if (input.trim().matches("\\d{4}")) {
            return processFacade(input);
        } else {
            return ("Неверный ввод.");
        }
    }

    private String processFacade(final String input) {
        String result;
        final int intCode = Integer.parseInt(input);

        final FioGenerator fioGenerator = new FioGenerator();
        fioGenerator.generateParams(intCode);
        final Fio fio = fioGenerator.getFio();

        final PhysGenerator physGenerator = new PhysGenerator();
        physGenerator.generateParams(intCode);
        final Physical physical = physGenerator.buildResponse();

        final AppearanceGenerator appearanceGenerator = new AppearanceGenerator();
        appearanceGenerator.generateParams(intCode);
        final Appearance appearance = appearanceGenerator.buildResponse();

        Phone phone = null;
        // добавляем телефон, только если введённый код не палиндром
        if (!input.equals(new StringBuilder(input).reverse().toString())) {
            final PhoneGenerator phoneGenerator = new PhoneGenerator();
            phoneGenerator.generateParams(intCode);
            phone = phoneGenerator.buildResponse();
        }
        result = new PersonBuilder(input)
                .setLastName(fio.getLastName())
                .setFirstName(fio.getFirstName())
                .setMiddleName(fio.getMiddleName())
                .setPhys(physical)
                .setAppearance(appearance)
                .setPhone(phone)
                .build().toString();
        return result;
    }
}

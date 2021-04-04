package generators;

import person.Fio;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class FioGenerator {

    private Fio fio = new Fio();

    /**
     * ФИО берутся из соответствующих файлов по индексу в листе:
     * Фамилия - сумма цифр в коде
     * Имя - сумма первых двух цифр
     * Отчество - сумма последних двух цифр.
     *
     * @param code код для генерации
     */
    public final void generateParams(final int code) {
        final int lastNameIndex = getDigitsSum(code);
        final String sex = (lastNameIndex % 2 == 0) ? "f" : "m";
        setLastNameFromFile(lastNameIndex, sex);
        setFirstNameFromFile(getDigitsSum(code / 100), sex);
        setMiddleNameFromFile(getDigitsSum(code % 100), sex);
    }

    public final Fio getFio() {
       return fio;
   }
    private void setLastNameFromFile(final int i, final String sex) {
        fio.setLastName(getLinesFromFile("lastNames_" + sex).get(i));
    }

    private void setFirstNameFromFile(final int i, final String sex) {
        fio.setFirstName(getLinesFromFile("names_" + sex).get(i));
    }

    private void setMiddleNameFromFile(final int i, final String sex) {
        fio.setMiddleName(getLinesFromFile("middleNames_" + sex).get(i));
    }
}


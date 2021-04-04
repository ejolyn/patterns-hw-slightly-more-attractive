package person;

import person.appearance.Appearance;

public class PersonBuilder {
    private final String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;

    public PersonBuilder(final String id) {
        this.id = id;
    }

    public final PersonBuilder setLastName(final String lastNameC) {
        this.lastName = lastNameC;
        return this;
    }
    public final PersonBuilder setFirstName(final String firstNameC) {
        this.firstName = firstNameC;
        return this;
    }
    public final PersonBuilder setMiddleName(final String middleNameC) {
        this.middleName = middleNameC;
        return this;
    }
    public final PersonBuilder setPhys(final Physical physC) {
        this.phys = physC;
        return this;
    }
    public final PersonBuilder setAppearance(final Appearance appearanceC) {
        this.appearance = appearanceC;
        return this;
    }
    public final PersonBuilder setPhone(final Phone phoneC) {
        this.phone = phoneC;
        return this;
    }
    public final Person build() {
        final Person person = new Person();
        person.setId(this.id);
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        person.setMiddleName(this.middleName);
        person.setPhys(this.phys);
        person.setAppearance(this.appearance);
        person.setPhone(this.phone);
        return person;
    }
}

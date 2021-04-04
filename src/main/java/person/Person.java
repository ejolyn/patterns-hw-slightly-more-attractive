package person;

import person.appearance.Appearance;

public class Person {

    private String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;

    public final void setId(final String id) {
        this.id = id;
    }
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    public final void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }
    public final void setPhys(final Physical phys) {
        this.phys = phys;
    }
    public final void setAppearance(final Appearance appearance) {
        this.appearance = appearance;
    }
    public final void setPhone(final Phone phone) {
        this.phone = phone;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(String.format("%1$s %2$s %3$s", lastName, firstName, middleName)).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }
}
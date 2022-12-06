public class Actor extends Person {

    public Actor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Actor() {
    }

    @Override
    public String toString() {
        return "Actors: " + getFirstName() + " " + getLastName();
    }
}

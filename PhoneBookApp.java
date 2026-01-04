import java.util.ArrayList;

public class PhoneBookApp {
    public static void main(String[] args) {
        ArrayList<PhoneBookEntry> contacts = new ArrayList<>();
        // Create the ArrayList with the objects
        contacts.add(new PhoneBookEntry("Nicolle M", "225-466-9820"));
        contacts.add(new PhoneBookEntry("Camilo A", "316-552-7899"));
        contacts.add(new PhoneBookEntry("Sophia W", "485-123-6398"));
        contacts.add(new PhoneBookEntry("Jess H", "315-266-7849"));
        contacts.add(new PhoneBookEntry("Aaron M", "412-314-6547"));

        // Show the contacts
        for (PhoneBookEntry c : contacts) {
            // we use the getters to show the values
            System.out.println(c.getName() + " - " + c.getNumber());

            //Return the list of the objects that we create
            //Nicolle M - 225-466-9820
            //Camilo A - 316-552-7899
            //Sophia W - 485-123-6398
            //Jess H - 315-266-7849
            //Aaron M - 412-314-6547
        }
    }
}

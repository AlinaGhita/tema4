public class Main {
    public static void main(String[] args) {

        Phone phone = new SamsungGalaxyS6("a", "0");

        phone.addContact("1", "564868586", "Alina", "Ghita");

        phone.addContact("2", "0786754e5r", "Ana", "Popescu");

        phone.addContact("3", "3q45e5678", "Adrian", "Popescu");

        phone.getFirstContact();
        System.out.println("First contact: " + phone.getFirstContact());

        phone.getLastContact();
        System.out.println("Last contact: " + phone.getLastContact());

        // send a message to the first contact from the previously listed

        // max number of characters - 100

        phone.sendMessage("phone number", "message content");

        phone.getFirstMessage("phone number");

        phone.getSecondMessage("phone number");

        // make a call to the second contact from the previously listed

        phone.call("second phone number");

        phone.viewHistory();


        Phone phone1 = new SamsungGalaxyNote("a", "67");

        phone1.addContact("1", "454678889", "Ioana", "Ilinca");

        phone1.addContact("2", "334565676", "Alexandra", "Stanescu");

        phone1.getFirstContact();
        System.out.println("First contact: " + phone1.getFirstContact());

        phone1.getLastContact();
        System.out.println("Last contact: " + phone1.getLastContact());

        // send a message to the first contact from the previously listed

        // max number of characters - 100

        phone1.sendMessage("phone number", "message content");

        phone1.getFirstMessage("phone number");

        phone1.getSecondMessage("phone number");

        // make a call to the second contact from the previously listed

        phone1.call("second phone number");


        phone1.viewHistory();

    }
}
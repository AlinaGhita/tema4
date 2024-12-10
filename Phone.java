import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Phone {
    // Constants for maximum battery usage
    private static final int MESSAGE_BATTERY_CONSUMPTION = 1;  // 1 hour per message
    private static final int CALL_BATTERY_CONSUMPTION = 2;     // 2 hours per call

    private String color;
    private String material;
    private final String imei;
    private int currentBatteryLife;

    //create contact list
    private List<Contact> contacts = new ArrayList<>();
    //create a map list for messages in order to check if a key(phoneNumber) exists
    //and in order to can add a value to a key in the list
    private Map<String, List<String>> messages = new HashMap<>();
    //create a callHistory list
    private List<String> callHistory = new ArrayList<>();

    public Phone(String imei, int batteryLife) {
        this.imei = imei;
        // Fixed battery life, set by constructor
        this.currentBatteryLife = batteryLife;
    }

    public void addContact(String contactId, String phoneNumber, String firstName, String lastName) {
        contacts.add(new Contact(contactId, phoneNumber, firstName, lastName));
        System.out.println("Lista de contacte:");
        for (Contact contact: contacts){
            System.out.println(contact);
        }
    }

    public Contact getFirstContact() {

        //check if first contact si empty or not
        return contacts.isEmpty() ? null : contacts.getFirst();
    }

    public Contact getLastContact() {
        //check if last contact si empty or not
        return contacts.isEmpty() ? null : contacts.getLast();
    }

    public void sendMessage(String phoneNumber, String messageContent) {
        if (messageContent.length() > 500) {
            System.out.println("Message exceeds 500 characters.");
            return;
        }
        if (currentBatteryLife <= 0) {
            System.out.println("Not enough battery to send message.");
            return;
        }

        //check if phoneNumber key exist in the Map list
        if (!messages.containsKey(phoneNumber)) {
            //add a new key (phoneNumber) in the list
            messages.put(phoneNumber, new ArrayList<>());
        }
        //add a message associate to a phone number
        messages.get(phoneNumber).add(messageContent);
        //update battery life
        currentBatteryLife -= MESSAGE_BATTERY_CONSUMPTION;
        System.out.println("Message sent to " + phoneNumber);
        System.out.println("Battery after a call is :" + currentBatteryLife);
    }

    public void call(String phoneNumber) {
        if (currentBatteryLife <= 0) {
            System.out.println("Not enough battery to make a call.");
            return;
        }

        callHistory.add("Call made to " + phoneNumber);
        //update battery life
        currentBatteryLife -= CALL_BATTERY_CONSUMPTION;
        System.out.println("Call made to " + phoneNumber);
        System.out.println("Battery after a call is :" + currentBatteryLife);
    }

    public void viewHistory() {
        if (callHistory.isEmpty()) {
            System.out.println("No calls made yet.");
        } else {
            for (String call : callHistory) {
                System.out.println(call);
            }
        }
    }

    // Getters
    public String getImei() {
        return imei;
    }

    public int getCurrentBatteryLife() {
        return currentBatteryLife;
    }

    public List<String> getFirstMessage(String phoneNumber) {
        //get the first message associate to a phoneNumber and add it to the list
        // or an empty list if there are no messages
        return messages.getOrDefault(phoneNumber, new ArrayList<>());
    }

    public List<String> getSecondMessage(String phoneNumber) {
        List<String> allMessages = messages.getOrDefault(phoneNumber, new ArrayList<>());
        return allMessages.size() > 1 ? List.of(allMessages.get(1)) : new ArrayList<>();
    }
}

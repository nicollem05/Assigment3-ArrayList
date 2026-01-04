public class PhoneBookEntry {
    private String name;
    private String number;

    //we create a constructor that received the name and number with the type
    public PhoneBookEntry(String name, String number){
        this.name = name;
        this.number = number;
    }
    //we need the getters and setters
    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setNumber(String number){
        this.number = number;
    }
}

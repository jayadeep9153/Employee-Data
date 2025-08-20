public class User {
    private int id;
    private String name;
    private Address address;

    public User(){}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return "User { id = " + id + ", name = " + name + " " + address + "}";
    }
}

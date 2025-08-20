public class Address {
    private String city;
    private String zip;
    private String state;

    public Address(){}

    public Address(String city, String zip, String state) {
        this.city = city;
        this.zip = zip;
        this.state = state;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public String getZip(){
        return this.zip;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    @Override
    public String toString() {
        return "Address { city = " + this.city + ", zip = " + this.zip + ", state = " + this.state + " }";
    }
}

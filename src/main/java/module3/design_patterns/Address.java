package module3.design_patterns;

public class Address {
    private String number, street, street2, city, state, zip1, zip2, country;

    private static final String DEFAULT_STREET2 = "";
    private static final String DEFAULT_ZIP2 = "";

    /**
     * Empty constructor for example use with Java Bean Builder Pattern.
     * <p>
     * Java Bean Builder Pattern - Use an Empty constructor to instantiate an object of the concrete class,
     * and use setters to build the values for its fields.
     * <p>
     * Drawbacks - Object not immutable. Objects can be partially initialized.
     * Pro - Clear to understand.
     */
    public Address() {

    }

    public Address(String number, String street, String street2, String city, String state, String zip1, String zip2,
                   String country) {
        this.number = number;
        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip1 = zip1;
        this.zip2 = zip2;
        this.country = country;
    }

    private Address(AddressBuilder addressBuilder){
        this.number = addressBuilder.number;
        this.street = addressBuilder.street;
        this.street2 = addressBuilder.street2;
        this.city = addressBuilder.city;
        this.state = addressBuilder.state;
        this.zip1 = addressBuilder.zip1;
        this.zip2 = addressBuilder.zip2;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip1() {
        return zip1;
    }

    public void setZip1(String zip1) {
        this.zip1 = zip1;
    }

    public String getZip2() {
        return zip2;
    }

    public void setZip2(String zip2) {
        this.zip2 = zip2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * AddressBuilder class Builds Address objects. This example shows how the builder pattern can be implemeneted in
     * java in order to construct Objects with a large amount of fields.
     */
    public static class AddressBuilder {
        private String number, street, street2, city, state, zip1, zip2, country;

        /**
         * AddressBuilder class example constructor. Constructor takes in the values that
         * are absolutely required for building the Concrete class.
         *
         * @param number the String value of the street number.
         * @param street the String value of the street of this address.
         * @param zip1   the zipcode of this address as a String.
         */
        public AddressBuilder(String number, String street, String zip1) {
            this.number = number;
            this.street = street;
            this.zip1 = zip1;
        }

        /**
         * Create build methods for all optional fields of concrete class. Each of these methods
         * return this AddressBuilder instance with their field updated to match the formal paramater provided.
         *
         * Finally, we have  a build method which returns an object of the concrete class.
          */
        public AddressBuilder street2(String street2) {
            this.street2 = street2;
            return this;
        }

        public AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder state(String state) {
            this.state = street2;
            return this;
        }

        public AddressBuilder zip2(String zip2) {
            this.zip2 = zip2;
            return this;
        }

        public AddressBuilder country(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }
}

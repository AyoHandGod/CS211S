package module3.design_patterns;

/**
 * Test class for Address Build Pattern Examples
 */
public class AddressDriver {
    public static void main(String[] args) {
        // Java Bean Builder Pattern Example
        Address addressOld = new Address();
        addressOld.setNumber("81");
        addressOld.setStreet("Oakdale st.");
        addressOld.setCity("San Francisco");
        addressOld.setState("California");
        addressOld.setZip1("94124");

        // AddressBuilder Pattern Example
        Address addressNew = new Address.AddressBuilder("81", "Oakdale st.", "94124").build();
        System.out.println(addressNew.getNumber());
    }
}

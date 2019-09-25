package homework;

/**
 * Size Type options for Players and Creatures.
 *
 * @author Dante l. Anthony
 * @version 1.0
 */
public enum Size implements Comparable<Size> {
    /*
    The Size options available to characters. The size double represent the maximum size.
     */
    TINY ("Tiny", 2.5),
    SMALL ("Small", 5),
    MEDIUM ("Medium", 5),
    LARGE("LARGE", 10),
    HUGE ("Huge", 15),
    GARGANTUAN ("Gargantuan", 20);

    private String name;
    private double area;

    /**
     * A Size type value for Character.
     * @param name the name of the size type.
     * @param area the amount of space the size occupies.
     */
    Size(String name, double area){
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return this.area;
    }

    /**
     * Retrieve a Size using a provided String of the size name.
     *
     * @param aSize string representation of the size name, case unrestricted.
     * @return The Size type if found, null if not.
     */
    public static Size findByName(String aSize){
        for(Size size: Size.values()){
            if(size.getName().equalsIgnoreCase(aSize)){
                return size;
            }
        }
        return null;
    }

}

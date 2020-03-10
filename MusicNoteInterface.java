import com.google.common.collect.ComparisonChain;

//Create MusicNoteInterface class to add a Comparable interface to the MusicNote class
public class MusicNoteInterface implements Comparable<MusicNoteInterface> {
    //Class fields
    private double length; //Create the Length field
    private int value; //Create the Value field
    private char name; //Create the Name field
    private String accidental; //Create the Natural/Sharp pitch field
    private double frequency; //Create the Frequency field

    //Create a class constructor for the MusicNote class
    public MusicNoteInterface() {
        this.length = 0.25; //Set the length to 1/4
        this.value = 0; //Set the Value to 0
    }

    /**
     * @param length
     * @param value
     */
    public MusicNoteInterface(double length, int value) {
        this.length = length;
        this.value = value;
    }

    //Method for retrieving Length
    public double getLength() {
        return length;
    }

    //Method for setting Length
    public void setLength(double length) {
        this.length = length;
    }

    //Method for retrieving Value
    public int getValue() {
        return value;
    }

    //Method for setting Value
    public void setValue(int value) {
        this.value = value;
    }

    //Method for retrieving Name
    public char getName() {
        //Determine if value is positive or negative, if it's negative we have to add 12 after finding the remainder
        //Credit to Bill for helping me figure out how to divide this up into 12 different cases
        if (value >= 0) {
            this.value = (value % 12);
        } else {
            if (value >= -12) {
                this.value = value + 12;
            } else {
                this.value = (value % 12) + 12;
            }
        }
        //Using switch we are able to determine which letter the value corresponds with
        switch (value) {
            case 0:
            case 1:
                name = 'A';
                break;
            case 2:
                name = 'B';
                break;
            case 3:
            case 4:
                name = 'C';
                break;
            case 5:
            case 6:
                name = 'D';
                break;
            case 7:
                name = 'E';
                break;
            case 8:
            case 9:
                name = 'F';
                break;
            case 10:
            case 11:
                name = 'G';
                break;
        }
        return name;
    }

    //Method for retrieving Accidental
    public String getAccidental() {
        switch (value) {
            case 1:
            case 4:
            case 6:
            case 9:
            case 11:
                accidental = "#";
                break;
            case 0:
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                accidental = " ";
                break;
        }
        return accidental;
    }

    //Method for retrieving Frequency
    public double getFrequency() {
        frequency = 440 * (Math.pow(2.0, (value / (double) 12))); //Credit to Diane for reminding us to use Math.pow!
        return Math.floor(frequency * 100) / 100;
    }

//    /**
//     * Compares this object with the specified object for order.  Returns a
//     * negative integer, zero, or a positive integer as this object is less
//     * than, equal to, or greater than the specified object.
//     */
//    @Override
//    public int compareTo(MusicNoteInterface obj) {
//        if (this.getFrequency() > obj.getFrequency()) {
//            return 1;
//        } else if (this.getFrequency() < obj.getFrequency()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }

    public int compareTo(MusicNoteInterface obj) {
        return ComparisonChain.start()
                .compare(this.getLength(), obj.getLength())
                .compare(this.getFrequency(), obj.getFrequency())
                .result();
    }

    public int compareTo(MusicNoteInterface compareNotes) {
        int compareLength = ((MusicNoteInterface) compareNotes).getLength());
        //ascending order
        return (int) (this.length - compareLength);
    }
}
//Credit to all of my peers on Discord who assisted me with various ideas on how to create this Java class

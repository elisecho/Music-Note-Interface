public class Driver {
    public static void main(String[] args) {
        //Let's test our default A note!
        MusicNoteInterface a = new MusicNoteInterface();
        System.out.println("Note a = " + a.getName() + a.getAccidental() + a.getFrequency() + " Length: " + a.getLength());
        //Let's make a bunch of other notes
        MusicNoteInterface cSharp = new MusicNoteInterface(1.0, 4);
        MusicNoteInterface dSharp = new MusicNoteInterface(0.5, 6);
        MusicNoteInterface b = new MusicNoteInterface(0.5, 2);
        MusicNoteInterface aSharp = new MusicNoteInterface(0.25, 1);
        //Compare notes
        System.out.println(cSharp.compareTo(a));
        System.out.println(dSharp.compareTo(b));
        System.out.println(b.compareTo(aSharp));

    }
}

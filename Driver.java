public class Driver {
    public static void main(String[] args) {
        //Let's test our default A note!
        MusicNoteInterface A = new MusicNoteInterface();
        System.out.println("Note A = " + A.getName() + A.getAccidental() + A.getFrequency() + " Length: " + A.getLength());
        //Let's make a new note, and change the defaults
        MusicNoteInterface CSharp = new MusicNoteInterface();
        CSharp.setLength(1.0);
        CSharp.setValue(4);
        System.out.println("Note CSharp = " + CSharp.getName() + CSharp.getAccidental() + CSharp.getFrequency() + " Length: " + CSharp.getLength());
    }
}

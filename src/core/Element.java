public class Element {

    // Represents a single data element used for algorithm visualization. Each element stores a numeric value,
    // a generated audio waveform, and drawing logic for graphical display.

    // This class was developed as part of coursework exploring the audio-visual representation of algorithms.
    // The implementation emphasizes perceptual clarity rather than performance or abstraction.

    private int value;
    private double[] sound;

    public Element(int value) {
        this.value = value;
        this.sound = new double[4410];
    }

    public int getValue() {
        return value;
    }

    public double[] getSound() {
        return sound;
    }

    public int compareTo(Element other) {
        if(this.value > other.value) {
            return 1;
        } else if (this.value < other.value) {
            return -1;
        }
        return 0;
    }

    // Generates a sine wave at the given frequency (Hz), sampled at 44.1 kHz for short playback.
    public void setSound(int hz) {
        for(int i = 0; i < sound.length; i++){
            sound[i] = Math.sin(2 * Math.PI * i * hz / 44100);
        }
    }

    // Draws the element as a vertical bar whose height is proportional to its value and whose position is given
    // by elementIndex.
    public void draw(int n, int elementIndex) {
        StdDraw.filledRectangle(0 + elementIndex, n/2,0.15,this.value * 0.4);
    }


}

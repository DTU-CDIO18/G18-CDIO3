package dk.dtu.CDIOg18.monopolyjr;

public class Die {
    private int faceCount = 6;

    public int getFaceValue() {
        return (int) (Math.random() * this.faceCount) + 1;
    }
}

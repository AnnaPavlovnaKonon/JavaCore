package homework1;

public class Human extends Team implements CanRun, CanJump {
    private String name;
    private double jumpLength;
    private double runLength;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getJumpLength() {
        return jumpLength;
    }
    public void setJumpLength(double jumpLength) {
        this.jumpLength = jumpLength;
    }
    public double getRunLength() {
        return runLength;
    }
    public void setRunLength(double runLength) {
        this.runLength = runLength;
    }


    public Human(String name, double jumpLength, double runLength) {
        super();
        this.name = name;
        this.jumpLength = jumpLength;
        this.runLength = runLength;
    }

    public void jump(double fieldLength) {
        if (fieldLength > jumpLength) {
            System.out.println("Игрок не смог перепрыгнуть препятствие");
        } else {
            System.out.println("Игрок прошел препятствие!");
        }
    }

    public void run(double roadLength) {
        if (roadLength > runLength) {
            System.out.println("Игрок не смог пробежать");
        } else {
            System.out.println("Игрок пробежал!");
        }
    }

}




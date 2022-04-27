package hu.robot.model.domain;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance() {
        return Math.sqrt(x * x + y * y);
    }

    public Coordinate move(Coordinate withCoordinate) {
        return new Coordinate(
                this.x + withCoordinate.getX(),
                this.y + withCoordinate.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("%d lépést kell tenni az ED, %d lépést a KN tengely mentén",
                Math.abs(y), Math.abs(x));
    }
}

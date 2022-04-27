package hu.robot.model.domain;

public class Step {

    private final int id;
    private final Direction direction;
    private final Coordinate coordinate;
    private final int capacity;

    public Step(int id, Direction direction, Coordinate coordinate, int capacity) {
        this.id = id;
        this.direction = direction;
        this.coordinate = coordinate.move(direction.getCoordinate());
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }

    public Double getDistance() {
        return coordinate.getDistance();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return coordinate.toString();
    }
}

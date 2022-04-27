package hu.robot.model.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Program {

    private final String[] OPPOSITIONS = {"ED", "DE", "KN", "NK"};

    private final int id;
    private final String program;
    private final List<Step> steps;

    public Program(int id, String program, List<Step> steps) {
        this.id = id;
        this.program = program;
        this.steps = steps;
    }

    public String couldBeSimplified() {
        return isSimplified() ? "egyszerűsíthető" : "nem egyszerűsíthető";
    }

    private boolean isSimplified() {
        return Arrays.stream(OPPOSITIONS)
                .anyMatch(program::contains);
    }

    public boolean isLowCapacity() {
        return getCapacity() <= 100;
    }

    public int getCapacity() {
        return steps.stream()
                .mapToInt(Step::getCapacity)
                .sum();
    }

    public Step getFarthestStep() {
        return steps.stream()
                .max(Comparator.comparing(Step::getDistance))
                .get();
    }

    public String getShortestWayBack() {
        return steps.get(steps.size() - 1).toString();
    }

    public int getId() {
        return id;
    }

    public String getProgram() {
        return program;
    }

    public List<Step> getSteps() {
        return steps;
    }
}

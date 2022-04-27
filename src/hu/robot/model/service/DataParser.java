package hu.robot.model.service;

import hu.robot.model.domain.Coordinate;
import hu.robot.model.domain.Direction;
import hu.robot.model.domain.Program;
import hu.robot.model.domain.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    private int id = 0;

    public List<Program> parse(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(this::createProgram)
                .collect(Collectors.toList());
    }

    private Program createProgram(String line) {
        List<Step> steps = new ArrayList<>();
        Coordinate coordinate = new Coordinate(0, 0);
        int stepId = 0;
        for (int i = 0; i < line.length(); i++) {
            char actual = line.charAt(i);
            Direction direction = Direction.valueOf(String.valueOf(actual));
            int capacity = (i > 0 && actual == line.charAt(i)) ? 1 : 3;
            Step step = new Step(++stepId, direction, coordinate, capacity);
            steps.add(step);
            coordinate = step.getCoordinate();
        }
        return new Program(++id, line, steps);
    }
}

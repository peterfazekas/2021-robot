package hu.robot.contoller;

import hu.robot.model.domain.Program;
import hu.robot.model.domain.Step;
import hu.robot.model.service.ProgramTransformer;

import java.util.List;
import java.util.stream.Collectors;

public class RobotService {

    private final List<Program> programs;

    private final ProgramTransformer programTransformer;

    public RobotService(List<Program> programs, ProgramTransformer programTransformer) {
        this.programs = programs;
        this.programTransformer = programTransformer;
    }

    public String couldBeSimplified(int id) {
        return getProgram(id).couldBeSimplified();
    }

    public String getShortestWayBack(int id) {
        return getProgram(id).getShortestWayBack();
    }

    public String getFarthestStep(int id) {
        Step step = getProgram(id).getFarthestStep();
        return String.format("A robot légvonalban a(z) %d. lépést köetően volt a legtávolabb, %5.3f cm távolságban",
                step.getId(), step.getDistance());
    }

    public String getLowCapacityPrograms() {
        return programs.stream()
                .filter(Program::isLowCapacity)
                .map(i -> i.getId() + " " + i.getCapacity())
                .collect(Collectors.joining(", "));
    }

    public List<String> toNewFormat() {
        return programs.stream()
                .map(Program::getProgram)
                .map(programTransformer::toNewFormat)
                .collect(Collectors.toList());
    }

    public String toOldFormat(String newFormat) {
        return programTransformer.toOldFormat(newFormat);
    }

    private Program getProgram(int id) {
        return programs.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .get();
    }
}

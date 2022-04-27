package hu.robot;

import hu.robot.contoller.RobotService;
import hu.robot.model.service.Console;
import hu.robot.model.service.DataApi;
import hu.robot.model.service.DataParser;
import hu.robot.model.service.FileReader;
import hu.robot.model.service.FileWriter;
import hu.robot.model.service.ProgramTransformer;

import java.util.Scanner;

public class App {

    private final RobotService service;
    private final Console console;
    private final FileWriter fileWriter;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        service = new RobotService(dataApi.getData("program.txt"), new ProgramTransformer());
        console = new Console(new Scanner(System.in));
        fileWriter = new FileWriter("ujprog.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat: Kérem az utasítássor sorszámát!");
        int id = console.getInt();
        System.out.println("2.a: " + service.couldBeSimplified(id));
        System.out.println("2.b: " + service.getShortestWayBack(id));
        System.out.println("2.c: " + service.getFarthestStep(id));
        System.out.println("3. feladat: A kis kapacitású akkuval futtatható programok: " +
                service.getLowCapacityPrograms());
        fileWriter.writeAll(service.toNewFormat());
        System.out.println("5. feladat: Adjon meg egy új formátumú programot: ");
        String newFormat = console.readProgram();
        System.out.println(service.toOldFormat(newFormat));

    }
}

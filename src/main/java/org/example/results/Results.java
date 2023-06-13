package org.example.results;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.virus.Virus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.lang.System.out;

/**
 * The type Results.
 */
public class Results {

    /**
     * The constant infectionCount.
     */
    public static int infectionCount = 0;
    /**
     * The constant healedCount.
     */
    public static int healedCount = 0;
    /**
     * The constant deadCount.
     */
    public static int deadCount = 0;
    /**
     * The constant vaccinatedCount.
     */
    public static int vaccinatedCount = 0;
    private final ArrayList<Child> children;
    private final ArrayList<Adult> adults;
    private final ArrayList<Elder> elders;
    private final int days;
    private final Virus virus;

    /**
     * Instantiates a new Results.
     *
     * @param children the children
     * @param adults   the adults
     * @param elders   the elders
     * @param virus    the virus
     * @param days     the days
     */
    public Results(ArrayList<Child> children, ArrayList<Adult> adults, ArrayList<Elder> elders, Virus virus, int days) {
        this.children = children;
        this.adults = adults;
        this.elders = elders;
        this.days = days;
        this.virus = virus;
    }

    public void writeResultsToFile() {
        Workbook workbook = new XSSFWorkbook();

        XSSFSheet spreadsheet = (XSSFSheet) workbook.createSheet("Simulation data");

        XSSFRow row;

        Map<String, Object[]> simulationData = new TreeMap<String, Object[]>();

        simulationData.put(
                "1",
                new Object[]{
                        "virus",
                        "days",
                        "young",
                        "adult",
                        "elder",
                        "infected",
                        "healed",
                        "dead",
                        "vaccinatedCount"
                }
        );

        simulationData.put(
                "2",
                new Object[] {
                        virus.getName(),
                        days,
                        children.size(),
                        adults.size(),
                        elders.size(),
                        infectionCount,
                        healedCount,
                        deadCount,
                        vaccinatedCount,
                }
        );

        Set<String> keyid = simulationData.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = simulationData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(obj.toString());
            }
        }


        String path = "C:\\Users\\Krzysiek\\Desktop\\simulationExcel.xlsx";
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            workbook.write(outputStream);
            out.close();
            out.println("Dane zostały zapisane do pliku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print results.
     */
    public void printResults() {
        out.println("Children: " + children.size() + " | Adults: " + adults.size() + " | Elders: " + elders.size() + " | virus: " + virus + " | days: " + days);
        out.println("Infected people: " + infectionCount + "\nHealed people: " + healedCount + "\nDead people: " + deadCount + "\nVaccinated people: " + vaccinatedCount);
    }

    /**
     * Gets infection count.
     *
     * @return the infection count
     */
    public static int getInfectionCount() {
        return infectionCount;
    }

    /**
     * Gets healed count.
     *
     * @return the healed count
     */
    public static int getHealedCount() {
        return healedCount;
    }

    /**
     * Gets dead count.
     *
     * @return the dead count
     */
    public static int getDeadCount() {
        return deadCount;
    }

    /**
     * Gets vaccinated count.
     *
     * @return the vaccinated count
     */
    public static int getVaccinatedCount() {
        return vaccinatedCount;
    }

    //TODO - Add writing function to represent results in external file
}

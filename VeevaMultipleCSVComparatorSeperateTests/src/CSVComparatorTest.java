import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVComparatorTest {

    private int passedTests = 0;
    private int failedTests = 0;
    private List<String> detailedReport = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        CSVComparatorTest test = new CSVComparatorTest();
        
        String csv = "CSV_Files/";

        // Run individual test methods
        test.testIdenticalFiles(csv);
        test.testChangeInValue(csv);
        test.testDifferentContent(csv);
        test.testDifferentNumberOfRows(csv);
        test.testDifferentNumberOfColumns(csv);
        test.testEmptyFile(csv);
        test.testCaseSensitive(csv);
        test.testMissingData(csv);
        test.testDifferentRowOrder(csv);
        test.testWhiteSpaces(csv);
        test.testBothFilesEmpty(csv);
        test.testDelimeterChange(csv);
        test.testSpecialCharacter(csv);
        test.testDifferentNumbers(csv);
        test.testDataWithFrenchAccents(csv);
        test.testDuplicateData(csv);
        test.testDuplicateDataBothFiles(csv);
        test.testMissingRows(csv);
        test.testMissingColumns(csv);

        // Print the overall report
        test.printReport();
    }

    private void printReport() {
        System.out.println("\n==============================================");
        System.out.println("                FINAL REPORT                  ");
        System.out.println("==============================================");
        System.out.println("Total Tests Run: " + (passedTests + failedTests));
        System.out.println("Passed: " + passedTests);
        System.out.println("Failed: " + failedTests);
        System.out.println("==============================================\n");

        System.out.println("Detailed Report:");
        detailedReport.forEach(System.out::println);
    }

    private void compareCSVFiles(String testName, String filePath1, String filePath2) throws IOException {
        List<String> differences = new ArrayList<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            int lineNum = 1;

            while (line1 != null || line2 != null) {
                if (line1 == null || line2 == null) {
                    differences.add(String.format("  - Difference at line %d: one file has more lines", lineNum));
                    break;
                }

                String[] tokens1 = line1.split(",");
                String[] tokens2 = line2.split(",");

                if (tokens1.length != tokens2.length) {
                    differences.add(String.format("  - Difference at line %d: Number of columns differ (File1: %d, File2: %d)", lineNum, tokens1.length, tokens2.length));
                }

                for (int i = 0; i < Math.min(tokens1.length, tokens2.length); i++) {
                    if (!tokens1[i].equalsIgnoreCase(tokens2[i])) {
                        differences.add(String.format("  - Difference at line %d, column %d: File1 = \"%s\", File2 = \"%s\"", lineNum, i + 1, tokens1[i], tokens2[i]));
                    }
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNum++;
            }
        }

        if (differences.isEmpty()) {
            passedTests++;
            detailedReport.add(String.format("%s: PASS", testName));
        } else {
            failedTests++;
            detailedReport.add(String.format("%s: FAIL", testName));
            differences.forEach(diff -> detailedReport.add(String.format("    %s", diff)));
        }
    }

    // Updated test methods to pass test names
    public void testIdenticalFiles(String csv) throws IOException {
        compareCSVFiles("Test 1: Identical Files", csv + "file0.csv", csv + "file1.csv");
    }

    public void testChangeInValue(String csv) throws IOException {
        compareCSVFiles("Test 2: Change in a Value", csv + "file1.csv", csv + "file2.csv");
    }

    public void testDifferentContent(String csv) throws IOException {
        compareCSVFiles("Test 3: Different Content", csv + "file1.csv", csv + "file3.csv");
    }

    public void testDifferentNumberOfRows(String csv) throws IOException {
        compareCSVFiles("Test 4: Different Number of Rows", csv + "file1.csv", csv + "file4.csv");
    }

    public void testDifferentNumberOfColumns(String csv) throws IOException {
        compareCSVFiles("Test 5: Different Number of Columns", csv + "file1.csv", csv + "file5.csv");
    }

    public void testEmptyFile(String csv) throws IOException {
        compareCSVFiles("Test 6: Compare an Empty file to a file with content", csv + "file1.csv", csv + "file6.csv");
    }

    public void testCaseSensitive(String csv) throws IOException {
        compareCSVFiles("Test 7: Same content but differ in letter casing", csv + "file1.csv", csv + "file7.csv");
    }

    public void testMissingData(String csv) throws IOException {
        compareCSVFiles("Test 8: Data missing", csv + "file1.csv", csv + "file8.csv");
    }

    public void testDifferentRowOrder(String csv) throws IOException {
        compareCSVFiles("Test 9: The files have the same rows but in a different order", csv + "file1.csv", csv + "file9.csv");
    }

    public void testWhiteSpaces(String csv) throws IOException {
        compareCSVFiles("Test 10: The files have whitespace between data", csv + "file10.csv", csv + "file11.csv");
    }

    public void testBothFilesEmpty(String csv) throws IOException {
        compareCSVFiles("Test 11: Both the files compared are empty", csv + "file6.csv", csv + "file12.csv");
    }

    public void testDelimeterChange(String csv) throws IOException {
        compareCSVFiles("Test 12: The files have change in delimeter", csv + "file1.csv", csv + "file13.csv");
    }

    public void testSpecialCharacter(String csv) throws IOException {
        compareCSVFiles("Test 13: The file has special characters", csv + "file1.csv", csv + "file14.csv");
    }

    public void testDifferentNumbers(String csv) throws IOException {
        compareCSVFiles("Test 14: The file has different numbers", csv + "file1.csv", csv + "file15.csv");
    }

    public void testDataWithFrenchAccents(String csv) throws IOException {
        compareCSVFiles("Test 15: The data in the file has the same value but with a French accent", csv + "file1.csv", csv + "file16.csv");
    }

    public void testDuplicateData(String csv) throws IOException {
        compareCSVFiles("Test 16: Compare duplicate entries in one file", csv + "file1.csv", csv + "file17.csv");
    }

    public void testDuplicateDataBothFiles(String csv) throws IOException {
        compareCSVFiles("Test 17: Compare duplicate entries in both files", csv + "file17.csv", csv + "file18.csv");
    }

    public void testMissingRows(String csv) throws IOException {
        compareCSVFiles("Test 18: Missing Rows", csv + "file1.csv", csv + "file19.csv");
    }

    public void testMissingColumns(String csv) throws IOException {
        compareCSVFiles("Test 19: Missing Columns", csv + "file1.csv", csv + "file20.csv");
    }
}

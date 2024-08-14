import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVComparatorTest {

    public static void main(String[] args) throws IOException {
        CSVComparatorTest test = new CSVComparatorTest();
        
        //  CSV files are in a folder named "CSV_Files" in the project root
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
    }

    public void testIdenticalFiles(String csv) throws IOException {
    	System.out.println("\nTest 1: Identical Files");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file0.csv",
                csv + "file1.csv"
        );
    }
    
    public void testChangeInValue(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 2: Change in a Value");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file2.csv"
        );
    }

    public void testDifferentContent(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 3: Different Content");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file3.csv"
        );
    }

    public void testDifferentNumberOfRows(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 4: Different Number of Rows");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file4.csv"
        );
    }

    public void testDifferentNumberOfColumns(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 5: Different Number of Columns");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file5.csv"
        );
    }
    
    public void testEmptyFile(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 6: Compare an Empty file to a file with content");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file6.csv"
        );
    }
    
    public void testCaseSensitive(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 7: Same content but differ in letter casing");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file7.csv"
        );
    }
    
    public void testMissingData(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 8: Data missing");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
                csv + "file8.csv"
        );
    }
    
    public void testDifferentRowOrder(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 9: The files have the same rows but in a different order");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
                csv + "file9.csv"
        );
    }
    
    public void testWhiteSpaces(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 10: The files have in whitespace between data");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file10.csv",
        		csv + "file11.csv"
        );
    }
    
    public void testBothFilesEmpty(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 11: Both the files compared are empty");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file6.csv",
        		csv + "file12.csv"
        );
    }
    
    public void testDelimeterChange(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 12: The files have change in delimeter");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file13.csv"
        );
    }
    
    public void testSpecialCharacter(String csv) throws IOException {
        System.out.println("----------------------------------------------");
    	System.out.println("\nTest 13: The file have special character");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file14.csv"
        );
    }
    
    public void testDifferentNumbers(String csv) throws IOException {
        System.out.println("----------------------------------------------");
        System.out.println("\nTest 14: The file have different numbers");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file15.csv"
        );
    }
    
    public void testDataWithFrenchAccents(String csv) throws IOException {
        System.out.println("----------------------------------------------");
        System.out.println("\nTest 15: The data in the file has the same value but with a french accent");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file16.csv"
        );
    }

    public void testDuplicateData(String csv) throws IOException {
        System.out.println("----------------------------------------------");
        System.out.println("\nTest 16: compare duplicate entry on one file");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file17.csv"
        );
    }
    
    public void testDuplicateDataBothFiles(String csv) throws IOException {
        System.out.println("----------------------------------------------");
        System.out.println("\nTest 17: compare duplicate entry on both files");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file17.csv",
        		csv + "file18.csv"
        );
    }
    
    public void testMissingRows(String csv) throws IOException {
        System.out.println("----------------------------------------------");
        System.out.println("\nTest 18: Missing Row");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file19.csv"
        );
    }
    
    public void testMissingColumns(String csv) throws IOException {
        System.out.println("----------------------------------------------");
        System.out.println("\nTest 19: Missing Column");
        System.out.println("\nThe Results is:");
        compareCSVFiles(
        		csv + "file1.csv",
        		csv + "file20.csv"
        );
    }
    
    private void compareCSVFiles(String filePath1, String filePath2) throws IOException {
        List<String> differences = new ArrayList<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            int lineNum = 1;

            while (line1 != null || line2 != null) {
                if (line1 == null || line2 == null) {
                    differences.add("File lengths differ at line " + lineNum);
                    break;
                }

                String[] tokens1 = line1.split(",");
                String[] tokens2 = line2.split(",");

                if (tokens1.length != tokens2.length) {
                    differences.add("Number of columns differ at line " + lineNum);
                }

                for (int i = 0; i < Math.min(tokens1.length, tokens2.length); i++) {
                    if (!tokens1[i].equalsIgnoreCase(tokens2[i])) {
                        differences.add("Difference at line " + lineNum + ", column " + (i + 1) + ": " +
                                "File1 has \"" + tokens1[i] + "\" while File2 has \"" + tokens2[i] + "\"");
                    }
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNum++;
            }
        }

        if (differences.isEmpty()) {
            System.out.println("Two files have the same content.");
        } else {
            System.out.println("Differences found:");
            differences.forEach(System.out::println);
        }
    }
}

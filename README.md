Problem Statement:
Create an automation framework in Java  that compares  2 csv files and identifies & reports the differences between the 2 files 
Make sure the differences are clearly identified so results can be easily triaged
I would like to see the different csv files you would create to validate that your code covers all different scenarios



Scenarios Covered:
1) testIdenticalFiles - The compared CSV files are identical (files used - file0 and file1)
2) testChangeInValue - One CSV file has a change in cell value (files used - file0 and file2)
3) testDifferentContent - The compared CSV files are entirely different (files used - file0 and file3)
4) testDifferentNumberOfRows - Different Number of rows (files used - file1 and file4)
5) testDifferentNumberOfColumns - Different Number of Columns (files used - file1 and file5)
6) testEmptyFile - Compare an Empty file to a file with content (files used - file1 and file6)
7) testCaseSensitive - Same content but differ in letter casing (files used - file1 and file7)
8) testCaseSensitive - Data missing  (files used - file10 and file11)
9) testDifferentRowOrder - The files have the same rows but in a different order (files used - file10 and file11)
10) testWhiteSpaces - The files have in whitespace between data (files used - file10 and file11)
11) testBothFilesEmpty - Both the files compared are empty (files used - file6 and file12)
12) testDelimeterChange - The files have change in delimeter (files used - file1 and file13)
13) testSpecialCharacter - The file have special character (files used - file1 and file14)
14) testDifferentNumbers - The compared CSV files has different numbers (files used - file1 and file15)
15) testDataWithFrenchAccents - The compared CSV files has a data in the file which has the same value but with a french accent (files used - file1 and file16)
16) testDuplicateData - - The compared CSV files has duplicate entry on one file (files used - file1 and file17)
17) testDuplicateDataBothFiles - The compared CSV files has duplicate entry on both files (files used - file17 and file18)
18) testMissingRows - The compared CSV files in which one of the file has a entire row missing (files used - file1 and file19)
19) testMissingColumns - The compared CSV files in which one of the file has a entire column missing (files used - file1 and file20)

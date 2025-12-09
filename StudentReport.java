import java.util.Scanner;


public class StudentReport {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ===== Input for the School Details =====

        System.out.print("Enter School Name: ");
        String schoolName = input.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = input.nextLine();

        System.out.print("Enter Grade: ");
        String grade = input.nextLine();

        System.out.print("Enter Year: ");
        String year = input.nextLine();

        // Array initialisation
        final int STUDENTS = 12;
        String[] studentName = new String[STUDENTS];
        double[] english = new double[STUDENTS];
        double[] math = new double[STUDENTS];
        double[] history = new double[STUDENTS];
        double[] geography = new double[STUDENTS];
        double[] science = new double[STUDENTS];
        double[] programming = new double[STUDENTS];
        double[] total = new double[STUDENTS];
        String[] gradeRank = new String[STUDENTS];

        System.out.println("\n=== Enter Student Records ===");

        for (int i = 0; i < STUDENTS; i++) {
            System.out.println("\nStudent " + (i + 1));

            input.nextLine();
            System.out.print("Name: ");
            studentName[i] = input.nextLine();

            System.out.print("English: ");
            english[i] = input.nextDouble();

            System.out.print("Math: ");
            math[i] = input.nextDouble();

            System.out.print("History: ");
            history[i] = input.nextDouble();

            System.out.print("Geography: ");
            geography[i] = input.nextDouble();

            System.out.print("Science: ");
            science[i] = input.nextDouble();

            System.out.print("Programming: ");
            programming[i] = input.nextDouble();

            total[i] = english[i] + math[i] + history[i] + geography[i] + science[i] + programming[i];

            if (total[i] >= 540) gradeRank[i] = "A";
            else if (total[i] >= 480) gradeRank[i] = "B";
            else if (total[i] >= 420) gradeRank[i] = "C";
            else if (total[i] >= 360) gradeRank[i] = "D";
            else gradeRank[i] = "F";
        }

        // ===== Computation of the class data=====
        double sumEnglish = 0, sumMath = 0, sumHistory = 0, sumGeography = 0, sumScience = 0, sumProgramming = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int i = 0; i < STUDENTS; i++) {
            sumEnglish += english[i];
            sumMath += math[i];
            sumHistory += history[i];
            sumGeography += geography[i];
            sumScience += science[i];
            sumProgramming += programming[i];

            switch (gradeRank[i]) {
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "C":
                    countC++;
                    break;
                case "D":
                    countD++;
                    break;
                case "F":
                    countF++;
                    break;
            }
        }

        // ===== OUTPUT REPORT FORMAT =====
        System.out.println("\n----------------------------------------------------------------------------------------");
        System.out.printf("%45s\n", "School Name: " + schoolName);
        System.out.printf("%45s\n", "Teacher: " + teacherName);
        System.out.printf("%35s\n", "Grade: " + grade);
        System.out.printf("%35s\n", "Year: " + year);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Student Name     English  Math  History  Geography  Science  Programming  Total   Rank");
        System.out.println("------------------------------------------------------------------------------------------");

        for (int i = 0; i < STUDENTS; i++) {
            System.out.printf("%-15s %7.2f %7.2f %8.2f %10.2f %8.2f %12.2f %7.2f %5s\n",
                    studentName[i], english[i], math[i], history[i], geography[i], science[i], programming[i], total[i], gradeRank[i]);
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %7.2f %7.2f %8.2f %10.2f %8.2f %12.2f\n", "Totals:",
                sumEnglish, sumMath, sumHistory, sumGeography, sumScience, sumProgramming);

        System.out.printf("%-15s %7.2f %7.2f %8.2f %10.2f %8.2f %12.2f\n", "Averages:",
                sumEnglish/STUDENTS, sumMath/STUDENTS, sumHistory/STUDENTS,
                sumGeography/STUDENTS, sumScience/STUDENTS, sumProgramming/STUDENTS);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("Ranks: A's: %d   B's: %d   C's: %d   D's: %d   F's: %d\n",
                countA, countB, countC, countD, countF);
        System.out.println("------------------------------------------------------------------------------------------");
    }
}

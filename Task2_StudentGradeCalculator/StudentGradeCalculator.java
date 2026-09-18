import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("       STUDENT GRADE CALCULATOR       ");
        System.out.println("======================================");

        System.out.print("\nEnter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        if (numberOfSubjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            scanner.close();
            return;
        }

        double totalMarks = 0;
        double[] marks = new double[numberOfSubjects];

        // Get marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {

            while (true) {

                System.out.print(
                        "Enter marks for Subject " + (i + 1)
                                + " (0-100): ");

                double mark = scanner.nextDouble();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    totalMarks += mark;
                    break;
                }

                System.out.println(
                        "Invalid marks. Please enter a value between 0 and 100.");
            }
        }

        // Calculate average percentage
        double average = totalMarks / numberOfSubjects;

        // Determine grade
        String grade;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display result
        System.out.println("\n======================================");
        System.out.println("             RESULT                   ");
        System.out.println("======================================");

        System.out.println("Student Name : " + studentName);
        System.out.println("Subjects     : " + numberOfSubjects);
        System.out.println("--------------------------------------");

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf(
                    "Subject %d     : %.2f%n",
                    i + 1,
                    marks[i]
            );
        }

        System.out.println("--------------------------------------");

        System.out.printf(
                "Total Marks  : %.2f%n",
                totalMarks
        );

        System.out.printf(
                "Average      : %.2f%%%n",
                average
        );

        System.out.println("Grade        : " + grade);

        System.out.println("======================================");

        scanner.close();
    }
}
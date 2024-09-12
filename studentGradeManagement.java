import java.util.Scanner;

public class studentGradeManagement {

    public static int getUserInput(int[] studentID, int subjects, int[] studentGrades, int sumVal, int size, String[] studentNames, int[] total) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = scanner.next();

        System.out.println("Enter your last name:");
        String lastName = scanner.next();

        System.out.println("Enter your student id:");
        studentID[size] = scanner.nextInt();

        System.out.println("Enter the number of subjects you've taken:");
        subjects = scanner.nextInt();

        sumVal = 0;  // Reset sumVal for each student

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            studentGrades[i] = scanner.nextInt();
            sumVal += studentGrades[i];
        }

        total[size] = sumVal;  // Store total grade for current student
        studentNames[size] = firstName + " " + lastName;

        size++;  // Increment size for next student

        return subjects;
    }

    public static char[] gradeCalculation(int[] total, int subject, int count) {
        char[] gradeArr = new char[count];

        double average = 0.0;

        for (int i = 0; i < count; i++) {
            average = total[i] / (double) subject;  // Cast subject to double to get correct average
            char letterGrade;
            if (average >= 90) {
                letterGrade = 'A';
            } else if (average >= 80) {
                letterGrade = 'B';
            } else if (average >= 70) {
                letterGrade = 'C';
            } else if (average >= 60) {
                letterGrade = 'D';
            } else {
                letterGrade = 'F';
            }
            gradeArr[i] = letterGrade;
            System.out.println("-------->>> " + gradeArr[i]);
        }

        return gradeArr;
    }

    public static String convertIntoString(int[] studentID, int subjects, char[] Ga, int sumVal, int size, String[] studentNames, int[] total) {
        StringBuilder emptyS = new StringBuilder();
        for (int i = 0; i < size; i++) {
            emptyS.append("Student name: [").append(studentNames[i]).append("] ")
                  .append("Student ID: [").append(studentID[i]).append("] ")
                  .append("Student grade: ").append(Ga[i]);
            if (i < size - 1) {
                emptyS.append(",\n");
            }
        }

        return emptyS.toString().toUpperCase();
    }

    public static void main(String[] args) {
        String[] studentNames = new String[5];
        int[] studentID = new int[5];
        try {
            int size = 0;
            int subjects = 0;
            int sumVal = 0;

            int[] studentGrades = new int[5];
            int[] total = new int[5];

            int count = 0;
            char loopInitializer = 'y';
            String val;

            while (loopInitializer == 'y' && size < 5) {  // Add size check to prevent ArrayIndexOutOfBoundsException
                subjects = getUserInput(studentID, subjects, studentGrades, sumVal, size, studentNames, total);
                size++;  // Increment size for each new student
                count++;
                Scanner sc = new Scanner(System.in);

                System.out.println("Next student, would you like to enter your credentials: (y or n)");
                val = sc.next();
                loopInitializer = val.charAt(0);
            }

            char[] Ga = gradeCalculation(total, subjects, count);
            System.out.println(convertIntoString(studentID, subjects, Ga, sumVal, size, studentNames, total));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
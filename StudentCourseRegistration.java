
import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> courses = new ArrayList<>();
        String[] availableCourses = {"Math", "Science", "History", "Art", "Computer Science"};
        
        System.out.println("Welcome to the Course Registration System.");
        System.out.println("Available courses:");

        for (int i = 0; i < availableCourses.length; i++) {
            System.out.println((i + 1) + ". " + availableCourses[i]);
        }

        while (true) {
            System.out.print("\nEnter the course number to register (or 0 to finish): ");
            int courseNumber = scanner.nextInt();

            if (courseNumber == 0) {
                break;
            } else if (courseNumber > 0 && courseNumber <= availableCourses.length) {
                String course = availableCourses[courseNumber - 1];
                if (!courses.contains(course)) {
                    courses.add(course);
                    System.out.println("You have registered for: " + course);
                } else {
                    System.out.println("You are already registered for this course.");
                }
            } else {
                System.out.println("Invalid course number. Please try again.");
            }
        }

        System.out.println("\nYou have registered for the following courses:");
        for (String course : courses) {
            System.out.println("- " + course);
        }

        System.out.println("Thank you for using the Course Registration System.");
        scanner.close();
    }
}
    


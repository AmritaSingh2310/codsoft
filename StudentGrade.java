package Task2;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many subjects marks you want to calculate?");
        int numSubjects = sc.nextInt();

        System.out.println("Enter numbers separated by space:");

        ArrayList<Integer> marks = new ArrayList<>();
        
        System.out.println("Enter marks of " + numSubjects + " subjects:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks.add(sc.nextInt());
        }
        
        // Calculate total marks
        int totalMarks = 0;
        int totalSubMarks = numSubjects * 100;
        for (int mark : marks) {
            totalMarks += mark;
        }
        

        System.out.println("Once again Check your marks: " + marks);
        double averageMarks = (double) totalMarks / numSubjects;
        

        // Display the results
        System.out.println("\nTotal Marks: " + totalMarks + " out of: "+ totalSubMarks );
        System.out.println("Average Marks: " + averageMarks);
     
        System.out.println("Average Marks in percentage: " + (int)averageMarks + "%");
        
        if(averageMarks >= 80 && averageMarks <= 100) {
        	System.out.println("Grade A");
        }
        else if(averageMarks >= 70 && averageMarks <= 80) {
        	System.out.println("Grade B");
        }
        else if(averageMarks >= 60 && averageMarks <= 70) {
        	System.out.println("Grade C");
        }
        else if(averageMarks >= 50 && averageMarks <= 60) {
        	System.out.println("Grade D");
        }
        else if(averageMarks >= 33 && averageMarks <= 50) {
        	System.out.println("Grade E");
        }
        else {
        	System.out.println("Fail");
        }
        
        
        
        sc.close();
        sc.close(); // Close the scanner to prevent resource leaks
    }
}

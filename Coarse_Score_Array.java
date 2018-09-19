/*
 * Joe_hollon
 * cis_2212_tuseday_class
 * Due_tuseday_sept_8_2018
 * Coarse_Scores_In_Arrays
 * */

package arrays;

import java.util.Scanner;

public class Coarse_Score_Array 
{
	// so the whole project can use scanner and close once i was running into
	// problems
	// when i closed the scanner in separate methods, even when i named them
	// different
	// it would error out at first .close()
	final static Scanner key = new Scanner(System.in);

	// size of array put here because all methods see it, not sure if this is global
	// scope or class scoped
	static int SIZE = 0;

	// method for input for user grades
	public static double[] ptsEarned(int numAssignments)// numAssignments = user input size
	{
		// for input
		// Scanner key = new Scanner(System.in);

		// 1
		// make a method for array
		double[] userGrades = new double[numAssignments];

		// for loop for user input size
		for (int i = 0; i < numAssignments; i++) {
			// populate array
			System.out.print("Enter points for Assignment #" + (i + 1) + ": ");
			userGrades[i] = key.nextDouble();

			// error check this stumped me for a bit, i wanted to put in if statement
			// then populate with-in, but it worked when i separated it,
			// but when the element is greater then or equal to zero it skips the
			// while loop, if it is a negative number it puts the for-loop on pause
			// and enters the while loop till the user enter zero or greater.
			// "Magical" :}
			while (userGrades[i] < 0) {
				System.out.print("Earned points must be 0 or greater. Please try again: ");
				userGrades[i] = key.nextDouble();
			}
		}

		// returns a array
		return userGrades;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////

	// 2
	// input for max points for tests
	public static double[] ptsMax(int numAssignments) {
		// array for max points
		double[] maxPoints = new double[numAssignments];

		// setting numbers in array
		for (int i = 0; i < numAssignments; i++) {
			System.out.print("Max pts possible for Assignment: #" + (i + 1) + ": ");
			maxPoints[i] = key.nextDouble();

			// error checking if number less then 1 if so re-enter
			while (maxPoints[i] < 1) {
				System.out.print("Earned points must be 0 or greater. Please try again: ");
				maxPoints[i] = key.nextDouble();
			}
		}

		return maxPoints;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////

	// 3
	// total points earned method
	public static double calcTotalPtsEarned(double[] earnedArray) {
		double sum = 0;

		// summing the points earned
		for (int i = 0; i < earnedArray.length; i++) {
			sum += earnedArray[i];
		}

		return sum;
	}
	/////////////////////////////////////////////////////////////////////////////////

	// 4
	// total test points method
	public static double calcTotalPtsMax(double[] maxArray) {
		double testSum = 0;

		// summing the max points
		for (int i = 0; i < maxArray.length; i++) {
			testSum += maxArray[i];
		}
		return testSum;
	}
	////////////////////////////////////////////////////////////////////////////////

	// 5
	// letter grade
	public static char ltrGrade(double Percentage) {
		char letter = 'j';

		// choosing the letter grades for percentage
		if (Percentage < 60)// 0-59
		{
			letter = 'F';
		} else if (Percentage >= 60 && Percentage < 70)// 60-69
		{
			letter = 'D';
		} else if (Percentage >= 70 && Percentage < 80)// 70-79
		{
			letter = 'C';
		} else if (Percentage >= 80 && Percentage < 90)// 80-89
		{
			letter = 'B';
		} else if (Percentage >= 90)// 60-999999999999999999999
		{
			letter = 'A';
		}

		return letter;
	}
	////////////////////////////////////////////////////////////////////////////////

	// 6
	// display all numbers, try to nest methods, calculate grade percentage
	public static void displayArray(double[] userGrade, double[] maxTestPoints) {
		// use loop to view points earned and test points
		// really didn't understand this method on the work-sheet, it wanted me to just
		// pass one parameter ptsArray but
		// above i have both the scores in two separate methods, then the work-sheet
		// tells me to call the methods in main,
		// so i made it work but modifying the parameters. The output is exactly the
		// same as you specified

		// then formated using _printf

		// messing about with strings
		String Earned = "Earned";
		String Max = "Max";

		System.out.printf("%9s  - %5s\n", Earned, Max);

		for (int i = 0; i < SIZE; i++) {
			System.out.printf("%9.2f %9.2f\n", userGrade[i], maxTestPoints[i]);
		}

		System.out.println();
	}
	////////////////////////////////////////////////////////////////////////////////

	//main method
	public static void main(String[] args)
	{
		//prompt user to tell how many assignments will be used, validate and make sure a _min of 1
		//call ptsEarned and ptsMax and pass in the assignment count
		
		for(int i = 0; i < 1; i++)
		{
			//put size entry
			//put while loop for checking
			System.out.print("How many assignments (at least 1): ");
			SIZE = key.nextInt();
			
			//error checking if number less then 1 if so re-enter
			while(SIZE <= 0)
			{
				System.out.print("How many assignments (at least 1): ");
				SIZE = key.nextInt();
			}
		}
		
		System.out.println();
		
		//user grade input
		double[] userGrade = ptsEarned(SIZE);
		
		System.out.println();
		
		//max points input
		double[] maxTestPoints = ptsMax(SIZE);
		
		System.out.println();
		
		//summing points earned
		double userEarnedTotal = calcTotalPtsEarned(userGrade);
		
		//summing max points
		double totalTest = calcTotalPtsMax(maxTestPoints);
		
		//making a percentage of earned/max
		double gradePercentage = (userEarnedTotal / totalTest) * 100;
		
		//choose a letter grade by the percentage
		char letter = ltrGrade(gradePercentage);
		
		//displays earned and max arrays
		displayArray(userGrade, maxTestPoints);
		System.out.printf("Points Earned: %.2f\n",userEarnedTotal);
		System.out.printf("Total Possible: %.2f\n",totalTest);
		System.out.printf("Coarse Score: %.2f%%\n",gradePercentage);
		//double per = 9999999999999999999999999999999999999999999999999999999999999999999999999999999999999.9; 
		//char letter = ltrGrade(per);
		System.out.println("Letter Grade: " + letter);
		
		//close scanner
		key.close();
		
	}//end main		
}

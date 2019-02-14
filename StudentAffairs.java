package lab01;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentAffairs {
	
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Course> courses = new ArrayList<Course>();
		Scanner myScanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		boolean isContinued = true;
		while(isContinued) {
		String input;
		input = myScanner.nextLine();
		String[] splitStr = input.split("\\s+");
		
		switch(splitStr[0]) {
			case "addStudent": 
				Student st = new Student(splitStr[1], Integer.parseInt(splitStr[2]));
				students.add(st);
				System.out.println("Student " + Integer.parseInt(splitStr[2]) + " added to the system.");
				break;
				
			case "addCourse": 
				Course crs = new Course(splitStr[1]);
				courses.add(crs);
				System.out.println("Course " + splitStr[1] + " added to the system.");
				break;
				
			case "enrollWithGrade":
				Student currentSt = students.get(Integer.parseInt(splitStr[1]) - 1);
				currentSt.addCourse(splitStr[2], Integer.parseInt(splitStr[3]));
				System.out.println("Student " + Integer.parseInt(splitStr[1]) + " enrolled to the " + splitStr[2]);
				break;
				
			case "updateGrade":
				Student currentStd = students.get(Integer.parseInt(splitStr[1]) - 1);
				currentStd.updateGrade(splitStr[2], Integer.parseInt(splitStr[3]));
				System.out.println("Course " + splitStr[2] + ": Student " + Integer.parseInt(splitStr[1])
				+ "grade updated to " + splitStr[3] + ".");
			
			case "report":
				int index = 0;
				double result,avg;
				Student topSt;
				
				if(splitStr[1].equals("courseAVG")) {
					for(int i = 0; i < courses.size(); i++) {
						if(courses.get(i).courseName.equals(splitStr[2])) {
							index = i;
						}
					}
					result = Math.round((courses.get(index).calculateCourseAvg()*100.0) / 100.0);
					System.out.println("Average of " + splitStr[2] + " is " + result + ".");
				}
				else if(splitStr[1].equals("topStudent")) {
					for(int i = 0; i < courses.size(); i++) {
						if(courses.get(i).courseName.equals(splitStr[2])) {
							index = i;
						}
					}
					topSt = courses.get(index).findTopStudent();
					System.out.println(splitStr[2] + " top student: " + topSt.toString() + ".");
				}
				else if(splitStr[1].equals("studentGradeAVG")) {
					avg = students.get(Integer.parseInt(splitStr[2]) - 1).gradeAVG();
					System.out.println("Student " + splitStr[2] + " grade AVG: " + avg + ".");
				}
				break;
				
			case "Exit":
				isContinued = false;
				return;
		}
		}
	}
}

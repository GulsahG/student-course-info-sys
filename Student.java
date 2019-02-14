package lab01;

public class Student {
	String[] courses;
	int[] grades;
	int size, ID, numberOfCourses = 0;
	String name;
		
	public Student(String name, int ID) {
		size = 3;
		courses = new String[size];
		grades = new int[size];	
	}	
	
	public void addCourse(String course, int grade) {
		numberOfCourses++;
		Course newCrs = new Course(course);
		courses[numberOfCourses - 1] = course;
		grades[numberOfCourses - 1] = grade;
	}
	
	public void updateGrade(String course, int grade) {
		int index = 0;
		for(int i = 0; i < courses.length; i++) {
			if(course.equals(courses[i])) {
				index = i;
			}
		}
		grades[index] = grade;
	}
	
	public int findCourseGrade(String course) {
		int index = 0;
		for(int i = 0; i < courses.length; i++) {
			if(course.equals(courses[i])) {
				index = i;
			}
		}
		return grades[index];
	}
	
	public String toString() {
		return name + ", ID= " + Integer.toString(ID);
	}
	
	public double gradeAVG() {
		double result = 0;
		int tempSize = size;
		for(int i = 0; i < size; i++) {
			if(grades[i] == 0) {
				tempSize--;
			}
			result += grades[i];
		}
		return (result/tempSize);
	}
	
	public void arrayExtension() {
		int [] tempArr = new int[size * 2];
		String [] tempArr2 = new String[size * 2];
		for(int i = 0; i < size; i++) {
			tempArr[i] = grades[i];
			tempArr2[i] = courses[i];
		}
		grades = tempArr;	 
		courses = tempArr2;
	}
}

package lab01;
import java.util.ArrayList;  

public class Course {
	String courseName;
	ArrayList<Student> students;
	
	public Course(String courseName){
		students = new ArrayList<Student>();
		this.courseName = courseName;
	}
	
	public void addStudent(String name, int ID){
		Student newSt = new Student(name, ID);
		students.add(newSt);
	}
	
	public double calculateCourseAvg() {
		double result = 0;
		for(int i = 0; i < students.size(); i++) {
			result += students.get(i).findCourseGrade(this.courseName);
		}
		return (result/students.size());
	}
	
	public Student findTopStudent() {
		int max = 0, grade = 0;
		for(int i = 0; i < students.size(); i++) {
			grade = students.get(i).findCourseGrade(this.courseName);
			if(grade > max) {
				max = i;
			}
		}
		return students.get(max);
	}
	
}

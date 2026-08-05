package services;

import models.Course;
import models.Student;

public class EnrollmentManager {

    private Student[] students = new Student[100];
    private int count = 0;

    public void addStudent(Student s){
        students[count] = s;
        count++;
    }

    public Student searchStudentById(String id){
        for(int i = 0; i < count; i++){
            if(students[i].getId().equals(id)){
                return students[i];
            }
        }
        return null;
    }

    public void sortStudentsByName(){
        for(int i = 0; i < count - 1; i++){
            for(int j = 0; j < count - i - 1; j++){
                if(students[j].getName().compareToIgnoreCase(students[j + 1].getName()) > 0){
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public void enrollStudentInCourse(Student s, Course c){
        System.out.println(s.getName() + " has been enrolled in " + c.getTitle());
    }

    public Student[] getStudents(){
        return students;
    }

    public int getCount(){
        return count;
    }
}

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract String getEvaluationMethod();
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class Course<T extends CourseType> {
    private T course;

    public Course(T course) {
        this.course = course;
    }

    public T getCourse() {
        return course;
    }

    public void displayInfo() {
        System.out.println(course.getCourseName() + " - " + course.getEvaluationMethod());
    }
}

import java.util.List;

class CourseUtility {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName() + " | " + course.getEvaluationMethod());
        }
    }
}

package com.introduction.multileveluniversitycoursemanagementsystem;

class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
        List<CourseType> courseList = new ArrayList<>();
        courseList.add(new ExamCourse("Mathematics"));
        courseList.add(new AssignmentCourse("Software Engineering"));
        courseList.add(new ResearchCourse("Artificial Intelligence"));

        System.out.println("All Courses:");
        CourseUtility.displayAllCourses(courseList);

        System.out.println("\nSingle Course Display:");
        Course<ExamCourse> mathCourse = new Course<>(new ExamCourse("Mathematics"));
        mathCourse.displayInfo();
    }
}
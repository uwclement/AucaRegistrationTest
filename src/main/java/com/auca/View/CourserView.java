package com.auca.View;

import com.auca.Implementation.CourseImpl;
import com.auca.Model.Academic_Unit;
import com.auca.Model.Course;
import com.auca.Model.Semester;

import java.text.ParseException;
import java.util.Scanner;
import java.util.UUID;

public class CourserView {
    public static void main(String[] args) throws ParseException {
        boolean condition = true;
        UUID course_id;
        String course_name;
        String course_code;
        String seme_id;
        String dept_id;
        int result;
        Course cour = new Course();
        CourseImpl impl = new CourseImpl();
        while (condition) {
            System.out.println("=========================");
            System.out.println("Course Registration System");
            System.out.println("---------------------------");
            System.out.println("1.Register Course");
            System.out.println("2.Update Course");
            System.out.println("3.Delete Course");
            System.out.println("4.View Course");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.print("Choose: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter course_Code: ");
                    course_code = input.next();
                    System.out.print("Enter course_name: ");
                    course_name = input.next();
                    System.out.print("Enter Semester: ");
                    seme_id = input.next();
                    Semester seme = new Semester(Integer.parseInt(seme_id));
                    System.out.print("Enter Department: ");
                    dept_id = input.next();
                    Academic_Unit acu = new Academic_Unit(UUID.fromString(dept_id));
                    cour.setCourse_code(course_code);
                    cour.setCourse_name(course_name);
                    cour.setSemester(seme);
                    cour.setAcademic_Unit(acu);
                    try {
                        result = impl.saveCourse(cour);
                        if (result > 0) {
                            System.out.println("Course saved Successfully");
                        } else {
                            System.out.println("Course Not saved");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    break;

                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}

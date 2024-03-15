package com.auca.View;


import com.auca.Implementation.CourseImpl;
import com.auca.Implementation.StudentCourseImpl;
import com.auca.Implementation.StudentRegImpl;
import com.auca.Model.*;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class StudentRegView {

    public static void main(String[] args) throws ParseException {
        boolean condition = true;
        UUID registration_id;
        UUID course;
        String studentId;
        String registration_code;
        int NbrCourse;
        int result;
        int saveResult;
        String semeid;
        boolean studentExists = false;
        boolean semesterExists = false;
        StudentRegistration stuReg = new StudentRegistration();
        StudentRegImpl impl = new StudentRegImpl();
        Student_Course studentCourse = new Student_Course();
        StudentCourseImpl implStuCour = new StudentCourseImpl();
        Course cr = new Course();
        CourseImpl courseImpl = new CourseImpl();
        while (condition) {
            System.out.println("=========================");
            System.out.println(" Registration System");
            System.out.println("---------------------------");
            System.out.println("1.Register Student");
            System.out.println("2.Update Student Registration");
            System.out.println("3.Delete Student Registration");
            System.out.println("4.View Student Registration");
            System.out.println("5.Search Student Per Semester");
            System.out.println("6.Search Student Per Department and Semester");
            System.out.println("7.Search Student Per Course and Semester");
            System.out.println("8.Search Course Per Department and Semester");
            System.out.println("9.Search Course Per Student");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.print("Choose: ");
            Scanner input = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter registration_code: ");
                    registration_code = input.next();
                    System.out.print("Enter Student Id: ");
                    studentId = input.next();
                    Student student_id = new Student(Integer.parseInt(studentId));
                    System.out.print("Enter Semester: ");
                    semeid = input.next();
                    Semester semester_id =new Semester(Integer.parseInt(semeid));
                    try {
                        studentExists = impl.isStudentExists(Integer.parseInt(studentId));
                        semesterExists = impl.isSemestertExists(Integer.parseInt(semeid));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (!studentExists || studentId.isEmpty() || semeid.isEmpty() ||!semesterExists) {
                        System.out.println("The Student or Semester is not Found");
                    }
                    else {
                        System.out.print("Enter Department: ");
                        Academic_Unit deptid = new Academic_Unit(UUID.fromString(input.next()));
                        System.out.print("Enter Number of Courses Less than 3: ");
                        NbrCourse = input.nextInt();
                        if(NbrCourse == 1) {
                            System.out.print("Enter Course: ");
                            course = UUID.fromString(input.next());
                            Course course_id = new Course(course);
                            stuReg.setRegistration_code(registration_code.charAt(0));
                            stuReg.setRegistration_date(new Timestamp(System.currentTimeMillis()));
                            stuReg.setStudent(student_id);
                            stuReg.setSemester(semester_id);
                            stuReg.setAcademic_Unit(deptid);

                            try {
                                result = impl.saveRegistration(stuReg);
                                if (result > 0) {
                                    System.out.println("Registration saved Successfully");
                                    registration_id = stuReg.getRegistration_id();
                                    studentCourse.setStudentRegistration(new StudentRegistration(registration_id));
                                    studentCourse.setCourse(course_id);
                                    saveResult = implStuCour.saveStudentCourse(studentCourse);
                                    if (saveResult>0){
                                        System.out.println("Registration Course saved Successfully");
                                    }
                                    else {
                                        System.out.println("Registration Course not saved Successfully");
                                    }
                                } else {
                                    System.out.println("Registration Not saved");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Registration_Id");
                    registration_id = UUID.fromString(input.next());
                    System.out.print("Enter registration_code: ");
                    registration_code = input.next();
                    System.out.print("Enter Student Id: ");
                    studentId = input.next();
                    System.out.print("Enter Semester: ");
                    semeid = input.next();
                    try {
                        studentExists = impl.isStudentExists(Integer.parseInt(studentId));
                        semesterExists = impl.isSemestertExists(Integer.parseInt(semeid));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (!studentExists || studentId.isEmpty() || semeid.isEmpty() ||!semesterExists) {
                        System.out.println("The Student or Semester is not Found");
                    }
                    else {
                        System.out.print("Enter Department: ");
                        Academic_Unit deptid = new Academic_Unit(UUID.fromString(input.next()));
                        System.out.print("Enter Number of Courses Less than 3: ");
                        NbrCourse = input.nextInt();
                        if(NbrCourse == 1) {
                            System.out.print("Enter Course: ");
                            course = UUID.fromString(input.next());
                            Course course_id = new Course(course);
                            stuReg.setRegistration_id(registration_id);
                            stuReg.setRegistration_code(registration_code.charAt(0));
                            stuReg.setRegistration_date(new Timestamp(System.currentTimeMillis()));
                            stuReg.setStudent(new Student(Integer.parseInt(studentId)));
                            stuReg.setSemester(new Semester(Integer.parseInt(semeid)));
                            stuReg.setAcademic_Unit(deptid);

                            try {
                                result = impl.updateRegistration(stuReg);
                                if (result > 0) {
                                    System.out.println("Registration saved Successfully");
                                    registration_id = stuReg.getRegistration_id();
                                    studentCourse.setStudentRegistration(new StudentRegistration(registration_id));
                                    studentCourse.setCourse(course_id);
                                    saveResult = implStuCour.saveStudentCourse(studentCourse);
                                    if (saveResult>0){
                                        System.out.println("Registration Course saved Successfully");
                                    }
                                    else {
                                        System.out.println("Registration Course not saved Successfully");
                                    }
                                } else {
                                    System.out.println("Registration Not saved");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Registration_Id");
                    registration_id = UUID.fromString(input.next());
                    stuReg.setRegistration_id(registration_id);
                    try {
                        result = impl.deleteRegistration(stuReg);
                        if (result > 0) {
                            System.out.println("Registration Deleted Successfully");
                        } else {
                            System.out.println("Registration Not Deleted");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    break;
                case 4:
                    try {
                        System.out.println("The List of All Registration");
                        List<StudentRegistration> studRegs = impl.displayRegistration();
                        if (studRegs == null) {
                            System.out.println("No Registration Found");
                        } else {
                            for (StudentRegistration reg : studRegs) {
                                System.out.println("Registration ID: " + reg.getRegistration_id());
                                System.out.println("Registration Code: " + reg.getRegistration_code());
                                System.out.println("Registration Date: " + reg.getRegistration_date());
                                Student stu = reg.getStudent();
                                System.out.println("Student ID : " + stu.getFirst_name());
                                Semester semester = reg.getSemester();
                                System.out.println("Semester : " + semester.getsemester_name());
                                Academic_Unit department = reg.getAcademic_Unit();
                                System.out.println("Department : " + department.getAcademic_name());
                                System.out.println();

                            }
                            ;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        System.out.println("The List of All Registration By Semester");
                        System.out.print("Enter Semester: ");
//                        semeid = input.next();
//                        stuReg.getSemester(semeid);
                        List<StudentRegistration> studRegs = impl.studentPerSemester(1);
                        if (studRegs == null) {
                            System.out.println("No Registration Found");
                        } else {
                            for (StudentRegistration reg : studRegs) {
                                System.out.println("Registration ID: " + reg.getRegistration_id());
                                System.out.println("Registration Code: " + reg.getRegistration_code());
                                System.out.println("Registration Date: " + reg.getRegistration_date());
                                Student stu = reg.getStudent();
                                System.out.println("Student ID : " + stu.getFirst_name());
                                Semester semester = reg.getSemester();
                                System.out.println("Semester : " + semester.getsemester_name());
                                Academic_Unit department = reg.getAcademic_Unit();
                                System.out.println("Department : " + department.getAcademic_name());
                                System.out.println();
                            }
                            ;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 6:
                    try {

                        System.out.println("The List of All Registration By Department and  Semester");
                        System.out.print("Enter Department: ");
                        UUID deptid = UUID.fromString(input.next());
                        System.out.print("Enter Semester: ");
                        int seme_id = input.nextInt();
                        List<Object[]> studRegs = impl.StudentPerDepartmentSemester(new Academic_Unit(deptid),seme_id);
                        if (studRegs == null) {
                            System.out.println("No Registration Found");
                        } else {
                            for (Object[] reg : studRegs) {
                                String fname = (String) reg[0];
                                String lname = (String) reg[1];
                                String crname = (String) reg[2];
                                String semname = (String) reg[3];
                                String deptname = (String) reg[4];
                                System.out.println("First name: " +  fname);
                                System.out.println("Last Name: " + lname);
                                System.out.println("Course Name: " + crname);
                                System.out.println("Semester Name : " + semname);
                                System.out.println("Department Name: " + deptname);
                                System.out.println();
                            }
                            ;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 7:
                    try {

                        System.out.println("The List of All Registration By Course and Semester");
                        System.out.print("Enter Course: ");
                        UUID course_id = UUID.fromString(input.next());
                        System.out.print("Enter Semester: ");
                        int seme_id = input.nextInt();
                        List<Object[]> studRegs = impl.StudentPerCourseSemester(new Course(course_id),new Semester(seme_id));
                        if (studRegs == null) {
                            System.out.println("No Registration Found");
                        } else {
                            for (Object[] reg : studRegs) {
                                int stuID = (Integer) reg[0];
                                String seme = (String) reg[1];
                                String cour = (String) reg[2];
                                System.out.println("Student ID : " + stuID);
                                System.out.println("Semester : " + seme);
                                System.out.println("Course : " + cour);
                                System.out.println();

                            }
                            ;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 8:
                    try {
                        System.out.println("The List of All Course By Department and  Semester");
                        System.out.print("Enter Department: ");
                        UUID deptid = UUID.fromString(input.next());
                        System.out.print("Enter Semester: ");
                        int seme_id = input.nextInt();
                        List<Course> courses = courseImpl.CourseperDepartmentSemester(deptid,seme_id);
                        if (courses == null) {
                            System.out.println("No Course Found");
                        } else {
                            for (Course reg : courses) {
                                System.out.println("Course ID: " + reg.getCourse_id());
                                System.out.println("Course Code: " + reg.getCourse_code());
                                System.out.println("Course Name: " + reg.getCourse_name());
                                Semester semester = reg.getSemester();
                                System.out.println("Semester : " + semester.getsemester_name());
                                Academic_Unit department = reg.getAcademic_Unit();
                                System.out.println("Department : " + department.getAcademic_name());
                                System.out.println();
                            }

                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        System.out.println("The List of All Courses By Student");
                        System.out.print("Enter Student_id: ");
                        int stuId = input.nextInt();
                        Student student = new Student(stuId);
                        List<Object[]> results = impl.courseperStudernt(student);
                        if (results == null || results.isEmpty()) {
                            System.out.println("No Courses Found");
                        } else {
                            for (Object[] row : results) {
                                String courseName = (String) row[0];
                                String courseCode = (String) row[1];
                                String firstName = (String) row[2];
                                System.out.println("Course Name: " + courseName);
                                System.out.println("Course Code: " + courseCode);
                                System.out.println("First Name: " + firstName);
                                System.out.println();
                            }
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

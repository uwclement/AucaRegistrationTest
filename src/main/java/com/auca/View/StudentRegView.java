package com.auca.View;


import com.auca.Implementation.StudentRegImpl;
import com.auca.Model.Student;
import com.auca.Model.StudentRegistration;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentRegView {

    public static void main(String[] args) throws ParseException {
        boolean condition = true;
        int registration_id;
        String registration_code;
        Date registration_date;
        int student_id;
        int semester_id;
        int dept_id;
        int result;
        String semeid;
        boolean studentExists = false;
        boolean semesterExists = false;
        StudentRegistration stuReg = new StudentRegistration();
        StudentRegImpl impl = new StudentRegImpl();
        while (condition) {
            System.out.println("=========================");
            System.out.println(" Registration System");
            System.out.println("---------------------------");
            System.out.println("1.Register Student");
            System.out.println("2.Update Student Registration");
            System.out.println("3.Delete Student Registration");
            System.out.println("4.View Student Registration");
            System.out.println("5.Search Student Registration");
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
                    String studentid = input.next();
                    student_id = Integer.parseInt(studentid);
                    System.out.print("Enter Semester: ");
                    semeid = input.next();
                    semester_id = Integer.parseInt(semeid);
                    try {
                        studentExists = impl.isStudentExists(student_id);
                        semesterExists = impl.isSemestertExists(semester_id);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (!studentExists || studentid.isEmpty() || semeid.isEmpty() ||!semesterExists) {
                        System.out.println("The Student or Semester is not Found");
                    } else {
                        System.out.print("Enter Department: ");
                        dept_id = Integer.parseInt(input.next());
                        stuReg.setRegistration_code(registration_code.charAt(0));
                        stuReg.setRegistration_date(new Timestamp(System.currentTimeMillis()));
                        stuReg.setStudent(student_id);
                        stuReg.setSemester(semester_id);
                        stuReg.setDepartment_id(dept_id);

                        try {
                            result = impl.saveRegistration(stuReg);
                            if (result > 0) {
                                System.out.println("Registration saved Successfully");
                            } else {
                                System.out.println("Registration Not saved");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter registration_code: ");
                    registration_code = input.next();
                    System.out.print("Enter Student Id: ");
                    student_id = Integer.parseInt(input.next());
                    System.out.print("Enter Semester: ");
                    semester_id = Integer.parseInt(input.next());
                    System.out.print("Enter Department: ");
                    dept_id = Integer.parseInt(input.next());
                    stuReg.setRegistration_code(registration_code.charAt(0));
                    stuReg.setStudent(student_id);
                    stuReg.setSemester(semester_id);
                    stuReg.setDepartment_id(dept_id);
                    try {
                        result = impl.updateRegistration(stuReg);
                        if (result > 0) {
                            System.out.println("Registration UPDATED Successfully");
                        } else {
                            System.out.println("Registration Not UPDATED");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    break;
                case 3:
                    System.out.print("Enter Semester Id: ");
                    registration_id = Integer.parseInt(input.next());
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
                                System.out.println("Student ID : " + reg.getStudent());
                                System.out.println("Semester : " + reg.getSemester());
                                System.out.println("Department : " + reg.getDepartment_id());
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
                                System.out.println("Student ID : " + reg.getStudent());
                                System.out.println("Semester : " + reg.getSemester());
                                System.out.println("Department : " + reg.getDepartment_id());
                                System.out.println();
                            }
                            ;
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

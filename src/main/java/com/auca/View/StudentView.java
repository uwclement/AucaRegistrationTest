package com.auca.View;

import com.auca.Implementation.StudentImpl;
import com.auca.Model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    public static void main (String[] args) throws ParseException {
        boolean condition = true;
        int studentid;
        String firstname;
        String lastname;
        Date DOB;
        int result;
        Student stu = new Student();
        StudentImpl imp = new StudentImpl();
        while (condition){
            System.out.println("=========================");
            System.out.println("Student Registration System");
            System.out.println("---------------------------");
            System.out.println("1.Register Student");
            System.out.println("2.Update Student");
            System.out.println("3.Delete Student");
            System.out.println("4.View Students");
            System.out.println("5.Search Student");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.print("Choose: ");
            Scanner input = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter Student Id: ");
                    studentid = Integer.parseInt(input.next());
                    if(String.valueOf(studentid).length()!=5){
                     System.out.println("Id should be 5 numbers");
                    }else{
                        System.out.print("Enter FirstName: ");
                        firstname = input.next();
                        System.out.print("Enter LastName: ");
                        lastname = input.next();
                        System.out.println("Enter Date of Birth");
                        DOB = dateFormat.parse(input.next());
                        stu.setStudent_id(studentid);
                        stu.setFirst_name(firstname);
                        stu.setLast_name(lastname);
                        stu.setDate_of_birth(DOB);
                          try {
                              result = imp.saveStudent(stu);
                              if (result>0){
                                  System.out.println("Student saved Successfully");
                              }else{
                                  System.out.println("Student Not saved");
                              }
                          }catch (Exception ex){
                              ex.printStackTrace();
                          }

                    }
                    break;
                case 2:
                    System.out.print("Enter Student Id: ");
                    studentid = Integer.parseInt(input.next());
                    if(String.valueOf(studentid).length()!=5){
                        System.out.println("Id should be 5 numbers");
                    }else{
                        System.out.print("Enter New FirstName: ");
                        firstname = input.next();
                        System.out.print("Enter New LastName: ");
                        lastname = input.next();
                        System.out.println("Enter New  Date of Birth");
                        DOB = dateFormat.parse(input.next());
                        stu.setStudent_id(studentid);
                        stu.setFirst_name(firstname);
                        stu.setLast_name(lastname);
                        stu.setDate_of_birth(DOB);
                        try {
                            result = imp.updateStudent(stu);
                            if (result>0){
                                System.out.println("Student UPDATED Successfully");
                            }else{
                                System.out.println("Student Not UPDATED");
                            }
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }

                    }
                    break;
                case 3:
                    System.out.print("Enter Student Id: ");
                    studentid = Integer.parseInt(input.next());
                    if(String.valueOf(studentid).length()!=5){
                        System.out.println("Id should be 5 numbers");
                    }else{
                        stu.setStudent_id(studentid);
                        try {
                            result = imp.deleteStudent(stu);
                            if (result>0){
                                System.out.println("Student Deleted Successfully");
                            }else{
                                System.out.println("Student Not Deleted");
                            }
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }

                    }
                    break;
                case 4:
                    try {
                        System.out.println("The List of All Students");
                        List<Student> students =imp.displayStudents();
                        if(students == null){
                            System.out.println("No Student Found");
                        }else
                        {
                             for (Student stud : students) {
                                 System.out.println("Student ID: " + stud.getStudent_id());
                                 System.out.println("First Name: " + stud.getFirst_name());
                                 System.out.println("Last Name: " + stud.getLast_name());
                                 System.out.println("Date of Birth: " + stud.getDate_of_birth());
                                 System.out.println();

                           } ;
                         }
                    }catch (Exception ex){
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

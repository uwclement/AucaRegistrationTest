package com.auca.View;

import com.auca.Implementation.SemesterImpl;
import com.auca.Implementation.StudentImpl;
import com.auca.Model.Semester;
import com.auca.Model.Student;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SemesterView {
    public static void main(String[] args) throws ParseException {
        boolean condition = true;
        int semester_id;
        String semester_name;
        Date start_date;
        Date end_date;
        int result;
        Semester seme = new Semester();
        SemesterImpl impl = new SemesterImpl();
        while (condition) {
            System.out.println("=========================");
            System.out.println("Semester Registration System");
            System.out.println("---------------------------");
            System.out.println("1.Register Semester");
            System.out.println("2.Update Semester");
            System.out.println("3.Delete Semester");
            System.out.println("4.View Semester");
            System.out.println("5.Search Semester");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.print("Choose: ");
            Scanner input = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter semester_name: ");
                    semester_name = input.next();
                    System.out.println("Enter End Date ");
                    end_date = dateFormat.parse(input.next());
                    seme.setsemester_name(semester_name);
                    seme.setStarting_date(new Timestamp(System.currentTimeMillis()));
                    seme.setEnd_date(end_date);
                    try {
                        result = impl.saveSemester(seme);
                        if (result > 0) {
                            System.out.println("Semester saved Successfully");
                        } else {
                            System.out.println("Semester Not saved");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    break;
            case 2:
                System.out.print("Enter Semester Id: ");
                semester_id = Integer.parseInt(input.next());
                System.out.print("Enter New semester_name: ");
                semester_name = input.next();
                System.out.println("Enter New  Date of Birth");
                end_date = dateFormat.parse(input.next());
                seme.setSemester_id(semester_id);
                seme.setsemester_name(semester_name);
                seme.setEnd_date(end_date);
                    try {
                        result = impl.updateSemester(seme);
                        if (result > 0) {
                            System.out.println("Semester UPDATED Successfully");
                        } else {
                            System.out.println("Semester Not UPDATED");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                break;
            case 3:
                System.out.print("Enter Semester Id: ");
                semester_id = Integer.parseInt(input.next());
                    seme.setSemester_id(semester_id);
                    try {
                        result = impl.deleteSemester(seme);
                        if (result > 0) {
                            System.out.println("Semester Deleted Successfully");
                        } else {
                            System.out.println("Semester Not Deleted");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                break;
            case 4:
                try {
                    System.out.println("The List of All Semesters");
                    List<Semester> semesters = impl.displaySemester();
                    if (semesters == null) {
                        System.out.println("No Semester Found");
                    } else {
                        for (Semester sem : semesters) {
                            System.out.println("Semester ID: " + sem.getSemester_id());
                            System.out.println("Semester Name: " + sem.getsemester_name());
                            System.out.println("Start Date: " + sem.getStarting_date());
                            System.out.println("End Date : " + sem.getEnd_date());
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


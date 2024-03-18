package com.auca.View;

import com.auca.Implementation.AcademicUnitImpl;
import com.auca.Model.Academic_Unit;
import com.auca.Model.EAcademicUnit;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AcademicUnitView {
    public static void main(String[] args) throws ParseException {
        boolean condition = true;
        String Input;
        UUID academic_id;
        UUID parent_id;
        String academic_code;
        String academic_name;
        int type;
        int result;
        String semeid;
        Academic_Unit Acu  = new Academic_Unit();
        AcademicUnitImpl impl = new AcademicUnitImpl();
        while (condition) {
            System.out.println("=========================");
            System.out.println(" Academic Registration System");
            System.out.println("---------------------------");
            System.out.println("1.Register Academy");
            System.out.println("2.Update Academy Registration");
            System.out.println("3.Delete Academy Registration");
            System.out.println("4.View Academy Registration");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.print("Choose: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter academic_code: ");
                    academic_code = input.next();
                    System.out.print("Enter Academic name: ");
                    academic_name = input.next();
                    System.out.print("1 For Program, 2 for Faculty, 3 for Department");
                    System.out.print("Enter Type:");
                    type = Integer.parseInt(input.next());

                    if (academic_code.trim().isEmpty() || academic_name.trim().isEmpty()) {
                        System.out.println("All fields are required ");
                    } else {
                        Acu.setAcademic_name(academic_name);
                        Acu.setAcademic_code(academic_code);

                        if(type == 1){
                            Acu.setType(EAcademicUnit.PROGRAM);
                            try {
                                result = impl.saveAcademicUnit(Acu);
                                if (result > 0) {
                                    System.out.println("Registration saved Successfully");
                                } else {
                                    System.out.println("Registration Not saved");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }else if(type == 2){
                            Acu.setType(EAcademicUnit.FACULTY);
                            try {
                                result = impl.saveAcademicUnit(Acu);
                                if (result > 0) {
                                    System.out.println("Registration saved Successfully");
                                } else {
                                    System.out.println("Registration Not saved");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }else if(type == 3){
                            Acu.setType(EAcademicUnit.DEPARTMENT);
                                System.out.print("Enter Parent ID: ");
                               Input = input.next();
                               Academic_Unit parentUnit = null;
                                parent_id = UUID.fromString(Input);
                                parentUnit = new Academic_Unit(parent_id);
                                Acu.setParent(parentUnit);
                            try {
                                result = impl.saveAcademicUnit(Acu);
                                if (result > 0) {
                                    System.out.println("Registration saved Successfully");
                                } else {
                                    System.out.println("Registration Not saved");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }else {
                            System.out.println("Invalid Type");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter academic_id: ");
                    Input = input.next();
                    academic_id = UUID.fromString(Input);
                    System.out.print("Enter academic_code: ");
                    academic_code = input.next();
                    System.out.print("Enter Academic name: ");
                    academic_name = input.next();
                    System.out.print("Enter Type: ");
                    type = Integer.parseInt(input.next());

                    if (academic_code.trim().isEmpty() || academic_name.trim().isEmpty()) {
                        System.out.println("All fields are required ");
                    } else {
                        Acu.setAcademic_id(academic_id);
                        Acu.setAcademic_name(academic_name);
                        Acu.setAcademic_code(academic_code);

                        if(type == 1){
                            Acu.setType(EAcademicUnit.PROGRAM);
                            try {
                                result = impl.updateAcademicUnit(Acu);
                                if (result > 0) {
                                    System.out.println("Academic saved Successfully");
                                } else {
                                    System.out.println("Academic Not saved");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }else if(type == 2){
                            Acu.setType(EAcademicUnit.FACULTY);
                            try {
                                result = impl.updateAcademicUnit(Acu);
                                if (result > 0) {
                                    System.out.println("Academic Updated Successfully");
                                } else {
                                    System.out.println("Academic Not Updated");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }else if(type == 3){
                            Acu.setType(EAcademicUnit.DEPARTMENT);
                            System.out.print("Enter Parent ID: ");
                            String parentIdInput = input.next();
                            UUID parent_Id = UUID.fromString(parentIdInput);
                            Academic_Unit Unit = new Academic_Unit(parent_Id);
                            Acu.setParent(Unit);
                            try {
                                result = impl.updateAcademicUnit(Acu);
                                if (result > 0) {
                                    System.out.println("Academic Updated Successfully");
                                } else {
                                    System.out.println("Academic Not Updated");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }else {
                            System.out.println("Invalid Type");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter academic_id: ");
                    Input = input.next();
                    academic_id = UUID.fromString(Input);;
                    Acu.setAcademic_id(academic_id);
                    try {
                        result = impl.deleteAcademicUnit(Acu);
                        if (result > 0) {
                            System.out.println("Academic Deleted Successfully");
                        } else {
                            System.out.println("Academic Not Deleted");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    break;
                case 4:
                    try {
                        System.out.println("The List of All Academic Units");
                        List<Academic_Unit> academicUnits = impl.displayAcademicUnit();
                        if (academicUnits == null) {
                            System.out.println("No Academic Found");
                        } else {
                            for (Academic_Unit units : academicUnits) {

                                System.out.println("Academic ID: " + units.getAcademic_id());
                                System.out.println("Academic Code: " + units.getAcademic_code());
                                System.out.println("Academic Name: " + units.getAcademic_name());
                                System.out.println("Type : " + units.getType());
                                System.out.println("Parent : " + units.getParent());
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

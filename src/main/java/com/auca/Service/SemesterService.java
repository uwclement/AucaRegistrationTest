package com.auca.Service;

import com.auca.Model.Semester;

import java.util.List;

public interface SemesterService {
    int saveSemester(Semester sem) throws Exception;
    int updateSemester(Semester sem) throws Exception;
    int deleteSemester(Semester sem) throws Exception;

    List<Semester> displaySemester () throws Exception;
}

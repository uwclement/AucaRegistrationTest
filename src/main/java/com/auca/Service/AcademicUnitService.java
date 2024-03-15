package com.auca.Service;

import com.auca.Model.Academic_Unit;

import java.util.List;

public interface AcademicUnitService {
    int saveAcademicUnit (Academic_Unit au) throws Exception;
    int updateAcademicUnit (Academic_Unit au) throws Exception;
    int deleteAcademicUnit (Academic_Unit au) throws Exception;
    List<Academic_Unit> displayAcademicUnit() throws Exception;
}

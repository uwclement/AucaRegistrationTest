package com.auca.Implementation;

import com.auca.Dao.Academic_UnitDao;
import com.auca.Model.Academic_Unit;
import com.auca.Service.AcademicUnitService;

import java.util.List;

public class AcademicUnitImpl implements AcademicUnitService {
    public AcademicUnitImpl() {
    }
     Academic_UnitDao dao = new Academic_UnitDao();
    @Override
    public int saveAcademicUnit(Academic_Unit au) throws Exception {
        return dao.saveAcademicUnit(au);
    }

    @Override
    public int updateAcademicUnit(Academic_Unit au) throws Exception {
        return dao.updateAcademicUnit(au);
    }

    @Override
    public int deleteAcademicUnit(Academic_Unit au) throws Exception {
        return dao.deleteAcademicUnit(au);
    }

    @Override
    public List<Academic_Unit> displayAcademicUnit() throws Exception {
        return dao.displayAcademicUnit();
    }
}

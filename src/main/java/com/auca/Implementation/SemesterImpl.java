package com.auca.Implementation;

import com.auca.Dao.SemesterDao;
import com.auca.Model.Semester;
import com.auca.Service.SemesterService;

import java.util.List;

public class SemesterImpl implements SemesterService {
    public SemesterImpl() {
    }
    SemesterDao dao = new SemesterDao();
    @Override
    public int saveSemester(Semester sem) throws Exception {
        return dao.saveSemester(sem);
    }

    @Override
    public int updateSemester(Semester sem) throws Exception {
        return dao.updateSemester(sem);
    }

    @Override
    public int deleteSemester(Semester sem) throws Exception {
        return dao.deleteSemester(sem);
    }

    @Override
    public List<Semester> displaySemester() throws Exception {
        return dao.displaySemester();
    }
}

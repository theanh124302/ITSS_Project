package project.itss.group11.itss.repository;

import project.itss.group11.itss.model.LogInfor;

import java.util.List;

public interface LogInforRepository {
    List<LogInfor> getLogInforByDay(int day,int Month,int Year,int employee_id);
    List<LogInfor> getLogInforByMonth(int month,int Year,int employee_id);
}

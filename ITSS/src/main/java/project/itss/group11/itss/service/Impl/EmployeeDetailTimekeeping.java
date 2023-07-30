package project.itss.group11.itss.service.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.LogInfor;
import project.itss.group11.itss.model.TimekeepingDetail;
import project.itss.group11.itss.model.TimekeepingOverview;
import project.itss.group11.itss.repository.Impl.LogInforRepositoryImpl;
import project.itss.group11.itss.repository.LogInforRepository;
import project.itss.group11.itss.service.IEmployeeDetailTimekeeping;
import project.itss.group11.itss.service.IEmployeeTimekeepingOverview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailTimekeeping implements IEmployeeDetailTimekeeping {
    IEmployeeTimekeepingOverview employeeTimekeepingOverview = new EmployeeTimekeepingOverviewImpl();
    LogInforRepository logInforRepository = new LogInforRepositoryImpl();

    @Override
    public String getReturnEarlyTime(LocalDateTime returningTime, LocalDateTime endTime) {
        boolean isReturningEarly = returningTime.getHour()*3600 + returningTime.getMinute()*60 + returningTime.getSecond()
                < endTime.getHour()*3600 + endTime.getMinute()*60 + endTime.getSecond();
        if(isReturningEarly) {
            int total = endTime.getHour() * 3600 + endTime.getMinute() * 60  - returningTime.getHour() * 3600 + returningTime.getMinute() * 60;
            return (int)total/3600 + ":" + (total- 3600*(int)total/3600)/60;
        }
        else
            return "No";
    }

    @Override
    public String getComeLateTime(LocalDateTime comingTime, LocalDateTime startTime) {
        boolean isComeLate = comingTime.getHour()*3600 + comingTime.getMinute()*60 + comingTime.getSecond()
                > startTime.getHour()*3600 + startTime.getMinute()*60 + startTime.getSecond();
        if(isComeLate)
        {
            int total = comingTime.getHour() * 3600 + comingTime.getMinute() * 60 - comingTime.getHour() * 3600 + comingTime.getMinute() * 60;
            return (int)total/3600 + ":" + (total- 3600*(int)total/3600)/60;
        }
        else
            return "No";
    }

    @Override
    public ObservableList<TimekeepingDetail> getDetailTimekeepingByDay(LocalDate time, LocalDateTime start, LocalDateTime end) {
        ObservableList<TimekeepingDetail> timekeepingDetails = FXCollections.observableArrayList();
        List<LogInfor> logInfors = new ArrayList<>();
        LocalDateTime current_time = LocalDateTime.now();
        LocalDateTime date1,date2;

        int day = time.getDayOfMonth();
        int month = time.getMonth().getValue();
        int year = time.getYear();
        logInfors = logInforRepository.getLogInforByDay(day,month,year, Constant.employee.getID());
        if(logInfors.size()>=1){
            date1 = logInfors.get(0).getTimeStamp();
            TimekeepingDetail t1 = new TimekeepingDetail();
            t1.setTime(employeeTimekeepingOverview.getStartTime(date1));
            t1.setComeLate(getComeLateTime(date1,start));
            t1.setReturnEarly("-");
            int machine = logInfors.get(0).getDevice();
            t1.setMachine(machine);
            if(machine==1)
                t1.setType("Check in");
            else
                t1.setType("Check out");
            timekeepingDetails.add(t1);
        }
        System.out.println(logInfors.size());
        if(logInfors.size()>=2){
            date2 = logInfors.get(1).getTimeStamp();
            TimekeepingDetail t2 = new TimekeepingDetail();
            t2.setTime(employeeTimekeepingOverview.getStartTime(date2));
            t2.setReturnEarly(getReturnEarlyTime(date2,end));
            t2.setComeLate("-");
            int machine = logInfors.get(1).getDevice();
            t2.setMachine(machine);
            if(machine==1)
                t2.setType("Check in");
            else
                t2.setType("Check out");
            timekeepingDetails.add(t2);
        }
        return timekeepingDetails;
    }
}

package project.itss.group11.itss.repository.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.Employee;
import project.itss.group11.itss.repository.EmployeeInforRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EmployeeInforRepositoryImpl implements EmployeeInforRepository {

    private static final Logger logger = LogManager.getLogger(EmployeeInforRepositoryImpl.class);
    private static final String getEmployeeInforQuery = "select * from employee where id = ?";
    @Override
    public List<Employee> getEmployeeInfor(String query) {
        return null;
    }

    @Override
    public Employee getInforUser(int id) {
        Employee employee = new Employee(id);
        try{
            Connection connection = Constant.pool.getConnection();
            PreparedStatement stmt = connection.prepareStatement(getEmployeeInforQuery);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                employee.setName(rs.getString(2));
                employee.setBirthDate( rs.getDate(3).toLocalDate());
                employee.setUnit(rs.getInt(4));
                employee.setRole(rs.getInt(5));
                employee.setGender(rs.getInt(6));
            }
            rs.close();
            stmt.close();
            Constant.pool.releaseConnection(connection);
        }catch (SQLException ex) {
            logger.error("getInforUser id: " + id + " error", ex);
            throw new RuntimeException(ex);
        }
        return employee;
    }

}

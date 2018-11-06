package com.move.spring.wed.springbootwed.mapper;

import com.move.spring.wed.springbootwed.bean.Employee;
import com.move.spring.wed.springbootwed.bean.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    long countByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    int deleteByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Fri Nov 02 09:34:02 CST 2018
     */
    int updateByPrimaryKey(Employee record);
}
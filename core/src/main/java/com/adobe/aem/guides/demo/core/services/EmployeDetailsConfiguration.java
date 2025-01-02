package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="EmployeDetailsConfiguration",description = "EmployeDetails")
public @interface EmployeDetailsConfiguration {

  @AttributeDefinition(name="EmployeeName",
           description="about EmployeeName",
           type = AttributeType.STRING)
  public String employeeName();
  
  @AttributeDefinition(name="EmployeeId",
          description="about EmployeeId",
           type = AttributeType.INTEGER)
  public int employeeId();
  
  @AttributeDefinition(name="EmployeeSecret",
  description="about EmployeeName",
           type = AttributeType.STRING)
  public String employeeSecret();
 
  @AttributeDefinition(name="EmployeeSalary",
  description="about EmployeeSalary",
           type = AttributeType.DOUBLE)
  public double employeeSalary();
  
  @AttributeDefinition(name="EmployeeDepartment",
  description="about EmployeeDepartment",
           type = AttributeType.STRING)
  public String employeeDepartment();

  @AttributeDefinition(name="EmployeeRestAPI",
           description="about EmployeeRestAPI",
           type = AttributeType.STRING)
  public String employeeRestAPI();

}

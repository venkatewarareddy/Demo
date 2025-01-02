package com.adobe.aem.guides.demo.core.services;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(service= EmployeeService.class,enabled = true,immediate = true)
@Designate(ocd=EmployeDetailsConfiguration.class)
public class EmployeeService {

  private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
     private String EmployeeName;
     private int EmployeeId;
     private String EmployeeSecret;
     private double EmployeeSalary;
     private String EmployeeDepartment;
     private String EmployeeRestAPI;

  @Activate
  public void active(EmployeDetailsConfiguration edetailsConfiguration){
     log.info("EmployeeService class Active() excuted");
     upadateAll(edetailsConfiguration);
  }
  @Deactivate
  public void deactive(EmployeDetailsConfiguration edetailsConfiguration){
  log.info("EmployeeService class Deactivate()excuted");
  upadateAll(edetailsConfiguration);
  }
  @Modified
  public void update(EmployeDetailsConfiguration edetailsConfiguration){
  log.info("EmployeeService class update() excuted");
  upadateAll(edetailsConfiguration);
  }

  public void upadateAll(EmployeDetailsConfiguration edetailsConfiguration){
             this.EmployeeName = edetailsConfiguration.employeeName();
             this.EmployeeId = edetailsConfiguration.employeeId();
             this.EmployeeSecret = edetailsConfiguration.employeeSecret();
             this.EmployeeSalary = edetailsConfiguration.employeeSalary();
             this.EmployeeDepartment = edetailsConfiguration.employeeDepartment();
             this.EmployeeRestAPI = edetailsConfiguration.employeeRestAPI();
             log.info("EmployeeName={},EmployeeId={},EmployeeSecret={},EmployeeSalary={},EmployeeDepartment={},EmployeeRestAPI={}" + EmployeeName,EmployeeId,EmployeeSecret,EmployeeSalary,EmployeeDepartment,EmployeeRestAPI);
  }
}

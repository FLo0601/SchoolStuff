package org.hase;


import org.hase.model.Employee;

public class HaseGmbHManagement {

    private Authentication authentication;
    private final EmployeeMgmt employeeMgmt;

    public HaseGmbHManagement() {
        authentication = Authentication.getInstance();
        this.employeeMgmt = new EmployeeMgmt();
    }

    public EmployeeMgmt getEmployeeMgmt(String username, String password) {
        if (authentication.authenticate(username, password))
            return employeeMgmt;
        return null;
    }

    public boolean addNewEmployee(Employee anEmployee, String username, String pwd) {
        if (employeeMgmt.add(anEmployee))
            if (authentication.addAccount(username, pwd, anEmployee.getEmail()))
                return true;
        return false;
    }

    public boolean updatePassword(String username, String password, String newPassword){
        return authentication.changePassword(username, password, newPassword);
    }

    public boolean recoverPassword(String username){
        return authentication.resetPassword(username);
    }


}

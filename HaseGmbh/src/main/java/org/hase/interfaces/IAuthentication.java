package org.hase.interfaces;

public interface IAuthentication {
    public boolean addAccount(String username, String password, String email);
    public boolean authenticate(String username, String password);
    public boolean changePassword(String username, String password, String newPassword);
    public boolean resetPassword(String username);
}

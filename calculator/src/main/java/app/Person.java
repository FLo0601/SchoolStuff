package app;

public class Person {
    
    public Person() {};

    private String _name;
    private String _email;
    private String _password;

    public String get_name() {
        return _name;
    }
    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }
    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }
    public void set_password(String _password) {
        this._password = _password;
    }

    public boolean checkEmail(String email) {
        return false;
    }

    public boolean checkPassword(String pwd) {
        return false;
    }

    // [a-z]([A-Z]|[a-z]|[._-]|[0-9])+[@][a-z]([A-Z]|[a-z]|[._-]|[0-9])[a-z]+[.][a-z]+
}

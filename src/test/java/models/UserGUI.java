package models;

public class UserGUI {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public static class Builder {
        private UserGUI newUserGUI;

        public Builder() {
            newUserGUI = new UserGUI();
        }

        public Builder withEmail(String value) {
            newUserGUI.email = value;

            return this;
        }

        public Builder withPassword(String value) {
            newUserGUI.password = value;

            return this;
        }

        public Builder withFirstname(String value) {
            newUserGUI.firstname = value;

            return this;
        }

        public Builder withLastname(String value) {
            newUserGUI.lastname = value;

            return this;
        }

        public UserGUI build() {
            return newUserGUI;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

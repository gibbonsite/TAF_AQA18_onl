package models;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder withEmail(String value) {
            newUser.email = value;

            return this;
        }

        public Builder withPassword(String value) {
            newUser.password = value;

            return this;
        }

        public Builder withFirstname(String value) {
            newUser.firstname = value;

            return this;
        }

        public Builder withLastname(String value) {
            newUser.lastname = value;

            return this;
        }

        public User build() {
            return newUser;
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

package pojos;

public class User {
   private int id;
   private String login;
   private String firstName;
   private String lastName;
   private String email;
   private boolean activated;
   private String langKey;
   private Object imageUrl;
   private Object resetDate;

    public User() {
    }

    public User(int id, String login, String firstName, String lastName, String email, boolean activated, String langKey, Object imageUrl, Object resetDate) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.langKey = langKey;
        this.imageUrl = imageUrl;
        this.resetDate = resetDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activated=" + activated +
                ", langKey='" + langKey + '\'' +
                ", imageUrl=" + imageUrl +
                ", resetDate=" + resetDate +
                '}';
    }
}

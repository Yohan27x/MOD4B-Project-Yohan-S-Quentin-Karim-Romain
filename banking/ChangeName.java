package banking;


public class ChangeName {
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return this.userName;
    }
}

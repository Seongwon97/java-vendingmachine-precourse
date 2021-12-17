package vendingmachine.repository;

public class UserChangeRepository {
    private static UserChangeRepository instance = new UserChangeRepository();
    private static int change = 0;

    private UserChangeRepository() {

    }

    public static UserChangeRepository getInstance() {
        return instance;
    }

    public void initChange(int change) {
        if (this.change == 0) {
            this.change = change;
        }
    }

    public int getChange() {
        return change;
    }

}

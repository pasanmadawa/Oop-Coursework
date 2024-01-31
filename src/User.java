
public class User{
    private String username;
    private String password;



    public User(String username, String password){

        this.username = username;
        this.password = password;

    }

    public void setUsername(String username1){
        this.username = username1;
    }

    public void setPassword(String password1){
        this.password = password1;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toString(){
        return getUsername() +","+getPassword();
    }
}


package banking;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        ChangeName name = new ChangeName();
        name.setUserName(user);
        System.out.println(name);
        
    }
}

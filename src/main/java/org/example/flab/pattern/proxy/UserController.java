package org.example.flab.pattern.proxy;

public class UserController implements IUserController {

    public void login(String username, String password) {
        System.out.println("UserController.login");
    }

    public void register(String username, String password) {
        System.out.println("UserController.register");
    }
}

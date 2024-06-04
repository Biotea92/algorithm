package org.example.flab.pattern;

import org.example.flab.pattern.proxy.IUserController;
import org.example.flab.pattern.proxy.MetricsCollectorProxy;
import org.example.flab.pattern.proxy.UserController;

public class Test {

    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        userController.login("telephone", "password");
    }
}

package com.roytuts.java.junit.mockito.verify;

public class UserService {

    public void saveUser(String userId) {
        System.out.println("Saving user [" + userId + "] info...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("User [" + userId + "] info saved");
    }
}

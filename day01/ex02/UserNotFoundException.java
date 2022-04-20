package ex02;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(int id)
    {
        System.out.println("User " + id + "not found:(");
    }
}

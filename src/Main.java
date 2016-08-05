import MVC.environment.Application;
import MVC.environment.Database;

/**
 *  MAIN CLASS
 *
 *  initiates at the moment only the function to fill
 *  the database with values for testing purposes
 */
public class Main {
    public static void main(String [] args){
        Database.create_test_data();

        // COPY ME TO UNIT TESTS
        Application.test(false);
    }
}

package MVC.environment;

import MVC.controllers.FileTypesController;
import MVC.controllers.MusicFilesController;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static boolean test(boolean _silent){
        test_relations(_silent);
        test_controllers(_silent);
        test_encryption(_silent);
        return true;
    }

    public static boolean test_relations(boolean _silent){

        return true;
    }

    public static boolean test_controllers(boolean _silent){
        test_file_types_controller(_silent);
        return true;
    }

    private static boolean test_file_types_controller(boolean _silent) {
        boolean result;
        result = FileTypesController.create(1, "foo");
        if(!result){
            System.out.println("everything okay");
            result = FileTypesController.create(0, "foo");
            if(result){
                System.out.println("everything okay");
                result = FileTypesController.delete(0, 0);
                if(result){
                    System.out.println("everything okay");
                    return true;
                } else {
                    System.out.println("something went wrong");
                }
            } else {
                System.out.println("something went wrong");
            }

        } else {
            System.out.println("something went wrong");
        }
        return false;
    }

    private static boolean test_music_files_controller(boolean _silent) {
        boolean result;
        return false;
    }

    public static boolean test_encryption(boolean _silent){


        return true;
    }
}

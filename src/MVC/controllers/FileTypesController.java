package MVC.controllers;

import MVC.models.FileType;
import MVC.models.User;

public class FileTypesController {
    public static boolean create(int _user_id, String _title){
        User user = User.find(_user_id);
        if(user.has_role("admin")){
            FileType file_type = new FileType(_title);
            if(file_type != null){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean delete(int _id, int _user_id){
        User user = User.find(_user_id);
        FileType type = FileType.find(_id);
        if(type != null){
            if(user.has_role("admin")) {
                type.delete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

package MVC.controllers;

import MVC.models.FileType;

public class FileTypesController {
    public boolean create(String _title){
        FileType file_type = new FileType(_title);
        if(file_type != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int _id){
        FileType type = FileType.find(_id);
        if(type != null){
            type.delete();
            return true;
        } else {
            return false;
        }
    }
}

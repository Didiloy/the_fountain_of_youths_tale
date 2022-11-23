package character;

import common.enums.Speciality;

public class NPCharacter {
    private String _name;
    private Speciality _speciality;
     public NPCharacter(String name, Speciality s){
         this._name = name;
         this._speciality = s;
     }

    public Speciality getSpeciality() {
        return _speciality;
    }

    public String getName() {
        return _name;
    }
}

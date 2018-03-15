package by.it.akhmelev.jd02_06.matlab_classwork;

public class VarCreator {

    private static VarCreator instance;

    private VarCreator() {
    }

    static VarCreator getInstance(){
        if (instance==null){
           instance=new VarCreator();
        }
        return  instance;
    }

    Var createVar(String part) {
        Var res;
        if (part.matches(Patterns.exMat)) {
            res = new VarM(part);
        } else if (part.matches(Patterns.exVec)) {
            res = new VarV(part);
        } else if (part.matches(Patterns.exVal)) {
            res = new VarF(part);
        } else
            res = Var.vars.get(part);
        return res;
    }

}

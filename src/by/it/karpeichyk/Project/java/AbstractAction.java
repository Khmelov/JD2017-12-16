package by.it.karpeichyk.Project.java;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 05.03.2018.
 */
abstract class AbstractAction {
    abstract  AbstractAction execute(HttpServletRequest req ) throws  Exception;
   public String getJsp (){return "/"+this.toString().toLowerCase()+".jsp";}

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replaceFirst("Command","");}

    }


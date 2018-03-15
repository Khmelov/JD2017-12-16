package by.it.akhmelev.jd02_06.matlab_classwork;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IOperation, IVariable {

    static public Map<String,Var> vars=new HashMap<String,Var>(){
        @Override
        //представим карту в нужном String-формате в анонимном классе
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Entry pair : vars.entrySet()) {
                sb.append(
                        String.format("%s=%s\n",
                                pair.getKey(),
                                pair.getValue())
                );
            }
            return sb.toString();
        }
    };

    @Override
    public Var add(Var var) throws MathExcepton {
        throw new MathExcepton("Операция сложения невозможна");
    }

    @Override
    public Var sub(Var var) throws MathExcepton {
        throw new MathExcepton("Операция вычитания невозможна");
    }

    @Override
    public Var mul(Var var) throws MathExcepton {
        throw new MathExcepton("Операция умножения невозможна");
    }

    @Override
    public Var div(Var var) throws MathExcepton {
        throw new MathExcepton("Операция деления невозможна");
    }

    @Override
    public void save(String name) {
        vars.put(name,this);
    }

}

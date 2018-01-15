package by.it.patsko.calc;


interface Operation {
    Var add(Var other);

    Var sub(Var other);

    Var mul(Var other);

    Var div(Var other);

    Var assign(Var other);
}

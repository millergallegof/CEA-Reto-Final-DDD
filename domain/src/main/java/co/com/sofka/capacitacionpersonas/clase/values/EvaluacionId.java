package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.Identity;

public class EvaluacionId extends Identity {
    public EvaluacionId(String value) {
        super(value);
    }

    public EvaluacionId() {
    }

    public static EvaluacionId of(String value) {
        return new EvaluacionId(value);
    }
}

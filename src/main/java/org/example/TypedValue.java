package org.example;

import java.math.BigDecimal;

public class TypedValue {
    public enum Kind { INT, BOOL, DECIMAL, STRING }

    public final Kind kind;
    public final Integer intVal;
    public final Boolean boolVal;
    public final BigDecimal decVal;
    public final String strVal;

    public TypedValue(Integer v) {
        this.kind = Kind.INT;
        this.intVal = v;
        this.boolVal = null;
        this.decVal = null;
        this.strVal = null;
    }

    public TypedValue(Boolean v) {
        this.kind = Kind.BOOL;
        this.intVal = null;
        this.boolVal = v;
        this.decVal = null;
        this.strVal = null;
    }

    public TypedValue(BigDecimal v) {
        this.kind = Kind.DECIMAL;
        this.intVal = null;
        this.boolVal = null;
        this.decVal = v;
        this.strVal = null;
    }

    public TypedValue(String v) {
        this.kind = Kind.STRING;
        this.intVal = null;
        this.boolVal = null;
        this.decVal = null;
        this.strVal = v;
    }

    @Override
    public String toString() {
        switch (kind) {
            case INT: return intVal.toString();
            case BOOL: return boolVal.toString();
            case DECIMAL: return decVal.toPlainString();
            case STRING: return strVal;
            default: return "null";
        }
    }

    public BigDecimal asBigDecimal() {
        switch (kind) {
            case INT: return new BigDecimal(intVal);
            case DECIMAL: return decVal;
            default: throw new RuntimeException("Não é um valor numérico: " + this);
        }
    }

    public boolean isNumeric() {
        return kind == Kind.INT || kind == Kind.DECIMAL;
    }
}
package org.launchcode.techjobs.oo;
import java.util.Objects;
public class JobField {
    private int id;
    private int nextId = 1;
    private String value;

public JobField() {
    id = nextId;
    nextId++;

}

public JobField(String value) {
    this();
    this.value = value;
}

public String toString() {
    return value;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id && nextId == jobField.nextId && Objects.equals(value, jobField.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nextId, value);
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}




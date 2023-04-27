package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private int id;
    private String name;
    private Object states;

    public Country() {
    }

    public Country(int i, String usa, Object o) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getStates() {
        return states;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", states=" + states +
                '}';
    }

    public void setStates(Object states) {
        this.states = states;
    }
}

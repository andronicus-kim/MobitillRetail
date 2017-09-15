package ke.co.dataintegrated.mobitillretail.data;

/**
 * Created by andronicus on 9/13/2017.
 */

public class Menu {
    private Integer id;
    private String name;

    public Menu(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "No."+getId() + " "+name;
    }
}

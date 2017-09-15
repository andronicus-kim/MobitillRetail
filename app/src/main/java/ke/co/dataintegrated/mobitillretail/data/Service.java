package ke.co.dataintegrated.mobitillretail.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andronicus on 9/13/2017.
 */

public class Service {

    private static final Map<Integer,Menu> SERVICE_DATA;
    private static Service INSTANCE = null;

    static {
        SERVICE_DATA = new LinkedHashMap<>();
        addService(1,"Make sale");
        addService(2,"Tuzo milk");
        addService(3,"Client name");
        addService(4,"Buy more than one");
        addService(5,"Buy more than one");
        addService(6,"Buy more than one");
        addService(7,"Buy more than one");
        addService(8,"Buy more than one");
        addService(78,"Buy more than one");
        addService(34,"Buy more than one");
        addService(65,"Buy more than one");
        addService(92,"Buy more than one");
        addService(90,"Buy more than one");
        addService(746,"Buy more than one");
        addService(246,"Buy more than one");
        addService(784,"Buy more than one");
        addService(827,"Buy more than one");
        addService(26554,"Buy more than one");
        addService(14524,"Buy more than one");
        addService(236,"Buy more than one");
    }

    private Service(){}

    public static Service getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Service();
        }
        return INSTANCE;
    }

    private static void addService(Integer id, String name){
        Menu menu = new Menu(id,name);
        menu.toString();
        SERVICE_DATA.put(menu.getId(),menu);
    }

    public static List<Menu> getMenuItems() {
        if (!SERVICE_DATA.isEmpty()) {
            return new ArrayList<>(SERVICE_DATA.values());
        }
        return null;
    }
}

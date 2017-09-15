package ke.co.dataintegrated.mobitillretail.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andronicus on 9/14/2017.
 */

public class Repository {
    List<Servicemenus> services = new ArrayList<>();

    public Repository() {
    }
    public List<Servicemenus> getServices(){
        Servicemenus menuMerchant = new Servicemenus();
        menuMerchant.setServicemenuId((long) 694);
        menuMerchant.setParent((long) 0);
        menuMerchant.setChild((long) 1);
        menuMerchant.setLabel("Merchant Services");
        menuMerchant.setLType((long) 1);
        services.add(menuMerchant);

        Servicemenus makeSale = new Servicemenus();
        makeSale.setServicemenuId((long) 695);
        makeSale.setParent((long) 1);
        makeSale.setChild((long) 2);
        makeSale.setLabel("Make Sale");
        makeSale.setLType((long) 3);
        makeSale.setQtLabel("Enter Amount");
        services.add(makeSale);

        Servicemenus tuzoMilk = new Servicemenus();
        tuzoMilk.setServicemenuId((long) 696);
        tuzoMilk.setParent((long) 1);
        tuzoMilk.setChild((long) 3);
        tuzoMilk.setLabel("Tuzo Milk");
        tuzoMilk.setLType((long) 2);
        tuzoMilk.setDataType((long) 1);
        tuzoMilk.setQtLabel("Enter Amount");
        tuzoMilk.setDefaultValue("55.00");
        services.add(tuzoMilk);

        Servicemenus clientName = new Servicemenus();
        clientName.setServicemenuId((long) 697);
        clientName.setParent((long) 1);
        clientName.setChild((long) 4);
        clientName.setLabel("Client Name");
        clientName.setLType((long) 3);
        clientName.setDataType((long) 3);
        clientName.setQtLabel("Enter Client Name");
        services.add(clientName);

        Servicemenus buyMoreThanOne = new Servicemenus();
        buyMoreThanOne.setServicemenuId((long) 698);
        buyMoreThanOne.setParent((long) 1);
        buyMoreThanOne.setChild((long) 5);
        buyMoreThanOne.setLabel("Buy more than one");
        buyMoreThanOne.setLType((long) 5);
        buyMoreThanOne.setDataType((long) 0);
        services.add(buyMoreThanOne);

        Servicemenus bread = new Servicemenus();
        bread.setServicemenuId((long) 699);
        bread.setParent((long) 5);
        bread.setChild((long) 6);
        bread.setLabel("Bread 400g");
        bread.setLType((long) 2);
        bread.setDataType((long) 1);
        bread.setDefaultValue("50.00");
        services.add(bread);

        Servicemenus sugar = new Servicemenus();
        sugar.setServicemenuId((long) 700);
        sugar.setParent((long) 5);
        sugar.setChild((long) 7);
        sugar.setLabel("Sugar");
        sugar.setLType((long) 3);
        sugar.setDataType((long) 2);
        sugar.setQtLabel("Enter Price");
        services.add(sugar);

        Servicemenus meat = new Servicemenus();
        meat.setServicemenuId((long) 701);
        meat.setParent((long) 5);
        meat.setChild((long) 8);
        meat.setLabel("Meat 1kg");
        meat.setLType((long) 4);
        meat.setDataType((long) 2);
        meat.setQtLabel("Enter Quantity");
        meat.setDefaultValue("500.00");
        services.add(meat);

        return services;
    }
}

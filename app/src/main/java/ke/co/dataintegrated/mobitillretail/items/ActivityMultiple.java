package ke.co.dataintegrated.mobitillretail.items;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import ke.co.dataintegrated.mobitillretail.SingleFragmentActivity;
import ke.co.dataintegrated.mobitillretail.data.Servicemenus;

/**
 * Created by andronicus on 9/14/2017.
 */

public class ActivityMultiple extends SingleFragmentActivity {

    private static final String SERVICE_MENUS = "SERVICE_MENUS";


    public static Intent newIntent(Context context, ArrayList<Servicemenus> servicemenus){
        Intent intent = new Intent(context,ActivityMultiple.class);
        intent.putExtra(SERVICE_MENUS,servicemenus);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        return ItemsFragment.newInstance(getIntent().getParcelableArrayListExtra(SERVICE_MENUS));
    }
}

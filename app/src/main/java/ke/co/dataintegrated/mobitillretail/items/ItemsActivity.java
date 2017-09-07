package ke.co.dataintegrated.mobitillretail.items;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.List;

import ke.co.dataintegrated.mobitillretail.SingleFragmentActivity;
import ke.co.dataintegrated.mobitillretail.data.Item;

public class ItemsActivity extends SingleFragmentActivity implements ItemsFragment.CommnicationHandler{

    private static final String TAG = "ItemsActivity";

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,ItemsActivity.class);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        return ItemsFragment.newInstance();
    }

    @Override
    public void sendItems(List<Item> items) {
        SingleFragmentActivity.setSelectedItems(items);
    }
}

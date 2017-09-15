package ke.co.dataintegrated.mobitillretail.items;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import ke.co.dataintegrated.mobitillretail.SingleFragmentActivity;

public class ItemsActivity extends SingleFragmentActivity{

    private static final String TAG = "ItemsActivity";

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,ItemsActivity.class);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        return EmptyItemsFragment.newInstance();
    }
}

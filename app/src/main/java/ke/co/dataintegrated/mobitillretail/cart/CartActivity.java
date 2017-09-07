package ke.co.dataintegrated.mobitillretail.cart;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import ke.co.dataintegrated.mobitillretail.R;
import ke.co.dataintegrated.mobitillretail.SingleFragmentActivity;
import ke.co.dataintegrated.mobitillretail.payment.PayActivity;

public class CartActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,CartActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return CartFragment.newInstance(SingleFragmentActivity.getSelectedItems());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.done:
                startActivity(PayActivity.newIntent(CartActivity.this));
                break;
            default:
                break;
        }
        return true;
    }
}

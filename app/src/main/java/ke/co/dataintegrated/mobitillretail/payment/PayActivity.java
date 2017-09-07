package ke.co.dataintegrated.mobitillretail.payment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;

import ke.co.dataintegrated.mobitillretail.R;
import ke.co.dataintegrated.mobitillretail.SingleFragmentActivity;

public class PayActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        return new Intent(context,PayActivity.class);
    }
    @Override
    protected Fragment createFragment() {
        return PayFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pay_menu,menu);
        return true;
    }
}

package ke.co.dataintegrated.mobitillretail;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import ke.co.dataintegrated.mobitillretail.items.ItemsCategoryFragment;
import ke.co.dataintegrated.mobitillretail.items.ItemsFragment;
import ke.co.dataintegrated.mobitillretail.utils.ActivityUtils;

/**
 * Created by andronicus on 9/5/2017.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ItemsFragment mItemsFragment;
    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutRes(){
        return R.layout.activity_fragment;
    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(getLayoutRes());

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            toolbar.setTitle(getResources().getString(R.string.app_name));

            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (fragment == null){
                fragment = createFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment)
                        .commit();
            }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.inflateMenu(R.menu.merchant_menu);
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.items, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            //noinspection SimplifiableIfStatement
            if (id == R.id.search) {
                return true;
            }if (id == R.id.done){
//                if (mItemsFragment == null){
//                    mItemsFragment = ItemsFragment.newInstance();
//                }
//                ArrayList<Servicemenus> selectedItems = mItemsFragment.getSelectedItems();
//                if (!selectedItems.isEmpty()) {
//                    startActivity(CartActivity.newIntent(SingleFragmentActivity.this,selectedItems));
//                }
//                else {
//                    return true;
//                }
            }
            return super.onOptionsItemSelected(item);
        }
        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.menu_merchant) {
                Fragment fragment = ItemsCategoryFragment.newInstance();
                ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        R.id.fragment_container,
                        fragment);
//                mItemsFragment = ItemsFragment.newInstance();
//                ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),R.id.fragment_container, mItemsFragment);

            } else if (id == R.id.menu_category) {

            } else if (id == R.id.nav_slideshow) {

            } else if (id == R.id.nav_manage) {

            } else if (id == R.id.nav_share) {

            } else if (id == R.id.nav_send) {

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
}
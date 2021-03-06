package name.jacklewis.reactivehealth;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.jakewharton.rxbinding2.support.design.widget.RxNavigationView;
import com.jakewharton.rxbinding2.view.RxView;

public class MainActivity extends AppCompatActivity {

    final private static String TAG = "MainActivity";
    private FloatingActionButton fab;
    private DrawerLayout mDrawerLayout;
    NavigationView navigationView;



    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate() called.");

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        RxNavigationView.itemSelections(navigationView)
                .subscribe(menuItem -> {
                    Log.i(TAG, "Menu Item Clicked!");
                    if (menuItem.isChecked()) {
                        menuItem.setIcon(R.drawable.arrow_folded);
                        menuItem.setChecked(false);
                    } else {
                        menuItem.setIcon(R.drawable.arrow_unfolded);
                        menuItem.setChecked(true);
                    }

                });
        RxView.clicks(fab)
                .subscribe(clickEvent -> {
                    Log.i(TAG, "Starting Bluetooth Scan! ");

                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

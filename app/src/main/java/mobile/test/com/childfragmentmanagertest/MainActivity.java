package mobile.test.com.childfragmentmanagertest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager.enableDebugLogging(true);

        FragmentManager fm = getSupportFragmentManager();
        Fragment mainActivityFragment = fm.findFragmentByTag("parent_frag");
        Log.d(TAG, "Existing Parent fragment " + mainActivityFragment);
        if ( mainActivityFragment == null ) {
            FragmentTransaction ft = fm.beginTransaction();
            mainActivityFragment = new ParentFragment();
            ft.add(R.id.fragment_layout, mainActivityFragment, "parent_frag");
            ft.commit();
        }
    }
}

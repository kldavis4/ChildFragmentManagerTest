package mobile.test.com.childfragmentmanagertest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class ParentFragment extends Fragment {
    private final static String TAG = ParentFragment.class.getName();

    public ParentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fm = getChildFragmentManager();
        Log.d(TAG, "Existing fragments " + fm.getFragments() );
        Fragment childFragment = fm.findFragmentByTag("child_fragment");
        Log.d(TAG, "Existing child fragment " + childFragment);
        if ( childFragment == null ) {
            FragmentTransaction ft = fm.beginTransaction();
            childFragment = new ChildFragment();
            ft.add(R.id.fragment_child_layout, childFragment, "child_fragment");
            ft.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_parent, container, false);
    }
}

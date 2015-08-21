package mobile.test.com.childfragmentmanagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.atomic.AtomicInteger;

public class ChildFragment extends Fragment {
    private static final String TAG = ChildFragment.class.getName();
    private static AtomicInteger instanceCount = new AtomicInteger(0);

    public ChildFragment() {
        Log.d(TAG, "Child fragment instance count " + instanceCount.incrementAndGet());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_child, container, false);
    }
}

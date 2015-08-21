# ChildFragmentManagerTest
Test project which demonstrates issue with the fragment manager in a fragment.

The issue is that when the device is rotated, the fragment manager instance returned by getChildFragmentManager() in onCreate() is not the same as the fragment manager returned when the onCreate() was called originally. This causes getFragments() to return null and getFragmentByTag() to not find any fragments. This makes it unreliable for determing whether a new instance of a fragment should be created.

I did check the savedInstanceState and found that the FragmentState is present and I also enable debug logging in fragment manager and determined that *an* instance of fragment manager has references to my child fragment.

The solution (found here: http://stackoverflow.com/questions/27316086/findviewbyid-always-returns-null-in-fragment) is simple. Instead of calling getChildFragmentManager() from the onCreate method, do it in the onCreateView method. Apparently the fragment manager on the fragment hasn't been fully initialized until onCreateView.

The corrected version of the ParentFragmentManager is thus:

public class ParentFragment extends Fragment {
    private final static String TAG = ParentFragment.class.getName();

    public ParentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent, container, false);

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

        return view;
    }}

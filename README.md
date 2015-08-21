# ChildFragmentManagerTest
Test project which demonstrates issue with the fragment manager in a fragment.

The issue is that when the device is rotated, the fragment manager instance returned by getChildFragmentManager() in onCreate() is not the same as the fragment manager returned when the onCreate() was called originally. This causes getFragments() to return null and getFragmentByTag() to not find any fragments. This makes it unreliable for determing whether a new instance of a fragment should be created.

I did check the savedInstanceState and found that the FragmentState is present and I also enable debug logging in fragment manager and determined that *an* instance of fragment manager has references to my child fragment.

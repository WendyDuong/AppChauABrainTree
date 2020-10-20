package com.example.android.demoapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.demoapp.AppExecutors;
import com.example.android.demoapp.R;
import com.example.android.demoapp.ViewModel.YeuThichViewModel;
import com.example.android.demoapp.adapter.YeuthichAdapter;
import com.example.android.demoapp.database.AppDatabase;
import com.example.android.demoapp.database.YeuThichEntry;

import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class YeuThichFragment extends Fragment {

       /* implements
        LoaderManager.LoaderCallbacks<Cursor>, YeuthichAdapter.ListItemClickListener {
    RecyclerView recyclerViewYeuThich;
    YeuthichAdapter yeuThichAdapter;
    View emptyView;

    private static final String TAG2 = YeuThichFragment.class.getSimpleName();

    private static final int TASK_LOADER_ID = 1;
    public YeuThichFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.yeuthich_fragment, container, false);
        emptyView = rootView.findViewById(R.id.empty_view_yeu_thich);

        emptyView.setVisibility(View.INVISIBLE);

        recyclerViewYeuThich = rootView.findViewById(R.id.recycler_view_yeu_thich);
        recyclerViewYeuThich.setLayoutManager(new LinearLayoutManager(getActivity()));
        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerViewYeuThich);
        yeuThichAdapter = new YeuthichAdapter( this, getActivity());
        recyclerViewYeuThich.setAdapter(yeuThichAdapter);
        //recyclerViewYeuThich.addItemDecoration(new DividerItemDecoration(getActivity(),
          //      DividerItemDecoration.VERTICAL));

        getLoaderManager().initLoader(TASK_LOADER_ID, null, this);

        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(TASK_LOADER_ID, null, YeuThichFragment.this);


    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, final Bundle loaderArgs) {

        return new AsyncTaskLoader<Cursor>(getActivity()) {

            // Initialize a Cursor, this will hold all the task data
            Cursor mTaskData = null;

            // onStartLoading() is called when a loader first starts loading data
            @Override
            protected void onStartLoading() {
                if (mTaskData != null) {
                    // Delivers any previously loaded data immediately
                    deliverResult(mTaskData);
                } else {
                    // Force a new load
                    forceLoad();
                }
            }

            // loadInBackground() performs asynchronous loading of data
            @Override
            public Cursor loadInBackground() {
                // Will implement to load data

                // Query and load all task data in the background; sort by priority
                // [Hint] use a try/catch block to catch any errors in loading data

                try {
                    return getActivity().getContentResolver().query(SanPhamContract.SanPhamEntry.CONTENT_URI_2,
                            null,
                            null,
                            null,
                            null);

                } catch (Exception e) {
                    Log.e(TAG2, "Failed to asynchronously load data.");
                    e.printStackTrace();
                    return null;
                }
            }

            // deliverResult sends the result of the load, a Cursor, to the registered listener
            public void deliverResult(Cursor data) {
                mTaskData = data;
                super.deliverResult(data);
            }
        };

    }


    *//**
     * Called when a previously created loader has finished its load.
     *
     * @param loader The Loader that has finished.
     * @param data The data generated by the Loader.
     *//*
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Update the data that the adapter uses to create ViewHolders

        yeuThichAdapter.swapCursor(data);
        if ( data.getCount() == 0)
            emptyView.setVisibility(View.VISIBLE);
        else {
            emptyView.setVisibility(View.INVISIBLE);
        }

    }





    */
    /**
     * Called when a previously created loader is being reset, and thus
     * making its data unavailable.
     * onLoaderReset removes any references this activity had to the loader's data.
     *
     * @param loader The Loader that is being reset.
     *//*
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
       yeuThichAdapter.swapCursor(null);
    }



    ItemTouchHelper.SimpleCallback itemTouchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int id = (int) viewHolder.itemView.getTag();

            // Build appropriate uri with String row id appended
            String stringId = Integer.toString(id);
            Uri uri = SanPhamContract.SanPhamEntry.CONTENT_URI_2;
            uri = uri.buildUpon().appendPath(stringId).build();

            // COMPLETED (2) Delete a single row of data using a ContentResolver
            getActivity().getContentResolver().delete(uri, null, null);
            getLoaderManager().restartLoader(TASK_LOADER_ID, null, YeuThichFragment.this);

            Cursor cursorSoSanPhamYeuThich = getActivity().getContentResolver().query(SanPhamContract.SanPhamEntry.CONTENT_URI_2, null,null,null,null);
            if (cursorSoSanPhamYeuThich.getCount() > 0)
            {
                MainActivity.badgeDrawableYeuthich.setVisible(true);

                MainActivity.badgeDrawableYeuthich.setNumber(cursorSoSanPhamYeuThich.getCount());
            }
            else
                MainActivity.badgeDrawableYeuthich.setVisible(false);

            cursorSoSanPhamYeuThich.close();



            // COMPLETED (3) Restart the loader to re-query for all tasks after a deletion

        }
    };

    @Override
    public void onListItemClick() {
        getLoaderManager().restartLoader(TASK_LOADER_ID, null, YeuThichFragment.this);

    }
}
*/    private AppDatabase mDb;

    RecyclerView recyclerViewYeuThich;
    YeuthichAdapter yeuThichAdapter;
    View emptyView;
    List<YeuThichEntry> mYeuThichs;

    private static final String TAG2 = YeuThichFragment.class.getSimpleName();

    private static final int TASK_LOADER_ID = 1;

    public YeuThichFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mDb = AppDatabase.getInstance(getActivity());

        View rootView = inflater.inflate(R.layout.yeuthich_fragment, container, false);
        emptyView = rootView.findViewById(R.id.empty_view);


        recyclerViewYeuThich = rootView.findViewById(R.id.recycler_view_yeu_thich);
        recyclerViewYeuThich.setLayoutManager(new LinearLayoutManager(getActivity()));

        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerViewYeuThich);
        yeuThichAdapter = new YeuthichAdapter(getActivity());
        recyclerViewYeuThich.setAdapter(yeuThichAdapter);
        //recyclerViewYeuThich.addItemDecoration(new DividerItemDecoration(getActivity(),
        //      DividerItemDecoration.VERTICAL));

        YeuThichViewModel yeuThichViewModel = ViewModelProviders.of(this).get(YeuThichViewModel.class);
        //yeuThichViewModel.getYeuThich().removeObservers(this);
        yeuThichViewModel.getYeuThich().observe(this, new Observer<List<YeuThichEntry>>() {
            @Override
            public void onChanged(@Nullable List<YeuThichEntry> yeuThichEntries) {
                mYeuThichs = yeuThichEntries;
                yeuThichAdapter.setYeuThichs(yeuThichEntries);

                if (mYeuThichs.size() == 0) {
                    yeuThichAdapter.setYeuThichs(yeuThichEntries);
                    emptyView.setVisibility(View.VISIBLE);
                }
                else
                    emptyView.setVisibility(View.INVISIBLE);

            }
        });

        return rootView;
    }
    ItemTouchHelper.SimpleCallback itemTouchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    int position = viewHolder.getAdapterPosition();
                    List<YeuThichEntry> yeuThichs = yeuThichAdapter.getYeuThichs();
                    mDb.yeuThichDao().deleteYeuThich(yeuThichs.get(position));
                }
            });


        }
    };



}
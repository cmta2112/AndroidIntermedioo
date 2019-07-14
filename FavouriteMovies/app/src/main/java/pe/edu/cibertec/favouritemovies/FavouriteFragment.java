package pe.edu.cibertec.favouritemovies;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment {

    RecyclerView rvFavorites;
    FavouriteAdapter adapter;
    List<Movie> items;


    public FavouriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFavorites = view.findViewById(R.id.rvFavorites);
        loadItems(view);
    }

    private void loadItems(View view) {

        items = AppDatabase.getInstance(view.getContext()).movieDao().getAll();
        adapter = new FavouriteAdapter(items);

        rvFavorites.setAdapter(adapter);
        rvFavorites.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}

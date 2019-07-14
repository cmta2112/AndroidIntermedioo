package pe.edu.cibertec.favouritemovies;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavoritePrototype> {

    List<Movie> items;

    public FavouriteAdapter(List<Movie> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FavoritePrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_favourite, viewGroup, false);

        return new FavoritePrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoritePrototype favoritePrototype, int position) {
        favoritePrototype.tvTitle.setText(items.get(position).getTitle());
        favoritePrototype.tvYear.setText(items.get(position).getYear());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class FavoritePrototype extends RecyclerView.ViewHolder {
        TextView tvTitle, tvYear;

        ImageButton btDelete;

        public FavoritePrototype(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvYear = itemView.findViewById(R.id.tvYear);

            btDelete = itemView.findViewById(R.id.btDelete);

         btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppDatabase.getInstance(v.getContext()).movieDao()
                            .delete(items.get(getAdapterPosition()));
                    items.remove(items.get(getAdapterPosition()));
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(), items.size());


                }
            });

        }
    }
}

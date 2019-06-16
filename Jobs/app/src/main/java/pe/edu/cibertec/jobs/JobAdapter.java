package pe.edu.cibertec.jobs;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobPrototype> {

    List<Job> items;

    public JobAdapter(List<Job> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public JobPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.prototype_job, viewGroup, false);


        return new JobPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobPrototype jobPrototype, int position) {

        jobPrototype.tvtitle.setText(items.get(position).getTitle());
        jobPrototype.tvCompany.setText(items.get(position).getCompany());
        jobPrototype.tvDescription.setText(items.get(position).getDescription());
        jobPrototype.tvDescription.setText(items.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class JobPrototype extends RecyclerView.ViewHolder {

        TextView tvtitle, tvCompany, tvDescription;
        ImageView ivlogo;





        public JobPrototype(@NonNull View itemView) {
            super(itemView);

            tvtitle=itemView.findViewById(R.id.tvTitle);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            tvDescription = itemView.findViewById(R.id.tvDescription);

            ivlogo = itemView.findViewById(R.id.ivLogo);


        }
    }
}
package ru.olschegolev.homework3_alertdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
private final LayoutInflater layoutInflater;
List<Car> cars;

    public CarAdapter(Context context, List<Car> cars) {
        this.cars = cars;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.image.setImageResource(car.getImage());
        holder.description.setText(car.getDescription());
        holder.title.setText(car.getName());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            description= itemView.findViewById(R.id.description);
        }
    }
}

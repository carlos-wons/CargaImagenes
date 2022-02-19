package net.jesus.cargaimagenes.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import net.jesus.cargaimagenes.R;
import net.jesus.cargaimagenes.model.ImagenC;
import java.util.ArrayList;
public class AdaptadorImage extends RecyclerView.Adapter<AdaptadorImage.ViewHolder> {

    ArrayList<ImagenC> ListaImagenes;
    private Context contxx;
    private LayoutInflater lyF;
    private static final String TAG = "idImagen";

    public AdaptadorImage(Context contexto, ArrayList<ImagenC> heroesList) {
        lyF = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.ListaImagenes = heroesList;
        this.contxx = contexto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = lyF.inflate(R.layout.disenio, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImagenC objIm = ListaImagenes.get(position);
        Picasso.get().load(objIm.getImageurl()).into(holder.contenidoImagen);
        holder.nombreImagen.setText(objIm.getName());
    }

    @Override
    public int getItemCount() {
        return ListaImagenes.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView contenidoImagen;
        public TextView nombreImagen;

        public ViewHolder(View itemView)
        {
            super(itemView);
            contenidoImagen = (ImageView) itemView.findViewById(R.id.contentImage);
            contenidoImagen.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            nombreImagen = (TextView) itemView.findViewById(R.id.contentName);
        }
    }

}

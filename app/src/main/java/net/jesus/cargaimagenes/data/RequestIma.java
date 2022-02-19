package net.jesus.cargaimagenes.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.jesus.cargaimagenes.MainActivity;
import net.jesus.cargaimagenes.R;
import net.jesus.cargaimagenes.model.ImagenC;
import net.jesus.cargaimagenes.view.Fragmaneto;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RequestIma {
    private static final String TAG = "idImagen";
    Context context;
    MainActivity mainActivity;
    RequestQueue requestI;

    public RequestIma(Context context) {
        this.context = context;
        if (context instanceof MainActivity){
            mainActivity = (MainActivity) context;
        }
        requestI = Volley.newRequestQueue(context);
    }

    public void cargaIRequests(){
        String linkImgenes = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";
        JsonRequest jsonRequest = new JsonObjectRequest(
                linkImgenes,
                null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("heroes");
                        Type listType = new TypeToken<ArrayList<ImagenC>>(){}.getType();
                        Gson gson = new Gson();
                        MainActivity.heroesArrayList = gson.fromJson(jsonArray.toString(), listType);
                        for(ImagenC hero: MainActivity.heroesArrayList){
                            Log.d(TAG, "RequestIma: nombre: " + hero.getName() + ", Imagen: " + hero.getImageurl());
                        }
                        Log.d(TAG, "RequestIma: Imagenes cargadas");
                        Fragmaneto selectorFragment = new Fragmaneto();
                        if (mainActivity.findViewById(R.id.contenedorI) != null && mainActivity.getSupportFragmentManager().findFragmentById(R.id.contenedorI) == null){
                            mainActivity.getSupportFragmentManager().beginTransaction().add(R.id.contenedorI, selectorFragment).commit();
                        }
                    } catch (JSONException e) {
                        Log.d(TAG, "RequestIma: " + e.getMessage());
                    }
                },
                error -> {
                    Log.d(TAG, "RequestIma: Error: " + error);
                }
        );
        requestI.add(jsonRequest);
        Log.d(TAG, "RequestIma: Pasó request");
    }
}

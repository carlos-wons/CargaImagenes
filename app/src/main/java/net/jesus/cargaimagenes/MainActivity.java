package net.jesus.cargaimagenes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.jesus.cargaimagenes.data.RequestIma;
import net.jesus.cargaimagenes.model.ImagenC;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ImagenC> heroesArrayList;
    RequestIma objImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objImage = new RequestIma(this);
        objImage.cargaIRequests();
    }
    //Funcionando al 100% y cargando imagenes en fragmentos
}
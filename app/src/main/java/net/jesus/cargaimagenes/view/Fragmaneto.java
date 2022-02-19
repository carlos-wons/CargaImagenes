package net.jesus.cargaimagenes.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import net.jesus.cargaimagenes.MainActivity;
import net.jesus.cargaimagenes.R;


public class Fragmaneto extends Fragment {

    private AdaptadorImage adapterimg;
    private GridLayoutManager lym;
    private RecyclerView imgRecyclerView;
    MainActivity mainActivity;
    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof MainActivity){
            mainActivity = (MainActivity) context;
        }
    }

    private String Param1img;
    private String Param2img;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Fragmaneto() {

    }

    public static Fragmaneto newInstance(String param1, String param2) {
        Fragmaneto fragment = new Fragmaneto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Param1img = getArguments().getString(ARG_PARAM1);
            Param2img = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cargador, container, false);
        imgRecyclerView = v.findViewById(R.id.hero_recyclerView);
        lym = new GridLayoutManager(getActivity(), 2);
        adapterimg = new AdaptadorImage(getActivity(), MainActivity.heroesArrayList);
        imgRecyclerView.setLayoutManager(lym);
        imgRecyclerView.setAdapter(adapterimg);
        return v;
    }
}

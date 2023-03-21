package com.example.parada_cabrera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> listaPrincipalProductos;
    private RecyclerView rvListadoProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.txt_listado));

        cargarDatos();

        rvListadoProductos = findViewById(R.id.rv_listado_productos);

        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(listaPrincipalProductos);

        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Producto miProducto, int posicion) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("producto",miProducto);
                startActivity(intent);
            }

            @Override
            public void onItemBtnEliminaClick(Producto miProducto, int posicion) {
                listaPrincipalProductos.remove(posicion);
                miAdaptador.setListadoInformacion(listaPrincipalProductos);
            }
        });

        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));
    }

    public void cargarDatos(){
        Producto producto1 = new Producto();
        producto1.setNombre("Computador HP");
        producto1.setPrecio(8000.0);
        producto1.setUrlImagen("https://e7.pngegg.com/pngimages/565/899/png-clipart-laptop-hewlett-packard-hp-pavilion-15-cd000-series-intel-core-i5-laptop-gadget-electronics.png");

        Producto producto2 = new Producto("Teclado Dell",
                800.00,
                "https://e7.pngegg.com/pngimages/454/792/png-clipart-computer-keyboard-computer-mouse-keyboard-protectors-bluetooth-dell-computer-mouse-electronics-computer-keyboard.png");
        Producto producto3 = new Producto("Mouse",
                5000.0,
                "https://w7.pngwing.com/pngs/303/196/png-transparent-computer-mouse-logitech-g402-hyperion-fury-amazon-com-optical-mouse-computer-mouse-electronics-computer-video-game.png");

        listaPrincipalProductos = new ArrayList<>();

        listaPrincipalProductos.add(producto1);
        listaPrincipalProductos.add(producto2);
        listaPrincipalProductos.add(producto3);
    }
}
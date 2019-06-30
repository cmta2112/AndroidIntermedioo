package pe.cibertec.agendaroommvp.ui.main;

import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import pe.cibertec.agendaroommvp.R;
import pe.cibertec.agendaroommvp.data.db.AppDatabase;
import pe.cibertec.agendaroommvp.data.db.model.Contact;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    TextInputEditText etNombre;
    Button btAdd;
    RecyclerView rvContact;

    List<Contact> items;
    ContactAdapter adapter;

    MainContract.MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // METODOS

        //--INICIALIZAR LOS DATOS  QUE ESTAN EN LAYOUT
        initView();

        //-- LOS BOTONES QUE SE VA A HACER
        setListeners();

        //-- AMARRE CON EL PRESENTER
        configureMvp();
    }

    private void configureMvp() {

        //aqui viene el amarre
        this.presenter = new MainPresenter(this);
    }

    private void setListeners() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Agregar el contact
                Contact contact = new Contact(etNombre.getText().toString());

                MainActivity.this.presenter.addContact(contact);
                MainActivity.this.presenter.getAllContatcs();
            }
        });


    }

    private void initView() {

        etNombre = findViewById(R.id.etName);
        btAdd = findViewById(R.id.btAdd);
        rvContact = findViewById(R.id.rvContact);

    }


    //-----------------------------------------------------------------------------------------

    @Override
    //CON ESTE METODO OBTENGO LOS DATOS
    protected void onResume() {
        super.onResume();
        this.presenter.getAllContatcs();
    }

    @Override
    // MOSTRAR MIS CONTACTOS
    public void showContacts(List<Contact> contacts) {
        items = contacts;
        adapter = new ContactAdapter(items);
        rvContact.setAdapter(adapter);

        rvContact.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }




}

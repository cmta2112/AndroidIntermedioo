package pe.cibertec.agendaroommvp.ui.main;

import java.util.List;

import pe.cibertec.agendaroommvp.data.db.model.Contact;

public interface MainContract {

    // LAS INTERFACES DE VIEW Y DEL PRESENTER

    interface MainView {
        // METODO PARA MOSTRAR
        void showContacts(List<Contact> contacts);


    }

    // MAIN PRESENTER ESTA LA LOGICA DEL MODELO / METODOS
    interface  MainPresenter {
        void addContact(Contact contact);
        void getAllContatcs();
        // METODO ELIMINAR ETC ....



    }
}

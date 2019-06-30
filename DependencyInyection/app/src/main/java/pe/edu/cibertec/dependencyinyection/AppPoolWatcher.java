package pe.edu.cibertec.dependencyinyection;

public class AppPoolWatcher {

   // EventLogWriter eventLogWriter = null;
  //  INotificationAction action = null;
   INotificationAction action = null;


    //INYECCION DE PROPIERDAD / ATRIBUTO
    public INotificationAction getAction() {
        return action;
    }

    public void setAction(INotificationAction action) {
        this.action = action;
    }
    // de acuerdo por el medio que quieres enviar el mensaje
    /*
    public void  notify (String message){
        if (action == null){
           // action = new EventLogWriter();
           // action = new SmsSender();
            action = new EmailSender();
        }

        action.write(message);
   }
   */


    // INYECCION DE CONTRUCTOR

    public AppPoolWatcher(INotificationAction action) {
        this.action = action;    }

    //CONTRUCTOR VACIO

    public AppPoolWatcher() {

    }

    public void notify(String message){
        action.write(message);
    }

    //INYECCION DE METODO

    public void  notify (INotificationAction action, String message){
        this.action = action;
        this.action.write(message);
    }

}

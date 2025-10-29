import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Declaro entidades y versión del esquema
@Database(entities = {Persona.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE; //Para manejar una única instancia / unico hilo visibilidad entre hilos.
    public abstract PersonaDAO personaDAO(); //Room implementa este método para obtener el DAO.

    public static AppDatabase getInstance(Context context) { //Patrón Singletón con doble check de locking

        if(INSTANCE == null) {
            synchronized(AppDatabase.class){ //Bloquea para crear instancia segura en multihilo.
                if(INSTANCE == null) { //Doble chequeo, adentro, para evitar crear dos instancias y tener colisión de hilos.
                    //Aca deberíamos usar hilos/Executors o crutinas si fuera kotlin
                    INSTANCE =  Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class, //Clase de DB
                                    "demo.db") //Nombre del archivo de la bbdd
                            .fallbackToDestructiveMigration() //si cambia la versión y no hay migración, la base se borra yu se recrea.
                            .allowMainThreadQueries() //Permite instanciarse en el hilo principal.
                            //En una app real, debería ir en un executor para no bloquear la U
                            //La base podría tener multiples hilos tranquilamente.
                            //Dos hilos, podrían insertar un duplicado sin los controles suficientes.
                            .build(); //Construyo la instancia inmutable
                }
            }
        }
        return INSTANCE; //Devuelvo la UNICA instancia.
    }
}

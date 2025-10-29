

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PersonaDAO {
    //Le indicamos a Room que esta interfaz define operaciones contra la bd
    //Contrato de métodos
    @Insert //Room generará el código para insert en "persona"
    void insertar(Persona p);
    @Query("SELECT id, nombre, edad FROM personas")
    List<Persona> todas(); //Devuelve una lista de las entidades mapeadas.
    @Query("DELETE FROM personas")
    void borrarTodo();
}

//El DAO es una intefaz con métodos antoados en donde Room generára las impelementaciones conrectar en COMPILACION!

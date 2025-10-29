import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "personas") //Le indico a Room que esta clase es una tabla llamada persona
public class Persona {

     @PrimaryKey(autoGenerate = true) //La columna es primary key y es autoincrmental
     public int id;
     public String nombre;
     public String edad; //Cuando ponés String, Room infiere que es tipo TEXT.

}

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Adaptador básico para mostrar strings en un recycler view
public class AdaptadorTexto extends RecyclerView.Adapter<AdaptadorTexto.VistaTextoViewHolder> {

    //Fuente de datos, en este caso de una List

    private final List<String> listadeTextos;

    public AdaptadorTexto(List<String> listadeTextos) {
        this.listadeTextos = listadeTextos;
    }

    //Crear cada una de las cards (ViewHolder) inflando el xml del ítem.
    public VistaTextoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vistaItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_texto_simple, parent, false);

        return new VistaTextoViewHolder(vistaItem);
    }

    //Bindea "pega" el dato en la poscicón "position" a la vista del ViewHolder

    public void onBindViewHolder(@NonNull VistaTextoViewHolder holder, int position) {

        String texto = listadeTextos.get(position);
        holder.txtTexto.setText(texto);

    }

    //Devolver cuantos items tiene mi banco de datos (lista)

    @Override
    public int getItemCount() {

        return (listadeTextos == null) ? 0 : listadeTextos.size();
    }

    //El viewHolder guarda referencias a las vistas del item para no buscarlas cada vez.
    static class VistaTextoViewHolder extends RecyclerView.ViewHolder {
        final TextView txtTexto;

        public VistaTextoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTexto = itemView.findViewById(R.id.txtTexto);
        }
    }

}

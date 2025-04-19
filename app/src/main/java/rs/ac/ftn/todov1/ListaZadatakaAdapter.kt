package rs.ac.ftn.todov1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import rs.ac.ftn.todov1.databinding.StavkaListeZadatakBinding


class CuvacZadataka (
    private val binding: StavkaListeZadatakBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(zadatak: Zadatak) {
        binding.naslovZadatka.text = zadatak.naslov
        binding.datumZadatka.text = zadatak.datum.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "kliknuto na ${zadatak.naslov}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class ListaZadatakaAdapter (
    private val zadaci: List<Zadatak>
) : RecyclerView.Adapter<CuvacZadataka>() {

    override fun onCreateViewHolder (
        parent: ViewGroup,
        viewType: Int
    ) : CuvacZadataka {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StavkaListeZadatakBinding.inflate(inflater, parent, false)
        return CuvacZadataka(binding)
    }

    override fun getItemCount() = zadaci.size

    override fun onBindViewHolder(holder: CuvacZadataka, position: Int) {
        val zadatak = zadaci[position]
        holder.bind(zadatak)
    }
}
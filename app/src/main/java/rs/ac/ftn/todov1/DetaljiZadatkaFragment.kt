package rs.ac.ftn.todov1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import rs.ac.ftn.todov1.databinding.DetaljiZadatkaFragmentBinding
import java.util.Date
import java.util.UUID

class DetaljiZadatkaFragment : Fragment() {

    // private lateinit var binding: FragmentDetaljiZadatkaBinding
    private var _binding: DetaljiZadatkaFragmentBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Ne mogu da pristupim binding-u jer je null. Da li je View vidljiv?"
        }
    private lateinit var zadatak: Zadatak

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        zadatak = Zadatak(
            id = UUID.randomUUID(),
            naslov = "",
            datum = Date(),
            daLiJeResen = false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetaljiZadatkaFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            naslovZadatka.doOnTextChanged { text, _, _, _ ->
                zadatak = zadatak.copy(naslov = text.toString())
            }

            datumZadatka.apply {
                text = zadatak.datum.toString()
                isEnabled = false
            }

            zadatakResen.setOnCheckedChangeListener { _, isChecked ->
                zadatak = zadatak.copy(daLiJeResen = isChecked)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
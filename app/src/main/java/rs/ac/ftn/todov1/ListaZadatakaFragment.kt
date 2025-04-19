package rs.ac.ftn.todov1

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import rs.ac.ftn.todov1.databinding.ListaZadatakaFragmentBinding

private const val TAG = "ListaZadatakaFragment"

class ListaZadatakaFragment: Fragment() {

    private var _binding: ListaZadatakaFragmentBinding? = null
    private val binding
        get() = checkNotNull(_binding){
            "Ne mogu da pristupim binding-u jer je null. Da li je View vidljiv?"
        }

    private val listaZadatakaViewModel: ListaZadatakaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Ukupno zadataka: ${listaZadatakaViewModel.zadaci.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListaZadatakaFragmentBinding.inflate(inflater, container, false)
        binding.zadatakRecyclerView.layoutManager = LinearLayoutManager(context)

        val zadaci = listaZadatakaViewModel.zadaci
        val adapter = ListaZadatakaAdapter(zadaci)
        binding.zadatakRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
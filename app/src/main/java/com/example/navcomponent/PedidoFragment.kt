package com.example.navcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navcomponent.databinding.FragmentPedidoBinding
import com.example.navcomponent.databinding.FragmentProductosBinding

class PedidoFragment : Fragment() {
    private var _binding: FragmentPedidoBinding? = null
    private val binding get() = _binding!!

    private val args: PedidoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPedidoBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productoSelecionado.text = getString(R.string.detalles_titulo, args.comida)

        binding.cantidad.setOnClickListener { binding.cantidad.text.clear() }
        binding.nombre.setOnClickListener { binding.nombre.text.clear() }

        binding.opcionComida.isChecked = true

        binding.btnConfirmar.setOnClickListener {

            val nombre = binding.nombre.text.toString()
            val horario = when {
                binding.opcionComida.isChecked -> "Comida"
                else -> "Cena"
            }

            val insert = binding.cantidad.text
            if (insert.isBlank()) {
                val text = "La cantidad esta vacía"
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(activity, text, duracion)
                toast.show()
            } else {
                val cantidad = binding.cantidad.text.toString().toInt()
                val action = PedidoFragmentDirections.actionPedidoFragmentToResumenPedidoFragment(
                    args.comida,
                    cantidad,
                    horario,
                    nombre
                )
                findNavController().navigate(action)
            }
        }
        binding.btnAtras.setOnClickListener {
            findNavController().popBackStack()
        }


    }

}
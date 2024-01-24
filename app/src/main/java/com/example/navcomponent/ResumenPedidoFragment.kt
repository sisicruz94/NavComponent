package com.example.navcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navcomponent.databinding.FragmentPedidoBinding
import com.example.navcomponent.databinding.FragmentResumenPedidoBinding

class ResumenPedidoFragment : Fragment() {
    private var _binding: FragmentResumenPedidoBinding? = null
    private val binding get() = _binding!!

    private val args: ResumenPedidoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResumenPedidoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pedido.text = getString(R.string.pedido_confirmacion, args.cantidad, args.comida)
        binding.horario.text = getString(R.string.horario_confirmacion, args.horario)
        binding.nombre.text = getString(R.string.nombre_confirmacion, args.nombre)

        binding.btnConfirmar.setOnClickListener {
            findNavController().navigate(R.id.confirmacionFragment)

        }
        binding.btnAtras.setOnClickListener {
            findNavController().popBackStack()
        }


    }
}
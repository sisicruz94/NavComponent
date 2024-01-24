package com.example.navcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navcomponent.databinding.FragmentProductosBinding

class ProductosFragment : Fragment() {

    //implementamos el binding
    private var _binding: FragmentProductosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentProductosBinding.inflate(layoutInflater, container, false)
        return binding.root

        return inflater.inflate(R.layout.fragment_pedido, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.hamburguesa.setOnClickListener {
            val hamburguesa = " Hamburguesa"
            val action =
                ProductosFragmentDirections.actionProductosFragmentToPedidoFragment(hamburguesa)
            findNavController().navigate(action)

        }

        binding.pizza.setOnClickListener {
            val pizza = " Pizza"
            val action = ProductosFragmentDirections.actionProductosFragmentToPedidoFragment(pizza)
            findNavController().navigate(action)

        }

        binding.ensalada.setOnClickListener {
            val ensalada = " Ensalada"
            val action =
                ProductosFragmentDirections.actionProductosFragmentToPedidoFragment(ensalada)
            findNavController().navigate(action)

        }
        binding.taco.setOnClickListener {
            val taco = " Taco"
            val action = ProductosFragmentDirections.actionProductosFragmentToPedidoFragment(taco)
            findNavController().navigate(action)

        }


    }

}
package com.example.mobileapplication11.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileapplication11.R

private const val ARG_P1 = "p1"
private const val ARG_P2 = "p2"


class SearchFragment : Fragment() {
    private var p1: String? = null
    private var p2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            p1 = it.getString(ARG_P1)
            p2 = it.getString(ARG_P2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(p1: String, p2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_P1, p1)
                    putString(ARG_P2, p2)
                }
            }
    }
}
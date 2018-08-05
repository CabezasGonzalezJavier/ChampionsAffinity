package com.thedeveloperworldisyours.championsaffinity.detail

import kotlinx.android.synthetic.main.detail_fragment.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thedeveloperworldisyours.championsaffinity.Constantss.Companion.EXTRA_NAME
import com.thedeveloperworldisyours.championsaffinity.R

/**
 * Created by javiergonzalezcabezas on 30/7/18.
 */
class DetailFragment : Fragment() {
    companion object {
        fun newInstance(name: String): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putString(EXTRA_NAME, name)
            fragment.setArguments(args)
            return fragment
        }
    }

    var namePlayer :String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater?.inflate(R.layout.detail_fragment, container, false)
        val args = arguments
        namePlayer= args?.getString(EXTRA_NAME) as String
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detail_fragment_description_title_textView.setText(namePlayer)
    }
}
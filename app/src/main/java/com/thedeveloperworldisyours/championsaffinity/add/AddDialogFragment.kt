package com.thedeveloperworldisyours.championsaffinity.add

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thedeveloperworldisyours.championsaffinity.R
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.add_dialog_fragment.*


/**
 * Created by javiergonzalezcabezas on 5/8/18.
 */
class AddDialogFragment: DialogFragment() {
    companion object {
        fun newInstance(name: String): AddDialogFragment {
            val fragment = AddDialogFragment()
            val args = Bundle()
            //args.putString(EXTRA_NAME, name)
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater?.inflate(R.layout.add_dialog_fragment, container, false)
        val args = arguments
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //detail_fragment_description_title_textView.setText(namePlayer)

        add_club_button.setOnClickListener {
            showClubs()
        }
    }

    fun showClubs() {
        val builderSingle = AlertDialog.Builder(activity)
        builderSingle.setTitle("Select One Name:-")

        val arrayAdapter = ArrayAdapter<String>(activity, android.R.layout.select_dialog_singlechoice)
        arrayAdapter.add("At.Madrid")
        arrayAdapter.add("Barcelona")
        arrayAdapter.add("Real Madrid")
        arrayAdapter.add("Valencia")
        arrayAdapter.add("Bayern")

        builderSingle.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })

        builderSingle.setAdapter(arrayAdapter, DialogInterface.OnClickListener { dialog, which ->
            val strName = arrayAdapter.getItem(which)
            val builderInner = AlertDialog.Builder(activity)
            builderInner.setMessage(strName)
            builderInner.setTitle("Your Selected Item is")
            builderInner.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
            builderInner.show()
        })
        builderSingle.show()
    }

}
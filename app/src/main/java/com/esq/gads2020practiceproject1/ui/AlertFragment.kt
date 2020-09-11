package com.esq.gads2020practiceproject1.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.esq.gads2020practiceproject1.R
import com.esq.gads2020practiceproject1.databinding.FragmentAlertBinding

private const val ARG_PARAM_TYPE = "alert_type"

/**
 * A simple [Fragment] subclass.
 * Use the [AlertFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlertFragment : DialogFragment() {

    private var mAlertType: String? = null
    private lateinit var mBinding: FragmentAlertBinding

    private lateinit var listener: OnRequestConfirmationListener

    interface OnRequestConfirmationListener {
        fun onConfirmed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mAlertType = it.getString(ARG_PARAM_TYPE)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_alert,
            null,
            false
        )

        mBinding.type = mAlertType

        return activity?.let {
            val builder = AlertDialog.Builder(it)

            mBinding.ibCancel.setOnClickListener {
                dismiss()
            }
            mBinding.btnYes.setOnClickListener {
                listener.onConfirmed()
                dismiss()
            }

            builder.setView(mBinding.root)
            builder.setCancelable(mAlertType != "confirmation")
            builder.create()
        } ?: throw IllegalStateException("Parent cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = activity as OnRequestConfirmationListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                (context.toString() +
                        " must implement OnRequestConfirmationListener")
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(alertType: String) =
            AlertFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_TYPE, alertType)
                }
            }
    }
}
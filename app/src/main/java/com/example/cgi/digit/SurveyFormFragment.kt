package com.example.cgi.digit

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SurveyFormFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SurveyFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SurveyFormFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var lat: String? = null
    private var long: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            lat = arguments.getString(Constant.Location.TAG_LAT)
            long = arguments.getString(Constant.Location.TAG_LAT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_survey_form, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param lat Parameter 1.
         * @param long Parameter 2.
         * @return A new instance of fragment SurveyFormFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(lat: String, long: String): SurveyFormFragment {
            val fragment = SurveyFormFragment()
            val args = Bundle()
            args.putString(Constant.Location.TAG_LAT, lat)
            args.putString(Constant.Location.TAG_LONG, long)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor

package rs.digitalvision.digitalvision.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.io.UnsupportedEncodingException;

import rs.digitalvision.digitalvision.R;
import rs.digitalvision.digitalvision.models.Elements;
import rs.digitalvision.digitalvision.network.VolleySingleton;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ArticleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ArticleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Elements article;
    private NetworkImageView networkImageView;
    private TextView tvPrice;
    private TextView tvAvailable;
    private TextView tvDescription;


    private OnFragmentInteractionListener mListener;

    public ArticleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param elements klk.
     * @return A new instance of fragment ArticleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArticleFragment newInstance(Elements elements) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, elements);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            article = (Elements) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        tvPrice = (TextView) view.findViewById(R.id.tv_price);
        tvAvailable = (TextView) view.findViewById(R.id.tv_available);
        tvDescription = (TextView) view.findViewById(R.id.tv_description);
        networkImageView = (NetworkImageView) view.findViewById(R.id.img_networkImageView);

        tvPrice.setText(article.getCenafullString());
        int available = article.getArtikalStanje();
        if (available > 0)
            tvAvailable.setText(getString(R.string.available));
        else
            tvAvailable.setText(getString(R.string.non_available));

        String base64 = article.getArtikalKratakOpis();
        byte[] data = Base64.decode(base64, Base64.DEFAULT);
        String text = "";
        try {
            text = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        tvDescription.setText(text);
        networkImageView.setImageUrl(article.getSlika(), VolleySingleton.getsInstance(getActivity()).getImageLoader());


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            // TODO: uncomment
            // throw new RuntimeException(context.toString()
            //          + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

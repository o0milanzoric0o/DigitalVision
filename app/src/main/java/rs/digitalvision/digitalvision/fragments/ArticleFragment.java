package rs.digitalvision.digitalvision.fragments;

import android.app.Fragment;
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
        showData();
        return view;
    }

    public void setElemets(Elements elemets){
        article = elemets;
        showData();
    }

    private void showData(){
        if (article != null) {
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
        }
    }

}

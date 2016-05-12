package rs.digitalvision.digitalvision;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.Serializable;

import rs.digitalvision.digitalvision.common.Application.MyApplication;
import rs.digitalvision.digitalvision.common.Config.EndPoints;
import rs.digitalvision.digitalvision.fragments.ArticleFragment;
import rs.digitalvision.digitalvision.models.Articles;
import rs.digitalvision.digitalvision.models.Elements;
import rs.digitalvision.digitalvision.network.PullWebContent;
import rs.digitalvision.digitalvision.network.UrlEndpoints;
import rs.digitalvision.digitalvision.network.VolleySingleton;
import rs.digitalvision.digitalvision.network.WebRequestCallbackInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button btnSubmit;
    private final String jsonRequestTAG = "JSONRequestTAG";

    private VolleySingleton mVolleySingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et_article_code);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(this);
        mVolleySingleton = VolleySingleton.getsInstance(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                // Validate input fields
                if (editText.length() <= 2) {
                    // Not long enough
                    Snackbar.make(v, getString(R.string.article_code_size_error_msg), Snackbar.LENGTH_LONG)
                            .show();
                }

//                // Pull the JSON from the web
//                String url = String.format(EndPoints.DIGITAL_VISION_URL, editText.getText());
//                JsonObjectRequest jsObjRequest = new JsonObjectRequest
//                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                // Show fragment with downloaded data
//                                // Launching  user account fragment
//                                Fragment articleFragment = ArticleFragment.newInstance(response);
//                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                                // Replace whatever is in the fragment_container view with this fragment,
//                                // and add the transaction to the back stack
//                                transaction.replace(R.id.fragment_container, articleFragment);
//                                //transaction.addToBackStack(null);
//
//                                // Commit the transaction
//                                transaction.commit();
//                            }
//                        }, new Response.ErrorListener() {
//
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                Snackbar.make(btnSubmit, getString(R.string.internet_access_fail), Snackbar.LENGTH_LONG)
//                                        .show();
//                            }
//                        });



                final String code = editText.getText().toString();
                PullWebContent<Articles> content =
                        new PullWebContent<Articles>(this, Articles.class, UrlEndpoints.getRequestUrlArticleCode(code), mVolleySingleton);
                content.setCallbackListener(new WebRequestCallbackInterface<Articles>() {
                    @Override
                    public void webRequestSuccess(boolean success, Articles allArticles) {
                        if (success) {
                            Elements elements;
                            elements = allArticles.getElements();
                            // Show fragment with downloaded data
                            // Launching  user account fragment
                            Fragment articleFragment = ArticleFragment.newInstance(elements);
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();

                            // Replace whatever is in the fragment_container view with this fragment,
                            // and add the transaction to the back stack
                            transaction.replace(R.id.fragment_container, articleFragment);
                            //transaction.addToBackStack(null);

                            // Commit the transaction
                            transaction.commit();
                        }
                    }

                    @Override
                    public void webRequestError(String error) {

                    }
                });
                content.pullList();

                break;
            default:
        }
    }
}

package rs.digitalvision.digitalvision;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import rs.digitalvision.digitalvision.fragments.ArticleFragment;
import rs.digitalvision.digitalvision.models.Articles;
import rs.digitalvision.digitalvision.models.Elements;
import rs.digitalvision.digitalvision.network.PullWebContent;
import rs.digitalvision.digitalvision.network.UrlEndpoints;
import rs.digitalvision.digitalvision.network.VolleySingleton;
import rs.digitalvision.digitalvision.network.WebRequestCallbackInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String jsonRequestTAG = "JSONRequestTAG";
    private EditText editText;
    private Button btnSubmit;
    private VolleySingleton mVolleySingleton;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et_article_code);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(this);
        mVolleySingleton = VolleySingleton.getsInstance(this);
        mActivity = this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                // Validate input fields
                if (editText.length() <= 2) {
                    // Not long enough
                    Snackbar snackbar = Snackbar.make(v, getString(R.string.article_code_size_error_msg), Snackbar.LENGTH_LONG)
                            .setAction("ACTION", null);
                    snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
                    snackbar.show();
                } else {

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
                                if (elements != null) {
                                    Fragment articleFragment = ArticleFragment.newInstance(elements);
                                    FragmentTransaction transaction = getFragmentManager().beginTransaction();

                                    // Replace whatever is in the fragment_container view with this fragment,
                                    // and add the transaction to the back stack
                                    transaction.replace(R.id.fragment_container, articleFragment);
                                    transaction.addToBackStack(null);

                                    // Commit the transaction
                                    transaction.commit();
                                } else {
                                    // No product with that code
                                    Snackbar snackbar = Snackbar.make(editText, getString(R.string.article_code_fail), Snackbar.LENGTH_LONG)
                                            .setAction("ACTION", null);
                                    snackbar.getView().setBackgroundColor(ContextCompat.getColor(mActivity, R.color.colorAccent));
                                    snackbar.show();
                                }
                            }
                        }

                        @Override
                        public void webRequestError(String error) {

                        }
                    });
                    content.pullList();
                }
                break;
            default:
        }
    }
}

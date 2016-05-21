package rs.digitalvision.digitalvision;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import rs.digitalvision.digitalvision.dialogs.ProgressDialogCustom;
import rs.digitalvision.digitalvision.fragments.ArticleFragment;
import rs.digitalvision.digitalvision.fragments.KeypadFragment;
import rs.digitalvision.digitalvision.models.Articles;
import rs.digitalvision.digitalvision.models.Elements;
import rs.digitalvision.digitalvision.network.PullWebContent;
import rs.digitalvision.digitalvision.network.UrlEndpoints;
import rs.digitalvision.digitalvision.network.VolleySingleton;
import rs.digitalvision.digitalvision.network.WebRequestCallbackInterface;

public class MainActivity extends AppCompatActivity implements  KeypadFragment.OnKeypadSubmit{

    private final String jsonRequestTAG = "JSONRequestTAG";
    private EditText editText;
    private Button btnSubmit;
    private TextView tv_title;
    private VolleySingleton mVolleySingleton;
    private Activity mActivity;
    private ArticleFragment mArticleFragment;

    ProgressDialogCustom progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et_article_code);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        tv_title = (TextView) findViewById(R.id.tv_price_list);
        mArticleFragment = (ArticleFragment) getFragmentManager().findFragmentById(R.id.article_viewer);
        mVolleySingleton = VolleySingleton.getsInstance(this);
        mActivity = this;

        //setting progressDialog
        progressDialog = new ProgressDialogCustom(this);
        progressDialog.setCancelable(false);
    }


    @Override
    public void onKeypadSubmit(String code) {
        // Validate input fields
        if (code.length() <= 2) {
            // Not long enough
            Snackbar snackbar = Snackbar.make(editText, getString(R.string.article_code_size_error_msg), Snackbar.LENGTH_LONG)
                    .setAction("ACTION", null);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            snackbar.show();
        } else {

            PullWebContent<Articles> content =
                    new PullWebContent<Articles>(this, Articles.class, UrlEndpoints.getRequestUrlArticleCode(code), mVolleySingleton);
            content.setCallbackListener(new WebRequestCallbackInterface<Articles>() {
                @Override
                public void webRequestSuccess(boolean success, Articles allArticles) {
                    if (success) {
                        progressDialog.hideDialog();
                        Elements elements;
                        elements = allArticles.getElements();
                        // Show fragment with downloaded data
                        // Launching  user account fragment
                        if (elements != null) {
                            mArticleFragment.setElemets(elements);
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
                    progressDialog.hideDialog();
                }
            });
            content.pullList();
            progressDialog.showDialog("Pretraga...");
        }
    }
}

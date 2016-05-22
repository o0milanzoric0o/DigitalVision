package rs.digitalvision.digitalvision;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.FrameLayout;
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

public class MainActivity extends AppCompatActivity implements KeypadFragment.OnKeypadSubmit {

    private final String jsonRequestTAG = "JSONRequestTAG";
    ProgressDialogCustom progressDialog;
    private TextView tvTitle;
    private FrameLayout mContainer;
    private VolleySingleton mVolleySingleton;
    private Activity mActivity;
    private ArticleFragment mArticleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        /**TODO check if tablet or handset...*/
        if (getResources().getConfiguration().smallestScreenWidthDp >= 600) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(R.layout.activity_main);


        mContainer = (FrameLayout) findViewById(R.id.container);
        if (mContainer != null) { // this is small screen
            //Load fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            KeypadFragment keypadFragment = new KeypadFragment();
            fragmentTransaction.add(R.id.container, keypadFragment);
            fragmentTransaction.commit();

        } else {
            mArticleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_viewer);
        }
        tvTitle = (TextView) findViewById(R.id.tv_price_list);

        mVolleySingleton = VolleySingleton.getsInstance(this);


        //setting progressDialog
        progressDialog = new ProgressDialogCustom(this);
        progressDialog.setCancelable(false);
    }


    @Override
    public void onKeypadSubmit(String code) {
        // Validate input fields
        if (code.length() < 2) {
            // Not long enough
            Snackbar snackbar = Snackbar.make(tvTitle, getString(R.string.article_code_size_error_msg), Snackbar.LENGTH_LONG)
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
                            if (mContainer != null) {// it's a handset
                                // Create new fragment and transaction
                                ArticleFragment articleFragment = new ArticleFragment();
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                                // Replace whatever is in the fragment_container view with this fragment,
                                // and add the transaction to the back stack
                                transaction.replace(R.id.container, articleFragment);
                                transaction.addToBackStack(null);

                                // Commit the transaction
                                transaction.commit();
                                getSupportFragmentManager().executePendingTransactions();
                                articleFragment.setElemets(elements);
                            } else {
                                mArticleFragment.setElemets(elements);
                            }
                        } else {
                            // No product with that code
                            Snackbar snackbar = Snackbar.make(tvTitle, getString(R.string.article_code_fail), Snackbar.LENGTH_LONG)
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

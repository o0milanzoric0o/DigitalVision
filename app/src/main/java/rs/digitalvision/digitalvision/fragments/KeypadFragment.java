package rs.digitalvision.digitalvision.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import rs.digitalvision.digitalvision.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeypadFragment extends Fragment implements View.OnClickListener {
    OnKeypadSubmit mListener;
    EditText editText;
    String code = "";

    public KeypadFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("LALALA", "ON ATACH WAS CALLED");
        if (context instanceof OnKeypadSubmit) {
            mListener = (OnKeypadSubmit) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnKeypadSubmit");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keypad, container, false);
        (view.findViewById(R.id.button0)).setOnClickListener(this);
        (view.findViewById(R.id.button1)).setOnClickListener(this);
        (view.findViewById(R.id.button2)).setOnClickListener(this);
        (view.findViewById(R.id.button3)).setOnClickListener(this);
        (view.findViewById(R.id.button4)).setOnClickListener(this);
        (view.findViewById(R.id.button5)).setOnClickListener(this);
        (view.findViewById(R.id.button6)).setOnClickListener(this);
        (view.findViewById(R.id.button7)).setOnClickListener(this);
        (view.findViewById(R.id.button8)).setOnClickListener(this);
        (view.findViewById(R.id.button9)).setOnClickListener(this);
        (view.findViewById(R.id.button_backspace)).setOnClickListener(this);
        (view.findViewById(R.id.button_clear)).setOnClickListener(this);
        (view.findViewById(R.id.btn_submit)).setOnClickListener(this);
        editText = (EditText) view.findViewById(R.id.et_article_code);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                code = code + "0";
                break;
            case R.id.button1:
                code = code + "1";
                break;
            case R.id.button2:
                code = code + "2";
                break;
            case R.id.button3:
                code = code + "3";
                break;
            case R.id.button4:
                code = code + "4";
                break;
            case R.id.button5:
                code = code + "5";
                break;
            case R.id.button6:
                code = code + "6";
                break;
            case R.id.button7:
                code = code + "7";
                break;
            case R.id.button8:
                code = code + "8";
                break;
            case R.id.button9:
                code = code + "9";
                break;
            case R.id.button_clear:
                code = "";
                break;
            case R.id.button_backspace:
                if (code != null && code.length() > 0) {
                    code = code.substring(0, code.length() - 1);
                }
                break;
            case R.id.btn_submit:
                mListener.onKeypadSubmit(code);
                code = "";
                break;
            default:
        }
        editText.setText(code);
    }

    // Container Activity must implement this interface
    public interface OnKeypadSubmit {
        public void onKeypadSubmit(String code);
    }


}

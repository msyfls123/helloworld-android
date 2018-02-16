package cc.ebichu.helloworld;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlinesFragment extends Fragment implements View.OnClickListener {
    OnHeadlineSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(String message);
    }

    public HeadlinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_headlines, container, false);

        final Button article1 = (Button) v.findViewById(R.id.button321);
        article1.setOnClickListener(this);
        final Button article2 = (Button) v.findViewById(R.id.button123);
        article2.setOnClickListener(this);
        /*loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                sendMessage(v);
            }
        });*/
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = (Activity) context;

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnHeadlineSelectedListener) a;
        } catch (ClassCastException e) {
            throw new ClassCastException(a.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public void onClick(View view) {
        // Do something in response to button
        // Button button = (Button) view.findViewById(R.id.button321);

        switch (view.getId()) {
            case R.id.button321:
            case R.id.button123:
                String message = ((Button)view).getText().toString();
                mCallback.onArticleSelected(message);
                break;
            default:
                break;
        }
    }

}

package cc.ebichu.helloworld;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {
    public ArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        String message;
        if (args != null) {
            message = args.getString("message");
        } else {
            message = "init";
        }
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.article_view, container, false);
        View tv = v.findViewById(R.id.test_string);
        ((TextView)tv).setText(message);
        return v;
    }

    public void updateArticleView(String message) {
        View textView = getView().findViewById(R.id.test_string);
        ((TextView)textView).setText(message);
    }

}

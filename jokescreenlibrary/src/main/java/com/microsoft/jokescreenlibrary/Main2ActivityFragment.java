package com.microsoft.jokescreenlibrary;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main2ActivityFragment extends Fragment {

    public Main2ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String joke = getActivity().getIntent().getExtras().getString("Joke");
        View v = inflater.inflate(R.layout.fragment_main2, container, false);
        ((TextView)v.findViewById(R.id.jokeText)).setText(joke);
        return  v;
    }
}

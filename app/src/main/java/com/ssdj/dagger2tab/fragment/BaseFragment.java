package com.ssdj.dagger2tab.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ssdj.dagger2tab.R;


/**
 * @author 陈  杰
 * @version $Rev$
 * @time 2017/2/20 15:50
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class BaseFragment extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    private String param1;

    public static BaseFragment newInstance(String param)
    {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            param1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_base, null, false);
        TextView textView = findView(view, R.id.fg_tv);
        textView.setText(param1);
        return view;
    }

    private <T extends View> T findView(View view, int id)
    {
        return (T) view.findViewById(id);
    }
}
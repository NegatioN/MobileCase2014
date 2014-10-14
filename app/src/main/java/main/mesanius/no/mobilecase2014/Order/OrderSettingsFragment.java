package main.mesanius.no.mobilecase2014.Order;

import java.text.DecimalFormat;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import main.mesanius.no.mobilecase2014.R;

public class OrderSettingsFragment extends Fragment {
	OnHeadlineSelectedListener mCallback;
	LinearLayout home, rest;

	public interface OnHeadlineSelectedListener {
		/** Called by HeadlinesFragment when a list item is selected */
		public void payAndConfirm();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// If activity recreated (such as from screen rotate), restore
		// the previous article selection set by onSaveInstanceState().
		// This is primarily necessary when in the two-pane layout.
		if (savedInstanceState != null) {
		} else {

		}
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.order_settings_layout, container,
				false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		updateArticleView();

	}

	public void updateArticleView() {

		home = (LinearLayout) getActivity().findViewById(
				R.id.homeSelected);
		rest = (LinearLayout) getActivity().findViewById(
				R.id.restSelected);
		final Button ok = (Button)getActivity().findViewById(R.id.Order);
		ok.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //show confirm dialog
                Toast.makeText(getActivity(),"CONFIRM?",Toast.LENGTH_SHORT);
            }
        });
		
		RadioButton radioRest = (RadioButton)getActivity().findViewById(R.id.ResturantRB);
		radioRest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				changeView(false);
			}
		});
		RadioButton radioHome = (RadioButton)getActivity().findViewById(R.id.HomeRB);
		radioHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				changeView(true);
			}
		});
	}
	
	public void changeView(boolean b)
	{
		if (b) {
			home.setVisibility(View.VISIBLE);
			rest.setVisibility(View.GONE);
		}
		else
		{
			home.setVisibility(View.GONE);
			rest.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	}

	/*
	 * @Override public View onCreateView(LayoutInflater inflater, ViewGroup
	 * container, Bundle savedInstanceState) { // set the layout you want to
	 * display in First Fragment View view = inflater.inflate(R.layout.testfrag,
	 * container, false); return view;
	 * 
	 * }
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception.
		try {
			mCallback = (OnHeadlineSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeadlineSelectedListener");
		}
	}

}

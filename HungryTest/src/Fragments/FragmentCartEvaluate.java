package Fragments;

import java.util.ArrayList;
import java.util.List;

import model.Store;

import com.example.hungrytest.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentCartEvaluate extends Fragment {

	
	View view;
	LayoutInflater layoutInflater;


	@Override
	public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2)
	{
		view=arg0.inflate(R.layout.fragment_cart_evaluate, null);
		layoutInflater=arg0;

	
		return view;
	}
	
	
}

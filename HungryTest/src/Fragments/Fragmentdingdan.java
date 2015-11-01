package Fragments;

import java.util.ArrayList;
import java.util.List;

import model.Store;



import Widget.MarqueeTextView;
import adp.WaimaiPinnedlistadp;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hungrytest.IndexActivity;
import com.example.hungrytest.Login;
import com.example.hungrytest.R;
import com.example.hungrytest.R.color;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

public class Fragmentdingdan extends Fragment {
	
	View view;
	LayoutInflater layoutInflater;
	Button breakfastButton;
	List<View> views=new ArrayList<View>();

	List<Store> Stores=new ArrayList<Store>();
	
	@Override
	public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2)
	{
		view=arg0.inflate(R.layout.fragment_dingdan, null);
		layoutInflater=arg0;

		init();
		addListener();
		
		return view;
	}
	public void init() {
	  
           initFindViewById();
	
	
        
	}
	public void initFindViewById()
	{
		breakfastButton=(Button) view.findViewById(R.id.button_dingdan_breakfast);
	}
	public void addListener() {
		breakfastButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Fragmentdingdan.this.getActivity(),Login.class);
		      
				startActivity(intent);
				Fragmentdingdan.this.getActivity().overridePendingTransition(R.anim.pagetoright, R.anim.pagetoright2);
			}
		});
	}
}

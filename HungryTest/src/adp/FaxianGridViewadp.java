package adp;

import java.util.List;
import java.util.Map;

import com.example.hungrytest.Login;
import com.example.hungrytest.R;
import com.handmark.pulltorefresh.library.internal.Utils;

import adp.FoodLeftadp.ViewHolder;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;

public class FaxianGridViewadp extends BaseAdapter {

	Context context;
	List<Map<String, Object>> lsMaps;
	GridView gView;
	public FaxianGridViewadp(Context context,List<Map<String, Object>> lsMaps,GridView gv) {
		this.context=context;
		this.lsMaps=lsMaps;
		this.gView=gv;
	}
	
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lsMaps.size()+1;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return lsMaps.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		View v=convertView;
		ViewHolder vh;
	
		if(position==(lsMaps.size()))
		{
			Footder footder=new Footder(context);
			Button btnButton=new Button(context);
	        footder.setOrientation(0);
	        int dplayout=55;
	        int dpbutton=40;
            dplayout=MyUtils.DensityUtil.dip2px(context,dplayout);
            dpbutton=MyUtils.DensityUtil.dip2px(context,dpbutton);
	        AbsListView.LayoutParams params1 = new  AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, dplayout);
	       footder.setLayoutParams(params1);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT, dpbutton);
			params.setMargins(100, 0, 0, 0);
		   
		     btnButton.setLayoutParams(params);
         
             btnButton.setText("�������");
             
             btnButton.setBackgroundResource(R.drawable.shap_faxian_gengduohaoli);
            footder.addView(btnButton);

		     return footder;
             
		}
		if(v==null)
		{
	        v=LayoutInflater.from(context).inflate(R.layout.gridview_faxian,null);
	        vh=new ViewHolder();
	        vh.price=(TextView)v.findViewById(R.id.textView_gridview_price);
			vh.note=(TextView)v.findViewById(R.id.textView_gridview_note);
			vh.reward=(Button)v.findViewById(R.id.button_gridview_reward);
			vh.logo=(ImageView)v.findViewById(R.id.imageView_gridview_img);
			vh.footder=(RelativeLayout)v.findViewById(R.id.fooder);
			vh.gengduohaoli=(Button) v.findViewById(R.id.button_gengduohaoli);
			v.setTag(vh);
		}
		else
		{
			vh=(ViewHolder) v.getTag();
		}
	    vh.logo.setImageResource(Integer.parseInt(lsMaps.get(position).get("logo").toString()));
				vh.note.setText(lsMaps.get(position).get("note").toString());
				vh.price.setText(lsMaps.get(position).get("price").toString());
				vh.logo=(ImageView)v.findViewById(R.id.imageView_gridview_img);
				if(lsMaps.get(position).get("isreward").toString().equals("true"))
				{
					vh.reward.setVisibility(View.VISIBLE);
				}
				else {
					vh.reward.setVisibility(View.INVISIBLE);
				}
				Log.d("olod", ""+position);
	
				if(position==(lsMaps.size()))
				{
					v.setLayoutParams(new android.widget.AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			        vh.gengduohaoli.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				    vh.gengduohaoli.setWidth(1900);
			        vh.footder.setVisibility(View.VISIBLE);
			     
				}
				else {

					vh.footder.setVisibility(View.GONE);
				}
				
				
				
				v.setBackgroundResource(R.drawable.shap_gridview);
		return v;
	}
	class Footder extends LinearLayout {
        public Footder(Context context) {
            super(context);
        }
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int targetWidth = gView.getMeasuredWidth()
                    - gView.getPaddingLeft()
                    - gView.getPaddingRight();
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(targetWidth,
                    MeasureSpec.getMode(widthMeasureSpec));
            super.onMeasure(widthMeasureSpec-150, heightMeasureSpec);
        }
    }
	
	
	class ViewHolder
	{
		ImageView logo;

		TextView price;
		Button reward;
		TextView note;
	    RelativeLayout footder;
	    Button gengduohaoli;
		
	}
}

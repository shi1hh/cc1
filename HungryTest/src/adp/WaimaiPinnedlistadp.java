package adp;

import java.util.List;

import model.Store;

import com.example.hungrytest.R;


import Fragments.Fragmentwaimai;
import adp.FoodLeftadp.ViewHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * 外卖页面LISTVIEW数据适配器
 * @author Administrator
 *
 */
public class WaimaiPinnedlistadp extends BaseAdapter  {

	List<Store> lsstore;
	Context context;
	
	/**
	 * 
	 * @param context
	 * @param lsStores 门店数据模型
	 */
	public WaimaiPinnedlistadp(Context context,List<Store> lsStores) {
		super();
		this.lsstore=lsStores;
		this.context=context;
	}
	
	


	class ViewHolder
	{
		ImageView waimaiLogo;
		ImageView iswork;
		TextView restautitle;
		RatingBar ratingBarfavour;
		TextView restauSpeed;
		TextView waimaiMinpay;
		TextView waimaiDispatch;
		
	}




	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lsstore.size();
	}


	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}


	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}


	@Override
	public View getView(int position, View convertView,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		View v=convertView;
		ViewHolder vh;
		Log.d(Fragmentwaimai.LOG_TAG,""+position);
		if(v==null)
		{
	        v=LayoutInflater.from(context).inflate(R.layout.lv_restaurant,null);
	        vh=new ViewHolder();
	        vh.waimaiDispatch=(TextView)v.findViewById(R.id.textView_waimai_dispatch);
			vh.restautitle=(TextView)v.findViewById(R.id.tv_restau_title);
			vh.ratingBarfavour=(RatingBar)v.findViewById(R.id.ratingBar_favour);
			vh.restauSpeed=(TextView)v.findViewById(R.id.tv_restau_speed);
			vh.waimaiLogo=(ImageView)v.findViewById(R.id.imageView_pinnedlist_waimai_logo);
			vh.waimaiMinpay=(TextView)v.findViewById(R.id.textView_waimai_minpay);
			vh.iswork=(ImageView)v.findViewById(R.id.imageview_iswork);
			v.setTag(vh);
		}
		else
		{
			vh=(ViewHolder) v.getTag();
		}
		MyUtils.ImgLoader.LoadURLImg(lsstore.get(position).getLogo().getFileUrl(context), vh.waimaiLogo);
		vh.restautitle.setText(lsstore.get(position).getName());
		vh.restauSpeed.setText(lsstore.get(position).getSpeed());
		vh.waimaiMinpay.setText("￥"+lsstore.get(position).getMinPay());
		vh.ratingBarfavour.setRating(lsstore.get(position).getFavourValue());
	    if(lsstore.get(position).getWorkState()==true)
	    {
	    	vh.restauSpeed.setVisibility(View.VISIBLE);
	    	vh.iswork.setVisibility(View.INVISIBLE);
	    }
	    else {
	    	vh.restauSpeed.setVisibility(View.INVISIBLE);
	    	vh.iswork.setVisibility(View.VISIBLE);
		}
	    if(lsstore.get(position).getDispatch()==0)
	    {
	    	vh.waimaiDispatch.setTextColor(Color.BLACK);
	    	vh.waimaiDispatch.setText("免");
	    }
	    else {
	    	vh.waimaiDispatch.setTextAppearance(context, R.style.waimai_money_text);

			vh.waimaiDispatch.setText("￥"+lsstore.get(position).getDispatch());
		}
			
		return v;
	}
	

}

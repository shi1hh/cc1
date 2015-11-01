package adp;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * ������Viewpager����������
 * @author Administrator
 *
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter
{
	List<Fragment> lsFragments;

	public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> lsFragments)
	{
		super(fm);
		this.lsFragments=lsFragments;
	}
	
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return lsFragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lsFragments.size();
	}
	@Override
	public int getItemPosition(Object arg0)
	{
		return super.getItemPosition(arg0);
	}
}
	
	
	
	


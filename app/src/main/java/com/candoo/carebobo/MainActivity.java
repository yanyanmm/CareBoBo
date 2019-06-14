package com.candoo.carebobo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.candoo.carebobo.activity.BaseActivity;
import com.candoo.carebobo.activity.fragment.CircleFragment;
import com.candoo.carebobo.activity.fragment.HomeFragment;
import com.lihg.library.tabbarlayout.YBadgeView;
import com.lihg.library.tabbarlayout.YTabbarItem;
import com.lihg.library.tabbarlayout.YTabbarItemView;
import com.lihg.library.tabbarlayout.YTabbarLayout;
import com.lihg.library.toolbar.YToolBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    YToolBar mToolBar;

    @BindView(R.id.tabbarLayout)
    YTabbarLayout mTabbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定初始化ButterKnife
        ButterKnife.bind(this);

        //设置顶部工具导航
        this.setupToolBar();

        //设置菜单菜单导航
        this.setupTabbar();
    }

    /**
     * 设置顶部工具导航
     */
    private void setupToolBar() {
        mToolBar.addRightViewWithImage(R.mipmap.btn_switch, new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击我了", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 设置底部菜单导航
     */
    private void setupTabbar() {
        List<YTabbarItem> tabbarItems = new ArrayList<YTabbarItem>();
        tabbarItems.add(YTabbarItem.createItem(R.mipmap.menu_home, R.string.menu_home, new HomeFragment()));
        tabbarItems.add(YTabbarItem.createItem(R.mipmap.menu_circle, R.string.menu_circle, new CircleFragment()));
        tabbarItems.add(YTabbarItem.createItem(R.mipmap.menu_msg, R.string.menu_msg,null));
        tabbarItems.add(YTabbarItem.createItem(R.mipmap.menu_my, R.string.menu_my,null));
        mTabbarLayout.setTabbarItems(tabbarItems, getSupportFragmentManager());
        mTabbarLayout.setOnTabbarItemClickListener(mTabbarListener);
        List<YTabbarItemView> tabbarItemViews = mTabbarLayout.getTabbarItemViews();
        if (tabbarItemViews.size() > 3) {
            ImageView imageView = tabbarItemViews.get(2).getImageView();
            if (imageView != null) {
                YBadgeView badgeView = new YBadgeView(this);
                badgeView.setTargetView(imageView);
            }
        }
    }

    private YTabbarLayout.OnTabbarItemClickListener mTabbarListener = new YTabbarLayout.OnTabbarItemClickListener() {
        @Override
        public void onClickItem(View v) {
            mToolBar.getTitleView().setText(((YTabbarItemView)v).getTextView().getText());
        }

        @Override
        public void onClickCenterItem(View v) {

        }
    };
}

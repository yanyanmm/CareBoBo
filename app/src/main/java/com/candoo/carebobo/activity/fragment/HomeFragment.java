package com.candoo.carebobo.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.candoo.carebobo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.banner)
    Banner mBanner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //绑定初始化ButterKnife
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //设置广告控件
        this.setupBanner();
    }

    /**
     * 设置广告控件
     */
    private void setupBanner() {
        List<String> images = new ArrayList<String>();
        images.add("http://img1.imgtn.bdimg.com/it/u=267257130,1949808613&fm=26&gp=0.jpg");
        images.add("http://img1.imgtn.bdimg.com/it/u=1767235641,3039452276&fm=26&gp=0.jpg");
        images.add("http://img3.imgtn.bdimg.com/it/u=3341920966,1839838281&fm=26&gp=0.jpg");
        images.add("http://img1.imgtn.bdimg.com/it/u=1785979113,1375631776&fm=26&gp=0.jpg");
        images.add("http://img1.imgtn.bdimg.com/it/u=2454308617,1525549680&fm=11&gp=0.jpg");
        images.add("http://img3.imgtn.bdimg.com/it/u=2330652651,3358823902&fm=26&gp=0.jpg");
        images.add("http://img3.imgtn.bdimg.com/it/u=3639309787,3677423088&fm=11&gp=0.jpg");
        mBanner.setImages(images);
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                //Glide 加载图片简单用法
                Glide.with(context).load(path).into(imageView);
            }
        });
        mBanner.setBannerAnimation(Transformer.CubeOut);
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mBanner.start();
    }

    @Override
    public void onStart() {
        super.onStart();

        //开始轮播
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();

        //结束轮播
        mBanner.stopAutoPlay();
    }
}

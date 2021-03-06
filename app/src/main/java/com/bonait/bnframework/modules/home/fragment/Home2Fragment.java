package com.bonait.bnframework.modules.home.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.bonait.bnframework.R;
import com.bonait.bnframework.common.base.BaseFragment;
import com.bonait.bnframework.common.base.Item;
import com.bonait.bnframework.common.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home2Fragment extends BaseFragment {


@BindView(R.id.grid)
GridView grid;
@BindView(R.id.topbar)
QMUITopBarLayout mTopBar;
@BindView(R.id.floating_search_view)
FloatingSearchView   mSearchView;

    public Home2Fragment() {
    }

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home2, null);
        ButterKnife.bind(this, root);
        grid.setOnItemClickListener(mOnItemClickListener);
        GridAdapter adapter = new GridAdapter();
        grid.setAdapter(adapter);

        //search bar
        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {

                //get suggestions based on newQuery

                //pass them on to the search view
               // mSearchView.swapSuggestions(newSuggestions);
            }
        });

        return root;
    }




    private final AdapterView.OnItemClickListener mOnItemClickListener
            = new AdapterView.OnItemClickListener() {

        /**
         * Called when an item in the {@link android.widget.GridView} is clicked
         */
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Item item = (Item) adapterView.getItemAtPosition(position);

//            // Construct an Intent as normal
//            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//            intent.putExtra(DetailActivity.EXTRA_PARAM_ID, item.getId());
//
//            // BEGIN_INCLUDE(start_activity)
//            /*
//             * Now create an {@link android.app.ActivityOptions} instance using the
//             * {@link ActivityOptionsCompat#makeSceneTransitionAnimation(Activity, Pair[])} factory
//             * method.
//             */
//            @SuppressWarnings("unchecked")
//            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                    MainActivity.this,
//
//                    // Now we provide a list of Pair items which contain the view we can transitioning
//                    // from, and the name of the view it is transitioning to, in the launched activity
//                    new Pair<>(view.findViewById(R.id.imageview_item),
//                            DetailActivity.VIEW_NAME_HEADER_IMAGE),
//                    new Pair<>(view.findViewById(R.id.textview_name),
//                            DetailActivity.VIEW_NAME_HEADER_TITLE));
//
//            // Now we can start the Activity, providing the activity options as a bundle
//            ActivityCompat.startActivity(MainActivity.this, intent, activityOptions.toBundle());
            // END_INCLUDE(start_activity)
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.d("???????????????");
        initTopBar();
    }

    private void initTopBar() {
        mTopBar.setTitle("?????????");
    }
    /**
     * {@link android.widget.BaseAdapter} which displays items.
     */
    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Item.ITEMS.length;
        }

        @Override
        public Item getItem(int position) {
            return Item.ITEMS[position];
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).getId();
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.grid_item, viewGroup, false);
            }

            final Item item = getItem(position);

            QMUILinearLayout layout = view.findViewById(R.id.view_layout);
            layout.setShadowColor( 0x779974);
            layout.setShadowAlpha(0.2f);
            layout.setRadiusAndShadow(QMUIDisplayHelper.dp2px(getContext(), 30),
                    QMUIDisplayHelper.dp2px(getContext(), 30),
                    0.25f);

            // Load the thumbnail image
            ImageView image = view.findViewById(R.id.imageview_item);
            Picasso.with(image.getContext()).load(item.getPhotoUrl()).into(image);

            // Set the TextView's contents
            TextView name = view.findViewById(R.id.textview_name);
            name.setText(item.getName());

            return view;
        }

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d("???????????????");
    }

    /**
     * ??????activity??????viewPager + BottomNavigation + fragment??????
     * ?????????viewPager???????????????????????????fragment???????????????????????????????????????????????????
     * ??????????????????????????????fragment???????????????????????????
     *
     * ?????????????????????????????????????????????
     *
     * ??????fragment??????viewPager + BottomNavigation + fragment????????????????????????????????????
     * */
    @Override
    protected boolean canDragBack() {
        return false;
    }
}

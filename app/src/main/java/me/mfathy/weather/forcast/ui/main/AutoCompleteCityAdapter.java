package me.mfathy.weather.forcast.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import me.mfathy.weather.forcast.R;
import me.mfathy.weather.forcast.domain.model.City;

import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class AutoCompleteCityAdapter extends ArrayAdapter<City> {

    private Context mContext;
    private int layoutResourceId;
    private List<City> data;
    private final LayoutInflater mInflater;

    public AutoCompleteCityAdapter(Context mContext, int layoutResourceId, List<City> data) {

        super(mContext, layoutResourceId, data);


        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        this.data = data;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(layoutResourceId, parent, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);


        City city = data.get(position);

        textView.setText(city.getLocalizedName());

        return view;
    }

    @Override
    public City getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}

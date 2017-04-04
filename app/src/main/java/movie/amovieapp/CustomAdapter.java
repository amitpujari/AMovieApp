package movie.amovieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ashu on 12/08/15.
 */
public class CustomAdapter extends BaseAdapter {
    private List<Response.MoviesEntity> mMovieitem;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext, List<Response.MoviesEntity> mMovieitem) {
        this.mContext = mContext;
        this.mMovieitem = mMovieitem;
    }

    @Override
    public int getCount() {
        return mMovieitem.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.each_list_item, parent, false);
        Response.MoviesEntity item = (Response.MoviesEntity) getItem(position);
        ImageView thumbnail = (ImageView) rowView.findViewById(R.id.thumbnail);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView rating = (TextView) rowView.findViewById(R.id.rating);
        String imageUrl = item.getPosters().getOriginal();
        Picasso.with(mContext).load(imageUrl).into(thumbnail);
        title.setText(item.getTitle());
        rating.setText(item.getRatings().getAudience_rating());
        return rowView;
    }
}
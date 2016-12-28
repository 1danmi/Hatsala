package a1221.org.il.hatsalaquestionaire.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import a1221.org.il.hatsalaquestionaire.Entities.Answer;
import a1221.org.il.hatsalaquestionaire.R;

public class LanguageRecyclerAdapter extends RecyclerView.Adapter<LanguageRecyclerAdapter.LanguageViewHolder> {
    private static final String TAG = "LanguageRecyclerAdapter";
    private List<String> languages;
    private Context mContext;


    public LanguageRecyclerAdapter(Context mContext, ArrayList<String> languages) {
        this.languages = languages;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((languages != null) && (languages.size() != 0) ? languages.size() : 0);

    }

    @Override
    public void onBindViewHolder(final LanguageViewHolder holder, int position) {
        // Called by the layout manager when it wants new data in an existing row


        Log.d(TAG, "onBindViewHolder: " + languages.get(position) + " --> " + position);
        holder.title.setText(languages.get(position));


    }

    public void addItem(String language) {
        languages.add(language);
        notifyItemInserted(languages.size());
    }

    public void removeItem(int position) {
        languages.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public LanguageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called by the layout manager when it needs a new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_item, parent, false);
        return new LanguageViewHolder(view);
    }


    public void loadNewData(List<String> newLanguages) {
        this.languages = newLanguages;
        notifyDataSetChanged();
    }


    public String getLanguage(int position) {
        return ((languages != null) && (languages.size() != 0) ? languages.get(position) : null);
    }


    static class LanguageViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "LanguageViewHolder";
        CardView cardItemLayout;
        TextView title;

        public LanguageViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "LanguageViewHolder: starts");
            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.listitem_name);
        }
    }
}

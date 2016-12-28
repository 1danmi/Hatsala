package a1221.org.il.hatsalaquestionaire.adapters;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

import a1221.org.il.hatsalaquestionaire.R;
import a1221.org.il.hatsalaquestionaire.entities.Category;

/**
 * Created by Daniel on 12/28/2016.
 */

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ListViewHolder> {
    private static final String TAG = "CategoryRecyclerViewAda";
    private final Comparator<Category> mComparator;
    private Context mContext;
    SortedList<Category> categories = new SortedList<>(Category.class, new SortedList.Callback<Category>() {

        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count) {
            notifyItemRangeChanged(position, count);
        }

        @Override
        public int compare(Category a, Category b) {
            return mComparator.compare(a,b);
        }

        @Override
        public boolean areContentsTheSame(Category oldItem, Category newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areItemsTheSame(Category item1, Category item2) {
            return item1.get_ID() == item2.get_ID();
        }
    });

    public CategoryRecyclerViewAdapter(Context mContext, Comparator<Category> mComparator) {
        this.mComparator = mComparator;
        //this.categories = categories;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((categories != null) && (categories.size() != 0) ? categories.size() : 0);

    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, int position) {
        // Called by the layout manager when it wants new data in an existing row


        Log.d(TAG, "onBindViewHolder: " + categories.get(position).getName() + " --> " + position);
        holder.title.setText(categories.get(position).getName());


    }

    public void addItem(Category category) {
        categories.add(category);
        notifyItemInserted(categories.size());
    }

    public void removeItem(int position) {
        categories.remove(categories.get(position));
        notifyItemRemoved(position);
    }




    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called by the layout manager when it needs a new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_item, parent, false);
        return new ListViewHolder(view);
    }



    public Category getLanguage(int position) {
        return ((categories != null) && (categories.size() != 0) ? categories.get(position) : null);
    }


    static class ListViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ListViewHolder";
        CardView cardItemLayout;
        TextView title;

        public ListViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "ListViewHolder: starts");
            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.listitem_name);
        }
    }

    public void add(Category model) {
        categories.add(model);
    }

    public void remove(Category model) {
        categories.remove(model);
    }

    public void add(List<Category> models) {
        categories.addAll(models);
    }

    public void remove(List<Category> models) {
        categories.beginBatchedUpdates();
        for (Category  model : models) {
            categories.remove(model);
        }
        categories.endBatchedUpdates();
    }

    public void addList(List<Category> models) {
        categories.addAll(models);
    }

    public void replaceAll(List<Category> models) {
        categories.beginBatchedUpdates();
        for (int i = categories.size() - 1; i >= 0; i--) {
            final Category model = categories.get(i);
            if (!models.contains(model)) {
                categories.remove(model);
            }
        }
        categories.addAll(models);
        categories.endBatchedUpdates();
    }
}


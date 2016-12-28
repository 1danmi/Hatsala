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
import a1221.org.il.hatsalaquestionaire.entities.Question;

/**
 * Created by Daniel on 12/28/2016.
 */

public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<QuestionRecyclerViewAdapter.ListViewHolder> {
    private static final String TAG = "QuestionRecyclerViewAda";
    private final Comparator<Question> mComparator;
    private Context mContext;
    SortedList<Question> questions = new SortedList<>(Question.class, new SortedList.Callback<Question>() {

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
        public int compare(Question a, Question b) {
            return mComparator.compare(a,b);
        }

        @Override
        public boolean areContentsTheSame(Question oldItem, Question newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }

        @Override
        public boolean areItemsTheSame(Question item1, Question item2) {
            return item1.get_ID() == item2.get_ID();
        }
    });

    public QuestionRecyclerViewAdapter(Context mContext, Comparator<Question> mComparator) {
        this.mComparator = mComparator;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((questions != null) && (questions.size() != 0) ? questions.size() : 0);

    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, int position) {
        // Called by the layout manager when it wants new data in an existing row


        Log.d(TAG, "onBindViewHolder: " + questions.get(position).getTitle() + " --> " + position);
        holder.title.setText(questions.get(position).getTitle());


    }

    public void addItem(Question question) {
        questions.add(question);
        notifyItemInserted(questions.size());
    }

    public void removeItem(int position) {
        questions.remove(questions.get(position));
        notifyItemRemoved(position);
    }




    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called by the layout manager when it needs a new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_item, parent, false);
        return new ListViewHolder(view);
    }



    public Question getQuestion(int position) {
        return ((questions != null) && (questions.size() != 0) ? questions.get(position) : null);
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

    public void add(Question model) {
        questions.add(model);
    }

    public void remove(Question model) {
        questions.remove(model);
    }

    public void add(List<Question> models) {
        questions.addAll(models);
    }

    public void remove(List<Question> models) {
        questions.beginBatchedUpdates();
        for (Question  model : models) {
            questions.remove(model);
        }
        questions.endBatchedUpdates();
    }

    public void addList(List<Question> models) {
        questions.addAll(models);
    }

    public void replaceAll(List<Question> models) {
        questions.beginBatchedUpdates();
        for (int i = questions.size() - 1; i >= 0; i--) {
            final Question model = questions.get(i);
            if (!models.contains(model)) {
                questions.remove(model);
            }
        }
        questions.addAll(models);
        questions.endBatchedUpdates();
    }
}


package a1221.org.il.hatsalaquestionaire.adapters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import a1221.org.il.hatsalaquestionaire.entities.UIAnswer;
import a1221.org.il.hatsalaquestionaire.R;

/**
 * Created by Arele-PC on 12/28/2016.
 */

public class AnswersRecyclerAdapter extends  RecyclerView.Adapter<AnswersRecyclerAdapter.AnswerViewHolder> {

    private List<UIAnswer> UIAnswers= null;
    private Context mContext;
    private static final String TAG = "AnswerRecyclerAdapter";
    TextToSpeech ttobj;
    public boolean isscale = false;
    public AnswersRecyclerAdapter(Context mcontext, List<UIAnswer> hebans){
        mContext= mcontext;
        if(hebans != null){UIAnswers = hebans;}
    }

    @Override
    public AnswersRecyclerAdapter.AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_layout, parent, false);
        return new AnswersRecyclerAdapter.AnswerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(AnswersRecyclerAdapter.AnswerViewHolder holder, int position) {
        if(UIAnswers!=null){  holder.hebtext.setText(UIAnswers.get(position).getaHebrew());
            holder.transtext.setText(UIAnswers.get(position).getaTranslation());}


    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((UIAnswers != null) && (UIAnswers.size() != 0) ? UIAnswers.size() : 0);
    }
    static class AnswerViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "AnswerViewHolder";
        CardView cardItemLayout;
        TextView hebtext;
        TextView transtext;
        ImageButton hebspeech;
        ImageButton transspeech;
        TextToSpeech ttsobjEn;

        public AnswerViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "AnswerViewHolder: starts");
            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item_ans);
            hebtext = (TextView) itemView.findViewById(R.id.textView_heb_ans);
            transtext = (TextView) itemView.findViewById(R.id.textView_trans_ans);
            hebspeech = (ImageButton)  itemView.findViewById(R.id.imageButton_heb);
            transspeech= (ImageButton)  itemView.findViewById(R.id.imageButton_trans);
            transspeech.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    speak();
                }
            });
            ttsobjEn=new TextToSpeech(itemView.getContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status != TextToSpeech.ERROR) {
                        ttsobjEn.setLanguage(Locale.UK);//getselectedlanguage()
                    }
                }
            });
            hebtext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.setBackgroundColor(v.getResources().getColor(R.color.green));
                }
            });

        }
        private void speak(){
            String toSpeak = hebtext.getText().toString();
            ttsobjEn.speak(toSpeak, TextToSpeech.QUEUE_ADD, null);
        }
    }
}

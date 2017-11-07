package ru.hh.headhunterclient.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.domain.entity.vacancies.main.Vacancy;

/**
 * Created by neox on 12/9/17.
 * Адаптер списка вакансий
 */
public class VacancyListAdapter extends RecyclerView.Adapter<VacancyListViewHolder> {

    private VacancyListActivity.OnItemSelectedListener mItemSelectedListener;
    private List<Vacancy> mList;
    private Context mContext;

    public VacancyListAdapter(Context context, VacancyListActivity.OnItemSelectedListener itemSelectedListener) {
        mContext = context;
        mItemSelectedListener = itemSelectedListener;
        mList = new ArrayList<>();
    }

    @Override
    public VacancyListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_vacancy_list, parent, false);
        return new VacancyListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VacancyListViewHolder holder, int position) {
        holder.bind(mList.get(position), mItemSelectedListener);
    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        }
        return mList.size();
    }

    public void setList(List<Vacancy> list) {
        this.mList = list;
        this.notifyDataSetChanged();
    }
}

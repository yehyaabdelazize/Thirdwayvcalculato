package com.yahya.thirdwayvcalculator.ui.maincalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yahya.thirdwayvcalculator.R;
import com.yahya.thirdwayvcalculator.pojo.models.OperationModel;

import java.util.List;

/**
 * The type Calcu adapter.
 */
public class CalcuAdapter extends RecyclerView.Adapter<CalcuAdapter.ViewHolder> {

    private Context context;
    private List<OperationModel> operations;

    /**
     * Instantiates a new Calcu adapter.
     *
     * @param context         the context
     * @param operationModels the operation models
     */
    public CalcuAdapter(Context context, List<OperationModel> operationModels) {
        this.context = context;
        this.operations = operationModels;
    }


    /**
     * The type View holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The Operation.
         */
        TextView operation;

        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        public ViewHolder(View itemView) {
            super(itemView);
            operation = itemView.findViewById(R.id.tv_rec_operation_item);
        }
    }

    @Override
    public CalcuAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_operation_rec, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CalcuAdapter.ViewHolder viewHolder, int i) {
        viewHolder.operation.setText(operations.get(i).getSign() + operations.get(i).getOperation());

    }

    @Override
    public int getItemCount() {
        return operations.size();
    }
}


package personal.app.material_design_guia4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import personal.app.material_design_guia4.R;
import personal.app.material_design_guia4.model.EmployeeModel;
import personal.app.material_design_guia4.viewHolders.EmployeesListViewHolder;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesListViewHolder> {

    List<EmployeeModel> lstEmployees;

    public EmployeesAdapter(List<EmployeeModel> lstEmployees) {
        this.lstEmployees = lstEmployees;
    }

    @NonNull
    @Override
    public EmployeesListViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_employees, parent, false);
        return new EmployeesListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  EmployeesListViewHolder holder, int position) {
        holder.getImgAvatar().setImageResource(lstEmployees.get(position).getImgEmployee());
        holder.getTvName().setText(lstEmployees.get(position).getName());
        holder.getTvLastName().setText(lstEmployees.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return this.lstEmployees.size();
    }
}

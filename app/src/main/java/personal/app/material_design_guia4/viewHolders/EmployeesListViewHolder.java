package personal.app.material_design_guia4.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import personal.app.material_design_guia4.R;

public class EmployeesListViewHolder extends RecyclerView.ViewHolder {

    ImageView imgAvatar;
    TextView tvName, tvLastName;


    public EmployeesListViewHolder(@NonNull  View itemView) {
        super(itemView);

        imgAvatar = (ImageView)  itemView.findViewById(R.id.ivAvatar) ;
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvLastName = (TextView) itemView.findViewById(R.id.tvLastName);
    }

    public ImageView getImgAvatar() {
        return imgAvatar;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvLastName() {
        return tvLastName;
    }
}

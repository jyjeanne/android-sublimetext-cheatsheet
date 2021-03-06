package fr.joeybronner.sublimetextcheatsheetapp.cards;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.joeybronner.sublimetextcheatsheetapp.R;
import fr.joeybronner.sublimetextcheatsheetapp.interfaces.OnCommandClickListener;
import fr.joeybronner.sublimetextcheatsheetapp.interfaces.OnShareClickListener;
import fr.joeybronner.sublimetextcheatsheetapp.objects.Command;

public class CommandsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;
    private TextView tvCommand;
    public ImageView btShare;

    // itemView is the view for one cell
    public CommandsViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvCommandTitle);
        tvCommand = (TextView) itemView.findViewById(R.id.tvCommand);
        btShare = (ImageView) itemView.findViewById(R.id.btShare);
    }

    // Set the values/images to the object
    public void bind(final Command command, final OnCommandClickListener listener, final OnShareClickListener listenerShare){
        tvTitle.setText(command.getTxtTitle());
        tvCommand.setText(command.getTxtCommand());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                listener.onItemClick(command);
            }
        });
        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                listenerShare.onItemClick(command.getTxtTitle(), command.getTxtCommand());
            }
        });
    }
}
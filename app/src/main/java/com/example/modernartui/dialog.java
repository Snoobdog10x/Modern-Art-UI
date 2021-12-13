package com.example.modernartui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class dialog {
    public void showDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.fragment_dialog);

        Button dialogButton = (Button) dialog.findViewById(R.id.okbutton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL = "https://www.moma.org";
                Intent momaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                activity.startActivity(momaIntent);
            }
        });
        Button canclebutton = (Button) dialog.findViewById(R.id.exitbutton);
        canclebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}

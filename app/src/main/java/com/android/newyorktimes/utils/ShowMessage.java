package com.android.newyorktimes.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class ShowMessage {

    public static void showDialog(Context context, String title, String message, String btnText, Boolean cancelable) {
        final AlertDialog.Builder adb = new AlertDialog.Builder(context);
        adb.setTitle(title)
                .setCancelable(cancelable)
                .setMessage(message)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }
}
